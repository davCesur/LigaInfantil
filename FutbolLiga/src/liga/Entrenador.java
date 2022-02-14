/**
 * Extiende Persona con propiedades específicas de Entrenador
 *
 * @author equipo 4 DAW
 */

package liga;

public class Entrenador extends Persona{
	
	private int numeroLicencia;
	private Equipo equipo;
	
	public int getNumeroLicencia() {
		return numeroLicencia;
	}
	public void setNumeroLicencia(int numeroLicencia) {
		this.numeroLicencia = numeroLicencia;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	@Override
	public String toString() {
		return super.toString()+"\n"+
				"Numero Licencia: "+this.numeroLicencia+"\n";
	}
	
	
	
	


}
