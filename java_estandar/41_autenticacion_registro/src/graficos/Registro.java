package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.UsuarioService;
import service.UsuarioServiceFactory;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userText;
	private JTextField passText;
	private JTextField emailText;
	private JTextField telText;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("Usuario");
		lbl1.setBounds(61, 29, 46, 14);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("Contraseña");
		lbl2.setBounds(61, 54, 65, 14);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel("Email");
		lbl3.setBounds(61, 83, 46, 14);
		contentPane.add(lbl3);
		
		JLabel lbl4 = new JLabel("Teléfono");
		lbl4.setBounds(61, 122, 46, 14);
		contentPane.add(lbl4);
		
		userText = new JTextField();
		userText.setBounds(212, 26, 86, 20);
		contentPane.add(userText);
		userText.setColumns(10);
		
		passText = new JTextField();
		passText.setColumns(10);
		passText.setBounds(212, 51, 86, 20);
		contentPane.add(passText);
		
		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(212, 80, 86, 20);
		contentPane.add(emailText);
		
		telText = new JTextField();
		telText.setColumns(10);
		telText.setBounds(212, 111, 86, 20);
		contentPane.add(telText);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioService userService = UsuarioServiceFactory.getUsuarioService();
				String mensaje;
				int telefono = 0;
				
				try {
					// Parseamos el valor introducido en la caja.
					telefono = Integer.parseInt(telText.getText());
					System.out.println(telefono);

				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				
				if(userService.saveUser(userText.getText(),passText.getText(), emailText.getText(),telefono)) {
					mensaje="Usuario registrado";
				}else {
					mensaje="No se ha registrado el usuario";
				}
				JOptionPane.showMessageDialog(Registro.this, mensaje);
				Registro.this.dispose(); 

				
			}
		});
		btnRegistrar.setBounds(124, 171, 89, 23);
		contentPane.add(btnRegistrar);
		this.setVisible(true);
	}

}
