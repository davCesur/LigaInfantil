
package liga;

import java.util.Arrays;

public class Calendario {
	private Jornada[] jornadas;

	public Calendario(Equipo[] equipos, Arbitro[] arbitros) {
		int numeroEquipos = equipos.length;
		int numeroJornadas = (numeroEquipos-1)*2;
		int numeroPartidos = numeroEquipos/2;
		
		jornadas= new Jornada[numeroJornadas];
		Equipo[][] emparejamientos = new Equipo[2][numeroPartidos];
		//Mitad izquierda del array doble
		for (int i=0;i<numeroPartidos;i++) {
			emparejamientos[0][i]=equipos[i];
		}
		//Mitad derecha del array doble
		for (int j=numeroPartidos-1;j>=0;j--) {
			emparejamientos[1][j]=equipos[numeroEquipos-1-j];
		}
		
		for (int i=0; i<numeroJornadas/2; i++) {
			
			Partido[] partidosIda = new Partido[numeroPartidos];
			Partido[] partidosVuelta =  new Partido[numeroPartidos];
			
			for (int j=0; j<numeroPartidos;j++) {
				//Partidos de ida
				partidosIda[j] = new Partido();
				partidosIda[j].setLocal(emparejamientos[0][j]);
				partidosIda[j].setVisitante(emparejamientos[1][j]);
				partidosIda[j].setArbitro(arbitros[j]);
				//Partidos de vuelta
				partidosVuelta[j] = new Partido();
				partidosVuelta[j].setLocal(emparejamientos[1][j]);
				partidosVuelta[j].setVisitante(emparejamientos[0][j]);
				partidosVuelta[j].setArbitro(arbitros[j]);
				
			}
			//Actualizamos jornadas
			jornadas[i] =  new Jornada();
			jornadas[i].setPartidos(partidosIda);
			jornadas[numeroJornadas-1-i] =  new Jornada();
			jornadas[numeroJornadas-1-i].setPartidos(partidosVuelta);
			
			//Rotamos el array doble
			Equipo[][] auxEmp = new Equipo[2][numeroPartidos];
			//Actualizamos columna izquierda
			for (int k=0;k<numeroPartidos;k++) {
				if (k==0) {
					auxEmp[0][k]=emparejamientos[0][k];
				}else if(k>0 && k<numeroPartidos-1) {
					auxEmp[0][k+1]=emparejamientos[0][k];
				}else {
					auxEmp[1][k]=emparejamientos[0][k];
				}
			}
			//Columna Derecha
			for (int k=0;k<numeroPartidos;k++) {
				if (k>0 && k<numeroPartidos) {
					auxEmp[1][k-1]=emparejamientos[1][k];
				}else {
					auxEmp[0][1]=emparejamientos[1][k];
				}
			}
			emparejamientos=auxEmp;
		}
	}

	public Jornada[] getJornadas() {
		return jornadas;
	}

	public void setJornadas(Jornada[] jornadas) {
		this.jornadas = jornadas;
	}

	@Override
	public String toString() {
		String cadena = "Calendario de Liga: \n";
		for (int i=0;i<this.jornadas.length;i++)
		{
			cadena+=(i+1)+"ª "+this.jornadas[i]+"\n";
		}
		
		return cadena;
	}
	
}
