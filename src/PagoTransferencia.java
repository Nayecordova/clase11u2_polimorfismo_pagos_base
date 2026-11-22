/**
 * Subclase para pagos por transferencia bancaria (tarifa fija de $0.50).
 */
public class PagoTransferencia extends MetodoPago {
    private String bancoOrigen;
    private String numeroComprobante;

    public PagoTransferencia(String referencia, String titular, double montoBase,
                             String bancoOrigen, String numeroComprobante) {
        super(referencia, titular, montoBase);
        if (bancoOrigen == null || bancoOrigen.trim().isEmpty()) {
            throw new IllegalArgumentException("El banco de origen no puede estar vacío.");
        }
        if (numeroComprobante == null || numeroComprobante.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de comprobante no puede estar vacío.");
        }
        this.bancoOrigen = bancoOrigen.trim();
        this.numeroComprobante = numeroComprobante.trim();
    }

    @Override
    public double calcularComision() {
        return 0.50;
    }

    @Override
    public String procesarPago() {
        return String.format("Procesando transferencia desde %s (Comp. %s) por total %.2f",
                bancoOrigen, numeroComprobante, calcularTotal());
    }

    @Override
    public String mostrarComprobante() {
        return super.mostrarComprobante() + String.format(" | Banco: %s | Comprobante #: %s",
                bancoOrigen, numeroComprobante);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [bancoOrigen='%s', numeroComprobante='%s']",
                bancoOrigen, numeroComprobante);
    }
}