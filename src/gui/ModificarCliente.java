package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import dao.DaoCliente;

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

public class ModificarCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfSaldo;
	private JTextField tfCompras;
	private Cliente Cliente;
	JButton btnModificar = new JButton("Modificar");
	JButton btnSalir = new JButton("Salir");


	/**
	 * Create the frame.
	 */
	public ModificarCliente(String arg) {
		this.Cliente=(Cliente) new DaoCliente().getObject(arg);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {125, 125, 125, 0};
		gbl_contentPane.rowHeights = new int[]{32, 0, 0, 0, 35, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Modificar");
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
		
		JLabel lblNewLabel_1 = new JLabel("Saldo");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfSaldo = new JTextField();
		GridBagConstraints gbc_tfSaldo = new GridBagConstraints();
		gbc_tfSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_tfSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSaldo.gridx = 1;
		gbc_tfSaldo.gridy = 1;
		contentPane.add(tfSaldo, gbc_tfSaldo);
		tfSaldo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Compras");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tfCompras = new JTextField();
		tfCompras.setColumns(10);
		GridBagConstraints gbc_tfCompras = new GridBagConstraints();
		gbc_tfCompras.insets = new Insets(0, 0, 5, 5);
		gbc_tfCompras.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCompras.gridx = 1;
		gbc_tfCompras.gridy = 2;
		contentPane.add(tfCompras, gbc_tfCompras);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=Cliente.getPersona().getId()+"";
				if(!tfSaldo.getText().equals("")) {
					if(!tfCompras.getText().equals("")) {
						String log="";
						if(new DaoCliente().modify("saldo", tfSaldo.getText(),id))log+="\nse actualizo saldo a "+tfSaldo.getText();
						else log+="\nOcurrio un error al tratar de actualizar saldo";
						if(new DaoCliente().modify("compras", tfCompras.getText(),id))log+="\nse actualizo compras a "+tfCompras.getText();
						else log+="\nOcurrio un error al tratar de actualizar compras";
						JOptionPane.showMessageDialog(null,log);
						dispose();
					}else JOptionPane.showMessageDialog(null,"\nHace falta llenar password");
				}else JOptionPane.showMessageDialog(null,"\nHace falta llenar Cliente");
			}
		});
		
		btnModificar.setEnabled(false);
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 0;
		gbc_btnModificar.gridy = 3;
		contentPane.add(btnModificar, gbc_btnModificar);
		btnModificar.setEnabled(true);
		
		tfSaldo.setText(Cliente.getSaldo()+"");
		tfCompras.setText(Cliente.getnCompras()+"");
		lblBusqueda.setText(arg);
		
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalir.gridx = 1;
		gbc_btnSalir.gridy = 3;
		contentPane.add(btnSalir, gbc_btnSalir);
	}

}
