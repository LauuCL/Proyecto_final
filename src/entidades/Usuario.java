package entidades;

/**
 * @author HP
 * @version 1.0
 * @created 19-nov.-2022 14:33:15
 */
public class Usuario {

	private String Usuario;
	private String Contrasena;

	public Usuario(){

	}

        public void finalize() throws Throwable {

	}

    public Usuario(String Usuario, String Contrasena) {
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    @Override
    public String toString() {
        return  Usuario + " " + Contrasena;
    }
        
        
	
}//end Usuario