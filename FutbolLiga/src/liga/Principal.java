
package liga;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Principal {

	private static Equipo[] equipos;
	private static Arbitro[] arbitros;
	private static Liga liga;
	private static Calendario calendario;
	private static Clasificacion clasificacion;

	public static void main(String[] args) {
		
		ui.print("");
		crearLiga();
		menuPrincipal();
		ui.print("Hasta otra amigo...");
		
	}
	
	private static void crearNuevaLiga() {
		
		String nombreLiga = ui.readKeyboardString("Introduzca el nombre de la liga: ");
		while( nombreLiga.equals("") | nombreLiga.length()>20 ) {
			ui.print("No puede dejar el nombre de la liga vacío o superar los 20 caracteres");
			nombreLiga = ui.readKeyboardString("Introduzca el nombre de la liga: ");
		}
		
		int numeroEquipos=2;
		while( numeroEquipos%2==1 | numeroEquipos<4 | numeroEquipos>40 ) {
			numeroEquipos = ui.readKeyboardInt("Introduzca un número de equipos (par entre 4 y 40): ");
		}
		
		Jugador jugador = new Jugador();
		String[][] categorias = jugador.getCategorias();
		int rangoInicial = 0;
		int rangoFinal = 0;
		try {
			rangoInicial = Integer.valueOf(categorias[0][1]);
			rangoFinal = Integer.valueOf(categorias[categorias.length-1][2]);
		}
		catch (NumberFormatException ex) {
			ui.print("Ocurrió un error en principal.crearNuevaLiga try");
			System.exit(1);
		}
		
		int edadLiga=-1;
		while( edadLiga<rangoInicial | edadLiga>rangoFinal ) {
			edadLiga = ui.readKeyboardInt("Introduzca la edad de los jugadores (entre "+rangoInicial+" y "+rangoFinal+"): ");
		}
		
		int jornadasJugadas=-1;
		while( jornadasJugadas<0 | jornadasJugadas>(numeroEquipos-1)*2 ) {
			jornadasJugadas = ui.readKeyboardInt("Introduzca un número de jornadas (entre 0 y "+( (numeroEquipos-1)*2 )+"): ");
		}
		
		crearLiga(nombreLiga, edadLiga, numeroEquipos, jornadasJugadas);
		
		ui.print( "\n\nLiga creada correctamente"
				+ liga.info()
				+ "Pulse enter para continuar");
		ui.readKeyboard();


	}
	
	private static void crearLiga() {
		
		String nombreLiga = "La SuperLiga";
		int edadLiga=12;
		int jornadasJugadas = 15;
		int numeroEquipos=8;
		crearLiga(nombreLiga, edadLiga, numeroEquipos, jornadasJugadas);
		
		ui.print( "\n\nLiga creada automáticamente"
				+ liga.info());

	}

	private static void crearLiga(String nombreLiga, int edadLiga, int numeroEquipos, int jornadasJugadas) {
		
		String[] frasesInicio = {
			"Calculando algorrinos",
			"Invocando al bit ancestral",
			"Generando booleanos cuánticos",
			"Creando errores para darle encanto",
			"Minando crypto con luz ajena",
			"Ensordeciendo a Siri para darle dignidad",
			"Escondiendo código usable",
			"Agotando tu paciencia por no usar Linux",
			"Te juro que es mi primera compilación precoz",
			"Haciendo café para la batería",
			"sudo ponme un 10"
		};
		
		int numero = (int) Math.floor((Math.random())*frasesInicio.length);
		
		ui.print(frasesInicio[numero], true);
		for( int i=0 ; i<5 ; i++ ) {
			try {
				ui.print(".",true);
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		equipos = crearListaEquipos(numeroEquipos, edadLiga);
		arbitros = new Arbitro[numeroEquipos/2]; 
		for (int i=0;i<arbitros.length;i++) {
			arbitros[i]= crearArbitro();
		}
		
		liga = new Liga(nombreLiga,equipos,arbitros);
		calendario = liga.getCalendario();
		generarPartidos(calendario,jornadasJugadas);
		clasificacion = new Clasificacion(equipos,calendario);
		
		//equipos[0].getJugadores()[0].cambiarEdad();
		//ui.print(equipos[0].getJugadores()[0].getCategoria());

	}

	
	/**
	 * Mostramos el ménu pricipal
	 */
	private static void menuPrincipal() {

		String[][] elements = {
				{"1","1 - Crear nueva Liga"},
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
			crearNuevaLiga();
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
		case "0":
			ui.print("\nSaliendo... ¡Hasta otra amigo!\n\n");
			System.exit(0);
		}
		
		menuPrincipal();

	}
	
	/**
	 * Mostramos el ménu de Editar Liga
	 */
	private static void menuEditarLiga() {

		String[][] elements = {
			{"1","1 - Mostrar los datos de la liga"},
			{"2","2 - Editar el nombre de la liga"},
			{"3","3 - Cambiar resultados"},
			{"",""},
			{"0","0 - Volver"},
			{"",""}
		};

		String opcion = ui.menu("EDITAR LA LIGA", elements);
		
		switch( opcion.toUpperCase() ) {
		case "1":
			ui.print(liga.info());
			ui.readKeyboard("Pulse enter para continuar");
			menuEditarLiga();
			break;
		case "2":
			liga.cambiarNombre();
			menuEditarLiga();
			break;
		case "3":
			cambiarResultados();
			menuEditarLiga();
			break;
		case "0":
		}

	}
	
	public static void cambiarResultados() {
		
		String[] cabecera = {"","Equipo local", "", "","Equipo visitante", "Árbitro"};
		String[][] tabla = calendarioToStringArray();

		for( int i=0 ; i<tabla.length ; i++ ) {
			
			//añadimos la numeración al principio
			String[] nuevaFila = new String[tabla[i].length+1];

			if( 2 > tabla[i].length ) { //Se sale del rango. Cabecera
				nuevaFila[0] = "";
			} else {
				nuevaFila[0] = Integer.toString(i+1);
			}

			//copiamos el resto una columna más adelante (la 0 es para la numeración)
			for( int j=0 ; j<tabla[i].length ; j++ ) {
				nuevaFila[j+1] = tabla[i][j];
			}
			
			tabla[i] = nuevaFila;
		}
		
		ui.tabla(cabecera, tabla);

	}


	
	private static void mostrarClasificacion() {
		
		ui.print(clasificacion.toString());
		
		ui.print("Pulse enter para continuar");
		ui.readKeyboard();
	}
	

	private static void mostrarCalendario() {
		
		String[] cabecera = {"Equipo local", "", "","Equipo visitante", "Árbitro"};
		ui.tabla(cabecera, calendarioToStringArray());
		
		ui.print("Pulse enter para continuar");
		ui.readKeyboard();
	}
	
	private static String[][] calendarioToStringArray() {
		
		String[][] retorno = {};

		Jornada[] jornadas = liga.getCalendario().getJornadas();
		for( int i=0 ; i<jornadas.length ; i++ ) {
			
			String[] arrayTempJornada = {"Jornada " + (i+1)};
			retorno = myutils.arrayAdd(retorno, arrayTempJornada);
			
			Partido[] partidos = jornadas[i].getPartidos();
			for( Partido partido:partidos ) {
			
				String[] arrayTempPartido = partido.toStringArray();
				retorno = myutils.arrayAdd(retorno, arrayTempPartido);
				
			}
		}
		
		return retorno;
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
	


}
