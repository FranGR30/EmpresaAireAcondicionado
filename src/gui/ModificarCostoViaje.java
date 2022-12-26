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

public class ModificarCostoViaje extends JFrame{
	private JButton btnVolver,aplicarCostoViaje;
	private JLabel costoViajeLabel,idEmpleadoConectado,nombreEmpleado,idLabel,costoViajeActualLabel,costoViajeActual,nuevoCostoViaje;
	private JSpinner costoViajeSpinner;
	public ModificarCostoViaje() {
		super("Menu Salario Tecnicos");
		nombreEmpleado = new JLabel();
        idEmpleadoConectado = new JLabel();
        idLabel = new JLabel("ID: ");
        idLabel.setBounds(255,10,220,20);
        nombreEmpleado.setBounds(10,10,220,20);
        idEmpleadoConectado.setBounds(275,10,220,20);
        nuevoCostoViaje = new JLabel();
        nuevoCostoViaje.setBounds(290,40,160,35);
        nuevoCostoViaje.setText("Nuevo Costo de viaje:");
        costoViajeActualLabel = new JLabel();
        costoViajeActualLabel.setBounds(155,40,160,35);
        costoViajeActualLabel.setText("Costo de viaje actual:");
        costoViajeActual = new JLabel();
        costoViajeActual.setBounds(200,80,160,35);
        costoViajeLabel = new JLabel();
        SpinnerNumberModel snm = new SpinnerNumberModel(0.0,-999999999.0,999999999.0,0.1);
        costoViajeSpinner = new JSpinner(snm);
        costoViajeLabel.setBounds(30,80,160,35);
        costoViajeLabel.setText("Costo de Viaje:");
        costoViajeSpinner.setBounds(300,80,60,35);
		//Botones
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(380, 420,100, 35);
		aplicarCostoViaje = new JButton("Modificar Costo");
		aplicarCostoViaje.setBounds(370,80,150,35);
		ManejoBotones manejoBoton = new ManejoBotones();
		btnVolver.addActionListener(manejoBoton);
		aplicarCostoViaje.addActionListener(manejoBoton);

		//
		InicializarVentana();
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		c.add(btnVolver);
		c.add(costoViajeLabel);
		c.add(costoViajeSpinner);
		c.add(idEmpleadoConectado);
		c.add(nombreEmpleado);
		c.add(idLabel);
		c.add(costoViajeActualLabel);
		c.add(costoViajeActual);
		c.add(nuevoCostoViaje);
		c.add(aplicarCostoViaje);

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
	
	public JLabel getCostoViajeActual() {
		return costoViajeActual;
	}
	public void setCostoViajeActual(JLabel costoViajeActual) {
		this.costoViajeActual = costoViajeActual;
	}
	private void InicializarVentana() {
		this.setVisible(true);
		this.setSize(550, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public class ManejoBotones implements ActionListener {
		public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnVolver) {
                	setVisible(false);
					Controlador.getInstancia().menuTecnicosGUI(idEmpleadoConectado);
                }
                if(e.getSource()==aplicarCostoViaje) {
                	if((Double.parseDouble(costoViajeSpinner.getValue().toString())) >= 0) {
	                	Controlador.getInstancia().modificarCostoViaje(Double.parseDouble(costoViajeSpinner.getValue().toString()),Integer.parseInt(idEmpleadoConectado.getText()));
	                	JOptionPane.showMessageDialog(null, "Costo de viaje modificado correctamente");
	                	setVisible(false);
	                	Controlador.getInstancia().modificarCostoViaje(idEmpleadoConectado);
                	}
                	else {
                		JOptionPane.showMessageDialog(null, "Costo de viaje no puede ser menor a 0");
                	}
                }
			}
	}
}
