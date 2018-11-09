package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import dao.DaoUsuario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsr;
	private JPasswordField tfPwd;
	private JPasswordField tfCPwd;
	private JComboBox<?> cbTipoUsr;
	private Usuario usuario;
	JButton btnModificar = new JButton("Modificar");
	JButton btnSalir = new JButton("Salir");


	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ModificarUsuario(String arg) {
		this.usuario=(Usuario) new DaoUsuario().getObject(arg);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {125, 125, 125, 0};
		gbl_contentPane.rowHeights = new int[]{32, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfUsr = new JTextField();
		GridBagConstraints gbc_tfUsr = new GridBagConstraints();
		gbc_tfUsr.insets = new Insets(0, 0, 5, 5);
		gbc_tfUsr.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfUsr.gridx = 1;
		gbc_tfUsr.gridy = 2;
		contentPane.add(tfUsr, gbc_tfUsr);
		tfUsr.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tfPwd = new JPasswordField();
		tfPwd.setColumns(10);
		GridBagConstraints gbc_tfPwd = new GridBagConstraints();
		gbc_tfPwd.insets = new Insets(0, 0, 5, 5);
		gbc_tfPwd.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPwd.gridx = 1;
		gbc_tfPwd.gridy = 3;
		contentPane.add(tfPwd, gbc_tfPwd);
		
		JLabel lblNewLabel_3 = new JLabel("Confirmar password");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tfCPwd = new JPasswordField();
		tfCPwd.setColumns(10);
		GridBagConstraints gbc_tfCPwd = new GridBagConstraints();
		gbc_tfCPwd.insets = new Insets(0, 0, 5, 5);
		gbc_tfCPwd.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCPwd.gridx = 1;
		gbc_tfCPwd.gridy = 4;
		contentPane.add(tfCPwd, gbc_tfCPwd);
		
		JLabel lblNewLabel_4 = new JLabel("tipo de ususario");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		cbTipoUsr = new JComboBox();
		cbTipoUsr.setEditable(true);
		cbTipoUsr.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Estandar"}));
		GridBagConstraints gbc_cbTipoUsr = new GridBagConstraints();
		gbc_cbTipoUsr.insets = new Insets(0, 0, 5, 5);
		gbc_cbTipoUsr.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbTipoUsr.gridx = 1;
		gbc_cbTipoUsr.gridy = 5;
		contentPane.add(cbTipoUsr, gbc_cbTipoUsr);
		btnModificar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String id=usuario.getPersona().getId()+"";
				if(!tfUsr.getText().equals("")) {
					if(!tfPwd.getText().equals("")) {
						if(tfCPwd.getText().equals(tfPwd.getText())) {
							String log="";
							int tipoUsuario=cbTipoUsr.getSelectedIndex()+1;
							if(new DaoUsuario().modify("usr", tfUsr.getText(),id))log+="\nse actualizo usuario a "+tfUsr.getText();
							else log+="\nOcurrio un error al tratar de actualizar usuario";
							if(new DaoUsuario().modify("pwd", tfPwd.getText(),id))log+="\nse actualizo password a ***";
							else log+="\nOcurrio un error al tratar de actualizar password";
							if(new DaoUsuario().modify("tipoUsuario",""+tipoUsuario,id))log+="\nse actualizo tipo de usuario a "+((tipoUsuario==1)?"Administrador":"Estandar");
							else log+="\nOcurrio un error al tratar de actualizar el tipo de usuario";
							JOptionPane.showMessageDialog(null,log);
							dispose();
						}else JOptionPane.showMessageDialog(null,"\nNo se confirmo el password correctamente");
					}else JOptionPane.showMessageDialog(null,"\nHace falta llenar password");
				}else JOptionPane.showMessageDialog(null,"\nHace falta llenar usuario");
			}
		});
		
		btnModificar.setEnabled(false);
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 0;
		gbc_btnModificar.gridy = 7;
		contentPane.add(btnModificar, gbc_btnModificar);
		btnModificar.setEnabled(true);
		
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalir.gridx = 1;
		gbc_btnSalir.gridy = 7;
		contentPane.add(btnSalir, gbc_btnSalir);
		
		tfUsr.setText(usuario.getUsr());
		cbTipoUsr.setSelectedIndex(usuario.getTipoUsuario()-1);
		tfPwd.setText(usuario.getPwd());
		tfCPwd.setText(usuario.getPwd());
		lblBusqueda.setText(arg);
	}

}
