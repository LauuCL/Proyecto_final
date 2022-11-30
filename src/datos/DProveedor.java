/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Proveedor;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class DProveedor {
    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    //Metodos 
    public void obtRegistros(){
        try{
            conn= Conexion.obtConexion();
            String tSQL = "Select * from Proveedor";
            ps= conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs= ps.executeQuery();
        }catch(SQLException ex){
            System.out.println("Error al obtener registros:" + ex.getMessage());
        }
    }
    
    public ArrayList<Proveedor> listarProveedor(){
        ArrayList<Proveedor> lista = new ArrayList<>();
        try{
            this.obtRegistros();
            while(rs.next()){
                lista.add(new Proveedor (
                rs.getString("codigo_proveedor"),
                rs.getString("nombre"),
                rs.getString("Direccion"),
                rs.getString("Codigo_Municipio"),
                rs.getInt("telefono")
                ));
            }
        }catch(SQLException ex){
            System.out.println("Error al listar proveedores " + ex.getMessage());
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
    
    public boolean guardarProveedor(Proveedor p){
        boolean guardado = false;
        this.obtRegistros();
        try{
            rs.moveToInsertRow();
            rs.updateString("codigo_proveedor", p.getIdProv());
            rs.updateString("nombre", p.getNombreProv());
            rs.updateString("Direccion", p.getDireccionProv());
            rs.updateString("Codigo_Municipio", p.getCodigoMunicipio());
            rs.updateInt("telefono", p.getTelefonoProv());
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
    
    public boolean existeProveedor(int id){
        boolean resp=false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("codigo_proveedor")== id){
                    resp=true;
                    break;
                }
            }
        }catch(SQLException ex){
            System.out.println("Error al buscar el proveedor: " + ex.getMessage());
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
    
    public boolean editarProveedor(Proveedor p){
         boolean resp=false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getString("codigo_proveedor").equals(p.getIdProv())){
                     rs.updateString("nombre", p.getNombreProv());
                     rs.updateString("Direccion", p.getDireccionProv());
                     rs.updateString("Codigo_Municipio", p.getCodigoMunicipio());
                     rs.updateInt("telefono", p.getTelefonoProv());
                     rs.updateRow();
                    resp=true;
                    break;
                }
            }
        }catch(SQLException ex){
            System.out.println("Error al editar: " + ex.getMessage().toString());
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
    
    
    public boolean eliminarProveedor(String id){
         boolean resp=false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getString("codigo_proveedor").equals(id)){
                    rs.deleteRow();
                    resp=true;
                    break;
                }
            }
        }catch(SQLException ex){
            System.out.println("Error al eliminar el proveedor: " + ex.getMessage());
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
