package formulario;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import datos.DCliente;
import entidades.Cliente;
import java.sql.*;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FrmCliente extends javax.swing.JFrame {

     private int id;
    private DCliente dcliente = new DCliente();
    private ArrayList<Cliente> lista = new ArrayList<>();
    
    //Declaramos un filtro de datos para la tabla
    TableRowSorter trsFiltro;
    
    
    public FrmCliente() {
        initComponents();
        setLocationRelativeTo(null);
        this.llenarTabla();
    }
    
    private void limpiar(){
        TfNombres.setText("");
        TfApellidos.setText("");
        TfDireccion.setText("");
        TfMunicipio.setText("");
        TfTelefono.setText("");
        TfCorreo.setText("");
        BtnGuardar.setEnabled(true);
        BtnEditar.setEnabled(false);
        BtnEliminar.setEnabled(false);
    }
    
    private void llenarArrayList(){
        if(!lista.isEmpty()){
            lista.clear();
        }
        lista=dcliente.listarCliente();
    }
    
    private void llenarTabla(){
        llenarArrayList();
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        String titulos[] = {"Nombres", "Apellidos", "Dirección", "Teléfono", "Correo eléctronico"};
        dtm.setColumnIdentifiers(titulos);
        for(Cliente c : lista){
            Object[] fila = new Object[]{
                c.getNombreCliente(),
                c.getApellidoCliente(),
                c.getDireccionCliente(),
                c.getCodigoMunicipio(),
                c.getTelefonoCliente(),
                c.getEmailCliente()
            };
            dtm.addRow(fila);
        }
        
        this.TblRegistros.setModel(dtm);
    }
    
    private void filtrarTabla(){
        trsFiltro.setRowFilter(RowFilter.regexFilter(TbDato.getText()));
    }
    
    private void ubicarDatos(){
        int fila = TblRegistros.getSelectedRow();
        id = lista.get(fila).getIdCliente();
        TfNombres.setText(lista.get(fila).getNombreCliente());
        TfApellidos.setText(lista.get(fila).getApellidoCliente());
        TfDireccion.setText(lista.get(fila).getDireccionCliente());
        TfMunicipio.setText(lista.get(fila).getCodigoMunicipio());
        TfTelefono.setText(Integer.toString(lista.get(fila).getTelefonoCliente()));
        TfCorreo.setText(lista.get(fila).getEmailCliente());
        TbPanel.setSelectedIndex(0);
        BtnGuardar.setEnabled(false);
        BtnEditar.setEnabled(true);
        BtnEliminar.setEnabled(true);
        TfNombres.requestFocus();
    }
    
    private void verificarDatosVacios(){
        if(TfNombres.getText().equals("") || TfNombres.getText().length() == 0){
         JOptionPane.showMessageDialog(this, "Por favor verifique que los nombres"
                 + "no esten vacios", "Cliente", JOptionPane.WARNING_MESSAGE);
         TfNombres.requestFocus();
        }
        
        if(TfApellidos.getText().equals("") || TfApellidos.getText().length() == 0){
         JOptionPane.showMessageDialog(this, "Por favor verifique que los apellidos"
                 + "no esten vacios", "Cliente", JOptionPane.WARNING_MESSAGE);
         TfApellidos.requestFocus();
        }
        
        if(TfDireccion.getText().equals("") || TfDireccion.getText().length() == 0){
         JOptionPane.showMessageDialog(this, "Por favor verifique que la dirección"
                 + "no esté vacío", "Cliente", JOptionPane.WARNING_MESSAGE);
         TfDireccion.requestFocus();
        }
        
        if(TfMunicipio.getText().equals("") || TfMunicipio.getText().length() == 0){
         JOptionPane.showMessageDialog(this, "Por favor verifique que el código"
                 + "del municipio no esté vacío", "Cliente", JOptionPane.WARNING_MESSAGE);
         TfMunicipio.requestFocus();
        }
        
        if(TfTelefono.getText().equals("") || TfTelefono.getText().length() == 0){
         JOptionPane.showMessageDialog(this, "Por favor verifique que el teléfono"
                 + "no esté vaío", "Cliente", JOptionPane.WARNING_MESSAGE);
         TfTelefono.requestFocus();
        }
        
        if(TfCorreo.getText().equals("") || TfCorreo.getText().length() == 0){
         JOptionPane.showMessageDialog(this, "Por favor verifique que el correo"
                 + "no esté vacío", "Cliente", JOptionPane.WARNING_MESSAGE);
         TfCorreo.requestFocus();
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        TbPanel = new javax.swing.JTabbedPane();
        Datos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TfTelefono = new javax.swing.JTextField();
        TfDireccion = new javax.swing.JTextField();
        TfApellidos = new javax.swing.JTextField();
        TfNombres = new javax.swing.JTextField();
        TbComandos = new javax.swing.JToolBar();
        BtnNuevo = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnEditar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        TfCorreo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TfMunicipio = new javax.swing.JTextField();
        Registros = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        TbDato = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblRegistros = new javax.swing.JTable();

        jLabel6.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setText("Código cliente:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CLIENTE");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombres: ");

        jLabel2.setText("Apellidos:");

        jLabel3.setText("Dirección:");

        jLabel4.setText("Teléfono:");

        jLabel5.setText("Correo:");

        TbComandos.setRollover(true);

        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/Nuevo.png"))); // NOI18N
        BtnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });
        TbComandos.add(BtnNuevo);

        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/Guardar.png"))); // NOI18N
        BtnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });
        TbComandos.add(BtnGuardar);

        BtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/editar.png"))); // NOI18N
        BtnEditar.setEnabled(false);
        BtnEditar.setFocusable(false);
        BtnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });
        TbComandos.add(BtnEditar);

        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/Eliminar.png"))); // NOI18N
        BtnEliminar.setEnabled(false);
        BtnEliminar.setFocusable(false);
        BtnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        TbComandos.add(BtnEliminar);

        BtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/salida.png"))); // NOI18N
        BtnSalir.setFocusable(false);
        BtnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });
        TbComandos.add(BtnSalir);

        jLabel8.setText("Código Municipio:");

        javax.swing.GroupLayout DatosLayout = new javax.swing.GroupLayout(Datos);
        Datos.setLayout(DatosLayout);
        DatosLayout.setHorizontalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TbComandos, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DatosLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TfNombres)
                    .addComponent(TfApellidos)
                    .addComponent(TfDireccion)
                    .addComponent(TfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TfMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        DatosLayout.setVerticalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(TbComandos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(TfMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        TbPanel.addTab("Datos", Datos);

        jLabel9.setText("Buscar:");

        TbDato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TbDatoKeyTyped(evt);
            }
        });

        TblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblRegistrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblRegistros);

        javax.swing.GroupLayout RegistrosLayout = new javax.swing.GroupLayout(Registros);
        Registros.setLayout(RegistrosLayout);
        RegistrosLayout.setHorizontalGroup(
            RegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrosLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(TbDato, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegistrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        RegistrosLayout.setVerticalGroup(
            RegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrosLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(RegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TbDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        TbPanel.addTab("Registros", Registros);

        getContentPane().add(TbPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        // TODO add your handling code here:
         limpiar();
        TbPanel.setSelectedIndex(0);
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void TbDatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TbDatoKeyTyped
        // TODO add your handling code here:
        TbDato.addKeyListener(new KeyAdapter(){
            public void keyReleased(final KeyEvent e){
                filtrarTabla();
            }
        });
        trsFiltro = new TableRowSorter(TblRegistros.getModel());
        TblRegistros.setRowSorter(trsFiltro);
    }//GEN-LAST:event_TbDatoKeyTyped

    private void TblRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblRegistrosMouseClicked
        // TODO add your handling code here:
        TblRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent e){
            if(e.getClickCount() ==2){
                ubicarDatos();
            }  
        }
        });
    }//GEN-LAST:event_TblRegistrosMouseClicked

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        // TODO add your handling code here:
         this.verificarDatosVacios();
        try{
            Cliente c = new Cliente(0, TfNombres.getText(), TfApellidos.getText(), TfDireccion.getText(),
                    TfMunicipio.getText(), Integer.parseInt(TfTelefono.getText()), TfCorreo.getText());
            if(dcliente.guardarCliente(c)){
                JOptionPane.showMessageDialog(this, "Registro guardado",
                        "Cliente", JOptionPane.INFORMATION_MESSAGE);
                llenarTabla();
                TbPanel.setSelectedIndex(1);
            }else{
              JOptionPane.showMessageDialog(this, "Error al guardar",
                        "Cliente", JOptionPane.WARNING_MESSAGE);  
            }
        }catch(HeadlessException ex){
            System.out.println("Error al intentar guardar: " + ex.getMessage());
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
        // TODO add your handling code here:
        this.verificarDatosVacios();
         Cliente c = new Cliente(id, TfNombres.getText(), TfApellidos.getText(), TfDireccion.getText(),
                   TfMunicipio.getText(), Integer.parseInt(TfTelefono.getText()), TfCorreo.getText());
          if(dcliente.editarCliente(c)){
                JOptionPane.showMessageDialog(this, "Registro Editado",
                        "Cliente", JOptionPane.INFORMATION_MESSAGE);
                llenarTabla();
                TbPanel.setSelectedIndex(1);
            }else{
              JOptionPane.showMessageDialog(this, "Error al editar",
                        "Cliente", JOptionPane.WARNING_MESSAGE);  
            }
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
        this.verificarDatosVacios();
        int resp = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este registro?",
                "Cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resp==0){
            if(dcliente.eliminarCliente(id)){
            JOptionPane.showMessageDialog(this, "Registro eliminado satisfactoriamente",
                        "Cliente", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Error al eliminar",
                        "Cliente", JOptionPane.WARNING_MESSAGE);
            }
         }
        llenarTabla();
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        // TODO add your handling code here:
        /*Intermedia inter = new Intermedia();
        // inter.setEnabled(true);
        Intermedia.ClienteRegistro.setEnabled(true);
        inter.setVisible(true);
        dispose();*/
    }//GEN-LAST:event_BtnSalirActionPerformed

    

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
            Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JPanel Datos;
    private javax.swing.JPanel Registros;
    private javax.swing.JToolBar TbComandos;
    private javax.swing.JTextField TbDato;
    private javax.swing.JTabbedPane TbPanel;
    private javax.swing.JTable TblRegistros;
    private javax.swing.JTextField TfApellidos;
    private javax.swing.JTextField TfCorreo;
    private javax.swing.JTextField TfDireccion;
    private javax.swing.JTextField TfMunicipio;
    private javax.swing.JTextField TfNombres;
    private javax.swing.JTextField TfTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
