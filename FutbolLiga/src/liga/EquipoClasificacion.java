
package liga;

/**
 * @author miguel
 *
 */
public class EquipoClasificacion {
	
	private Equipo equipo;
	private int jugados=0;
	private int ganados=0;
	private int perdidos=0;
	private int empatados=0;
	private int gFavor=0;
	private int gContra=0;
	private int dGoles=0;
	private int puntos=0;
	
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public int getJugados() {
		return jugados;
	}
	public void setJugados(int jugados) {
		this.jugados = jugados;
	}
	public int getGanados() {
		return ganados;
	}
	public void setGanados(int ganados) {
		this.ganados = ganados;
	}
	public int getPerdidos() {
		return perdidos;
	}
	public void setPerdidos(int perdidos) {
		this.perdidos = perdidos;
	}
	public int getgFavor() {
		return gFavor;
	}
	public void setgFavor(int gFavor) {
		this.gFavor = gFavor;
	}
	public int getgContra() {
		return gContra;
	}
	public void setgContra(int gContra) {
		this.gContra = gContra;
	}
	public int getdGoles() {
		return dGoles;
	}
	public void setdGoles(int dGoles) {
		this.dGoles = dGoles;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public void addGolesFavor(int valor) {
		this.gFavor+=valor;
		this.dGoles+=valor;
	}
	
	public void addGolesContra(int valor) {
		this.gContra+=valor;
		this.dGoles-=valor;
	}
	
	public void addVictoria() {
		this.jugados++;
		this.ganados++;
		this.puntos+=3;
	}
	
	public void addEmpate() {
		this.jugados++;
		this.empatados++;
		this.puntos++;
	}
	
	public void addDerrota() {
		this.jugados++;
		this.perdidos++;
	}
	
	@Override
	public String toString() {
		String cadena= equipo.getNombre();
		int longitud = cadena.length();
		int tabuladores = 6;
		int tabEquipo = longitud/8;
		for (int i=0; i<tabuladores-tabEquipo;i++) {
			cadena+="\t";
		}
		cadena+=jugados+"\t"+ganados+"\t"+perdidos+"\t"+
				empatados+"\t"+gFavor+"\t"+gContra+"\t"+dGoles+"\t"+puntos+"\n";
		return cadena;
	}

//	public String[][] toStringArray() {
//		String[][] cadena= equipo.getNombre();
//		int longitud = cadena.length();
//		int tabuladores = 6;
//		int tabEquipo = longitud/8;
//		for (int i=0; i<tabuladores-tabEquipo;i++) {
//			cadena+="\t";
//		}
//		cadena+=jugados+"\t"+ganados+"\t"+perdidos+"\t"+
//				empatados+"\t"+gFavor+"\t"+gContra+"\t"+dGoles+"\t"+puntos+"\n";
//		return cadena;
//	}

}
