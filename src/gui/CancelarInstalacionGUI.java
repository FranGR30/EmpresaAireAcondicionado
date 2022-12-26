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

public class CancelarInstalacionGUI extends JFrame{
	private JButton btnVolver,buscarCliente,cancelarInstalacion;
	private JLabel CUITLabel,fechaLabel,idEmpleadoConectado,nombreEmpleado,idLabel,nombreClienteLabel,nombreCliente,estadoLabel,estadoInstalacionLabel,fechaInstalacion;
	private JTextField CUITCliente;
	int idEmpleado;
	public CancelarInstalacionGUI() {
		super("Cancelar Instalacion");
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
		fechaInstalacion = new JLabel();
		fechaInstalacion.setBounds(150,120,100,35);
		fechaInstalacion.setVisible(false);
		estadoLabel = new JLabel();
		estadoLabel.setText("Estado:");
		estadoLabel.setBounds(50,160,100,35);
		estadoLabel.setVisible(false);
		estadoInstalacionLabel = new JLabel();
		estadoInstalacionLabel.setBounds(150,160,100,35);
		estadoInstalacionLabel.setVisible(false);
		//Botones
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(380, 420,100, 35);
		buscarCliente = new JButton("Buscar cliente");
		buscarCliente.setBounds(255,40,150,35);
		cancelarInstalacion = new JButton("Cancelar Instalacion");
		cancelarInstalacion.setBounds(120, 360,250, 40);
		cancelarInstalacion.setVisible(false);
		ManejoBotones manejoBoton = new ManejoBotones();
		btnVolver.addActionListener(manejoBoton);
		buscarCliente.addActionListener(manejoBoton);
		cancelarInstalacion.addActionListener(manejoBoton);
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
		c.add(fechaInstalacion);
		c.add(cancelarInstalacion);
		c.add(idEmpleadoConectado);
		c.add(nombreEmpleado);
		c.add(idLabel);
		c.add(nombreClienteLabel);
		c.add(nombreCliente);
		c.add(estadoLabel);
		c.add(estadoInstalacionLabel);
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
						if(Controlador.getInstancia().existeInstalacionProgramada(Integer.parseInt(CUITCliente.getText()))) {

							CUITLabel.setVisible(true);
							fechaLabel.setVisible(true);
							CUITCliente.setVisible(true);
							fechaInstalacion.setVisible(true);
							fechaInstalacion.setText(Controlador.getInstancia().devolverFechaInstalacion(Integer.parseInt(CUITCliente.getText())));
							cancelarInstalacion.setVisible(true);
							nombreClienteLabel.setVisible(true);
					        nombreCliente.setText(Controlador.getInstancia().devolverNombreCliente(Integer.parseInt(CUITCliente.getText())));
					        nombreCliente.setVisible(true);
					        estadoLabel.setVisible(true);
					        estadoInstalacionLabel.setVisible(true);
					        estadoInstalacionLabel.setText(Controlador.getInstancia().devolverEstadoInstalacion(Integer.parseInt(CUITCliente.getText())));
						}else {
							JOptionPane.showMessageDialog(null, "No se encontraron instalaciones en estado programada para el cliente seleccionado");
						}
					}else {
						JOptionPane.showMessageDialog(null, "No se encontro el cliente");
						setVisible(false);
						Controlador.getInstancia().volverOperadorCallCenterGUI(idEmpleadoConectado);
					}}
                	catch(Exception excepcion) {
                		JOptionPane.showMessageDialog(null, "Por favor ingrese un numero de CUIT valido");
                	}
                }
                if(e.getSource()==cancelarInstalacion) {
                	int idInstalacion = Controlador.getInstancia().devolverIdInstalacion(Integer.parseInt(CUITCliente.getText()));
                	Controlador.getInstancia().cancelarInstalacion(idInstalacion,Integer.parseInt(idEmpleadoConectado.getText()));
                	JOptionPane.showMessageDialog(null, "Instalacion eliminada correctamente");
                	setVisible(false);
                	Controlador.getInstancia().volverOperadorCallCenterGUI(idEmpleadoConectado);
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
