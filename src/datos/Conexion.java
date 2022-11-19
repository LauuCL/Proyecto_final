/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;


import java.sql.*;

/**
 *
 * @author labc205
 */
public class Conexion {
    
    //la unica instancia que existe de esta clase
    private static Conexion conx = null;
    //atributos
    private static Connection con = null;
    private static String url = "jdbc:sqlserver://localhost;"
            + "databaseName=BDLibros;"
            + "Persist Security Info=True;";
    private static String user = "sa";
    private static String password = "123";

    //constructor
    public Conexion() {
        
    }
    
    public static Conexion obtInstancia(){
        //instanciamos la unica instancia de Conexion
        if(conx==null){
            conx = new Conexion();
        }
        return conx;
    }
    
    //metodos
    public static Connection obtConexion(){
        if(estaConectado()==false){
            Conexion.crearConexion();
        }
        return con;
    }
    
    public static boolean estaConectado(){
       
        boolean resp = false;
        try{
           resp=!((con==null) || (con.isClosed())); 
        }catch(Exception e){
            System.out.println("Error al consultar el estado de la conexion:"
                    + e.getMessage());
        }
        return resp;
    }
    
    public static void crearConexion(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con= DriverManager.getConnection(url, user, password);
        }catch(ClassNotFoundException e){
            con=null;
            System.out.println("Error al cargar el driver:" + e.getMessage());
        }catch(SQLException e){
              con=null;
            System.out.println("Error al cargar el driver:" + e.getMessage());
        }
    }
    
    public static void cerrarConexion(Connection con){
        if(estaConectado()!=false){
            try{
                con.close();
            }catch(SQLException e){
                e.printStackTrace();
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }
    
    
}
