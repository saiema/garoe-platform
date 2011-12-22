/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AIgui.java
 *
 * Created on 13-nov-2011, 17:57:37
 */
package example_reversi;

import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;

/**
 *
 * @author BigEma
 */
public class AIgui extends javax.swing.JFrame implements ActionListener {
    private ReversiAISettingsController controller;
    
    /** Creates new form AIgui */
    public AIgui() {
        initComponents();
        this.setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint());
    }
    
    public void setController(ReversiAISettingsController controller) {
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

        engineLabel = new javax.swing.JLabel();
        engineSelector = new javax.swing.JComboBox();
        maxTreeLevelLabel = new javax.swing.JLabel();
        treeLevelSpinner = new javax.swing.JSpinner();
        maxSearchTimeLabel = new javax.swing.JLabel();
        searchTimeSpinner = new javax.swing.JSpinner();
        maxSearchNodesLabel = new javax.swing.JLabel();
        searchNodesSpinner = new javax.swing.JSpinner();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        engineLabel.setText("AI engine");

        engineSelector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MinMax con poda Alfa-Beta" }));

        maxTreeLevelLabel.setText("Max tree level");

        treeLevelSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        maxSearchTimeLabel.setText("Max search time (ms)");
        maxSearchTimeLabel.setEnabled(false);

        searchTimeSpinner.setEnabled(false);

        maxSearchNodesLabel.setText("Max search nodes");
        maxSearchNodesLabel.setEnabled(false);

        searchNodesSpinner.setEnabled(false);

        saveButton.setText("save");
        saveButton.addActionListener(this);

        cancelButton.setText("cancel");
        cancelButton.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(engineLabel)
                        .addGap(30, 30, 30)
                        .addComponent(engineSelector, 0, 332, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maxTreeLevelLabel)
                            .addComponent(maxSearchTimeLabel)
                            .addComponent(maxSearchNodesLabel))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchNodesSpinner)
                            .addComponent(searchTimeSpinner)
                            .addComponent(treeLevelSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(engineLabel)
                    .addComponent(engineSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(maxTreeLevelLabel)
                    .addComponent(treeLevelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxSearchTimeLabel)
                    .addComponent(searchTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxSearchNodesLabel)
                    .addComponent(searchNodesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == saveButton) {
            AIgui.this.saveButtonActionPerformed(evt);
        }
        else if (evt.getSource() == cancelButton) {
            AIgui.this.cancelButtonActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Integer maxTreeLevel = (Integer)this.getTreeLevelSpinner().getValue();
        Integer maxSearchTime = (Integer)this.getSearchTimeSpinner().getValue();
        Integer maxSearchNodes = (Integer)this.getSearchNodesSpinner().getValue();
        this.controller.save(this.getEngineSelector().getSelectedItem().toString(), maxTreeLevel, maxSearchTime, maxSearchNodes);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.controller.close();
    }//GEN-LAST:event_cancelButtonActionPerformed

    
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
            java.util.logging.Logger.getLogger(AIgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AIgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AIgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AIgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AIgui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel engineLabel;
    private javax.swing.JComboBox engineSelector;
    private javax.swing.JLabel maxSearchNodesLabel;
    private javax.swing.JLabel maxSearchTimeLabel;
    private javax.swing.JLabel maxTreeLevelLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JSpinner searchNodesSpinner;
    private javax.swing.JSpinner searchTimeSpinner;
    private javax.swing.JSpinner treeLevelSpinner;
    // End of variables declaration//GEN-END:variables

    public JLabel getEngineLabel() {
        return engineLabel;
    }

    public JComboBox getEngineSelector() {
        return engineSelector;
    }

    public JSpinner getSearchNodesSpinner() {
        return searchNodesSpinner;
    }

    public JSpinner getSearchTimeSpinner() {
        return searchTimeSpinner;
    }

    public JSpinner getTreeLevelSpinner() {
        return treeLevelSpinner;
    }

    

    public JLabel getMaxSearchNodes() {
        return maxSearchNodesLabel;
    }

    public JLabel getMaxSearchTimeLevel() {
        return maxSearchTimeLabel;
    }

    public JLabel getMaxTreeLevelLabel() {
        return maxTreeLevelLabel;
    }



}
