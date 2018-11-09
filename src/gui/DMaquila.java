package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.Usuario;
import dao.DaoUsuario;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DMaquila {

	private JFrame frame;
	private JTextField tfUsr;
	private JPasswordField tfPwd;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DMaquila window = new DMaquila();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DMaquila() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 196);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 2, 2, 10));
		
		lblNewLabel_1 = new JLabel("Acceso al sistema");
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblUsuario = new JLabel("Usuario");
		frame.getContentPane().add(lblUsuario);
		
		tfUsr = new JTextField();
		frame.getContentPane().add(tfUsr);
		tfUsr.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Contraseña");
		frame.getContentPane().add(lblNewLabel);
		
		tfPwd = new JPasswordField();
		frame.getContentPane().add(tfPwd);
		
		btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(tfUsr.getText().equals(""))JOptionPane.showMessageDialog(frame, "No se ingreso el usuario");
				if(tfPwd.getText().equals(""))JOptionPane.showMessageDialog(frame, "No se ingreso el password");
				if(!tfUsr.getText().equals("") && !tfPwd.getText().equals("")) {
					Usuario u=(Usuario) new DaoUsuario().getObjectBySecondaryKey(tfUsr.getText());
					System.out.println(u.toString());
					if(u.getUsr()!=null) {
						if(u.getPwd().equals(tfPwd.getText())) {
							JOptionPane.showMessageDialog(frame, "Bienvenido");
							if(u.getTipoUsuario()==1) {
								Admin.init(u);
								frame.dispose();
							}
							if(u.getTipoUsuario()==2) {
								new Venta(u).setVisible(true);
								frame.dispose();
							}
							
						}
						else JOptionPane.showMessageDialog(frame, "Password incorrecto");
					}else JOptionPane.showMessageDialog(frame, "No se encontro el usuario");
				}
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Salir");
		frame.getContentPane().add(btnNewButton_1);
	}

}
