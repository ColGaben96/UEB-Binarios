package co.edu.unbosque.model;

import java.io.*;
import java.util.Random;

public class Binaries {
	
	public String writeBinaryFile(String fileName) throws IOException {
		File f = new File("./docs/Output/"+fileName);
		FileOutputStream fos = new FileOutputStream(f);
		DataOutputStream dos = new DataOutputStream(fos);
		Random random = new Random();
		String line = "";
		Double[] b = new Double[30];
		for (int i = 0; i < b.length; i++) { 
			b[i] = random.nextDouble()*100;
			line += b[i]+"\n";
		}
		dos.writeUTF(line);
		dos.close();
		return f.getAbsolutePath();
	}
	
	public String readBinaryFile(String fileName) throws IOException {
		String lastBin = "";
		File f = new File("./docs/Output/"+fileName);
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		String[] myBin = dis.readUTF().split("\n");
		for (int i = 0; i < myBin.length; i++) {
			lastBin += myBin[i] + "\n";
		}
		dis.close();
		return lastBin;
	}
	
}
