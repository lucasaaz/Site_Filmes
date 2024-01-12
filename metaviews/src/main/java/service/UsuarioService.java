package service;

import dao.UsuarioDAO;
import model.Usuario;
import spark.Request;
import spark.Response;

public class UsuarioService {
	private UsuarioDAO userDAO = new UsuarioDAO();

	private boolean autenticar(String login, String senha) {
		return userDAO.autenticar(login, senha);
	}
	
	public boolean autenticar(Request request, Response response) {
		String senha = request.queryParams("senha");
		String nome = request.queryParams("nome");
		return autenticar(nome, senha);
	}

	public Object insert(Request request, Response response) {
		String email = request.queryParams("email");
		int idade = Integer.parseInt(request.queryParams("idade"));
		String senha = request.queryParams("senha");
		String nome = request.queryParams("nome");
		
		String resp = "";
		
		Usuario usuario = new Usuario(-1, email, idade, senha, nome);
		
		if (userDAO.insert(usuario)) {
			resp = "User (" + usuario.getNome() + ") criada!";
			response.status(201); // 201 Created
		} else {
			resp = "User (" + usuario.getNome() + ") não criada!";
			response.status(404); // 404 Not found
		}
		return resp;
	}
	
	public Object get(Request request, Response response) {
		int id = Integer.parseInt(request.params(":id"));		
		Usuario usuario = userDAO.get(id);
		String resp = "";
		if (usuario != null) {
			response.status(200); // success
        } else {
            response.status(404); // 404 Not found
            resp = "Produto " + id + " não encontrado.";    
        }
		return resp;
	}
	
	
	public Object update(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
		Usuario usuario = userDAO.get(id);
        String resp = "";       

        if (usuario != null) {
        	usuario.setEmail(request.queryParams("email"));
        	usuario.setIdade(Integer.parseInt(request.queryParams("idade")));
        	usuario.setSenha(request.queryParams("senha"));
        	usuario.setNome(request.queryParams("nome"));
    		userDAO.update(usuario);
        	response.status(200); // success
            resp = "Produto (ID " + usuario.getIdUsuario() + ") atualizado!";
        } else {
            response.status(404); // 404 Not found
            resp = "Produto (ID \" + usuario.getIdUsuario() + \") não encontrado!";
        }
        return resp;
	}
	
	
	public Object delete(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        Usuario usuario = userDAO.get(id);
        String resp = "";       

        if (usuario != null) {
            userDAO.delete(id);
            response.status(200); // success
            resp = "Produto (" + id + ") excluído!";
        } else {
            response.status(404); // 404 Not found
            resp = "Produto (" + id + ") não encontrado!";
        }
		return resp;
	}
	
}