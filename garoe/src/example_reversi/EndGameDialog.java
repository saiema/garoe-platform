/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EndGameDialog.java
 *
 * Created on 13-nov-2011, 20:40:13
 */
package example_reversi;

import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author BigEma
 */
public class EndGameDialog extends javax.swing.JFrame implements ActionListener {
    private JFrame father;
    
    /** Creates new form EndGameDialog */
    public EndGameDialog(ImageIcon image, String message) {
        initComponents();
        this.setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint());
        this.image.setIcon(image);
        this.image.setText("");
        this.message.setText(message);
    }
    
    public void setFather(JFrame father) {
        this.father = father;
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        image = new javax.swing.JLabel();
        message = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 22, 300, 300));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setText("IMAGE");
        image.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        image.setMaximumSize(new java.awt.Dimension(126, 120));
        image.setMinimumSize(new java.awt.Dimension(126, 120));
        image.setPreferredSize(new java.awt.Dimension(126, 120));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 0, 1);
        getContentPane().add(image, gridBagConstraints);

        message.setFont(new java.awt.Font("Segoe Print", 3, 24));
        message.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        message.setText("MESSAGE");
        message.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        getContentPane().add(message, gridBagConstraints);

        okButton.setText("ok");
        okButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        okButton.addActionListener(this);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        getContentPane().add(okButton, gridBagConstraints);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == okButton) {
            EndGameDialog.this.okButtonActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        this.father.setEnabled(true);
        this.father.setFocusable(true);
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    
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
            java.util.logging.Logger.getLogger(EndGameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EndGameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EndGameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EndGameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EndGameDialog(new ImageIcon(System.class.getResource("/images/ganaste120x120.jpg")),"LAVATE EL CULO").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel image;
    private javax.swing.JTextField message;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
