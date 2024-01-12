package model;

public class Avalia {
	private int idUsuario;
	private String nomeMidia;
	private float nota;

	
	public Avalia(int idUsuario, String nomeMidia, float nota){
		setIdUsuario(idUsuario);
		setNomeMidia(nomeMidia);
		setNota(nota);
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeMidia() {
		return this.nomeMidia;
	}
	public void setNomeMidia(String nomeMidia) {
		this.nomeMidia = nomeMidia;
	}
	public float getNota() {
		return this.nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return "Avalia [idUsuario=" + this.idUsuario + 
				", nomeMidia=" + this.nomeMidia + 
				", nota=" + this.nota +"]";
	}
}