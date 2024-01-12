package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO extends DAO {
	
	public UsuarioDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	public boolean insert(Usuario usuario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO Usuario (email, idade, senha, nome) "
				       + "VALUES ("+usuario.getEmail()+ ", " + usuario.getIdade() + ", '"  
				       + DAO.toMD5(usuario.getSenha()) + "', '" + usuario.getNome() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		} catch (Exception u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Usuario get(int idUsuario) {
		Usuario usuario = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Usuario WHERE id=" + idUsuario + ";";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 usuario = new Usuario(rs.getInt("idUsuario"), rs.getString("email"), 
	        			 rs.getInt("idade"), rs.getString("senha"), 
	        			 rs.getString("nome"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuario;
	}
	
	
	public List<Usuario> get() {
		return get("");
	}

	
	public List<Usuario> getOrderById() {
		return get("idUsuario");		
	}
	
	
	public List<Usuario> getOrderByNome() {
		return get("nome");		
	}
	
	
	public List<Usuario> getOrderByIdade() {
		return get("idade");		
	}
	
	
	private List<Usuario> get(String orderBy) {	
	
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Usuario" + 
			((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy)) + ";";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Usuario u = new Usuario(rs.getInt("idUsuario"), rs.getString("email"), 
	        			 rs.getInt("idade"), rs.getString("senha"), 
	        			 rs.getString("nome"));
	            usuarios.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} 
		return usuarios;
	}

	
	public boolean update(Usuario usuario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE Usuario SET email = '" + usuario.getEmail() + 
					"', idade = " + usuario.getIdade() + 
					", senha = '" + DAO.toMD5(usuario.getSenha()) +
					"', nome = '" + usuario.getNome() +
					    "' WHERE codigo = " + usuario.getIdUsuario() + ";";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean delete(int idUsuario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM Usuario WHERE idUsuario = " + idUsuario + ";";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean autenticar(String nome, String senha) {
		boolean resp = false;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Usuario WHERE nome LIKE '" + 
					nome + "' AND senha LIKE '" + DAO.toMD5(senha) + "';";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			resp = rs.next();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resp;
	}	
}