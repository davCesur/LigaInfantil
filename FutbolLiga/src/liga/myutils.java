package liga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class myutils {

	public static String[] arrayAdd(String array[], String elemento)
	{
		int longitud = array.length;

		String nuevoArray[] = new String[longitud];

		for (int i=0; i<longitud ; i++) {
			nuevoArray[i] = array[i];
		}

		nuevoArray[longitud] = elemento;
		return nuevoArray;
	}

	public static int[] arrayAdd(int array[], int elemento)
	{
		int longitud = array.length;

		int nuevoArray[] = new int[longitud+1];

		for (int i=0; i<longitud ; i++) {
			nuevoArray[i] = array[i];
		}

		nuevoArray[longitud] = elemento;
		return nuevoArray;
	}

	public static String[][] arrayAdd(String array[][], String elemento[])
	{
		int longitud = array.length;

		String nuevoArray[][] = new String[longitud+1][];

		for (int i=0; i<longitud ; i++) {
			nuevoArray[i] = array[i];
		}

		nuevoArray[longitud] = elemento;
		return nuevoArray;
	}

	public static String[][] arrayAdd(String array[][], String elemento[][])
	{
/*		ui.print("array:");
		ui.print( Arrays.toString(array) );
		ui.print("elemento:");
		ui.print( Arrays.toString(elemento) );
*/		
		int longitud = array.length+elemento.length;

		String nuevoArray[][] = new String[longitud][];

		for (int i=0; i<array.length ; i++) {
			nuevoArray[i] = array[i];
		}
		for (int i=0; i<elemento.length ; i++) {
			nuevoArray[i+array.length] = elemento[i];
		}

//ui.print("segundo array");
//ui.print( Arrays.toString(nuevoArray) );
		return nuevoArray;
		

	}

}
