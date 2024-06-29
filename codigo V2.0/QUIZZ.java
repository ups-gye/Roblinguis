/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package practicas_dos;
import java.awt.Color;
import java.net.Socket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.DataOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import practicas_dos.CONEX.Opcion;
import practicas_dos.CONEX.Pregunta;


public class QUIZZ extends javax.swing.JFrame {
    
    private static final String SERVER_IP = "172.18.177.18"; // Cambia esta dirección IP por la del servidor
    private static final int SERVER_PORT = 9876;
    private CONEX conex;
    private String newusuario;
    private int testId;
    int index=0, correct= 0;  
    private List<Pregunta> preguntas;
    ButtonGroup bg = new ButtonGroup();
    
    public QUIZZ(String newusuario, int testId) {
        this.newusuario = newusuario;
        this.testId = testId;
        this.conex = new CONEX();
        initComponents();
        
        bg.add(resp1);
        bg.add(resp2);
        bg.add(resp3);
        bg.add(resp4);
        
        cargarPreguntas();
        mostrarPregunta();
    }
    
    private void cargarPreguntas() {
        preguntas = conex.obtenerPreguntasYOpcionesPorTestId(testId);
    }
    
    private void mostrarPregunta() {
        if (index < preguntas.size()) {
            Pregunta pregunta = preguntas.get(index);
            pregu.setText(pregunta.getTexto());
            List<Opcion> opciones = pregunta.getOpciones();
            resp1.setText(opciones.get(0).getTexto());
            resp2.setText(opciones.get(1).getTexto());
            resp3.setText(opciones.get(2).getTexto());
            resp4.setText(opciones.get(3).getTexto());
            enableRbuttons(true);
        } else {
            mostrarResultado();
        }
        bg.clearSelection();
    }
    
     private void getSelectedOption(JRadioButton rbtn) {
        CONEX.Pregunta pregunta = preguntas.get(index);
        for (CONEX.Opcion opcion : pregunta.getOpciones()) {
            if (opcion.getTexto().equals(rbtn.getText()) && opcion.esCorrecta()) {
                correct++;
                break;
            }
        }
        index++;
        enableRbuttons(false);
    }
    
    public void enableRbuttons(boolean yes_or_no){
        resp1.setEnabled(yes_or_no);
        resp2.setEnabled(yes_or_no);
        resp3.setEnabled(yes_or_no);
        resp4.setEnabled(yes_or_no);
        
    }
    
     private void mostrarResultado() {
        pregu.setText("Tu record: " + correct + " / " + preguntas.size());
        String mensaje = newusuario + " ha obtenido un record de " + correct + " / " + preguntas.size();
        if (correct >= (float) preguntas.size() / 2) {
            container.setBackground(Color.green);
        } else {
            container.setBackground(Color.red);
        }

        enviar.setText("Reiniciar preguntas");
        enviarResultadoAlServidor(mensaje);
        conex.actualizarNotaUsuario(newusuario, correct);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        container = new javax.swing.JPanel();
        pregu = new javax.swing.JLabel();
        resp1 = new javax.swing.JRadioButton();
        resp2 = new javax.swing.JRadioButton();
        resp3 = new javax.swing.JRadioButton();
        resp4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        enviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        container.setBackground(new java.awt.Color(255, 255, 255));

        pregu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pregu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pregu.setText("jLabel1");

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(pregu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pregu, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(container, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 430, 150));

        resp1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resp1.setText("jRadioButton1");
        resp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp1ActionPerformed(evt);
            }
        });
        jPanel1.add(resp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 468, -1));

        resp2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resp2.setText("jRadioButton2");
        resp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp2ActionPerformed(evt);
            }
        });
        jPanel1.add(resp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, -1, -1));

        resp3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resp3.setText("jRadioButton3");
        resp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp3ActionPerformed(evt);
            }
        });
        jPanel1.add(resp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, -1, -1));

        resp4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resp4.setText("jRadioButton4");
        resp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp4ActionPerformed(evt);
            }
        });
        jPanel1.add(resp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 670, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicas_dos/anim/QUIZZPEQU.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 810));

        enviar.setBackground(new java.awt.Color(102, 255, 102));
        enviar.setForeground(new java.awt.Color(255, 204, 0));
        enviar.setText("siguiente");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302))
        );

        pack();
    }// </editor-fold>                        

    private void resp3ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        getSelectedOption(resp3);
    }                                     

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
        if (enviar.getText().equals("Reiniciar preguntas")) {
            enviar.setText("siguiente");
            container.setBackground(new java.awt.Color(255, 255, 255));
            index = 0;
            correct = 0;
            cargarPreguntas();
        } else if (index == preguntas.size()) {
            mostrarResultado();
        } else {
            mostrarPregunta();
            if (index == preguntas.size() - 1) {
                enviar.setText("Terminar y ver el resultado");
            }
        }
        
    }                                      

    private void enviarResultadoAlServidor(String mensaje) {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            DataOutputStream flujoSalida = new DataOutputStream(socket.getOutputStream());

            String resultado = "Resultado de " + newusuario + ": " + correct + " / " + preguntas.size();
            flujoSalida.writeUTF(resultado);
            flujoSalida.writeUTF(mensaje);

            flujoSalida.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void resp1ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        
        getSelectedOption(resp1);
        
    }                                     

    private void resp2ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        getSelectedOption(resp2);
    }                                     

    private void resp4ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        getSelectedOption(resp4);
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
            java.util.logging.Logger.getLogger(QUIZZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QUIZZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QUIZZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QUIZZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QUIZZ("nombreDeUsuario",1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel container;
    private javax.swing.JButton enviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pregu;
    private javax.swing.JRadioButton resp1;
    private javax.swing.JRadioButton resp2;
    private javax.swing.JRadioButton resp3;
    private javax.swing.JRadioButton resp4;
    // End of variables declaration                   
    
   
}

