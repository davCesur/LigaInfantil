package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

public class datos {
	
	

	public datos() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static String path() {
		try {
			return new File(datos.class.getProtectionDomain().getCodeSource().getLocation()
				    .toURI()).getPath();
		} catch (URISyntaxException e) {
			System.out.println("Pete en path");
			e.printStackTrace();
		}

		return "";
	}
	
	
	/**
	 * Lee un archivo y lo retorna como string
	 * @param nombreFichero
	 * @return
	 */
	public static String leerArchivo(String nombreFichero) {
		
		String salida ="";
		
		try {
			FileReader lector = new FileReader(nombreFichero);
			BufferedReader buffLector = new BufferedReader(lector);
			
			String linea;
			while( (linea=buffLector.readLine() ) != null ) {
				salida += linea;
			}
			
			lector.close();
			
		} catch (IOException e) {
			System.out.println("Pete en datos.leerArchivo");
			e.printStackTrace();
		}
		
		return salida;
	}
	
	/**
	 * Escribe un archivo según texto pasado
	 * @param nombreFichero
	 * @param texto
	 * @return boolean success
	 */
	public static boolean escribirArchivo(String nombreFichero, String texto) {
		try {

			FileWriter jugEscritor = new FileWriter(nombreFichero, false);
			BufferedWriter buffJugador = new BufferedWriter(jugEscritor);
			buffJugador.write(texto);
			buffJugador.newLine();
			buffJugador.close();

			return true;
			
		} catch (IOException e) {
			System.out.println("Pete en datos.escribirArchivo");
			e.printStackTrace();
			return false;
		}
	}
	
	

}
