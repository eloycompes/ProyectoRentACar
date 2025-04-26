package InterfazGrafica.Vehiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

import GestionVehiculos.*;

public class GestionVehiculos extends JPanel {

    private JTable tablaVehiculos;

    public GestionVehiculos(JFrame padre) {
        setLayout(null);

        Vehiculo.LeerDisco();;

        // ==== Panel Alta Vehículo ==== 
        JPanel panelAlta = new JPanel();
        panelAlta.setBorder(BorderFactory.createTitledBorder("Nuevo Vehículo"));
        panelAlta.setLayout(null);
        panelAlta.setBounds(20, 20, 364, 280);
        add(panelAlta);

        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setBounds(20, 30, 100, 25);
        panelAlta.add(lblCategoria);

        JComboBox<String> cbCategoria = new JComboBox<>(new String[]{"Turismo", "Motocicleta", "Furgoneta"});
        cbCategoria.setBounds(130, 30, 200, 25);
        panelAlta.add(cbCategoria);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(20, 70, 100, 25);
        panelAlta.add(lblTipo);

        JComboBox<String> cbTipo = new JComboBox<>();
        cbTipo.setBounds(130, 70, 200, 25);
        panelAlta.add(cbTipo);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(20, 110, 100, 25);
        panelAlta.add(lblModelo);

        JTextField tfModelo = new JTextField();
        tfModelo.setBounds(130, 110, 200, 25);
        panelAlta.add(tfModelo);

        JLabel lblFecha = new JLabel("Fecha Matriculación:");
        lblFecha.setBounds(20, 150, 150, 25);
        panelAlta.add(lblFecha);

        JTextField tfFecha = new JTextField("2023-01-01");
        tfFecha.setBounds(170, 150, 160, 25);
        panelAlta.add(tfFecha);

        JButton btnAltaVehiculo = new JButton("Dar de alta");
        btnAltaVehiculo.setBounds(130, 190, 120, 30);
        panelAlta.add(btnAltaVehiculo);

        // Actualizar tipos según categoría seleccionada
        cbCategoria.addActionListener((ActionEvent e) -> {
            String categoriaSeleccionada = (String) cbCategoria.getSelectedItem();
            cbTipo.removeAllItems(); // Limpiar tipos anteriores

            switch (categoriaSeleccionada) {
                case "Turismo":
                    for (TiposVehiculos tipo : TiposVehiculos.getTipoTurismo()) {
                        cbTipo.addItem(tipo.getTipo());
                    }
                    break;
                case "Furgoneta":
                    for (TiposVehiculos tipo : TiposVehiculos.getTipoFurgoneta()) {
                        cbTipo.addItem(tipo.getTipo());
                    }
                    break;
                case "Motocicleta":
                    for (TiposVehiculos tipo : TiposVehiculos.getTipoMotocicleta()) {
                        cbTipo.addItem(tipo.getTipo());
                    }
                    break;
            }
        });

        btnAltaVehiculo.addActionListener((ActionEvent e) -> {
            String categoriaStr = (String) cbCategoria.getSelectedItem();
            String tipoStr = (String) cbTipo.getSelectedItem();
            String modelo = tfModelo.getText();
            String fechaStr = tfFecha.getText();

            Vehiculo vehiculo = null;
            TiposVehiculos tipoVehiculo = TiposVehiculos.getTipoPorNombre(tipoStr);

            switch (categoriaStr.toUpperCase()) {
                case "TURISMO":
                    try {
                        vehiculo = new Turismo(tipoVehiculo, modelo, java.time.LocalDate.parse(fechaStr));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "MOTOCICLETAS":
                    try {
                        vehiculo = new Motocicleta(tipoVehiculo, modelo, java.time.LocalDate.parse(fechaStr));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "FURGONETA":
                    try {
                        vehiculo = new Furgoneta(tipoVehiculo, modelo, java.time.LocalDate.parse(fechaStr));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }

            if (vehiculo != null) {
                Vehiculo.Insertar(vehiculo);
                Vehiculo.GuardarCambios();
                actualizarTablaVehiculos();

                tfModelo.setText("");
                tfFecha.setText("2023-01-01");
            }
        });

        // ==== Panel Listado Vehículos ==== 
        JPanel panelListado = new JPanel(new BorderLayout());
        panelListado.setBorder(BorderFactory.createTitledBorder("Vehículos registrados"));
        panelListado.setBounds(404, 20, 546, 280);
        add(panelListado);

        String[] columnas = {"ID", "Tipo", "Modelo", "Fecha Mat.", "Precio/Día"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        tablaVehiculos = new JTable(model);
        JScrollPane scroll = new JScrollPane(tablaVehiculos);
        panelListado.add(scroll, BorderLayout.CENTER);

        actualizarTablaVehiculos();

        // ==== Botones ==== 
        JButton btnModificar = new JButton("Modificar vehículo");
        btnModificar.setBounds(404, 320, 200, 30);
        add(btnModificar);
        btnModificar.addActionListener(e -> {
            int row = tablaVehiculos.getSelectedRow();
            if (row != -1) {
                int id = (int) tablaVehiculos.getValueAt(row, 0);
                Vehiculo vehiculo = Vehiculo.Leer(id);
                if (vehiculo != null) {
                    new VentanaModificarVehiculo(vehiculo, this).setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un vehículo para modificar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });
        
        JButton btnVer = new JButton("Ver vehículo");
        btnVer.setBounds(617, 320, 160, 30);
        add(btnVer);
        btnVer.addActionListener(e -> {
            int row = tablaVehiculos.getSelectedRow();
            if (row != -1) {
                int id = (int) tablaVehiculos.getValueAt(row, 0);
                Vehiculo vehiculo = Vehiculo.Leer(id);
                if (vehiculo != null) {
                    new VentanaVerVehiculo(vehiculo).setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un vehículo para ver.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });
        JButton btnEliminar = new JButton("Eliminar vehículo");
        btnEliminar.setBounds(790, 320, 160, 30);
        add(btnEliminar);
        btnEliminar.addActionListener(e -> {
            int row = tablaVehiculos.getSelectedRow();
            if (row != -1) {
                int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres eliminar este vehículo?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    int id = (int) tablaVehiculos.getValueAt(row, 0);
                    Vehiculo.Eliminar(id);
                    Vehiculo.GuardarCambios();
                    actualizarTablaVehiculos();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un vehículo para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public void actualizarTablaVehiculos() {
        Vehiculo.LeerDisco();
        List<Vehiculo> lista = Vehiculo.getListaVehiculos();

        DefaultTableModel model = (DefaultTableModel) tablaVehiculos.getModel();
        model.setRowCount(0);

        for (Vehiculo v : lista) {
            model.addRow(new Object[]{
                v.getIdVehiculo(),
                v.getCategoria(),
                v.getModelo(),
                v.getFechaMatriculacion(),
                v.getPrecioDia()
            });
        }
    }
}
