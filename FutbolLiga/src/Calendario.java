import java.util.concurrent.ThreadLocalRandom;

public class Calendario extends Liga {
	private String Dia="";
	
	/*
	 * jornadas[x][y] (Nºequipos/2)
	 * x => equipo local
	 * y => equipo visitante 
	 */
	private int[][] jornadas;
	
	public Calendario() {
		
		//Creamos las jornadas
		
		
	}
	
	
	public int[][] getJornadas() {
		return jornadas;
	}
	public void setJornadas() {
				
		Equipo[] equipos = super.getEquipos();
		int numeroPartidos = equipos.length/2;
		int numeroJornadas = equipos.length-1;
		Equipo[][] enfrentamientos= new Equipo[2][numeroPartidos];
		Jornada[] jornadas = new Jornada[numeroJornadas];



		/*
		 * Ejemplo para 8 equipos para 1 jornada 
		 * Para las siguiente jornada, giramos los enfrentamientos en sentido contrario a las agujas del reloj
		 *  jornada[0] => equipos[0][0] vs equipos[1][7]
		 *  jornada[1] => equipos[0][1] vs equipos[1][6]
		 *  jornada[2] => equipos[0][2] vs equipos[1][5]
		 *  jornada[3] => equipos[0][3] vs equipos[1][4]
		 */
		
		//mitad izquierda
		for (int i=0;i<equipos.length/2;i++ ) {
		    enfrentamientos[0][i]=equipos[i];
		}
		//mitad derecha
		for (int j=equipos.length/2-1;j>=0;j--) {
		    enfrentamientos[1][j]=equipos[equipos.length-1-j];
		}
		
		//Generamos las jornadas
		for (int i=0; i<jornadas.length/2;i++) {

		    //Generamos dos arrays de partidos (ida y vuelta)
		    Partido[] partidosIda = new Partido[enfrentamientos.length];
		    Partido[] partidosVuelta = new Partido[enfrentamientos.length];

		 
		    //Recorremos los enfrentamiientos y los rellenamos (con ida y vuelta)
		    for (int j=0; j<enfrentamientos[0].length;j++) {
		        partidosIda[i].setLocal(enfrentamientos[0][j]);
		        partidosIda[i].setVisitante(enfrentamientos[1][j]);
		        
		        partidosVuelta[i].setLocal(enfrentamientos[1][j]);
		        partidosVuelta[i].setVisitante(enfrentamientos[0][j]);
		    }
		    //Asignamos los partidos a la de ida
		    jornadas[i].setPartidos(partidosIda);
		    //Asignamos los partidos a la de vuelta
		    jornadas[i+jornadas.length-1].setPartidos(partidosVuelta);
		}
				

				
				
				
	}
	
	public String getDia() {
		return Dia;
	}
	public void setDia(String Dia) {
		this.Dia = Dia;
	}
	
	
	
	/**
	 * Generador de jornadas
	 * Recibe un número de equipos
	 * Lo guarda en String jornada[][]
	 */
	public static String[][] generarJornada(int numeroEquipos) {
		String[][] enfrentamientos = new String [numeroEquipos/2][2];
		
		Equipo e = new Equipo();
		for (int i=0;i<numeroEquipos/2;i++) { 
			for (int j=0;j<2;j++) {
				enfrentamientos [i][j] = e.getClub();
				System.out.println(enfrentamientos[i][j]);
			}
		}
		return enfrentamientos;
	}
		

	
}
