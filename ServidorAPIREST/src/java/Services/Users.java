/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import logica.Fabrica;
import logica.clases.Usuario;
import logica.interfaces.InterfaceUsuario;

/**
 *
 * @author 59892
 */

@Path("users")
public class Users {
     Fabrica fabrica = Fabrica.getInstance();
     InterfaceUsuario ICU = fabrica.getInstanceControllerUsuario();
     
    @GET
    @Path("/")
    public Response getUsers(@QueryParam("email") String email) {
        try {
            boolean existe = ICU.chequear_correo_repetido(email);
               System.out.println(email); 
           // EspectadorDto usuario = new EspectadorDto(texto, "Edison", "Cavani", "edi@gmail.com", new Date(), -1, "123");  
            return Response.ok(new Gson().toJson(existe), MediaType.APPLICATION_JSON).build();

        } catch (Exception e) {
            System.out.println("Services.Users.getTexto()" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
     
}
