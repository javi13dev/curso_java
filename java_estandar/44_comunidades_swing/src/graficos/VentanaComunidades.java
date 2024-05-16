package graficos;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import adaptadores.ComboBoxModelComunidadesImpl;
import adaptadores.ComboBoxModelProvinciasImpl;
import adaptadores.TableModelMunicipiosImpl;
import model.Provincia;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;




public class VentanaComunidades extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable tableMunicipios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaComunidades frame = new VentanaComunidades();
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
	public VentanaComunidades() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComunidad = new JLabel("Seleccione comunidad:");
		lblComunidad.setBounds(150, 11, 181, 14);
		contentPane.add(lblComunidad);
		
		JComboBox<String> comboBoxComunidades = new JComboBox<>();
		comboBoxComunidades.setBounds(101, 30, 241, 20);
		contentPane.add(comboBoxComunidades);
		comboBoxComunidades.setModel(new ComboBoxModelComunidadesImpl());
		
		JLabel lblProvincias = new JLabel("Seleccione provincia:");
		lblProvincias.setBounds(150, 71, 181, 14);
		contentPane.add(lblProvincias);
		
		JComboBox<Provincia> comboBoxProvincias = new JComboBox<>();
		comboBoxProvincias.setBounds(101, 90, 241, 20);
		contentPane.add(comboBoxProvincias);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 170, 564, 213);
		contentPane.add(scrollPane_1);
		
		tableMunicipios = new JTable();
		scrollPane_1.setViewportView(tableMunicipios);
		
		JLabel lblNewLabel = new JLabel("Municipios:");
		lblNewLabel.setBounds(179, 132, 152, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setBounds(242, 422, 137, 23);
		contentPane.add(btnNewButton);
		
		JLabel jlbReloj = new JLabel("");
		jlbReloj.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jlbReloj.setBounds(541, 11, 109, 20);
		contentPane.add(jlbReloj);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaComunidades.this.dispose();
			}
		});

		
		comboBoxComunidades.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// El evento se produce dos veces al seleccionar y deseleccionar:
				if(e.getStateChange() == ItemEvent.SELECTED) { // Así controlamos que no pase dos veces.
					
					String comunidad = (String)comboBoxComunidades.getSelectedItem();
					comboBoxProvincias.setModel(new ComboBoxModelProvinciasImpl(comunidad));
					tableMunicipios.setModel(new DefaultTableModel());
				}	
			}
		});
		
		comboBoxProvincias.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(28, 143, 598, 237);
				contentPane.add(scrollPane);
				
				// El evento se produce dos veces al seleccionar y deseleccionar:
				if(e.getStateChange() == ItemEvent.SELECTED) { // Así controlamos que no pase dos veces.						
					
					String codigo = ((Provincia) comboBoxProvincias.getSelectedItem()).getCodigoProvincia();	
					var adaptador = new TableModelMunicipiosImpl(codigo);
					tableMunicipios.setModel(adaptador);
				}
			}
		});	
		
		
		// hilo Reloj
		ExecutorService executor = Executors.newCachedThreadPool();
		// No devuelve nada, es una impementación de Runnable
		executor.submit(() -> {
			// Actualizar reloj cada medio segundo
			
			while(true) { // bucle infinito
				LocalTime hora = LocalTime.now();
				jlbReloj.setText(hora.toString());
				Thread.sleep(500); // Se realizará cada medio segundo
				// No se para nunca ya que está en multitarea.
			}
		
		});
		executor.shutdown(); // Continua ejecutandose, habria que controlarlo.
	}
}
