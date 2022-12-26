package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Controlador;

public class MenuArticulosGUI extends JFrame{
	private JButton menuModificarStock,btnVolver,menuModificarCostos;
	private JLabel idEmpleadoConectado,nombreEmpleado,idLabel;
	public MenuArticulosGUI() {
		super("Menu Articulos");
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
		menuModificarStock = new JButton("Modificar Stock");
		menuModificarStock.setBounds(130,100,235,65);
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(380, 420,100, 35);
		menuModificarCostos = new JButton("Modificar precio");
		menuModificarCostos.setBounds(130,175,235,65);
		ManejoBotones manejoBoton = new ManejoBotones();
		btnVolver.addActionListener(manejoBoton);
		menuModificarStock.addActionListener(manejoBoton);
		menuModificarCostos.addActionListener(manejoBoton);
		//Agregado de botones/paneles
		InicializarVentana();
		c.add(btnVolver);
		c.add(menuModificarCostos);
		c.add(idEmpleadoConectado);
		c.add(nombreEmpleado);
		c.add(idLabel);
		c.add(menuModificarStock);
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
					Controlador.getInstancia().administradorSistemaGUI(idEmpleadoConectado);
                }
                if(e.getSource()==menuModificarStock) {
					setVisible(false);
					Controlador.getInstancia().menuModificarStockArticulos(idEmpleadoConectado);
                }
                if(e.getSource()==menuModificarCostos) {
					setVisible(false);
					Controlador.getInstancia().modificarPrecioArticulos(idEmpleadoConectado);
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

