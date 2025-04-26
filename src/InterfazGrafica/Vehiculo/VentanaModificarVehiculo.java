package InterfazGrafica.Vehiculo;

import javax.swing.*;
import GestionVehiculos.*;
import java.awt.event.ActionEvent;

public class VentanaModificarVehiculo extends JFrame {
    private JTextField tfModelo, tfFechaMatriculacion;
    private JComboBox<String> cbTipo, cbCategoria;
    private int idVehiculoOriginal;

    public VentanaModificarVehiculo(Vehiculo vehiculo, GestionVehiculos padre) {
        setTitle("Modificar Vehículo");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        // Modelo
        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(20, 30, 100, 25);
        add(lblModelo);
        tfModelo = new JTextField(vehiculo.getModelo());
        tfModelo.setBounds(130, 30, 200, 25);
        add(tfModelo);

        // Fecha de Matriculación
        JLabel lblFecha = new JLabel("Fecha Matriculación:");
        lblFecha.setBounds(20, 70, 150, 25);
        add(lblFecha);
        tfFechaMatriculacion = new JTextField(vehiculo.getFechaMatriculacion().toString());
        tfFechaMatriculacion.setBounds(170, 70, 160, 25);
        add(tfFechaMatriculacion);

        // Categoria del vehículo
        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setBounds(20, 110, 100, 25);
        add(lblCategoria);
        cbCategoria = new JComboBox<>(new String[]{"Turismo", "Furgoneta", "Motocicleta"});
        cbCategoria.setSelectedItem(vehiculo.getCategoria().toString());
        cbCategoria.setBounds(130, 110, 200, 25);
        add(cbCategoria);

        // Tipo de Vehículo
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(20, 150, 100, 25);
        add(lblTipo);
        cbTipo = new JComboBox<>();
        actualizarTiposVehiculo(vehiculo.getCategoria());
        cbTipo.setSelectedItem(vehiculo.getTipoVehiculos().toString());
        cbTipo.setBounds(130, 150, 200, 25);
        add(cbTipo);

        // Botón de Modificación
        JButton btnModificar = new JButton("Modificar vehículo");
        btnModificar.setBounds(130, 200, 180, 30);
        add(btnModificar);

        this.idVehiculoOriginal = vehiculo.getIdVehiculo();

        // Acción del botón de Modificar
        btnModificar.addActionListener((ActionEvent e) -> {
            try {
                // Actualizamos los datos del vehículo
                vehiculo.setModelo(tfModelo.getText());
                vehiculo.setFechaMatriculacion(java.time.LocalDate.parse(tfFechaMatriculacion.getText()));

                // Obtener la categoría seleccionada y actualizar los tipos disponibles
                String categoriaSeleccionada = (String) cbCategoria.getSelectedItem();
                CategoriaVehiculo categoriaVehiculo = CategoriaVehiculo.valueOf(categoriaSeleccionada.toUpperCase());

                // Obtener el tipo seleccionado
                String tipoSeleccionado = (String) cbTipo.getSelectedItem();
                TiposVehiculos tipoVehiculo = TiposVehiculos.getTipoPorNombre(tipoSeleccionado);

                // Actualizar categoría y tipo
                vehiculo.setCategoria(categoriaVehiculo);
                vehiculo.setTipoVehiculos(tipoVehiculo);

                // Guardar los cambios
                Vehiculo.GuardarCambios();
                padre.actualizarTablaVehiculos();
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Listener para cambiar los tipos cuando se cambie la categoría
        cbCategoria.addActionListener(e -> {
            String categoriaSeleccionada = (String) cbCategoria.getSelectedItem();
            CategoriaVehiculo categoriaVehiculo = CategoriaVehiculo.valueOf(categoriaSeleccionada.toUpperCase());
            actualizarTiposVehiculo(categoriaVehiculo);
        });
    }

    // Método para actualizar los tipos disponibles según la categoría seleccionada
    private void actualizarTiposVehiculo(CategoriaVehiculo categoria) {
        cbTipo.removeAllItems();

        // Cargar los tipos de vehículos dependiendo de la categoría seleccionada
        switch (categoria) {
            case TURISMO:
                cbTipo.addItem("Pequeño");
                cbTipo.addItem("Mediano");
                cbTipo.addItem("Lujo");
                break;
            case FURGONETA:
                cbTipo.addItem("Estandar");
                cbTipo.addItem("GranCarga");
                break;
            case MOTOCICLETA:
                cbTipo.addItem("Motocicleta");
                break;
        }
    }
}
