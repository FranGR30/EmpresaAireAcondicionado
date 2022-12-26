package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Controlador;

public class RegistrarClienteGUI extends JFrame{
	private JButton btnVolver,CrearCliente;
	private JLabel CUITLabel,nombreLabel,domicilioLabel,idEmpleadoConectado,nombreEmpleado,idLabel,correoElectronicoLabel;
	private JTextField CUITCliente,nombre,domicilio,correoElectronicoText;
	public RegistrarClienteGUI() {
		super("Menu Registrar Cliente");
		nombreEmpleado = new JLabel();
        idEmpleadoConectado = new JLabel();
        idLabel = new JLabel("ID: ");
        idLabel.setBounds(255,10,220,20);
        nombreEmpleado.setBounds(10,10,220,20);
        idEmpleadoConectado.setBounds(275,10,220,20);
		CUITLabel = new JLabel();
		CUITCliente = new JTextField();
		CUITLabel.setBounds(80,60,200,35);
		CUITLabel.setText("CUIT del cliente:");
		CUITCliente.setBounds(200,60,200,35);
		nombreLabel = new JLabel();
		nombreLabel.setText("Nombre:");
		nombreLabel.setBounds(80,140,200,35);
		nombre = new JTextField();
		nombre.setBounds(200,140,200,35);
		domicilioLabel = new JLabel();
		domicilioLabel.setText("Domicilio:");
		domicilioLabel.setBounds(80,220,200,35);
		domicilio = new JTextField();
		domicilio.setBounds(200,220,200,35);
		correoElectronicoLabel = new JLabel("Correo Electronico: ");
		correoElectronicoLabel.setBounds(80,300,200,35);
		correoElectronicoText = new JTextField();
		correoElectronicoText.setBounds(200,300,200,35);
		//Botones
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(380, 420,100, 35);
		CrearCliente = new JButton("Registrar Cliente");
		CrearCliente.setBounds(120, 360,250, 40);
		ManejoBotones manejoBoton = new ManejoBotones();
		btnVolver.addActionListener(manejoBoton);
		CrearCliente.addActionListener(manejoBoton);
		//
		InicializarVentana();
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		c.add(btnVolver);
		c.add(CUITLabel);
		c.add(CUITCliente);
		c.add(CrearCliente);
		c.add(nombreLabel);
		c.add(nombre);
		c.add(domicilioLabel);
		c.add(domicilio);
		c.add(idEmpleadoConectado);
		c.add(nombreEmpleado);
		c.add(idLabel);
		c.add(correoElectronicoLabel);
		c.add(correoElectronicoText);
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
	
	public JTextField getCUITCliente() {
		return CUITCliente;
	}
	public void setCUITCliente(JTextField cUITCliente) {
		CUITCliente = cUITCliente;
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
					Controlador.getInstancia().volverRegistrarInstalacion(idEmpleadoConectado);
                }
                if(e.getSource()==CrearCliente) {
                	try {
                		if(!CUITCliente.getText().isEmpty() && !nombre.getText().isEmpty() && !domicilio.getText().isEmpty() && !correoElectronicoLabel.getText().isEmpty()) {
	                		Controlador.getInstancia().registrarCliente(Integer.parseInt(CUITCliente.getText()), nombre.getText(),domicilio.getText() ,correoElectronicoText.getText(),Integer.parseInt(idEmpleadoConectado.getText()));
	                		JOptionPane.showMessageDialog(null, "Cliente creado con exito");
	                		setVisible(false);
	                		Controlador.getInstancia().registrarInstalacionGUI(idEmpleadoConectado, CUITCliente);
                		}else {
                			JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
                		}
                	}catch(Exception excepcion) {
                		JOptionPane.showMessageDialog(null, "Por favor ingrese un valor valido");
                	}
                }

			}
	}
}
