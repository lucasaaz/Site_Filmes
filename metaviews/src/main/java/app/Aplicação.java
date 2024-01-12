package app;

import static spark.Spark.*;
import service.*;


public class Aplicacao {
	//private static AssisteService assiteService = new AssisteService();
	//private static AvaliaService avalaiaService = new AvaliaService();
	private static UsuarioService usuarioService = new UsuarioService();
	
	
    public static void main(String[] args) {
        port(6789);
        
        staticFiles.location("/public");
        
        //post("/assiste/insert", (request, response) -> assiteService.insert(request, response));
        
        //get("/assiste/:id", (request, response) -> assisteService.get(request, response));
        
        //get("/assiste/delete/:id", (request, response) -> assisteService.delete(request, response));
        
        //post("/avalia/insert", (request, response) -> avalaiService.insert(request, response));
        
        //get("/avalia/:id", (request, response) -> avaliaService.get(request, response));
    
        //get("/avalia/delete/:id", (request, response) -> avaliaService.delete(request, response));
        
        get("/usuario/autenticar", (request, response) -> usuarioService.autenticar(request, response));
        
        post("/usuario/insert", (request, response) -> usuarioService.insert(request, response));
        
        post("/usuario/insert", (request, response) -> usuarioService.insert(request, response));

        get("/usuario/:id", (request, response) -> usuarioService.get(request, response));
        
        get("/usuario/update/:id", (request, response) -> usuarioService.update(request, response));
        
        get("/produto/delete/:id", (request, response) -> usuarioService.delete(request, response));
    }
}