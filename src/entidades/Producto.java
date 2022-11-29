package entidades;

/**
 * @author HP
 * @version 1.0
 * @created 19-nov.-2022 14:33:28
 */
public class Producto {

	private int idProd;
	private String nombreProd;
        private String codigoProv;
	private double precioProd;
	private int existenciaProd;
        private String categoria;
	private String fechaVencimiento;
        private Proveedor proveedor;

	public Producto(){

	}

    public Producto(int idProd, String nombreProd, String codigoProv,  double precioProd, int existenciaProd,
            String categoria, String fechaVencimiento) {
        this.idProd = idProd;
        this.nombreProd = nombreProd;
        this.codigoProv = codigoProv;
        this.precioProd = precioProd;
        this.existenciaProd = existenciaProd;
        this.categoria = categoria;
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

    public String getCodigoProv() {
        return codigoProv;
    }

    public void setCodigoProv(String codigoProv) {
        this.codigoProv = codigoProv;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return  idProd + " " + nombreProd + " " + codigoProv + " " + precioProd + " " + existenciaProd + " " +
                categoria + " " + fechaVencimiento;
    }
        
        
}//end Producto