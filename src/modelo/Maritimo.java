package modelo;

public class Maritimo extends Envio {
    private static final double TARIFA_BASE_KM = 800.0;
    private static final double RECARGO_KG = 1000.0;

    public Maritimo(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public double calcularTarifa() {
        return (getDistancia() * TARIFA_BASE_KM) + (getPeso() * RECARGO_KG);
    }
}
