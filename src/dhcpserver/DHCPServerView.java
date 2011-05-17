/*
 * DHCPServerView.java
 */

package dhcpserver;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

/**
 * The application's main frame.
 */
public class DHCPServerView extends FrameView {

    public DHCPServerView(SingleFrameApplication app) {
        super(app);

        initComponents();

        DHCPDatabase.logModel.addColumn("Request");
        DHCPDatabase.logModel.addColumn("Response");
        DHCPDatabase.logModel.addColumn("Client Add.");
        DHCPDatabase.logModel.addColumn("IP (offered/requested)");

        ipTable.setModel(DHCPDatabase.model);
        logTable.setModel(DHCPDatabase.logModel);
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = DHCPServerApp.getApplication().getMainFrame();
            aboutBox = new DHCPServerAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        DHCPServerApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ipTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        logTable = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        mainPanel.setName("mainPanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        ipTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client Address", "IP Address", "Verified At"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ipTable.setName("dbTable"); // NOI18N
        jScrollPane1.setViewportView(ipTable);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dhcpserver.DHCPServerApp.class).getContext().getResourceMap(DHCPServerView.class);
        ipTable.getColumnModel().getColumn(0).setResizable(false);
        ipTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("dbTable.columnModel.title0")); // NOI18N
        ipTable.getColumnModel().getColumn(1).setResizable(false);
        ipTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("dbTable.columnModel.title1")); // NOI18N
        ipTable.getColumnModel().getColumn(2).setResizable(false);
        ipTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("dbTable.columnModel.title2")); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        logTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request", "Response", "Client Address", "IP (requested/offered)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        logTable.setName("logTable"); // NOI18N
        jScrollPane2.setViewportView(logTable);
        logTable.getColumnModel().getColumn(0).setResizable(false);
        logTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("logTable.columnModel.title2")); // NOI18N
        logTable.getColumnModel().getColumn(1).setResizable(false);
        logTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("logTable.columnModel.title3")); // NOI18N
        logTable.getColumnModel().getColumn(2).setResizable(false);
        logTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("logTable.columnModel.title0")); // NOI18N
        logTable.getColumnModel().getColumn(3).setResizable(false);
        logTable.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("logTable.columnModel.title1")); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                .addContainerGap())
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(dhcpserver.DHCPServerApp.class).getContext().getActionMap(DHCPServerView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ipTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable logTable;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

    private JDialog aboutBox;
}
