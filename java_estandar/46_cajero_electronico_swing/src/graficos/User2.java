package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cuenta;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User2 frame = new User2();
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
	public User2() {
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
		panel.setBounds(10, 36, 414, 155);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenu jmOptions = new JMenu("Acciones");
		jmOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Desplegar la visualización de las demás pestañas de opciones
			}
		});
		jmOptions.setBounds(10, 22, 115, 26);
		panel.add(jmOptions);
		
		JMenuItem jmTitulares = new JMenuItem("Ver titulares");
		jmTitulares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Se ha pulsado ver titulares");
				
			}
		});
		jmOptions.add(jmTitulares);
		
		JMenuItem jmIng = new JMenuItem("Ingreso");
		jmOptions.add(jmIng);
		
		JMenuItem jmExt = new JMenuItem("Extracción");
		jmOptions.add(jmExt);
		
		JMenuItem jmSaldo = new JMenuItem("Saldo y movimientos");
		jmOptions.add(jmSaldo);
		
		this.setVisible(true);
		
	}

}
