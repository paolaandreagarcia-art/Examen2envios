import controlador.EnvioController;
import servicio.ServicioEnvios;
import vista.VentanaEnvios;

import javax.swing.SwingUtilities;

public class Logistica {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaEnvios vista = new VentanaEnvios();
            ServicioEnvios servicio = new ServicioEnvios();
            new EnvioController(vista, servicio);
            vista.setVisible(true);
        });
    }
}
