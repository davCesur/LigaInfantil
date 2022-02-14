/**
 * User Interface 
 * @author equipo 4
 *
 */

package liga;

import java.util.Scanner;

public class ui {

	/**
	 * 
	 */
	public ui() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}
	
	public static void print(String texto) {
		System.out.println(texto);
	}
	
	/**
	 * Read (form keyboard) 
	 * @return String
	 */
	public static String readKeyboard() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
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


}
