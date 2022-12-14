package formulario;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import datos.Conexion;
import datos.DProducto;
import datos.DVenta;
import entidades.Venta;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class FrmVenta extends javax.swing.JFrame {

    private String id;
    public static DefaultTableModel nueva_tabla = new DefaultTableModel();
    private DVenta dventa = new DVenta();
    private ArrayList<Venta> lista = new ArrayList<>();
    
     //Declaramos un filtro de datos para la tabla
    TableRowSorter trsFiltro;

    public FrmVenta() {
        Venta v = new Venta();
        initComponents();
        setLocationRelativeTo(null);
        CargarTablaProducto();
        LlenarComboBox();//Se va a rellenar el combobox cuando inicie el formulario
       

    }
    
    
     public void LlenarComboBox(){
        DVenta p = new DVenta();
        CmbVendedor.setModel(p.llenar());//Se llena el combobox
    }
     
   /* public void LlenarTextfield(){
          Conexion con = new Conexion();
   try {
        PreparedStatement ps = Conexion.obtConexion().prepareStatement("Select Codigo_venta from Venta");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){//Realizamos un recorrido
       this.TfVenta.setText(rs.getString("Codigo_producto"));
        }
   } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
       }
     }*/
     
     
      public void CargarTablaProducto(){
        
          DefaultTableModel dtm = (DefaultTableModel) TblProducto.getModel();
          dtm.setRowCount(0);
           ResultSet rs;
           ResultSetMetaData rsmd;
           int columnas;
    

        try{
            Conexion con = new Conexion();
            
             PreparedStatement pst = Conexion.obtConexion().prepareStatement("Select Codigo_producto, precio,"
                     + "nombre_producto, existencia from Producto");
             rs = pst.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            while(rs.next()){
                Object[] filas = new Object[columnas];
               for(int i = 0; i<columnas; i++){
                   filas[i] = rs.getObject(i+1);
               }
                
                dtm.addRow(filas);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
      
      private String obtenerCodigo(){
        String proveedor = CmbVendedor.getSelectedItem().toString();
        String codigoProveedor = "";
        for(int i =0; i<proveedor.length(); i++){
            if(proveedor.charAt(i) == '-'){
                return codigoProveedor.trim();
            }
            codigoProveedor += proveedor.charAt(i);
        }
        return codigoProveedor.trim();
    }
      
      public void CargarTablaProductoAdquirido(){
        
          DefaultTableModel dtm = (DefaultTableModel) TblProductosAdquiridos.getModel();
          dtm.setRowCount(0);
          
           ResultSet rs;
           ResultSetMetaData rsmd;
           int columnas;
    

        try{
            Conexion con = new Conexion();
            
             CallableStatement cst = Conexion.obtConexion().prepareCall("{Call Cargar_TablaVenta (?)}");
             cst.setString(1, (TfVenta.getText()));
             rs = cst.executeQuery();
             rsmd = rs.getMetaData();
             columnas = rsmd.getColumnCount();
            while(rs.next()){
                Object[] filas = new Object[columnas];
               for(int i = 0; i<columnas; i++){
                   filas[i] = rs.getObject(i + 1);
               }
                
                dtm.addRow(filas);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
     
      private void limpiar() {
        TfFecha.setText("");
        TfDescuento.setText("");
        TfCantidad.setText("");
        TfPrecio.setText("");
        TfTotalProducto.setText("");
        TfTotal.setText("");
        TfEfectivo.setText("");
        TfCambio.setText("");
        CmbVendedor.setSelectedIndex(0);
    }

    private void llenarArrayList() {
        if (!lista.isEmpty()) {
            lista.clear();
        }
        lista = dventa.listarVenta();
    }

  
    private void verificarDatosVacios() {
        
         if (TfVenta.getText().equals("") || TfVenta.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor verifique que el n??mero de factura"
                    + "no est?? vac??a", "Venta", JOptionPane.WARNING_MESSAGE);
            TfVenta.requestFocus();
        }
         
         
        if (TfFecha.getText().equals("") || TfFecha.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor verifique que la fecha"
                    + "no est?? vac??a", "Venta", JOptionPane.WARNING_MESSAGE);
            TfFecha.requestFocus();
        }

        if (TfCantidad.getText().equals("") || TfCantidad.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor verifique que la cantidad"
                    + "no est?? vac??a", "Venta", JOptionPane.WARNING_MESSAGE);
            TfCantidad.requestFocus();
        }

        if (TfEfectivo.getText().equals("") || TfEfectivo.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor verifique que el efectivo"
                    + " no est?? vac??o", "Venta", JOptionPane.WARNING_MESSAGE);
            TfEfectivo.requestFocus();
        }


        if (CmbVendedor.getSelectedItem().equals(0)) {
            JOptionPane.showMessageDialog(this, "Por favor verifique que haya seleccionado"
                    + "un vendedor", "Venta", JOptionPane.WARNING_MESSAGE);
            CmbVendedor.requestFocus();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        Datos = new javax.swing.JPanel();
        DatosCliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TfCodigoCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TfFecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TfVenta = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CmbVendedor = new javax.swing.JComboBox<>();
        DatosVenta = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TfProducto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TfDescuento = new javax.swing.JTextField();
        DatosPago = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        TfTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TfEfectivo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TfCambio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TfCantidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TfPrecio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TfTotalProducto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblProductosAdquiridos = new javax.swing.JTable();
        TfGuardar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnCalcular = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblProducto = new javax.swing.JTable();
        TbComandos = new javax.swing.JToolBar();
        BtnSalir = new javax.swing.JButton();
        BtnRegistros = new javax.swing.JButton();
        BtnAgregarProducto1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FACTURACION");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Datos.setBackground(new java.awt.Color(204, 204, 255));
        Datos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DatosCliente.setBackground(new java.awt.Color(204, 204, 204));
        DatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        DatosCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("C??dula del cliente:");
        DatosCliente.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, 20));
        DatosCliente.add(TfCodigoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 150, -1));
        TfCodigoCliente.getAccessibleContext().setAccessibleName("TfCodigoCliente");

        jLabel5.setText("Fecha:");
        DatosCliente.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, 20));
        DatosCliente.add(TfFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 100, -1));

        jLabel6.setText("Factura No:");
        DatosCliente.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));
        DatosCliente.add(TfVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 110, 30));

        jLabel14.setText("Atendido por:");
        DatosCliente.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        DatosCliente.add(CmbVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 140, -1));

        Datos.add(DatosCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 420, 140));
        DatosCliente.getAccessibleContext().setAccessibleName("Registro de venta");
        DatosCliente.getAccessibleContext().setAccessibleParent(DatosCliente);

        DatosVenta.setBackground(new java.awt.Color(204, 204, 204));
        DatosVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        DatosVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Producto:");
        DatosVenta.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        TfProducto.setEditable(false);
        TfProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DatosVenta.add(TfProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 136, -1));

        jLabel15.setText("Descuento:");
        DatosVenta.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        DatosVenta.add(TfDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 130, 30));

        DatosPago.setBackground(new java.awt.Color(204, 204, 255));
        DatosPago.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total de la compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        DatosPago.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Total:");
        DatosPago.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 28, -1, -1));

        TfTotal.setEditable(false);
        DatosPago.add(TfTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 24, 140, -1));

        jLabel8.setText("Efectivo:");
        DatosPago.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));
        DatosPago.add(TfEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 70, 130, -1));

        jLabel9.setText("Cambio");
        DatosPago.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        TfCambio.setEditable(false);
        DatosPago.add(TfCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 120, 130, -1));

        DatosVenta.add(DatosPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 230, 170));

        jLabel10.setText("Cantidad:");
        DatosVenta.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));
        DatosVenta.add(TfCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 140, -1));

        jLabel11.setText("Precio:");
        DatosVenta.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        TfPrecio.setEditable(false);
        DatosVenta.add(TfPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 130, -1));

        jLabel12.setText("TOTAL:");
        DatosVenta.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));
        DatosVenta.add(TfTotalProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 130, 30));

        Datos.add(DatosVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 740, 200));

        TblProductosAdquiridos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 204)));
        TblProductosAdquiridos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TblProductosAdquiridos.setForeground(new java.awt.Color(255, 0, 0));
        TblProductosAdquiridos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C??digo", "Medicamento", "Precio", "Cantidad", "Total"
            }
        ));
        TblProductosAdquiridos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblProductosAdquiridosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TblProductosAdquiridos);

        Datos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 420, 100));

        TfGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TfGuardar.setText("Guardar");
        TfGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfGuardarActionPerformed(evt);
            }
        });
        Datos.add(TfGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 140, -1));

        BtnEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        Datos.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 130, -1));

        BtnCalcular.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnCalcular.setText("Calcular");
        BtnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCalcularActionPerformed(evt);
            }
        });
        Datos.add(BtnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, 140, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        TblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C??digo", "Precio", "Medicamento"
            }
        ));
        TblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblProducto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Datos.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        TbComandos.setRollover(true);

        BtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/salida.png"))); // NOI18N
        BtnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });
        TbComandos.add(BtnSalir);

        BtnRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formularios/iconos/editar.png"))); // NOI18N
        BtnRegistros.setFocusable(false);
        BtnRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnRegistros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrosActionPerformed(evt);
            }
        });
        TbComandos.add(BtnRegistros);

        Datos.add(TbComandos, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 530, 100, 40));

        BtnAgregarProducto1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnAgregarProducto1.setText("Agregar");
        BtnAgregarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarProducto1ActionPerformed(evt);
            }
        });
        Datos.add(BtnAgregarProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 130, -1));

        getContentPane().add(Datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
         int opcion = JOptionPane.showConfirmDialog(null,
                "??Est?? seguro que quiere cerrar la aplicaci??n?",
                "Confirmaci??n de cierre", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        // TODO add your handling code here:
        FrmIntermedia inter = new FrmIntermedia();
        inter.setEnabled(true);
        FrmIntermedia.ClienteRegistro.setEnabled(true);
        inter.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void TblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblProductoMouseClicked
        int clic_tabla = TblProducto.rowAtPoint(evt.getPoint());

        String precio = "" + TblProducto.getValueAt(clic_tabla, 1);
        String codigo = "" + TblProducto.getValueAt(clic_tabla, 0);

        TfProducto.setText(String.valueOf(codigo));
        TfPrecio.setText(String.valueOf(precio));
    }//GEN-LAST:event_TblProductoMouseClicked

    private void BtnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCalcularActionPerformed

        int total = 0;
        float cambio;

        for (int i = 0; i < TblProductosAdquiridos.getRowCount(); i++) {
            Double fila = Double.parseDouble(TblProductosAdquiridos.getValueAt(i, 3).toString());
            total += fila;
        }
        try {
            TfTotal.setText(String.valueOf(total));
            Double cad1 = Double.parseDouble(TfEfectivo.getText());
            if (total > cad1) {
                JOptionPane.showMessageDialog(null, "Su dinero es insuficiente");
                TfCambio.setText("");
            } else {
                cambio = (float) (cad1 - total);
                TfCambio.setText(String.valueOf(cambio));
            }

        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite con cu??anto paga el usuario");
        }
    }//GEN-LAST:event_BtnCalcularActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
       try{
            Conexion con = new Conexion();
            PreparedStatement ps;
            ResultSet rs = null;
            
            CallableStatement cst = Conexion.obtConexion().prepareCall("{CALL Eliminar_DetalleVenta (?)}");
            cst.setString(1,(TfVenta.getText()));
            
            cst.executeQuery();
            boolean entra = false;
           
            JOptionPane.showMessageDialog(this, "Registro Eliminado");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void TfGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfGuardarActionPerformed
       Conexion con = new Conexion();
       
        try{
             String proveedor = obtenerCodigo();
            CallableStatement cst = Conexion.obtConexion().prepareCall("{CALL Ingresar_Venta (?,?,?,?)}");
            cst.setString(1, (TfVenta.getText()));
            cst.setString(2, (TfCodigoCliente.getText()));
            cst.setString(3, (proveedor));
            cst.setString(4, (TfFecha.getText()));
            cst.executeUpdate();
            boolean entra = false;
           
            JOptionPane.showMessageDialog(this, "Venta Registrado Correctamente");
            
          // LlenarTextfield();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
            
    }//GEN-LAST:event_TfGuardarActionPerformed

    private void BtnAgregarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarProducto1ActionPerformed
        // TODO add your handling code here:
        Conexion con = new Conexion();
        
        try{
            
            int Total1 = (Integer.parseInt(TfPrecio.getText()) * Integer.parseInt(TfCantidad.getText()));
            TfTotalProducto.setText(String.valueOf(Total1));
                 
            CallableStatement cst = Conexion.obtConexion().prepareCall("{CALL Ingresar_DetalleVenta (?,?,?,?)}");
            cst.setString(1,(TfVenta.getText()));
            cst.setInt(2, Integer.parseInt(TfProducto.getText()));
            cst.setInt(3, Integer.parseInt(TfCantidad.getText()));
            cst.setInt(4, Integer.parseInt(TfDescuento.getText()));
            cst.executeUpdate();
            boolean entra = false;
            
             CargarTablaProductoAdquirido();
            JOptionPane.showMessageDialog(this, "Producto registrado correctamente");
           
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
         
         if (TfDescuento.equals(0)){
             int total = 0;
             for (int i= 0; i<TblProductosAdquiridos.getRowCount(); i++){
                 Double fi = Double.parseDouble(TblProductosAdquiridos.getValueAt(i, 4).toString());
                 total += fi;
                 TfTotal.setText(String.valueOf(total));
             }
         }else{
              int total = 0;
             for (int i= 0; i<TblProductosAdquiridos.getRowCount(); i++){
                 Double fi = Double.parseDouble(TblProductosAdquiridos.getValueAt(i, 4).toString());
                 total += fi;
                 Double desc = (total * (Double.parseDouble(TfDescuento.getText())/100));
                 Double Total1 = total - desc;
                 TfTotal.setText(String.valueOf(Total1));
             }
         }
        
    }//GEN-LAST:event_BtnAgregarProducto1ActionPerformed

    private void TblProductosAdquiridosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblProductosAdquiridosMouseClicked
        // TODO add your handling code here:
        try{
            Conexion con = new Conexion();
            PreparedStatement ps;
            ResultSet rs = null;
            
            int fila = TblProductosAdquiridos.rowAtPoint(evt.getPoint());
            
            CallableStatement cst = Conexion.obtConexion().prepareCall("{CALL Mouse_ClickedProductoAdquirido (?)}");
            cst.setString(1,(TblProductosAdquiridos.getValueAt(fila, 0).toString()));
            
          rs =  cst.executeQuery();
           
            while(rs.next()){
                TfProducto.setText(rs.getString("Codigo_producto"));
                TfPrecio.setText(rs.getString("precio"));
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_TblProductosAdquiridosMouseClicked

    private void BtnRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrosActionPerformed
        // TODO add your handling code here:
        FrmRegistrosVenta venta = new FrmRegistrosVenta();
        venta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BtnRegistrosActionPerformed

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
            Logger.getLogger(FrmVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarProducto1;
    private javax.swing.JButton BtnCalcular;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnRegistros;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JComboBox<String> CmbVendedor;
    private javax.swing.JPanel Datos;
    private javax.swing.JPanel DatosCliente;
    private javax.swing.JPanel DatosPago;
    private javax.swing.JPanel DatosVenta;
    private javax.swing.JToolBar TbComandos;
    private javax.swing.JTable TblProducto;
    private javax.swing.JTable TblProductosAdquiridos;
    private javax.swing.JTextField TfCambio;
    private javax.swing.JTextField TfCantidad;
    public static javax.swing.JTextField TfCodigoCliente;
    private javax.swing.JTextField TfDescuento;
    private javax.swing.JTextField TfEfectivo;
    private javax.swing.JTextField TfFecha;
    private javax.swing.JButton TfGuardar;
    private javax.swing.JTextField TfPrecio;
    private javax.swing.JTextField TfProducto;
    private javax.swing.JTextField TfTotal;
    private javax.swing.JTextField TfTotalProducto;
    private javax.swing.JTextField TfVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
