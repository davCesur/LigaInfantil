
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
	
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
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
	
	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
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

	
	
	private String toStringJugadores(Jugador[] jugadores) {
		String listadoJugadores="";
		for (Jugador j: jugadores) {
			listadoJugadores+=j+"\n";
		}
		return listadoJugadores;
		
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

