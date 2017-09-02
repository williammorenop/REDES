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

public class principal {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_16;
	private JTextField textField_1;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;

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
		
		JLabel lblAsdasd = new JLabel("mac des");
		lblAsdasd.setBounds(739, 277, 92, 26);
		frame.getContentPane().add(lblAsdasd);
		
		JLabel lblMacOrigen = new JLabel("mac origen");
		lblMacOrigen.setBounds(429, 277, 92, 26);
		frame.getContentPane().add(lblMacOrigen);
		
		JLabel lblIpDes = new JLabel("ip des");
		lblIpDes.setBounds(898, 277, 92, 26);
		frame.getContentPane().add(lblIpDes);
		
		JLabel lblIpOri = new JLabel("ip ori");
		lblIpOri.setBounds(608, 277, 92, 26);
		frame.getContentPane().add(lblIpOri);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(336, 21, 418, 216);
		frame.getContentPane().add(scrollPane);
		
		JTable tablaipmac = new JTable();
		scrollPane.setViewportView(tablaipmac);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(292, 349, 105, 32);
		frame.getContentPane().add(textField);
		
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
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(21, 308, 105, 32);
		frame.getContentPane().add(textField_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Otro"}));
		comboBox_1.setBounds(292, 308, 105, 32);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Otro"}));
		comboBox_2.setBounds(399, 308, 179, 32);
		frame.getContentPane().add(comboBox_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(399, 349, 179, 32);
		frame.getContentPane().add(textField_5);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Otro"}));
		comboBox_3.setBounds(582, 308, 118, 32);
		frame.getContentPane().add(comboBox_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(582, 349, 118, 32);
		frame.getContentPane().add(textField_6);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setToolTipText("");
		textField_16.setText("4");
		textField_16.setColumns(10);
		textField_16.setBounds(242, 308, 46, 32);
		frame.getContentPane().add(textField_16);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(21, 460, 105, 32);
		frame.getContentPane().add(textField_1);
		
		textField_7 = new JTextField();
		textField_7.setText("2048");
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(130, 460, 56, 32);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setToolTipText("");
		textField_8.setText("6");
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(192, 460, 46, 32);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setToolTipText("");
		textField_9.setText("4");
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(242, 460, 46, 32);
		frame.getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEnabled(false);
		textField_10.setColumns(10);
		textField_10.setBounds(292, 460, 105, 32);
		frame.getContentPane().add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setEnabled(false);
		textField_11.setColumns(10);
		textField_11.setBounds(399, 460, 179, 32);
		frame.getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setEnabled(false);
		textField_12.setColumns(10);
		textField_12.setBounds(582, 460, 118, 32);
		frame.getContentPane().add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(704, 460, 179, 32);
		frame.getContentPane().add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(885, 460, 118, 32);
		frame.getContentPane().add(textField_14);
		
		JButton btnNewButton = new JButton("ENVIAR");
		btnNewButton.setBounds(42, 53, 217, 161);
		frame.getContentPane().add(btnNewButton);
	}
}
