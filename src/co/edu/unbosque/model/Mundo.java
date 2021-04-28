package co.edu.unbosque.model;

import java.io.IOException;

import co.edu.unbosque.model.persistence.GabenFile;
import co.edu.unbosque.model.persistence.GabenProperties;

/**
 * @author Gabriel Blanco
 * Clase "multitoma" donde se define la solución de la problemática
 */
public class Mundo {
	private GabenFile archivo = new GabenFile();
	private GabenProperties propiedad = new GabenProperties();
	private Binaries binaries = new Binaries();
	private Client[] client = new Client[3];
	
	public Mundo() {
		String name1 = "Tom Johnson", name2 = "John Appleseed", name3 = "Jeff Burton";
		String country1 = "United Kingdom", country2 = "United States", country3 = "Canada";
		int age1 = 23, age2 = 45, age3 = 18;
		long phoneNumber1 = 425332323, phoneNumber2 = 983232145, phoneNumber3 = 623232143;
		client[0] = new Client(name1, country1, age1, phoneNumber1);
		client[1] = new Client(name2, country2, age2, phoneNumber2);
		client[2] = new Client(name3, country3, age3, phoneNumber3);
	}
	
	public String escribirPropiedadesDelCliente() throws IOException {
		var message = "";
		message = propiedad.escribirPropiedad("nombreCliente1", client[0].getName(), "clients.properties", null);
		message = propiedad.escribirPropiedad("paisCliente1", client[0].getCountry(), "clients.properties", null);
		message = propiedad.escribirPropiedad("edadCliente1", String.valueOf(client[0].getAge()), "clients.properties", null);
		message = propiedad.escribirPropiedad("telefonoCliente1", String.valueOf(client[0].getPhoneNumber()), "clients.properties", null);
		message = propiedad.escribirPropiedad("nombreCliente2", client[1].getName(), "clients.properties", null);
		message = propiedad.escribirPropiedad("paisCliente2", client[1].getCountry(), "clients.properties", null);
		message = propiedad.escribirPropiedad("edadCliente2", String.valueOf(client[1].getAge()), "clients.properties", null);
		message = propiedad.escribirPropiedad("telefonoCliente2", String.valueOf(client[1].getPhoneNumber()), "clients.properties", null);
		message = propiedad.escribirPropiedad("nombreCliente3", client[2].getName(), "clients.properties", null);
		message = propiedad.escribirPropiedad("paisCliente3", client[2].getCountry(), "clients.properties", null);
		message = propiedad.escribirPropiedad("edadCliente3", String.valueOf(client[2].getAge()), "clients.properties", null);
		message = propiedad.escribirPropiedad("telefonoCliente3", String.valueOf(client[2].getPhoneNumber()), "clients.properties", null);
		return message;
	}
	
	public String escribirArchivosBinarios() throws IOException {
		var message = "";
		message = binaries.writeBinaryFile("client.bin");
		return message;
	}
	
	public String leerPropiedadesDelCliente() throws IOException {
		var message = "";
		message += propiedad.leerPropiedad("clients.properties", "nombreCliente1")+"; ";
		message += propiedad.leerPropiedad("clients.properties", "paisCliente1")+"; ";
		message += propiedad.leerPropiedad("clients.properties", "edadCliente1")+"; ";
		message += propiedad.leerPropiedad("clients.properties", "telefonoCliente1")+"\n";
		message += propiedad.leerPropiedad("clients.properties", "nombreCliente2")+"; ";
		message += propiedad.leerPropiedad("clients.properties", "paisCliente2")+"; ";
		message += propiedad.leerPropiedad("clients.properties", "edadCliente2")+"; ";
		message += propiedad.leerPropiedad("clients.properties", "telefonoCliente2")+"\n";
		message += propiedad.leerPropiedad("clients.properties", "nombreCliente3")+"; ";
		message += propiedad.leerPropiedad("clients.properties", "paisCliente3")+"; ";
		message += propiedad.leerPropiedad("clients.properties", "edadCliente3")+"; ";
		message += propiedad.leerPropiedad("clients.properties", "telefonoCliente3")+"\n";
		return message;
	}
	
	public String leerArchivosBinarios() throws IOException {
		return binaries.readBinaryFile("client.bin");
	}
	
	public Binaries getBinaries() {
		return binaries;
	}

	public String toString() {
		return "Buena Hackerman, crack, leyenda";
	}

	public GabenFile getArchivo() {
		return archivo;
	}

	public GabenProperties getPropiedad() {
		return propiedad;
	}
}
