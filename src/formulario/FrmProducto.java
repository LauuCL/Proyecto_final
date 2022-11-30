package formulario;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import datos.Conexion;
import datos.DProducto;
import entidades.Producto;
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

public class FrmProducto extends javax.swing.JFrame {

    private int id;
    private DProducto dproducto = new DProducto();
    private ArrayList<Producto> lista = new ArrayList<>();

    //Declaramos un filtro de datos para la tabla
    TableRowSorter trsFiltro;

    public FrmProducto() {
        initComponents();
        setLocationRelativeTo(null);
        this.llenarTabla();
        LlenarComboBox();//Se va a rellenar el combobox cuando inicie el formulario
    }
    
    public void LlenarComboBox(){
        DProducto p = new DProducto();
        CmbProveedor.setModel(p.llenar());//Se llena el combobox
    }

    private void limpiar() {
        TfNombre.setText("");
        TfExistencia.setText("");
        TfFechaVenc.setText("");
        TfPrecio.setText("");
        CmbProveedor.setSelectedIndex(0);
        BtnGuardar.setEnabled(true);
        BtnEditar.setEnabled(false);
        BtnEliminar.setEnabled(false);
    }

    private void llenarArrayList() {
        if (!lista.isEmpty()) {
            lista.clear();
        }
        lista = dproducto.listarProducto();
    }

    private void llenarTabla() {
        llenarArrayList();
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String titulos[] = {"Nombres", "Proveedor","Precio", "Existencia", "Categoría", "Fecha Vencimiento"};
        dtm.setColumnIdentifiers(titulos);
        for (Producto p : lista) {
            Object[] fila = new Object[]{
                p.getNombreProd(),
                p.getCodigoProv(),
                 p.getPrecioProd(),
                p.getExistenciaProd(),
                p.getCategoria(),
                p.getFechaVencimiento()
            };
            dtm.addRow(fila);
        }

        this.TblRegistros.setModel(dtm);
    }

    private void filtrarTabla() {
        trsFiltro.setRowFilter(RowFilter.regexFilter(TbDato.getText()));
    }



    private void ubicarDatos() {
        int fila = TblRegistros.getSelectedRow();
        id = lista.get(fila).getIdProd();
        TfNombre.setText(lista.get(fila).getNombreProd());
        CmbProveedor.setSelectedItem(lista.get(fila).getCodigoProv());
        TfPrecio.setText(Double.toString(lista.get(fila).getPrecioProd()));
        TfExistencia.setText(Integer.toString(lista.get(fila).getExistenciaProd()));
         TfCategoria.setText(lista.get(fila).getCategoria());
        TfFechaVenc.setText(lista.get(fila).getFechaVencimiento());
        TbPanel.setSelectedIndex(0);
        BtnGuardar.setEnabled(false);
        BtnEditar.setEnabled(true);
        BtnEliminar.setEnabled(true);
        TfNombre.requestFocus();
    }

    private void verificarDatosVacios() {
        if (TfNombre.getText().equals("") || TfNombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor verifique que el nombre"
                    + "no esten vacios", "Producto", JOptionPane.WARNING_MESSAGE);
            TfNombre.requestFocus();
        }

        if (TfExistencia.getText().equals("") || TfExistencia.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor verifique que la existencia"
                    + "no esté vacía", "Producto", JOptionPane.WARNING_MESSAGE);
            TfExistencia.requestFocus();
        }

        if (TfFechaVenc.getText().equals("") || TfFechaVenc.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor verifique que la fecha de vencimiento"
                    + " no esté vacío", "Producto", JOptionPane.WARNING_MESSAGE);
            TfFechaVenc.requestFocus();
        }

        if (TfPrecio.getText().equals("") || TfPrecio.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor verifique que el precio"
                    + "no esté vacío", "Producto", JOptionPane.WARNING_MESSAGE);
            TfPrecio.requestFocus();
        }

        if (TfCategoria.getText().equals("") || TfCategoria.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor verifique que la categoría"
                    + "no esté vacía", "Producto", JOptionPane.WARNING_MESSAGE);
            TfPrecio.requestFocus();
        }

        if (CmbProveedor.getSelectedItem().equals(0)) {
            JOptionPane.showMessageDialog(this, "Por favor verifique que haya seleccionado"
                    + "un proveedor", "Producto", JOptionPane.WARNING_MESSAGE);
            CmbProveedor.requestFocus();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        TbPanel = new javax.swing.JTabbedPane();
        Datos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TfPrecio = new javax.swing.JTextField();
        TfExistencia = new javax.swing.JTextField();
        TfNombre = new javax.swing.JTextField();
        TbComandos = new javax.swing.JToolBar();
        BtnNuevo = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnEditar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        TfFechaVenc = new javax.swing.JTextField();
        CmbProveedor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TfCategoria = new javax.swing.JTextField();
        Registros = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        TbDato = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblRegistros = new javax.swing.JTable();

        jLabel6.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setText("Código cliente:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PRODUCTO");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre: ");

        jLabel3.setText("Existencia:");

        jLabel4.setText("Precio:");

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

        jLabel8.setText("Fecha de Vencimiento:");

        jLabel2.setText("Proveedor:");

        jLabel5.setText("Categoría:");

        javax.swing.GroupLayout DatosLayout = new javax.swing.GroupLayout(Datos);
        Datos.setLayout(DatosLayout);
        DatosLayout.setHorizontalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TbComandos, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(DatosLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel2))
                .addGap(50, 50, 50)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addComponent(TfFechaVenc, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(364, Short.MAX_VALUE))
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(TfCategoria, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TfExistencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                                .addComponent(TfNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
                            .addComponent(TfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        DatosLayout.setVerticalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(TbComandos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(TfExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(TfCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TfFechaVenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(91, Short.MAX_VALUE))
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
                .addContainerGap(291, Short.MAX_VALUE))
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

        getContentPane().add(TbPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 820, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        // TODO add your handling code here:
        limpiar();
        TbPanel.setSelectedIndex(0);
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void TbDatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TbDatoKeyTyped
        // TODO add your handling code here:
        TbDato.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                filtrarTabla();
            }
        });
        trsFiltro = new TableRowSorter(TblRegistros.getModel());
        TblRegistros.setRowSorter(trsFiltro);
    }//GEN-LAST:event_TbDatoKeyTyped

    private void TblRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblRegistrosMouseClicked
        // TODO add your handling code here:
        TblRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    ubicarDatos();
                }
            }
        });
    }//GEN-LAST:event_TblRegistrosMouseClicked

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        // TODO add your handling code here:
        this.verificarDatosVacios();
        try {
            Producto p;
            String proveedor = obtenerCodigo();
            p = new Producto(0, TfNombre.getText(), proveedor,
                    Double.parseDouble(TfPrecio.getText()), Integer.parseInt(TfExistencia.getText()),
                    TfCategoria.getText(), TfFechaVenc.getText());
            if (dproducto.guardarProducto(p)) {
                JOptionPane.showMessageDialog(this, "Registro guardado",
                        "Producto", JOptionPane.INFORMATION_MESSAGE);
                llenarTabla();
                TbPanel.setSelectedIndex(1);
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar",
                        "Producto", JOptionPane.WARNING_MESSAGE);
            }
        } catch (HeadlessException ex) {
            System.out.println("Error al intentar guardar: " + ex.getMessage());
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private String obtenerCodigo(){
        String proveedor = CmbProveedor.getSelectedItem().toString();
        String codigoProveedor = "";
        for(int i =0; i<proveedor.length(); i++){
            if(proveedor.charAt(i) == '-'){
                return codigoProveedor.trim();
            }
            codigoProveedor += proveedor.charAt(i);
        }
        return codigoProveedor.trim();
    }
    
    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
        // TODO add your handling code here:
        this.verificarDatosVacios();
        String proveedor = obtenerCodigo();
        Producto p = new Producto(id, TfNombre.getText(), proveedor,
                Double.parseDouble(TfPrecio.getText()), Integer.parseInt(TfExistencia.getText()),
                TfCategoria.getText(), TfFechaVenc.getText());
        if (dproducto.editarProducto(p)) {
            JOptionPane.showMessageDialog(this, "Registro Editado",
                    "Producto", JOptionPane.INFORMATION_MESSAGE);
            llenarTabla();
            TbPanel.setSelectedIndex(1);
        } else {
            JOptionPane.showMessageDialog(this, "Error al editar",
                    "Producto", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
        this.verificarDatosVacios();
        int resp = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este registro?",
                "Producto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp == 0) {
            if (dproducto.eliminarProducto(id)) {
                JOptionPane.showMessageDialog(this, "Registro eliminado satisfactoriamente",
                        "Producto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar",
                        "Producto", JOptionPane.WARNING_MESSAGE);
            }
        }
        llenarTabla();
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        // TODO add your handling code here:
        FrmIntermedia inter = new FrmIntermedia();
        inter.setEnabled(true);
        FrmIntermedia.ClienteRegistro.setEnabled(true);
        inter.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
         int opcion = JOptionPane.showConfirmDialog(null,
                "¿Está seguro que quiere cerrar la aplicación?",
                "Confirmación de cierre", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

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
            Logger.getLogger(FrmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JComboBox<String> CmbProveedor;
    private javax.swing.JPanel Datos;
    private javax.swing.JPanel Registros;
    private javax.swing.JToolBar TbComandos;
    private javax.swing.JTextField TbDato;
    private javax.swing.JTabbedPane TbPanel;
    private javax.swing.JTable TblRegistros;
    private javax.swing.JTextField TfCategoria;
    private javax.swing.JTextField TfExistencia;
    private javax.swing.JTextField TfFechaVenc;
    private javax.swing.JTextField TfNombre;
    private javax.swing.JTextField TfPrecio;
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
