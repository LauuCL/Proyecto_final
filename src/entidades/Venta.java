package entidades;

/**
 * @author HP
 * @version 1.0
 * @created 19-nov.-2022 14:33:30
 */
public class Venta {

	private int numeroFactura;
        private String  codigocliente;
        private String codigovendedor;
	private String fechaVenta;
        private String codigoproducto;
	private int cantidad;
	private double descuento;

	public Venta(){

	}

    public Venta(int numeroFactura, String codigocliente, String codigovendedor,
            String fechaVenta, String codigoproducto, int cantidad, double descuento) {
        
        this.numeroFactura = numeroFactura;
        this.codigocliente = codigocliente;
        this.codigovendedor = codigovendedor;
        this.fechaVenta = fechaVenta;
        this.codigoproducto = codigoproducto;
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
        return numeroFactura + " " + codigocliente + " " + codigovendedor + " " + 
                fechaVenta+ " " + codigoproducto + " " + cantidad + " " + descuento;
    }

    public String getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(String codigocliente) {
        this.codigocliente = codigocliente;
    }

    public String getCodigovendedor() {
        return codigovendedor;
    }

    public void setCodigovendedor(String codigovendedor) {
        this.codigovendedor = codigovendedor;
    }

    public String getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(String codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

        
	
}//end Venta