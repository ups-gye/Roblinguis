
package practicas_dos;
import java.io.DataOutputStream;
import java.net.Socket;
public class INGRESO extends javax.swing.JFrame {
    
    public INGRESO() {
        initComponents();
        transparencia();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 510, 400, 50));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 410, 60));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 410, 60));

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 250, 30));

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel1.setText("Nombres:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, -1));

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel3.setText("código de clase:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, -1, -1));

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabel5.setText("Ingresa tu nombre y el código de la clase");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicas_dos/anim/flecha_necha.png"))); // NOI18N
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicas_dos/conceptos/fondo_NGRESO.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String newusuario = jTextField1.getText();
        String codigoClase = jTextField2.getText();

        // Verificar si el código de la clase existe en la base de datos
        CONEX conexion = new CONEX();
        boolean codigoExiste = conexion.verificarCodigoClase(codigoClase);

        if (codigoExiste) {
            boolean insercionExitosa = conexion.insertarUsuarioClase(newusuario, codigoClase);
            if (insercionExitosa) {
                System.out.println("Datos insertados en la base de datos correctamente.");
            } else {
             System.out.println("Error al insertar datos en la base de datos.");
            }

            try {
            // Enviar el nombre de usuario al servidor
                Socket socket = new Socket("localhost", 9876); // Conectar al servidor en localhost y puerto 9876
                DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
                salida.writeUTF(newusuario); // Enviar el nombre de usuario
                salida.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            PLAY playWindow = new PLAY(newusuario);
            playWindow.setVisible(true);
               
            this.dispose();
    } else {
        jLabel2.setText("Código de sala no existe");
    }

        // Cerrar la conexión
        
    }                                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           
    
    public void transparencia(){
        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        
        
        jTextField1.setOpaque(false);
        
        
    }
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
            java.util.logging.Logger.getLogger(INGRESO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INGRESO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INGRESO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INGRESO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INGRESO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration                   
}
