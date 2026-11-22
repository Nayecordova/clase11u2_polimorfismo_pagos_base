/**
 * Superclase base para el sistema de pagos polimórficos.
 * PASO 1: Revisa los atributos protegidos y los métodos definidos aquí.
 * Luego, las subclases deberán heredar de MetodoPago y redefinir los métodos
 * indicados usando @Override.
 */
public class MetodoPago {
    // TODO 1: Declarar atributos protected: referencia (String), titular (String), montoBase (double)
     protected String referencia;
    protected String titular;
    protected double montoBase;
    public MetodoPago(String referencia, String titular, double montoBase) {
        // TODO 2: Validar que referencia y titular no estén vacíos y montoBase > 0
        // Luego asignar los valores a los atributos de la clase
        if (referencia == null || referencia.trim().isEmpty()) {
            throw new IllegalArgumentException("La referencia no puede estar vacía.");
        }
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("El titular no puede estar vacío.");
        }
        if (montoBase <= 0) {
            throw new IllegalArgumentException("El monto base debe ser mayor que 0.");
        }
        this.referencia = referencia.trim();
        this.titular = titular.trim();
        this.montoBase = montoBase;
    }


    public double calcularComision() {
        return 0.0;
    }

    public double calcularTotal() {
        // TODO 3: Retornar montoBase + calcularComision()
        return montoBase + calcularComision();
    }

    public String procesarPago() {
        return "Procesando pago genérico";
    }

    public String mostrarComprobante() {
        // TODO 4: Retornar una cadena con referencia, titular, base, comision, total
        return String.format(
                "Comprobante | Referencia: %s | Titular: %s | Base: %.2f | Comisión: %.2f | Total: %.2f",
                referencia, titular, montoBase, calcularComision(), calcularTotal()
        );
    }

    @Override
    public String toString() {
        return String.format(
                "%s[referencia='%s', titular='%s', montoBase=%.2f, total=%.2f]",
                getClass().getSimpleName(), referencia, titular, montoBase, calcularTotal()
        );
    }
}