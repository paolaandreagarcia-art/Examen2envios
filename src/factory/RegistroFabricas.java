package factory;

import java.util.HashMap;
import java.util.Map;

public class RegistroFabricas {
    private static final Map<String, FabricaEnvio> fabricas = new HashMap<>();

    static {
        fabricas.put("Terrestre", new FabricaTerrestre());
        fabricas.put("Aereo", new FabricaAereo());
        fabricas.put("Maritimo", new FabricaMaritimo());
    }

    public static FabricaEnvio getFabrica(String tipo) {
        FabricaEnvio fabrica = fabricas.get(tipo);
        if (fabrica == null) {
            throw new IllegalArgumentException("Tipo de envío no soportado: " + tipo);
        }
        return fabrica;
    }

    public static void registrarFabrica(String tipo, FabricaEnvio fabrica) {
        fabricas.put(tipo, fabrica);
    }
}
