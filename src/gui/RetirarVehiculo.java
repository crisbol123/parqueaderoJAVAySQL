/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import acceso.Conexion;
import acceso.VigilanteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import modelo.EnumTipo;
import modelo.Vigilante;

/**
 *
 * @author ksant
 */
public class RetirarVehiculo extends javax.swing.JFrame {
Conexion conexion = new Conexion();

 PreparedStatement ps;
    ResultSet rs;
    Connection aux;
    String sql;
    /**
     * Creates new form RetirarVehiculo
     */
    public RetirarVehiculo() {
             initComponents();
       // botones();
        //conexion = new Conexion();
        Conexion conexion = new Conexion();
        aux = conexion.conectar();
        if (aux == null) {
            // Manejar el caso en el que la conexión no se estableció correctamente
            System.out.println("Error: La conexión es nula");
        }else{
            botones();
            
            ((AbstractDocument) PLACA.getDocument()).setDocumentFilter(new DocumentFilter() {
    private final int maxCharacters = 7;

    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
        int futureLength = currentText.length() - length + text.length();

        if (futureLength <= maxCharacters) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
});
            
                    
        }

    }
    
         public void setIdAdminValue(int idAdmin) {
      jLabel5.setText(String.valueOf(idAdmin));
    }              
      
public String getIdAdminPrincipal() {
    return jLabel5.getText();
}

 int filas = 3;
int columnas = 4;
int largo = 65;
int ancho = 100;
int espaciadoHorizontal = 18; // Nueva variable para controlar el espaciado horizontal
int espaciadoVertical = 87;   // Nueva variable para controlar el espaciado vertical
int ejex = 119;
int ejey = 34;
    
    public JToggleButton[][] jtboton = new JToggleButton[filas][columnas];
    
    public void asignarlugar(int lugar){
        try{
            String consulta = "UPDATE bahia SET estado='OCUPADO' WHERE IdBahia ="+lugar;
            ps = aux.prepareStatement(consulta);
            int mensaje = ps.executeUpdate();
            if(mensaje>0){
                JOptionPane.showMessageDialog(null,"Vehiculo estacionado");
            }else{
                JOptionPane.showMessageDialog(null,"Error al actualizar");
            }
        }catch(Exception e){
            System.out.print("Error:"+e);
        }
    }
    
    public void eliminarlugar(int lugar){
        try{
            String consulta = "UPDATE bahia SET estado='DISPONIBLE' WHERE IdBahia ="+lugar;
            ps = aux.prepareStatement(consulta);
            int mensaje = ps.executeUpdate();
            if(mensaje>0){
                JOptionPane.showMessageDialog(null,"Vehiculo retirado");
            }else{
                JOptionPane.showMessageDialog(null,"Error al actualizar");
            }
        } catch(Exception e){
            System.out.print("Error:"+e);
        }
    }
    
// ...

  // Método para obtener el estado de la bahía desde la base de datos
    private String obtenerEstadoBahiaDesdeBD(int i, int j) {
        String estado = "DISPONIBLE";  // Valor predeterminado

        try {
            String consulta = "SELECT estado FROM bahia WHERE IdBahia = " + ((i * columnas) + j + 1);
            ps = aux.prepareStatement(consulta);
            rs = ps.executeQuery();
            if (rs.next()) {
                estado = rs.getString("estado");
            }
        } catch (SQLException e) {
            System.out.print("Error:" + e);
        }

        return estado;
    }

    public void botones() {
        int contar = 1;
       java.awt.Font fuente = new java.awt.Font("Arial", java.awt.Font.BOLD, 15);

        jtboton = new JToggleButton[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                jtboton[i][j] = new JToggleButton();
                jtboton[i][j].setBounds(ejex, ejey, largo, ancho);
                jtboton[i][j].setText("B" + contar++);
                jtboton[i][j].setFont(fuente);

                // Obtener el estado de la bahía desde la base de datos
                String estadoBahia = obtenerEstadoBahiaDesdeBD(i, j);

                // Modificar el color del botón según el estado de la bahía
                if (estadoBahia.equals("OCUPADO")) {
                 
                    jtboton[i][j].setBackground(java.awt.Color.RED);
                } else {
                    jtboton[i][j].setBackground(java.awt.Color.GREEN);
                }

              
               
                jPanel2.add(jtboton[i][j]);
                ejex += (largo + espaciadoHorizontal);
            }
            ejex = 118;
            ejey += (ancho + espaciadoVertical);
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
        jLabel2 = new javax.swing.JLabel();
        PLACA = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new FondoPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("INGRESE PLACA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel2.setText("SALIDA DE VEHICULOS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        jPanel1.add(PLACA, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 140, 40));

        jButton1.setText("VOLVER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton2.setText("RETIRAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/CARRITO.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/MOTOO.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\ksant\\Documents\\NetBeansProjects\\UsuarioBiblioteca\\UsuarioBiblioteca\\pngwing.com (4).png")); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 120, 70));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          this.dispose();
        int codigo = Integer.parseInt(jLabel5.getText());
       InterfazVehiculo loginPrincipal = new InterfazVehiculo();
            loginPrincipal.setLocationRelativeTo(null); // Centra el JFrame en la pantalla
            loginPrincipal.setVisible(true);
            loginPrincipal.setIdAdminValue(codigo);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
try {
    sql = "DELETE FROM vehiculo WHERE Placa=?";
    ps = aux.prepareStatement(sql);
    ps.setString(1, PLACA.getText());
    int filasAfectadas = ps.executeUpdate();
    String updateBahiaSql = "UPDATE bahia SET estado = 'DISPONIBLE', Placa = ? WHERE Placa = ?";
        PreparedStatement updateBahiaPs = aux.prepareStatement(updateBahiaSql);
        updateBahiaPs.setString(1, "");
        updateBahiaPs.setString(2, PLACA.getText());
        updateBahiaPs.executeUpdate();
    if (filasAfectadas > 0) {
       
        JOptionPane.showMessageDialog(null, "Registro borrado exitosamente.");
        
        
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró la Placa proporcionada.");
       
    }
} catch (SQLException ex) {
    Logger.getLogger(VigilanteDAO.class.getName()).log(Level.SEVERE, null, ex);
} finally {
        try {
            // Cierra la conexión después de ejecutar la consulta
            aux.close();
             this.dispose();
        int codigo = Integer.parseInt(jLabel5.getText());
       RetirarVehiculo loginPrincipal = new RetirarVehiculo();
            loginPrincipal.setLocationRelativeTo(null); // Centra el JFrame en la pantalla
            loginPrincipal.setVisible(true);
            loginPrincipal.setIdAdminValue(codigo);
             
        } catch (SQLException ex) {
            Logger.getLogger(RetirarVehiculo.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(RetirarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RetirarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RetirarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RetirarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RetirarVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PLACA;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
