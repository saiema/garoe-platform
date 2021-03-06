/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WaterJarsGUI.java
 *
 * Created on 19-dic-2011, 18:31:55
 */
package example_waterjars;

import java.awt.Color;
import java.awt.event.ActionListener;

/**
 *
 * @author BigEma
 */
public class WaterJarsGUI extends javax.swing.JFrame implements ActionListener {
    private WaterJarsMainController mainController;
    
    /** Creates new form WaterJarsGUI */
    public WaterJarsGUI() {
        initComponents();
    }
    
    public void setMainController(WaterJarsMainController mainController) {
        this.mainController = mainController;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jar1Panel = new javax.swing.JPanel();
        jar1Capacity = new javax.swing.JLabel();
        jar1Ocuppied = new javax.swing.JLabel();
        jar1FillButton = new javax.swing.JButton();
        jar1EmptyButton = new javax.swing.JButton();
        jar1TransferButton = new javax.swing.JButton();
        jar2Panel = new javax.swing.JPanel();
        jar2Capacity = new javax.swing.JLabel();
        jar2Ocuppied = new javax.swing.JLabel();
        jar2FillButton = new javax.swing.JButton();
        jar2EmptyButton = new javax.swing.JButton();
        jar2TransferButton = new javax.swing.JButton();
        success = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        preferencesMenu = new javax.swing.JMenu();
        estadoInicialMenuItem = new javax.swing.JMenuItem();
        iaMenuItem = new javax.swing.JMenuItem();
        iaMenu = new javax.swing.JMenu();
        clueMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(420, 350));
        setResizable(false);

        jar1Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Jarra 1"));
        jar1Panel.setMaximumSize(new java.awt.Dimension(200, 300));
        jar1Panel.setMinimumSize(new java.awt.Dimension(200, 300));
        jar1Panel.setPreferredSize(new java.awt.Dimension(200, 300));

        jar1Capacity.setText("capacidad: ");

        jar1Ocuppied.setText("ocupado: ");

        jar1FillButton.setText("llenar");
        jar1FillButton.addActionListener(this);

        jar1EmptyButton.setText("vaciar");
        jar1EmptyButton.addActionListener(this);

        jar1TransferButton.setText("transferir");
        jar1TransferButton.addActionListener(this);

        javax.swing.GroupLayout jar1PanelLayout = new javax.swing.GroupLayout(jar1Panel);
        jar1Panel.setLayout(jar1PanelLayout);
        jar1PanelLayout.setHorizontalGroup(
            jar1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jar1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jar1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jar1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jar1Capacity)
                        .addComponent(jar1TransferButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jar1EmptyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jar1FillButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jar1Ocuppied))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jar1PanelLayout.setVerticalGroup(
            jar1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jar1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jar1Capacity)
                .addGap(18, 18, 18)
                .addComponent(jar1Ocuppied)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jar1TransferButton)
                .addGap(18, 18, 18)
                .addComponent(jar1EmptyButton)
                .addGap(18, 18, 18)
                .addComponent(jar1FillButton)
                .addContainerGap())
        );

        jar2Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Jarra 2"));
        jar2Panel.setMaximumSize(new java.awt.Dimension(200, 300));
        jar2Panel.setMinimumSize(new java.awt.Dimension(200, 300));
        jar2Panel.setPreferredSize(new java.awt.Dimension(200, 300));

        jar2Capacity.setText("capacidad: ");

        jar2Ocuppied.setText("ocupado: ");

        jar2FillButton.setText("llenar");
        jar2FillButton.addActionListener(this);

        jar2EmptyButton.setText("vaciar");
        jar2EmptyButton.addActionListener(this);

        jar2TransferButton.setText("transferir");
        jar2TransferButton.addActionListener(this);

        javax.swing.GroupLayout jar2PanelLayout = new javax.swing.GroupLayout(jar2Panel);
        jar2Panel.setLayout(jar2PanelLayout);
        jar2PanelLayout.setHorizontalGroup(
            jar2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jar2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jar2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jar2Capacity)
                    .addComponent(jar2Ocuppied))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jar2PanelLayout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addGroup(jar2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jar2FillButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jar2EmptyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jar2TransferButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jar2PanelLayout.setVerticalGroup(
            jar2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jar2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jar2Capacity)
                .addGap(18, 18, 18)
                .addComponent(jar2Ocuppied)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jar2TransferButton)
                .addGap(18, 18, 18)
                .addComponent(jar2EmptyButton)
                .addGap(18, 18, 18)
                .addComponent(jar2FillButton)
                .addContainerGap())
        );

        success.setBackground(new java.awt.Color(255, 51, 51));
        success.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        success.setText("EXITO!");
        success.setEnabled(false);
        success.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        success.setOpaque(true);

        fileMenu.setMnemonic('j');
        fileMenu.setText("Jarras");

        newMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMenuItem.setMnemonic('n');
        newMenuItem.setText("Reiniciar");
        newMenuItem.addActionListener(this);
        fileMenu.add(newMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setMnemonic('s');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(this);
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        preferencesMenu.setMnemonic('p');
        preferencesMenu.setText("Preferencias");

        estadoInicialMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        estadoInicialMenuItem.setMnemonic('e');
        estadoInicialMenuItem.setText("Estado problema");
        estadoInicialMenuItem.addActionListener(this);
        preferencesMenu.add(estadoInicialMenuItem);

        iaMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        iaMenuItem.setMnemonic('f');
        iaMenuItem.setText("Preferencias IA");
        iaMenuItem.addActionListener(this);
        preferencesMenu.add(iaMenuItem);

        menuBar.add(preferencesMenu);

        iaMenu.setMnemonic('i');
        iaMenu.setText("IA");

        clueMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        clueMenuItem.setMnemonic('p');
        clueMenuItem.setText("Pista");
        clueMenuItem.addActionListener(this);
        iaMenu.add(clueMenuItem);

        menuBar.add(iaMenu);

        helpMenu.setMnemonic('a');
        helpMenu.setText("Ayuda");

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Acerca de");
        aboutMenuItem.addActionListener(this);
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jar1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jar2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
            .addComponent(success, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jar2Panel, javax.swing.GroupLayout.Alignment.LEADING, 0, 264, Short.MAX_VALUE)
                    .addComponent(jar1Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(success, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == jar1FillButton) {
            WaterJarsGUI.this.jar1FillButtonActionPerformed(evt);
        }
        else if (evt.getSource() == jar1EmptyButton) {
            WaterJarsGUI.this.jar1EmptyButtonActionPerformed(evt);
        }
        else if (evt.getSource() == jar1TransferButton) {
            WaterJarsGUI.this.jar1TransferButtonActionPerformed(evt);
        }
        else if (evt.getSource() == jar2FillButton) {
            WaterJarsGUI.this.jar2FillButtonActionPerformed(evt);
        }
        else if (evt.getSource() == jar2EmptyButton) {
            WaterJarsGUI.this.jar2EmptyButtonActionPerformed(evt);
        }
        else if (evt.getSource() == jar2TransferButton) {
            WaterJarsGUI.this.jar2TransferButtonActionPerformed(evt);
        }
        else if (evt.getSource() == newMenuItem) {
            WaterJarsGUI.this.newMenuItemActionPerformed(evt);
        }
        else if (evt.getSource() == exitMenuItem) {
            WaterJarsGUI.this.exitMenuItemActionPerformed(evt);
        }
        else if (evt.getSource() == estadoInicialMenuItem) {
            WaterJarsGUI.this.estadoInicialMenuItemActionPerformed(evt);
        }
        else if (evt.getSource() == iaMenuItem) {
            WaterJarsGUI.this.iaMenuItemActionPerformed(evt);
        }
        else if (evt.getSource() == clueMenuItem) {
            WaterJarsGUI.this.clueMenuItemActionPerformed(evt);
        }
        else if (evt.getSource() == aboutMenuItem) {
            WaterJarsGUI.this.aboutMenuItemActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        this.mainController.exit();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jar1TransferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jar1TransferButtonActionPerformed
        this.mainController.transferToJar2();
        if (isHintMarked()) this.mainController.nextHint(); 
    }//GEN-LAST:event_jar1TransferButtonActionPerformed

    private void jar1EmptyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jar1EmptyButtonActionPerformed
        this.mainController.emptyJar1();
        if (isHintMarked()) this.mainController.nextHint();
    }//GEN-LAST:event_jar1EmptyButtonActionPerformed

    private void jar1FillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jar1FillButtonActionPerformed
        this.mainController.fillJar1();
        if (isHintMarked()) this.mainController.nextHint();
    }//GEN-LAST:event_jar1FillButtonActionPerformed

    private void jar2TransferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jar2TransferButtonActionPerformed
        this.mainController.transferTojar1();
        if (isHintMarked()) this.mainController.nextHint();
    }//GEN-LAST:event_jar2TransferButtonActionPerformed

    private void jar2EmptyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jar2EmptyButtonActionPerformed
        this.mainController.emptyJar2();
        if (isHintMarked()) this.mainController.nextHint();
    }//GEN-LAST:event_jar2EmptyButtonActionPerformed

    private void jar2FillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jar2FillButtonActionPerformed
        this.mainController.fillJar2();
        if (isHintMarked()) this.mainController.nextHint();
    }//GEN-LAST:event_jar2FillButtonActionPerformed

    private void estadoInicialMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoInicialMenuItemActionPerformed
        StatePreferencesGUI prefGui = new StatePreferencesGUI();
        WaterJarsPreferencesController prefController = new WaterJarsPreferencesController(this.mainController,prefGui);
        prefGui.setController(prefController);
        prefController.show();
    }//GEN-LAST:event_estadoInicialMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        this.mainController.about();
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void clueMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clueMenuItemActionPerformed
        this.mainController.hint();
    }//GEN-LAST:event_clueMenuItemActionPerformed

    private void newMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuItemActionPerformed
        this.mainController.resetState();
    }//GEN-LAST:event_newMenuItemActionPerformed

    private void iaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iaMenuItemActionPerformed
        IAgui iaGui = new IAgui();
        WaterJarsIAController iaController = new WaterJarsIAController(this.mainController, iaGui);
        iaGui.setController(iaController);
        iaController.show();
    }//GEN-LAST:event_iaMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WaterJarsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WaterJarsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WaterJarsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WaterJarsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new WaterJarsGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem clueMenuItem;
    private javax.swing.JMenuItem estadoInicialMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu iaMenu;
    private javax.swing.JMenuItem iaMenuItem;
    private javax.swing.JLabel jar1Capacity;
    private javax.swing.JButton jar1EmptyButton;
    private javax.swing.JButton jar1FillButton;
    private javax.swing.JLabel jar1Ocuppied;
    private javax.swing.JPanel jar1Panel;
    private javax.swing.JButton jar1TransferButton;
    private javax.swing.JLabel jar2Capacity;
    private javax.swing.JButton jar2EmptyButton;
    private javax.swing.JButton jar2FillButton;
    private javax.swing.JLabel jar2Ocuppied;
    private javax.swing.JPanel jar2Panel;
    private javax.swing.JButton jar2TransferButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JMenu preferencesMenu;
    private javax.swing.JLabel success;
    // End of variables declaration//GEN-END:variables




    public void update(WaterJarsState state) {
        //limpiar cartel de exito
        this.success.setBackground(Color.RED);
        
        //Update jars status
        this.jar1Capacity.setText("capacidad: "+state.getJar1Cap());
        this.jar2Capacity.setText("capacidad: "+state.getJar2Cap());
        this.jar1Ocuppied.setText("contenido: "+state.getJar1Cont());
        this.jar2Ocuppied.setText("contenido: "+state.getJar2Cont());
        
        //update enabled buttons and success status
        if (state.success()) {
            enableButtons(false);
            this.success.setBackground(Color.GREEN);
        } else {
            enableFill1Button(state.getJar1Cont() < state.getJar1Cap());
            enableFill2Button(state.getJar2Cont() < state.getJar2Cap());
            enableEmpty1Button(state.getJar1Cont() > 0);
            enableEmpty2Button(state.getJar2Cont() > 0);
            enableTransfer1Button(state.getJar1Cont()==0?false:state.getJar2Cont() < state.getJar2Cap());
            enableTransfer2Button(state.getJar2Cont()==0?false:state.getJar1Cont() < state.getJar1Cap());
        }
    }
    
    public void enableButtons(boolean enable) {
        enableFill1Button(enable);
        enableFill2Button(enable);
        enableEmpty1Button(enable);
        enableEmpty2Button(enable);
        enableTransfer1Button(enable);
        enableTransfer2Button(enable);
    }
    
    private void enableFill1Button(boolean enable) {
        this.jar1FillButton.setEnabled(enable);
    }
    
    private void enableFill2Button(boolean enable) {
        this.jar2FillButton.setEnabled(enable);
    }
    
    private void enableEmpty1Button(boolean enable) {
        this.jar1EmptyButton.setEnabled(enable);
    }
    
    private void enableEmpty2Button(boolean enable) {
        this.jar2EmptyButton.setEnabled(enable);
    }
    
    private void enableTransfer1Button(boolean enable) {
        this.jar1TransferButton.setEnabled(enable);
    }
    
    private void enableTransfer2Button(boolean enable) {
        this.jar2TransferButton.setEnabled(enable);
    }
    
    public void unpaintAllButtons() {
        paintFill1Button(null);
        paintFill2Button(null);
        paintEmpty1Button(null);
        paintEmpty2Button(null);
        paintTransfer1Button(null);
        paintTransfer2Button(null);
    }
    
    public void paintFill1Button(Color c) {
        this.jar1FillButton.setBackground(c);
    }
    
    public void paintFill2Button(Color c) {
        this.jar2FillButton.setBackground(c);
    }
    
    public void paintEmpty1Button(Color c) {
        this.jar1EmptyButton.setBackground(c);
    }
    
    public void paintEmpty2Button(Color c) {
        this.jar2EmptyButton.setBackground(c);
    }
    
    public void paintTransfer1Button(Color c) {
        this.jar1TransferButton.setBackground(c);
    }
    
    public void paintTransfer2Button(Color c) {
        this.jar2TransferButton.setBackground(c);
    }
    
    private boolean isHintMarked() {
        boolean f1b = this.jar1FillButton.getBackground() == Color.GREEN;
        boolean f2b = this.jar2FillButton.getBackground() == Color.GREEN;
        boolean e1b = this.jar1EmptyButton.getBackground() == Color.GREEN;
        boolean e2b = this.jar2EmptyButton.getBackground() == Color.GREEN;
        boolean t1b = this.jar1TransferButton.getBackground() == Color.GREEN;
        boolean t2b = this.jar2TransferButton.getBackground() == Color.GREEN;
        return f1b || f2b || e1b || e2b || t1b || t2b;
    }

}
