/**
 * 
 * @author equipo 4 DAW
 *
 */

package liga;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Liga liga = new Liga();
		liga.setNombre("Liga Equipo 4");
		
		//### Crear una Lista de Equipos
		int numeroEquipos = (int) (Math.floor(Math.random()*3)+4)*2;
		int edad = (int) Math.floor(Math.random()*8)+8; // (de 8 a 15 años)
		liga.setEquipos( crearEquipos(numeroEquipos, edad) );
		
		//# Creamos los árbitros
		liga.setArbitros( crearArbitros() );
	}
	
	private static Equipo[] crearEquipos(int numeroEquipos, int edad) {
		
		
/**
 * En cada equipo:
 * Hay que añadir los jugadores
 * crearJugadores(numeroJugadores, edadJugadores, this);
 * Hay que añadir el entrenador
 * 		
 */
		
		if( numeroEquipos%2!=0 ) {
			//El número de equipos es impar
			ui.print("Error: El número de equipos a generar es impar");
			System.exit(1);
		}
		
		String [] nombreBarrios = {"El Candado", "Huelin", "Tiro Pichón", "Rincón de la Victoria", "La Rosaleda", "Torremolinos",
				"Velez Málaga","Cerrado de Calderon", "El Puerto de la Torre", "Bresca", "Mezquitilla", "Teatinos", "Motril",
				"Centro","Santa Paula", "El Palo", "Los Corazones", "Las Delicias", "Recogidas","Nueva Málaga", "Casas Blancas",
				"La Palmilla","Los Asperones","Campanillas","La Corta"};
		String [] mascotas = {"Los Pollos", "Los Araclanes", "Los Limones", "Los Delfines", "Los Chanquetes", "Los Gatitos",
								"Los Boquerones", "Los Toros", "Los Perritos", "Los Halcones", "Los Ornitorrincos", "Los Caracoles",
								"Los Palomos Cojos", "Los Heterosaurios", "Las Tortugas Ninjas", "Los Pintarrojas"};

		Equipo [] listaEquipos= new Equipo[numeroEquipos];
		
		for (int i=0; i<numeroEquipos; i++) {
			
			//Creamos Equipo
			Equipo equipo = new Equipo();
			
			equipo.setEdadJugadores(edad);
			
			//### Generamos el nombre y club
			// Elegimos random un nombre y una mascota de las listas respectivas.
			int numero = (int) Math.floor(Math.random()*nombreBarrios.length);
			String barrio= nombreBarrios[numero];
			numero = (int) Math.floor(Math.random()*mascotas.length);
			String mascota= mascotas[numero];

			// Definimos el club en base al nombre del barrio
			equipo.setClub(barrio+" F.C.");
			
			// Unimos con un "de" en medio
			String nombre;
			if (barrio.startsWith("El ")) {
				barrio=barrio.substring(3);
				nombre = mascota + " del "+ barrio;
			}else {
				nombre = mascota + " de "+ barrio;
			}
			
			equipo.setNombre(nombre);
			
			//Metemos el equipo en el array de equipos
			listaEquipos[i]=equipo;
			
			//Creamos al entrenador
			Equipo entrenador = new Equipo();
			entrenador.setEntrenador(crearEntrenador(entrenador));
		}
		return listaEquipos;
	}

	private static Arbitro[] crearArbitros() {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqué","Bale (lesionado)",
				"Amunike","N'kono","Butragueño","Sanchís","Neymar","Batistuta","Maradona",
				"Pelé","Beckenbauer"};
		
		Arbitro[] arbitros = new Arbitro[3];
		
		for( int i=0 ; i<arbitros.length ; i++ ) {
			
			Arbitro arbitro = new Arbitro();
			
			//Nombre
			int numero = (int) Math.floor(Math.random()*nombres.length);
			String nombre = nombres[numero];
			arbitro.setNombre(nombre);

			//Apellidos
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido1 = apellidos[numero];
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido2 = apellidos[numero];
			arbitro.setApellidos(apellido1+" "+apellido2);
			
			//Edad
			int edad = (int) Math.floor(Math.random()*47)+18;
			arbitro.setEdad(edad);
			//Licencia
			int licencia = (int) Math.floor(Math.random()*100000);
			arbitro.setLicencia(licencia);
			
			arbitros[i] = arbitro;
		}
		return arbitros;
	}

	
	/**
	 * Creador de entrenador
	 */
	private static Entrenador crearEntrenador(Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqué","Bale (lesionado)",
				"Amunike","N'kono","Butragueño","Sanchís","Neymar","Batistuta","Maradona",
				"Pelé","Beckenbauer"};
		
		Entrenador entrenador = new Entrenador();
		
		//Nombre
		int numero = (int) Math.floor(Math.random()*nombres.length);
		String nombre = nombres[numero];
		entrenador.setNombre(nombre);

		//Apellidos
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido1 = apellidos[numero];
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido2 = apellidos[numero];
		entrenador.setApellidos(apellido1+" "+apellido2);
		
		//Equipo
		entrenador.setEquipo(equipo);
		
		//Edad
		int edad = (int) Math.floor(Math.random()*47)+18;
		entrenador.setEdad(edad);
		//Licencia
		int licencia = (int) Math.floor(Math.random()*100000);
		entrenador.setNumeroLicencia(licencia);
		
		return entrenador;
	}
	
	/**
	 * Creador de jugadores
	 */
	private static Jugador[] crearJugadores(int numeroJugadores, int edad, Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqué","Bale (lesionado)",
				"Amunike","N'kono","Butragueño","Sanchís","Neymar","Batistuta","Maradona",
				"Pelé","Beckenbauer"};
		String[] posiciones = {"Portero/a","Defensa","Centrocampista","Delantero/a"};
		
		//Estructura de Array de Jugadores
		Jugador[] jugadores = new Jugador[numeroJugadores];
		
		for (int i=0; i<numeroJugadores; i++) {
			//Crear un Jugador
			Jugador jug = new Jugador();
			//Nombre
			int numero = (int) Math.floor(Math.random()*nombres.length);
			String nombre = nombres[numero];
			jug.setNombre(nombre);

			//Apellidos
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido1 = apellidos[numero];
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido2 = apellidos[numero];
			jug.setApellidos(apellido1+" "+apellido2);

			//Posición
			numero = (int) Math.floor(Math.random()*posiciones.length);
			String posicion = posiciones[numero];
			jug.setPosicion(posicion);

			//Edad
			jug.setEdad(edad);

			//Dorsal
			jug.setDorsal(i+1);
			
			//Equipo
			jug.setEquipo(equipo);

			jugadores[i]=jug;

		}
		
		return jugadores;
	}
}
