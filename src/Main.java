import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MetodoPago> lotePagos = new ArrayList<>();

        lotePagos.add(new PagoEfectivo("REF-001", "Ana Gómez", 100.0, 120.0));
        lotePagos.add(new PagoTarjeta("REF-002", "Carlos Ruiz", 250.0, "4532", 3));
        lotePagos.add(new PagoTransferencia("REF-003", "María López", 400.0, "Banco Pichincha", "COMP-8891"));
        lotePagos.add(new PagoBilleteraDigital("REF-004", "Luis Vera", 80.0, "Nequi", "@luis.vera"));

        double totalComisiones = 0.0;
        double totalRecaudado = 0.0;

        for (MetodoPago pago : lotePagos) {
            System.out.println(pago.procesarPago());
            System.out.println(pago.mostrarComprobante());
            System.out.println("toString(): " + pago);

            totalComisiones += pago.calcularComision();
            totalRecaudado += pago.calcularTotal();

            System.out.println("--------------------------------------------------");
        }

        System.out.printf("Total Comisiones : %.2f%n", totalComisiones);
        System.out.printf("Total Recaudado  : %.2f%n", totalRecaudado);
    }
}