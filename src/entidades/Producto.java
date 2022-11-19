package entidades;

/**
 * @author HP
 * @version 1.0
 * @created 19-nov.-2022 14:33:28
 */
public class Producto {

	private int idProd;
	private String nombreProd;
	private double precioProd;
	private int existenciaProd;
	private String fechaVencimiento;

	public Producto(){

	}

    public Producto(int idProd, String nombreProd, double precioProd, int existenciaProd, String fechaVencimiento) {
        this.idProd = idProd;
        this.nombreProd = nombreProd;
        this.precioProd = precioProd;
        this.existenciaProd = existenciaProd;
        this.fechaVencimiento = fechaVencimiento;
    }

	public void finalize() throws Throwable {

	}

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public double getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(double precioProd) {
        this.precioProd = precioProd;
    }

    public int getExistenciaProd() {
        return existenciaProd;
    }

    public void setExistenciaProd(int existenciaProd) {
        this.existenciaProd = existenciaProd;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return  idProd + " " + nombreProd + " =" + precioProd + " " + existenciaProd + " " + fechaVencimiento;
    }
        
        
}//end Producto