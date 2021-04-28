package co.edu.unbosque.view;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.InputStream;

import javax.swing.JOptionPane;

/**
 * @author Gabriel Blanco Clase para mostrar los diálogos
 */
public class Dialogos {

	/**
	 * Método utilizado para la entrada del usuario
	 * 
	 * @param systemIn
	 * @param title
	 * @param message
	 * @param messageType
	 * @return
	 */
	public String input(InputStream systemIn, String title, String message, int messageType) {
		return JOptionPane.showInputDialog(null, message, title, messageType);
	}

	/**
	 * Método utilizado para la salida del sistema
	 * 
	 * @param title
	 * @param message
	 * @param messageType
	 */
	public void output(String title, String message, int messageType) {
		JOptionPane.showMessageDialog(null, message, title, messageType);
	}
	/**
	 * Método para mostrar notificaciones del sistema al usuario
	 * @param title
	 * @param message
	 * @throws AWTException
	 */
	public void notification(String title, String message, MessageType messageType) throws AWTException {
		SystemTray tray = SystemTray.getSystemTray();
		Image image = Toolkit.getDefaultToolkit().createImage("./docs/icon.png");
		TrayIcon icon = new TrayIcon(image, "Message by Gaben");
		icon.setImageAutoSize(true);
		icon.setToolTip("Message by Gaben");
		tray.add(icon);
		icon.displayMessage(title, message, messageType);
	}

	/**
	 * Método para mostrar la ayuda del funcionamiento del programa al usuario
	 * 
	 * @return
	 */
	public String ayuda() {
		return "0. Salir\n"
				+ "1. Cargar GUI\n"
				+ "2. Escribir Binarios\n"
				+ "3. Leer Binarios\n"
				+ "4. Escribir Propiedades\n"
				+ "5. Leer Propiedades\n";
	}

}
