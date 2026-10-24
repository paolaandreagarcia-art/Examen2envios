package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaEnvios extends JFrame {
    private JTextField txtCodigo;
    private JTextField txtCliente;
    private JTextField txtPeso;
    private JTextField txtDistancia;
    private JComboBox<String> cbTipo;
    private JTable tablaEnvios;
    private DefaultTableModel modelTabla;

    private JButton btnGuardar;
    private JButton btnRetirar;
    private JButton btnCancelar;

    public VentanaEnvios() {
        initUI();
    }

    private void initUI() {
        setTitle("Operador Logístico - Gestión de Envíos");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel Formulario
        JPanel panelFormulario = new JPanel(new GridLayout(6, 2, 8, 8));
        panelFormulario.setBorder(BorderFactory.createTitledBorder(" Registrar / Gestionar Envío "));

        panelFormulario.add(new JLabel("Número (Código):"));
        txtCodigo = new JTextField();
        panelFormulario.add(txtCodigo);

        panelFormulario.add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"Terrestre", "Aereo", "Maritimo"});
        panelFormulario.add(cbTipo);

        panelFormulario.add(new JLabel("Cliente:"));
        txtCliente = new JTextField();
        panelFormulario.add(txtCliente);

        panelFormulario.add(new JLabel("Peso (Kg):"));
        txtPeso = new JTextField();
        panelFormulario.add(txtPeso);

        panelFormulario.add(new JLabel("Distancia en Km:"));
        txtDistancia = new JTextField();
        panelFormulario.add(txtDistancia);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnGuardar = new JButton("Guardar");
        btnRetirar = new JButton("Retirar");
        btnCancelar = new JButton("Cancelar");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnRetirar);
        panelBotones.add(btnCancelar);

        panelFormulario.add(new JLabel());
        panelFormulario.add(panelBotones);

        add(panelFormulario, BorderLayout.NORTH);

        // Tabla
        String[] columnas = {"Tipo", "Código", "Cliente", "Peso", "Distancia", "Costo"};
        modelTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaEnvios = new JTable(modelTabla);
        add(new JScrollPane(tablaEnvios), BorderLayout.CENTER);
    }

    public JTextField getTxtCodigo() { return txtCodigo; }
    public JTextField getTxtCliente() { return txtCliente; }
    public JTextField getTxtPeso() { return txtPeso; }
    public JTextField getTxtDistancia() { return txtDistancia; }
    public JComboBox<String> getCbTipo() { return cbTipo; }

    public JButton getBtnGuardar() { return btnGuardar; }
    public JButton getBtnRetirar() { return btnRetirar; }
    public JButton getBtnCancelar() { return btnCancelar; }
    public DefaultTableModel getModelTabla() { return modelTabla; }

    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, tipoMensaje);
    }

    public void limpiarFormulario() {
        txtCodigo.setText("");
        txtCliente.setText("");
        txtPeso.setText("");
        txtDistancia.setText("");
        cbTipo.setSelectedIndex(0);
    }
}
