package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import controller.Controlador;

@SuppressWarnings("serial")
public class Principal extends JFrame {
	
	public Principal() {
		super("Menu principal");
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		JPanel menuPrincipal = new JPanel();
		menuPrincipal.setLayout(new GridLayout(2,1,5,5));
		menuPrincipal.setBackground(Color.WHITE);
		menuPrincipal.setBorder(new MatteBorder(20,20,20,20,Color.white) );
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		p.setBackground(Color.WHITE);
		
		JLabel Usuario = new JLabel("Usuario: ");
		JLabel Contraseña = new JLabel("Contraseña: ");
		JTextField UsuarioCampo = new JTextField();
		JTextField ContraseñaCampo = new JTextField();
		JButton btnIngresar=new JButton("Ingresar");

		menuPrincipal.add(Usuario);
		menuPrincipal.add(UsuarioCampo);
		menuPrincipal.add(Contraseña);
		menuPrincipal.add(ContraseñaCampo);
		p.add(btnIngresar);

		this.setVisible(true);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(menuPrincipal,BorderLayout.CENTER);
		this.add(p,BorderLayout.CENTER);
		
		btnIngresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnIngresar) {
					try {
					String auxiliarID = UsuarioCampo.getText();
					int id = Integer.parseInt(auxiliarID);
					String auxiliarContraseña = ContraseñaCampo.getText();
					int contraseña = Integer.parseInt(auxiliarContraseña);
					if(Controlador.getInstancia().chequearAcceso(id) != null) {
						if(id == contraseña) {
						JOptionPane.showMessageDialog(null, "¡Bienvenido  "+Controlador.getInstancia().getNombreEmpleado(id)+"!");
						if(Controlador.getInstancia().chequearAcceso(id).getNombre() == "Tecnico") {
							setVisible(false);
							TecnicoGUI tecnicoGUI = new TecnicoGUI();
							tecnicoGUI.setVisible(true);   	
							tecnicoGUI.getIdEmpleadoConectado().setText(auxiliarID);
							tecnicoGUI.getNombreEmpleado().setText("Nombre: "+Controlador.getInstancia().getNombreEmpleado(id));
						}   
						else if(Controlador.getInstancia().chequearAcceso(id).getNombre() == "Operador de call center") {
							setVisible(false);
							OperadorCallCenterGUI operadorCallCenterGUI = new OperadorCallCenterGUI();
							operadorCallCenterGUI.setVisible(true); 
							operadorCallCenterGUI.getIdEmpleadoConectado().setText(auxiliarID);
							operadorCallCenterGUI.getNombreEmpleado().setText("Nombre: "+Controlador.getInstancia().getNombreEmpleado(id));
						}
						else if(Controlador.getInstancia().chequearAcceso(id).getNombre() == "Administrativo"){
							setVisible(false);
							AdministrativoGUI administrativoGUI = new AdministrativoGUI();
							administrativoGUI.setVisible(true); 
							administrativoGUI.getIdEmpleadoConectado().setText(auxiliarID);
							administrativoGUI.getNombreEmpleado().setText("Nombre: " + Controlador.getInstancia().getNombreEmpleado(id));
						}
						else if (Controlador.getInstancia().chequearAcceso(id).getNombre() == "Administrador de sistema") {
							setVisible(false);
							AdministradorSistemaGUI administradorSistemaGUI = new AdministradorSistemaGUI();
							administradorSistemaGUI.setVisible(true); 
							administradorSistemaGUI.getIdEmpleadoConectado().setText(auxiliarID);
							administradorSistemaGUI.getNombreEmpleado().setText("Nombre: "+Controlador.getInstancia().getNombreEmpleado(id));
						}
						}
						else {
							JOptionPane.showMessageDialog(null, "La contraseña que ingresó es incorrecta");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "El id que ingresó es incorrecto");
					}
				}
				catch(Exception excepcion) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese un usuario y contraseña validos");
				}
				}
			}
			
		});
		
	}
}
