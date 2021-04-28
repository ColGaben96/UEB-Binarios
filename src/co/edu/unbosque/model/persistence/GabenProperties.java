package co.edu.unbosque.model.persistence;

/**
 * @author Gabriel Blanco Clase para usar propiedades
 */

import java.io.*;
import java.util.Properties;

public class GabenProperties {
	private Properties property = new Properties();

	/**
	 * Método para escribir la propiedad
	 * 
	 * @author Gabriel Blanco
	 * @param key
	 * @param value
	 * @param location
	 * @param comments
	 * @throws IOException
	 */
	public String escribirPropiedad(String key, String value, String fileName, String comments) throws IOException {
		File f = new File("./docs/Output/"+fileName);
		property.setProperty(key, value);
		property.store(new FileOutputStream(f), comments);
		return f.getAbsolutePath();
	}

	/**
	 * Método para leer la propiedad
	 * 
	 * @author Gabriel Blanco
	 * @param location
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String leerPropiedad(String fileName, String key) throws IOException {
		File f = new File("./docs/Output/"+fileName);
		String linea = "";
		property.load(new FileInputStream(f));
		linea += property.getProperty(key);
		return linea;

	}
}
