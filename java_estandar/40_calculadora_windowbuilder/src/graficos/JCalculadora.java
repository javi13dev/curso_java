package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtf1;
	private JTextField jtf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCalculadora frame = new JCalculadora();
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
	public JCalculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número 1\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(128, 52, 89, 24);
		contentPane.add(lblNewLabel);
		
		jtf1 = new JTextField();
		jtf1.setBounds(289, 56, 86, 20);
		contentPane.add(jtf1);
		jtf1.setColumns(10);
		
		jtf2 = new JTextField();
		jtf2.setColumns(10);
		jtf2.setBounds(289, 119, 86, 20);
		contentPane.add(jtf2);
		
		JLabel lblNmero = new JLabel("Número 2");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNmero.setBounds(128, 119, 89, 24);
		contentPane.add(lblNmero);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblResultado.setBounds(235, 291, 168, 30);
		JButton jbtSumar = new JButton("Sumar");
		
		jbtSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int suma = Integer.parseInt(jtf1.getText())+Integer.parseInt(jtf2.getText());
				lblResultado.setText("Suma: " + suma);
				
			}
		});
		jbtSumar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jbtSumar.setBounds(117, 227, 89, 23);
		contentPane.add(jbtSumar);
		
		JButton jbtMultiplicar = new JButton("Multiplicar");
		jbtMultiplicar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jbtMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int multiplicacion = Integer.parseInt(jtf1.getText())*Integer.parseInt(jtf2.getText());
				lblResultado.setText("Producto: " + multiplicacion);
			}
		});
		jbtMultiplicar.setBounds(413, 227, 109, 23);
		contentPane.add(jbtMultiplicar);
		

		contentPane.add(lblResultado);
		
		JButton btnCerrar = new JButton("X Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCalculadora.this.dispose(); // para acceder a la ventana y poder cerrarla.
			}
		});
		btnCerrar.setBounds(550, 11, 89, 23);
		contentPane.add(btnCerrar);
	}
}





