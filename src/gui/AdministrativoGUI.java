package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.Controlador;
import models.EstadoInstalacion;


@SuppressWarnings("serial")
public class AdministrativoGUI extends JFrame{
	private JLabel idEmpleadoConectado,nombreEmpleado,idLabel,tituloEmision,labelComboInstalaciones,labelTipoFactura,labelCliente,labelCorreo,
	labelOtrosCostos,labelGastos,labelHorasTrabajadas,labelEquipos;
	private JButton btnListaFacturas,btnCerrarSesion,btnVerDetalleFactura,btnEmitirNuevaFactura,btnModificarCostos,btnEmitir,btnVolverAtras,btnGuardarCambios, btnVolverAtrasDetalle;
	private DefaultListModel<String> modelo;
	private JList<String> listadoFacturas;
	private JComboBox<String> instalacionesFinalizadas,equipos;
	private JPanel emisionFactura,menuAdministrativo,detalleFactura;
	private JTextField textTipoFactura,textCliente,textCorreo,textOtrosCostos,textGastos,textHorasTrabajadas,textEquipos;
	private JTextArea detalle;
	public AdministrativoGUI() {
		super("Menu Administrativo");
		Container c = this.getContentPane();
		c.setLayout(null);
		//Panel de detalle de factura
		detalleFactura = new JPanel();
		detalleFactura.setBackground(Color.LIGHT_GRAY);
		detalleFactura.setBounds(10,90,465,465);
		detalleFactura.setLayout(null);
		detalleFactura.setVisible(false);
		Font myFont2 = new Font("Arial", Font.BOLD, 12);
		detalle = new JTextArea();
		detalle.setBounds(10,10,445,400);
		detalle.setFont(myFont2);
		detalle.setEditable(false);
		//Labels de container
		idEmpleadoConectado = new JLabel();
		nombreEmpleado = new JLabel();
		idLabel = new JLabel("ID: ");
		idLabel.setBounds(260,10,220,20);
		nombreEmpleado.setBounds(15,10,220,20);
		idEmpleadoConectado.setBounds(280,10,220,20);
		//Panel de menu de administrativo
		menuAdministrativo = new JPanel();
		menuAdministrativo.setBounds(10,90,465,465);
		menuAdministrativo.setLayout(null);
		menuAdministrativo.setBackground(Color.LIGHT_GRAY);
		//Panel de creacion de Factura
		emisionFactura = new JPanel();
		emisionFactura.setBounds(10,90,465,465);
		emisionFactura.setLayout(null);
		emisionFactura.setBackground(Color.LIGHT_GRAY);
		emisionFactura.setVisible(false);
		//Labels de Panel de creacion de factura 
		tituloEmision = new JLabel("Emisión de facturas");
		Font fuente = new Font("Arial", Font.BOLD, 20);
		Font fuente2 = new Font("Arial", Font.BOLD, 15);
		tituloEmision.setFont(fuente);
		labelComboInstalaciones = new JLabel("Instalaciones finalizadas: ");
		labelTipoFactura = new JLabel("Tipo de factura: ");
		tituloEmision.setBounds(140,5,300,20);
		labelComboInstalaciones.setBounds(20,30,180,30);
		labelComboInstalaciones.setFont(fuente2);
		labelTipoFactura.setBounds(20,65,180,30);
		labelTipoFactura.setFont(fuente2);
		labelCliente = new JLabel("Cliente: ");
		labelCliente.setFont(fuente2);
		labelCorreo = new JLabel("Correo electronico: ");
		labelCorreo.setFont(fuente2);
		labelCliente.setBounds(20,105,180,30);
		labelCorreo.setBounds(20,145,180,30);
		labelOtrosCostos = new JLabel("Otros Costos: ");
		labelOtrosCostos.setFont(fuente2);
		labelGastos = new JLabel("Gastos: ");
		labelGastos.setFont(fuente2);
		labelHorasTrabajadas = new JLabel("Horas trabajadas: ");
		labelHorasTrabajadas.setFont(fuente2);
		labelEquipos = new JLabel("Equipos: ");
		labelEquipos.setFont(fuente2);
		labelOtrosCostos.setBounds(20,185,200,30);
		labelGastos.setBounds(20,225,200,30);
		labelHorasTrabajadas.setBounds(20,265,200,30);
		labelEquipos.setBounds(20,305,180,30);
		//Combo en Panel de creacion de factura
		instalacionesFinalizadas = new JComboBox<String>();
		instalacionesFinalizadas.setBounds(220,30,200,30);
		instalacionesFinalizadas.setEditable(false);
    	Controlador.getInstancia().agregarInstalacionesFinalizadas(instalacionesFinalizadas, EstadoInstalacion.finalizada);
    	equipos = new JComboBox<String>();
    	equipos.setBounds(220,305,200,30);
    	equipos.setEditable(false);
		//TextField en panel de creacion de factura
		textTipoFactura = new JTextField();
		textTipoFactura.setBounds(220,65,200,30);
		textTipoFactura.setEditable(false);
		textCliente = new JTextField();
		textCorreo = new JTextField();
		textCliente.setBounds(220,105,200,30);
		textCliente.setEditable(false);
		textCorreo.setBounds(220,145,200,30);
		textCorreo.setEditable(false);
		textOtrosCostos = new JTextField();
		textGastos = new JTextField();
		textHorasTrabajadas = new JTextField();
		textEquipos = new JTextField();
		textOtrosCostos.setBounds(220,185,200,30);
		textOtrosCostos.setEditable(false);
		textGastos.setBounds(220,225,200,30);
		textGastos.setEditable(false);
		textHorasTrabajadas.setEditable(false);
		textHorasTrabajadas.setBounds(220,265,200,30);
		//Botones de emision de factura
		btnModificarCostos = new JButton("Modificar costos");
		btnModificarCostos.setBounds(10,380,200,45);
		btnEmitir = new JButton("Emitir factura");
		btnEmitir.setBounds(255,380,200,45);
		btnVolverAtras = new JButton("Volver atrás");
		btnVolverAtras.setBounds(255,380,200,45);
		btnVolverAtras.setVisible(false);
		btnGuardarCambios = new JButton("Modificar y emitir");
		btnGuardarCambios.setBounds(10,380,200,45);
		btnGuardarCambios.setVisible(false);
		//Botones de menu de administrativo
		btnVerDetalleFactura = new JButton("Ver detalle");
		btnEmitirNuevaFactura = new JButton("Emitir nueva factura");
		btnVerDetalleFactura.setBounds(10,420,200,30);
		btnEmitirNuevaFactura.setBounds(255,420,200,30);	
		//Boton de detalle de factura
		btnVolverAtrasDetalle = new JButton("Volver atras");
		btnVolverAtrasDetalle.setBounds(10,420,445,30);
		btnVolverAtrasDetalle.setVisible(false);
		//JList para el menu de administrativo
		modelo = new DefaultListModel<>();
		listadoFacturas = new JList<>(modelo);
		listadoFacturas.setBounds(10,10,445,400);
		//Botones de container
		btnListaFacturas=new JButton("Listar Facturas");
		btnCerrarSesion = new JButton("Cerrar sesión");
		btnListaFacturas.setBounds(10, 40, 220, 45);
		btnCerrarSesion.setBounds(255, 40, 220, 45);
		//Agregado a detalle de factura
		detalleFactura.add(detalle);
		detalleFactura.add(btnVolverAtrasDetalle);
		//Agregado a Container
		c.add(menuAdministrativo);
		c.add(btnListaFacturas);
		c.add(btnCerrarSesion);
		c.add(nombreEmpleado);
		c.add(idEmpleadoConectado);
		c.add(idLabel);
		c.add(emisionFactura);
		c.add(detalleFactura);
		//Agregado a Panel Menu Administrativo
		menuAdministrativo.add(btnEmitirNuevaFactura);
		menuAdministrativo.add(btnVerDetalleFactura);
		menuAdministrativo.add(listadoFacturas);
		//Agregado a Panel de emision de facturas
		emisionFactura.add(tituloEmision);
		emisionFactura.add(labelComboInstalaciones);
		emisionFactura.add(labelTipoFactura);
		emisionFactura.add(instalacionesFinalizadas);
		emisionFactura.add(textTipoFactura);
		emisionFactura.add(labelCliente);
		emisionFactura.add(labelCorreo);
		emisionFactura.add(textCliente);
		emisionFactura.add(textCorreo);
		emisionFactura.add(labelOtrosCostos);
		emisionFactura.add(labelGastos);
		emisionFactura.add(labelHorasTrabajadas);
		emisionFactura.add(labelEquipos);
		emisionFactura.add(textOtrosCostos);
		emisionFactura.add(textGastos);
		emisionFactura.add(textHorasTrabajadas);
		emisionFactura.add(textEquipos);
		emisionFactura.add(equipos);
		emisionFactura.add(btnModificarCostos);
		emisionFactura.add(btnEmitir);
		emisionFactura.add(btnVolverAtras);
		emisionFactura.add(btnGuardarCambios);
		//Inicializar la ventana
		inicializarVentana();
		//Agregar comportamiento a botones 
		ManejoBotones manejoBoton = new ManejoBotones();
		btnCerrarSesion.addActionListener(manejoBoton);
		btnListaFacturas.addActionListener(manejoBoton);
		btnEmitirNuevaFactura.addActionListener(manejoBoton);
		instalacionesFinalizadas.addActionListener(manejoBoton);
		btnModificarCostos.addActionListener(manejoBoton);
		btnVolverAtras.addActionListener(manejoBoton);
		btnGuardarCambios.addActionListener(manejoBoton);
		btnEmitir.addActionListener(manejoBoton);
		btnVerDetalleFactura.addActionListener(manejoBoton);
		btnVolverAtrasDetalle.addActionListener(manejoBoton);
	}
	public void inicializarVentana() {
		this.setVisible(true);
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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


	public class ManejoBotones implements ActionListener {
		public void actionPerformed(ActionEvent e) {
                int auxiliarId = Integer.parseInt(idEmpleadoConectado.getText());
                if(e.getSource()==btnCerrarSesion) {
					setVisible(false);
					Principal principal = new Principal();
					principal.setVisible(true);  

                }
                if(e.getSource()==btnListaFacturas) {
                	detalleFactura.setVisible(true);	
	                emisionFactura.setVisible(false);
	            	menuAdministrativo.setVisible(true);
	        		modelo.clear();
	        		btnVolverAtrasDetalle.setVisible(false);
	            	Controlador.getInstancia().agregarFacturasModelo(modelo);
	            	listadoFacturas.setSelectedIndex(0);
                }
                if(e.getSource() == btnEmitirNuevaFactura) {
                	menuAdministrativo.setVisible(false);
                    emisionFactura.setVisible(true);
            
                }
                if(e.getSource() == instalacionesFinalizadas) {
                	if(instalacionesFinalizadas.getSelectedItem() != null) {
                		equipos.removeAllItems();
                		textTipoFactura.setText(Controlador.getInstancia().getTipoFacturaInstalacion(instalacionesFinalizadas.getSelectedItem().toString()).toString());
                		textCliente.setText(Controlador.getInstancia().getClienteInstalacion(instalacionesFinalizadas.getSelectedItem().toString()).toString());
                		textCorreo.setText(Controlador.getInstancia().getClienteCorreoInstalacion(instalacionesFinalizadas.getSelectedItem().toString()).toString());
                		String auxiliar = Double.toString(Controlador.getInstancia().getGastosInstalacion(instalacionesFinalizadas.getSelectedItem().toString())); 
                		textGastos.setText(auxiliar);     	
                		textOtrosCostos.setText(Double.toString(Controlador.getInstancia().getTotalMaterialesOpcionales(instalacionesFinalizadas.getSelectedItem().toString())));
                		textHorasTrabajadas.setText(Double.toString(Controlador.getInstancia().getTotalHorasTrabajadas(instalacionesFinalizadas.getSelectedItem().toString())));
                		Controlador.getInstancia().llenarComboEquipoInstalacion(equipos, instalacionesFinalizadas.getSelectedItem().toString());                	
                		}
                }
                if(e.getSource() == btnModificarCostos) {
                	if(!textTipoFactura.getText().isEmpty() && !textCliente.getText().isEmpty() && !textCorreo.getText().isEmpty() && !textGastos.getText().isEmpty() && !textOtrosCostos.getText().isEmpty() && !textHorasTrabajadas.getText().isEmpty()) {
                	instalacionesFinalizadas.setEnabled(false);
                	btnEmitir.setVisible(false);
                	btnVolverAtras.setVisible(true);
                	textGastos.setEditable(true);
                	textOtrosCostos.setEditable(true);
                	btnModificarCostos.setVisible(false);
                	btnGuardarCambios.setVisible(true);
                	}
                	else {
                		JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna instalaci�n, por favor seleccione una");
                	}
                }
                if(e.getSource() == btnVolverAtras) {
                	instalacionesFinalizadas.setEnabled(true);
                	btnEmitir.setVisible(true);
                	btnVolverAtras.setVisible(false);
                	textGastos.setEditable(false);
                	textOtrosCostos.setEditable(false);
                	btnModificarCostos.setVisible(true);
                }
                if(e.getSource() == btnGuardarCambios) {
                	if(!textTipoFactura.getText().isEmpty() && !textCliente.getText().isEmpty() && !textCorreo.getText().isEmpty() && !textGastos.getText().isEmpty() && !textOtrosCostos.getText().isEmpty() && !textHorasTrabajadas.getText().isEmpty()) {
                		if(Controlador.getInstancia().validarFactura(instalacionesFinalizadas.getSelectedItem().toString())) {
                			System.out.println(Double.parseDouble(textOtrosCostos.getText()));
                			String facturaAux2 = Controlador.getInstancia().emitirFacturaAdministrativoConModificacion(auxiliarId, instalacionesFinalizadas.getSelectedItem().toString(), Double.parseDouble(textOtrosCostos.getText())).toString();
                			JOptionPane.showMessageDialog(null,"Se emitio la factura: "+ facturaAux2);
                		}
                		else {
                			JOptionPane.showMessageDialog(null,"Ya hay una factura para esa instalacion");
                		}
                	}
                	else {
                		JOptionPane.showMessageDialog(null,"No se ha seleccionado ninguna instalación, por favor seleccione una");
                	}
                }
                if(e.getSource() == btnEmitir) {
                	if(!textTipoFactura.getText().isEmpty() && !textCliente.getText().isEmpty() && !textCorreo.getText().isEmpty() && !textGastos.getText().isEmpty() && !textOtrosCostos.getText().isEmpty() && !textHorasTrabajadas.getText().isEmpty()) {
                		if(Controlador.getInstancia().validarFactura(instalacionesFinalizadas.getSelectedItem().toString())) {
		                	Controlador.getInstancia().emitirFacturaAdministrativo(auxiliarId,instalacionesFinalizadas.getSelectedItem().toString());
		                	JOptionPane.showMessageDialog(null,"Se emitio la factura correctamente y se envió al cliente");
                		}
                		else {
                			JOptionPane.showMessageDialog(null,"Ya hay una factura para esa instalacion");
                		}
                	}
                	else {
                		JOptionPane.showMessageDialog(null,"No se ha seleccionado ninguna instalación, por favor seleccione una");
                	}
           
                }
              if(e.getSource() == btnVerDetalleFactura) {
            	  detalleFactura.setVisible(true);
            	  menuAdministrativo.setVisible(false);
            	  btnVolverAtrasDetalle.setVisible(true);
            	  if(Controlador.getInstancia().detalleFactura(listadoFacturas.getSelectedValue()) != null) {
              		detalle.setText(Controlador.getInstancia().detalleFactura(listadoFacturas.getSelectedValue()));
              	}
            	  
              }
              if(e.getSource() == btnVolverAtrasDetalle) {
              	btnVolverAtrasDetalle.setVisible(false);
              	detalleFactura.setVisible(false);
              	menuAdministrativo.setVisible(true);
              	
              }
        }
	}
}
