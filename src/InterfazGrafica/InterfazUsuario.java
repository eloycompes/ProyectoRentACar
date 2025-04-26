package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import GestionClientes.Cliente;
import InterfazGrafica.Cliente.GestionClientes;
import InterfazGrafica.Cliente.VentanaModificarCliente;
import InterfazGrafica.Cliente.VentanaVerCliente;

public class InterfazUsuario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public InterfazUsuario() {
        setTitle("Panel Usuario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        // Inicializamos el JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        GestionClientes panelClientes = new GestionClientes(this);
        tabbedPane.addTab("Gestión Clientes", null, panelClientes, null);
        
        
        // Pestaña: Gestión Alquileres
        JPanel panelAlquileres = new JPanel();
        panelAlquileres.setLayout(null);
        tabbedPane.addTab("Gestión Alquileres", null, panelAlquileres, null);
    }
}
