
package liga;

import utils.ui;

public class Jugador extends Persona{
	
	private int dorsal;
	private String posicion;
	private String categoria;
	private Equipo equipo;
	
	
	private String[][] categorias = {
		{"Chupetí­n","4","5"},
		{"Prebenjamín","6","7"},
		{"Benjamín","8","9"},
		{"Alevín","10","11"},
		{"Infantil","12","13"},
		{"Cadete","14","15"},
		{"Juvenil","16","19"}
	};
	
	public void cambiarEdad() {

		int edad = this.getEdad();
		int nuevaEdad=0;
		
		while( !(nuevaEdad >= 8 && nuevaEdad <= 65) ) {
			nuevaEdad = ui.readKeyboardInt("Edad actual: "+edad+" años\n"
					+"Introduzca la nueva edad del jugador (entre 8 y 65): ");
		}
		
		this.setEdad(nuevaEdad);
	}

	
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
	public String[][] getCategorias() {
		return categorias;
	}
	
	private String setCategoria(int edad) {
		
		String categoria = "";
		
		for( int i=0 ; i < categorias.length ; i++ ) {
			int rinicial=0;
			int rfinal=0;
			try {
				rinicial = Integer.valueOf(categorias[i][1]);
				rfinal = Integer.valueOf(categorias[i][2]);
			}
			catch (NumberFormatException ex) {
				ui.print("Ocurrió un error en jugador.setCategoria try");
				System.exit(1);
			}
			
			if( edad >= rinicial && edad <= rfinal ) {
				categoria = categorias[i][0];
				break;
			}
		}
		
		return categoria;
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
				"PosiciÃ³n: "+posicion+", Dorsal: "+dorsal+"\n";
	}
	
}
