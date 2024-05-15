package graficos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import adaptadores.ComboBoxModelContinentesImpl;
import adaptadores.JTableModelPaisesImpl;
import service.PaisServiceFactory;

public class VentanaPaises extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

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
		
		JLabel lblPaises = new JLabel("Paises");
		lblPaises.setBounds(61, 79, 46, 14);
		contentPane.add(lblPaises);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 104, 365, 146);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// El evento se produce dos veces al seleccionar y deseleccionar:
				if(e.getStateChange() == ItemEvent.SELECTED) { // Así controlamos que no pase dos veces.					
					String seleccionado=(String)comboBox.getSelectedItem();
					var service=PaisServiceFactory.getPaisService();
					
					// JOptionPane.showMessageDialog(VentanaPaises.this, "Paises de "+seleccionado+" :"+service.mostrarPaises(seleccionado).size());
					
					// Aqui se rellenará la tabla
					// Creamos una instancia del adaptador:
					var adaptador = new JTableModelPaisesImpl(seleccionado);
					table.setModel(adaptador);
					
					
				}
			}
		});
		comboBox.setBounds(172, 30, 120, 22);
		contentPane.add(comboBox);
		comboBox.setBackground(new Color(192, 192, 192));
		// Se asocia el adaptador a la lista:
		comboBox.setModel(new ComboBoxModelContinentesImpl());
		

	}
}
