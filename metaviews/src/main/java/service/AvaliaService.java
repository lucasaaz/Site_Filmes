package service;

import java.util.List;

import dao.AvaliaDAO;
import model.Avalia;
import spark.Request;
import spark.Response;

public class AvaliaService {
	private AvaliaDAO apraiseDAO = new AvaliaDAO();

	public Object insert(Request request, Response response) {
		int idUsuario = Integer.parseInt(request.queryParams("idUsuario"));
		String nomeMidia = request.queryParams("nomeMidia");
		float nota = Float.parseFloat(request.queryParams("nomeMidia"));
		
		String resp = "";
		
		Avalia avalia = new Avalia(idUsuario, nomeMidia, nota);
		
		if (apraiseDAO.insert(avalia)) {
			resp = "User (" + avalia.getIdUsuario() + ") criada!";
			response.status(201); // 201 Created
		} else {
			resp = "User (" + avalia.getIdUsuario() + ") não criada!";
			response.status(404); // 404 Not found
		}
		return resp;
	}
	
	public Object get(Request request, Response response) {
		int id = Integer.parseInt(request.params(":id"));		
		List<Avalia> avalia = apraiseDAO.get(id);
		String resp = "";
		if (avalia != null) {
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
        List<Avalia> avalia = apraiseDAO.get(id);
        String resp = "";       

        if (avalia != null) {
            apraiseDAO.delete(id, nomeMidia);
            response.status(200); // success
            resp = "Produto (" + id + ") excluído!";
        } else {
            response.status(404); // 404 Not found
            resp = "Produto (" + id + ") não encontrado!";
        }
		return resp;
	}
	
}