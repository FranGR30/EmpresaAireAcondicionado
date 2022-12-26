package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controller.Controlador;

public class ModificarPrecioArticulos extends JFrame{
	private JButton btnVolver,aplicarPrecioCondensadora,aplicarPrecioEvaporadora,aplicarPrecioKitInstalacion;
	private JLabel condensadoraLabel,kitInstalacionLabel,evaporadoraLabel,idEmpleadoConectado,nombreEmpleado,idLabel,precioLabel,precioCondensadora,precioEvaporadora,precioKitInstalacion,nuevoPrecioLabel;
	private JSpinner condensadoraSpinner,kitInstalacionSpinner,evaporadoraSpinner;
	public ModificarPrecioArticulos() {
		super("Menu Precio Articulos");
		nombreEmpleado = new JLabel();
        idEmpleadoConectado = new JLabel();
        idLabel = new JLabel("ID: ");
        idLabel.setBounds(255,10,220,20);
        nombreEmpleado.setBounds(10,10,220,20);
        idEmpleadoConectado.setBounds(275,10,220,20);
        nuevoPrecioLabel = new JLabel();
        nuevoPrecioLabel.setBounds(270,40,160,35);
        nuevoPrecioLabel.setText("Nuevo precio:");
        precioLabel = new JLabel();
        precioLabel.setBounds(175,40,160,35);
        precioLabel.setText("Precio actual:");
        precioCondensadora = new JLabel();
        precioCondensadora.setBounds(200,80,160,35);
        precioEvaporadora = new JLabel();
        precioEvaporadora.setBounds(200,280,160,35);
        precioKitInstalacion = new JLabel();
        precioKitInstalacion.setBounds(200,180,160,35);
        condensadoraLabel = new JLabel();
        SpinnerNumberModel snm = new SpinnerNumberModel(0.0,-999999999.0,999999999.0,0.1);
        condensadoraSpinner = new JSpinner(snm);
		condensadoraLabel.setBounds(30,80,160,35);
		condensadoraLabel.setText("Stock de Condensadora:");
		condensadoraSpinner.setBounds(280,80,60,35);
		kitInstalacionLabel = new JLabel();
		kitInstalacionLabel.setText("Stock de Kit de Instalacion:");
		kitInstalacionLabel.setBounds(30,180,160,35);
		SpinnerNumberModel snm2 = new SpinnerNumberModel(0.0,-999999999.0,999999999.0,0.1);
		kitInstalacionSpinner = new JSpinner(snm2);
		kitInstalacionSpinner.setBounds(280,180,60,35);
		evaporadoraLabel = new JLabel();
		evaporadoraLabel.setText("Stock de Evaporadora:");
		evaporadoraLabel.setBounds(30,280,160,35);
		SpinnerNumberModel snm3 = new SpinnerNumberModel(0.0,-999999999.0,999999999.0,0.1);
		evaporadoraSpinner = new JSpinner(snm3);
		evaporadoraSpinner.setBounds(280,280,60,35);
		//Botones
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(380, 420,100, 35);
		aplicarPrecioCondensadora = new JButton("Modificar precio");
		aplicarPrecioCondensadora.setBounds(350,80,130,35);
		aplicarPrecioEvaporadora = new JButton("Modificar precio");
		aplicarPrecioEvaporadora.setBounds(350,280,130,35);
		aplicarPrecioKitInstalacion = new JButton("Modificar precio");
		aplicarPrecioKitInstalacion.setBounds(350,180,130,35);
		ManejoBotones manejoBoton = new ManejoBotones();
		btnVolver.addActionListener(manejoBoton);
		aplicarPrecioCondensadora.addActionListener(manejoBoton);
		aplicarPrecioEvaporadora.addActionListener(manejoBoton);
		aplicarPrecioKitInstalacion.addActionListener(manejoBoton);
		//
		InicializarVentana();
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		c.add(btnVolver);
		c.add(condensadoraLabel);
		c.add(condensadoraSpinner);
		c.add(kitInstalacionLabel);
		c.add(kitInstalacionSpinner);
		c.add(evaporadoraLabel);
		c.add(evaporadoraSpinner);
		c.add(idEmpleadoConectado);
		c.add(nombreEmpleado);
		c.add(idLabel);
		c.add(precioLabel);
		c.add(precioCondensadora);
		c.add(precioEvaporadora);
		c.add(precioKitInstalacion);
		c.add(nuevoPrecioLabel);
		c.add(aplicarPrecioCondensadora);
		c.add(aplicarPrecioEvaporadora);
		c.add(aplicarPrecioKitInstalacion);
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
	
	public JLabel getPrecioCondensadora() {
		return precioCondensadora;
	}
	public void setPrecioCondensadora(JLabel precioCondensadora) {
		this.precioCondensadora = precioCondensadora;
	}
	public JLabel getPrecioEvaporadora() {
		return precioEvaporadora;
	}
	public void setPrecioEvaporadora(JLabel precioEvaporadora) {
		this.precioEvaporadora = precioEvaporadora;
	}
	public JLabel getPrecioKitInstalacion() {
		return precioKitInstalacion;
	}
	public void setPrecioKitInstalacion(JLabel precioKitInstalacion) {
		this.precioKitInstalacion = precioKitInstalacion;
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
					Controlador.getInstancia().menuArticuloGUI(idEmpleadoConectado);
                }
                if(e.getSource()==aplicarPrecioCondensadora) {
                	if((Double.parseDouble(condensadoraSpinner.getValue().toString())) >= 0) {
	                	Controlador.getInstancia().modificarPrecioCondensadora(Double.parseDouble(condensadoraSpinner.getValue().toString()),Integer.parseInt(idEmpleadoConectado.getText()));
	                	JOptionPane.showMessageDialog(null, "Precio de condensadora modificado correctamente");
	                	setVisible(false);
	                	Controlador.getInstancia().modificarPrecioArticulos(idEmpleadoConectado);
                	}
                	else {
                		JOptionPane.showMessageDialog(null, "Precio de condensadora no puede ser menor a 0");
                	}
                }
				if(e.getSource()==aplicarPrecioEvaporadora) {
					if((Double.parseDouble(evaporadoraSpinner.getValue().toString())) >= 0) {
						Controlador.getInstancia().modificarPrecioEvaporadora(Double.parseDouble(evaporadoraSpinner.getValue().toString()),Integer.parseInt(idEmpleadoConectado.getText()));
	                	JOptionPane.showMessageDialog(null, "Precio de evaporadora modificado correctamente");
	                	setVisible(false);
	                	Controlador.getInstancia().modificarPrecioArticulos(idEmpleadoConectado);
					}else {
						JOptionPane.showMessageDialog(null, "Precio de evaporadora no puede ser menor a 0");
					}
				}				
				if(e.getSource()==aplicarPrecioKitInstalacion) {
					if((Double.parseDouble(kitInstalacionSpinner.getValue().toString())) >= 0) {
						Controlador.getInstancia().modificarPrecioKitInstalacion(Double.parseDouble(kitInstalacionSpinner.getValue().toString()),Integer.parseInt(idEmpleadoConectado.getText()));
	                	JOptionPane.showMessageDialog(null, "Precio de kit de instalacion modificado correctamente");
	                	setVisible(false);
	                	Controlador.getInstancia().modificarPrecioArticulos(idEmpleadoConectado);
					}else {
						JOptionPane.showMessageDialog(null, "Precio del kit de instalacion no puede ser menor a 0");
					}
				}
			}
	}
}
