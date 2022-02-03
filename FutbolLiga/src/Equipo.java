
public class Equipo {
	private String nombre;
	private String club;
	private Entrenador entrenador;
	private String equipacionCasa;
	private String equipacionFuera;
	private Jugador[] jugadores;
	
	private int edadJugadores;
	private int numeroJugadores=25;
	
	public Equipo() {
		// Recibe equipo
		this.entrenador = crearEntrenador(this);
		//recibe (int numeroJugadores, int edad, Equipo equipo);
		this.jugadores = crearJugadores(numeroJugadores, edadJugadores, this);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public Entrenador getEntrenador() {
		return entrenador;
	}
	public String getEquipacionCasa() {
		return equipacionCasa;
	}
	public void setEquipacionCasa(String equipacionCasa) {
		this.equipacionCasa = equipacionCasa;
	}
	public String getEquipacionFuera() {
		return equipacionFuera;
	}
	public void setEquipacionFuera(String equipacionFuera) {
		this.equipacionFuera = equipacionFuera;
	}
	public Jugador[] getJugadores() {
		return jugadores;
	}
	private String toStringJugadores(Jugador[] jugadores) {
		String listadoJugadores="";
		for (Jugador j: jugadores) {
			listadoJugadores+=j+"\n";
		}
		return listadoJugadores;
		
	}
	
	
	
	
	public int getEdadJugadores() {
		return edadJugadores;
	}

	public void setEdadJugadores(int edadJugadores) {
		this.edadJugadores = edadJugadores;
	}

	public int getNumeroJugadores() {
		return numeroJugadores;
	}

	public void setNumeroJugadores(int numeroJugadores) {
		this.numeroJugadores = numeroJugadores;
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



	
	@Override
	public String toString() {
		return "Nombre del Equipo: "+this.nombre+"\n"+
				"Club: "+this.club+"\n"+
				"Entrenador"+"\n"+
				entrenador+"\n"+
				"Plantilla: "+"\n"+
				toStringJugadores(this.jugadores);
		
	}


}

