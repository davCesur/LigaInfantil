
package liga;


public class Principal {

	public static void main(String[] args) {
		final int NUMEROEQUIPOS = 20;
		final int EDAD=12;
		final String NOMBRELIGA="La SuperLiga";
		final int JORNADASJUGADAS = 15;
		
		menu();
		System.exit(0);
		
		
		Equipo[] misEquipos = crearListaEquipos(NUMEROEQUIPOS, EDAD);
		Arbitro[] arbitros = new Arbitro[NUMEROEQUIPOS/2]; 
		for (int i=0;i<arbitros.length;i++) {
			arbitros[i]= crearArbitro();
		}
		
		Liga miLiga = new Liga(NOMBRELIGA,misEquipos,arbitros);
		System.out.println(miLiga.getCalendario());
		Calendario miCalendario=miLiga.getCalendario();
		generarPartidos(miCalendario,JORNADASJUGADAS);
		
		
		Clasificacion clasificacion = new Clasificacion(misEquipos,miCalendario);
		System.out.println(clasificacion);
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
			System.out.println("Jornada: "+(i+1));
			Partido[] partidos = jornadas[i].getPartidos();
			for (Partido par: partidos) {
				int golesLocales = (int)Math.floor((Math.random())*MAXGOLES);
				int golesVisitantes = (int)Math.floor((Math.random())*MAXGOLES);
				par.setgLocal(golesLocales);
				par.setgVisitante(golesVisitantes);
				System.out.println(par);
			}
			jornadas[i].terminar();
		}
		
	}
	
	/**
	 * Show menu and wait for a valid option
	 *  Get: Array whit elements in format {
	 *   {"option1", "title", "function to execute"},
	 *   {"option2", "title", "function to execute"} }
	 *  Return: valid option of array parsed
	 */
	private static void menu() {

		String[][] elements = {
				{"1","1  - Operaciones matemáticas"},
				{"2","2  - Serie de Fibonacci"},
				{"9","9  - Pasar vocales a mayúsculas\n"
				+"       y consonantes a minúsculas"},
				{"11","11 - Extractor de vocales"},
				{"",""},
				{"","Cambiar velocidad de animaciones:"},
				{"N","    N - Normal"},
				{"D","    D - Desactivado (Disabled)"},
				{"",""},
				{"0","0 - Salir"},
				{"",""}
		};

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

		switch( option.toUpperCase() ) {
		case "1":
		case "N":
			printMenuCabecera("Operaciones matemáticas");
			// aquí el método. ej: operacionesMatematicas();
			break;
		case "0":
			ui.print("\nSaliendo... ¡Hasta otra amigo!\n\n");
			System.exit(0);
		}

		//System.out.println("despues de switch");
		//MyUtils.readKeyboard();

		menu();

	}
	/**
	 * Imprime por salida estándar el menú principal
	 */
	private static void printMenu(String[][] elements) {
		printMenuCabecera("GENERADOR DE LIGAS");
		ui.print("          Seleccione una opción\n");
		ui.print("\n");

		//Print elements
		for( String[] element:elements ) {
			ui.print("  "+element[1]+"\n");
		}
	}
	/**
	 * Imprime la cabecera para cada sección
	 */
	private static void printMenuCabecera(String texto) {
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




}
