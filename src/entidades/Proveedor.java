package entidades;

/**
 * @author HP
 * @version 1.0
 * @created 19-nov.-2022 14:33:23
 */
public class Proveedor {

	private int IdProv;
	private String nombreProv;
	private String direccionProv;
	private int telefonoProv;

	public Proveedor(){

	}

    public Proveedor(int IdProv, String nombreProv, String direccionProv, int telefonoProv) {
        this.IdProv = IdProv;
        this.nombreProv = nombreProv;
        this.direccionProv = direccionProv;
        this.telefonoProv = telefonoProv;
    }
        

	public void finalize() throws Throwable {

	}

    public int getIdProv() {
        return IdProv;
    }

    public void setIdProv(int IdProv) {
        this.IdProv = IdProv;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public String getDireccionProv() {
        return direccionProv;
    }

    public void setDireccionProv(String direccionProv) {
        this.direccionProv = direccionProv;
    }

    public int getTelefonoProv() {
        return telefonoProv;
    }

    public void setTelefonoProv(int telefonoProv) {
        this.telefonoProv = telefonoProv;
    }

    @Override
    public String toString() {
        return IdProv + " " + nombreProv + " " + direccionProv + " " + telefonoProv;
    }
               
}//end Proveedor