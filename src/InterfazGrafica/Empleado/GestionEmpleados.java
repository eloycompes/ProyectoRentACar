package InterfazGrafica.Empleado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import GestionEmpleados.Administrador;
import GestionEmpleados.Empleado;  // Suponiendo que la clase Empleado ya esté definida
import GestionEmpleados.Rol;
import GestionEmpleados.Usuario;
import InterfazGrafica.Empleado.VentanaModificarEmpleado;
import InterfazGrafica.Empleado.VentanaVerEmpleado;

public class GestionEmpleados extends JPanel {

    private JTable tablaEmpleados;

    public GestionEmpleados(JFrame padre) {
        setLayout(null);

        Empleado.LeerDisco();

        // Panel Alta Empleado
        JPanel panelAlta = new JPanel();
        panelAlta.setBorder(BorderFactory.createTitledBorder("Nuevo Empleado"));
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

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(20, 150, labelWidth, 25);
        panelAlta.add(lblTelefono);

        JTextField tfTelefono = new JTextField();
        tfTelefono.setBounds(130, 150, textFieldWidth, 25);
        panelAlta.add(tfTelefono);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 190, labelWidth, 25);
        panelAlta.add(lblEmail);

        JTextField tfEmail = new JTextField();
        tfEmail.setBounds(130, 190, textFieldWidth, 25);
        panelAlta.add(tfEmail);

        JLabel lblRol = new JLabel("Rol:");
        lblRol.setBounds(20, 230, labelWidth, 25);
        panelAlta.add(lblRol);

        JComboBox<String> cbRol = new JComboBox<>(new String[]{"Administrador", "Usuario"});
        cbRol.setBounds(130, 230, textFieldWidth, 25);
        panelAlta.add(cbRol);

        JButton btnAltaEmpleado = new JButton("Dar de alta");
        btnAltaEmpleado.setBounds(130, 270, 120, 30);
        panelAlta.add(btnAltaEmpleado);
        
        
        btnAltaEmpleado.addActionListener(e -> {
            String rolSeleccionado = cbRol.getSelectedItem().toString();
            Rol rol = Rol.valueOf(rolSeleccionado.toUpperCase());

            Empleado empleado = null;

            if (rol == Rol.ADMINISTRADOR) {
                empleado = new Administrador(
                    tfNombre.getText(),
                    tfApellidos.getText(),
                    tfDni.getText(),
                    tfTelefono.getText(),
                    tfEmail.getText()
                );
            } else if (rol == Rol.USUARIO) {
                empleado = new Usuario(
                    tfNombre.getText(),
                    tfApellidos.getText(),
                    tfDni.getText(),
                    tfTelefono.getText(),
                    tfEmail.getText()
                );
            }

            if (empleado != null) {
                Empleado.Insertar(empleado);
                Empleado.GuardarCambios();
                actualizarTablaEmpleados();

                // Limpiar campos
                tfNombre.setText("");
                tfApellidos.setText("");
                tfDni.setText("");
                tfTelefono.setText("");
                tfEmail.setText("");
            }
        });

        // Panel Listado Empleados
        JPanel panelListado = new JPanel(new BorderLayout());
        panelListado.setBorder(BorderFactory.createTitledBorder("Empleados registrados"));
        panelListado.setBounds(404, 20, 546, 320);
        add(panelListado);

        String[] columnas = {"ID", "Nombre", "DNI", "Teléfono", "Email", "Rol"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        tablaEmpleados = new JTable(model);
        JScrollPane scroll = new JScrollPane(tablaEmpleados);
        panelListado.add(scroll, BorderLayout.CENTER);

        actualizarTablaEmpleados();

        // Botones 
        JButton btnModificarEmpleado = new JButton("Modificar empleado");
        btnModificarEmpleado.setBounds(404, 350, 200, 30);
        add(btnModificarEmpleado);
        btnModificarEmpleado.addActionListener(e -> {
            int row = tablaEmpleados.getSelectedRow();
            if (row != -1) {
                int id = (int) tablaEmpleados.getValueAt(row, 0);
                Empleado seleccionado = Empleado.Leer(id);
                if (seleccionado != null) {
                    new VentanaModificarEmpleado(seleccionado, this).setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un empleado para modificar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        JButton btnVerEmpleado = new JButton("Ver empleado");
        btnVerEmpleado.setBounds(617, 350, 160, 30);
        add(btnVerEmpleado);
        btnVerEmpleado.addActionListener(e -> {
            int row = tablaEmpleados.getSelectedRow();
            if (row != -1) {
                int id = (int) tablaEmpleados.getValueAt(row, 0);
                Empleado seleccionado = Empleado.Leer(id);
                if (seleccionado != null) {
                    new VentanaVerEmpleado(seleccionado).setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un empleado para ver.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        JButton btnEliminarEmpleado = new JButton("Eliminar empleado");
        btnEliminarEmpleado.setBounds(790, 350, 160, 30);
        add(btnEliminarEmpleado);
        btnEliminarEmpleado.addActionListener(e -> {
            int row = tablaEmpleados.getSelectedRow();
            if (row != -1) {
                int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres eliminar este empleado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    int id = (int) tablaEmpleados.getValueAt(row, 0);
                    Empleado.Eliminar(id);
                    Empleado.GuardarCambios();
                    actualizarTablaEmpleados();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un empleado para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public void actualizarTablaEmpleados() {
        Empleado.LeerDisco();
        List<Empleado> empleados = Empleado.getListaEmpleado();

        DefaultTableModel model = (DefaultTableModel) tablaEmpleados.getModel();
        model.setRowCount(0);

        for (Empleado e : empleados) {
            model.addRow(new Object[]{
                    e.getIdEmpleado(),
                    e.getNombre(),
                    e.getDni(),
                    e.getTelefono(),
                    e.getEmail(),
                    e.getRol()
            });
        }
    }
}
