package InterfazGrafica.Cliente;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import GestionClientes.Cliente;
import InterfazGrafica.InterfazUsuario;

public class GestionClientes extends JPanel {

    private JTable tablaClientes;  
    
    public GestionClientes(InterfazUsuario padre) {
        setLayout(null);

        Cliente.LeerDisco();

        // Panel Alta Cliente
        JPanel panelAlta = new JPanel();
        panelAlta.setBorder(BorderFactory.createTitledBorder("Nuevo Cliente"));
        panelAlta.setLayout(null);
        panelAlta.setBounds(20, 20, 364, 320);
        add(panelAlta);

        int labelWidth = 100;
        int textFieldWidth = 200;

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 30, labelWidth, 25);
        panelAlta.add(lblNombre);

        JTextField tfNombre = new JTextField();
        tfNombre.setBounds(130, 30, textFieldWidth, 25);
        panelAlta.add(tfNombre);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(20, 70, labelWidth, 25);
        panelAlta.add(lblApellidos);

        JTextField tfApellidos = new JTextField();
        tfApellidos.setBounds(130, 70, textFieldWidth, 25);
        panelAlta.add(tfApellidos);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(20, 110, labelWidth, 25);
        panelAlta.add(lblDni);

        JTextField tfDni = new JTextField();
        tfDni.setBounds(130, 110, textFieldWidth, 25);
        panelAlta.add(tfDni);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(20, 150, labelWidth, 25);
        panelAlta.add(lblDireccion);

        JTextField tfDireccion = new JTextField();
        tfDireccion.setBounds(130, 150, textFieldWidth, 25);
        panelAlta.add(tfDireccion);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(20, 190, labelWidth, 25);
        panelAlta.add(lblTelefono);

        JTextField tfTelefono = new JTextField();
        tfTelefono.setBounds(130, 190, textFieldWidth, 25);
        panelAlta.add(tfTelefono);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 230, labelWidth, 25);
        panelAlta.add(lblEmail);

        JTextField tfEmail = new JTextField();
        tfEmail.setBounds(130, 230, textFieldWidth, 25);
        panelAlta.add(tfEmail);

        JButton btnAltaCliente = new JButton("Dar de alta");
        btnAltaCliente.setBounds(130, 270, 120, 30);
        panelAlta.add(btnAltaCliente);

        btnAltaCliente.addActionListener(e -> {
            Cliente cliente = new Cliente(
                tfNombre.getText(),
                tfApellidos.getText(),
                tfDni.getText(),
                tfDireccion.getText(),
                tfTelefono.getText(),
                tfEmail.getText()
            );
            Cliente.Insertar(cliente);
            Cliente.GuardarCambios();
            actualizarTablaClientes();

            tfNombre.setText("");
            tfApellidos.setText("");
            tfDni.setText("");
            tfDireccion.setText("");
            tfTelefono.setText("");
            tfEmail.setText("");
        });

        // Panel Listado Clientes
        JPanel panelListado = new JPanel(new BorderLayout());
        panelListado.setBorder(BorderFactory.createTitledBorder("Clientes registrados"));
        panelListado.setBounds(404, 20, 546, 320);
        add(panelListado);

        String[] columnas = {"ID", "Nombre", "DNI", "Teléfono", "Email"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        tablaClientes = new JTable(model);
        JScrollPane scroll = new JScrollPane(tablaClientes);
        panelListado.add(scroll, BorderLayout.CENTER);

        actualizarTablaClientes();

        // Botones
        JButton btnModificarCliente = new JButton("Modificar cliente");
        btnModificarCliente.setBounds(404, 350, 200, 30);
        add(btnModificarCliente);
        btnModificarCliente.addActionListener(e -> {
            int row = tablaClientes.getSelectedRow();
            if (row != -1) {
                int id = (int) tablaClientes.getValueAt(row, 0);
                Cliente seleccionado = Cliente.Leer(id);
                if (seleccionado != null) {
                    new VentanaModificarCliente(seleccionado, this).setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un cliente para modificar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        JButton btnVer = new JButton("Ver cliente");
        btnVer.setBounds(617, 350, 160, 30);
        add(btnVer);
        btnVer.addActionListener(e -> {
            int row = tablaClientes.getSelectedRow();
            if (row != -1) {
                int id = (int) tablaClientes.getValueAt(row, 0);
                Cliente seleccionado = Cliente.Leer(id);
                if (seleccionado != null) {
                    new VentanaVerCliente(seleccionado).setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un cliente para ver.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        JButton btnEliminar = new JButton("Eliminar cliente");
        btnEliminar.setBounds(790, 350, 160, 30);
        add(btnEliminar);
        btnEliminar.addActionListener(e -> {
            int row = tablaClientes.getSelectedRow();
            if (row != -1) {
                int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres eliminar este cliente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    int id = (int) tablaClientes.getValueAt(row, 0);
                    Cliente.Eliminar(id);
                    Cliente.GuardarCambios();
                    actualizarTablaClientes();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un cliente para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public void actualizarTablaClientes() {
        Cliente.LeerDisco();
        List<Cliente> clientes = Cliente.getListaClientes();

        DefaultTableModel model = (DefaultTableModel) tablaClientes.getModel();
        model.setRowCount(0);

        for (Cliente c : clientes) {
            model.addRow(new Object[]{
                c.getIdCliente(),
                c.getNombre(),
                c.getDni(),
                c.getTelefono(),
                c.getEmail()
            });
        }
    }

}
