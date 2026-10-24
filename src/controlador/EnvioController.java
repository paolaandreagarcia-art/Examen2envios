package controlador;

import modelo.Envio;
import servicio.ServicioEnvios;
import vista.VentanaEnvios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnvioController implements ActionListener {
    private final VentanaEnvios vista;
    private final ServicioEnvios servicio;

    public EnvioController(VentanaEnvios vista, ServicioEnvios servicio) {
        this.vista = vista;
        this.servicio = servicio;
        this.initController();
    }

    private void initController() {
        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getBtnRetirar().addActionListener(this);
        this.vista.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnGuardar()) {
            guardarEnvio();
        } else if (e.getSource() == vista.getBtnRetirar()) {
            retirarEnvio();
        } else if (e.getSource() == vista.getBtnCancelar()) {
            vista.limpiarFormulario();
        }
    }

    private void guardarEnvio() {
        try {
            String codigo = vista.getTxtCodigo().getText().trim();
            String cliente = vista.getTxtCliente().getText().trim();
            String tipo = (String) vista.getCbTipo().getSelectedItem();

            if (codigo.isEmpty() || cliente.isEmpty() ||
                vista.getTxtPeso().getText().trim().isEmpty() ||
                vista.getTxtDistancia().getText().trim().isEmpty()) {
                vista.mostrarMensaje("Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double peso = Double.parseDouble(vista.getTxtPeso().getText().trim());
            double distancia = Double.parseDouble(vista.getTxtDistancia().getText().trim());

            if (peso <= 0 || distancia <= 0) {
                vista.mostrarMensaje("El peso y la distancia deben ser mayores a cero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            servicio.agregarEnvio(tipo, codigo, cliente, peso, distancia);
            actualizarTabla();
            vista.limpiarFormulario();
            vista.mostrarMensaje("Envío registrado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            vista.mostrarMensaje("Ingrese números válidos para peso y distancia.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            vista.mostrarMensaje(ex.getMessage(), "Error de Validación", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void retirarEnvio() {
        String codigo = vista.getTxtCodigo().getText().trim();
        if (codigo.isEmpty()) {
            vista.mostrarMensaje("Ingrese el número (código) del envío que desea retirar.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean exito = servicio.retirarEnvio(codigo);
        if (exito) {
            actualizarTabla();
            vista.limpiarFormulario();
            vista.mostrarMensaje("Envío eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.mostrarMensaje("El código especificado no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla() {
        vista.getModelTabla().setRowCount(0);
        for (Envio e : servicio.listarEnvios()) {
            vista.getModelTabla().addRow(new Object[]{
                    e.getClass().getSimpleName(),
                    e.getCodigo(),
                    e.getCliente(),
                    e.getPeso(),
                    e.getDistancia(),
                    e.calcularTarifa()
            });
        }
    }
}
