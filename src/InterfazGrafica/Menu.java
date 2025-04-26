package InterfazGrafica;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JFrame{

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	
	public Menu() {
		setTitle("Menú Principal - RentACar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		contentPane.setLayout(new GridLayout(2, 1, 10, 10));
		setContentPane(contentPane);

		JButton btnAdministrador = new JButton("Administrador");
		JButton btnUsuario = new JButton("Usuario");

		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazAdministrador ventanaAdmin = new InterfazAdministrador();
				ventanaAdmin.setVisible(true);
			}
		});

		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazUsuario ventanaUsuario = new InterfazUsuario();
		        ventanaUsuario.setVisible(true);
			}
		});

		contentPane.add(btnAdministrador);
		contentPane.add(btnUsuario);
	}

}
