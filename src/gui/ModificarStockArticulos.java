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

public class ModificarStockArticulos extends JFrame{
	private JButton btnVolver,agregarStockCondensadora,quitarStockCondensadora,agregarStockEvaporadora,quitarStockEvaporadora,agregarStockKitInstalacion,quitarStockKitInstalacion;
	private JLabel condensadoraLabel,kitInstalacionLabel,evaporadoraLabel,idEmpleadoConectado,nombreEmpleado,idLabel,stockLabel,stockCondensadora,stockEvaporadora,stockKitInstalacion;
	private JSpinner condensadoraSpinner,kitInstalacionSpinner,evaporadoraSpinner;
	public ModificarStockArticulos() {
		super("Menu Modificar Stock Articulos");
		
		nombreEmpleado = new JLabel();
        idEmpleadoConectado = new JLabel();
        idLabel = new JLabel("ID: ");
        idLabel.setBounds(255,10,220,20);
        nombreEmpleado.setBounds(10,10,220,20);
        idEmpleadoConectado.setBounds(275,10,220,20);
        stockLabel = new JLabel();
        stockLabel.setBounds(400,50,160,35);
        stockLabel.setText("Stock:");
        stockCondensadora = new JLabel();
        stockCondensadora.setBounds(400,80,160,35);
        stockEvaporadora = new JLabel();
        stockEvaporadora.setBounds(400,280,160,35);
        stockKitInstalacion = new JLabel();
        stockKitInstalacion.setBounds(400,180,160,35);
        condensadoraLabel = new JLabel();
        SpinnerNumberModel snm = new SpinnerNumberModel(0,-999999999,999999999,1);
        condensadoraSpinner = new JSpinner(snm);
		condensadoraLabel.setBounds(30,80,160,35);
		condensadoraLabel.setText("Stock de Condensadora:");
		condensadoraSpinner.setBounds(200,80,60,35);
		agregarStockCondensadora = new JButton("Agregar Stock");
		agregarStockCondensadora.setBounds(60,120,150,30);
		quitarStockCondensadora = new JButton("Quitar Stock");
		quitarStockCondensadora.setBounds(220,120,150,30);
		kitInstalacionLabel = new JLabel();
		kitInstalacionLabel.setText("Stock de Kit de Instalacion:");
		kitInstalacionLabel.setBounds(30,180,160,35);
		SpinnerNumberModel snm2 = new SpinnerNumberModel(0,-999999999,999999999,1);
		kitInstalacionSpinner = new JSpinner(snm2);
		kitInstalacionSpinner.setBounds(200,180,60,35);
		agregarStockKitInstalacion = new JButton("Agregar Stock");
		agregarStockKitInstalacion.setBounds(60,220,150,30);
		quitarStockKitInstalacion = new JButton("Quitar Stock");
		quitarStockKitInstalacion.setBounds(220,220,150,30);
		evaporadoraLabel = new JLabel();
		evaporadoraLabel.setText("Stock de Evaporadora:");
		evaporadoraLabel.setBounds(30,280,160,35);
		SpinnerNumberModel snm3 = new SpinnerNumberModel(0,-999999999,999999999,1);
		evaporadoraSpinner = new JSpinner(snm3);
		evaporadoraSpinner.setBounds(200,280,60,35);
		agregarStockEvaporadora = new JButton("Agregar Stock");
		agregarStockEvaporadora.setBounds(60,320,150,30);
		quitarStockEvaporadora = new JButton("Quitar Stock");
		quitarStockEvaporadora.setBounds(220,320,150,30);
		//Botones
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(380, 420,100, 35);

		ManejoBotones manejoBoton = new ManejoBotones();
		btnVolver.addActionListener(manejoBoton);
		agregarStockCondensadora.addActionListener(manejoBoton);
		quitarStockCondensadora.addActionListener(manejoBoton);
		agregarStockEvaporadora.addActionListener(manejoBoton);
		quitarStockEvaporadora.addActionListener(manejoBoton);
		agregarStockKitInstalacion.addActionListener(manejoBoton);
		quitarStockKitInstalacion.addActionListener(manejoBoton);

		//
		InicializarVentana();
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		c.add(btnVolver);
		c.add(condensadoraLabel);
		c.add(condensadoraSpinner);
		c.add(agregarStockCondensadora);
		c.add(kitInstalacionLabel);
		c.add(kitInstalacionSpinner);
		c.add(evaporadoraLabel);
		c.add(evaporadoraSpinner);
		c.add(idEmpleadoConectado);
		c.add(nombreEmpleado);
		c.add(idLabel);
		c.add(quitarStockCondensadora);
		c.add(agregarStockEvaporadora);
		c.add(quitarStockEvaporadora);
		c.add(agregarStockKitInstalacion);
		c.add(quitarStockKitInstalacion);
		c.add(stockLabel);
		c.add(stockCondensadora);
		c.add(stockEvaporadora);
		c.add(stockKitInstalacion);
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
	
	public JLabel getStockCondensadora() {
		return stockCondensadora;
	}
	public void setStockCondensadora(JLabel stockCondensadora) {
		this.stockCondensadora = stockCondensadora;
	}
	public JLabel getStockEvaporadora() {
		return stockEvaporadora;
	}
	public void setStockEvaporadora(JLabel stockEvaporadora) {
		this.stockEvaporadora = stockEvaporadora;
	}
	public JLabel getStockKitInstalacion() {
		return stockKitInstalacion;
	}
	public void setStockKitInstalacion(JLabel stockKitInstalacion) {
		this.stockKitInstalacion = stockKitInstalacion;
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
					Controlador.getInstancia().menuArticuloGUI(idEmpleadoConectado);
                }
                if(e.getSource()==agregarStockCondensadora) {
                	if((Integer.parseInt(condensadoraSpinner.getValue().toString())) > 0) {
	                	Controlador.getInstancia().agregarCondensadora(Integer.parseInt(condensadoraSpinner.getValue().toString()),Integer.parseInt(idEmpleadoConectado.getText()));
	                	JOptionPane.showMessageDialog(null, "Stock de condensadora agregado correctamente");
	                	setVisible(false);
	                	Controlador.getInstancia().menuModificarStockArticulos(idEmpleadoConectado);
                	}else {
                		JOptionPane.showMessageDialog(null, "Stock de condensadora a agregar debe ser positivo");
                	}
                }
				if(e.getSource()==quitarStockCondensadora) {
					if((Integer.parseInt(condensadoraSpinner.getValue().toString())) > 0) {
						if((Integer.parseInt(stockCondensadora.getText())) - (Integer.parseInt(condensadoraSpinner.getValue().toString()))  >= 0){
							Controlador.getInstancia().quitarCondensadora(Integer.parseInt(condensadoraSpinner.getValue().toString()),Integer.parseInt(idEmpleadoConectado.getText()));
		                	JOptionPane.showMessageDialog(null, "Stock de condensadora eliminado correctamente");
		                	setVisible(false);
		                	Controlador.getInstancia().menuModificarStockArticulos(idEmpleadoConectado);	
						}else {
							JOptionPane.showMessageDialog(null, "Error. El stock de condensadora no puede ser menor a 0");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Stock de condensadora a quitar debe ser positivo");
					}
				}
					
				
				if(e.getSource()==agregarStockEvaporadora) {
					if((Integer.parseInt(evaporadoraSpinner.getValue().toString())) > 0) {
						Controlador.getInstancia().agregarEvaporadora(Integer.parseInt(evaporadoraSpinner.getValue().toString()),Integer.parseInt(idEmpleadoConectado.getText()));
	                	JOptionPane.showMessageDialog(null, "Stock de evaporadora agregado correctamente");
	                	setVisible(false);
	                	Controlador.getInstancia().menuModificarStockArticulos(idEmpleadoConectado);
					}else {
                		JOptionPane.showMessageDialog(null, "Stock de evaporadora a agregar debe ser positivo");
                	}
				}				
				if(e.getSource()==quitarStockEvaporadora) {
					if((Integer.parseInt(evaporadoraSpinner.getValue().toString())) > 0) {
						if((Integer.parseInt(stockCondensadora.getText()) - Integer.parseInt(evaporadoraSpinner.getValue().toString()) >= 0)){
							Controlador.getInstancia().quitarEvaporadora(Integer.parseInt(evaporadoraSpinner.getValue().toString()),Integer.parseInt(idEmpleadoConectado.getText()));
		                	JOptionPane.showMessageDialog(null, "Stock de evaporadora eliminado correctamente");
		                	setVisible(false);
		                	Controlador.getInstancia().menuModificarStockArticulos(idEmpleadoConectado);
						}else {
							JOptionPane.showMessageDialog(null, "Error. El stock de evaporadora no puede ser menor a 0");
						}
					}else {
                		JOptionPane.showMessageDialog(null, "Stock de evaporadora a quitar debe ser positivo");
                	}
				}
				if(e.getSource()==agregarStockKitInstalacion) {
					if((Integer.parseInt(kitInstalacionSpinner.getValue().toString())) > 0) {
						Controlador.getInstancia().agregarKitInstalacion(Integer.parseInt(kitInstalacionSpinner.getValue().toString()),Integer.parseInt(idEmpleadoConectado.getText()));
	                	JOptionPane.showMessageDialog(null, "Stock de kit de instalacion agregado correctamente");
	                	setVisible(false);
	                	Controlador.getInstancia().menuModificarStockArticulos(idEmpleadoConectado);
					}else {
	                	JOptionPane.showMessageDialog(null, "Stock de kit de instalacion a agregar debe ser positivo");
	                }
				}
				if(e.getSource()==quitarStockKitInstalacion) {
					if((Integer.parseInt(kitInstalacionSpinner.getValue().toString())) > 0) {
						if((Integer.parseInt(stockCondensadora.getText()) - Integer.parseInt(evaporadoraSpinner.getValue().toString()) >= 0)){
							Controlador.getInstancia().quitarKitInstalacion(Integer.parseInt(kitInstalacionSpinner.getValue().toString()),Integer.parseInt(idEmpleadoConectado.getText()));
		                	JOptionPane.showMessageDialog(null, "Stock de kit de instalacion eliminado correctamente");
		                	setVisible(false);
		                	Controlador.getInstancia().menuModificarStockArticulos(idEmpleadoConectado);
						}else {
							JOptionPane.showMessageDialog(null, "Error. El stock del kit de instalacion no puede ser menor a 0");
						}
					}else {
	                	JOptionPane.showMessageDialog(null, "Stock de kit de instalacion a quitar debe ser positivo");
	                }
				}
			}
	}
}
