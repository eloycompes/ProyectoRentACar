package InterfazGrafica.Cliente;

import javax.swing.*;
import GestionClientes.Cliente;

public class VentanaVerCliente extends JFrame {
    public VentanaVerCliente(Cliente cliente) {
        setTitle("Ver Cliente");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        String[][] campos = {
            {"Nombre", cliente.getNombre()},
            {"Apellidos", cliente.getApellidos()},
            {"DNI", cliente.getDni()},
            {"Dirección", cliente.getDireccion()},
            {"Teléfono", cliente.getTelefono()},
            {"Email", cliente.getEmail()}
        };

        for (int i = 0; i < campos.length; i++) {
            JLabel label = new JLabel(campos[i][0] + ":");
            label.setBounds(20, 30 + i * 40, 100, 25);
            add(label);

            JTextField field = new JTextField(campos[i][1]);
            field.setBounds(130, 30 + i * 40, 200, 25);
            field.setEditable(false);
            add(field);
        }

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(130, 300, 100, 30);
        add(btnCerrar);

        btnCerrar.addActionListener(e -> dispose());
    }
}
