package factory;

import modelo.Envio;
import modelo.Aereo;

public class FabricaAereo extends FabricaEnvio {
    @Override
    public Envio crearEnvio(String codigo, String cliente, double peso, double distancia) {
        return new Aereo(codigo, cliente, peso, distancia);
    }
}
