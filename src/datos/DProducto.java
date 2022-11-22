/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;


import entidades.Producto;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class DProducto {
    
    
     private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    //Metodos 
    public void obtRegistros(){
        try{
            conn= Conexion.obtConexion();
            String tSQL = "Select * from Producto";
            ps= conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs= ps.executeQuery();
        }catch(SQLException ex){
            System.out.println("Error al obtener registros:" + ex.getMessage());
        }
    }
    
    public ArrayList<Producto> listarProducto(){
        ArrayList<Producto> lista = new ArrayList<>();
        try{
            this.obtRegistros();
            while(rs.next()){
                lista.add(new Producto (
                rs.getInt("Codigo_producto"),
                rs.getString("nombre_producto"),
                rs.getString("codigo_proveedor"),
                rs.getDouble("precio"),
                rs.getInt("existencia"),
                rs.getString("categoria"),
                rs.getString("fechaVencimiento")
                ));
            }
        }catch(SQLException ex){
            System.out.println("Error al listar productos " + ex.getMessage());
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
    
    public boolean guardarProducto(Producto p){
        boolean guardado = false;
        this.obtRegistros();
        try{
            rs.moveToInsertRow();
            rs.updateString("nombre_producto", p.getNombreProd());
            rs.updateString("codigo_proveedor", p.getCodigoProv());
            rs.updateDouble("precio", p.getPrecioProd());
            rs.updateInt("existencia", p.getExistenciaProd());
            rs.updateString("categoria", p.getCategoria());
            rs.updateString("fechaVencimiento", p.getFechaVencimiento());
            rs.insertRow();
            rs.moveToCurrentRow();
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
                
                if(conn!=null){
                    Conexion.cerrarConexion(conn);
                }
                
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        return guardado;
    }
    
    public boolean existeProducto(int id){
        boolean resp=false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("Codigo_producto")== id){
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
    
    public boolean editarProducto(Producto p){
         boolean resp=false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("Codigo_producto")== p.getIdProd()){
                     rs.updateString("nombre_producto", p.getNombreProd());
                     rs.updateString("codigo_proveedor", p.getCodigoProv());
                     rs.updateDouble("precio", p.getPrecioProd());
                     rs.updateInt("existencia", p.getExistenciaProd());
                     rs.updateString("categoria", p.getCategoria());
                     rs.updateString("fechaVencimiento", p.getFechaVencimiento());
                     rs.updateRow();
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
                
                if(conn!=null){
                    Conexion.cerrarConexion(conn);
                }
                
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
         
        }
        return resp;
    }
    
    
    public boolean eliminarProducto(int id){
         boolean resp=false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("Codigo_producto")== id){
                    rs.deleteRow();
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
