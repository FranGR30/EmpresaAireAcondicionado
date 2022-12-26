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

public class TecnicoGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnListarInstalaciones,btnVolver,btnVerDetalle,btnGuardarInicio,btnGuardarFin,btnModificarEstado,btnOpcionales,btnAlmuerzo;
	private JPanel Panel,Panel2;
	private DefaultListModel<String> modelo;
	private JList<String> instalaciones;
	private JTextArea detalle;
	private JLabel nombreEmpleado,idEmpleadoConectado, idLabel,estados,filtros,modificarHoraInicio,modificarHoraFin,opcionales,almuerzo;
	private JRadioButton EstadoProgramada,EstadoEnCurso,EstadoCancelada,EstadoFinalizada,almuerzoTrue,almuerzoFalse,
	EstadoProgramadaMenu,EstadoEnCursoMenu,EstadoCanceladaMenu,EstadoFinalizadaMenu;
	private JSpinner horaInicio,horaFin;
	private Date date;
	private JCheckBox checkOpcional1,checkOpcional2;
	public TecnicoGUI() {
		super("Menu Tecnico");
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
		instalaciones = new JList<>(modelo);
		instalaciones.setBounds(10,10,445,320);
		//---------------------------
		//Manejo de botones
		ManejoBotones manejoBoton = new ManejoBotones();
		btnListarInstalaciones.addActionListener(manejoBoton);
		btnVolver.addActionListener(manejoBoton);
		btnVerDetalle.addActionListener(manejoBoton);
		btnGuardarInicio.addActionListener(manejoBoton);
		btnGuardarFin.addActionListener(manejoBoton);
		btnModificarEstado.addActionListener(manejoBoton);
		EstadoProgramadaMenu.addActionListener(manejoBoton);
		EstadoEnCursoMenu.addActionListener(manejoBoton);
		EstadoCanceladaMenu.addActionListener(manejoBoton);
		EstadoFinalizadaMenu.addActionListener(manejoBoton);
		btnOpcionales.addActionListener(manejoBoton);
		checkOpcional1.addActionListener(manejoBoton);
		checkOpcional2.addActionListener(manejoBoton);
		btnAlmuerzo.addActionListener(manejoBoton);
		almuerzoTrue.addActionListener(manejoBoton);
		almuerzoFalse.addActionListener(manejoBoton);
		//-----------------------------------
		InicializarVentana();
		c.add(btnListarInstalaciones);
		c.add(btnVolver);
		c.add(Panel);
		c.add(Panel2);
		c.add(nombreEmpleado);
		c.add(idEmpleadoConectado);
		c.add(idLabel);
		this.add(Panel);
		this.add(Panel2);
		Panel2.setVisible(false);
		//--------Agregado de elementos Panel 1---------
		Panel.add(instalaciones);
		Panel.add(btnVerDetalle);
		Panel.add(EstadoProgramadaMenu);
		Panel.add(EstadoEnCursoMenu);
		Panel.add(EstadoCanceladaMenu);
		Panel.add(EstadoFinalizadaMenu);
		Panel.add(filtros);
		//--------Agregado de elementos Panel 2---------
		Panel2.add(detalle);
		Panel2.add(horaInicio);
		Panel2.add(horaFin);
		Panel2.add(btnGuardarInicio);
		Panel2.add(btnGuardarFin);
		Panel2.add(EstadoProgramada);
		Panel2.add(EstadoEnCurso);
		Panel2.add(EstadoCancelada);
		Panel2.add(EstadoFinalizada);
		Panel2.add(estados);
		Panel2.add(btnModificarEstado);
		Panel2.add(modificarHoraFin);
		Panel2.add(modificarHoraInicio);
		Panel2.add(checkOpcional1);
		Panel2.add(checkOpcional2);
		Panel2.add(opcionales);
		Panel2.add(btnOpcionales);
		Panel2.add(btnAlmuerzo);
		Panel2.add(almuerzo);
		Panel2.add(almuerzoTrue);
		Panel2.add(almuerzoFalse);
		}

	
	private void InicializarVentana() {
		this.setVisible(true);
		this.setSize(500, 600);
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
                if(e.getSource() == btnVerDetalle) {
                	Panel.setVisible(false);
                	Panel2.setVisible(true);          
                	if(Controlador.getInstancia().detalleInstalacion(instalaciones.getSelectedValue()) != null) {
                		detalle.setText(Controlador.getInstancia().detalleInstalacion(instalaciones.getSelectedValue()));
                	}
                }
                if(e.getSource()==btnListarInstalaciones) {
                	Panel2.setVisible(false);
                	Panel.setVisible(true);
            		modelo.clear();
                	Controlador.getInstancia().agregarInstalacionesListado(modelo, idAux);
                	instalaciones.setSelectedIndex(0);
                }
                if(e.getSource()==btnVolver) {
					setVisible(false);
					Principal principal = new Principal();
					principal.setVisible(true);  
                }
                if(e.getSource() == btnGuardarInicio) {
                	
                	DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                	String time = timeFormat.format(horaInicio.getValue());
                	if(Controlador.getInstancia().validarHora(idAux, time)) {
                	Controlador.getInstancia().SetearHoraInicioInstalacion(idAux,instalaciones.getSelectedValue(), time);
                	JOptionPane.showMessageDialog(null, "Se ha modificado la hora de inicio correctamente");
                	}
                	else {
                		JOptionPane.showMessageDialog(null, "La hora que ingresó no es valida, ingrese una hora que corresponda al turno de la instalacion\n Turno mañana: 8 a 14hs\n Turno tarde: 14 a 20hs");
                	}
                }
                if(e.getSource() == btnGuardarFin) {
                	
                	DateFormat timeFormat2 = new SimpleDateFormat("HH:mm:ss");
                	String time2 = timeFormat2.format(horaFin.getValue());
                	if(Controlador.getInstancia().validarHora(idAux, time2)) {
                	Controlador.getInstancia().SetearHoraFinInstalacion(idAux,instalaciones.getSelectedValue(), time2);
                	JOptionPane.showMessageDialog(null, "Se ha modificado la hora de fin correctamente");
                	}
                	else {
                		JOptionPane.showMessageDialog(null, "La hora que ingresó no es valida, ingrese una hora que corresponda al turno de la instalacion\n Turno mañana: 8 a 14hs\n Turno tarde: 14 a 20hs");
                	}

                }
                if(e.getSource() == btnModificarEstado) {
                	ValidarRadios();
                }
                if(e.getSource() == EstadoProgramadaMenu)          {
                	modelo.clear();
                	Controlador.getInstancia().agregarInstalacionesListadoEstado(modelo, idAux,EstadoInstalacion.programada);
                	instalaciones.setSelectedIndex(0);
                }
                if(e.getSource() == EstadoEnCursoMenu)          {
                	modelo.clear();
                	Controlador.getInstancia().agregarInstalacionesListadoEstado(modelo, idAux,EstadoInstalacion.enCurso);
                	instalaciones.setSelectedIndex(0);
                }
                if(e.getSource() == EstadoCanceladaMenu)          {
                	modelo.clear();
                	Controlador.getInstancia().agregarInstalacionesListadoEstado(modelo, idAux,EstadoInstalacion.cancelada);
                	instalaciones.setSelectedIndex(0);
                }
                if(e.getSource() == EstadoFinalizadaMenu)          {
                	modelo.clear();
                	Controlador.getInstancia().agregarInstalacionesListadoEstado(modelo, idAux,EstadoInstalacion.finalizada);
                	instalaciones.setSelectedIndex(0);
                }
                if(e.getSource() == btnOpcionales) {
                	ValidarCheckBox();
                	JOptionPane.showMessageDialog(null, "Se agregaron los opcionales correctamente");
                }
                if(e.getSource() == btnAlmuerzo) {
                	ValidarRadioAlmuerzo();
    				JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");
                }
			}

		private void ValidarRadios() {
			int idAux = Integer.parseInt(idEmpleadoConectado.getText()); 
			if(EstadoProgramada.isSelected()) {
				Controlador.getInstancia().SetearEstadoInstalacion(idAux,instalaciones.getSelectedValue(),EstadoInstalacion.programada);
				JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");
			}
			if(EstadoEnCurso.isSelected()) {
				Controlador.getInstancia().SetearEstadoInstalacion(idAux,instalaciones.getSelectedValue(),EstadoInstalacion.enCurso);
				JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");
			}
			if(EstadoCancelada.isSelected()) {
				Controlador.getInstancia().SetearEstadoInstalacion(idAux,instalaciones.getSelectedValue(),EstadoInstalacion.cancelada);
				JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");
			}
			if(EstadoFinalizada.isSelected()) {
				if(Controlador.getInstancia().tieneHoraInicioYFin(instalaciones.getSelectedValue())){
				Controlador.getInstancia().SetearEstadoInstalacion(idAux,instalaciones.getSelectedValue(),EstadoInstalacion.finalizada);
				JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");
				}
				else {
					JOptionPane.showMessageDialog(null, "Para pasar la instalacion a estado 'Finalizada' la misma debe tener\n una hora de inicio y una hora de fin.");
				}
			}
		}
		private void ValidarCheckBox() {
			int idAux = Integer.parseInt(idEmpleadoConectado.getText()); 
			if(checkOpcional1.isSelected()) {
				Controlador.getInstancia().agregarOpcionales(idAux, instalaciones.getSelectedValue(), Opcional.SeguroTrabajoAltura);
			}
			if(checkOpcional2.isSelected()) {
				Controlador.getInstancia().agregarOpcionales(idAux, instalaciones.getSelectedValue(), Opcional.SoportePared);
			}
		}
		private void ValidarRadioAlmuerzo() {
			int idAux = Integer.parseInt(idEmpleadoConectado.getText()); 
			if(almuerzoTrue.isSelected()) {
				Controlador.getInstancia().modificarAlmuerzo(idAux, instalaciones.getSelectedValue(), true);
			}
			if(almuerzoFalse.isSelected()) {
				Controlador.getInstancia().modificarAlmuerzo(idAux, instalaciones.getSelectedValue(), false);
			}
		}

	}
		private void inicializarPanel1() {
			Panel = new JPanel();
			Panel.setBackground(Color.LIGHT_GRAY);
			Panel.setBounds(10,80,465,470);
			Panel.setLayout(null);
			//--------Botones Panel 1-------------
			btnListarInstalaciones=new JButton("Mis instalaciones");
			btnVolver = new JButton("Cerrar sesión");
			btnListarInstalaciones.setBounds(10, 30, 220, 45);
			btnVolver.setBounds(255, 30, 220, 45);
			//-------------Label de estados filtros(Menu)----------------
			filtros = new JLabel("Filtrar por estado: ");
			filtros.setBounds(10,330,150,20);
			
			//--------------Radio Button Estado Instalacion Menu---------------------
			EstadoProgramadaMenu = new JRadioButton("Programada");
			EstadoEnCursoMenu = new JRadioButton("En curso");
			EstadoCanceladaMenu = new JRadioButton("Cancelada");
			EstadoFinalizadaMenu = new JRadioButton("Finalizada");
			EstadoEnCursoMenu.setBounds(230,350,114,20);
			EstadoCanceladaMenu.setBounds(120,350,114,20); 
			EstadoFinalizadaMenu.setBounds(340,350,114,20);
			EstadoProgramadaMenu.setBounds(10,350,114,20);
			ButtonGroup grupoMenu = new ButtonGroup();
			grupoMenu.add(EstadoEnCursoMenu);
			grupoMenu.add(EstadoProgramadaMenu);
			grupoMenu.add(EstadoCanceladaMenu);
			grupoMenu.add(EstadoFinalizadaMenu);
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
			//--------------Spinners Hora Inicio y Fin (PANEL 2) --------------
			date = new Date();
			SpinnerDateModel sm = new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
			SpinnerDateModel sm2 = new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
			horaInicio = new JSpinner(sm);
			horaFin = new JSpinner(sm2);
			JSpinner.DateEditor de = new JSpinner.DateEditor(horaInicio, "HH:mm:ss");
			JSpinner.DateEditor de2 = new JSpinner.DateEditor(horaFin, "HH:mm:ss");
			horaFin.setBounds(320,250,120,20);
			horaFin.setEditor(de2);
			horaInicio.setEditor(de);
			horaInicio.setBounds(170,250,120,20);
			//-----------Label Opcionales----------------
			opcionales = new JLabel("Agregar opcionales: ");
			opcionales.setBounds(10,365,160,20);
			//-----------Label Almuerzo----------------
			almuerzo = new JLabel("¿Hubo almuerzo?");
			almuerzo.setBounds(250,365,160,20);
			//------------Radio Button Almuerzo------------
			almuerzoTrue = new JRadioButton("Si");
			almuerzoFalse = new JRadioButton("No");
			almuerzoTrue.setBounds(250,385,190,20);
			almuerzoFalse.setBounds(250,405,190,20);
			ButtonGroup grupoAlmuerzo = new ButtonGroup();
			grupoAlmuerzo.add(almuerzoTrue);
			grupoAlmuerzo.add(almuerzoFalse);
			//-----------Checkbox opcionales-------------
			checkOpcional1 = new JCheckBox("Seguro de trabajo en altura");
			checkOpcional2 = new JCheckBox("Soporte de pared");
			checkOpcional1.setBounds(10,385,190,20);
			checkOpcional2.setBounds(10,405,190,20);
			//-------------Label de estados detalle----------------
			estados = new JLabel("Estado de instalacion: ");
			estados.setBounds(10,230,150,20);
			//-------------Label de modificacion de Hora inicio y fin----------------
			modificarHoraInicio = new JLabel("Modificar Hora de inicio");
			modificarHoraInicio.setBounds(170,230,150,20);
			modificarHoraFin = new JLabel("Modificar Hora de Fin");
			modificarHoraFin.setBounds(320,230,150,20);
			//--------------Radio Button Estado instalacion detalle------------------
			EstadoProgramada = new JRadioButton("Programada");
			EstadoEnCurso = new JRadioButton("En curso");
			EstadoCancelada = new JRadioButton("Cancelada");
			EstadoFinalizada = new JRadioButton("Finalizada");
			EstadoProgramada.setBounds(10,250,150,20);
			EstadoEnCurso.setBounds(10,270,150,20);
			EstadoCancelada.setBounds(10,290,150,20);
			EstadoFinalizada.setBounds(10,310,150,20);
			ButtonGroup grupo = new ButtonGroup();
			grupo.add(EstadoProgramada);
			grupo.add(EstadoEnCurso);
			grupo.add(EstadoCancelada);
			grupo.add(EstadoFinalizada);
			EstadoProgramada.setSelected(true);
			//--------Botones Panel 2-------------
			btnOpcionales = new JButton("Agregar");
			btnModificarEstado = new JButton("Modificar estado");
			btnVerDetalle = new JButton("Ver detalle");
			btnGuardarInicio = new JButton("Modificar");
			btnGuardarFin = new JButton("Modificar");
			btnAlmuerzo = new JButton("Modificar Almuerzo");
			btnAlmuerzo.setBounds(250,430,190,35);
			btnVerDetalle.setBounds(155,400,150,50);
			btnGuardarInicio.setBounds(170,275,120,30);
			btnGuardarFin.setBounds(320,275,120,30);
			btnModificarEstado.setBounds(10,335,150,30);
			btnOpcionales.setBounds(10,430,190,35);
		}
}
