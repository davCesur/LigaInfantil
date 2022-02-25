
package liga;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import utils.ui;
import utils.datos;

public class Principal {

	private static  int numeroEquipos = 20;
	private static  int edadLiga=12;
	private static  String nombreLiga="La SuperLiga";
	private static  int jornadasJugadas = 15;

	private static Equipo[] equipos;
	private static Arbitro[] arbitros;
	private static Liga liga;
	private static Calendario calendario;
	private static Clasificacion clasificacion;

	public static void main(String[] args) {
		
		menu();
		ui.print("Hasta otra amigo...");
		
	}
	
	private static void crearLiga() {
		
		int cantidadEquipos=2;
		while( cantidadEquipos %2 !=0 | cantidadEquipos < 4 | cantidadEquipos > 40 ) {
			cantidadEquipos = ui.readKeyboardInt("Introduzca un número de equipos (par entre 4 y 40): ");
		}
		
		numeroEquipos = cantidadEquipos;
		
		equipos = crearListaEquipos(numeroEquipos, edadLiga);
		arbitros = new Arbitro[numeroEquipos/2]; 
		for (int i=0;i<arbitros.length;i++) {
			arbitros[i]= crearArbitro();
		}
		
		liga = new Liga(nombreLiga,equipos,arbitros);
		calendario = liga.getCalendario();
		generarPartidos(calendario,jornadasJugadas);
		clasificacion = new Clasificacion(equipos,calendario);
		
		ui.print( "Liga creada automáticamente con "+" equipos\n"
				+ "Pulse enter para volver");
		ui.readKeyboard();


	}

	private static Jugador[] crearListaJugadores(int numeroJugadores, int edad, Equipo equipo) {
		String[] nombres = {"Pepe", "Juan", "María", "Melody", "Cayetano", "Christian", "Johnny",
				"Ibrahim", "Muhammad", "Cho Hej", "Robertinho", "Alicinha","Paulo Anton",
				"Alexander","Etham","Joel","Gisela","Martina","Jenny","Jessi","Tayra"};
		String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", 
				"Cariaga", "Carillo", "Carion", "Castillo", "Castorena", "Castro", 
				"Grande", "Grangenal", "Grano", "Grasia", "Griego",	"Grigalva" };

		String[] posiciones = {"Portero/a","Defensa","Centrocampista","Delantero/a"};


		Jugador[] listaJugadores= new Jugador[numeroJugadores];

		for (int i=0;i<numeroJugadores;i++) {
			Jugador jug = new Jugador();
			//Creamos el nombre
			int numero = (int) Math.floor((Math.random())*nombres.length);
			jug.setNombre(nombres[numero]);

			//Creamos los apellidos
			numero = (int) Math.floor((Math.random())*apellidos.length);
			String apellido1 = apellidos[numero];
			numero = (int) Math.floor((Math.random())*apellidos.length);
			String apellido2 = apellidos[numero];
			jug.setApellidos(apellido1+" "+apellido2);

			//Creamos una posicion
			numero =(int) Math.floor((Math.random())*posiciones.length);
			jug.setPosicion(posiciones[numero]);

			//Ponemos la edad que hemos definido arriba
			jug.setEdad(edad);

			//Crear dorsal
			jug.setDorsal(i+1);
			
			//Añadir equipo
			jug.setEquipo(equipo);

			listaJugadores[i]=jug;
		}
		return listaJugadores;
	}
	
	private static Equipo[] crearListaEquipos(int numeroEquipos, int edad) {
		String[]  barrios = {"El Perchel", "La Victoria", "El Rincon de la Victoria",
							"Huelin","Cortijo Alto", "Ronda", "Campanillas",
							"La Cruz de Humilladero", "El Soho", "El Puerto de la Torre",
							"Cártama","Velez Málaga","Cerrado de Calderon","La Paz",
							"Torre de Benagalbón", "Montilla","El Ejido", "La Roca",
							"La Palmilla", "El Palo", "Los Asperones", "Carranque"};
		String[] mascotas = {"Los Limones", "Los Cangrejos", "Los Michis", "Los Asquerosos",
								"Los Carpinchos", "Los Satanases", "Los Diablitos", "Los Olvidones",
								"Los Amantes", "Los Chonis", "Los Cayetanos","Los Perroflautas",
								"Los Apestados", "Las Divinas", "Las Ingenieras", "Las Chunguitas",
								"Las Sirenitas", "Las Requetonas"};
		
		
		Equipo[] equipos = new Equipo[numeroEquipos];
		//Edad debe ser siempre la misma
		
		for(int i=0;i<numeroEquipos;i++) {
			Equipo equipo = new Equipo();
			//Nombre del equipo y del Club
			String nombreEquipo;
			int numero = (int) Math.floor((Math.random())*mascotas.length);
			String mascota = mascotas[numero];
			numero = (int) Math.floor((Math.random())*barrios.length);
			String barrio = barrios[numero];
			equipo.setClub(barrio+" F.C.");
			
			if(barrio.startsWith("El ")) {
				barrio=barrio.substring(3);
				nombreEquipo=mascota + " del "+barrio;
			}else {
				nombreEquipo=mascota + " de "+barrio;
			}
			equipo.setNombre(nombreEquipo);
			
			//Hacer el entrenador
			Entrenador entrenador = crearEntrenador(equipo);
			equipo.setEntrenador(entrenador);
			
			//Crear e introducir a los jugadores
			int numeroJugadores = (int) Math.floor((Math.random())*8)+15;
			Jugador[] listaJugadores = crearListaJugadores(numeroJugadores, edad, equipo);
			equipo.setJugadores(listaJugadores);
		
			//Lo añadimos al array
			equipos[i]=equipo;
		
		
		}
		return equipos;
	}

	private static Entrenador crearEntrenador(Equipo equipo) {
		String[] nombres = {"Pepe", "Juan", "María", "Melody", "Cayetano", "Christian", "Johnny",
				"Ibrahim", "Muhammad", "Cho Hej", "Robertinho", "Alicinha","Paulo Anton",
				"Alexander","Etham","Joel","Gisela","Martina","Jenny","Jessi","Tayra"};
		String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", 
				"Cariaga", "Carillo", "Carion", "Castillo", "Castorena", "Castro", 
				"Grande", "Grangenal", "Grano", "Grasia", "Griego",	"Grigalva" };
		
		Entrenador entrenador = new Entrenador();
		//Nombre del entrenador
		int numero =(int) Math.floor((Math.random())*nombres.length);
		String nombre = nombres[numero];
		numero =(int) Math.floor((Math.random())*apellidos.length);
		String apellido = apellidos[numero];
		//Edad del entrenador
		int edad = (int) Math.floor((Math.random())*48)+18;
		//Licencia
		int licencia = (int) Math.floor((Math.random())*900000)+100000;
		entrenador.setNombre(nombre);
		entrenador.setApellidos(apellido);
		entrenador.setEdad(edad);
		entrenador.setEquipo(equipo);
		entrenador.setNumeroLicencia(licencia);
		
		return entrenador;
	}

	private static Arbitro crearArbitro() {
		String[] nombres = {"Pepe", "Juan", "María", "Melody", "Cayetano", "Christian", "Johnny",
				"Ibrahim", "Muhammad", "Cho Hej", "Robertinho", "Alicinha","Paulo Anton",
				"Alexander","Etham","Joel","Gisela","Martina","Jenny","Jessi","Tayra"};
		String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", 
				"Cariaga", "Carillo", "Carion", "Castillo", "Castorena", "Castro", 
				"Grande", "Grangenal", "Grano", "Grasia", "Griego",	"Grigalva" };
		
		Arbitro arbitro = new Arbitro();
		//Nombre del arbitro
		int numero =(int) Math.floor((Math.random())*nombres.length);
		String nombre = nombres[numero];
		numero =(int) Math.floor((Math.random())*apellidos.length);
		String apellido = apellidos[numero];
		//Edad del arbitro
		int edad = (int) Math.floor((Math.random())*48)+18;
		//Licencia
		int licencia = (int) Math.floor((Math.random())*900000)+100000;
		arbitro.setNombre(nombre);
		arbitro.setApellidos(apellido);
		arbitro.setEdad(edad);
		arbitro.setLicencia(licencia);
		
		return arbitro;
	}

	private static void generarPartidos(Calendario calendario, int numeroJornadas) {
		
		final int MAXGOLES=7;
		Jornada[] jornadas = calendario.getJornadas();
		int totalJornadas = jornadas.length;
		
		for (int i=0; i<numeroJornadas && i<totalJornadas; i++) {
//System.out.println("Jornada: "+(i+1));
			Partido[] partidos = jornadas[i].getPartidos();
			for (Partido par: partidos) {
				int golesLocales = (int)Math.floor((Math.random())*MAXGOLES);
				int golesVisitantes = (int)Math.floor((Math.random())*MAXGOLES);
				par.setgLocal(golesLocales);
				par.setgVisitante(golesVisitantes);
//System.out.println(par);
			}
			jornadas[i].terminar();
		}
		
	}
	
	
	/**
	 * Mostramos el ménu pricipal
	 */
	private static void menu() {

		String[][] elements = {
				{"1","1 - Crear Liga","crearLiga"},
				{"2","2 - Editar Liga","menuEditarLiga"},
				{"3","3 - Ver la clasificación","mostrarClasificacion"},
				{"4","4 - Ver calendario","mostrarCalendario"},
				{"5","5 - Guardar clasificación en archivo","guardarClasificacion"},
				{"6","6 - Guardar calendario en archivo","guardarCalendario"},
				{"","",""},
				{"0","0 - Salir","noRepetir"},
				{"","",""}
		};
		
		menu(elements);
	}
	
	/**
	 * Mostramos el ménu de Editar Liga
	 */
	private static void menuEditarLiga() {

		String[][] elements = {
				{"1","1 - Modificar el número de equipos","modificarNumeroEquipos"},
				{"","",""},
				{"0","0 - Volver","noRepetir"},
				{"","",""}
		};

		menu(elements);
	}
	
	
	private static void mostrarClasificacion() {
		
		ui.print(clasificacion.toString());
		
		ui.print("Pulse enter para volver");
		ui.readKeyboard();
	}
	
	
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
	
	
	private static void mostrarCalendario() {
		
		ui.print(liga.getCalendario().toString());
		
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
	
	

	/** 
	 * Comprueba si se ha creado la liga
	 */
	private static boolean checkLiga(String errorMensaje) {
		if( liga == null ) {
			ui.print(errorMensaje);
			return false;
		} else {
			return true;
		}
			
	}
	
	/** 
	 * Comprueba si se ha creado la liga
	 */
	private static boolean checkLiga() {
		if( liga == null ) {
			return false;
		} else {
			return true;
		}
			
	}
	
	/**
	 * Imprime por salida estándar en formato menu
	 * @param String[][] elementos del menu
	 */
	private static void printMenu(String[][] elements) {
		ui.printCabecera("GENERADOR DE LIGAS");
		ui.print("          Seleccione una opción\n");
		ui.print("\n");

		//Print elements
		for( String[] element:elements ) {
			ui.print("  "+element[1]+"\n");
		}
	}

	
	/**
	 * Muestra un menú según el array 
	 * para mostrar el menú inicial
	 */
	public static void menu(String[][] elements) {

		ui.cleanConsole();
		printMenu(elements);

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

		ui.print("Introduzca una opción: ");
		String option;
		int forClean=0;
		while( ( option = ui.readWhitOptions(validOptions) ).isEmpty() ) {
			System.out.print("Opción incorrecta. Introduzca una opción: ");	
			forClean++;
			if( forClean%10 == 0) { //Clean console and show menu again after 10 errors
				ui.cleanConsole();
				printMenu(elements);
				ui.print("Introduzca una opción: ");
			}
		}

		//Buscamos el elemento en elements y lo ejecutamos con lanzador
		boolean repetirMenu = true;
		for( String[] element:elements ) {
			if( !element[0].equals("") ) { //Exclude elementos sin opción seleccionable
				if( option.equals(element[0]) ) { //si hemos encontrado la selección, ejecutamos el método
					if( element[2].equals("noRepetir") ) {
						repetirMenu=false;
					} else {
						lanzador(element[2]);
					}
					break;
				}
			}
		}
		
		if( repetirMenu ) {
			menu(elements);
		}

	}
	
	/**
	 * Ejecuta el método method'metodo'
	 * donde metodo es el nombre restante del método a ejecutar
	 * ej: lanzador('Hola') ejecuta el método methodHola()
	 * @param metodo
	 */
	public static void lanzador(String metodo) {
		try {
			Method method = Principal.class.getDeclaredMethod(metodo);
			try {
				method.invoke(null);//by class
			} catch (InvocationTargetException e) {
				System.out.println();
				//throw new RuntimeException(e);
			}
		} catch (NoSuchMethodException e) {
			System.out.println();
			//throw new RuntimeException(e);
			//e.printStackTrace();
		} catch (RuntimeException e) {
			System.out.println();
			//throw new RuntimeException(e);
			//e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println();
			//throw new RuntimeException(e);
			//e.printStackTrace();
		}
	}





}
