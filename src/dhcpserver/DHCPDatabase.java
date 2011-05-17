package dhcpserver;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class DHCPDatabase extends AbstractTableModel {

    public static DefaultTableModel logModel = new DefaultTableModel();


    public static DHCPDatabase model = new DHCPDatabase();

    private String[] columnNames = {"Client Address", "IP Address", "Acked Time"};
    static ArrayList<DHCPRecord> data = new ArrayList<DHCPRecord>();

    // TODO indexed search of mac address
    public static DHCPRecord getRecord(byte[] mac)
    {
        int i = 0;
        Iterator<DHCPRecord> itr = data.iterator();
        while (itr.hasNext())
        {
            DHCPRecord record = itr.next();

            for (i = 0; i < 6; i++)
                if (record.chaddr[i] != mac[i])
                    break;
            if (i == 6)
                return record;
        }
        return null;
    }

    // TODO indexed search of Ip address
    public static boolean freeIp(byte[] ip)
    {
        int i = 0;
        Iterator<DHCPRecord> itr = data.iterator();
        while (itr.hasNext())
        {
            DHCPRecord record = itr.next();

            for (i = 0; i < 4; i++)
                if (record.ip[i] != ip[i])
                    break;
            if (i == 4)
            {
                int secondDiffs = (int)((record.ackTime.getTime() - (new Date()).getTime())/1000);
                if (secondDiffs < 24 * 3600)
                {
                    data.remove(record);
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    // global functions

    static String formatMAC(byte[] mac)
    {
        return String.format("%2s:%2s:%2s:%2s:%2s:%2s", Integer.toHexString(DHCPController.byteToInt(mac[0])), Integer.toHexString(DHCPController.byteToInt(mac[1])), Integer.toHexString(DHCPController.byteToInt(mac[2])), Integer.toHexString(DHCPController.byteToInt(mac[3])), Integer.toHexString(DHCPController.byteToInt(mac[4])), Integer.toHexString(DHCPController.byteToInt(mac[5]))).replace(" ", "0");
    }

    static String formatIp(byte[] ip)
    {
        return String.format("%d.%d.%d.%d", DHCPController.byteToInt(ip[0]), DHCPController.byteToInt(ip[1]), DHCPController.byteToInt(ip[2]), DHCPController.byteToInt(ip[3]));
    }

    // model functions
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {

        DHCPRecord record = data.get(row);
        switch (col)
        {
            case 0:
                return formatMAC(record.chaddr);
            case 1:
                return formatIp(record.ip);
            case 2:
                if (record.ackTime != null)
                    return record.ackTime.toString();
        }

        return null;
    }

    public Class getColumnClass(int c) {
        return ("").getClass();
    }
}
