package Principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombreCliente;
	private JTextField textFieldApellidosCliente;
	private JTextField textFieldDNICliente;
	private JTextField textFieldDireccionCliente;
	private JTextField textFieldTelefonoCliente;
	private JTextField textFieldEmailCliente;



	/**
	 * Create the frame.
	 */
	public GestionClientes() {
		/*setTitle("RENT A CAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		*/
		JLabel lblNewLabel = new JLabel("Gestion Clientes");
		lblNewLabel.setFont(new Font("Lato", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 112, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panelNuevoCliente = new JPanel();
		panelNuevoCliente.setBackground(new Color(245, 245, 245));
		panelNuevoCliente.setBounds(10, 36, 628, 486);
		contentPane.add(panelNuevoCliente);
		panelNuevoCliente.setLayout(null);
		
		JLabel lblNuevoCliente = new JLabel("Nuevo cliente");
		lblNuevoCliente.setBounds(282, 11, 73, 15);
		panelNuevoCliente.add(lblNuevoCliente);
		lblNuevoCliente.setFont(new Font("Lato", Font.BOLD, 12));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Lato", Font.PLAIN, 12));
		lblNombre.setBounds(73, 43, 73, 15);
		panelNuevoCliente.add(lblNombre);
		
		textFieldNombreCliente = new JTextField();
		textFieldNombreCliente.setBounds(156, 41, 401, 20);
		panelNuevoCliente.add(textFieldNombreCliente);
		textFieldNombreCliente.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Lato", Font.PLAIN, 12));
		lblApellidos.setBounds(73, 71, 73, 15);
		panelNuevoCliente.add(lblApellidos);
		
		textFieldApellidosCliente = new JTextField();
		textFieldApellidosCliente.setColumns(10);
		textFieldApellidosCliente.setBounds(156, 69, 401, 20);
		panelNuevoCliente.add(textFieldApellidosCliente);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Lato", Font.PLAIN, 12));
		lblDni.setBounds(73, 99, 73, 15);
		panelNuevoCliente.add(lblDni);
		
		textFieldDNICliente = new JTextField();
		textFieldDNICliente.setColumns(10);
		textFieldDNICliente.setBounds(156, 97, 401, 20);
		panelNuevoCliente.add(textFieldDNICliente);
		
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
		
		textFieldDireccionCliente = new JTextField();
		textFieldDireccionCliente.setColumns(10);
		textFieldDireccionCliente.setBounds(156, 125, 401, 20);
		panelNuevoCliente.add(textFieldDireccionCliente);
		
		textFieldTelefonoCliente = new JTextField();
		textFieldTelefonoCliente.setColumns(10);
		textFieldTelefonoCliente.setBounds(156, 153, 401, 20);
		panelNuevoCliente.add(textFieldTelefonoCliente);
		
		textFieldEmailCliente = new JTextField();
		textFieldEmailCliente.setColumns(10);
		textFieldEmailCliente.setBounds(156, 181, 401, 20);
		panelNuevoCliente.add(textFieldEmailCliente);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton.setBackground(new Color(171, 225, 228));
		btnNewButton.setFont(new Font("Lato", Font.PLAIN, 11));
		btnNewButton.setBounds(468, 212, 89, 20);
		panelNuevoCliente.add(btnNewButton);
		
	}
}
