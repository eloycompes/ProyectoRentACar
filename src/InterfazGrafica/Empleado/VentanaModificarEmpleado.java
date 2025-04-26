package InterfazGrafica.Empleado;

import javax.swing.*;

import GestionEmpleados.Empleado;
import GestionEmpleados.Rol;

public class VentanaModificarEmpleado extends JFrame {
    private JTextField tfNombre, tfApellidos, tfDni, tfTelefono, tfEmail;
    private JComboBox<Rol> cbRol;
    private int idEmpleadoOriginal;

    public VentanaModificarEmpleado(Empleado empleado, GestionEmpleados padre) {
        setTitle("Modificar Empleado");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 30, 100, 25);
        add(lblNombre);
        tfNombre = new JTextField(empleado.getNombre());
        tfNombre.setBounds(130, 30, 200, 25);
        add(tfNombre);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(20, 70, 100, 25);
        add(lblApellidos);
        tfApellidos = new JTextField(empleado.getApellidos());
        tfApellidos.setBounds(130, 70, 200, 25);
        add(tfApellidos);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(20, 110, 100, 25);
        add(lblDni);
        tfDni = new JTextField(empleado.getDni());
        tfDni.setBounds(130, 110, 200, 25);
        add(tfDni);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(20, 150, 100, 25);
        add(lblTelefono);
        tfTelefono = new JTextField(empleado.getTelefono());
        tfTelefono.setBounds(130, 150, 200, 25);
        add(tfTelefono);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 190, 100, 25);
        add(lblEmail);
        tfEmail = new JTextField(empleado.getEmail());
        tfEmail.setBounds(130, 190, 200, 25);
        add(tfEmail);

        JLabel lblRol = new JLabel("Rol:");
        lblRol.setBounds(20, 230, 100, 25);
        add(lblRol);
        cbRol = new JComboBox<>(Rol.values());
        cbRol.setSelectedItem(empleado.getRol());
        cbRol.setBounds(130, 230, 200, 25);
        add(cbRol);

        JButton btnModificar = new JButton("Modificar empleado");
        btnModificar.setBounds(130, 280, 180, 30);
        add(btnModificar);

        this.idEmpleadoOriginal = empleado.getIdEmpleado();

        btnModificar.addActionListener(e -> {
            empleado.setNombre(tfNombre.getText());
            empleado.setApellidos(tfApellidos.getText());
            empleado.setDni(tfDni.getText());
            empleado.setTelefono(tfTelefono.getText());
            empleado.setEmail(tfEmail.getText());
            empleado.setRol((Rol) cbRol.getSelectedItem());

            Empleado.GuardarCambios();
            padre.actualizarTablaEmpleados();
            dispose();
        });
    }
}
