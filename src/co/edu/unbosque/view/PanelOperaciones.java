package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PanelOperaciones extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JButton escribirBinarios = new JButton("Escribir Binarios"), leerBinarios = new JButton("Leer Binarios");
	private JButton escribirPropiedades = new JButton("Escribir Propiedades"), leerPropiedades = new JButton("Leer Propiedades");
	public final String ESCRIBIRBINARIOS = "EscribirBinariosOperaciones", LEERBINARIOS = "LeerBinariosOperaciones", ESCRIBIRPROPIEDADES = "EscribirPropiedadesOperaciones", LEERPROPIEDADES = "LeerPropiedadesOperaciones";
	
	public PanelOperaciones() {
		cargar();
		addComponentes();
	}
	
	public void cargar() {
		setLayout(new GridLayout(4, 1));
		escribirBinarios.setActionCommand(ESCRIBIRBINARIOS);
		leerBinarios.setActionCommand(LEERBINARIOS);
		escribirPropiedades.setActionCommand(ESCRIBIRPROPIEDADES);
		leerPropiedades.setActionCommand(LEERPROPIEDADES);
		escribirBinarios.setBackground(Color.white);
		leerBinarios.setBackground(Color.white);
		escribirPropiedades.setBackground(Color.white);
		leerPropiedades.setBackground(Color.white);
		try {
			Font segoeui = Font.createFont(Font.TRUETYPE_FONT, new File("./docs/segoeui.ttf")).deriveFont(20f);
			escribirBinarios.setFont(segoeui);
			leerBinarios.setFont(segoeui);
			escribirPropiedades.setFont(segoeui);
			leerPropiedades.setFont(segoeui);
		} catch (Exception e) {
			System.out.println("Some things aren't in place! Find the font \"segoeui.ttf\" and put it in place!");
		}
	}
	
	public void addComponentes() {
		add(escribirBinarios);
		add(leerBinarios);
		add(escribirPropiedades);
		add(leerPropiedades);
	}

	public JButton getEscribirBinarios() {
		return escribirBinarios;
	}

	public JButton getLeerBinarios() {
		return leerBinarios;
	}

	public JButton getEscribirPropiedades() {
		return escribirPropiedades;
	}

	public JButton getLeerPropiedades() {
		return leerPropiedades;
	}
	
	
}
