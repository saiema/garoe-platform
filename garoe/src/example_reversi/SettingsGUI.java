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

import java.awt.Color;
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
        initHintColorSelector(this.hintWhiteColorSelector);
        initHintColorSelector(this.hintBlackColorSelector);
        this.guideActivated.setEnabled(true);
        this.hintWhiteColorSelector.setSelectedIndex(6);
        this.hintBlackColorSelector.setSelectedIndex(0);
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
        jPanel2 = new javax.swing.JPanel();
        player1NameLabel = new javax.swing.JLabel();
        player1NameValue = new javax.swing.JTextField();
        player1BrainsLabel = new javax.swing.JLabel();
        player1BrainsSelect = new javax.swing.JComboBox();
        player1ColorLabel = new javax.swing.JLabel();
        player1Color = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        player2NameLabel = new javax.swing.JLabel();
        player2NameValue = new javax.swing.JTextField();
        player2BrainsLabel = new javax.swing.JLabel();
        player2BrainsSelect = new javax.swing.JComboBox();
        player2ColorLabel = new javax.swing.JLabel();
        player2Color = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        guideActivated = new javax.swing.JCheckBox();
        colorGuia1Label = new javax.swing.JLabel();
        hintWhiteColorSelector = new javax.swing.JComboBox();
        colorGuia2Label = new javax.swing.JLabel();
        hintBlackColorSelector = new javax.swing.JComboBox();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(this.winClose());
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("preferencias jugador 1"));

        player1NameLabel.setText("nombre");

        player1NameValue.setText("xxx");
        player1NameValue.setMaximumSize(new java.awt.Dimension(24, 20));
        player1NameValue.setMinimumSize(new java.awt.Dimension(24, 20));

        player1BrainsLabel.setText("inteligencia");

        player1BrainsSelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AI", "Human" }));
        player1BrainsSelect.setSelectedIndex(1);
        player1BrainsSelect.setToolTipText("");

        player1ColorLabel.setText("color");

        player1Color.setText("WHITE");
        player1Color.addActionListener(this);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(player1NameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(player1NameValue, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(player1BrainsLabel)
                        .addGap(18, 18, 18)
                        .addComponent(player1BrainsSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(player1ColorLabel)
                        .addGap(18, 18, 18)
                        .addComponent(player1Color)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1NameLabel)
                    .addComponent(player1NameValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1BrainsLabel)
                    .addComponent(player1BrainsSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1ColorLabel)
                    .addComponent(player1Color))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("preferencias jugador 2"));
        jPanel3.setPreferredSize(new java.awt.Dimension(222, 166));

        player2NameLabel.setText("nombre");

        player2NameValue.setText("xxx");
        player2NameValue.setMaximumSize(new java.awt.Dimension(24, 20));
        player2NameValue.setMinimumSize(new java.awt.Dimension(24, 20));
        player2NameValue.setName(""); // NOI18N

        player2BrainsLabel.setText("inteligencia");

        player2BrainsSelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AI", "Human" }));
        player2BrainsSelect.setSelectedIndex(1);
        player2BrainsSelect.setToolTipText("");

        player2ColorLabel.setText("color");

        player2Color.setText("WHITE");
        player2Color.addActionListener(this);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(player2NameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(player2NameValue, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(player2BrainsLabel)
                        .addGap(18, 18, 18)
                        .addComponent(player2BrainsSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(player2ColorLabel)
                        .addGap(18, 18, 18)
                        .addComponent(player2Color)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player2NameLabel)
                    .addComponent(player2NameValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player2BrainsLabel)
                    .addComponent(player2BrainsSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player2ColorLabel)
                    .addComponent(player2Color))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("preferencias guia jugadas"));

        guideActivated.setText("activar guía");

        colorGuia1Label.setText("Color guía color blanco");

        hintWhiteColorSelector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        hintWhiteColorSelector.addActionListener(this);

        colorGuia2Label.setText("Color guía color negro");

        hintBlackColorSelector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        hintBlackColorSelector.setLightWeightPopupEnabled(false);
        hintBlackColorSelector.setMaximumSize(new java.awt.Dimension(56, 20));
        hintBlackColorSelector.addActionListener(this);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guideActivated)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(colorGuia2Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(colorGuia1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(hintWhiteColorSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(hintBlackColorSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(guideActivated)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colorGuia1Label)
                    .addComponent(hintWhiteColorSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colorGuia2Label)
                    .addComponent(hintBlackColorSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        saveButton.setText("save");
        saveButton.addActionListener(this);

        cancelButton.setText("cancel");
        cancelButton.addActionListener(this);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == player1Color) {
            SettingsGUI.this.player1ColorActionPerformed(evt);
        }
        else if (evt.getSource() == player2Color) {
            SettingsGUI.this.player2ColorActionPerformed(evt);
        }
        else if (evt.getSource() == hintWhiteColorSelector) {
            SettingsGUI.this.hintWhiteColorSelectorActionPerformed(evt);
        }
        else if (evt.getSource() == hintBlackColorSelector) {
            SettingsGUI.this.hintBlackColorSelectorActionPerformed(evt);
        }
        else if (evt.getSource() == saveButton) {
            SettingsGUI.this.saveButtonActionPerformed(evt);
        }
        else if (evt.getSource() == cancelButton) {
            SettingsGUI.this.cancelButtonActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.controller.close();
    }//GEN-LAST:event_cancelButtonActionPerformed

    
    private int winClose() {
        this.cancelButtonActionPerformed(null);
        return 0;
    }
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        int colorPlayer1 = this.getPlayer1Color().getText().compareToIgnoreCase("white") == 0?ReversiToken.WHITE:ReversiToken.BLACK;
        int colorPlayer2 = this.getPlayer2Color().getText().compareToIgnoreCase("white") == 0?ReversiToken.WHITE:ReversiToken.BLACK;
        boolean aiPlayer1 = this.getPlayer1BrainsSelect().getSelectedIndex() == 0?true:false;
        boolean aiPlayer2 = this.getPlayer2BrainsSelect().getSelectedIndex() == 0?true:false;
        String player1Name = this.getPlayer1NameValue().getText();
        String player2Name = this.getPlayer2NameValue().getText();
        Color hintWhite = getSelectedHintColor(1);
        Color hintBlack = getSelectedHintColor(2);
        this.controller.save(player1Name, player2Name, colorPlayer1, colorPlayer2, aiPlayer1, aiPlayer2, this.guideActivated.isSelected(),hintWhite,hintBlack);
        
    }//GEN-LAST:event_saveButtonActionPerformed

    private Color getSelectedHintColor(int color) {
        if (color == 1) {
            return textToColor((String)this.hintWhiteColorSelector.getSelectedItem());
        } else {
            return textToColor((String)this.hintBlackColorSelector.getSelectedItem());
        }
    }
    
    private Color textToColor(String c) {
        if (c.compareTo("BLACK")==0) {
            return Color.BLACK;
        } else if (c.compareTo("BLUE")==0) {
            return Color.BLUE;
        } else if (c.compareTo("CYAN")==0) {
            return Color.CYAN;
        } else if (c.compareTo("DARK_GRAY")==0) {
            return Color.DARK_GRAY;
        } else if (c.compareTo("GRAY")==0) {
            return Color.GRAY;
        } else if (c.compareTo("GREEN")==0) {
            return Color.GREEN;
        } else if (c.compareTo("LIGHT_GRAY")==0) {
            return Color.LIGHT_GRAY;
        } else if (c.compareTo("MAGENTA")==0) {
            return Color.MAGENTA;
        } else if (c.compareTo("ORANGE")==0) {
            return Color.ORANGE;
        } else if (c.compareTo("PINK")==0) {
            return Color.PINK;
        } else if (c.compareTo("RED")==0) {
            return Color.RED;
        } else if (c.compareTo("WHITE")==0) {
            return Color.WHITE;
        } else if (c.compareTo("YELLOW")==0) {
            return Color.YELLOW;
        } else {
            return null;
        }
    }
    
    
    
    private int colorIndex(Color c){
        if (c.equals(Color.BLACK)) {
            return 0;
        } else if (c.equals(Color.BLUE)) {
            return 1;
        } else if (c.equals(Color.CYAN)) {
            return 2;
        } else if (c.equals(Color.DARK_GRAY)) {
            return 3;
        } else if (c.equals(Color.GRAY)) {
            return 4;
        } else if (c.equals(Color.GREEN)) {
            return 5;
        } else if (c.equals(Color.LIGHT_GRAY)) {
            return 6;
        } else if (c.equals(Color.MAGENTA)) {
            return 7;
        } else if (c.equals(Color.ORANGE)) {
            return 8;
        } else if (c.equals(Color.PINK)) {
            return 9;
        } else if (c.equals(Color.RED)) {
            return 10;
        } else if (c.equals(Color.WHITE)) {
            return 11;
        } else if (c.equals(Color.YELLOW)) {
            return 12;
        } else {
            return -1;
        }
    }
    
    
    private void player2ColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2ColorActionPerformed
        String color2 = this.getPlayer2Color().getText();
        if (color2.compareToIgnoreCase("white") == 0) {
            this.getPlayer2Color().setText("BLACK");
        } else {
            this.getPlayer2Color().setText("WHITE");
        }
        this.changeColorValue(this.getPlayer1Color());
    }//GEN-LAST:event_player2ColorActionPerformed

    private void player1ColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player1ColorActionPerformed

        String color1 = this.getPlayer1Color().getText();         if (color1.compareToIgnoreCase("white") == 0) {             this.getPlayer1Color().setText("BLACK");         } else {             this.getPlayer1Color().setText("WHITE");         }         this.changeColorValue(this.getPlayer2Color());     }//GEN-LAST:event_player1ColorActionPerformed

    private void hintWhiteColorSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hintWhiteColorSelectorActionPerformed
        this.saveButton.setEnabled(this.hintWhiteColorSelector.getSelectedIndex() != this.hintBlackColorSelector.getSelectedIndex());
        if (!this.saveButton.isEnabled()) {
            this.saveButton.setToolTipText("Los colores guía deben ser distintos!");
        } else {
            this.saveButton.setToolTipText(null);
        }
    }//GEN-LAST:event_hintWhiteColorSelectorActionPerformed

    private void hintBlackColorSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hintBlackColorSelectorActionPerformed
        this.saveButton.setEnabled(this.hintWhiteColorSelector.getSelectedIndex() != this.hintBlackColorSelector.getSelectedIndex());
        if (!this.saveButton.isEnabled()) {
            this.saveButton.setToolTipText("Los colores guía deben ser distintos!");
        } else {
            this.saveButton.setToolTipText(null);
        }
    }//GEN-LAST:event_hintBlackColorSelectorActionPerformed

    
    
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
    private javax.swing.JLabel colorGuia1Label;
    private javax.swing.JLabel colorGuia2Label;
    private javax.swing.JCheckBox guideActivated;
    private javax.swing.JComboBox hintBlackColorSelector;
    private javax.swing.JComboBox hintWhiteColorSelector;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel player1BrainsLabel;
    private javax.swing.JComboBox player1BrainsSelect;
    private javax.swing.JButton player1Color;
    private javax.swing.JLabel player1ColorLabel;
    private javax.swing.JLabel player1NameLabel;
    private javax.swing.JTextField player1NameValue;
    private javax.swing.JLabel player2BrainsLabel;
    private javax.swing.JComboBox player2BrainsSelect;
    private javax.swing.JButton player2Color;
    private javax.swing.JLabel player2ColorLabel;
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
    
    
    private void initHintColorSelector(JComboBox comboBox) {
        comboBox.setModel(
                new javax.swing.DefaultComboBoxModel(
                        new String[] {                
                            "BLACK",
                            "BLUE",
                            "CYAN",
                            "DARK_GRAY",
                            "GRAY",
                            "GREEN",
                            "LIGHT_GRAY",
                            "MAGENTA",
                            "ORANGE",
                            "PINK",
                            "RED",
                            "WHITE",
                            "YELLOW",     
                            }
                        )
                );
    }
    
    public void setHintValue(boolean hintEnable, Color whiteHint, Color blackHint) {
        this.guideActivated.setSelected(hintEnable);
        this.hintWhiteColorSelector.setSelectedIndex(colorIndex(whiteHint));
        this.hintBlackColorSelector.setSelectedIndex(colorIndex(blackHint));
    }
    
    


}
