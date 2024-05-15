package graficos;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import adaptadores.ListModelContinentesImpl;
import service.PaisService;
import service.PaisServiceFactory;

public class VentanaPaises extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPaises frame = new VentanaPaises();
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
	public VentanaPaises() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Continentes:");
		lblNewLabel.setBounds(61, 34, 112, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(145, 32, 92, 119);
		contentPane.add(scrollPane);
		
		JList<String> listContinentes = new JList<>();  // Se determina el tipo, porque JList acepta genérico
		
		
		listContinentes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				PaisService service = PaisServiceFactory.getPaisService();
				
				int cantidad = service.mostrarPaises(listContinentes.getSelectedValue()).size();
				String mensaje = "Tiene " + cantidad + " paises";
				JOptionPane.showMessageDialog(VentanaPaises.this, mensaje);
			}
		});
		
		
		listContinentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listContinentes);
		listContinentes.setBackground(new Color(192, 192, 192));
		// Se asocia el adaptador a la lista:
		listContinentes.setModel(new ListModelContinentesImpl());
	}
}
