/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

/**
 *
 * @author Ilija Dumanović
 */
public class mainForm extends javax.swing.JFrame {

    /**
     * Creates new form mainForm
     */
    public mainForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miServerForma = new javax.swing.JMenuItem();
        miConfiguration = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        miPort = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server forma");

        jMenu1.setText(" Server");

        miServerForma.setText("Server forma");
        miServerForma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miServerFormaActionPerformed(evt);
            }
        });
        jMenu1.add(miServerForma);

        jMenuBar1.add(jMenu1);

        miConfiguration.setText("Database Configuration");

        jMenuItem1.setText("Baza konfiguracija");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        miConfiguration.add(jMenuItem1);

        miPort.setText("Port konfiguracija");
        miPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPortActionPerformed(evt);
            }
        });
        miConfiguration.add(miPort);

        jMenuBar1.add(miConfiguration);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miServerFormaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miServerFormaActionPerformed
       new serverForm().setVisible(true);
    }//GEN-LAST:event_miServerFormaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       new konfiguracijeForma().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void miPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPortActionPerformed
        new portForma().setVisible(true);
    }//GEN-LAST:event_miPortActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu miConfiguration;
    private javax.swing.JMenuItem miPort;
    private javax.swing.JMenuItem miServerForma;
    // End of variables declaration//GEN-END:variables
}