package model;

public class Usuario {
	private int idUsuario;
	private int idade;	
	private String email;
	private String senha;
	private String nome;
	
	public Usuario(int idUsuario, String email, int idade, String senha, String nome){
		setIdUsuario(idUsuario);
		setIdade(idade);
		setEmail(email);
		setSenha(senha);
		setNome(nome);
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int id) {
		this.idUsuario = id;
	}
	public int getIdade() {
		return this.idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + this.idUsuario + 
				", email=" + this.email + 
				", idade=" + this.idade + 
				", senha=" + this.senha + 
				", nome="+ this.nome +"]";
	}
}