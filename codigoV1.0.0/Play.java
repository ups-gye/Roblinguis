package practicas_dos;


public class PLAY extends javax.swing.JFrame {


    public PLAY() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        agudas = new javax.swing.JButton();
        graves = new javax.swing.JButton();
        esdru = new javax.swing.JButton();
        sobresdru = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        onli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("camino de la regla de acentuacion");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 280, 40));

        agudas.setText("agudas");
        agudas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agudasActionPerformed(evt);
            }
        });
        getContentPane().add(agudas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        graves.setText("graves");
        graves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gravesActionPerformed(evt);
            }
        });
        getContentPane().add(graves, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));

        esdru.setText("esdrujulas");
        getContentPane().add(esdru, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        sobresdru.setText("sobreesdrujula");
        getContentPane().add(sobresdru, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicas_dos/camino.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 570, 450));

        onli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicas_dos/peq.png"))); // NOI18N
        onli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onliActionPerformed(evt);
            }
        });
        getContentPane().add(onli, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, -1, -1));

        pack();
    }// </editor-fold>                        

    private void agudasActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // Cuando se haga clic en el botón "agudas", se abrirá un área de texto con la información deseada
        // Aquí puedes definir el texto que quieres mostrar
        String informacion = "Son aquellas que tienen acento en la última sílaba. Llevan tilde,\n" +
                            "únicamente, las palabras que terminan en n, s o vocal.\n "
                            +"con tildes: \n "+
                "canción,  inglés,  acabará \n"
                +"sin tildes: \n ";
    
        // Crear un nuevo cuadro de diálogo para mostrar la información
        javax.swing.JOptionPane.showMessageDialog(this, informacion, "Información sobre palabras agudas", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }                                      

    private void gravesActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // Cuando se haga clic en el botón "graves", se abrirá un área de texto con la información deseada
    // Aquí puedes definir el texto que quieres mostrar
        String informacion = "Aquí va la información sobre las palabras graves...";
    
    // Crear un nuevo cuadro de diálogo para mostrar la información
        javax.swing.JOptionPane.showMessageDialog(this, informacion, "Información sobre palabras graves", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }                                      

    private void onliActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // Crear una instancia de la interfaz de ingreso y hacerla visible
        INGRESO ingreso = new INGRESO();
        ingreso.setVisible(true);
    }                                    

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
            java.util.logging.Logger.getLogger(PLAY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PLAY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PLAY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PLAY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PLAY().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton agudas;
    private javax.swing.JButton esdru;
    private javax.swing.JButton graves;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton onli;
    private javax.swing.JButton sobresdru;
    // End of variables declaration                   
}
