package gui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.Compra;
import clases.Producto;
import dao.DaoCompra;
import dao.DaoProducto;
import dao.DaoProductoCompra;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DetalleVenta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfVendedor;
	private JTable table;
	private JTextField tfNombreCliente;
	private JTextField tfTotal;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	private Compra compra;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetalleVenta frame = new DetalleVenta(null);
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
	public DetalleVenta(String id) {
		compra=(Compra) new DaoCompra().getObject(id);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {84, 75, 75, 75, 75, 75, 75, 75, 75, 75, 0};
		gbl_contentPane.rowHeights = new int[]{-13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblVendedor = new GridBagConstraints();
		gbc_lblVendedor.anchor = GridBagConstraints.EAST;
		gbc_lblVendedor.insets = new Insets(0, 0, 5, 5);
		gbc_lblVendedor.gridx = 0;
		gbc_lblVendedor.gridy = 0;
		contentPane.add(lblVendedor, gbc_lblVendedor);
		
		tfVendedor = new JTextField();
		tfVendedor.setEditable(false);
		GridBagConstraints gbc_tfVendedor = new GridBagConstraints();
		gbc_tfVendedor.insets = new Insets(0, 0, 5, 5);
		gbc_tfVendedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfVendedor.gridx = 1;
		gbc_tfVendedor.gridy = 0;
		contentPane.add(tfVendedor, gbc_tfVendedor);
		tfVendedor.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 13;
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblVenta = new JLabel("Venta");
		lblVenta.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblVenta = new GridBagConstraints();
		gbc_lblVenta.insets = new Insets(0, 0, 5, 5);
		gbc_lblVenta.gridx = 0;
		gbc_lblVenta.gridy = 1;
		contentPane.add(lblVenta, gbc_lblVenta);
		
		JLabel lblNombreCliente = new JLabel("Nombre cliente");
		GridBagConstraints gbc_lblNombreCliente = new GridBagConstraints();
		gbc_lblNombreCliente.anchor = GridBagConstraints.EAST;
		gbc_lblNombreCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCliente.gridx = 0;
		gbc_lblNombreCliente.gridy = 2;
		contentPane.add(lblNombreCliente, gbc_lblNombreCliente);
		
		tfNombreCliente = new JTextField();
		tfNombreCliente.setEditable(false);
		GridBagConstraints gbc_tfNombreCliente = new GridBagConstraints();
		gbc_tfNombreCliente.anchor = GridBagConstraints.NORTH;
		gbc_tfNombreCliente.gridwidth = 2;
		gbc_tfNombreCliente.insets = new Insets(0, 0, 5, 5);
		gbc_tfNombreCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombreCliente.gridx = 1;
		gbc_tfNombreCliente.gridy = 2;
		contentPane.add(tfNombreCliente, gbc_tfNombreCliente);
		tfNombreCliente.setColumns(10);
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar");
		GridBagConstraints gbc_lblTotalAPagar = new GridBagConstraints();
		gbc_lblTotalAPagar.anchor = GridBagConstraints.EAST;
		gbc_lblTotalAPagar.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalAPagar.gridx = 0;
		gbc_lblTotalAPagar.gridy = 3;
		contentPane.add(lblTotalAPagar, gbc_lblTotalAPagar);
		
		tfTotal = new JTextField();
		tfTotal.setEditable(false);
		GridBagConstraints gbc_tfTotal = new GridBagConstraints();
		gbc_tfTotal.gridwidth = 2;
		gbc_tfTotal.insets = new Insets(0, 0, 5, 5);
		gbc_tfTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTotal.gridx = 1;
		gbc_tfTotal.gridy = 3;
		contentPane.add(tfTotal, gbc_tfTotal);
		tfTotal.setColumns(10);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.gridx = 9;
		gbc_btnSalir.gridy = 13;
		contentPane.add(btnSalir, gbc_btnSalir);
		
		tfVendedor.setText(compra.getVendedor().getUsr());
		tfNombreCliente.setText(compra.getCliente().getPersona().getNombre()+" "+compra.getCliente().getPersona().getApellidoPat());
		tfTotal.setText(compra.getTotal()+"");
		cargarTabla();
	}
	
	private void setModel(){
		table = new JTable();
		scrollPane.setViewportView(table);
		model= new DefaultTableModel();
		model.addColumn("Producto");
		model.addColumn("Descripcion");
		model.addColumn("Precio");
		model.addColumn("Cantidad");
		model.addColumn("Total");
		table.setModel(model);
	}
	private void cargarTabla() {
		setModel();
		List<String[]>cp=new DaoProductoCompra().getSearchToList("compra", compra.getId()+"");
		for(int i=0; i<cp.size();i++) {
			Producto p=(Producto) new DaoProducto().getObject(cp.get(i)[0]);
			String[] row=new String[5];
			row[0]=p.getNombre();
			row[1]=p.getColor()+" "+p.getTalla()+" "+p.getDetalle();
			row[2]=p.getPrecio()+"";
			row[3]=cp.get(i)[2];
			row[4]=(p.getPrecio()*Double.parseDouble(cp.get(i)[2]))+"";
			model.addRow(row);
		}
	}

}
