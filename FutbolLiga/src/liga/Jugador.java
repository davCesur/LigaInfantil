
package liga;

public class Jugador extends Persona{
	private int dorsal;
	private String posicion;
	private String categoria;
	private Equipo equipo;
	
	@Override
	public void setEdad(int edad){
		super.setEdad(edad);
		this.categoria=setCategoria(edad);
	}

	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getCategoria() {
		return categoria;
	}
	private String setCategoria(int edad) {
		switch (edad) {
		case 4:
		case 5:
			return "Chupetín";
		case 6:
		case 7:
			return "Prebenjamin";
		case 8:
		case 9:
			return "Benjamin";
		case 10:
		case 11:
			return "Alevín";
		case 12:
		case 13:
			return "Infantil";
		case 14:
		case 15:
			return "Cadete";
		case 16:
		case 17:
		case 18:
		case 19:
			return "Juvenil";
		default:
			return "N/A";
		
		}
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	@Override
	public String toString() {
		return super.toString()+//Imprimimos el toString de Persona
				"Categoria: "+categoria+"\n"+				
				"Equipo: "+equipo.getNombre()+"\n"+
				"Posición: "+posicion+", Dorsal: "+dorsal+"\n";
	}
	
}
