package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.event.ListDataListener;
import javax.swing.plaf.SliderUI;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JProgressBar;

import Controller.ARP;
import jpcap.packet.ARPPacket;

import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ItemEvent;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Color;

public class principal {

	private JFrame frmArp;
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
	//private  ARP arp= new ARP();
	private JTextField operacion;
	private JComboBox selecmacori;
	private JComboBox selectipori;
	private JTextField macdesti;
	private JTextField ipdesti;
	private JTextField reci9;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	   
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal window = new principal();
					window.frmArp.setVisible(true);
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
		frmArp = new JFrame();
	
		frmArp.setTitle("ARP");
		frmArp.setIconImage(Toolkit.getDefaultToolkit().getImage(principal.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		frmArp.setBounds(100, 100, 1048, 556);
		frmArp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArp.getContentPane().setLayout(null);
		
		macdesti = new JTextField();
		macdesti.setEditable(false);
		macdesti.setText("FF:FF:FF:FF:FF:FF");
		macdesti.setBounds(704, 308, 179, 32);
		frmArp.getContentPane().add(macdesti);
		macdesti.setColumns(10);
		
		ipdesti = new JTextField();
		ipdesti.setColumns(10);
		ipdesti.setBounds(885, 308, 118, 32);
		frmArp.getContentPane().add(ipdesti);
		
		JLabel lblAsdasd = new JLabel("MAC destino");
		lblAsdasd.setBounds(747, 277, 83, 26);
		frmArp.getContentPane().add(lblAsdasd);
		
		JLabel lblMacOrigen = new JLabel("MAC origen");
		lblMacOrigen.setBounds(458, 277, 74, 26);
		frmArp.getContentPane().add(lblMacOrigen);
		
		JLabel lblIpDes = new JLabel("IP destino");
		lblIpDes.setBounds(907, 277, 83, 26);
		frmArp.getContentPane().add(lblIpDes);
		
		JLabel lblIpOri = new JLabel("IP origen");
		lblIpOri.setBounds(615, 277, 56, 26);
		frmArp.getContentPane().add(lblIpOri);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(487, 50, 418, 216);
		frmArp.getContentPane().add(scrollPane);
		
		JTable tablaipmac = new JTable();
		tablaipmac.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"IP", "MAC"}
		));
		scrollPane.setViewportView(tablaipmac);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("6");
		textField_2.setToolTipText("");
		textField_2.setColumns(10);
		textField_2.setBounds(192, 308, 46, 32);
		frmArp.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("2048");
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(130, 308, 56, 32);
		frmArp.getContentPane().add(textField_3);
		
		hardtype = new JTextField();
		hardtype.setColumns(10);
		hardtype.setBounds(21, 308, 105, 32);
		frmArp.getContentPane().add(hardtype);
		
		selecmacori = new JComboBox();
		selecmacori.setModel(new DefaultComboBoxModel(new String[] {"Temp", "Otro"}));
		selecmacori.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(selecmacori.getSelectedItem().equals("Otro"))
				{
					macori.setEnabled(true);
				}
				else 
				{
					macori.setEnabled(false);
				}
			}
		});
		selecmacori.setBounds(399, 308, 179, 32);
		frmArp.getContentPane().add(selecmacori);
		
		macori = new JTextField();
		macori.setEnabled(false);
		macori.setColumns(10);
		macori.setBounds(399, 349, 179, 32);
		frmArp.getContentPane().add(macori);
		
		selectipori = new JComboBox();
		selectipori.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(selectipori.getSelectedItem().equals("Otro"))
				{
					iporigi.setEnabled(true);
				}
				else 
				{
					iporigi.setEnabled(false);
				}
			}
		});
		selectipori.setModel(new DefaultComboBoxModel(new String[] {"Temp","Otro"}));
		selectipori.setBounds(582, 308, 118, 32);
		frmArp.getContentPane().add(selectipori);
		
		iporigi = new JTextField();
		iporigi.setEnabled(false);
		iporigi.setColumns(10);
		iporigi.setBounds(582, 349, 118, 32);
		frmArp.getContentPane().add(iporigi);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setToolTipText("");
		textField_16.setText("4");
		textField_16.setColumns(10);
		textField_16.setBounds(242, 308, 46, 32);
		frmArp.getContentPane().add(textField_16);
		
		reci1 = new JTextField();
		reci1.setEditable(false);
		reci1.setColumns(10);
		reci1.setBounds(21, 460, 105, 32);
		frmArp.getContentPane().add(reci1);
		
		reci2 = new JTextField();
		reci2.setText("2048");
		reci2.setEditable(false);
		reci2.setColumns(10);
		reci2.setBounds(130, 460, 56, 32);
		frmArp.getContentPane().add(reci2);
		
		reci3 = new JTextField();
		reci3.setToolTipText("");
		reci3.setText("6");
		reci3.setEditable(false);
		reci3.setColumns(10);
		reci3.setBounds(192, 460, 46, 32);
		frmArp.getContentPane().add(reci3);
		
		reci4 = new JTextField();
		reci4.setToolTipText("");
		reci4.setText("4");
		reci4.setEditable(false);
		reci4.setColumns(10);
		reci4.setBounds(242, 460, 46, 32);
		frmArp.getContentPane().add(reci4);
		
		reci5 = new JTextField();
		reci5.setEditable(false);
		reci5.setColumns(10);
		reci5.setBounds(292, 460, 105, 32);
		frmArp.getContentPane().add(reci5);
		
		reci6 = new JTextField();
		reci6.setEditable(false);
		reci6.setColumns(10);
		reci6.setBounds(399, 460, 179, 32);
		frmArp.getContentPane().add(reci6);
		
		reci7 = new JTextField();
		reci7.setEditable(false);
		reci7.setColumns(10);
		reci7.setBounds(582, 460, 118, 32);
		frmArp.getContentPane().add(reci7);
		
		reci8 = new JTextField();
		reci8.setEditable(false);
		reci8.setColumns(10);
		reci8.setBounds(704, 460, 179, 32);
		frmArp.getContentPane().add(reci8);
		
		reci9 = new JTextField();
		reci9.setEditable(false);
		reci9.setColumns(10);
		reci9.setBounds(885, 460, 118, 32);
		frmArp.getContentPane().add(reci9);
		
		JButton btnNewButton = new JButton("ENVIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ARPPacket prueba = null;
				/**ENVIA LA TRAMA **/	
				try {
					prueba =ARP.request(Short.parseShort(hardtype.getText()), "", "", ipdesti.getText());
					//progressBar43.
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//ARP.request(Short.parseShort(hardtype.getText()), selecmacori.getName(), selectipori.getName(), ipdesti.getText());
				/**ACTUALIZA LOS CAMPO DE ABAJO**/
				reci1.setText(String.valueOf(prueba.hardtype));
				//reci2.setText("KIKO");
				//reci3.setText("KIKO");
				reci5.setText("REPLY");
				reci6.setText((String) prueba.getSenderHardwareAddress());
				reci7.setText( prueba.getSenderProtocolAddress().toString());
				reci8.setText((String) prueba.getTargetHardwareAddress());
				reci9.setText(prueba.getTargetProtocolAddress().toString());
				
				for (int a=0; a<ARP.ips.size();a++) {
					System.out.println(ARP.ips.get(a).toString());
					
				}
				/**ORDEN TABLA**/
				Vector<List<String>> columnaip = new Vector<List<String>>();
				/*Vector<String> fila2=new Vector<String>();
				fila2.add("192.168.0.1");
				fila2.add("A6.B6.00.56");
				//columnaip.add(fila);
				//fila.clear();*/
				for (int i = 0; i < ARP.ips.size(); i++) {
					Vector<String> fila=new Vector<String>();
						fila.add(ARP.ips.get(i).toString());
						fila.add(ARP.macs.get(i).toString());				
					columnaip.add(fila);					
				}
				//fila.clear();
				/*fila2.add("192.168.0.3");
				fila2.add("A6.B6.00.5B");
				//columnaip.add(fila);
				//fila.clear();
				fila2.add("192.168.0.4");
				fila2.add("A6.B6.00.AA");
				//columnaip.add(fila);
				//fila.clear();*/
				
				Vector<String> name = new Vector<String>();
				name.add("IP2");name.add("MAC2");	
				TableModel juliantia=new DefaultTableModel( columnaip,name);
				
				tablaipmac.setModel(juliantia);
				
				/** ----ACTUALIZA LOS SELECTBOX---
				 *  PDT: AL PULSAR REPEDIDAS VECES EVIAR SE GENERAN VARIOS OTROS REVISAR 
				 *  MOTIVO: NO VACIA LA LISTA DE ITEMS
				 *  SOLUCION: VACIARLA CON CUIDADO DE LOS ERRORES
				 *  SOLUCIONADO!!!!
				**/
				Vector<String> selemaor = new Vector<String>();
				Vector<String> seleipor = new Vector<String>();
				//selecmacori.addItem("Otro2");
				//selecmacori.addItem("Otro3");
				//selecmacori.addItem("Otro");
				//selectipori.removeAllItems();
				//System.out.println(selecmacori.getComponentCount());
				//selecmacori.remove(1);
				//selecmacori.removeAll();
				//selecmacori.updateUI();
				//System.out.println(selecmacori.getComponentCount());
				
				//selecmacori.remove(0);

				//selecmacori.removeAllItems();
				//selecmacori.removeAll();
				for (int i = 0; i < columnaip.size(); i++) {
					selemaor.add(columnaip.get(i).get(1));
					seleipor.add(columnaip.get(i).get(0));
					//selecmacori.addItem(columnaip.get(i).get(1));
					//selectipori.addItem(columnaip.get(i).get(0));
				}
				
				//selecmacori.removeItemAt(0);
				//selecmacori.removeItemAt(0);
				//selectipori.addItem("Otro");
				//selectipori.removeItemAt(0);
				//selectipori.removeItemAt(0);
				System.out.println(selecmacori.getComponentCount());
				//ComboBoxModel lllll=new ComboBoxModel(selemaor) ;
				
				selecmacori.setModel(new DefaultComboBoxModel(selemaor));
				selecmacori.addItem("Otro");
				
				selectipori.setModel(new DefaultComboBoxModel(seleipor));
				selectipori.addItem("Otro");
				
				
			}
		});
		btnNewButton.setBounds(165, 73, 217, 161);
		frmArp.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Enviar");
		lblNewLabel.setBounds(21, 235, 92, 26);
		frmArp.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Recibir");
		lblNewLabel_1.setBounds(21, 391, 92, 26);
		frmArp.getContentPane().add(lblNewLabel_1);
		
		lblOpercacion = new JLabel("Operacion");
		lblOpercacion.setBounds(305, 277, 63, 26);
		frmArp.getContentPane().add(lblOpercacion);
		
		lblHardware = new JLabel("Hardware \r\ntype");
		lblHardware.setBounds(31, 274, 95, 32);
		frmArp.getContentPane().add(lblHardware);
		
		label = new JLabel("Hardware \r\ntype");
		label.setBounds(0, 427, 146, 32);
		frmArp.getContentPane().add(label);
		
		label_1 = new JLabel("Operacion");
		label_1.setBounds(292, 430, 105, 26);
		frmArp.getContentPane().add(label_1);
		
		label_2 = new JLabel("MAC origen");
		label_2.setBounds(418, 430, 152, 26);
		frmArp.getContentPane().add(label_2);
		
		label_3 = new JLabel("IP origen");
		label_3.setBounds(591, 430, 92, 26);
		frmArp.getContentPane().add(label_3);
		
		label_4 = new JLabel("MAC destino");
		label_4.setBounds(741, 430, 136, 26);
		frmArp.getContentPane().add(label_4);
		
		label_5 = new JLabel("IP destino");
		label_5.setBounds(885, 430, 105, 26);
		frmArp.getContentPane().add(label_5);
		
		progressBar43 = new JProgressBar();
	
		progressBar43.setBounds(50, 361, 243, 14);
		frmArp.getContentPane().add(progressBar43);
		
		operacion = new JTextField();
		operacion.setEditable(false);
		operacion.setText("Request");
		operacion.setBounds(292, 308, 105, 32);
		frmArp.getContentPane().add(operacion);
		operacion.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 0));
		panel.setBounds(21, 62, 107, 52);
		frmArp.getContentPane().add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 255));
		panel_2.setBounds(21, 113, 107, 32);
		frmArp.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 0, 0));
		panel_3.setBounds(21, 144, 107, 32);
		frmArp.getContentPane().add(panel_3);
		
		JLabel label_6 = new JLabel("PRODUCTO COLOMBIANO");
		label_6.setBounds(21, 29, 165, 32);
		frmArp.getContentPane().add(label_6);
	}
}
