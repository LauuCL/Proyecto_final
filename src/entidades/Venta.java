package entidades;

/**
 * @author HP
 * @version 1.0
 * @created 19-nov.-2022 14:33:30
 */
public class Venta {

	private int numeroFactura;
	private String fechaVenta;
	private int cantidad;
	private double descuento;

	public Venta(){

	}

    public Venta(int numeroFactura, String fechaVenta, int cantidad, double descuento) {
        this.numeroFactura = numeroFactura;
        this.fechaVenta = fechaVenta;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return numeroFactura + " " + fechaVenta + " " + cantidad + " " + descuento;
    }

        
	
}//end Venta