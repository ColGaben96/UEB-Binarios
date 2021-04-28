package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelFuncionesSuperiores extends JPanel {

	private static final long serialVersionUID = 1L;
	private JSeparator separador = new JSeparator();
	private JMenuBar tooltip = new JMenuBar();
	private JMenu archivo = new JMenu("Archivo"), ayuda = new JMenu("Ayuda");
	private JMenuItem nuevo = new JMenuItem("Nuevo"), guardar = new JMenuItem("Guardar"), cargar = new JMenuItem("Cargar"), acercaDe = new JMenuItem("Acerca De"), salir = new JMenuItem("Salir");
	public final String NUEVOARCHIVO = "NuevoArchivoFrame", GUARDAR = "GuardarArchivoFrame", CARGAR = "CargarArchivoFrame", ACERCADE = "AcercaDeArchivoFrame", SALIR = "SalirFrame";
	
	public PanelFuncionesSuperiores() {
		cargar();
		addComponentes();
	}
	
	public void cargar() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		nuevo.setActionCommand(NUEVOARCHIVO);
		guardar.setActionCommand(GUARDAR);
		cargar.setActionCommand(CARGAR);
		acercaDe.setActionCommand(ACERCADE);
		salir.setActionCommand(SALIR);
	}
	
	public void addComponentes() {
		add(tooltip, BorderLayout.CENTER);
		tooltip.add(archivo); tooltip.add(ayuda);
		archivo.add(nuevo); archivo.add(separador); archivo.add(guardar); archivo.add(cargar); archivo.add(separador); archivo.add(salir);
		ayuda.add(acercaDe);
	}

	public JMenuItem getNuevo() {
		return nuevo;
	}

	public JMenuItem getGuardar() {
		return guardar;
	}

	public JMenuItem getCargar() {
		return cargar;
	}

	public JMenuItem getAcercaDe() {
		return acercaDe;
	}

	public JMenuItem getSalir() {
		return salir;
	}
	
	
	
}
