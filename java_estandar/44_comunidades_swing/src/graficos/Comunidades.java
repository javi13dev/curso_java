package graficos;

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

import adaptadores.ComboBoxModelComunidadesImpl;
import adaptadores.ComboBoxModelProvinciasImpl;
import adaptadores.TableModelMunicipiosImpl;


public class Comunidades extends JFrame {

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
					Comunidades frame = new Comunidades();
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
	public Comunidades() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComunidad = new JLabel("Seleccione comunidad:");
		lblComunidad.setBounds(150, 11, 181, 14);
		contentPane.add(lblComunidad);
		
		JComboBox comboBoxComunidades = new JComboBox();
		comboBoxComunidades.setBounds(101, 30, 241, 20);
		contentPane.add(comboBoxComunidades);
		comboBoxComunidades.setModel(new ComboBoxModelComunidadesImpl());
		
		JLabel lblProvincias = new JLabel("Seleccione provincia:");
		lblProvincias.setBounds(150, 71, 181, 14);
		contentPane.add(lblProvincias);
		

		
		comboBoxComunidades.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				// El evento se produce dos veces al seleccionar y deseleccionar:
				if(e.getStateChange() == ItemEvent.SELECTED) { // Así controlamos que no pase dos veces.					
					JComboBox comboBoxProvincias = new JComboBox();
					
					comboBoxProvincias.setBounds(101, 90, 241, 20);
					contentPane.add(comboBoxProvincias);
					System.out.println(comboBoxComunidades.getSelectedItem());
					comboBoxProvincias.setModel(new ComboBoxModelProvinciasImpl((String)comboBoxComunidades.getSelectedItem()));
					
					comboBoxProvincias.addItemListener(new ItemListener() {
						
						public void itemStateChanged(ItemEvent e) {
							System.out.println("En el evento municipios");
							JScrollPane scrollPane = new JScrollPane();
							scrollPane.setBounds(28, 143, 598, 237);
							contentPane.add(scrollPane);
							
							table = new JTable();
							scrollPane.setColumnHeaderView(table);
							
							// El evento se produce dos veces al seleccionar y deseleccionar:
							if(e.getStateChange() == ItemEvent.SELECTED) { // Así controlamos que no pase dos veces.	
								
								System.out.println("evento " + comboBoxProvincias.getSelectedItem());
								
								var adaptador = new TableModelMunicipiosImpl(comboBoxProvincias.getSelectedItem());
								table.setModel(adaptador);
							}
							
							
							
						}
					});
					
				}
				
				
				
			}
		});
		
		//////
		
	}

}
