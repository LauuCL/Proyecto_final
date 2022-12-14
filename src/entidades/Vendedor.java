package entidades;

/**
 * @author HP
 * @version 1.0
 * @created 19-nov.-2022 14:33:33
 */
public class Vendedor {

	private String idVend;
	private String nombreVend;
	private String apellidoVend;
	private String direccionVend;
        private String codigoMunicipio;
	private int telefonoVend;
	private String turnoVend;
	

	public Vendedor(){

	}

    public Vendedor(String idVend, String nombreVend, String apellidoVend, String direccionVend, 
            String codigoMunicipio, int telefonoVend, String turnoVend) {
        this.idVend = idVend;
        this.nombreVend = nombreVend;
        this.apellidoVend = apellidoVend;
        this.direccionVend = direccionVend;
        this.codigoMunicipio = codigoMunicipio;
        this.telefonoVend = telefonoVend;
        this.turnoVend = turnoVend;
    }

    public String getIdVend() {
        return idVend;
    }

    public void setIdVend(String idVend) {
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

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
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
        return idVend + " " + nombreVend + " " + apellidoVend + " " + direccionVend + " " +
                codigoMunicipio + " " + telefonoVend + " " + turnoVend;
    }
	
}//end Vendedor