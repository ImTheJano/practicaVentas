package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Persona;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevaPersona extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombre;
	private JTextField tfApPat;
	private JTextField tfApMat;
	private JTextField tfFechaNac;
	private JTextField tfDireccion;
	private JTextField tfEmail;
	public Persona persona=null;
	
	private void setPersona(Persona persona) {
		this.persona=persona;
	}
	public Persona getPersona() {
		return this.persona;
	}

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public NuevaPersona(Frame parent,Boolean modal) {
		super(parent,modal);
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {125, 125, 125, 0};
		gbl_contentPanel.rowHeights = new int[]{41, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Datos personales");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridwidth = 2;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			tfNombre = new JTextField();
			GridBagConstraints gbc_tfNombre = new GridBagConstraints();
			gbc_tfNombre.insets = new Insets(0, 0, 5, 5);
			gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfNombre.gridx = 1;
			gbc_tfNombre.gridy = 1;
			contentPanel.add(tfNombre, gbc_tfNombre);
			tfNombre.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Apellido pat");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			tfApPat = new JTextField();
			GridBagConstraints gbc_tfApPat = new GridBagConstraints();
			gbc_tfApPat.insets = new Insets(0, 0, 5, 5);
			gbc_tfApPat.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfApPat.gridx = 1;
			gbc_tfApPat.gridy = 2;
			contentPanel.add(tfApPat, gbc_tfApPat);
			tfApPat.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Apellido mat");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 3;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			tfApMat = new JTextField();
			GridBagConstraints gbc_tfApMat = new GridBagConstraints();
			gbc_tfApMat.insets = new Insets(0, 0, 5, 5);
			gbc_tfApMat.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfApMat.gridx = 1;
			gbc_tfApMat.gridy = 3;
			contentPanel.add(tfApMat, gbc_tfApMat);
			tfApMat.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Fecha nac");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 4;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			tfFechaNac = new JTextField();
			GridBagConstraints gbc_tfFechaNac = new GridBagConstraints();
			gbc_tfFechaNac.anchor = GridBagConstraints.NORTH;
			gbc_tfFechaNac.insets = new Insets(0, 0, 5, 5);
			gbc_tfFechaNac.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfFechaNac.gridx = 1;
			gbc_tfFechaNac.gridy = 4;
			contentPanel.add(tfFechaNac, gbc_tfFechaNac);
			tfFechaNac.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Direccion");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 0;
			gbc_lblNewLabel_5.gridy = 5;
			contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			tfDireccion = new JTextField();
			GridBagConstraints gbc_tfDireccion = new GridBagConstraints();
			gbc_tfDireccion.insets = new Insets(0, 0, 5, 5);
			gbc_tfDireccion.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfDireccion.gridx = 1;
			gbc_tfDireccion.gridy = 5;
			contentPanel.add(tfDireccion, gbc_tfDireccion);
			tfDireccion.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("email");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_6.gridx = 0;
			gbc_lblNewLabel_6.gridy = 6;
			contentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		}
		{
			tfEmail = new JTextField();
			GridBagConstraints gbc_tfEmail = new GridBagConstraints();
			gbc_tfEmail.insets = new Insets(0, 0, 0, 5);
			gbc_tfEmail.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfEmail.gridx = 1;
			gbc_tfEmail.gridy = 6;
			contentPanel.add(tfEmail, gbc_tfEmail);
			tfEmail.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!tfNombre.getText().equals("")) {
							if(!tfApPat.getText().equals("")) {
								if(!tfApMat.getText().equals("")) {
									if(!tfFechaNac.getText().equals("")) {
										if(!tfDireccion.getText().equals("")) {
											if(!tfEmail.getText().equals("")){
												Persona p=new Persona(0,tfNombre.getText(),tfApPat.getText(),tfApMat.getText(),tfFechaNac.getText(),tfDireccion.getText(),tfEmail.getText());
												setPersona(p);
												System.out.println("nueva "+getPersona().toString());
												setModal(false);
												setVisible(false);
												//dispose();
											}else JOptionPane.showMessageDialog(null,"Hace falta llenar nomnre");
										}else JOptionPane.showMessageDialog(null,"Hace falta llenar apellido paterno");
									}else JOptionPane.showMessageDialog(null,"Hace falta llenar apellido materno");
								}else JOptionPane.showMessageDialog(null,"Hace falta llenar fecha de nacimiento");
							}else JOptionPane.showMessageDialog(null,"Hace falta llenar direccion");
						}else JOptionPane.showMessageDialog(null,"Hace falta llenar email");
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
