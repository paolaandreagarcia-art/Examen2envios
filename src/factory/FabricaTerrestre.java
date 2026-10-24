package factory;

import modelo.Envio;
import modelo.Terrestre;

public class FabricaTerrestre extends FabricaEnvio {
    @Override
    public Envio crearEnvio(String codigo, String cliente, double peso, double distancia) {
        return new Terrestre(codigo, cliente, peso, distancia);
    }
}
