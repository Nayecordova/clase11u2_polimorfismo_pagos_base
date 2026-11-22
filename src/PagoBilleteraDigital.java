/**
 * Subclase para pagos por billetera digital (1.5% con tope máximo de $3.00).
 */
public class PagoBilleteraDigital extends MetodoPago {
    private String proveedor;
    private String aliasUsuario;

    public PagoBilleteraDigital(String referencia, String titular, double montoBase,
                                String proveedor, String aliasUsuario) {
        super(referencia, titular, montoBase);
        if (proveedor == null || proveedor.trim().isEmpty()) {
            throw new IllegalArgumentException("El proveedor no puede estar vacío.");
        }
        if (aliasUsuario == null || aliasUsuario.trim().isEmpty()) {
            throw new IllegalArgumentException("El alias de usuario no puede estar vacío.");
        }
        this.proveedor = proveedor.trim();
        this.aliasUsuario = aliasUsuario.trim();
    }

    @Override
    public double calcularComision() {
        return Math.min(montoBase * 0.015, 10.0);
    }

    @Override
    public String procesarPago() {
        return String.format("Procesando débito de billetera digital (%s - %s) por total %.2f",
                proveedor, aliasUsuario, calcularTotal());
    }

    @Override
    public String mostrarComprobante() {
        return super.mostrarComprobante() + String.format(" | Proveedor: %s | Alias: %s",
                proveedor, aliasUsuario);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [proveedor='%s', aliasUsuario='%s']",
                proveedor, aliasUsuario);
    }
}
