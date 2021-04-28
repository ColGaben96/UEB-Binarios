package co.edu.unbosque.controller;

import java.awt.AWTException;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Mundo;
import co.edu.unbosque.view.View;

/**
 * @author Gabriel Blanco Clase Controlador
 *
 */
public class Controller implements ActionListener {

	private Mundo mundo = new Mundo();
	private View view = new View();

	/**
	 * Método Constructor del Controlador
	 * 
	 * @throws IOException
	 */
	public Controller() throws Exception {
		GUI();
	}

	/**
	 * Método para probar casos puntuales en consola
	 * 
	 * @throws IOException
	 */
	public void Consola() throws Exception {
		// Se inicializa gui aqui ya que es necesario para probar por via JOptionPane
		/*
		 * TODO: Buscar un método mas eficiente para mostrar TODOS los errores por
		 * JOptionPane
		 */
		boolean activo = true;
		while (activo) {
			try {
				int comando = Integer.parseInt(view.getDialogos().input(System.in, "Archivos Binarios: DebuggerMode",
						view.getDialogos().ayuda(), JOptionPane.PLAIN_MESSAGE));
				switch (comando) {
				default:
					view.getDialogos().output("Error", "Bad command!", JOptionPane.ERROR_MESSAGE);
					break;
				case 0:
					activo = false;
					break;
				case 1:
					activo = false;
					GUI();
					break;
				case 2:
					escribirBinarios();
					break;
				case 3:
					leerBinarios();
					break;
				case 4:
					escribirPropiedades();
					break;
				case 5:
					leerPropiedades();
					break;
				}
			} catch (Exception e) {
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				view.getDialogos().notification("¡Ingeniero, Pilas!", "He creado un archivo en \n"+mundo.getArchivo().makeLog(errors.toString()), MessageType.INFO);
				view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
						+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.txt en donde aparece el detalle específico del error causado.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Método para iniciar la GUI
	 */
	public void GUI() throws Exception {
		try {
			view.iniciar(this);
			view.setTitle("New Document.forestbin - Archivos Binarios");
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			view.getDialogos().notification("¡Ingeniero, Pilas!", "He creado un archivo en \n"+mundo.getArchivo().makeLog(errors.toString()), MessageType.INFO);
			view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
					+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.log en donde aparece el detalle específico del error causado.",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void escribirBinarios() throws Exception {
		view.getDialogos().notification("¡Ingeniero, Pilas!", "He creado un archivo en \n"+mundo.escribirArchivosBinarios(), MessageType.NONE);
	}
	
	public void leerBinarios() throws Exception {
		view.getDialogos().output("Toma tus binarios", mundo.leerArchivosBinarios(), JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void escribirPropiedades() throws Exception {
		view.getDialogos().notification("¡Ingeniero, Pilas!", "He creado un archivo en \n"+mundo.escribirPropiedadesDelCliente(), MessageType.NONE);
	}
	
	public void leerPropiedades() throws Exception {
		view.getDialogos().output("Toma tus propiedades", mundo.leerPropiedadesDelCliente(), JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * @author Carl Quinn
	 * Método para escuchar los eventos de la vista
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			/*
			 * Panel Funciones Superiores
			 */
			if(e.getActionCommand() == view.getToolbar().NUEVOARCHIVO) {
				if(view.getResultado().getResultado().getText() == "") {
					int result = JOptionPane.showConfirmDialog(null, "¿Desea guardar este documento?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
					if(result == JOptionPane.YES_OPTION) {
						mundo.getArchivo().escribirArchivo(view.getResultado().getResultado().getText(), view.guardarArchivo());
					}
				} else {
					view.getResultado().getResultado().setText("");
					view.setTitle("New Document.forestbin - Archivos Binarios");
				}
			}
			if(e.getActionCommand() == view.getToolbar().GUARDAR) {
				String newTitle = mundo.getArchivo().escribirArchivo(view.getResultado().getResultado().getText(), view.guardarArchivo());
				view.setTitle(newTitle+" - Archivos Binarios");
			}
			if(e.getActionCommand() == view.getToolbar().CARGAR) {
				String newTitle = view.cargarArchivo();
				view.getResultado().getResultado().setText(mundo.getArchivo().leerArchivo(newTitle));
				view.setTitle(newTitle+" - Archivos Binarios");
			}
			if(e.getActionCommand() == view.getToolbar().SALIR) {
				view.dispose();
			}
			if(e.getActionCommand() == view.getToolbar().ACERCADE) {
				view.getDialogos().output("Acerca De", "Archivos Binarios by The Forest Software Company\nv1.0", JOptionPane.INFORMATION_MESSAGE);
			}
			/*
			 * Panel Operaciones
			 */
			if(e.getActionCommand() == view.getOperaciones().ESCRIBIRBINARIOS) {
				String path = mundo.escribirArchivosBinarios();
				view.getResultado().getResultado().setText(view.getResultado().getResultado().getText()+"\n<<Writing binary files on "+path+">>\n");
			}
			if(e.getActionCommand() == view.getOperaciones().LEERBINARIOS) {
				view.getResultado().getResultado().setText(view.getResultado().getResultado().getText()+"\n<<Reading the binary files>>\n"+mundo.leerArchivosBinarios());
			}
			if(e.getActionCommand() == view.getOperaciones().ESCRIBIRPROPIEDADES) {
				String path = mundo.escribirPropiedadesDelCliente();
				view.getResultado().getResultado().setText(view.getResultado().getResultado().getText()+"\n<<Writing binary files on "+path+">>\n");
			}
			if(e.getActionCommand() == view.getOperaciones().LEERPROPIEDADES) {
				view.getResultado().getResultado().setText(view.getResultado().getResultado().getText()+"\n<<Reading the binary files>>\n"+mundo.leerPropiedadesDelCliente());
			}

		} 
		/*
		 * Estas líneas son para controlar en caso de que por falta de memoria no genere
		 * el log. Esto es vital para el programa ya que me permite llevar una trazabilidad
		 */
		catch (Exception e2) {
			StringWriter errors = new StringWriter();
			e2.printStackTrace(new PrintWriter(errors));
			try {
				view.getDialogos().notification("¡Ingeniero, Pilas!", "He creado un archivo en \n"+mundo.getArchivo().makeLog(errors.toString()), MessageType.INFO);
			} catch (IOException | AWTException e1) {
				view.getDialogos().output("Error Fatal",
						"Ha ocurrido un error inesperado donde se debe salir del programa.\nMotivo: Error creando el log de archivos",
						JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
			view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
					+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.log en donde aparece el detalle específico del error causado.",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
