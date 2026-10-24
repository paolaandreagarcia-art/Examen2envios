package modelo;

public class Aereo extends Envio {
    private static final double TARIFA_BASE_KM = 5000.0;
    private static final double RECARGO_KG = 4000.0;

    public Aereo(String codigo, String cliente, double peso, double distancia) {
        super(codigo, cliente, peso, distancia);
    }

    @Override
    public double calcularTarifa() {
        return (getDistancia() * TARIFA_BASE_KM) + (getPeso() * RECARGO_KG);
    }
}
