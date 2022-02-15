
package liga;


public class Principal {

	public static void main(String[] args) {
		final int NUMEROEQUIPOS = 20;
		final int EDAD=12;
		final String NOMBRELIGA="La SuperLiga";
		final int JORNADASJUGADAS = 15;
		
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

}
