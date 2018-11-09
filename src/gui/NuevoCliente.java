package gui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.Persona;
import clases.Cliente;
import dao.DaoPersona;
import funciones.Funciones;
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
public class NuevoCliente extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfSaldo;
	JButton btnGuardar;
	
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
					NuevoCliente frame = new NuevoCliente();
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
	public NuevoCliente() {
		NuevaPersona nP=new NuevaPersona(this,true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {125, 125, 125, 0};
		gbl_contentPane.rowHeights = new int[]{0, 23, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNuevoCliente = new JLabel("Nuevo Cliente");
		lblNuevoCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNuevoCliente = new GridBagConstraints();
		gbc_lblNuevoCliente.gridwidth = 2;
		gbc_lblNuevoCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevoCliente.gridx = 0;
		gbc_lblNuevoCliente.gridy = 0;
		contentPane.add(lblNuevoCliente, gbc_lblNuevoCliente);
		
		JLabel lblCliente = new JLabel("Saldo inicial");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 2;
		contentPane.add(lblCliente, gbc_lblCliente);
		
		tfSaldo = new JTextField();
		tfSaldo.setText("00.00");
		GridBagConstraints gbc_tfSaldo = new GridBagConstraints();
		gbc_tfSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_tfSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSaldo.gridx = 1;
		gbc_tfSaldo.gridy = 2;
		contentPane.add(tfSaldo, gbc_tfSaldo);
		tfSaldo.setColumns(10);
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
		gbc_btnDatosPersonales.gridy = 3;
		contentPane.add(btnDatosPersonales, gbc_btnDatosPersonales);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tfSaldo.getText().equals("")){
					if(Funciones.isNum(tfSaldo.getText())) {
						if(new DaoPersona().objectToNewRow(getPersona())) {
							Persona aux=(Persona) new DaoPersona().getObject(persona.getNombre(), persona.getApellidoPat(), persona.getApellidoMat());
							Cliente Cliente=new Cliente(aux,Double.parseDouble(tfSaldo.getText()),0);
							if(new DaoCliente().objectToNewRow(Cliente)) {
								JOptionPane.showMessageDialog(null,"Se ha guardado un nuevo Cliente");
								dispose();
							}else JOptionPane.showMessageDialog(null,"Ocurrio un error al tratar de escribir los datos de Cliente");
						}else {
							Persona aux=(Persona) new DaoPersona().getObject(persona.getNombre(), persona.getApellidoPat(), persona.getApellidoMat());
							if (persona.getNombre()!=null) {
								Cliente Cliente=new Cliente(aux,Double.parseDouble(tfSaldo.getText()),0);
								if(new DaoCliente().objectToNewRow(Cliente)) {
									JOptionPane.showMessageDialog(null,"Se ha guardado un nuevo Cliente");
									dispose();
								}else JOptionPane.showMessageDialog(null,"Ocurrio un error al tratar de escribir los datos de Cliente");
							}else JOptionPane.showMessageDialog(null,"Ocurrio un error al tratar de escribir los datos personales");
						}
					}else JOptionPane.showMessageDialog(null,"Saldo debe ser un dato numerico");
				}else JOptionPane.showMessageDialog(null,"Hace falta llenar Saldo");
			}
		});
		
		btnGuardar.setEnabled(false);
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 4;
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
		gbc_btnSalir.gridy = 5;
		contentPane.add(btnSalir, gbc_btnSalir);
	}

}
