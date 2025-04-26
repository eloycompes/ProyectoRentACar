package InterfazGrafica;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import InterfazGrafica.Empleado.GestionEmpleados;
import InterfazGrafica.Vehiculo.GestionVehiculos;

public class InterfazAdministrador extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public InterfazAdministrador() {
        setTitle("Panel Administrador");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // Inicializamos el JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        // Añadimos la pestaña de "Gestión Empleados"
        GestionEmpleados panelEmpleados = new GestionEmpleados(this);
        tabbedPane.addTab("Gestión Empleados", null, panelEmpleados, null);
        
        // Pestaña: Gestión Vehiculos
        GestionVehiculos panelVehiculos = new GestionVehiculos(this);
        tabbedPane.addTab("Gestión Vehículos", null, panelVehiculos, null);
    }

    public static void main(String[] args) {
        InterfazAdministrador frame = new InterfazAdministrador();
        frame.setVisible(true);
    }
}
