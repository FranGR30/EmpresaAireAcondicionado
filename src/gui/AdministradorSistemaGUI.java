package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Controlador;

public class AdministradorSistemaGUI extends JFrame{
	private JButton menuTecnicos,btnVolver,menuArticulos;
	private JLabel idEmpleadoConectado,nombreEmpleado,idLabel;
	public AdministradorSistemaGUI() {
		super("Menu Administrador de sistema");
		nombreEmpleado = new JLabel();
        idEmpleadoConectado = new JLabel();
        idLabel = new JLabel("ID: ");
        idLabel.setBounds(255,10,220,20);
        nombreEmpleado.setBounds(10,10,220,20);
        idEmpleadoConectado.setBounds(275,10,220,20);
		//Container
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		//Botones
		menuTecnicos = new JButton("Tecnicos");
		menuTecnicos.setBounds(130,100,235,65);
		btnVolver = new JButton("Cerrar sesión");
		btnVolver.setBounds(130, 250, 235, 65);
		menuArticulos = new JButton("Articulos");
		menuArticulos.setBounds(130,175,235,65);
		ManejoBotones manejoBoton = new ManejoBotones();
		btnVolver.addActionListener(manejoBoton);
		menuTecnicos.addActionListener(manejoBoton);
		menuArticulos.addActionListener(manejoBoton);
		//Agregado de botones/paneles
		InicializarVentana();
		c.add(btnVolver);
		c.add(menuTecnicos);
		c.add(idEmpleadoConectado);
		c.add(nombreEmpleado);
		c.add(idLabel);
		c.add(menuArticulos);
	}
	private void InicializarVentana() {
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public class ManejoBotones implements ActionListener {
		public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnVolver) {
					setVisible(false);
					Principal principal = new Principal();
					principal.setVisible(true);
                }
                if(e.getSource()==menuTecnicos) {
					setVisible(false);
					Controlador.getInstancia().menuTecnicosGUI(idEmpleadoConectado);
                }
                if(e.getSource()==menuArticulos) {
					setVisible(false);
					Controlador.getInstancia().menuArticuloGUI(idEmpleadoConectado);
                } 
			}
	}
	public JLabel getIdEmpleadoConectado() {
		return idEmpleadoConectado;
	}
	public void setIdEmpleadoConectado(JLabel idEmpleadoConectado) {
		this.idEmpleadoConectado = idEmpleadoConectado;
	}
	public JLabel getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(JLabel nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	
}

