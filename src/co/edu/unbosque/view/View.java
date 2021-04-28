package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.controller.Controller;

import java.awt.*;
import java.io.IOException;

/**
 * @author Gabriel Blanco
 * Clase para definir la ventana principal
 */
public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private Dialogos dialogos = new Dialogos();
	private PanelFuncionesSuperiores toolbar = new PanelFuncionesSuperiores();
	private PanelOperaciones operaciones = new PanelOperaciones();
	private PanelResultado resultado = new PanelResultado();
	
	/**
	 * M�todo para iniciar la ventana principal
	 * @author Gabriel Blanco
	 * @param control
	 */
	public void iniciar(Controller control) {
		cargar();
		addComponentes();
		escucharComponentes(control);
	}
	/**
	 * M�todo para cargar la configuraci�n de la ventana principal
	 * @author Gabriel Blanco
	 */
	public void cargar() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setTitle("Archivos Binarios");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);
	}
	
	/**
	 * M�todo para a�adir los componentes de la ventana principal
	 * @author Gabriel Blanco
	 */
	public void addComponentes() {
		add(toolbar, BorderLayout.NORTH);
		add(operaciones, BorderLayout.WEST);
		add(resultado, BorderLayout.CENTER);
		
	}
	
	/**
	 * M�todo para escuchar los componentes donde <pre>Controller</pre> va a manejar todas
	 * estas excepciones.
	 * @author Gabriel Blanco
	 * @param control
	 */
	public void escucharComponentes(Controller control) {
		//PanelFuncionesSuperiores
		toolbar.getAcercaDe().addActionListener(control);
		toolbar.getNuevo().addActionListener(control);
		toolbar.getGuardar().addActionListener(control);
		toolbar.getCargar().addActionListener(control);
		toolbar.getSalir().addActionListener(control);
		
		//PanelOperaciones
		operaciones.getEscribirBinarios().addActionListener(control);
		operaciones.getLeerBinarios().addActionListener(control);
		operaciones.getEscribirPropiedades().addActionListener(control);
		operaciones.getLeerPropiedades().addActionListener(control);
	}
	
	public String cargarArchivo() throws IOException {
		String path = "";
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Forest Binary Files", new String[] {"FORESTBIN"});
		chooser.addChoosableFileFilter(filter);
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(chooser);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			path = chooser.getSelectedFile().getAbsolutePath();
			return path;
		} else {
			//No hace nada
			return null;
		}
	}
	
	/**
	 * M�todo para guardar un archivo via JFileChooser
	 * @author Gabriel Blanco
	 * @param linea
	 * @throws IOException
	 */
	public String guardarArchivo() throws IOException {
		String path = "";
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Forest Binary Files", new String[] {"FORESTBIN"});
		chooser.addChoosableFileFilter(filter);
		chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(chooser);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			path = chooser.getSelectedFile().getAbsolutePath();
		} 
		else {
			//No hace nada
		}
		return path+".forestbin";
	}

	public Dialogos getDialogos() {
		return dialogos;
	}
	public PanelFuncionesSuperiores getToolbar() {
		return toolbar;
	}
	public PanelOperaciones getOperaciones() {
		return operaciones;
	}
	public PanelResultado getResultado() {
		return resultado;
	}
	
}
