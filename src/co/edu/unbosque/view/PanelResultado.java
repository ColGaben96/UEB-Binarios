package co.edu.unbosque.view;

import javax.swing.*;

import java.awt.*;
import java.io.File;

public class PanelResultado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea resultado;
	private JScrollPane scroll;
	
	public PanelResultado() {
		cargar();
		addComponentes();
	}
	
	public void cargar() {
		setLayout(new BorderLayout());
		resultado = new JTextArea(800,600);
		resultado.setBackground(Color.BLACK);
		resultado.setForeground(new Color(0, 255, 0));
		resultado.setEditable(false);
		resultado.setWrapStyleWord(true);
		resultado.setLineWrap(true);
		resultado.setAutoscrolls(true);
		scroll = new JScrollPane(resultado);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setViewportView(resultado);
		scroll.setBounds(23, 40, 394, 191);
		try {
			Font mononoki = Font.createFont(Font.TRUETYPE_FONT, new File("./docs/mononoki-Regular.ttf")).deriveFont(12f);
			resultado.setFont(mononoki);
		} catch (Exception e) {
			System.out.println("Some things aren't in place! Find the font \"mononoki-Regular.ttf\" and put it in place!");
		}
	}
	
	public void addComponentes() {
		add(scroll, BorderLayout.CENTER);
	}

	public JTextArea getResultado() {
		return resultado;
	}
	

}
