package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JProgressBar;

public class principal {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField hardtype;
	private JTextField macori;
	private JTextField iporigi;
	private JTextField textField_16;
	private JTextField reci1;
	private JTextField reci2;
	private JTextField reci3;
	private JTextField reci4;
	private JTextField reci5;
	private JTextField reci6;
	private JTextField reci7;
	private JTextField reci8;
	private JTextField reci9;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblOpercacion;
	private JLabel lblHardware;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JProgressBar progressBar43;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	 //ACA EL REQUES
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal window = new principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1255, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextField macdesti = new JTextField();
		macdesti.setEditable(false);
		macdesti.setText("FF:FF:FF:FF:FF:FF");
		macdesti.setBounds(704, 308, 179, 32);
		frame.getContentPane().add(macdesti);
		macdesti.setColumns(10);
		
		JTextField ipdesti = new JTextField();
		ipdesti.setColumns(10);
		ipdesti.setBounds(885, 308, 118, 32);
		frame.getContentPane().add(ipdesti);
		
		JLabel lblAsdasd = new JLabel("MAC destino");
		lblAsdasd.setBounds(741, 277, 136, 26);
		frame.getContentPane().add(lblAsdasd);
		
		JLabel lblMacOrigen = new JLabel("MAC origen");
		lblMacOrigen.setBounds(418, 277, 152, 26);
		frame.getContentPane().add(lblMacOrigen);
		
		JLabel lblIpDes = new JLabel("IP destino");
		lblIpDes.setBounds(885, 277, 105, 26);
		frame.getContentPane().add(lblIpDes);
		
		JLabel lblIpOri = new JLabel("IP origen");
		lblIpOri.setBounds(591, 277, 92, 26);
		frame.getContentPane().add(lblIpOri);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(582, 52, 418, 216);
		frame.getContentPane().add(scrollPane);
		
		JTable tablaipmac = new JTable();
		tablaipmac.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IP", "MAC"
			}
		));
		scrollPane.setViewportView(tablaipmac);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("6");
		textField_2.setToolTipText("");
		textField_2.setColumns(10);
		textField_2.setBounds(192, 308, 46, 32);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("2048");
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(130, 308, 56, 32);
		frame.getContentPane().add(textField_3);
		
		hardtype = new JTextField();
		hardtype.setColumns(10);
		hardtype.setBounds(21, 308, 105, 32);
		frame.getContentPane().add(hardtype);
		
		JComboBox seloperacion = new JComboBox();
		seloperacion.setModel(new DefaultComboBoxModel(new String[] {"Request", "Reply"}));
		seloperacion.setBounds(292, 308, 105, 32);
		frame.getContentPane().add(seloperacion);
		
		JComboBox selecmacori = new JComboBox();
		selecmacori.setModel(new DefaultComboBoxModel(new String[] {"Otro"}));
		selecmacori.setBounds(399, 308, 179, 32);
		frame.getContentPane().add(selecmacori);
		
		macori = new JTextField();
		macori.setColumns(10);
		macori.setBounds(399, 349, 179, 32);
		frame.getContentPane().add(macori);
		
		JComboBox selectipori = new JComboBox();
		selectipori.setModel(new DefaultComboBoxModel(new String[] {"Otro"}));
		selectipori.setBounds(582, 308, 118, 32);
		frame.getContentPane().add(selectipori);
		
		iporigi = new JTextField();
		iporigi.setColumns(10);
		iporigi.setBounds(582, 349, 118, 32);
		frame.getContentPane().add(iporigi);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setToolTipText("");
		textField_16.setText("4");
		textField_16.setColumns(10);
		textField_16.setBounds(242, 308, 46, 32);
		frame.getContentPane().add(textField_16);
		
		reci1 = new JTextField();
		reci1.setEnabled(false);
		reci1.setColumns(10);
		reci1.setBounds(21, 460, 105, 32);
		frame.getContentPane().add(reci1);
		
		reci2 = new JTextField();
		reci2.setText("2048");
		reci2.setEditable(false);
		reci2.setColumns(10);
		reci2.setBounds(130, 460, 56, 32);
		frame.getContentPane().add(reci2);
		
		reci3 = new JTextField();
		reci3.setToolTipText("");
		reci3.setText("6");
		reci3.setEditable(false);
		reci3.setColumns(10);
		reci3.setBounds(192, 460, 46, 32);
		frame.getContentPane().add(reci3);
		
		reci4 = new JTextField();
		reci4.setToolTipText("");
		reci4.setText("4");
		reci4.setEditable(false);
		reci4.setColumns(10);
		reci4.setBounds(242, 460, 46, 32);
		frame.getContentPane().add(reci4);
		
		reci5 = new JTextField();
		reci5.setEnabled(false);
		reci5.setColumns(10);
		reci5.setBounds(292, 460, 105, 32);
		frame.getContentPane().add(reci5);
		
		reci6 = new JTextField();
		reci6.setEnabled(false);
		reci6.setColumns(10);
		reci6.setBounds(399, 460, 179, 32);
		frame.getContentPane().add(reci6);
		
		reci7 = new JTextField();
		reci7.setEnabled(false);
		reci7.setColumns(10);
		reci7.setBounds(582, 460, 118, 32);
		frame.getContentPane().add(reci7);
		
		reci8 = new JTextField();
		reci8.setEditable(false);
		reci8.setColumns(10);
		reci8.setBounds(704, 460, 179, 32);
		frame.getContentPane().add(reci8);
		
		reci9 = new JTextField();
		reci9.setEditable(false);
		reci9.setColumns(10);
		reci9.setBounds(885, 460, 118, 32);
		frame.getContentPane().add(reci9);
		
		JButton btnNewButton = new JButton("ENVIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					progressBar43.setValue(progressBar43.getValue()+1);
					
			}
		});
		btnNewButton.setBounds(329, 81, 217, 161);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Enviar");
		lblNewLabel.setBounds(21, 235, 92, 26);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Recivir");
		lblNewLabel_1.setBounds(21, 391, 92, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblOpercacion = new JLabel("Operacion");
		lblOpercacion.setBounds(292, 277, 105, 26);
		frame.getContentPane().add(lblOpercacion);
		
		lblHardware = new JLabel("Hardware \r\ntype");
		lblHardware.setBounds(0, 274, 146, 32);
		frame.getContentPane().add(lblHardware);
		
		label = new JLabel("Hardware \r\ntype");
		label.setBounds(0, 427, 146, 32);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("Operacion");
		label_1.setBounds(292, 430, 105, 26);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("MAC origen");
		label_2.setBounds(418, 430, 152, 26);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("IP origen");
		label_3.setBounds(591, 430, 92, 26);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("MAC destino");
		label_4.setBounds(741, 430, 136, 26);
		frame.getContentPane().add(label_4);
		
		label_5 = new JLabel("IP destino");
		label_5.setBounds(885, 430, 105, 26);
		frame.getContentPane().add(label_5);
		
		progressBar43 = new JProgressBar();
	
		progressBar43.setBounds(50, 361, 243, 14);
		frame.getContentPane().add(progressBar43);
	}
}
