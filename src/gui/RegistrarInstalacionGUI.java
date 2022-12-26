package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import controller.Controlador;
import models.Fecha;

public class RegistrarInstalacionGUI extends JFrame{
	private JButton btnVolver,buscarCliente,RegistrarInstalacion;
	private JLabel CUITLabel,fechaLabel,tunoLabel,tipoFacturaLabel,idEmpleadoConectado,nombreEmpleado,idLabel,nombreClienteLabel,nombreCliente;
	private JTextField CUITCliente;
	private JComboBox<String> turno,tipoFactura;
	private JSpinner fecha;
	Date date;
	int idEmpleado;
	public RegistrarInstalacionGUI() {
		super("Menu Registrar Instalacion");
		nombreEmpleado = new JLabel();
        idEmpleadoConectado = new JLabel();
        idLabel = new JLabel("ID: ");
        idLabel.setBounds(255,10,220,20);
        nombreEmpleado.setBounds(10,10,220,20);
        idEmpleadoConectado.setBounds(275,10,220,20);
        nombreClienteLabel = new JLabel();
        nombreClienteLabel.setText("Nombre cliente:");
        nombreClienteLabel.setBounds(50,80,100,35);
        nombreClienteLabel.setVisible(false);
        nombreCliente = new JLabel();
        nombreCliente.setText("CUIT");
        nombreCliente.setBounds(150,80,100,35);
        nombreCliente.setVisible(false);
		CUITLabel = new JLabel();
		CUITCliente = new JTextField();
		CUITLabel.setBounds(50,40,100,35);
		CUITLabel.setText("CUIT del cliente:");
		CUITCliente.setBounds(150,40,100,35);
		fechaLabel = new JLabel();
		fechaLabel.setText("Fecha:");
		fechaLabel.setBounds(50,120,100,35);
		fechaLabel.setVisible(false);
		tunoLabel = new JLabel();
		tunoLabel.setText("Turno:");
		tunoLabel.setBounds(50,160,100,35);
		tunoLabel.setVisible(false);
		turno = new JComboBox<String>();
		turno.setBounds(150,160,100,35);
		turno.addItem("mañana");
		turno.addItem("tarde");
		turno.setVisible(false);
		tipoFacturaLabel = new JLabel();
		tipoFacturaLabel.setText("Tipo de factura:");
		tipoFacturaLabel.setBounds(50,200,100,35);
		tipoFacturaLabel.setVisible(false);
		tipoFactura = new JComboBox<>();
		tipoFactura.addItem("A");
		tipoFactura.addItem("B");
		tipoFactura.setBounds(150,200,100,35);
		tipoFactura.setVisible(false);
		//Spinner
		date = new Date();
		SpinnerDateModel sm = new SpinnerDateModel(date,null,null,Calendar.DATE);
		fecha = new JSpinner(sm);
		JSpinner.DateEditor de = new JSpinner.DateEditor(fecha, "dd/M/yy");
		fecha.setEditor(de);
		fecha.setBounds(150,120,100,35);
		fecha.setVisible(false);
		//Botones
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(380, 420,100, 35);
		buscarCliente = new JButton("Buscar cliente");
		buscarCliente.setBounds(255,40,150,35);
		RegistrarInstalacion = new JButton("Registrar Instalacion");
		RegistrarInstalacion.setBounds(120, 360,250, 40);
		RegistrarInstalacion.setVisible(false);
		ManejoBotones manejoBoton = new ManejoBotones();
		btnVolver.addActionListener(manejoBoton);
		buscarCliente.addActionListener(manejoBoton);
		RegistrarInstalacion.addActionListener(manejoBoton);
		//
		InicializarVentana();
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		c.add(btnVolver);
		c.add(CUITLabel);
		c.add(CUITCliente);
		c.add(buscarCliente);
		c.add(fechaLabel);
		c.add(turno);
		c.add(tunoLabel);
		c.add(tipoFacturaLabel);
		c.add(tipoFactura);
		c.add(RegistrarInstalacion);
		c.add(idEmpleadoConectado);
		c.add(nombreEmpleado);
		c.add(idLabel);
		c.add(nombreClienteLabel);
		c.add(nombreCliente);
		c.add(fecha);
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
					Controlador.getInstancia().volverOperadorCallCenterGUI(idEmpleadoConectado);
                }
                if(e.getSource()==buscarCliente) {
                	try {
					if(Controlador.getInstancia().buscarCliente(Integer.parseInt(CUITCliente.getText()))) {
						CUITLabel.setVisible(true);
						fechaLabel.setVisible(true);
						tunoLabel.setVisible(true);
						tipoFacturaLabel.setVisible(true);
						CUITCliente.setVisible(true);
						turno.setVisible(true);
						tipoFactura.setVisible(true);
						RegistrarInstalacion.setVisible(true);
						nombreClienteLabel.setVisible(true);
				        if(CUITCliente != null) {
				        	nombreCliente.setText(Controlador.getInstancia().devolverNombreCliente(Integer.parseInt(CUITCliente.getText())));
				        }
				        nombreCliente.setVisible(true);
				        fecha.setVisible(true);

					}else {
						JOptionPane.showMessageDialog(null, "No se encontro el cliente");
						setVisible(false);
						Controlador.getInstancia().registrarClienteGUI(idEmpleadoConectado, CUITCliente);
					}}
                	catch(Exception excepcion) {
                		JOptionPane.showMessageDialog(null, "Por favor ingrese un numero de CUIT valido");
                	}
                }
                if(e.getSource()==RegistrarInstalacion) {
                	try {
                	DateFormat dateFormat = new SimpleDateFormat("dd/M/yy");
                	String date = dateFormat.format(fecha.getValue());
                	if(Controlador.getInstancia().validarFecha(date)) {
                		if(Controlador.getInstancia().buscarCliente(Integer.parseInt(CUITCliente.getText()))){
                			if(Controlador.getInstancia().hayFechaDisponible(date, turno.getSelectedItem().toString())) {
                				if(!Controlador.getInstancia().existeInstalacion(Integer.parseInt(CUITCliente.getText()))) {
                					if(!Controlador.getInstancia().informarFaltanteStock()) {
			                			Controlador.getInstancia().registrarInstalacionFromGUI(Integer.parseInt(CUITCliente.getText()),date,turno.getSelectedItem().toString(), tipoFactura.getSelectedItem().toString(), Integer.parseInt(idEmpleadoConectado.getText()));
			                			JOptionPane.showMessageDialog(null, "Instalacion registrada correctamente");
			                			setVisible(false);
			            				Controlador.getInstancia().volverOperadorCallCenterGUI(idEmpleadoConectado);
                					}else {
                						JOptionPane.showMessageDialog(null, "No hay stock disponible para pactar la instalacion");
                					}
                				}else {
                					JOptionPane.showMessageDialog(null, "El cliente ya tiene una instalacion pactada");      					
                				}
                			}else {
                				JOptionPane.showMessageDialog(null, "No hay tecnicos disponibles para la fecha y turno solicitado");
                			}
                		}else {
                			JOptionPane.showMessageDialog(null, "No se encontro el cliente");
                		}
                	}else{
                		JOptionPane.showMessageDialog(null, "Por favor ingrese una fecha valida");
                	}
                	}catch(Exception excepcion){
                		JOptionPane.showMessageDialog(null, excepcion);
                	}
                }
			}
	}

	public JTextField getCUITCliente() {
		return CUITCliente;
	}
	public void setCUITCliente(JTextField cUITCliente) {
		CUITCliente = cUITCliente;
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
