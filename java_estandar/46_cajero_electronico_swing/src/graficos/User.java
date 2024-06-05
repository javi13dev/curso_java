package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import model.Cuenta;
import service.CajeroService;
import service.CajeroServiceFactory;

public class User extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// Aqui tengo la cuenta y los titulares.
	CajeroService service = CajeroServiceFactory.getCajeroService();
	Cuenta cuenta;
	List<Cliente> titulares;
	//List<Cliente> titulares = service.obtenerTitulares(cuenta.getNumeroCuenta());

	/**
	 * Create the frame.
	 */
	public User(Cuenta cuenta) {
		titulares = service.obtenerTitulares(cuenta.getNumeroCuenta());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cuenta: ");
		lblNewLabel.setBounds(49, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel jbl_numCuenta = new JLabel(String.valueOf(cuenta.getNumeroCuenta()));
		jbl_numCuenta.setBounds(134, 11, 54, 14);
		contentPane.add(jbl_numCuenta);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 78, 414, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 20, 104, 22);
		panel.add(menuBar);
		
		JMenu jmOptions_1 = new JMenu("Operaciones");
		menuBar.add(jmOptions_1);
		
		JMenuItem jmIng = new JMenuItem("Ingreso");
		jmIng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Ingreso(cuenta);
			}
		});
		jmOptions_1.add(jmIng);
		
		JMenuItem jmExt = new JMenuItem("Extracción");
		jmExt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Extraccion(cuenta);
			}
		});
		jmOptions_1.add(jmExt);
		
		JMenuItem jmiTransferencias = new JMenuItem("Transferencias");
		jmOptions_1.add(jmiTransferencias);
		
		JMenuItem jmSaldo = new JMenuItem("Saldo y movimientos");
		jmSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaMovimientos(cuenta);
			}
		});
		jmOptions_1.add(jmSaldo);
		

		// Muestro los titulares
		DefaultListModel modelo = new DefaultListModel();
		titulares
		.forEach(t -> modelo.addElement(t.getNombre()));
		
		JLabel lblNewLabel_1 = new JLabel("Titulares");
		lblNewLabel_1.setBounds(216, 11, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JList listTitulares = new JList();
		listTitulares.setBounds(304, 10, 120, 46);
		contentPane.add(listTitulares);
		listTitulares.setModel(modelo);
		
		// Eventos 
		
		jmOptions_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Desplegar la visualización de las demás pestañas de opciones
				System.out.println("Desde acciones: ");
			}
		});
		
		this.setVisible(true);
		
	}
}
