package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.Persona;
import clases.Cliente;
import dao.DaoPersona;
import dao.DaoCliente;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientesFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfBuscar;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_4;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnEditar;
	private JButton btnEliminar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientesFrame frame = new ClientesFrame();
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
	public ClientesFrame() {
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
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarTabla();
			}
		});
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
		
		cargarTabla();
		
		btnNewButton_1 = new JButton("Nuevo cliente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoCliente.main(null);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 2;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		btnNewButton_4 = new JButton("Salir");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sel=table.getSelectedRow();
				if(!table.getModel().getValueAt(sel,0).equals(""))new ModificarCliente((String) table.getModel().getValueAt(sel,0)).setVisible(true);
			}
		});
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditar.gridx = 1;
		gbc_btnEditar.gridy = 2;
		contentPane.add(btnEditar, gbc_btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sel=table.getSelectedRow();
				if(!table.getModel().getValueAt(sel,0).equals("")) {
					int conf = JOptionPane.showConfirmDialog(null, "Realmente desea eliminar el cliente?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(conf==0) {
						if(new DaoCliente().deleteRow((String)table.getModel().getValueAt(sel,0))) {
							JOptionPane.showMessageDialog(null,"Se ha eliminado un cliente");
							cargarTabla();
						}else JOptionPane.showMessageDialog(null,"O");
					}
				}
			}
		});
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEliminar.gridx = 2;
		gbc_btnEliminar.gridy = 2;
		contentPane.add(btnEliminar, gbc_btnEliminar);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridx = 3;
		gbc_btnNewButton_4.gridy = 2;
		contentPane.add(btnNewButton_4, gbc_btnNewButton_4);
	}
	
	private void setModel(){
		table = new JTable();
		scrollPane.setViewportView(table);
		model= new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("E-mail");
		model.addColumn("Saldo");
		model.addColumn("Compras");
		table.setModel(model);
	}
	
	private void cargarTabla() {
		setModel();
		List<String[]>clientes=new DaoCliente().getAllToList();
		for(int i=0; i<clientes.size();i++) {
			Persona persona=(Persona) new DaoPersona().getObject(clientes.get(i)[0]);
			Object []obj=new Object[6];
			obj[0]=clientes.get(i)[0];
			obj[1]=persona.getNombre();
			obj[2]=persona.getApellidoPat();
			obj[3]=persona.getEmail();
			obj[4]=clientes.get(i)[1];
			obj[5]=clientes.get(i)[2];
			model.addRow(obj);
		}
	}
	private void buscar() {
		setModel();
		List<String[]>clientes=new DaoCliente().getSearchToList("saldo", tfBuscar.getText());
		for(int i=0; i<clientes.size();i++) {
			Persona persona=(Persona) new DaoPersona().getObject(clientes.get(i)[0]);
			Object []obj=new Object[6];
			obj[0]=clientes.get(i)[0];
			obj[1]=persona.getNombre();
			obj[2]=persona.getApellidoPat();
			obj[3]=persona.getEmail();
			obj[4]=clientes.get(i)[1];
			obj[5]=clientes.get(i)[3].equals("1")?"administrador":"estandar";
			model.addRow(obj);
		}
		List<String[]>personas=new DaoPersona().getSearchToList("nombre", tfBuscar.getText());
		for(int i=0; i<personas.size();i++) {
			Cliente aux=(Cliente) new DaoCliente().getObject(personas.get(i)[0]);
			if(aux.getPersona()!=null) {
				Object []obj=new Object[6];
				obj[0]=personas.get(i)[0];
				obj[1]=personas.get(i)[1];
				obj[2]=personas.get(i)[2];
				obj[3]=personas.get(i)[6];
				obj[4]=aux.getSaldo();
				obj[5]=aux.getnCompras();
				model.addRow(obj);
			}
		}
		personas=new DaoPersona().getSearchToList("apellidoPat", tfBuscar.getText());

		for(int i=0; i<personas.size();i++) {
			Cliente aux=(Cliente) new DaoCliente().getObject(personas.get(i)[0]);
			if(aux.getPersona()!=null) {
				Object []obj=new Object[6];
				obj[0]=personas.get(i)[0];
				obj[1]=personas.get(i)[1];
				obj[2]=personas.get(i)[2];
				obj[3]=personas.get(i)[6];
				obj[4]=aux.getSaldo();
				obj[5]=aux.getnCompras();
				model.addRow(obj);
			}
		}
	}

}
