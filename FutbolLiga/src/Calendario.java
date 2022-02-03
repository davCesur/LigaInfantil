import java.util.concurrent.ThreadLocalRandom;

public class Calendario extends Liga { 
	private String equipoUno ="";
	private String equipoDos="";
	private String Dia="";
	
	/*
	 * jornada[x][y]
	 * x => número de jornada
	 * y => enfrentamientos (Nºequipos/2)
	 */
	private String[][] jornada;
	
	public String getEquipoUno() {
		return equipoUno;
	}
	public void setEquipoUno(String equipoUno) {
		this.equipoUno = equipoUno;
	}
	public String getEquipoDos() {
		return equipoDos;
	}
	public void setEquipoDos(String equipoDos) {
		this.equipoDos = equipoDos;
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
	 * Lo guarda en String jornada[][];
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
		
	//		String [][] enfrentamientos = new String [numero];
//   		String []DiaSemana = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
//   		
//   		String []DiaAleatorio = new String [numeroEquipos/2];
//   		Calendario calendario = new Calendario();
//		
//		//Elegimos un número random al que se asigna a un número de día.
//		for (int i=0;i<numeroEquipos/2;i++) {
//			int numero = (int) Math.floor(Math.random()*DiaSemana.length);
//			String Dia = DiaSemana[numero];
//			calendario.setDia(Dia);
//			DiaAleatorio[i] = calendario.getDia();
//		}
//   
//   	   	return DiaAleatorio;
	//	return enfrentamiento;
//   	}
	
//	public static String[][] generarEnfrentamientos (String [] DiaAleatorio, int numeroEquipos) {
//		String [][] enfrentamiento = new String [numeroEquipos][2];
//		String[] team = new String [2];
//		Equipo equipo = new Equipo ();
//		for (int i=0;i<DiaAleatorio.length;i++) {
//			for (int j=0;j<2;j++) {
//				team [j]= equipo.getNombre();
//				enfrentamiento [i][j] = DiaAleatorio[i]+team[j];
//				System.out.println(enfrentamiento[i][j]);
//			}
//		}
		
//		return enfrentamiento;
//	}
	
	
//	
//	 
//	 private int[] equipos;
//   	 private String[][] matriz1,matriz2,jornadas,jornadas2;
//   	 
//   	 
//   	 
//   	
//
//   	
//
//	//Num de jornadas = (N-1)*2, con N = num equipos. (N-1) es una vuelta.
//	
//	/**
//	 * @param N -> numero de equipos
//	 */
//	public Calendario(int N){
//
//		
//		//Relleno las matrices
//		/*   Matriz 1    	 Matriz 2			 
//			1   2   3		6   5   4
//			4   5   1		6   3   2
//			2   3   4		6   1   5
//			5   1   2		6   4   3
//			3   4   5		6   2   1
//			
//			Resultado:
//			
//			J1	6vs1	2vs5	3vs4
//			J2	4vs6	5vs3	1vs2
//			J3	6vs2	3vs1	4vs5
//			J4	5vs6	1vs4	2vs3
//			J5	6vs3	4vs2	5vs1
//		 */
//		
//		int cont = 0;
//		int cont2 = N-2;
//		
//		for(int i=0;i<N-1;i++){
//			for(int j=0;j<N/2;j++){
//				//matriz1
//				matriz1[i][j] = String.valueOf(equipos[cont]);
//				cont++;
//				if(cont==(N-1)) cont=0;
//				
//				//matriz2
//				if(j==0) matriz2[i][j] = String.valueOf(N);
//				else {
//					matriz2[i][j] = String.valueOf(equipos[cont2]);
//					cont2--;
//					if(cont2==-1) cont2 = N-2;
//				}
//				
//				//Elaboro la matriz final de enfrentamientos por jornada (primera vuelta)
//				if(j==0){
//					if(i%2==0)jornadas[i][j] = matriz2[i][j] + "-" + matriz1[i][j] + " Se jugara: " + DiaAleatorio +"|";
//					else jornadas[i][j] = matriz1[i][j] + "-" + matriz2[i][j] + " Se jugara: " + DiaAleatorio +"|";
//				}
//				else jornadas[i][j] = matriz1[i][j] + "-" + matriz2[i][j] + " Se jugara: " + DiaAleatorio +"|";
//				
//				
//				//segunda vuelta - al reves que la primera
//				if(j==0){
//					if(i%2==0) jornadas2[i][j] = matriz1[i][j] + "-" + matriz2[i][j] + " ";
//					else jornadas2[i][j] = matriz2[i][j] + "-" + matriz1[i][j] + " ";
//				}
//				else jornadas2[i][j] = matriz2[i][j] + "-" + matriz1[i][j] + " ";
//				
//			}
//		}
//		
//		//Solo para mostrarlo por consola
//
//		int jorn = 1;
//		for(int i=0;i<N-1;i++){
//			for(int j=0;j<N/2;j++){
//				System.out.print("J"+jorn+" "+jornadas[i][j]); 
//				if(j==(N/2)-1) System.out.println();
//			}
//			jorn++;
//		}
//		
//		System.out.println();
//		jorn = N;
//		for(int i=0;i<N-1;i++){
//			for(int j=0;j<N/2;j++){
//				System.out.print("J"+jorn+" "+jornadas2[i][j]);
//				if(j==(N/2)-1) System.out.println();
//			}
//			jorn++;
//		}
//		
//	}
//	
//	/**
//	 * @param args
//	 */
//
//	public static int numeroAleatorioEnRango(int minimo, int maximo) {
//        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
//        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
//    }
	
}
