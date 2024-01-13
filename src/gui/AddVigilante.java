/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import javax.swing.JOptionPane;
import modelo.Administrador;
import acceso.*;
import modelo.EnumTipo;
import modelo.Vigilante;

/**
 *
 * @author Laura
 */
public class AddVigilante extends javax.swing.JFrame {
    /**
     * Creates new form AddUsuarioVista
     */
    private Vigilante a;
    private VigilanteDAO adao;
    private int ced;
    
    public AddVigilante() {
        initComponents();
        ced = 0;
        a = new Vigilante();
        adao = new VigilanteDAO();
        cargarIdAdminDesdeVista();
    }
    
  
    public AddVigilante(Vigilante vig) {
         initComponents();
        
        this.a = vig;
        ced = a.getIdVigilante();
        
      
        adao = new VigilanteDAO();
        
        IdVigilante.setText(String.valueOf(a.getIdVigilante()));
        Celular.setText(String.valueOf(a.getCelular()));
        Nombre.setText(a.getNombre());
        Apellido.setText(a.getApellido());
        Correo.setText(a.getCorreo());
        IdAdmin.setText(String.valueOf(a.getIdAdmin()));
        cargarIdAdminDesdeVista();
        
    }
    
    public void setIdAdminValue(int idAdmin) {
        IdAdmin.setText(String.valueOf(idAdmin));
    }
      public String getIdAdminValue() {
        return IdAdmin.getText();
    }
    
    private void cargarIdAdminDesdeVista() {
        VigilanteVista vigilanteVista = new VigilanteVista();
        String idAdminGestion = vigilanteVista.getIdAdminGestion();
        IdAdmin.setText(idAdminGestion);
    }
     
    public void guardar() {
        int codigo = Integer.parseInt(IdVigilante.getText());
        int idadmin = Integer.parseInt(IdAdmin.getText());
        String apellido = Apellido.getText();
        String correo = Correo.getText();
         String nombre = Nombre.getText();
        int celular = Integer.parseInt(Celular.getText());
          EnumTipo TIPO = EnumTipo.Vigilante;
     

        a.setIdVigilante(codigo);
        a.setNombre(nombre); // Asigna el nombre que corresponda
        a.setCorreo(correo);
        a.setApellido(apellido);
        a.setCelular(celular);
        a.setIdAdmin(idadmin);
        a.setTIPO(TIPO);
     
        
      
 if(ced==0){
      this.adao.AgregarVigilante(a);
  }
  else
      this.adao.EditarVigilante(a,ced);
    }
    
      private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        // TODO add your handling code here:
        try{
            adao.VigilanteOff();
            System.out.println("Conexión cerrada.");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Apellido = new javax.swing.JTextField();
        Correo = new javax.swing.JTextField();
        VOLVER = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        IdAdmin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        INSERTAT1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        IdVigilante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Celular = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Apellido");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 80, -1));
        jPanel1.add(Apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 174, -1));

        Correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorreoActionPerformed(evt);
            }
        });
        jPanel1.add(Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 174, -1));

        VOLVER.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        VOLVER.setText("Volver");
        VOLVER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VOLVERActionPerformed(evt);
            }
        });
        jPanel1.add(VOLVER, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel4.setText("Registro Vigilante");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setText(" Nombre");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 80, -1));

        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });
        jPanel1.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 174, -1));

        IdAdmin.setBackground(new java.awt.Color(102, 102, 255));
        IdAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        IdAdmin.setBorder(null);
        IdAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdAdminActionPerformed(evt);
            }
        });
        jPanel1.add(IdAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 60, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel7.setText("IdVigilante");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, -1));

        INSERTAT1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        INSERTAT1.setText("Guardar");
        INSERTAT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSERTAT1ActionPerformed(evt);
            }
        });
        jPanel1.add(INSERTAT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ksant\\Documents\\NetBeansProjects\\UsuarioBiblioteca\\UsuarioBiblioteca\\pngwing.com (4).png")); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, 60));

        IdVigilante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdVigilanteActionPerformed(evt);
            }
        });
        jPanel1.add(IdVigilante, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 174, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel8.setText("Correo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 60, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setText("Celular");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 70, -1));

        Celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CelularActionPerformed(evt);
            }
        });
        jPanel1.add(Celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 174, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/apps.61678.14234735185022408.fe2c08da-fe3f-4864-b86c-868c83f48cce.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CorreoActionPerformed

    private void VOLVERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VOLVERActionPerformed
        int codigo = Integer.parseInt(IdAdmin.getText());
        this.dispose();
        VigilanteVista vista = new VigilanteVista();
        vista.setVisible(true);   
        vista.setLocationRelativeTo(null);
                 vista.setIdAdminValue(codigo);
    }//GEN-LAST:event_VOLVERActionPerformed

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    private void INSERTAT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSERTAT1ActionPerformed
        // TODO add your handling code here:
        int codigo = Integer.parseInt(IdAdmin.getText());
        guardar();
        
         this.dispose();
         VigilanteVista vista = new VigilanteVista();
         vista.setVisible(true);
         
         vista.setLocationRelativeTo(null);
         vista.setIdAdminValue(codigo);
    }//GEN-LAST:event_INSERTAT1ActionPerformed

    private void IdVigilanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdVigilanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdVigilanteActionPerformed

    private void CelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CelularActionPerformed

    private void IdAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdAdminActionPerformed

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
            java.util.logging.Logger.getLogger(AddVigilante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddVigilante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddVigilante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddVigilante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new AddVigilante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellido;
    private javax.swing.JTextField Celular;
    private javax.swing.JTextField Correo;
    private javax.swing.JButton INSERTAT1;
    private javax.swing.JTextField IdAdmin;
    private javax.swing.JTextField IdVigilante;
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton VOLVER;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
