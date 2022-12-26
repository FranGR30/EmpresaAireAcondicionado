package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Controlador;

public class OperadorCallCenterGUI extends JFrame{
	private JButton registrarInstalacion,btnVolver,cancelarInstalacion;
	private JLabel idEmpleadoConectado,nombreEmpleado,idLabel;
	public OperadorCallCenterGUI() {
		super("Menu OperadorCallCenter");
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
		registrarInstalacion = new JButton("Registrar Instalacion");
		registrarInstalacion.setBounds(130,100,235,65);
		btnVolver = new JButton("Cerrar sesión");
		btnVolver.setBounds(130, 250, 235, 65);
		cancelarInstalacion = new JButton("Cancelar Instalacion");
		cancelarInstalacion.setBounds(130,175,235,65);
		ManejoBotones manejoBoton = new ManejoBotones();
		btnVolver.addActionListener(manejoBoton);
		registrarInstalacion.addActionListener(manejoBoton);
		cancelarInstalacion.addActionListener(manejoBoton);
		//Agregado de botones/paneles
		InicializarVentana();
		c.add(btnVolver);
		c.add(registrarInstalacion);
		c.add(idEmpleadoConectado);
		c.add(nombreEmpleado);
		c.add(idLabel);
		c.add(cancelarInstalacion);
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
                if(e.getSource()==registrarInstalacion) {
					setVisible(false);
					Controlador.getInstancia().registrarInstalacionGUI(idEmpleadoConectado);
                }
                if(e.getSource()==cancelarInstalacion) {
					setVisible(false);
					Controlador.getInstancia().cancelarInstalacionGUI(idEmpleadoConectado);
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

