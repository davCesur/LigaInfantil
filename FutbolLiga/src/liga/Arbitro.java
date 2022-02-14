/**
 * Extiende Persona con propiedades espec�ficas de �rbitro
 *
 * @author equipo 4 DAW
 */

package liga;

public class Arbitro extends Persona {
	int licencia;

	public int getLicencia() {
		return licencia;
	}

	public void setLicencia(int licencia) {
		this.licencia = licencia;
	}

	@Override
	public String toString() {
		return "Arbitro [licencia=" + licencia + ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos()
				+ ", getEdad()=" + getEdad() + "]";
	}
}
