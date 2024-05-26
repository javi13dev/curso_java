package graficos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Cuenta;
import service.CajeroService;
import service.CajeroServiceFactory;

public class Cajero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtNumCuenta;
	static Cuenta cuentaUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cajero frame = new Cajero();
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
	public Cajero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número de cuenta");
		lblNewLabel.setBounds(152, 27, 88, 14);
		contentPane.add(lblNewLabel);
		
		jtNumCuenta = new JTextField();
		jtNumCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jtNumCuenta.setBounds(152, 68, 86, 20);
		contentPane.add(jtNumCuenta);
		jtNumCuenta.setColumns(10);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Aqui se va a ingresa la cuenta, llamaremos al service de Cajero Service para ir probando.
				CajeroService service = CajeroServiceFactory.getCajeroService();
				
				System.out.println("Desde cajero");
				System.out.println(jtNumCuenta.getText());
				cuentaUser = service.obtenerCuenta(Integer.parseInt(jtNumCuenta.getText()));
				new User();
			}
		});
		btnNewButton.setBounds(152, 115, 89, 23);
		contentPane.add(btnNewButton);
	}
}
