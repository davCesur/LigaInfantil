
package liga;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import utils.ui;
import utils.datos;

public class Principal {

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

		//datos por defecto en la generación automática
		String nombreLiga = "La SuperLiga";
		int edadLiga=12;
		int jornadasJugadas = 15;
		int numeroEquipos=8;
		
		
		equipos = crearListaEquipos(numeroEquipos, edadLiga);
		arbitros = new Arbitro[numeroEquipos/2]; 
		for (int i=0;i<arbitros.length;i++) {
			arbitros[i]= crearArbitro();
		}
		
		liga = new Liga(nombreLiga,equipos,arbitros);
		calendario = liga.getCalendario();
		generarPartidos(calendario,jornadasJugadas);
		clasificacion = new Clasificacion(equipos,calendario);
		
		ui.print( "Liga creada automáticamente"
				+ liga.info()
				+ "Pulse enter para volver");
		ui.readKeyboard();
		
		//equipos[0].getJugadores()[0].cambiarEdad();
		//ui.print(equipos[0].getJugadores()[0].getCategoria());


	}

	public void cambiarNumeroEquipos() {

		int numeroEquipos=2;
		while( !(numeroEquipos %2 ==0 && numeroEquipos >= 4 && numeroEquipos <= 40) ) {
			numeroEquipos = ui.readKeyboardInt("Introduzca un número de equipos (par entre 4 y 40): ");
		}
		
		

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
				{"1","1 - Crear Liga"},
				{"2","2 - Editar Liga"},
				{"3","3 - Ver la clasificación"},
				{"4","4 - Ver calendario"},
				{"5","5 - Guardar clasificación en archivo"},
				{"6","6 - Guardar calendario en archivo"},
				{"",""},
				{"0","0 - Salir"},
				{"",""}
		};
		
		String opcion = ui.menu("GENERADOR DE LIGAS",elements);
		
		switch( opcion.toUpperCase() ) {
		case "1":
			crearLiga();
			break;
		case "2":
			if( checkLiga("Primero tiene que crear una liga", true) ) {
				menuEditarLiga();
			}
			break;
		case "3":
			if( checkLiga("Primero tiene que crear una liga", true) ) {
				mostrarClasificacion();
			}
			break;
		case "4":
			if( checkLiga("Primero tiene que crear una liga", true) ) {
				mostrarCalendario();
			}
			break;
		case "5":
			if( checkLiga("Primero tiene que crear una liga", true) ) {
				guardarClasificacion();
			}
			break;
		case "6":
			if( checkLiga("Primero tiene que crear una liga", true) ) {
				guardarCalendario();
			}
			break;
		case "0":
			ui.print("\nSaliendo... ¡Hasta otra amigo!\n\n");
			System.exit(0);
		}
		
		menu();

	}
	
	/**
	 * Mostramos el ménu de Editar Liga
	 */
	private static void menuEditarLiga() {

		String[][] elements = {
			{"1","1 - Mostrar los datos de la liga"},
			{"2","2 - Editar el nombre de la liga"},
			{"3","3 - Editar equipos"},
			{"",""},
			{"0","0 - Volver"},
			{"",""}
		};

		String opcion = ui.menu("EDITAR LA LIGA", elements);
		
		switch( opcion.toUpperCase() ) {
		case "1":
			ui.print(liga.info());
			ui.readKeyboard("Pulse enter para volver");
			menuEditarLiga();
			break;
		case "2":
			liga.cambiarNombre();
			menuEditarLiga();
			break;
		case "0":
		}

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
	 * Comprueba si se ha creado la liga, reportando un error y esperando a pulsar enter
	 */
	private static boolean checkLiga(String errorMensaje, boolean pulsar) {
		
		if( checkLiga(errorMensaje) ) {
			return true;
		} else {
			ui.readKeyboard("Pulse enter para continuar.");
			return false;
		}
	}

	/** 
	 * Comprueba si se ha creado la liga, reportanto un error en caso de que no
	 */
	private static boolean checkLiga(String errorMensaje) {
		
		if( checkLiga() ) {
			return true;
		} else {
			ui.print(errorMensaje);
			return false;
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


}
