package gui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.Persona;
import clases.Usuario;
import dao.DaoPersona;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
public class NuevoUsuario extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsr;
	private JPasswordField tfPwd;
	private JPasswordField tfCPwd;
	
	Persona persona;
	
	private void setPersona(Persona persona) {
		this.persona=persona;
	}
	private Persona getPersona() {
		return this.persona;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoUsuario frame = new NuevoUsuario();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public NuevoUsuario() {
		NuevaPersona nP=new NuevaPersona(this,true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {125, 125, 125, 0};
		gbl_contentPane.rowHeights = new int[]{0, 23, 0, 0, 0, 0, 0, 23, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNuevoUsuario = new JLabel("Nuevo Usuario");
		lblNuevoUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNuevoUsuario = new GridBagConstraints();
		gbc_lblNuevoUsuario.gridwidth = 2;
		gbc_lblNuevoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevoUsuario.gridx = 0;
		gbc_lblNuevoUsuario.gridy = 0;
		contentPane.add(lblNuevoUsuario, gbc_lblNuevoUsuario);
		
		JLabel lblUsuario = new JLabel("Usuario");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 2;
		contentPane.add(lblUsuario, gbc_lblUsuario);
		
		tfUsr = new JTextField();
		GridBagConstraints gbc_tfUsr = new GridBagConstraints();
		gbc_tfUsr.insets = new Insets(0, 0, 5, 5);
		gbc_tfUsr.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfUsr.gridx = 1;
		gbc_tfUsr.gridy = 2;
		contentPane.add(tfUsr, gbc_tfUsr);
		tfUsr.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 3;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		tfPwd = new JPasswordField();
		GridBagConstraints gbc_tfPwd = new GridBagConstraints();
		gbc_tfPwd.insets = new Insets(0, 0, 5, 5);
		gbc_tfPwd.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPwd.gridx = 1;
		gbc_tfPwd.gridy = 3;
		contentPane.add(tfPwd, gbc_tfPwd);
		tfPwd.setColumns(10);
		
		JLabel lblConfirmacionPwd = new JLabel("Confirmacion pwd");
		GridBagConstraints gbc_lblConfirmacionPwd = new GridBagConstraints();
		gbc_lblConfirmacionPwd.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmacionPwd.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmacionPwd.gridx = 0;
		gbc_lblConfirmacionPwd.gridy = 4;
		contentPane.add(lblConfirmacionPwd, gbc_lblConfirmacionPwd);
		
		tfCPwd = new JPasswordField();
		GridBagConstraints gbc_tfCPwd = new GridBagConstraints();
		gbc_tfCPwd.insets = new Insets(0, 0, 5, 5);
		gbc_tfCPwd.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCPwd.gridx = 1;
		gbc_tfCPwd.gridy = 4;
		contentPane.add(tfCPwd, gbc_tfCPwd);
		tfCPwd.setColumns(10);
		
		JLabel lblTipoUsuario = new JLabel("Tipo de usuario");
		GridBagConstraints gbc_lblTipoUsuario = new GridBagConstraints();
		gbc_lblTipoUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblTipoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoUsuario.gridx = 0;
		gbc_lblTipoUsuario.gridy = 5;
		contentPane.add(lblTipoUsuario, gbc_lblTipoUsuario);
		
		JComboBox<String[]> cbTipoUsr = new JComboBox<String[]>();
		cbTipoUsr.setModel(new DefaultComboBoxModel(new String[] {"Estandar", "Administrador"}));
		GridBagConstraints gbc_cbTipoUsr = new GridBagConstraints();
		gbc_cbTipoUsr.insets = new Insets(0, 0, 5, 5);
		gbc_cbTipoUsr.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbTipoUsr.gridx = 1;
		gbc_cbTipoUsr.gridy = 5;
		contentPane.add(cbTipoUsr, gbc_cbTipoUsr);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(!tfUsr.getText().equals("")) {
					if(!tfPwd.getText().equals("")) {
						if(tfCPwd.getText().equals(tfPwd.getText())) {
							Usuario usrAux= (Usuario) new DaoUsuario().getObjectBySecondaryKey(tfUsr.getText());
							if(usrAux.getUsr()==null) {
								if(new DaoPersona().objectToNewRow(getPersona())) {
									Persona aux=(Persona) new DaoPersona().getObject(persona.getNombre(), persona.getApellidoPat(), persona.getApellidoMat());
									Usuario usuario=new Usuario(aux,tfUsr.getText(),tfPwd.getText(),cbTipoUsr.getSelectedIndex()+1);
									if(new DaoUsuario().objectToNewRow(usuario)) {
										JOptionPane.showMessageDialog(null,"Se ha guardado un nuevo usuario");
										dispose();
									}else JOptionPane.showMessageDialog(null,"Ocurrio un error al tratar de escribir los datos de usuario");
								}else {
									Persona aux=(Persona) new DaoPersona().getObject(persona.getNombre(), persona.getApellidoPat(), persona.getApellidoMat());
									if (persona.getNombre()!=null) {
										Usuario usuario=new Usuario(aux,tfUsr.getText(),tfPwd.getText(),cbTipoUsr.getSelectedIndex()+1);
										if(new DaoUsuario().objectToNewRow(usuario)) {
											JOptionPane.showMessageDialog(null,"Se ha guardado un nuevo usuario");
											dispose();
										}else JOptionPane.showMessageDialog(null,"Ocurrio un error al tratar de escribir los datos de usuario");
									}else JOptionPane.showMessageDialog(null,"Ocurrio un error al tratar de escribir los datos personales");
								}
							}else JOptionPane.showMessageDialog(null,"El usuario ya existe, intenta otro");
						}else JOptionPane.showMessageDialog(null,"La confirmacion del password no coincide");
					}else JOptionPane.showMessageDialog(null,"Hace falta llenar password");
				}else JOptionPane.showMessageDialog(null,"Hace falta llenar usuario");
			}
		});
		JButton btnDatosPersonales = new JButton("Datos personales");
		btnDatosPersonales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nP.setVisible(true);
				setPersona(nP.persona);
				if(persona!=null) {
					btnGuardar.setEnabled(true);
				}
			}
		});
		GridBagConstraints gbc_btnDatosPersonales = new GridBagConstraints();
		gbc_btnDatosPersonales.gridwidth = 2;
		gbc_btnDatosPersonales.insets = new Insets(0, 0, 5, 5);
		gbc_btnDatosPersonales.gridx = 0;
		gbc_btnDatosPersonales.gridy = 6;
		contentPane.add(btnDatosPersonales, gbc_btnDatosPersonales);
		
		btnGuardar.setEnabled(false);
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 7;
		contentPane.add(btnGuardar, gbc_btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.gridwidth = 2;
		gbc_btnSalir.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalir.gridx = 0;
		gbc_btnSalir.gridy = 8;
		contentPane.add(btnSalir, gbc_btnSalir);
	}

}
