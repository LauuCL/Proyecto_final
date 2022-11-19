package entidades;

/**
 * @author HP
 * @version 1.0
 * @created 19-nov.-2022 14:33:33
 */
public class Vendedor {

	private int idVend;
	private String nombreVend;
	private String apellidoVend;
	private String direccionVend;
	private int telefonoVend;
	private String turnoVend;
	

	public Vendedor(){

	}

    public Vendedor(int idVend, String nombreVend, String apellidoVend, String direccionVend, int telefonoVend, String turnoVend) {
        this.idVend = idVend;
        this.nombreVend = nombreVend;
        this.apellidoVend = apellidoVend;
        this.direccionVend = direccionVend;
        this.telefonoVend = telefonoVend;
        this.turnoVend = turnoVend;
    }

    public int getIdVend() {
        return idVend;
    }

    public void setIdVend(int idVend) {
        this.idVend = idVend;
    }

    public String getNombreVend() {
        return nombreVend;
    }

    public void setNombreVend(String nombreVend) {
        this.nombreVend = nombreVend;
    }

    public String getApellidoVend() {
        return apellidoVend;
    }

    public void setApellidoVend(String apellidoVend) {
        this.apellidoVend = apellidoVend;
    }

    public String getDireccionVend() {
        return direccionVend;
    }

    public void setDireccionVend(String direccionVend) {
        this.direccionVend = direccionVend;
    }

    public int getTelefonoVend() {
        return telefonoVend;
    }

    public void setTelefonoVend(int telefonoVend) {
        this.telefonoVend = telefonoVend;
    }

    public String getTurnoVend() {
        return turnoVend;
    }

    public void setTurnoVend(String turnoVend) {
        this.turnoVend = turnoVend;
    }

    @Override
    public String toString() {
        return idVend + " " + nombreVend + " " + apellidoVend + " " + direccionVend + " " + telefonoVend + " " + turnoVend;
    }
	
}//end Vendedor