package formulario;


import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FrmIntermedia extends javax.swing.JFrame {

    public FrmIntermedia() {
        initComponents();
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        JPanelIntermedia = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JmbBotones = new javax.swing.JMenuBar();
        BtnGerente = new javax.swing.JMenu();
        AlmacenRegistro = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        BtnCliente = new javax.swing.JMenu();
        ClienteRegistro = new javax.swing.JMenuItem();
        BtnVendedores = new javax.swing.JMenu();
        EmpleadosRegistrosE = new javax.swing.JMenuItem();
        BtnProveedores = new javax.swing.JMenu();
        RegistroProveedor = new javax.swing.JMenuItem();
        BtnAyuda = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        BtnAcerca = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BIENVENIDO AL SISTEMA");
        setBackground(new java.awt.Color(0, 51, 51));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JPanelIntermedia.setBackground(new java.awt.Color(204, 204, 255));
        JPanelIntermedia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204), 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/Farmacia.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        javax.swing.GroupLayout JPanelIntermediaLayout = new javax.swing.GroupLayout(JPanelIntermedia);
        JPanelIntermedia.setLayout(JPanelIntermediaLayout);
        JPanelIntermediaLayout.setHorizontalGroup(
            JPanelIntermediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        JPanelIntermediaLayout.setVerticalGroup(
            JPanelIntermediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        BtnGerente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/gerente.jpg"))); // NOI18N
        BtnGerente.setText("Gerente");
        BtnGerente.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        AlmacenRegistro.setText("Registro de productos");
        AlmacenRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlmacenRegistroActionPerformed(evt);
            }
        });
        BtnGerente.add(AlmacenRegistro);

        jMenuItem2.setText("Inicio de sesion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        BtnGerente.add(jMenuItem2);

        JmbBotones.add(BtnGerente);

        BtnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/cliente.jpg"))); // NOI18N
        BtnCliente.setText("Cliente");
        BtnCliente.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        ClienteRegistro.setText("Registro de cliente");
        ClienteRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteRegistroActionPerformed(evt);
            }
        });
        BtnCliente.add(ClienteRegistro);

        JmbBotones.add(BtnCliente);

        BtnVendedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/empleado.png"))); // NOI18N
        BtnVendedores.setText("Vendedores");
        BtnVendedores.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        EmpleadosRegistrosE.setText("Registro de Vendedores");
        EmpleadosRegistrosE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpleadosRegistrosEActionPerformed(evt);
            }
        });
        BtnVendedores.add(EmpleadosRegistrosE);

        JmbBotones.add(BtnVendedores);

        BtnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/empleado.png"))); // NOI18N
        BtnProveedores.setText("Proveedores");
        BtnProveedores.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        RegistroProveedor.setText("Registro de proveedores");
        RegistroProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroProveedorActionPerformed(evt);
            }
        });
        BtnProveedores.add(RegistroProveedor);

        JmbBotones.add(BtnProveedores);

        BtnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/Icono_ayuda1.jpg"))); // NOI18N
        BtnAyuda.setText("Ayuda");
        BtnAyuda.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItem3.setText("¿Que es PHARMSYS?");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        BtnAyuda.add(jMenuItem3);

        jMenuItem4.setText("¿Que hacer si el programa funciona lentamente?");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        BtnAyuda.add(jMenuItem4);

        jMenuItem5.setText("¿A quien puedo contactar para solicitar ayuda?");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        BtnAyuda.add(jMenuItem5);

        jMenuItem6.setText("¿Donde puedo enviar comentarios sobre PHARMSYS?");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        BtnAyuda.add(jMenuItem6);

        JmbBotones.add(BtnAyuda);

        BtnAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/acerca.jpg"))); // NOI18N
        BtnAcerca.setText("Acerca de:");
        BtnAcerca.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItem9.setText("Información");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        BtnAcerca.add(jMenuItem9);

        JmbBotones.add(BtnAcerca);

        setJMenuBar(JmbBotones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelIntermedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPanelIntermedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int opcion = JOptionPane.showConfirmDialog(null,
                "Está seguro que quiere cerrar la aplicación?",
                "Confirmación de cierre", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void ClienteRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteRegistroActionPerformed
        FrmCliente infocli = new FrmCliente();
        infocli.setVisible(true);
        this.setVisible(false); 
        ClienteRegistro.setEnabled(false);
    }//GEN-LAST:event_ClienteRegistroActionPerformed

    private void EmpleadosRegistrosEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpleadosRegistrosEActionPerformed

       /* Vendedor vendedor = new Vendedor();
        vendedor.setVisible(true);
        this.setVisible(false); 
        EmpleadosRegistrosE.setEnabled(false);*/

    }//GEN-LAST:event_EmpleadosRegistrosEActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        /*Informacion info = new Informacion();
        info.setVisible(true);
        this.setVisible(false); 
        jMenuItem9.setEnabled(false);*/
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void AlmacenRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlmacenRegistroActionPerformed

        /*Ventas_r.Productos optener = new Ventas_r.Productos();
        optener.setVisible(true);
        this.setVisible(false); 
        AlmacenRegistro.setEnabled(false);*/

    }//GEN-LAST:event_AlmacenRegistroActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FrmInicioSesion iniciar = new FrmInicioSesion();
        iniciar.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JOptionPane.showMessageDialog(null, "PHARMSYS es un sistema o programa que permite a la Farmacia FARMAPLUS desarrollarse en diferentes\n "
                + "actividades. En el sector administativo, llevar control de los productos disponibles en la Farmacia y las actividades\n  "
                + "realizadas por los trabajadores. En el sector de compra y venta, permite llevar un registro de las ventas y agiliza el desarrollo\n "
                + "de esta actividad para que el cliente reciba una mejor atención\n"
        );
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        JOptionPane.showMessageDialog(null, "Todo software instalado en el computador necesita Memoria de Acceso Aleatorio\n"
                + "para funcionar, por lo tanto libere memoria RAM cerrando otros programas abiertos,\n "
                + "reinicie el software, apague y reinicie su computadora\n ");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JOptionPane.showMessageDialog(null, "En cado de presentar problemas con el sistema, contactar a:\n"
                + "Atención General: Operadores -> *123\n"
                + "Propietario de farmacia: Robert Aragón -> Correo: Aragon12@gmail.com, celular: 8833-2901\n "
                + "Gerente de farmacia: Julio Centeno -> correo: Centeno98@gmail.com, celular: 7934-2187 \n");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        JOptionPane.showMessageDialog(null, "En caso de querer dejar un comentario constructivo puede hacerlo entrando\n"
                + "al siguiente correo electrónico: \n"
                + "FranLauLis18@outlook.com\n");
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void RegistroProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroProveedorActionPerformed
        /*Proveedor provee = new Proveedor();
        provee.setVisible(true);
        this.setVisible(false);
        RegistroProveedor.setEnabled(false);*/
    }//GEN-LAST:event_RegistroProveedorActionPerformed

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

            //</editor-fold>
            UIManager.setLookAndFeel(new McWinLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FrmIntermedia.class.getName()).log(Level.SEVERE, null, ex);
        }

        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmIntermedia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenuItem AlmacenRegistro;
    private javax.swing.JMenu BtnAcerca;
    private javax.swing.JMenu BtnAyuda;
    private javax.swing.JMenu BtnCliente;
    private javax.swing.JMenu BtnGerente;
    public static javax.swing.JMenu BtnProveedores;
    private javax.swing.JMenu BtnVendedores;
    public static javax.swing.JMenuItem ClienteRegistro;
    public static javax.swing.JMenuItem EmpleadosRegistrosE;
    private javax.swing.JPanel JPanelIntermedia;
    private javax.swing.JMenuBar JmbBotones;
    public static javax.swing.JMenuItem RegistroProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    public static javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    // End of variables declaration//GEN-END:variables
}
