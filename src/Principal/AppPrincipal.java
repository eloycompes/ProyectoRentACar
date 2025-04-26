package Principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AppPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;


	/**
	 * Create the frame.
	 */
	public AppPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		// Crear el JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, 760, 540);  // Tamaño del JTabbedPane dentro del JFrame
        getContentPane().add(tabbedPane);

        // Pestaña 1: Gestión Alquileres
        JPanel alquilerPanel = new JPanel();
        tabbedPane.addTab("Gestion Alquileres", null, alquilerPanel, null);
        alquilerPanel.setLayout(null);

        // Pestaña 3: Gestión Empleados
        JPanel empleadosPanel = new JPanel();
        tabbedPane.addTab("Gestion Empleados", null, empleadosPanel, null);
        empleadosPanel.setLayout(null);
        
        // Pestaña 2: Gestión Clientes
        JPanel clientesPanel = new JPanel();
        tabbedPane.addTab("Gestion Clientes", null, clientesPanel, null);
        clientesPanel.setLayout(null);
                
           
                /*
                JPanel panelNuevoCliente = new JPanel();
                panelNuevoCliente.setLayout(null);
                panelNuevoCliente.setBackground(new Color(245, 245, 245));
                panelNuevoCliente.setBounds(0, 0, 628, 251);
                clientesPanel.add(panelNuevoCliente);
                
                JLabel lblNuevoCliente = new JLabel("Nuevo cliente");
                lblNuevoCliente.setFont(new Font("Lato", Font.BOLD, 12));
                lblNuevoCliente.setBounds(282, 11, 73, 15);
                panelNuevoCliente.add(lblNuevoCliente);
                
                JLabel lblNombre = new JLabel("Nombre");
                lblNombre.setFont(new Font("Lato", Font.PLAIN, 12));
                lblNombre.setBounds(73, 43, 73, 15);
                panelNuevoCliente.add(lblNombre);
                
                textField = new JTextField();
                textField.setColumns(10);
                textField.setBounds(156, 41, 401, 20);
                panelNuevoCliente.add(textField);
                
                JLabel lblApellidos = new JLabel("Apellidos");
                lblApellidos.setFont(new Font("Lato", Font.PLAIN, 12));
                lblApellidos.setBounds(73, 71, 73, 15);
                panelNuevoCliente.add(lblApellidos);
                
                textField_1 = new JTextField();
                textField_1.setColumns(10);
                textField_1.setBounds(156, 69, 401, 20);
                panelNuevoCliente.add(textField_1);
                
                JLabel lblDni = new JLabel("DNI");
                lblDni.setFont(new Font("Lato", Font.PLAIN, 12));
                lblDni.setBounds(73, 99, 73, 15);
                panelNuevoCliente.add(lblDni);
                
                textField_2 = new JTextField();
                textField_2.setColumns(10);
                textField_2.setBounds(156, 97, 401, 20);
                panelNuevoCliente.add(textField_2);
                
                JLabel lblDireccin = new JLabel("Dirección");
                lblDireccin.setFont(new Font("Lato", Font.PLAIN, 12));
                lblDireccin.setBounds(73, 127, 73, 15);
                panelNuevoCliente.add(lblDireccin);
                
                JLabel lblTelfono = new JLabel("Teléfono");
                lblTelfono.setFont(new Font("Lato", Font.PLAIN, 12));
                lblTelfono.setBounds(73, 155, 73, 15);
                panelNuevoCliente.add(lblTelfono);
                
                JLabel lblEmail = new JLabel("Email");
                lblEmail.setFont(new Font("Lato", Font.PLAIN, 12));
                lblEmail.setBounds(73, 183, 73, 15);
                panelNuevoCliente.add(lblEmail);
                
                textField_3 = new JTextField();
                textField_3.setColumns(10);
                textField_3.setBounds(156, 125, 401, 20);
                panelNuevoCliente.add(textField_3);
                
                textField_4 = new JTextField();
                textField_4.setColumns(10);
                textField_4.setBounds(156, 153, 401, 20);
                panelNuevoCliente.add(textField_4);
                
                textField_5 = new JTextField();
                textField_5.setColumns(10);
                textField_5.setBounds(156, 181, 401, 20);
                panelNuevoCliente.add(textField_5);
                
                JButton btnNewButton = new JButton("Enviar");
                btnNewButton.setFont(new Font("Lato", Font.PLAIN, 11));
                btnNewButton.setBackground(new Color(171, 225, 228));
                btnNewButton.setBounds(468, 212, 89, 20);
                panelNuevoCliente.add(btnNewButton);
                */

        // Pestaña 4: Gestión Vehículos
        JPanel vehiculosPanel = new JPanel();
        tabbedPane.addTab("Gestion Vehículos", null, vehiculosPanel, null);
        vehiculosPanel.setLayout(null);

        // Pestaña 5: Gestión Mantenimiento
        JPanel mantenimientoPanel = new JPanel();
        tabbedPane.addTab("Gestion Mantenimiento", null, mantenimientoPanel, null);
        mantenimientoPanel.setLayout(null);
	}

}
