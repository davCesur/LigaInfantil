/*
En el principal había:

	private static void guardarClasificacion() {

		if( checkLiga("No ha creado ninguna liga.\nCree una liga con la opción 1.") ) {

			String nombreArchivo = "Clasificacion.txt";

			ui.print("Ruta donde se guardará el archivo: " + datos.path() + "/");
			ui.print("Nombre de archivo por defecto: "+nombreArchivo);
			String leerNombreArchivo = ui.readKeyboard("Introduzca un nombre de archivo distinto (déjelo en blanco si no desea cambiarlo): ");
			if( !leerNombreArchivo.equals("") ) {
				nombreArchivo = leerNombreArchivo;
			}

			ui.print("Se va a guardar en: "+datos.path()+"/"+nombreArchivo);

			if( datos.escribirArchivo(nombreArchivo, clasificacion.toString()) ) {
				ui.print("Datos guardados correctamente.");
			} else {
				ui.print("Error al guardar los datos. Inténtelo de nuevo con otro nombre o ruta.");
			}
		}

		ui.print("Pulse enter para volver");
		ui.readKeyboard();
	}



		private static void guardarCalendario() {

		if( checkLiga("No ha creado ninguna liga.\nCree una liga con la opción 1.") ) {

			String nombreArchivo = "Calendario.txt";

			ui.print("Ruta donde se guardará el archivo: " + datos.path() + "/");
			ui.print("Nombre de archivo por defecto: "+nombreArchivo);
			String leerNombreArchivo = ui.readKeyboard("Introduzca un nombre de archivo distinto (déjelo en blanco si no desea cambiarlo): ");
			if( !leerNombreArchivo.equals("") ) {
				nombreArchivo = leerNombreArchivo;
			}

			ui.print("Se va a guardar en: "+datos.path()+"/"+nombreArchivo);

			if( datos.escribirArchivo(nombreArchivo, liga.getCalendario().toString()) ) {
				ui.print("Datos guardados correctamente.");
			} else {
				ui.print("Error al guardar los datos. Inténtelo de nuevo con otro nombre o ruta.");
			}
		}

		ui.print("Pulse enter para volver");
		ui.readKeyboard();
	}

*/



package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

public class io {
	
	

	public io() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static String path() {
		try {
			return new File(io.class.getProtectionDomain().getCodeSource().getLocation()
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
