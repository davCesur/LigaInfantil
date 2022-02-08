public class Clasificacion {
 
	/**
	 * Contructor de Clasificacion
	 */
	public Clasificacion() {
	 
 }
	/**
	 *  Variables de la Clasificacion
	 */
	private Equipo equipo;   // Nombre de los equipos
	private int victorias;   // Numero de victorias
	private int derrotas;    // Numero de derrotas
	private int golesfavor;  // Numero de goles a favor
	private int golescontra; // Numero de goles en contra
	private int puntos;      // Numero de puntos
	Partido partido = new Partido();
	
	public int getVictorias() {
		
		
		return victorias;
	}
	
	
	public void setVictorias(int victorias) {
		
		
		this.victorias = victorias;
	}
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	public int getGolesfavor() {
		return golesfavor;
	}
	public void setGolesfavor(int golesfavor) {
		this.golesfavor = golesfavor;
	}
	public int getGolescontra() {
		return golescontra;
	}
	public void setGolescontra(int golescontra) {
		this.golescontra = golescontra;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
}