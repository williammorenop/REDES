package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.ImageIcon;
import java.awt.Font;

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
	//private  ARP arp= new ARP();
	private JTextField operacion;
	private JComboBox selecmacori;
	private JComboBox selectipori;
	private JTextField macdesti;
	private JTextField ipdesti;
	private JTextField reci9;
	private JLabel lblNewLabel_4;
	private JLabel lblArp;
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
		frmArp.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Categories-applications-internet-icon (1).png"));
		frmArp.setBounds(100, 100, 1056, 556);
		frmArp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArp.getContentPane().setLayout(null);
		
		lblArp = new JLabel("Address Resolution Protocol (ARP)");
		lblArp.setForeground(Color.WHITE);
		lblArp.setFont(new Font("SansSerif", Font.BOLD, 21));
		lblArp.setBounds(292, 6, 508, 32);
		frmArp.getContentPane().add(lblArp);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(".\\2017-15-09-16-34-53.jpeg"));
		lblNewLabel_4.setBounds(947, 0, 95, 94);
		frmArp.getContentPane().add(lblNewLabel_4);
		
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
		lblAsdasd.setForeground(Color.WHITE);
		lblAsdasd.setBackground(Color.WHITE);
		lblAsdasd.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblAsdasd.setBounds(704, 277, 83, 26);
		frmArp.getContentPane().add(lblAsdasd);
		
		JLabel lblMacOrigen = new JLabel("MAC origen");
		lblMacOrigen.setBackground(Color.WHITE);
		lblMacOrigen.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblMacOrigen.setForeground(Color.WHITE);
		lblMacOrigen.setBounds(400, 277, 74, 26);
		frmArp.getContentPane().add(lblMacOrigen);
		
		JLabel lblIpDes = new JLabel("IP destino");
		lblIpDes.setForeground(Color.WHITE);
		lblIpDes.setBackground(Color.WHITE);
		lblIpDes.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblIpDes.setBounds(885, 277, 83, 26);
		frmArp.getContentPane().add(lblIpDes);
		
		JLabel lblIpOri = new JLabel("IP origen");
		lblIpOri.setBackground(Color.WHITE);
		lblIpOri.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblIpOri.setForeground(Color.WHITE);
		lblIpOri.setBounds(582, 277, 74, 26);
		frmArp.getContentPane().add(lblIpOri);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(104, 49, 418, 216);
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
		hardtype.setText("1");
		hardtype.setColumns(10);
		hardtype.setBounds(21, 308, 105, 32);
		frmArp.getContentPane().add(hardtype);
		
		selecmacori = new JComboBox();
		selecmacori.setModel(new DefaultComboBoxModel(new String[] {"", "Otro"}));
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
		selectipori.setModel(new DefaultComboBoxModel(new String[] {"", "Otro"}));
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
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				ARPPacket prueba = null;
				/**ENVIA LA TRAMA **/	
				try {
					String macorig="";
					String iporig="";
					if(!selecmacori.getSelectedItem().toString().equals("Otro"))
					{
						macorig=selecmacori.getSelectedItem().toString();
					}
					else
					{
						macorig="";
						macorig+=macori.getText().toString();
					}
					//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					if(!selectipori.getSelectedItem().toString().equals("Otro"))
					{
						iporig=selectipori.getSelectedItem().toString();
					}
					else
					{
						iporig="/";
						iporig+=iporigi.getText().toString();
					}
					
					
					System.out.println("{{{{{{{{{{{"+macorig+"*****"+iporig);
					prueba =ARP.request(Short.parseShort(hardtype.getText()), macorig, iporig, ipdesti.getText());
					//prueba =ARP.request(Short.parseShort(hardtype.getText()), "", "", ipdesti.getText());

					//progressBar43.
				} catch(IllegalArgumentException e) {
					
					
					JOptionPane.showMessageDialog(null,e.getMessage(),"ERROR!!!!!!",JOptionPane.ERROR_MESSAGE); //Tipo de mensaje
					e.printStackTrace();

				}catch (IOException e) {
					
					JOptionPane.showMessageDialog(null,"Ooops, algo salió mal.","ERROR!!!!!!",JOptionPane.ERROR_MESSAGE); //Tipo de mensaje
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
				name.add("IP");name.add("MAC");	
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
		btnNewButton.setBounds(650, 84, 217, 134);
		frmArp.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Enviar");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(21, 239, 92, 26);
		frmArp.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Recibir");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_1.setBounds(21, 391, 92, 26);
		frmArp.getContentPane().add(lblNewLabel_1);
		
		lblOpercacion = new JLabel("Operacion");
		lblOpercacion.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblOpercacion.setForeground(Color.WHITE);
		lblOpercacion.setBounds(305, 277, 74, 26);
		frmArp.getContentPane().add(lblOpercacion);
		
		lblHardware = new JLabel("Hardware \r\ntype");
		lblHardware.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblHardware.setForeground(Color.WHITE);
		lblHardware.setBounds(21, 274, 95, 32);
		frmArp.getContentPane().add(lblHardware);
		
		label = new JLabel("Hardware \r\ntype");
		label.setForeground(Color.WHITE);
		label.setBackground(Color.WHITE);
		label.setFont(new Font("SansSerif", Font.BOLD, 13));
		label.setBounds(21, 427, 146, 32);
		frmArp.getContentPane().add(label);
		
		label_1 = new JLabel("Operacion");
		label_1.setForeground(Color.WHITE);
		label_1.setBackground(Color.WHITE);
		label_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		label_1.setBounds(292, 430, 105, 26);
		frmArp.getContentPane().add(label_1);
		
		label_2 = new JLabel("MAC origen");
		label_2.setForeground(Color.WHITE);
		label_2.setBackground(Color.WHITE);
		label_2.setFont(new Font("SansSerif", Font.BOLD, 13));
		label_2.setBounds(400, 430, 152, 26);
		frmArp.getContentPane().add(label_2);
		
		label_3 = new JLabel("IP origen");
		label_3.setForeground(Color.WHITE);
		label_3.setBackground(Color.WHITE);
		label_3.setFont(new Font("SansSerif", Font.BOLD, 13));
		label_3.setBounds(582, 430, 92, 26);
		frmArp.getContentPane().add(label_3);
		
		label_4 = new JLabel("MAC destino");
		label_4.setForeground(Color.WHITE);
		label_4.setBackground(Color.WHITE);
		label_4.setFont(new Font("SansSerif", Font.BOLD, 13));
		label_4.setBounds(709, 430, 136, 26);
		frmArp.getContentPane().add(label_4);
		
		label_5 = new JLabel("IP destino");
		label_5.setForeground(Color.WHITE);
		label_5.setBackground(Color.WHITE);
		label_5.setFont(new Font("SansSerif", Font.BOLD, 13));
		label_5.setBounds(887, 430, 105, 26);
		frmArp.getContentPane().add(label_5);
		
		operacion = new JTextField();
		operacion.setEditable(false);
		operacion.setText("Request");
		operacion.setBounds(292, 308, 105, 32);
		frmArp.getContentPane().add(operacion);
		operacion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(".\\2017-15-09-16-54-31.jpeg"));
		lblNewLabel_2.setBounds(0, 0, 1042, 517);
		frmArp.getContentPane().add(lblNewLabel_2);
	}
}
