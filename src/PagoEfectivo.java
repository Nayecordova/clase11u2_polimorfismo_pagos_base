/**
 * Subclase para pagos en efectivo.
 * PASO 2: Aplicar herencia (extends MetodoPago) y sobreescribir métodos con @Override.
 */

public class PagoEfectivo extends MetodoPago {
    private double montoRecibido;

    public PagoEfectivo(String referencia, String titular, double montoBase, double montoRecibido) {
        super(referencia, titular, montoBase);
        if (montoRecibido < montoBase) {
            throw new IllegalArgumentException("El monto recibido no puede ser menor al monto base.");
        }
        this.montoRecibido = montoRecibido;
    }

    @Override
    public double calcularComision() {
        return 0.0;
    }

    @Override
    public String procesarPago() {
        double cambio = montoRecibido - calcularTotal();
        return String.format("Procesando pago en efectivo | Recibido: %.2f | Cambio: %.2f",
                montoRecibido, Math.max(0.0, cambio));
    }

    @Override
    public String mostrarComprobante() {
        return super.mostrarComprobante() + String.format(" | Recibido: %.2f", montoRecibido);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [montoRecibido=%.2f]", montoRecibido);
    }
}
 