/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DTOs.EspectadorDto;
import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import logica.Fabrica;
import logica.interfaces.InterfaceEspectaculo;

@Path("espectaculos")
public class Espectaculos {
    Fabrica fabrica = Fabrica.getInstance();
    InterfaceEspectaculo ICE = fabrica.getInstanceControladorEspectaculo();
    
    @GET
    @Path("/")
    public Response getTexto(@QueryParam("texto") String texto) {
        try {
                
            EspectadorDto usuario = new EspectadorDto(texto, "Edison", "Cavani", "edi@gmail.com", new Date(), -1, "123");  
            return Response.ok(usuario, MediaType.APPLICATION_JSON).build();

        } catch (Exception e) {
            System.out.println("Services.Espectaculo.getTexto()" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
