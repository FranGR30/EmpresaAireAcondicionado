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

public class ModificarSeniority extends JFrame{
	private JButton btnVolver,guardar;
	private JLabel idTecnicoLabel,nombreLabel,turnoLabel,idEmpleadoConectado,nombreEmpleado,idLabel,seniorityLabel,nombreTecnicoLabel,idTecnico,turnoTecnicoLabel;
	private JComboBox<String> seniority;
	public ModificarSeniority() {
		super("Menu Modificar Seniority");
		nombreEmpleado = new JLabel();
        idEmpleadoConectado = new JLabel();
        seniorityLabel = new JLabel("Seniority:");
        seniorityLabel.setBounds(100,260,100,35);
        idLabel = new JLabel("ID: ");
        idLabel.setBounds(255,10,220,20);
        nombreEmpleado.setBounds(10,10,220,20);
        idEmpleadoConectado.setBounds(275,10,220,20);
        idTecnicoLabel = new JLabel();
		idTecnicoLabel.setBounds(100,80,100,35);
		idTecnicoLabel.setText("Id tecnico:");
		nombreLabel = new JLabel();
		nombreLabel.setText("Nombre:");
		nombreLabel.setBounds(100,140,100,35);
		turnoLabel = new JLabel();
		turnoLabel.setText("Turno:");
		turnoLabel.setBounds(100,200,100,35);
		idTecnico =  new JLabel();
		idTecnico.setBounds(200,80,100,35);
		turnoTecnicoLabel =  new JLabel();
		turnoTecnicoLabel.setBounds(200,200,100,35);
		nombreTecnicoLabel =  new JLabel();
		nombreTecnicoLabel.setBounds(200,140,100,35);
		//Botones
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(380, 420,100, 35);
		guardar = new JButton("Guardar");
		guardar.setBounds(120, 360,250, 40);
		ManejoBotones manejoBoton = new ManejoBotones();
		btnVolver.addActionListener(manejoBoton);
		guardar.addActionListener(manejoBoton);
		//Combo Box
		seniority = new JComboBox();
		seniority.setBounds(200,260,100,35);
		seniority.addItem("Junior");
		seniority.addItem("SemiSenior");
		seniority.addItem("Senior");
		//
		InicializarVentana();
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		c.add(btnVolver);
		c.add(idTecnicoLabel);
		c.add(guardar);
		c.add(nombreLabel);
		c.add(turnoLabel);
		c.add(idEmpleadoConectado);
		c.add(nombreEmpleado);
		c.add(idLabel);
		c.add(seniorityLabel);
		c.add(seniority);
		c.add(idTecnico);
		c.add(turnoTecnicoLabel);
		c.add(nombreTecnicoLabel);
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
	
	
	public JLabel getNombreTecnicoLabel() {
		return nombreTecnicoLabel;
	}
	public void setNombreTecnicoLabel(JLabel nombreTecnicoLabel) {
		this.nombreTecnicoLabel = nombreTecnicoLabel;
	}
	public JLabel getIdTecnico() {
		return idTecnico;
	}
	public void setIdTecnico(JLabel idTecnico) {
		this.idTecnico = idTecnico;
	}
	public JLabel getTurnoTecnicoLabel() {
		return turnoTecnicoLabel;
	}
	public void setTurnoTecnicoLabel(JLabel turnoTecnicoLabel) {
		this.turnoTecnicoLabel = turnoTecnicoLabel;
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
					Controlador.getInstancia().menuTecnicosGUI(idEmpleadoConectado);
                }
                if(e.getSource()==guardar) {
                	Controlador.getInstancia().modificarSeniority(Integer.parseInt(idTecnico.getText()),seniority.getSelectedItem().toString(),Integer.parseInt(idEmpleadoConectado.getText()));
                	JOptionPane.showMessageDialog(null, "Se guardo el cambio correctamente");
                	setVisible(false);
					Controlador.getInstancia().menuTecnicosGUI(idEmpleadoConectado);
                }
			}
		}
}
