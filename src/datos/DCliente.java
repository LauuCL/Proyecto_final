/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Cliente;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class DCliente {
    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    //Metodos 
    public void obtRegistros(){
        try{
            conn= Conexion.obtConexion();
            String tSQL = "Select * from Cliente";
            ps= conn.prepareStatement(tSQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs= ps.executeQuery();
        }catch(SQLException ex){
            System.out.println("Error al obtener registros:" + ex.getMessage());
        }
    }
    
    public ArrayList<Cliente> listarCliente(){
        ArrayList<Cliente> lista = new ArrayList<>();
        try{
            this.obtRegistros();
            while(rs.next()){
                lista.add(new Cliente (
                rs.getString("Codigo_cliente"),
                rs.getString("Nombre"),
                rs.getString("Apellido"),
                rs.getString("Direccion"),
                rs.getString("Codigo_Municipio"),
                rs.getInt("telefono"),
                rs.getString("Correo")
                ));
            }
        }catch(SQLException ex){
            System.out.println("Error al listar cliente " + ex.getMessage());
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
    
    public boolean guardarCliente(Cliente c){
        boolean guardado = false;
        this.obtRegistros();
        try{
            rs.moveToInsertRow();
            rs.updateString("Codigo_cliente", c.getIdCliente());
            rs.updateString("Nombre", c.getNombreCliente());
            rs.updateString("Apellido", c.getApellidoCliente());
            rs.updateString("Direccion", c.getDireccionCliente());
            rs.updateString("Codigo_Municipio", c.getCodigoMunicipio());
            rs.updateInt("telefono", c.getTelefonoCliente());
            rs.updateString("Correo", c.getEmailCliente());
            rs.insertRow();
            rs.moveToCurrentRow();
            guardado= true;
        }catch(SQLException ex){
            System.out.println("Error al guardar el cliente: " + ex.getMessage());
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
    
    public boolean existeCliente(int id){
        boolean resp=false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("Codigo_cliente")== id){
                    resp=true;
                    break;
                }
            }
        }catch(SQLException ex){
            System.out.println("Error al buscar el cliente: " + ex.getMessage());
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
    
    public boolean editarCliente(Cliente c){
         boolean resp=false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getString("Codigo_cliente")== c.getIdCliente()){
                     rs.updateString("Nombre", c.getNombreCliente());
                     rs.updateString("Apellido", c.getApellidoCliente());
                     rs.updateString("Direccion", c.getDireccionCliente());
                     rs.updateString("Codigo_Municipio", c.getCodigoMunicipio());
                     rs.updateInt("telefono", c.getTelefonoCliente());
                     rs.updateString("Correo", c.getEmailCliente());
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
    
    
    public boolean eliminarCliente(String id){
         boolean resp=false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getString("Codigo_cliente")== id){
                    rs.deleteRow();
                    resp=true;
                    break;
                }
            }
        }catch(SQLException ex){
            System.out.println("Error al eliminar el cliente: " + ex.getMessage());
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
