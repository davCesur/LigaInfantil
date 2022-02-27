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
		int longitud = array.length+elemento.length;

		String nuevoArray[][] = new String[longitud][];

		for (int i=0; i<array.length ; i++) {
			nuevoArray[i] = array[i];
		}
		for (int i=0; i<elemento.length ; i++) {
			nuevoArray[i+array.length] = elemento[i];
		}

		return nuevoArray;
		

	}

	public static Partido[] arrayAdd(Partido array[], Partido partido)
	{
		int longitud = array.length;

		Partido nuevoArray[] = new Partido[longitud+1];

		for (int i=0; i<array.length ; i++) {
			nuevoArray[i] = array[i];
		}
		
		nuevoArray[longitud] = partido;

		return nuevoArray;
	}

	public static Partido[] arrayAdd(Partido array[], Partido partido[])
	{
		int longitud = array.length+partido.length;

		Partido nuevoArray[] = new Partido[longitud];

		for (int i=0; i<array.length ; i++) {
			nuevoArray[i] = array[i];
		}
		for (int i=0; i<partido.length ; i++) {
			nuevoArray[i+array.length] = partido[i];
		}

		return nuevoArray;
	}

}
