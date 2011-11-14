/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SettingsGUI.java
 *
 * Created on 10-nov-2011, 22:43:29
 */
package example_reversi;

import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author BigEma
 */
public class SettingsGUI extends javax.swing.JFrame implements  ActionListener {
    private ReversiSettingsController controller;

    /** Creates new form SettingsGUI */
    public SettingsGUI() {
        initComponents();
        this.setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint());
    }
    
    public void setController(ReversiSettingsController controller) {
        this.controller = controller;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        player2Label = new javax.swing.JLabel();
        player1Label = new javax.swing.JLabel();
        player1NameLabel = new javax.swing.JLabel();
        player2NameLabel = new javax.swing.JLabel();
        player1NameValue = new javax.swing.JTextField();
        player2NameValue = new javax.swing.JTextField();
        player1BrainsLabel = new javax.swing.JLabel();
        player2BrainsLabel = new javax.swing.JLabel();
        player1BrainsSelect = new javax.swing.JComboBox();
        player2BrainsSelect = new javax.swing.JComboBox();
        player1ColorLabel = new javax.swing.JLabel();
        player2ColorLabel = new javax.swing.JLabel();
        player1Color = new javax.swing.JButton();
        player2Color = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        player2Label.setText("player 2");

        player1Label.setText("player 1");

        player1NameLabel.setText("name:");

        player2NameLabel.setText("name:");

        player1NameValue.setText("xxx");
        player1NameValue.setMaximumSize(new java.awt.Dimension(24, 20));
        player1NameValue.setMinimumSize(new java.awt.Dimension(24, 20));

        player2NameValue.setText("xxx");
        player2NameValue.setMaximumSize(new java.awt.Dimension(24, 20));
        player2NameValue.setMinimumSize(new java.awt.Dimension(24, 20));
        player2NameValue.setName(""); // NOI18N

        player1BrainsLabel.setText("brains");

        player2BrainsLabel.setText("brains");

        player1BrainsSelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AI", "Human" }));
        player1BrainsSelect.setSelectedIndex(1);
        player1BrainsSelect.setToolTipText("");

        player2BrainsSelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AI", "Human" }));
        player2BrainsSelect.setSelectedIndex(1);
        player2BrainsSelect.setToolTipText("");

        player1ColorLabel.setText("color");

        player2ColorLabel.setText("color");

        player1Color.setText("WHITE");
        player1Color.addActionListener(this);

        player2Color.setText("WHITE");
        player2Color.addActionListener(this);

        saveButton.setText("save");
        saveButton.addActionListener(this);

        cancelButton.setText("cancel");
        cancelButton.addActionListener(this);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(player1Label)
                                .addComponent(player1NameLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(player1NameValue, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(player1BrainsLabel)
                                .addComponent(player1ColorLabel))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(player1Color, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                .addComponent(player1BrainsSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(saveButton))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(player2NameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(player2NameValue, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                    .addComponent(player2Label)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(player2BrainsLabel)
                            .addComponent(player2ColorLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(player2Color, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(player2BrainsSelect, 0, 65, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(player2Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(player2NameLabel)
                            .addComponent(player2NameValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(player2BrainsLabel)
                            .addComponent(player2BrainsSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(player2ColorLabel)
                            .addComponent(player2Color))
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(player1Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(player1NameLabel)
                            .addComponent(player1NameValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(player1BrainsLabel)
                            .addComponent(player1BrainsSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(player1ColorLabel)
                            .addComponent(player1Color))
                        .addGap(18, 18, 18)
                        .addComponent(saveButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == cancelButton) {
            SettingsGUI.this.cancelButtonActionPerformed(evt);
        }
        else if (evt.getSource() == saveButton) {
            SettingsGUI.this.saveButtonActionPerformed(evt);
        }
        else if (evt.getSource() == player1Color) {
            SettingsGUI.this.player1ColorActionPerformed(evt);
        }
        else if (evt.getSource() == player2Color) {
            SettingsGUI.this.player2ColorActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.controller.close();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        int colorPlayer1 = this.getPlayer1Color().getText().compareToIgnoreCase("white") == 0?ReversiToken.WHITE:ReversiToken.BLACK;
        int colorPlayer2 = this.getPlayer2Color().getText().compareToIgnoreCase("white") == 0?ReversiToken.WHITE:ReversiToken.BLACK;
        boolean aiPlayer1 = this.getPlayer1BrainsSelect().getSelectedIndex() == 0?true:false;
        boolean aiPlayer2 = this.getPlayer2BrainsSelect().getSelectedIndex() == 0?true:false;
        String player1Name = this.getPlayer1NameValue().getText();
        String player2Name = this.getPlayer2NameValue().getText();
        this.controller.save(player1Name, player2Name, colorPlayer1, colorPlayer2, aiPlayer1, aiPlayer2);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void player1ColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player1ColorActionPerformed
        String color1 = this.getPlayer1Color().getText();
        if (color1.compareToIgnoreCase("white") == 0) {
            this.getPlayer1Color().setText("BLACK");
        } else {
            this.getPlayer1Color().setText("WHITE");
        }
        this.changeColorValue(this.getPlayer2Color());
    }//GEN-LAST:event_player1ColorActionPerformed

    private void player2ColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2ColorActionPerformed
        String color2 = this.getPlayer2Color().getText();
        if (color2.compareToIgnoreCase("white") == 0) {
            this.getPlayer2Color().setText("BLACK");
        } else {
            this.getPlayer2Color().setText("WHITE");
        }
        this.changeColorValue(this.getPlayer1Color());
    }//GEN-LAST:event_player2ColorActionPerformed

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
            java.util.logging.Logger.getLogger(SettingsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettingsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettingsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SettingsGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel player1BrainsLabel;
    private javax.swing.JComboBox player1BrainsSelect;
    private javax.swing.JButton player1Color;
    private javax.swing.JLabel player1ColorLabel;
    private javax.swing.JLabel player1Label;
    private javax.swing.JLabel player1NameLabel;
    private javax.swing.JTextField player1NameValue;
    private javax.swing.JLabel player2BrainsLabel;
    private javax.swing.JComboBox player2BrainsSelect;
    private javax.swing.JButton player2Color;
    private javax.swing.JLabel player2ColorLabel;
    private javax.swing.JLabel player2Label;
    private javax.swing.JLabel player2NameLabel;
    private javax.swing.JTextField player2NameValue;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables


//AGREGADO

    public JComboBox getPlayer1BrainsSelect() {
        return player1BrainsSelect;
    }

    public JTextField getPlayer1NameValue() {
        return player1NameValue;
    }

    public JComboBox getPlayer2BrainsSelect() {
        return player2BrainsSelect;
    }

    public JTextField getPlayer2NameValue() {
        return player2NameValue;
    }

    public JButton getPlayer1Color() {
        return player1Color;
    }

    public JButton getPlayer2Color() {
        return player2Color;
    }
    
    

    private void changeColorValue(JButton button) {
        if (button.getText().compareToIgnoreCase("white") == 0) {
            button.setText("BLACK");
        } else {
            button.setText("WHITE");
        }
    }
    
    


}
