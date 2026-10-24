package servicio;

import factory.FabricaEnvio;
import factory.RegistroFabricas;
import modelo.Envio;

import java.util.ArrayList;
import java.util.List;

public class ServicioEnvios {
    private final List<Envio> listaEnvios;

    public ServicioEnvios() {
        this.listaEnvios = new ArrayList<>();
    }

    public Envio agregarEnvio(String tipo, String codigo, String cliente, double peso, double distancia) {
        for (Envio e : listaEnvios) {
            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                throw new IllegalArgumentException("Ya existe un envío registrado con el código: " + codigo);
            }
        }
        FabricaEnvio fabrica = RegistroFabricas.getFabrica(tipo);
        Envio nuevoEnvio = fabrica.crearEnvio(codigo, cliente, peso, distancia);
        listaEnvios.add(nuevoEnvio);
        return nuevoEnvio;
    }

    public boolean retirarEnvio(String codigo) {
        return listaEnvios.removeIf(e -> e.getCodigo().equalsIgnoreCase(codigo));
    }

    public List<Envio> listarEnvios() {
        return new ArrayList<>(listaEnvios);
    }
}
