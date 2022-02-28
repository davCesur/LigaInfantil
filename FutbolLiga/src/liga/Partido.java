
package liga;

public class Partido {
	private Equipo local;
	private Equipo visitante;
	private Integer gLocal;
	private Integer gVisitante;
	private Arbitro arbitro;
	
	public Equipo getLocal() {
		return local;
	}
	public void setLocal(Equipo local) {
		this.local = local;
	}
	public Equipo getVisitante() {
		return visitante;
	}
	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}
	public int getgLocal() {
		return gLocal;
	}
	public void setgLocal(int gLocal) {
		this.gLocal = gLocal;
	}
	public int getgVisitante() {
		return gVisitante;
	}
	public void setgVisitante(int gVisitante) {
		this.gVisitante = gVisitante;
	}
	public Arbitro getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	
	public String[] toStringArray() {
		String golesLocal="-";
		if( this.gLocal != null ) {
			golesLocal=this.gLocal.toString();
		}
		String golesVisitante="-";
		if( this.gVisitante != null ) {
			golesVisitante=this.gVisitante.toString();
		}
		//String  = this.gVisitante.toString();
		
		String[] retorno = {
				this.local.getNombre(),
				golesLocal,
				golesVisitante,
				this.visitante.getNombre(),
				this.arbitro.getApellidos()};
		return retorno;
	}

	@Override
	public String toString() {
		return this.local.getNombre()+" "+this.gLocal+":"
				+this.gVisitante+" "+this.visitante.getNombre()
				+", Arbitro: "+this.arbitro.getApellidos()+"\n";
	}

}
