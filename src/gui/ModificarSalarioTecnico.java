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

public class ModificarSalarioTecnico extends JFrame{
	private JButton btnVolver,aplicarSenior,aplicarSemiSenior,aplicarJunior;
	private JLabel SeniorLabel,JuniorLabel,SemiSeniorLabel,idEmpleadoConectado,nombreEmpleado,idLabel,SalarioLabel,salarioSenior,salarioSemiSenior,salarioJunior,nuevoSalarioLabel;
	private JSpinner SeniorSpinner,JuniorSpinner,semiSeniorSpinner;
	public ModificarSalarioTecnico() {
		super("Menu Salario Tecnicos");
		nombreEmpleado = new JLabel();
        idEmpleadoConectado = new JLabel();
        idLabel = new JLabel("ID: ");
        idLabel.setBounds(255,10,220,20);
        nombreEmpleado.setBounds(10,10,220,20);
        idEmpleadoConectado.setBounds(275,10,220,20);
        nuevoSalarioLabel = new JLabel();
        nuevoSalarioLabel.setBounds(270,40,160,35);
        nuevoSalarioLabel.setText("Nuevo Salario:");
        SalarioLabel = new JLabel();
        SalarioLabel.setBounds(175,40,160,35);
        SalarioLabel.setText("Salario actual:");
        salarioSenior = new JLabel();
        salarioSenior.setBounds(200,80,160,35);
        salarioSemiSenior = new JLabel();
        salarioSemiSenior.setBounds(200,280,160,35);
        salarioJunior = new JLabel();
        salarioJunior.setBounds(200,180,160,35);
        SeniorLabel = new JLabel();
        SpinnerNumberModel snm = new SpinnerNumberModel(0.0,-999999999.0,999999999.0,0.1);
        SeniorSpinner = new JSpinner(snm);
        SeniorLabel.setBounds(30,80,160,35);
        SeniorLabel.setText("Salario Senior:");
        SeniorSpinner.setBounds(280,80,60,35);
		JuniorLabel = new JLabel();
		JuniorLabel.setText("Salario Junior:");
		JuniorLabel.setBounds(30,180,160,35);
		SpinnerNumberModel snm2 = new SpinnerNumberModel(0.0,-999999999.0,999999999.0,0.1);
		JuniorSpinner = new JSpinner(snm2);
		JuniorSpinner.setBounds(280,180,60,35);
		SemiSeniorLabel = new JLabel();
		SemiSeniorLabel.setText("Salario SemiSenior:");
		SemiSeniorLabel.setBounds(30,280,160,35);
		SpinnerNumberModel snm3 = new SpinnerNumberModel(0.0,-999999999.0,999999999.0,0.1);
		semiSeniorSpinner = new JSpinner(snm3);
		semiSeniorSpinner.setBounds(280,280,60,35);
		//Botones
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(380, 420,100, 35);
		aplicarSenior = new JButton("Modificar Senior");
		aplicarSenior.setBounds(350,80,150,35);
		aplicarSemiSenior = new JButton("Modificar SemiSenior");
		aplicarSemiSenior.setBounds(350,280,150,35);
		aplicarJunior = new JButton("Modificar Junior");
		aplicarJunior.setBounds(350,180,150,35);
		ManejoBotones manejoBoton = new ManejoBotones();
		btnVolver.addActionListener(manejoBoton);
		aplicarSenior.addActionListener(manejoBoton);
		aplicarSemiSenior.addActionListener(manejoBoton);
		aplicarJunior.addActionListener(manejoBoton);
		//
		InicializarVentana();
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		c.add(btnVolver);
		c.add(SeniorLabel);
		c.add(SeniorSpinner);
		c.add(JuniorLabel);
		c.add(JuniorSpinner);
		c.add(SemiSeniorLabel);
		c.add(semiSeniorSpinner);
		c.add(idEmpleadoConectado);
		c.add(nombreEmpleado);
		c.add(idLabel);
		c.add(SalarioLabel);
		c.add(salarioSenior);
		c.add(salarioSemiSenior);
		c.add(salarioJunior);
		c.add(nuevoSalarioLabel);
		c.add(aplicarSenior);
		c.add(aplicarSemiSenior);
		c.add(aplicarJunior);
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
	
	public JLabel getSalarioSenior() {
		return salarioSenior;
	}
	public void setSalarioSenior(JLabel salarioSenior) {
		this.salarioSenior = salarioSenior;
	}
	public JLabel getSalarioSemiSenior() {
		return salarioSemiSenior;
	}
	public void setSalarioSemiSenior(JLabel salarioSemiSenior) {
		this.salarioSemiSenior = salarioSemiSenior;
	}
	public JLabel getSalarioJunior() {
		return salarioJunior;
	}
	public void setSalarioJunior(JLabel salarioJunior) {
		this.salarioJunior = salarioJunior;
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
                if(e.getSource()==aplicarSenior) {
                	if((Double.parseDouble(SeniorSpinner.getValue().toString())) >= 0) {
	                	Controlador.getInstancia().modificarSalarioSenior(Double.parseDouble(SeniorSpinner.getValue().toString()),Integer.parseInt(idEmpleadoConectado.getText()));
	                	JOptionPane.showMessageDialog(null, "Salario de senior modificado correctamente");
	                	setVisible(false);
	                	Controlador.getInstancia().modificarSalarioTecnico(idEmpleadoConectado);
                	}
                	else {
                		JOptionPane.showMessageDialog(null, "Salario de senior no puede ser menor a 0");
                	}
                }
				if(e.getSource()==aplicarSemiSenior) {
					if((Double.parseDouble(semiSeniorSpinner.getValue().toString())) >= 0) {
						Controlador.getInstancia().modificarSalarioSemiSenior(Double.parseDouble(semiSeniorSpinner.getValue().toString()),Integer.parseInt(idEmpleadoConectado.getText()));
	                	JOptionPane.showMessageDialog(null, "Salario de Semi Senior modificado correctamente");
	                	setVisible(false);
	                	Controlador.getInstancia().modificarSalarioTecnico(idEmpleadoConectado);
					}else {
						JOptionPane.showMessageDialog(null, "Salario de Semi Senior no puede ser menor a 0");
					}
				}				
				if(e.getSource()==aplicarJunior) {
					if((Double.parseDouble(JuniorSpinner.getValue().toString())) >= 0) {
						Controlador.getInstancia().modificarSalarioJunior(Double.parseDouble(JuniorSpinner.getValue().toString()),Integer.parseInt(idEmpleadoConectado.getText()));
	                	JOptionPane.showMessageDialog(null, "Salario de Junior de instalacion modificado correctamente");
	                	setVisible(false);
	                	Controlador.getInstancia().modificarSalarioTecnico(idEmpleadoConectado);
					}else {
						JOptionPane.showMessageDialog(null, "Salario de Junior no puede ser menor a 0");
					}
				}
			}
	}
}
