package graficos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import service.CajeroService;
import service.CajeroServiceFactory;

public class User extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// Aqui tengo la cuenta y los titulares.
	CajeroService service = CajeroServiceFactory.getCajeroService();
	List<Cliente> titulares = service.obtenerTitulares(Cajero.cuentaUser.getNumeroCuenta());
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cuenta: ");
		lblNewLabel.setBounds(49, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel jbl_numCuenta = new JLabel(String.valueOf(Cajero.cuentaUser.getNumeroCuenta()));
		jbl_numCuenta.setBounds(156, 11, 105, 14);
		contentPane.add(jbl_numCuenta);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 35, 414, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 20, 104, 22);
		panel.add(menuBar);
		
		JMenu jmOptions_1 = new JMenu("Acciones");
		menuBar.add(jmOptions_1);
		
		
		JMenuItem jmTitulares = new JMenuItem("Ver titulares");
		jmOptions_1.add(jmTitulares);
		
		JMenuItem jmIng = new JMenuItem("Ingreso");
		jmOptions_1.add(jmIng);
		
		JMenuItem jmExt = new JMenuItem("Extracción");
		jmOptions_1.add(jmExt);
		
		JMenuItem jmSaldo = new JMenuItem("Saldo y movimientos");
		jmOptions_1.add(jmSaldo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 169, 414, 84);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl2_titulares = new JLabel("");
		lbl2_titulares.setBounds(10, 10, 68, 13);
		panel_1.add(lbl2_titulares);
		
		JLabel lbl2Titular = new JLabel("");
		lbl2Titular.setBounds(107, 10, 128, 13);
		panel_1.add(lbl2Titular);
		
		// Eventos 
		
		jmOptions_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Desplegar la visualización de las demás pestañas de opciones
				
				System.out.println("Desde acciones: ");
				getContentPane().setBackground(new Color(255,0,0));
			}
		});
		
		jmTitulares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Se ha pulsado ver titulares");
				lbl2_titulares.setText("Titulares: ");
				
				// Aqui de la lista de titulares tendria que sacar el nombre:
				titulares
				.stream()
				.distinct()
				.forEach(t -> System.out.println(t.getNombre()));
				lbl2Titular.setText("Tontin");
				
			}
		});
		this.setVisible(true);
		
	}
	
}
