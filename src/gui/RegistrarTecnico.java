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

public class RegistrarTecnico extends JFrame{
	private JButton btnVolver,crearTecnico;
	private JLabel nombreLabel,turnoLabel,idEmpleadoConectado,nombreEmpleado,idLabel,seniorityLabel;
	private JComboBox<String> seniority,turno;
	private JTextField nombreTecnico;
	public RegistrarTecnico() {
		super("Menu Modificar Seniority");
		nombreEmpleado = new JLabel();
        idEmpleadoConectado = new JLabel();
        seniorityLabel = new JLabel("Seniority:");
        seniorityLabel.setBounds(100,240,100,35);
        idLabel = new JLabel("ID: ");
        idLabel.setBounds(255,10,220,20);
        nombreEmpleado.setBounds(10,10,220,20);
        idEmpleadoConectado.setBounds(275,10,220,20);
		nombreLabel = new JLabel();
		nombreLabel.setText("Nombre:");
		nombreLabel.setBounds(100,80,100,35);
		turnoLabel = new JLabel();
		turnoLabel.setText("Turno:");
		turnoLabel.setBounds(100,160,100,35);
		nombreTecnico = new JTextField();
		nombreTecnico.setBounds(200,80,100,35);
		//Botones
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(380, 420,100, 35);
		crearTecnico = new JButton("Crear Tecnico");
		crearTecnico.setBounds(120, 360,250, 40);
		ManejoBotones manejoBoton = new ManejoBotones();
		btnVolver.addActionListener(manejoBoton);
		crearTecnico.addActionListener(manejoBoton);
		//Combo Box
		seniority = new JComboBox();
		seniority.setBounds(200,240,100,35);
		seniority.addItem("Junior");
		seniority.addItem("SemiSenior");
		seniority.addItem("Senior");
		turno = new JComboBox<String>();
		turno.setBounds(200,160,100,35);
		turno.addItem("Mañana");
		turno.addItem("Tarde");
		//
		InicializarVentana();
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		c.add(btnVolver);
		c.add(crearTecnico);
		c.add(nombreLabel);
		c.add(turnoLabel);
		c.add(idEmpleadoConectado);
		c.add(nombreEmpleado);
		c.add(idLabel);
		c.add(seniorityLabel);
		c.add(seniority);
		c.add(turno);
		c.add(nombreTecnico);
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
                if(e.getSource()==crearTecnico) {
                	if(nombreTecnico.getText() != null) {											
                		Controlador.getInstancia().altaTecnico(nombreTecnico.getText(),Integer.parseInt(idEmpleadoConectado.getText()),seniority.getSelectedItem().toString(),turno.getSelectedItem().toString());
                		setVisible(false);
                		JOptionPane.showMessageDialog(null, "Tecnico creado correctamente");
                		Controlador.getInstancia().menuTecnicosGUI(idEmpleadoConectado);
                	}else {
                		JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre");
                	}
                }
          
			}
		}
}
