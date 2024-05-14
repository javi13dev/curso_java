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

import service.UsuarioService;
import service.UsuarioServiceFactory;

public class Autenticacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jt1;
	private JTextField jt2;
	
	private JLabel lblResultado;
	private JButton btnReg;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Autenticacion frame = new Autenticacion();
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
	public Autenticacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("Usuario");
		lbl1.setBounds(55, 29, 70, 14);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("Password");
		lbl2.setBounds(55, 86, 70, 14);
		contentPane.add(lbl2);
		
		jt1 = new JTextField();
		jt1.setBounds(176, 26, 86, 20);
		contentPane.add(jt1);
		jt1.setColumns(10);
		
		jt2 = new JTextField();
		jt2.setColumns(10);
		jt2.setBounds(176, 83, 86, 20);
		contentPane.add(jt2);
		
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(138, 198, 171, 14);
		contentPane.add(lblResultado);
		
		JButton btnComprobar = new JButton("Ingresar");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioService userService = UsuarioServiceFactory.getUsuarioService();

				if(userService.existeUsuario(jt1.getText(), jt2.getText())) {
					lblResultado.setText("Usuario ya registrado");
				}else {
					lblResultado.setText("Usuario no existe");
				}
				
			}
		});
		btnComprobar.setBounds(152, 150, 89, 23);
		contentPane.add(btnComprobar);
		
		btnReg = new JButton("Resgistrar");
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Autenticacion.this.dispose(); 

				Registro frame2 = new Registro();
				frame2.setVisible(true);
			}
		});
		btnReg.setBounds(10, 227, 89, 23);
		contentPane.add(btnReg);

	}
}
