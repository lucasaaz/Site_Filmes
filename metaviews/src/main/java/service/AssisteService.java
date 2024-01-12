package service;

import java.util.List;

import dao.AssisteDAO;
import model.Assiste;
import spark.Request;
import spark.Response;

public class AssisteService {
	private AssisteDAO watchDAO = new AssisteDAO();

	public Object insert(Request request, Response response) {
		int idUsuario = Integer.parseInt(request.queryParams("idUsuario"));
		String nomeMidia = request.queryParams("nomeMidia");
		
		String resp = "";
		
		Assiste assiste = new Assiste(idUsuario, nomeMidia);
		
		if (watchDAO.insert(assiste)) {
			resp = "User (" + assiste.getIdUsuario() + ") criada!";
			response.status(201); // 201 Created
		} else {
			resp = "User (" + assiste.getIdUsuario() + ") não criada!";
			response.status(404); // 404 Not found
		}
		return resp;
	}
	
	public Object get(Request request, Response response) {
		int id = Integer.parseInt(request.params(":id"));		
		List<Assiste> assiste = watchDAO.get(id);
		String resp = "";
		if (assiste != null) {
			response.status(200); // success
        } else {
            response.status(404); // 404 Not found
            resp = "Produto " + id + " não encontrado.";    
        }
		return resp;
	}
	
	public Object delete(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        String nomeMidia= request.params(":nomeMidia");
        List<Assiste> assiste = watchDAO.get(id);
        String resp = "";       

        if (assiste != null) {
            watchDAO.delete(id, nomeMidia);
            response.status(200); // success
            resp = "Produto (" + id + ") excluído!";
        } else {
            response.status(404); // 404 Not found
            resp = "Produto (" + id + ") não encontrado!";
        }
		return resp;
	}
	
}