package factory;

import modelo.Envio;
import modelo.Maritimo;

public class FabricaMaritimo extends FabricaEnvio {
    @Override
    public Envio crearEnvio(String codigo, String cliente, double peso, double distancia) {
        return new Maritimo(codigo, cliente, peso, distancia);
    }
}
