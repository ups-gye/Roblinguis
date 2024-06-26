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
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class QUIZZ extends javax.swing.JFrame {
    private static final String SERVER_IP = "192.168.100.74"; // Cambia esta dirección IP por la del servidor
    private static final int SERVER_PORT = 9876;
    String newusuario;
    String[] questions ={"Cual es aguda", "cual es grave", "cual es esdrujula","cual es sobreesdrujula", "Cual es la incorrecta"};
    String[][] opinion = {{"luz","cancion","camino","siuu","cancion"},{"penaldo","espera","graba","pessi","penaldo"},{"coña","focus","men","siu","men"},
        {"nouu","yano","qw","invicto","yano"},{"andres","yanez","Alejandro","sigue","sigue"}};
    int index=0, correct= 0;  
    ButtonGroup bg = new ButtonGroup();
    
    public QUIZZ(String newusuario) {
        this.newusuario = newusuario;
        initComponents();
        
        bg.add(resp1);
        bg.add(resp2);
        bg.add(resp3);
        bg.add(resp4);
        
        enviarActionPerformed(null);
    }
    
    public void getSelectedOption(JRadioButton rbtn) {
    
        if(rbtn.getText().equals(opinion[index][4])){
            correct++;
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
        enviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        container.setBackground(new java.awt.Color(255, 255, 255));

        pregu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pregu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pregu.setText("jLabel1");

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pregu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pregu, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        resp1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resp1.setText("jRadioButton1");
        resp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp1ActionPerformed(evt);
            }
        });

        resp2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resp2.setText("jRadioButton2");
        resp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp2ActionPerformed(evt);
            }
        });

        resp3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resp3.setText("jRadioButton3");
        resp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp3ActionPerformed(evt);
            }
        });

        resp4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resp4.setText("jRadioButton4");
        resp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp4ActionPerformed(evt);
            }
        });

        enviar.setBackground(new java.awt.Color(102, 255, 102));
        enviar.setForeground(new java.awt.Color(255, 204, 0));
        enviar.setText("siguiente");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(resp3)
                                    .addComponent(resp2)
                                    .addComponent(resp4))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(resp1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resp2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resp3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resp4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void resp3ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        getSelectedOption(resp3);
    }                                     

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
        if(enviar.getText().equals("Reiniciar preguntas")){
            
            enviar.setText("siguiente");
            container.setBackground(new java.awt.Color(255, 255, 255));          
            index =0;
            correct=0;
        } 
        if(index == questions.length){
            pregu.setText("Tu record: "+correct+" / "+questions.length);
            String mensaje = newusuario + " ha obtenido un record de " + correct + " / " + questions.length;
            if(correct >= (float) questions.length/2){
                container.setBackground(Color.green);
            }else{
                container.setBackground(Color.red);
            }
            
            enviar.setText("Reiniciar preguntas");   
            enviarResultadoAlServidor(mensaje);
        }
        
        else{
            enableRbuttons(true);
            pregu.setText(questions[index]);
            resp1.setText(opinion[index][0]);
            resp2.setText(opinion[index][1]);
            resp3.setText(opinion[index][2]);
            resp4.setText(opinion[index][3]);
            
            if(index ==questions.length-1){
                enviar.setText("Terminar y ver el resultado");
            }
        }
        bg.clearSelection();        
    }                                      

    private void enviarResultadoAlServidor(String mensaje) {
    try {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        DataOutputStream flujoSalida = new DataOutputStream(socket.getOutputStream());
        
        String resultado = "Resultado de " + newusuario + ": " + correct + " / " + questions.length;
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
                new QUIZZ("nombreDeUsuario").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel container;
    private javax.swing.JButton enviar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pregu;
    private javax.swing.JRadioButton resp1;
    private javax.swing.JRadioButton resp2;
    private javax.swing.JRadioButton resp3;
    private javax.swing.JRadioButton resp4;
    // End of variables declaration                   
}
