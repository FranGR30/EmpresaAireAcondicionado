package gui;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;
import controller.Controlador;
import models.EstadoInstalacion;
import models.Opcional;

public class MenuTecnicosGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnListarTecnicos,btnCrearTecnico,btnEditar,btnVolver,btnBorrarTecnico,btnCostoViaje,btnModificarSalario;
	private JPanel Panel,Panel2;
	private DefaultListModel<String> modelo;
	private JList<String> tecnicos;
	private JTextArea detalle;
	private JLabel nombreEmpleado,idEmpleadoConectado, idLabel;
	public MenuTecnicosGUI() {
		super("Menu Tecnicos");
		//Inicializar Panel 1
		inicializarPanel1();
		//Inicializar Panel 2
		inicializarPanel2();
		//----------Container-----------------
		nombreEmpleado = new JLabel();
		idEmpleadoConectado = new JLabel();
		idLabel = new JLabel("ID: ");
		idLabel.setBounds(255,10,220,20);
		nombreEmpleado.setBounds(10,10,220,20);
		idEmpleadoConectado.setBounds(275,10,220,20);
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		modelo = new DefaultListModel<>();
		tecnicos = new JList<>(modelo);
		tecnicos.setBounds(10,10,445,380);
		//---------------------------
		//Manejo de botones
		ManejoBotones manejoBoton = new ManejoBotones();
		btnListarTecnicos.addActionListener(manejoBoton);
		btnCrearTecnico.addActionListener(manejoBoton);
		btnVolver.addActionListener(manejoBoton);
		btnEditar.addActionListener(manejoBoton);
		btnBorrarTecnico.addActionListener(manejoBoton);
		btnCostoViaje.addActionListener(manejoBoton);
		btnModificarSalario.addActionListener(manejoBoton);
		//-----------------------------------
		InicializarVentana();
		c.add(btnListarTecnicos);
		c.add(btnCrearTecnico);
		c.add(Panel);
		c.add(Panel2);
		c.add(nombreEmpleado);
		c.add(idEmpleadoConectado);
		c.add(idLabel);
		c.add(btnVolver);
		this.add(Panel);
		this.add(Panel2);
		Panel2.setVisible(false);
		//--------Agregado de elementos Panel 1---------
		Panel.add(tecnicos);
		Panel.add(btnEditar);
		Panel.add(btnBorrarTecnico);
		Panel.add(btnCostoViaje);
		Panel.add(btnModificarSalario);
		//--------Agregado de elementos Panel 2---------
		Panel2.add(detalle);
		}

	
	private void InicializarVentana() {
		this.setVisible(true);
		this.setSize(500, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JLabel getNombreEmpleado() {
		return nombreEmpleado;
	}


	public void setNombreEmpleado(JLabel nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}


	public JLabel getIdEmpleadoConectado() {
		return idEmpleadoConectado;
	}


	public void setIdEmpleadoConectado(JLabel idEmpleadoConectado) {
		this.idEmpleadoConectado = idEmpleadoConectado;
	}


	public class ManejoBotones implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int idAux = Integer.parseInt(idEmpleadoConectado.getText()); 
                if(e.getSource() == btnEditar) {
                	if(tecnicos.getSelectedValue() != null){
	                	setVisible(false);
	                	Controlador.getInstancia().editarTecnico(idEmpleadoConectado,tecnicos.getSelectedValue().toString());
                	}
                }
                if(e.getSource()==btnListarTecnicos) {
                	Panel2.setVisible(false);
                	Panel.setVisible(true);
            		modelo.clear();
                	Controlador.getInstancia().agregarTecnicosListado(modelo, idAux);
                	tecnicos.setSelectedIndex(0);
                }
                if(e.getSource()==btnCrearTecnico) {
					setVisible(false);
					Controlador.getInstancia().registrarTecnico(idEmpleadoConectado);
                }
                if(e.getSource() == btnVolver) {
                	setVisible(false);
					Controlador.getInstancia().administradorSistemaGUI(idEmpleadoConectado);
                }
                if(e.getSource() == btnBorrarTecnico) {
                	if(tecnicos.getSelectedValue() != null){
	                	Controlador.getInstancia().eliminarTecnico(Integer.parseInt(idEmpleadoConectado.getText()),tecnicos.getSelectedValue().toString());
	                	JOptionPane.showMessageDialog(null, "Tecnico eliminado correctamente");
	                	setVisible(false);
	                	Controlador.getInstancia().menuTecnicosGUI(idEmpleadoConectado);
                	}
                }
                if(e.getSource() == btnCostoViaje) {
	                setVisible(false);
	                Controlador.getInstancia().modificarCostoViaje(idEmpleadoConectado);
                }  
                if(e.getSource() == btnModificarSalario) {
	                setVisible(false);
	                Controlador.getInstancia().modificarSalarioTecnico(idEmpleadoConectado);
                } 
			}
	}
		private void inicializarPanel1() {
			Panel = new JPanel();
			Panel.setBackground(Color.LIGHT_GRAY);
			Panel.setBounds(10,80,465,570);
			Panel.setLayout(null);
			//--------Botones Panel 1-------------
			btnListarTecnicos=new JButton("Listar Tecnicos");
			btnCrearTecnico = new JButton("Nuevo Tecnico");
			btnVolver = new JButton("Volver");
			btnListarTecnicos.setBounds(10, 30, 220, 45);
			btnCrearTecnico.setBounds(255, 30, 220, 45);
			btnVolver.setBounds(360,600,100, 35);
		}
		private void inicializarPanel2() {
			Panel2 = new JPanel();
			Panel2.setBackground(Color.LIGHT_GRAY);
			Panel2.setBounds(10,80,465,470);
			Panel2.setLayout(null);
			Font myFont2 = new Font("Arial", Font.BOLD, 12);
			detalle = new JTextArea();
			detalle.setBounds(10,10,445,220);
			detalle.setFont(myFont2);
			detalle.setEditable(false);
			//--------Botones Panel 2-------------
			btnEditar = new JButton("Editar Seniority");
			btnEditar.setBounds(255,400,200,45);
			btnBorrarTecnico = new JButton("Eliminar Tecnico");
			btnBorrarTecnico.setBounds(10,400,200,45);
			btnCostoViaje = new JButton("Modificar Costo de viaje");
			btnCostoViaje.setBounds(10,455,200,45);
			btnModificarSalario = new JButton("Modificar Salario");
			btnModificarSalario.setBounds(255,455,200,45);

		}
}
