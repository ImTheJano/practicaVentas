package gui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.Usuario;
import dao.DaoCompra;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentasFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfBuscar;
	private JButton btnNewButton_2;
	private JButton btnNewButton_4;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private JLabel lbl1;
	private JLabel lblVentas;
	private JButton btnVerVenta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentasFrame frame = new VentasFrame();
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
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {125, 125, 125, 125, 0};
		gbl_contentPane.rowHeights = new int[]{29, 187, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Busqueda");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		tfBuscar = new JTextField();
		GridBagConstraints gbc_tfBuscar = new GridBagConstraints();
		gbc_tfBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_tfBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBuscar.gridx = 1;
		gbc_tfBuscar.gridy = 0;
		contentPane.add(tfBuscar, gbc_tfBuscar);
		tfBuscar.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!tfBuscar.getText().equals("")) {
					buscar();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_2 = new JButton("Actualizar tabla");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 0;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		btnNewButton_4 = new JButton("Salir");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		lbl1 = new JLabel("Ventas totales");
		GridBagConstraints gbc_lbl1 = new GridBagConstraints();
		gbc_lbl1.insets = new Insets(0, 0, 0, 5);
		gbc_lbl1.gridx = 0;
		gbc_lbl1.gridy = 2;
		contentPane.add(lbl1, gbc_lbl1);
		
		lblVentas = new JLabel("");
		GridBagConstraints gbc_lblVentas = new GridBagConstraints();
		gbc_lblVentas.insets = new Insets(0, 0, 0, 5);
		gbc_lblVentas.gridx = 1;
		gbc_lblVentas.gridy = 2;
		contentPane.add(lblVentas, gbc_lblVentas);
		
		btnVerVenta = new JButton("Ver venta");
		btnVerVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel=table.getSelectedRow();
				if(!table.getModel().getValueAt(sel,0).equals(""))new DetalleVenta((String) table.getModel().getValueAt(sel,0)).setVisible(true);
			}
		});
		GridBagConstraints gbc_btnVerVenta = new GridBagConstraints();
		gbc_btnVerVenta.insets = new Insets(0, 0, 0, 5);
		gbc_btnVerVenta.gridx = 2;
		gbc_btnVerVenta.gridy = 2;
		contentPane.add(btnVerVenta, gbc_btnVerVenta);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridx = 3;
		gbc_btnNewButton_4.gridy = 2;
		contentPane.add(btnNewButton_4, gbc_btnNewButton_4);
		
	}
	public VentasFrame() {
		init();
		cargarTabla();
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarTabla();
			}
		});
	}
	public VentasFrame(Usuario usr) {
		init();
		cargarTabla(usr);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarTabla(usr);
			}
		});
	}
	
	private void setModel(){
		table = new JTable();
		scrollPane.setViewportView(table);
		model= new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("cliente");
		model.addColumn("vendedor");
		model.addColumn("total");
		model.addColumn("Fecha");
		table.setModel(model);
	}
	
	private void cargarTabla() {
		setModel();
		List<String[]>Compras=new DaoCompra().getAllToList();
		for(int i=0; i<Compras.size();i++) {
			model.addRow(Compras.get(i));
		}
		lbl1.setText("Ventas totales");
		lblVentas.setText(Compras.size()+"");
	}
	private void cargarTabla(Usuario usr) {
		setModel();
		List<String[]>Compras=new DaoCompra().getSearchToList("vendedor", usr.getPersona().getId()+"");
		for(int i=0; i<Compras.size();i++) {
			model.addRow(Compras.get(i));
		}
		lbl1.setText("Total de tus ventas");
		lblVentas.setText(Compras.size()+"");
	}
	private void buscar() {
		setModel();
		List<String[]>compras=new DaoCompra().getSearchToList("cliente", tfBuscar.getText());
		for(int i=0; i<compras.size();i++) {
			model.addRow(compras.get(i));
		}
		compras=new DaoCompra().getSearchToList("vendedor", tfBuscar.getText());
		for(int i=0; i<compras.size();i++) {
			model.addRow(compras.get(i));
		}

	}

}
