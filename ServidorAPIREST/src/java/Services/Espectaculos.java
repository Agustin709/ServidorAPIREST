/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DTOs.EspectaculoDto;
import DTOs.EspectadorDto;

import com.google.gson.Gson;
import java.util.Date;
import javax.validation.Valid;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    public Response getTexto(@PathParam("texto") String texto) {
        try {
               System.out.println(texto); 
           // EspectadorDto usuario = new EspectadorDto(texto, "Edison", "Cavani", "edi@gmail.com", new Date(), -1, "123");  
            return Response.ok(new Gson().toJson(texto), MediaType.APPLICATION_JSON).build();

        } catch (Exception e) {
            System.out.println("Services.Espectaculo.getTexto()" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
     public Response getDatos(@Valid EspectaculoDto dato){
         try {
             //EspectadorDto espectaculo = new EspectadorDto ("lucho9","Luis","Suarez","lucho@gmail.com",new Date(), -2, "123");
             return Response.ok(new Gson().toJson(dato), MediaType.APPLICATION_JSON).build();
         } catch (Exception e) {
             System.out.println("Services.Espectaculo.getDatos()" + e.toString());
             return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
         }
     }
   
}
