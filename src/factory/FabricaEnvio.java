package factory;

import modelo.Envio;

public abstract class FabricaEnvio {
    public abstract Envio crearEnvio(String codigo, String cliente, double peso, double distancia);
}
