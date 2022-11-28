/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DTOs.ArtistaDto;
import DTOs.CategoriaDto;
import DTOs.PaqueteDto;
import Utility.GsonToUse;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Date;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import logica.Fabrica;
import logica.clases.Artista;
import logica.clases.Categoria;
import logica.clases.Espectaculo;
import logica.clases.Funcion;
import logica.clases.Paquete;
import logica.interfaces.InterfacePlataforma;

@Path("plataformas")
public class Plataforma {
    Fabrica fabrica = Fabrica.getInstance();
    InterfacePlataforma ICP = fabrica.getInstanceControladorPlataforma();

    @POST
    @Path("/Agregar_espectaculo_a_paquete")
    public Response Agregar_espectaculo_a_paquete(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorPlataforma().Agregar_espectaculo_a_paquete(GsonToUse.gson.fromJson(arguments.get(0), int.class), GsonToUse.gson.fromJson(arguments.get(1), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/plataformas/Agregar_espectaculo_a_paquete:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_info_paquetes")
    public Response obtener_info_paquetes(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Paquete r = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_info_paquetes(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            PaqueteDto dto = new PaqueteDto(r.getNombre(), r.getDescripcion(), new Date(r.getFecha_inicio().getTime()), new Date(r.getFecha_fin().getTime()), r.getDescuento(), r.getId());

            return Response.ok(GsonToUse.gson.toJson(dto), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/plataformas/obtener_info_paquetes:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/crear_Espectaculo")
    public Response crear_Espectaculo(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorPlataforma().crear_Espectaculo(GsonToUse.gson.fromJson(arguments.get(0), Espectaculo.class), GsonToUse.gson.fromJson(arguments.get(1), byte[].class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/plataformas/crear_Espectaculo:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_idespectaculo")
    public Response obtener_idespectaculo(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            int r = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_idespectaculo(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/plataformas/obtener_idespectaculo:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_id_categoria")
    public Response obtener_id_categoria(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            int r = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_id_categoria(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/plataformas/obtener_id_categoria:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/insertar_en_categoria_espectaculo")
    public Response insertar_en_categoria_espectaculo(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorPlataforma().insertar_en_categoria_espectaculo(GsonToUse.gson.fromJson(arguments.get(0), int.class), GsonToUse.gson.fromJson(arguments.get(1), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/plataformas/insertar_en_categoria_espectaculo:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_categorias")
    public Response obtener_categorias(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

	    ArrayList<Categoria> e = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_categorias();
            ArrayList<CategoriaDto> categorias = new ArrayList<>();
            for (Categoria item : e) {
                categorias.add(new CategoriaDto(item.getNombre(), item.getId()));
            }
            ArrayList<String> r = new ArrayList<>();
            for (CategoriaDto item : categorias) {
                r.add(GsonToUse.gson.toJson(item));
            }
	        return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/plataformas/obtener_categorias:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/Alta_de_Funcion")
    public Response Alta_de_Funcion(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorPlataforma().Alta_de_Funcion(GsonToUse.gson.fromJson(arguments.get(0), Funcion.class), GsonToUse.gson.fromJson(arguments.get(1), byte[].class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/plataformas/Alta_de_Funcion:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_idfuncion")
    public Response obtener_idfuncion(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            int r = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_idfuncion(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/plataformas/obtener_idfuncion:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_idartista")
    public Response obtener_idartista(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            int r = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_idartista(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/plataformas/obtener_idartista:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/insertar_Artista_Invitado")
    public Response insertar_Artista_Invitado(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorPlataforma().insertar_Artista_Invitado(GsonToUse.gson.fromJson(arguments.get(0), int.class), GsonToUse.gson.fromJson(arguments.get(1), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/plataformas/insertar_Artista_Invitado:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_artistas_disponibles")
    public Response obtener_artistas_disponibles(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

	    ArrayList<Artista> e = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_artistas_disponibles();
            ArrayList<ArtistaDto> artistas = new ArrayList<>();
            for (Artista item : e) {
                artistas.add(new ArtistaDto(item.getDescripcion(), item.getBiografia(), item.getSitio_web(), item.getNickname(), item.getNombre(), item.getApellido(), item.getCorreo(), new Date(item.getNacimiento().getTime()), item.getId(), item.getContrasenia()));
            }
            ArrayList<String> r = new ArrayList<>();
            for (ArtistaDto item : artistas) {
                r.add(GsonToUse.gson.toJson(item));
            }
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/plataformas/obtener_artistas_disponibles:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_categorias_espectaculo")
    public Response obtener_categorias_espectaculo(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            ArrayList<String> r = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_categorias_espectaculo(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/plataformas/obtener_categorias_espectaculo:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_paquetes")
    public Response obtener_paquetes(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

	    ArrayList<Paquete> e = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_paquetes();
	    ArrayList<PaqueteDto> dtos = new ArrayList<>();
            for (Paquete paquete : e) {
                dtos.add(new PaqueteDto(paquete.getNombre(), paquete.getDescripcion(), new Date(paquete.getFecha_inicio().getTime()), new Date(paquete.getFecha_fin().getTime()), paquete.getDescuento(), paquete.getId()));
            }

            ArrayList<String> r = new ArrayList<>();
            for (PaqueteDto item : dtos) {
                r.add(GsonToUse.gson.toJson(item));
            }
	    return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/plataformas/obtener_paquetes:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
