import java.util.concurrent.ThreadLocalRandom;

public class Calendario extends Liga { 
	private String equipoUno ="";
	private String equipoDos="";
	private String Dia="";
	
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
	
	public static String[][] generarJornada(int numeroEquipos) {
		String [][] enfrentamientos = new String [numeroEquipos/2][2];
		
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
