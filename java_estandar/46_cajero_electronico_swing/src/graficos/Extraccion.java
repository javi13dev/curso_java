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

import model.Cuenta;
import service.CajeroService;
import service.CajeroServiceFactory;

public class Extraccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfCantidad;
	Cuenta cuenta;

	/**
	 * Create the frame.
	 */
	public Extraccion(Cuenta cuenta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad:");
		lblNewLabel.setBounds(93, 56, 86, 14);
		contentPane.add(lblNewLabel);
		
		jtfCantidad = new JTextField();
		jtfCantidad.setBounds(216, 53, 86, 20);
		contentPane.add(jtfCantidad);
		jtfCantidad.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sacar dinero");
		lblNewLabel_1.setBounds(180, 11, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAceptarRetirada = new JButton("Aceptar");
		btnAceptarRetirada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CajeroService service = CajeroServiceFactory.getCajeroService();
				double cantidad = Double.parseDouble(jtfCantidad.getText());
				service.extraccion(cuenta.getNumeroCuenta(), cantidad);
				
				String mensaje = "";
				
				if(service.extraccion(cuenta.getNumeroCuenta(), cantidad) == null) {
					mensaje = "No se ha podido retirar el dinero";
					JOptionPane.showMessageDialog(Extraccion.this, mensaje);
				}else {
					mensaje = "Extracción de dinero realizada";
					JOptionPane.showMessageDialog(Extraccion.this, mensaje);
				}
			}
		});
		btnAceptarRetirada.setBounds(161, 126, 89, 23);
		contentPane.add(btnAceptarRetirada);
		
		// para cuando se cree, sea visible.
		this.setVisible(true);
	}

}
