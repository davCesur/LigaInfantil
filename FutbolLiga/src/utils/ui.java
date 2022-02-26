/**
 * User Interface 
 * @author equipo 4
 *
 */

package utils;

import java.util.Scanner;

public class ui {

	
	/**
	 * Clear console printing 200 new lines
	 */
	public static void cleanConsole() {
		for( int i=0 ; i<200 ; i++ ) {
			System.out.println();
		}
	}

	/**
	 * Muestra por pantalla el texto pasado
	 */
	public static void print(String texto) {
		System.out.println(texto);
	}
	
	/**
	 * Muestra por pantalla el texto pasado sin hacer retorno de carro
	 */
	public static void print(String texto, boolean bool) {
		System.out.print(texto);
	}
	
	
	//#### entrada por teclado

	/**
	 * Read (form keyboard) 
	 * @return String
	 */
	public static String readKeyboard() {
		Scanner sc = new Scanner(System.in);
		String retorno = sc.nextLine();
		return retorno;
	}

	/**
	 * Read (form keyboard) 
	 * @return String
	 */
	public static String readKeyboard(String mensaje) {
		print(mensaje);
		Scanner sc = new Scanner(System.in);
		String retorno = sc.nextLine();
		return retorno;
	}

	/**
	 * Read (form keyboard) and repeat while is empty
	 * @return String
	 */
	public static String readKeyboardString(String mensaje) {

		if( !mensaje.equals("") )
			print(mensaje);

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		while( input.equals("") ) {
			print("No ha introducido ningún valor.\n"+mensaje);
			input = sc.nextLine();
		}
		
		return input;
	}


	/**
	 * Read (form keyboard) and repeat while is not int
	 * @return int
	 */
	public static int readKeyboardInt(String mensaje) {

		if( !mensaje.equals("") )
			print(mensaje);

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int output = 0;
		boolean found = false;

		while( !found ) {
			try {
				output = Integer.valueOf(input);
				found = true;
			}
			catch (NumberFormatException ex) {
				found = false;
				print("Valor introducido incorrecto.\nDebe introducir un número "
						+ "entero\n"+mensaje);
				input = sc.nextLine();
			}
		}
		return output;
	}
	public static int readKeyboardInt() {
		return readKeyboardInt("");
	}


	/**
	 * Read (form keyboard) and repeat while is not Float
	 * @return Float
	 */
	public static float readKeyboardFloat(String mensaje) {

		if( !mensaje.equals("") )
			print(mensaje);

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		float output=0;
		boolean found=false;

		while( !found ) {
			try {
				output = Float.parseFloat(input);
				found = true;
			}
			catch (NumberFormatException ex) {
				found = false;
				print("Valor introducido incorrecto.\nUnilice el \".\" (punto) "
						+ "para los decimales.\n"+mensaje);
				input = sc.nextLine();
			}
		}
		return output;
	}


	/**
	 * Read (form keyboard) and repeat while is not double
	 * Cut to decimals numbers
	 * @return double
	 */
	public static double readKeyboardDouble(String mensaje, int decimals) {

		if( !mensaje.equals("") )
			print(mensaje);

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		double output=0;
		boolean found=false;

		while( !found ) {
			try {
				output = Double.parseDouble(input);
				found = true;
			}
			catch (NumberFormatException ex) {
				found = false;
				print("Valor introducido incorrecto.\nUnilice el \".\" (punto) "
						+ "para los decimales.\n"+mensaje);
				input = sc.nextLine();
			}
		}

		if( decimals > 0) {
			return (double)(Math.round(output*Math.pow(10,decimals)))/(Math.pow(10,decimals));
		}
		return output;
	}


	/**
	 * Read (form keyboard) and return it if is a valid option
	 *  Get:
	 * 	 array validOptions -> array of valid options to compare
	 *  @return String 
	 */
	public static String readWhitOptions( String[] validOptions ) {

		boolean found=false;
		String input=readKeyboard();

		for( String option:validOptions ) {
			if( option.toUpperCase().equals(input.toUpperCase())  ) {
				found=true;
			}
		}

		if( found ) {
			return input;
		} else {
			return "";
		}
	}

	
	
	//##### Útiles diseño
	
	
	/**
	 * Imprime la cabecera con el texto dado 
	 */
	public static void printCabecera(String texto) {
		int longitudLinea=50;
		String linea="\n";
		String out = "";
		
		//out += "*****************************************\n";
		int asteriscos=( longitudLinea-texto.length() )/2;
		for( int i=1 ; i<=asteriscos-1 ; i++) {
			out+="*";
		}
		out+=" "+texto+" ";
		for( int i=1 ; i<=asteriscos-1 ; i++) {
			out+="*";
		}
		
		for( int i=1 ; i<=out.length() ; i++) {
			linea+="*";
		}
		linea+="\n";
		
		out = "\n"+linea+out+linea+"\n";
		ui.print(out);
		
	}
	
	
	/**
	 * Imprime por salida estándar en formato menu
	 * @param String[][] elementos del menu
	 */
	private static void printMenu(String cabecera, String[][] elements) {
		
		ui.printCabecera(cabecera);
		ui.print("          Seleccione una opción\n");
		ui.print("\n");

		//Print elements
		for( String[] element:elements ) {
			ui.print("  "+element[1]+"\n");
		}
	}

	
	/**
	 * Muestra un menú según array pasado 
	 * Retorna String con la opción escogida
	 */
	public static String menu(String cabecera, String[][] elements) {

		ui.cleanConsole();
		printMenu(cabecera, elements);

		//Save valid options for check later
		String[] validOptions = new String[0];
		for( String[] element:elements ) {
			if( element[0]!="" ) { //Exclude elements without option (information only) 
				String elementTmp[] = new String[validOptions.length+1];
				System.arraycopy(validOptions, 0, elementTmp, 0, validOptions.length);
				elementTmp[elementTmp.length-1] = element[0];
				validOptions = elementTmp;
			}
		}

		ui.print("Introduzca una opción: ", true);
		String option;
		int forClean=0;
		while( ( option = ui.readWhitOptions(validOptions) ).isEmpty() ) {
			ui.print("Opción incorrecta. Introduzca una opción: ", true);	
			forClean++;
			if( forClean%10 == 0) { //Clean console and show menu again after 10 errors
				ui.cleanConsole();
				printMenu(cabecera, elements);
				ui.print("Introduzca una opción: ", true);
			}
		}
		
		return option;
	}



}
