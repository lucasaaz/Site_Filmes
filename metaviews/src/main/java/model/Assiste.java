package model;

public class Assiste {
	private int idUsuario;
	private String nomeMidia;

	public Assiste(int idUsuario, String nomeMidia){
		setIdUsuario(idUsuario);
		setNomeMidia(nomeMidia);
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
	
	@Override
	public String toString() {
		return "Assiste [idUsuario=" + this.idUsuario + 
				", nomeMidia=" + this.nomeMidia +"]";
	}
}