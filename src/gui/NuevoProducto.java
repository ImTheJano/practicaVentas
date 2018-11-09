package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.Producto;
import dao.DaoProducto;
import funciones.Funciones;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class NuevoProducto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfColor;
	private JTextField tfTalla;
	private JTextField tfDetalle;
	private JTextField tfCantidad;
	private JTextField tfPrecio;
	JButton btnNuevo = new JButton("Guardar");
	JButton btnSalir = new JButton("Salir");
	/**
	 * Create the frame.
	 */
	public NuevoProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {125, 125, 125, 0};
		gbl_contentPane.rowHeights = new int[]{32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Nuevo producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblBusqueda = new JLabel("lblBusqueda");
		GridBagConstraints gbc_lblBusqueda = new GridBagConstraints();
		gbc_lblBusqueda.anchor = GridBagConstraints.BELOW_BASELINE_LEADING;
		gbc_lblBusqueda.insets = new Insets(0, 0, 5, 0);
		gbc_lblBusqueda.gridx = 2;
		gbc_lblBusqueda.gridy = 0;
		contentPane.add(lblBusqueda, gbc_lblBusqueda);
		
		JLabel lblNewLabel_1 = new JLabel("Producto");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 1;
		gbc_tfNombre.gridy = 2;
		contentPane.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Color");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tfColor = new JTextField();
		tfColor.setColumns(10);
		GridBagConstraints gbc_tfColor = new GridBagConstraints();
		gbc_tfColor.insets = new Insets(0, 0, 5, 5);
		gbc_tfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfColor.gridx = 1;
		gbc_tfColor.gridy = 3;
		contentPane.add(tfColor, gbc_tfColor);
		
		JLabel lblNewLabel_3 = new JLabel("Talla");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tfTalla = new JTextField();
		tfTalla.setColumns(10);
		GridBagConstraints gbc_tfTalla = new GridBagConstraints();
		gbc_tfTalla.insets = new Insets(0, 0, 5, 5);
		gbc_tfTalla.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTalla.gridx = 1;
		gbc_tfTalla.gridy = 4;
		contentPane.add(tfTalla, gbc_tfTalla);
		
		JLabel lblNewLabel_4 = new JLabel("Detalle");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		tfDetalle = new JTextField();
		GridBagConstraints gbc_tfDetalle = new GridBagConstraints();
		gbc_tfDetalle.insets = new Insets(0, 0, 5, 5);
		gbc_tfDetalle.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDetalle.gridx = 1;
		gbc_tfDetalle.gridy = 5;
		contentPane.add(tfDetalle, gbc_tfDetalle);
		tfDetalle.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Stock");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		tfCantidad = new JTextField();
		GridBagConstraints gbc_tfCantidad = new GridBagConstraints();
		gbc_tfCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_tfCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCantidad.gridx = 1;
		gbc_tfCantidad.gridy = 6;
		contentPane.add(tfCantidad, gbc_tfCantidad);
		tfCantidad.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Precio");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		tfPrecio = new JTextField();
		GridBagConstraints gbc_tfPrecio = new GridBagConstraints();
		gbc_tfPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_tfPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPrecio.gridx = 1;
		gbc_tfPrecio.gridy = 7;
		contentPane.add(tfPrecio, gbc_tfPrecio);
		tfPrecio.setColumns(10);
		
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tfNombre.getText().equals("")) {
					if(!tfColor.getText().equals("")) {
						if(!tfTalla.getText().equals("")) {
							if(!tfDetalle.getText().equals("")) {
								if(!tfCantidad.getText().equals("")) {
									if(Funciones.isNum(tfCantidad.getText())) {
										if(!tfPrecio.getText().equals("")) {
											if(Funciones.isNum(tfPrecio.getText())) {
												Producto producto=new Producto(0,tfNombre.getText(),tfColor.getText(),tfTalla.getText(),tfDetalle.getText(),Integer.parseInt(tfCantidad.getText()),Double.parseDouble(tfPrecio.getText()));
												if(new DaoProducto().objectToNewRow(producto)) {
													JOptionPane.showMessageDialog(null,"Se capturo el producto correctamente");
													dispose();
												}else JOptionPane.showMessageDialog(null,"Ocurrio un error en la captura del producto");
											}else JOptionPane.showMessageDialog(null,"\nPrecio debe ser un dato numerico");
										}else JOptionPane.showMessageDialog(null,"\nHace falta llenar Precio");
									}else JOptionPane.showMessageDialog(null,"\nCantidad debe ser un dato numerico");
								}else JOptionPane.showMessageDialog(null,"\nHace falta llenar Cantidad");
							}else JOptionPane.showMessageDialog(null,"\nHace falta llenar Detalle");
						}else JOptionPane.showMessageDialog(null,"\nHace falta llenar Talla");
					}else JOptionPane.showMessageDialog(null,"\nHace falta llenar Color");
				}else JOptionPane.showMessageDialog(null,"\nHace falta llenar Producto");
			}
		});
		
		btnNuevo.setEnabled(false);
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevo.gridx = 1;
		gbc_btnNuevo.gridy = 8;
		contentPane.add(btnNuevo, gbc_btnNuevo);
		btnNuevo.setEnabled(true);
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalir.gridx = 1;
		gbc_btnSalir.gridy = 9;
		contentPane.add(btnSalir, gbc_btnSalir);
	}

}
