package entidades;

/**
 * @author HP
 * @version 1.0
 * @created 19-nov.-2022 14:33:31
 */
public class Cliente {

	private int idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String direccionCliente;
	private int telefonoCliente;
	private String emailCliente;

    public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String direccionCliente, int telefonoCliente, String emailCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
    }
	
        public void finalize() throws Throwable {

	}

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    @Override
    public String toString() {
        return idCliente + " "+ nombreCliente + " " +  apellidoCliente + " " + direccionCliente + " "
                + telefonoCliente + " " + emailCliente;
    }
        
        
        
}//end Cliente