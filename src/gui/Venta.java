package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Compra;
import clases.Producto;
import clases.ProductoCompra;
import clases.Usuario;
import dao.DaoCliente;
import dao.DaoCompra;
import dao.DaoProducto;
import dao.DaoProductoCompra;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;

public class Venta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfVendedor;
	private JTextField tfCodigoProducto;
	private JSpinner sCantidad;
	private JTextField tfPrecioProducto;
	private JTextField tfNombreProducto;
	private JTextField tfDescripcionProducto;
	private JTable table;
	private JTextField tfIdCliente;
	private JTextField tfNombreCliente;
	private JTextField tfTotalProductos;
	private JTextField tfTotal;
	private JTextField tfTotalProducto;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	
	private Producto producto;
	private List<ProductoCompra> venta;
	private int totalProductos=0;
	private double totalPagar=0;
	private Cliente cliente;
	private String fecha;
	private Usuario vendedor;
	DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Venta frame = new Venta(null);
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
	public Venta(Usuario usr) {
		this.vendedor=usr;
		venta=new ArrayList<ProductoCompra>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {42, 75, 75, 75, 75, 75, 75, 75, 75, 75, 75, 75, 0};
		gbl_contentPane.rowHeights = new int[]{-13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblVendedor = new GridBagConstraints();
		gbc_lblVendedor.anchor = GridBagConstraints.EAST;
		gbc_lblVendedor.insets = new Insets(0, 0, 5, 5);
		gbc_lblVendedor.gridx = 1;
		gbc_lblVendedor.gridy = 0;
		contentPane.add(lblVendedor, gbc_lblVendedor);
		
		tfVendedor = new JTextField();
		tfVendedor.setEditable(false);
		tfVendedor.setText(usr.getUsr());
		GridBagConstraints gbc_tfVendedor = new GridBagConstraints();
		gbc_tfVendedor.insets = new Insets(0, 0, 5, 5);
		gbc_tfVendedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfVendedor.gridx = 2;
		gbc_tfVendedor.gridy = 0;
		contentPane.add(tfVendedor, gbc_tfVendedor);
		tfVendedor.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 16;
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 4;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnVerVentas = new JButton("ver ventas");
		btnVerVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentasFrame(vendedor).setVisible(true);
			}
		});
		GridBagConstraints gbc_btnVerVentas = new GridBagConstraints();
		gbc_btnVerVentas.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerVentas.gridx = 11;
		gbc_btnVerVentas.gridy = 0;
		contentPane.add(btnVerVentas, gbc_btnVerVentas);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblProducto = new GridBagConstraints();
		gbc_lblProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProducto.gridx = 1;
		gbc_lblProducto.gridy = 1;
		contentPane.add(lblProducto, gbc_lblProducto);
		
		JLabel lblCodigo = new JLabel("Codigo");
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.anchor = GridBagConstraints.EAST;
		gbc_lblCodigo.gridx = 1;
		gbc_lblCodigo.gridy = 2;
		contentPane.add(lblCodigo, gbc_lblCodigo);
		
		tfCodigoProducto = new JTextField();
		GridBagConstraints gbc_tfCodigoProducto = new GridBagConstraints();
		gbc_tfCodigoProducto.insets = new Insets(0, 0, 5, 5);
		gbc_tfCodigoProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCodigoProducto.gridx = 2;
		gbc_tfCodigoProducto.gridy = 2;
		contentPane.add(tfCodigoProducto, gbc_tfCodigoProducto);
		tfCodigoProducto.setColumns(10);
		
		JButton btnBuscarProducto = new JButton("Buscar");
		btnBuscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				producto=(Producto) new DaoProducto().getObject(tfCodigoProducto.getText());
				if(producto!=null) {
					tfNombreProducto.setText(producto.getNombre());
					tfPrecioProducto.setText(producto.getPrecio()+"");
					tfDescripcionProducto.setText(producto.getColor()+" "+producto.getTalla()+" "+producto.getDetalle());
					double totalProducto=producto.getPrecio()*Double.parseDouble(sCantidad.getValue().toString());
					tfTotalProducto.setText(totalProducto+"");
				}else JOptionPane.showMessageDialog(null,"No se encontro el producto");
			}
		});
		GridBagConstraints gbc_btnBuscarProducto = new GridBagConstraints();
		gbc_btnBuscarProducto.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_btnBuscarProducto.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscarProducto.gridx = 3;
		gbc_btnBuscarProducto.gridy = 2;
		contentPane.add(btnBuscarProducto, gbc_btnBuscarProducto);
		
		JLabel lblBuscarProductoPor = new JLabel("Buscar producto por codigo");
		GridBagConstraints gbc_lblBuscarProductoPor = new GridBagConstraints();
		gbc_lblBuscarProductoPor.gridwidth = 2;
		gbc_lblBuscarProductoPor.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuscarProductoPor.gridx = 1;
		gbc_lblBuscarProductoPor.gridy = 3;
		contentPane.add(lblBuscarProductoPor, gbc_lblBuscarProductoPor);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		gbc_lblCantidad.anchor = GridBagConstraints.EAST;
		gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad.gridx = 1;
		gbc_lblCantidad.gridy = 4;
		contentPane.add(lblCantidad, gbc_lblCantidad);
		
		sCantidad = new JSpinner();
		sCantidad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(producto!=null) {
					double totalProducto=producto.getPrecio()*Double.parseDouble(sCantidad.getValue().toString());
					tfTotalProducto.setText(totalProducto+"");
				}
			}
		});
		sCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		GridBagConstraints gbc_sCantidad = new GridBagConstraints();
		gbc_sCantidad.gridwidth = 2;
		gbc_sCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_sCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_sCantidad.gridx = 2;
		gbc_sCantidad.gridy = 4;
		contentPane.add(sCantidad, gbc_sCantidad);
		
		JLabel lblPrecio = new JLabel("Precio");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 5;
		contentPane.add(lblPrecio, gbc_lblPrecio);
		
		tfPrecioProducto = new JTextField();
		tfPrecioProducto.setEditable(false);
		GridBagConstraints gbc_tfPrecioProducto = new GridBagConstraints();
		gbc_tfPrecioProducto.gridwidth = 2;
		gbc_tfPrecioProducto.insets = new Insets(0, 0, 5, 5);
		gbc_tfPrecioProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPrecioProducto.gridx = 2;
		gbc_tfPrecioProducto.gridy = 5;
		contentPane.add(tfPrecioProducto, gbc_tfPrecioProducto);
		tfPrecioProducto.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 6;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		tfNombreProducto = new JTextField();
		tfNombreProducto.setEditable(false);
		GridBagConstraints gbc_tfNombreProducto = new GridBagConstraints();
		gbc_tfNombreProducto.gridwidth = 2;
		gbc_tfNombreProducto.insets = new Insets(0, 0, 5, 5);
		gbc_tfNombreProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombreProducto.gridx = 2;
		gbc_tfNombreProducto.gridy = 6;
		contentPane.add(tfNombreProducto, gbc_tfNombreProducto);
		tfNombreProducto.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 7;
		contentPane.add(lblDescripcion, gbc_lblDescripcion);
		
		tfDescripcionProducto = new JTextField();
		tfDescripcionProducto.setFont(new Font("Tahoma", Font.PLAIN, 9));
		tfDescripcionProducto.setEditable(false);
		GridBagConstraints gbc_tfDescripcionProducto = new GridBagConstraints();
		gbc_tfDescripcionProducto.gridwidth = 2;
		gbc_tfDescripcionProducto.insets = new Insets(0, 0, 5, 5);
		gbc_tfDescripcionProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDescripcionProducto.gridx = 2;
		gbc_tfDescripcionProducto.gridy = 7;
		contentPane.add(tfDescripcionProducto, gbc_tfDescripcionProducto);
		tfDescripcionProducto.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 1;
		gbc_lblTotal.gridy = 8;
		contentPane.add(lblTotal, gbc_lblTotal);
		
		tfTotalProducto = new JTextField();
		tfTotalProducto.setEditable(false);
		GridBagConstraints gbc_tfTotalProducto = new GridBagConstraints();
		gbc_tfTotalProducto.gridwidth = 2;
		gbc_tfTotalProducto.insets = new Insets(0, 0, 5, 5);
		gbc_tfTotalProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTotalProducto.gridx = 2;
		gbc_tfTotalProducto.gridy = 8;
		contentPane.add(tfTotalProducto, gbc_tfTotalProducto);
		tfTotalProducto.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(producto!=null) {
					if(producto.getCantidad()>Integer.parseInt(sCantidad.getValue().toString())) {
						int index=buscarEnVenta(producto.getId());
						if(index>-1) {
							ProductoCompra pc=new ProductoCompra(new Compra(), producto, Integer.parseInt(sCantidad.getValue().toString()));
							venta.set(index, pc);
						}else {
							ProductoCompra pc=new ProductoCompra(new Compra(), producto, Integer.parseInt(sCantidad.getValue().toString()));
							venta.add(pc);
						}
						cargarTabla();
					}else JOptionPane.showMessageDialog(null, "No hay suficientes");
				}
			}
		});
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregar.gridx = 3;
		gbc_btnAgregar.gridy = 9;
		contentPane.add(btnAgregar, gbc_btnAgregar);
		
		JLabel lblVenta = new JLabel("Venta");
		lblVenta.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblVenta = new GridBagConstraints();
		gbc_lblVenta.insets = new Insets(0, 0, 5, 5);
		gbc_lblVenta.gridx = 1;
		gbc_lblVenta.gridy = 10;
		contentPane.add(lblVenta, gbc_lblVenta);
		
		JLabel lblCliente = new JLabel("Id cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 11;
		contentPane.add(lblCliente, gbc_lblCliente);
		
		tfIdCliente = new JTextField();
		GridBagConstraints gbc_tfIdCliente = new GridBagConstraints();
		gbc_tfIdCliente.insets = new Insets(0, 0, 5, 5);
		gbc_tfIdCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfIdCliente.gridx = 2;
		gbc_tfIdCliente.gridy = 11;
		contentPane.add(tfIdCliente, gbc_tfIdCliente);
		tfIdCliente.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente=(Cliente) new DaoCliente().getObject(tfIdCliente.getText());
				if(cliente!=null) {
					tfNombreCliente.setText(cliente.getPersona().getNombre()+" "+cliente.getPersona().getApellidoPat());
					if(cliente.getSaldo()>0) JOptionPane.showMessageDialog(null,"Este cliente cuenta con un saldo de $"+cliente.getSaldo()+" que podra utilizar en esta compra");
					if(cliente.getSaldo()<0) JOptionPane.showMessageDialog(null,"Este cliente tiene un adeudo de $"+cliente.getSaldo());
				}
			}
		});
		GridBagConstraints gbc_btnBuscarCliente = new GridBagConstraints();
		gbc_btnBuscarCliente.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscarCliente.gridx = 3;
		gbc_btnBuscarCliente.gridy = 11;
		contentPane.add(btnBuscarCliente, gbc_btnBuscarCliente);
		
		JLabel lblNombreCliente = new JLabel("Nombre cliente");
		GridBagConstraints gbc_lblNombreCliente = new GridBagConstraints();
		gbc_lblNombreCliente.anchor = GridBagConstraints.EAST;
		gbc_lblNombreCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCliente.gridx = 1;
		gbc_lblNombreCliente.gridy = 12;
		contentPane.add(lblNombreCliente, gbc_lblNombreCliente);
		
		tfNombreCliente = new JTextField();
		tfNombreCliente.setEditable(false);
		GridBagConstraints gbc_tfNombreCliente = new GridBagConstraints();
		gbc_tfNombreCliente.anchor = GridBagConstraints.NORTH;
		gbc_tfNombreCliente.gridwidth = 2;
		gbc_tfNombreCliente.insets = new Insets(0, 0, 5, 5);
		gbc_tfNombreCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombreCliente.gridx = 2;
		gbc_tfNombreCliente.gridy = 12;
		contentPane.add(tfNombreCliente, gbc_tfNombreCliente);
		tfNombreCliente.setColumns(10);
		
		JLabel lblTotalProductos = new JLabel("Total productos");
		GridBagConstraints gbc_lblTotalProductos = new GridBagConstraints();
		gbc_lblTotalProductos.anchor = GridBagConstraints.EAST;
		gbc_lblTotalProductos.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalProductos.gridx = 1;
		gbc_lblTotalProductos.gridy = 13;
		contentPane.add(lblTotalProductos, gbc_lblTotalProductos);
		
		tfTotalProductos = new JTextField();
		tfTotalProductos.setEditable(false);
		GridBagConstraints gbc_tfTotalProductos = new GridBagConstraints();
		gbc_tfTotalProductos.gridwidth = 2;
		gbc_tfTotalProductos.insets = new Insets(0, 0, 5, 5);
		gbc_tfTotalProductos.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTotalProductos.gridx = 2;
		gbc_tfTotalProductos.gridy = 13;
		contentPane.add(tfTotalProductos, gbc_tfTotalProductos);
		tfTotalProductos.setColumns(10);
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar");
		GridBagConstraints gbc_lblTotalAPagar = new GridBagConstraints();
		gbc_lblTotalAPagar.anchor = GridBagConstraints.EAST;
		gbc_lblTotalAPagar.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalAPagar.gridx = 1;
		gbc_lblTotalAPagar.gridy = 14;
		contentPane.add(lblTotalAPagar, gbc_lblTotalAPagar);
		
		tfTotal = new JTextField();
		tfTotal.setEditable(false);
		GridBagConstraints gbc_tfTotal = new GridBagConstraints();
		gbc_tfTotal.gridwidth = 2;
		gbc_tfTotal.insets = new Insets(0, 0, 5, 5);
		gbc_tfTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTotal.gridx = 2;
		gbc_tfTotal.gridy = 14;
		contentPane.add(tfTotal, gbc_tfTotal);
		tfTotal.setColumns(10);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cliente!=null) {
					if(venta.size()>0) {
						String log="Ingresa la cantidad que el cliente pagara\nEl total por la compra es: $"+totalPagar;
						if(cliente.getSaldo()>0) {
							if(totalPagar<cliente.getSaldo())log+="El cliente puede pagar con su saldo a favor toda la compra";
							else log+="El cliente tiene saldo a favor, su total a pagar es: $"+(totalPagar-cliente.getSaldo());
						}
						if(cliente.getSaldo()<0)log+="El cliente tiene un adeudo, su total a pagar es: $"+(totalPagar+cliente.getSaldo());
						double pago=Double.parseDouble(JOptionPane.showInputDialog(log));
						if(pago>=0) {
							fecha=hourdateFormat.format(new Date())+"";
							if(pago+cliente.getSaldo()<totalPagar)JOptionPane.showMessageDialog(null,"Quedara un adeudo de "+(cliente.getSaldo()-(totalPagar-pago)));
							if(pago+cliente.getSaldo()>totalPagar)JOptionPane.showMessageDialog(null,"El saldo del cliente "+(cliente.getSaldo()+(pago-totalPagar)));
							Compra c=new Compra(0,cliente,vendedor,totalPagar,fecha);
							if(new DaoCompra().objectToNewRow(c)) {
								System.out.println("exito");
								new DaoCliente().modify("saldo", cliente.getSaldo()-pago+"", cliente.getPersona().getId()+"");
								Compra _compra=(Compra) new DaoCompra().getObject(cliente.getPersona().getId()+"",fecha);
								for(int i=0;i<venta.size();i++) {
									ProductoCompra _pc=new ProductoCompra(_compra,venta.get(i).getProducto(),venta.get(i).getCantidad());
									new DaoProductoCompra().objectToNewRow(_pc);
									new DaoProducto().modify("cantidad", venta.get(i).getProducto().getCantidad()-venta.get(i).getCantidad()+"", venta.get(i).getProducto().getId()+"");
								}
								venta = new ArrayList<ProductoCompra>();
								cargarTabla();
								JOptionPane.showMessageDialog(null,"Se completo la venta"+(cliente.getSaldo()+(pago-totalPagar)));
							}
						}
					}
				}
			}
		});
		GridBagConstraints gbc_btnPagar = new GridBagConstraints();
		gbc_btnPagar.insets = new Insets(0, 0, 5, 5);
		gbc_btnPagar.gridx = 3;
		gbc_btnPagar.gridy = 15;
		contentPane.add(btnPagar, gbc_btnPagar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalir.gridx = 10;
		gbc_btnSalir.gridy = 16;
		contentPane.add(btnSalir, gbc_btnSalir);
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
		totalProductos=0;;
		totalPagar=0;
		for(int i=0; i<venta.size();i++) {
			String[] row=new String[5];
			row[0]=venta.get(i).getProducto().getNombre();
			row[1]=venta.get(i).getProducto().getColor()+" "+venta.get(i).getProducto().getTalla()+" "+venta.get(i).getProducto().getDetalle();
			row[2]=venta.get(i).getProducto().getPrecio()+"";
			row[3]=venta.get(i).getCantidad()+"";
			row[4]=(venta.get(i).getProducto().getPrecio()*venta.get(i).getCantidad())+"";
			totalProductos+=venta.get(i).getCantidad();
			totalPagar+=venta.get(i).getProducto().getPrecio()*venta.get(i).getCantidad();
			model.addRow(row);
		}
		tfTotalProductos.setText(totalProductos+"");
		tfTotal.setText(totalPagar+"");
	}
	private int buscarEnVenta(int id) {
		for(int i=0;i<venta.size();i++)
			if(venta.get(i).getProducto().getId()==id)return i;
		return -1;
	}

}
