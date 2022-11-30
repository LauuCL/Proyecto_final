/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;


import entidades.Venta;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class DVenta {
    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private PreparedStatement ps2 = null;
    private ResultSet rs2 = null;
    
    //Metodos 
    public void obtRegistrosVenta(){
        try{
            conn= Conexion.obtConexion();
            String tSQL = "Select * from Venta";
            ps= conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs= ps.executeQuery();
        }catch(SQLException ex){
            System.out.println("Error al obtener registros:" + ex.getMessage());
        }
    }
    
    public void obtRegistrosDetalleVenta(){
        try{
            conn= Conexion.obtConexion();
            String tSQL = "SELECT dbo.Venta.Codigo_venta, dbo.Venta.Codigo_cliente, dbo.Venta.Codigo_vendedor, "
                    + "dbo.Venta.Fecha_venta, dbo.Detalle_venta.Codigo_producto, dbo.Detalle_venta.Cantidad, dbo.Detalle_venta.Descuento\n" +
               "FROM dbo.Venta INNER JOIN\n" +
               "dbo.Detalle_venta ON dbo.Venta.Codigo_venta = dbo.Detalle_venta.Codigo_venta";
            ps2= conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs2= ps2.executeQuery();
        }catch(SQLException ex){
            System.out.println("Error al obtener registros:" + ex.getMessage());
        }
    }
    
    
    
    public DefaultComboBoxModel llenar() {
      DefaultComboBoxModel modelo = new DefaultComboBoxModel();
      modelo.addElement("Seleccione");
      try{
          CallableStatement cst = Conexion.obtConexion().prepareCall("{CALL LlenarComboVendedor}");
          ResultSet rs= cst.executeQuery();
          while(rs.next()){//Realizamos un recorrido
               String vendedor = rs.getString(1) + " - " + rs.getString(2);
            modelo.addElement(vendedor);//Agregamos los datos encontrados
          }
      }catch(Exception e){
          System.out.println("Error: " + e.getMessage());
      }
        return modelo;
      
    }
    
    public ArrayList<Venta> listarVenta(){
        ArrayList<Venta> lista = new ArrayList<>();
        try{
            this.obtRegistrosDetalleVenta();
            while(rs2.next()){
                lista.add(new Venta (
                rs2.getString("Codigo_venta"),
                rs2.getString("Codigo_cliente"),
                rs2.getString("Codigo_vendedor"),
                rs2.getString("Fecha_venta"),
                rs2.getString("Codigo_producto"),
                rs2.getInt("Cantidad"),
                rs2.getDouble("Descuento")
                ));
            }
        }catch(SQLException ex){
            System.out.println("Error al listar venta " + ex.getMessage());
        }finally{
            
            try{
                if(rs!=null){
                    rs.close();
                }
                
                if(ps!=null){
                    ps.close();
                }
                
                if(conn!=null){
                    Conexion.cerrarConexion(conn);
                }
                
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        return lista;
    }
    
    public boolean guardarVenta(Venta v){
        boolean guardado = false;
        this.obtRegistrosVenta();
        this.obtRegistrosDetalleVenta();
        try{
            rs.moveToInsertRow();
            rs.updateString("Codigo_venta", v.getNumeroFactura());
            rs.updateString("Codigo_cliente", v.getCodigocliente());
            rs.updateString("Codigo_vendedor", v.getCodigovendedor());
            rs.updateString("Fecha_venta", v.getFechaVenta());
            rs2.updateString("Codigo_producto", v.getCodigoproducto());
            rs2.updateInt("Cantidad", v.getCantidad());
            rs2.updateDouble("Descuento", v.getDescuento());
            rs.insertRow();
            rs.moveToCurrentRow();
            rs2.insertRow();
            rs2.moveToCurrentRow();
            guardado= true;
        }catch(SQLException ex){
            System.out.println("Error al guardar el proveedor: " + ex.getMessage());
        }finally{
            
        } try{
                if(rs!=null){
                    rs.close();
                }
                
                if(ps!=null){
                    ps.close();
                }
                
                 if(rs2!=null){
                    rs2.close();
                }
                
                if(ps2!=null){
                    ps2.close();
                }
                
                if(conn!=null){
                    Conexion.cerrarConexion(conn);
                }
                
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        return guardado;
    }
    
    public boolean existeVenta(int id){
        boolean resp=false;
        this.obtRegistrosVenta();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("Codigo_venta")== id){
                    resp=true;
                    break;
                }
            }
        }catch(SQLException ex){
            System.out.println("Error al buscar el producto: " + ex.getMessage());
        }
        
        finally{
            
         try{
                if(rs!=null){
                    rs.close();
                }
                
                if(ps!=null){
                    ps.close();
                }
                
                if(conn!=null){
                    Conexion.cerrarConexion(conn);
                }
                
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
         
        }
        return resp;
    }
    
    public boolean editarVenta(Venta v){
         boolean resp=false;
        this.obtRegistrosVenta();
        this.obtRegistrosDetalleVenta();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getString("Codigo_venta")== v.getNumeroFactura()){
                    rs.updateString("Codigo_cliente", v.getCodigocliente());
                    rs.updateString("Codigo_vendedor", v.getCodigovendedor());
                    rs.updateString("Fecha_venta", v.getFechaVenta());
                     rs.updateRow();
                    resp=true;
                    break;
                }
            }
            
            rs2.beforeFirst();
            while(rs2.next()){
                if(rs2.getString("Codigo_venta")== v.getNumeroFactura()){
                   rs2.updateString("Codigo_producto", v.getCodigoproducto());
                   rs2.updateInt("Cantidad", v.getCantidad());
                   rs2.updateDouble("Descuento", v.getDescuento());
                    rs2.updateRow();
                    resp=true;
                    break;
                }
            }
            
        }catch(SQLException ex){
            System.out.println("Error al editar: " + ex.getMessage());
        }
        
        finally{
            
         try{
                if(rs!=null){
                    rs.close();
                }
                
                if(ps!=null){
                    ps.close();
                }
                
                
                if(rs2!=null){
                    rs2.close();
                }
                
                if(ps2!=null){
                    ps2.close();
                }
                
                if(conn!=null){
                    Conexion.cerrarConexion(conn);
                }
                
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
         
        }
        return resp;
    }
    
    
    public boolean eliminarVenta(int id){
         boolean resp=false;
        this.obtRegistrosVenta();
        this.obtRegistrosDetalleVenta();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("Codigo_venta")== id){
                    rs.deleteRow();
                    resp=true;
                    break;
                }
            }
            
            rs2.beforeFirst();
            while(rs2.next()){
                if(rs2.getInt("Codigo_venta")== id){
                    rs2.deleteRow();
                    resp=true;
                    break;
                }
            }
        }catch(SQLException ex){
            System.out.println("Error al eliminar el producto: " + ex.getMessage());
        }
        
        finally{
            
         try{
                if(rs!=null){
                    rs.close();
                }
                
                if(ps!=null){
                    ps.close();
                }
                
                  if(rs2!=null){
                    rs2.close();
                }
                
                if(ps2!=null){
                    ps2.close();
                }
                
                if(conn!=null){
                    Conexion.cerrarConexion(conn);
                }
                
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
         
        }
        return resp;
    }
}
