package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Assiste;

public class AssisteDAO extends DAO {
	
	public AssisteDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	public boolean insert(Assiste assiste) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO Assiste (idUsuario, nomeMidia) "
				       + "VALUES ("+ assiste.getIdUsuario()	+ ", '" 
				       			   + assiste.getNomeMidia() 	+ "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	public List<Assiste> get(int idUsuario) {
		List<Assiste> maisTarde = new ArrayList<Assiste>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Assiste WHERE id=" + idUsuario + ";";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
			while(rs.next()){            
				Assiste u = new Assiste(rs.getInt("idUsuario"), 
						    rs.getString("nomeMidia"));
				maisTarde.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return maisTarde;
	}
	
	public List<Assiste> get() {
		return get("");
	}

	
	public List<Assiste> getOrderByIdUsuario() {
		return get("idUsuario");		
	}
	
	
	public List<Assiste> getOrderByIdMidia() {
		return get("nomeMidia");		
	}
	
	
	private List<Assiste> get(String orderBy) {	
	
		List<Assiste> maisTarde = new ArrayList<Assiste>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Assiste" + 
			((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy)) + ";";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Assiste u = new Assiste(rs.getInt("idUsuario"), 
	        						  rs.getString("nomeMidia"));
	        	maisTarde .add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return maisTarde;
	}
	
	public boolean delete(int idUsuario, String nomeMidia) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM usuario WHERE idUsuario = " + idUsuario + 
					" AND nomeMidia LIKE '" + nomeMidia + "';";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
}