/**
 * Subclase para pagos con tarjeta de crédito o débito (comisión 3.5%).
 */
public class PagoTarjeta extends MetodoPago {
    private String ultimosDigitos;
    private int cuotas;

    public PagoTarjeta(String referencia, String titular, double montoBase,
                       String ultimosDigitos, int cuotas) {
        super(referencia, titular, montoBase);
        if (ultimosDigitos == null || ultimosDigitos.trim().length() != 4) {
            throw new IllegalArgumentException("Los últimos dígitos deben tener 4 caracteres.");
        }
        if (cuotas < 1) {
            throw new IllegalArgumentException("Las cuotas deben ser al menos 1.");
        }
        this.ultimosDigitos = ultimosDigitos.trim();
        this.cuotas = cuotas;
    }

    @Override
    public double calcularComision() {
        return montoBase * 0.035;
    }

    @Override
    public String procesarPago() {
        return String.format("Procesando cargo con tarjeta ****%s en %d cuota(s) por %.2f",
                ultimosDigitos, cuotas, calcularTotal());
    }

    @Override
    public String mostrarComprobante() {
        return super.mostrarComprobante() + String.format(" | Tarjeta: ****%s | Cuotas: %d",
                ultimosDigitos, cuotas);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [ultimosDigitos='%s', cuotas=%d]",
                ultimosDigitos, cuotas);
    }
}