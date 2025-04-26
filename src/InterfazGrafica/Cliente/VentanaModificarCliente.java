package InterfazGrafica.Cliente;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import GestionClientes.Cliente;

public class VentanaModificarCliente extends JFrame {
    private JTextField tfNombre, tfApellidos, tfDni, tfDireccion, tfTelefono, tfEmail;
    private int idClienteOriginal;

    public VentanaModificarCliente(Cliente cliente, GestionClientes padre) {
        setTitle("Modificar Cliente");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 30, 100, 25);
        add(lblNombre);
        tfNombre = new JTextField(cliente.getNombre());
        tfNombre.setBounds(130, 30, 200, 25);
        add(tfNombre);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(20, 70, 100, 25);
        add(lblApellidos);
        tfApellidos = new JTextField(cliente.getApellidos());
        tfApellidos.setBounds(130, 70, 200, 25);
        add(tfApellidos);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(20, 110, 100, 25);
        add(lblDni);
        tfDni = new JTextField(cliente.getDni());
        tfDni.setBounds(130, 110, 200, 25);
        add(tfDni);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(20, 150, 100, 25);
        add(lblDireccion);
        tfDireccion = new JTextField(cliente.getDireccion());
        tfDireccion.setBounds(130, 150, 200, 25);
        add(tfDireccion);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(20, 190, 100, 25);
        add(lblTelefono);
        tfTelefono = new JTextField(cliente.getTelefono());
        tfTelefono.setBounds(130, 190, 200, 25);
        add(tfTelefono);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 230, 100, 25);
        add(lblEmail);
        tfEmail = new JTextField(cliente.getEmail());
        tfEmail.setBounds(130, 230, 200, 25);
        add(tfEmail);

        JButton btnModificar = new JButton("Modificar cliente");
        btnModificar.setBounds(130, 280, 160, 30);
        add(btnModificar);
        
        this.idClienteOriginal = cliente.getIdCliente();

        btnModificar.addActionListener(e -> {
            cliente.setNombre(tfNombre.getText());
            cliente.setApellidos(tfApellidos.getText());
            cliente.setDni(tfDni.getText());
            cliente.setDireccion(tfDireccion.getText());
            cliente.setTelefono(tfTelefono.getText());
            cliente.setEmail(tfEmail.getText());

            Cliente.GuardarCambios();
            padre.actualizarTablaClientes();
            dispose();
        });
    }
}
