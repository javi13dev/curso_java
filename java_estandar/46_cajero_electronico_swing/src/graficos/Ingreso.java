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

public class Ingreso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfCantidad;
	Cuenta cuenta;
	/**
	 * Create the frame.
	 */
	public Ingreso(Cuenta cuenta) {
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
		
		JLabel lblNewLabel_1 = new JLabel("Ingresar");
		lblNewLabel_1.setBounds(180, 11, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAceptarIngreso = new JButton("Aceptar");
		btnAceptarIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CajeroService service = CajeroServiceFactory.getCajeroService();
				double cantidad = Double.parseDouble(jtfCantidad.getText());
				String mensaje = "";
				
				if(service.extraccion(cuenta.getNumeroCuenta(), cantidad) == null) {
					mensaje = "No se ha podido realizar el ingreso";
					JOptionPane.showMessageDialog(Ingreso.this, mensaje);
				}else {
					mensaje = "Ingreso realizado";
					JOptionPane.showMessageDialog(Ingreso.this, mensaje);
				}
			}
		});
		btnAceptarIngreso.setBounds(161, 126, 89, 23);
		contentPane.add(btnAceptarIngreso);
		
		// para cuando se cree, sea visible.
		this.setVisible(true);
	}
}
