/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DTOs.ArtistaDto;
import DTOs.EspectadorDto;
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
import logica.clases.Espectador;
import logica.interfaces.InterfaceUsuario;

/**
 *
 * @author 59892
 */
@Path("users")
public class Users {
    Fabrica fabrica = Fabrica.getInstance();
    InterfaceUsuario ICU = fabrica.getInstanceControllerUsuario();
    @POST
    @Path("/paquete_comprado")
    public Response paquete_comprado(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControllerUsuario().paquete_comprado(GsonToUse.gson.fromJson(arguments.get(0), int.class), GsonToUse.gson.fromJson(arguments.get(1), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/users/paquete_comprado:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/comprar_paquete")
    public Response comprar_paquete(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControllerUsuario().comprar_paquete(GsonToUse.gson.fromJson(arguments.get(0), int.class), GsonToUse.gson.fromJson(arguments.get(1), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/users/comprar_paquete:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/existe_nickname_de_usuario")
    public Response existe_nickname_de_usuario(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControllerUsuario().existe_nickname_de_usuario(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/users/existe_nickname_de_usuario:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_imagen_usuario_con_nickname")
    public Response obtener_imagen_usuario_con_nickname(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            byte[] r = Fabrica.getInstance().getInstanceControllerUsuario().obtener_imagen_usuario_con_nickname(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/users/obtener_imagen_usuario_con_nickname:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/esta_usuario_registrado_a_funcion")
    public Response esta_usuario_registrado_a_funcion(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControllerUsuario().esta_usuario_registrado_a_funcion(GsonToUse.gson.fromJson(arguments.get(0), int.class), GsonToUse.gson.fromJson(arguments.get(1), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/users/esta_usuario_registrado_a_funcion:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/esta_siguiendo_a")
    public Response esta_siguiendo_a(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControllerUsuario().esta_siguiendo_a(GsonToUse.gson.fromJson(arguments.get(0), String.class), GsonToUse.gson.fromJson(arguments.get(1), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/users/esta_siguiendo_a:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/seguir_a")
    public Response seguir_a(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Fabrica.getInstance().getInstanceControllerUsuario().seguir_a(GsonToUse.gson.fromJson(arguments.get(0), String.class), GsonToUse.gson.fromJson(arguments.get(1), String.class));
            return Response.ok().build();
		
        } catch (Exception e) {
            System.out.println("/users/seguir_a:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/dejar_de_seguir")
    public Response dejar_de_seguir(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Fabrica.getInstance().getInstanceControllerUsuario().dejar_de_seguir(GsonToUse.gson.fromJson(arguments.get(0), String.class), GsonToUse.gson.fromJson(arguments.get(1), String.class));
            return Response.ok().build();
		
        } catch (Exception e) {
            System.out.println("/users/dejar_de_seguir:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_artista_de_id")
    public Response obtener_artista_de_id(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Artista r = Fabrica.getInstance().getInstanceControllerUsuario().obtener_artista_de_id(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            ArtistaDto ar = new ArtistaDto(r.getDescripcion(), r.getBiografia(), r.getSitio_web(), r.getNickname(), r.getNombre(), r.getApellido(), r.getCorreo(), new Date(r.getNacimiento().getTime()), r.getId(), r.getContrasenia());
            return Response.ok(GsonToUse.gson.toJson(ar), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/users/obtener_artista_de_id:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_artistas_invitados")
    public Response obtener_artistas_invitados(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

	    ArrayList<Artista> e = Fabrica.getInstance().getInstanceControllerUsuario().obtener_artistas_invitados(GsonToUse.gson.fromJson(arguments.get(0), int.class));
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
            System.out.println("/users/obtener_artistas_invitados:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_artista_de_nickname")
    public Response obtener_artista_de_nickname(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Artista r = Fabrica.getInstance().getInstanceControllerUsuario().obtener_artista_de_nickname(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            ArtistaDto ar = new ArtistaDto(r.getDescripcion(), r.getBiografia(), r.getSitio_web(), r.getNickname(), r.getNombre(), r.getApellido(), r.getCorreo(), new Date(r.getNacimiento().getTime()), r.getId(), r.getContrasenia());
            return Response.ok(GsonToUse.gson.toJson(ar), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/users/obtener_artista_de_nickname:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_espectador_de_nickname")
    public Response obtener_espectador_de_nickname(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Espectador r = Fabrica.getInstance().getInstanceControllerUsuario().obtener_espectador_de_nickname(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            EspectadorDto dto = new EspectadorDto(r.getNickname(), r.getNombre(), r.getApellido(), r.getCorreo(), new Date(r.getNacimiento().getTime()), r.getId(), r.getContrasenia());

            String retorna = GsonToUse.gson.toJson(dto);
//            System.out.println(retorna);
            return Response.ok(retorna, MediaType.APPLICATION_JSON).build();

        } catch (Exception e) {
            System.out.println("/users/obtener_espectador_de_nickname:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_nicknames_de_usuarios_que_siguen_a")
    public Response obtener_nicknames_de_usuarios_que_siguen_a(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            ArrayList<String> r = Fabrica.getInstance().getInstanceControllerUsuario().obtener_nicknames_de_usuarios_que_siguen_a(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();

        } catch (Exception e) {
            System.out.println("/users/obtener_nicknames_de_usuarios_que_siguen_a:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_nicknames_de_usuarios_a_los_que_sigue")
    public Response obtener_nicknames_de_usuarios_a_los_que_sigue(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            ArrayList<String> r = Fabrica.getInstance().getInstanceControllerUsuario().obtener_nicknames_de_usuarios_a_los_que_sigue(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/users/obtener_nicknames_de_usuarios_a_los_que_sigue:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/modificar_imagen_de_usuario")
    public Response modificar_imagen_de_usuario(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Fabrica.getInstance().getInstanceControllerUsuario().modificar_imagen_de_usuario(GsonToUse.gson.fromJson(arguments.get(0), int.class), GsonToUse.gson.fromJson(arguments.get(1), byte[].class));
            return Response.ok().build();
		
        } catch (Exception e) {
            System.out.println("/users/modificar_imagen_de_usuario:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/modificar_artista")
    public Response modificar_artista(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Fabrica.getInstance().getInstanceControllerUsuario().modificar_artista(GsonToUse.gson.fromJson(arguments.get(0), int.class), GsonToUse.gson.fromJson(arguments.get(1), Artista.class));
            return Response.ok().build();
		
        } catch (Exception e) {
            System.out.println("/users/modificar_artista:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/modificar_espectador")
    public Response modificar_espectador(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Fabrica.getInstance().getInstanceControllerUsuario().modificar_espectador(GsonToUse.gson.fromJson(arguments.get(0), int.class), GsonToUse.gson.fromJson(arguments.get(1), Espectador.class));
            return Response.ok().build();
		
        } catch (Exception e) {
            System.out.println("/users/modificar_espectador:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/existe_correo_de_usuario")
    public Response existe_correo_de_usuario(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControllerUsuario().existe_correo_de_usuario(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/users/existe_correo_de_usuario:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_nickname_de_correo")
    public Response obtener_nickname_de_correo(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            String r = Fabrica.getInstance().getInstanceControllerUsuario().obtener_nickname_de_correo(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/users/obtener_nickname_de_correo:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/chequear_nickname_repetido")
    public Response chequear_nickname_repetido(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControllerUsuario().chequear_nickname_repetido(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/users/chequear_nickname_repetido:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/chequear_correo_repetido")
    public Response chequear_correo_repetido(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControllerUsuario().chequear_correo_repetido(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/users/chequear_correo_repetido:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/registrar_artista")
    public Response registrar_artista(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Fabrica.getInstance().getInstanceControllerUsuario().registrar_artista(GsonToUse.gson.fromJson(arguments.get(0), Artista.class), GsonToUse.gson.fromJson(arguments.get(1), byte[].class));
            return Response.ok().build();
		
        } catch (Exception e) {
            System.out.println("/users/registrar_artista:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/registrar_espectador")
    public Response registrar_espectador(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Fabrica.getInstance().getInstanceControllerUsuario().registrar_espectador(GsonToUse.gson.fromJson(arguments.get(0), Espectador.class), GsonToUse.gson.fromJson(arguments.get(1), byte[].class));
            return Response.ok().build();
		
        } catch (Exception e) {
            System.out.println("/users/registrar_espectador:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_nicknames_de_usuarios")
    public Response obtener_nicknames_de_usuarios(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            ArrayList<String> r = Fabrica.getInstance().getInstanceControllerUsuario().obtener_nicknames_de_usuarios();
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/users/obtener_nicknames_de_usuarios:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
