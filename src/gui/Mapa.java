/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import acceso.Conexion;
import com.itextpdf.io.font.FontConstants;


import java.awt.Color;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import static com.itextpdf.kernel.pdf.PdfName.Font;
import static com.itextpdf.kernel.pdf.PdfName.FontFamily;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import gui.BuscarVehiculo;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.Graphics;
import java.awt.HeadlessException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

import javax.swing.text.DocumentFilter;

import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.awt.Color;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.parser.PdfDocumentContentParser;
import com.itextpdf.kernel.pdf.canvas.parser.listener.IEventListener;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.awt.Image;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
/**
 *
 * @author ksant
 */
public class Mapa extends javax.swing.JFrame {
 FondoPanel fondo = new FondoPanel();
    
    PreparedStatement ps; //sentencia
    ResultSet rs; //resultado
    Connection aux; //conexion
    String sql;

    /**
     * Creates new form IngresarVehiculo
     */
    public Mapa() {
        this.setContentPane(fondo);
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
            
              
        }

    }
    
      public void setIdAdminValue(int idAdmin) {
      jLabel2.setText(String.valueOf(idAdmin));
    }              
      
public String getIdAdminPrincipal() {
    return jLabel2.getText();
}
  
   int filas = 3;
int columnas = 4;
int largo = 60;
int ancho = 80;
int espaciadoHorizontal = 50; // Nueva variable para controlar el espaciado horizontal
int espaciadoVertical = 95;   // Nueva variable para controlar el espaciado vertical
int ejex = 160;
int ejey = 50;
    
    public JToggleButton[][] jtboton = new JToggleButton[filas][columnas];
    
    public void asignarlugar(int lugar){
        try{
            String consulta = "UPDATE bahia SET estado='OCUPADO' WHERE IdBahia ="+lugar;
            ps = aux.prepareStatement(consulta);
            int mensaje = ps.executeUpdate();
            if(mensaje>0){
                JOptionPane.showMessageDialog(null,"Bahia seleccionada");
                System.out.println(lugar);
               
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
            ejex = 160;
            ejey += (ancho + espaciadoVertical);
        }
    }  
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    String fechaHora="";
    public static final String DEST = "C:\\Users\\ksant\\Documents\\NetBeansProjects\\parqueadero\\ejemplo.pdf";
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new FondoPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setText("DISPONIBILIDAD DE BAHIAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel2)
                .addContainerGap(422, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mapa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}


class FondoPanel extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/gui/IMG-20231117-WA0031 (2).jpg")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }