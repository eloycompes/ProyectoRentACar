package InterfazGrafica.Vehiculo;

import javax.swing.*;
import GestionVehiculos.*;

public class VentanaVerVehiculo extends JFrame {

    public VentanaVerVehiculo(Vehiculo vehiculo) {
        setTitle("Ver Vehículo");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        // Campos para mostrar la información del vehículo
        String[][] campos = {
            {"Modelo", vehiculo.getModelo()},
            {"Fecha Matriculación", vehiculo.getFechaMatriculacion().toString()},
            {"Categoría", vehiculo.getCategoria().toString()},
            {"Tipo", vehiculo.getTipoVehiculos().toString()},
            {"Precio Día", String.valueOf(vehiculo.getTipoVehiculos().getPrecioDia())}
        };

        // Crear los JLabel y JTextField para mostrar los datos
        for (int i = 0; i < campos.length; i++) {
            JLabel label = new JLabel(campos[i][0] + ":");
            label.setBounds(20, 30 + i * 40, 150, 25);
            add(label);

            JTextField field = new JTextField(campos[i][1]);
            field.setBounds(170, 30 + i * 40, 200, 25);
            field.setEditable(false);
            add(field);
        }

        // Botón para cerrar la ventana
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(130, 300, 100, 30);
        add(btnCerrar);

        // Acción del botón de Cerrar
        btnCerrar.addActionListener(e -> dispose());
    }
}
