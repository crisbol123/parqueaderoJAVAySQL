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
public class IngresarVehiculo extends javax.swing.JFrame {
 FondoPanel fondo = new FondoPanel();
    
    PreparedStatement ps; //sentencia
    ResultSet rs; //resultado
    Connection aux; //conexion
    String sql;

    /**
     * Creates new form IngresarVehiculo
     */
    public IngresarVehiculo() {
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
            
            ((AbstractDocument) PLACA.getDocument()).setDocumentFilter(new DocumentFilter() {
    private final int maxCharacters = 7;

    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
        int futureLength = currentText.length() - length + text.length();

        if (futureLength <= maxCharacters) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
});
            
         NomUsuario.addKeyListener(new KeyAdapter() {
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (Character.isDigit(c)) {
            e.consume();  // Ignora la tecla si es un número
        }
    }
});              
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
int largo = 70;
int ancho = 80;
int espaciadoHorizontal = 7; // Nueva variable para controlar el espaciado horizontal
int espaciadoVertical = 68;   // Nueva variable para controlar el espaciado vertical
int ejex = 107;
int ejey = 32;
    
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

                Accion accion = new Accion();
                jtboton[i][j].addActionListener(accion);
                jPanel2.add(jtboton[i][j]);
                ejex += (largo + espaciadoHorizontal);
            }
            ejex = 108;
            ejey += (ancho + espaciadoVertical);
        }
    }  
    
public class Accion implements ActionListener {

    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (ae.getSource().equals(jtboton[i][j])) {
                    if (!jtboton[i][j].isSelected()) {
                        // El botón no está seleccionado, por lo que no hacemos nada
                        return;
                    }

                    // Obtener el estado de la bahía desde la base de datos
                    String estadoBahia = obtenerEstadoBahiaDesdeBD(i, j);

                    // Verificar si la bahía está ocupada
                    if (estadoBahia.equals("OCUPADO")) {
                        JOptionPane.showMessageDialog(null, "Esta bahía ya está ocupada. Por favor, elige otra.");
                        jtboton[i][j].setSelected(false);  // Deseleccionar el botón
                        
                        return;
                    }

                            if (jtboton[i][j].getText().length() == 2) {
                            String numerosletras = jtboton[i][j].getText().charAt(1) + "";
                        int numero = Integer.parseInt(numerosletras);
                        asignarlugar(numero);
                        

                            // Aquí asignamos el valor al JLabel BAHIA
                            BAHIA.setText(Integer.toString(numero));
                        } else if (jtboton[i][j].getText().length() == 3) {
                            String numerosletras = jtboton[i][j].getText().substring(1);
                            int numero = Integer.parseInt(numerosletras);
                            asignarlugar(numero);

                            // Aquí asignamos el valor al JLabel BAHIA
                            BAHIA.setText(Integer.toString(numero));
                            System.out.println(BAHIA);
                        }
                }
            }
        }
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
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BAHIA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PLACA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        rbMoto = new javax.swing.JRadioButton();
        rbAuto = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        NomUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new FondoPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("INGRESO DE VEHICULOS AL PARQUEADERO");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BAHIA.setBackground(new java.awt.Color(204, 204, 204));
        BAHIA.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        BAHIA.setText("jTextField1");
        BAHIA.setBorder(null);
        jPanel1.add(BAHIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 50, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setText("PLACA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        PLACA.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jPanel1.add(PLACA, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 160, 60));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        jLabel4.setText("BAHIA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        jButton1.setText("VOLVER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton2.setText("REGISTRAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        rbMoto.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        rbMoto.setText("Motocicleta");
        jPanel1.add(rbMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        rbAuto.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        rbAuto.setText("Automovil");
        jPanel1.add(rbAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setText("Nombre Usuario");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, 20));

        NomUsuario.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        NomUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(NomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 190, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setText("TIPO DE VEHICULO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabel1)
                        .addGap(0, 248, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    // TODO add your handling code here:
    String claseVehiculo = "";
    if(rbAuto.isSelected()){
        claseVehiculo = "Automovil";
    }
    if (rbMoto.isSelected()){
        claseVehiculo = "Motocicleta";
    }
    
    try {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        fechaHora = dateFormat.format(date);
        System.out.print(dateFormat.format(date));
       String updateBahiaSql = "UPDATE bahia SET estado = 'OCUPADO', Placa = ? WHERE IdBahia = ?";
        PreparedStatement updateBahiaPs = aux.prepareStatement(updateBahiaSql);
        updateBahiaPs.setString(1, PLACA.getText());
        updateBahiaPs.setInt(2, Integer.parseInt(BAHIA.getText()));
        updateBahiaPs.executeUpdate();
        
        String discoSql = "INSERT INTO vehiculo (Placa, NombreUsuario, EnumVehiculo, Bahia, HoraEntrada, estado) VALUES ('"+PLACA.getText() +"','"+NomUsuario.getText()+"','"+claseVehiculo+"','"+Integer.valueOf(BAHIA.getText())+"','"+fechaHora+"','DISPONIBLE')";					
        PreparedStatement discoPs = aux.prepareStatement(discoSql);

        // Puedes cambiar "En parqueadero" según tu lógica
        discoPs.executeUpdate(discoSql);

        JOptionPane.showMessageDialog(null,"Vehiculo Registrado");

    } catch(SQLException ex) {
        Logger.getLogger(IngresarVehiculo.class.getName()).log(Level.SEVERE,null,ex);
    } finally {
        try {
            // Cierra la conexión después de ejecutar la consulta
            aux.close();
             this.dispose();
        int codigo = Integer.parseInt(jLabel2.getText());
       IngresarVehiculo loginPrincipal = new IngresarVehiculo();
            loginPrincipal.setLocationRelativeTo(null); // Centra el JFrame en la pantalla
            loginPrincipal.setVisible(true);
            loginPrincipal.setIdAdminValue(codigo);
             
        } catch (SQLException ex) {
            Logger.getLogger(IngresarVehiculo.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
       
   
           String dest = "C:\\Users\\ksant\\Documents\\NetBeansProjects\\parqueadero\\ejemplo.pdf"; 
        try {
            
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc, PageSize.A4);
            pdfDoc.addNewPage(); 
           
            Paragraph para = new Paragraph ("Recibo Parqueadero"); 
            
            para.setBorder(Border.NO_BORDER);
            para.setBold();
             
            Paragraph para1 = new Paragraph ("Placa vehiculo: "+PLACA.getText()); 
            Paragraph para2 = new Paragraph ("Nombre del propietario: "+NomUsuario.getText()); 
            Paragraph para4 = new Paragraph ("Hora de ingreso: "+fechaHora); 
            Paragraph para3 = new Paragraph ("BAHIA: "+BAHIA.getText());
            Paragraph para5 = new Paragraph ("Atendido por: "+jLabel2.getText());
            
            document.add(para); 
            document.add(para1); 
            document.add(para2); 
            document.add(para3); 
            document.add(para4); 
             document.add(para5); 
            
            document.close();
             System.out.println("PDF Created");  
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IngresarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IngresarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {

		if ((new File("C:\\Users\\ksant\\Documents\\NetBeansProjects\\parqueadero\\ejemplo.pdf")).exists()) {

			Process p = Runtime
			   .getRuntime()
			   .exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\ksant\\Documents\\NetBeansProjects\\parqueadero\\ejemplo.pdf");
			p.waitFor();
				
		} else {

			System.out.println("File is not exists");

		}

		System.out.println("Done");

  	  } catch (Exception ex) {
		ex.printStackTrace();
	  }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        this.dispose();
        int codigo = Integer.parseInt(jLabel2.getText());
       InterfazVehiculo loginPrincipal = new InterfazVehiculo();
            loginPrincipal.setLocationRelativeTo(null); // Centra el JFrame en la pantalla
            loginPrincipal.setVisible(true);
            loginPrincipal.setIdAdminValue(codigo);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NomUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(IngresarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BAHIA;
    private javax.swing.JTextField NomUsuario;
    private javax.swing.JTextField PLACA;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
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
    private javax.swing.JRadioButton rbAuto;
    private javax.swing.JRadioButton rbMoto;
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