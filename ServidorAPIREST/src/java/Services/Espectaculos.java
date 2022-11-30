/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DTOs.EspectaculoDto;
import DTOs.EspectadorDto;
import DTOs.FuncionDto;
import DTOs.PaqueteDto;
import DTOs.Registro_funcionDto;
import Utility.GsonToUse;
import java.util.ArrayList;
import java.util.Date;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import logica.Fabrica;
import logica.clases.Espectaculo;
import logica.clases.Funcion;
import logica.clases.Paquete;
import logica.clases.Registro_funcion;
import logica.interfaces.InterfaceEspectaculo;

@Path("espectaculos")
public class Espectaculos {
    Fabrica fabrica = Fabrica.getInstance();
    InterfaceEspectaculo ICE = fabrica.getInstanceControladorEspectaculo();
    
//    @GET
//    @Path("/")
//    public Response getTexto(@QueryParam("texto") String texto, @QueryParam("b") String texto2) {
//        try {
//            System.out.println("texto2:" + texto2);
//            return Response.ok(GsonToUse.gson.toJson(texto), MediaType.APPLICATION_JSON).build();
//
//        } catch (Exception e) {
//            System.out.println("Services.Espectaculo.getTexto()" + e.toString());
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//    
//    @POST
//    @Path("/")
//    public Response getDatos(String dato){
//        try {
////            ArrayList<facilDto> data = GsonToUse.gson.fromJson(dato, ArrayList.class);
//            EspectadorDto data = GsonToUse.gson.fromJson(dato, EspectadorDto.class);
//
////            System.out.println(data.getNacimiento());
//            return Response.ok(GsonToUse.gson.toJson(data), MediaType.APPLICATION_JSON).build();
//        } catch (Exception e) {
//            System.out.println("Services.Espectaculo.getDatos()" + e.toString());
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @POST
//    @Path("/lal")
//    public Response getLal(@Valid String dato){
//        try {
//            facilDto facil = GsonToUse.gson.fromJson(dato, facilDto.class);
//            System.out.println(dato);
//            facil.setNombre(facil.getNombre() + " facil");
//            return Response.ok(GsonToUse.gson.toJson(facil), MediaType.APPLICATION_JSON).build();
//        } catch (Exception e) {
//            System.out.println("Services.Espectaculo.getDatos()" + e.toString());
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @POST
//    @Path("/dos")
//    public Response getDos(String datos){
//        try {
//            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);
//            facilDto facil = GsonToUse.gson.fromJson(arguments.get(0), facilDto.class);
//            return Response.ok(GsonToUse.gson.toJson(facil), MediaType.APPLICATION_JSON).build();
////            return Response.ok().build();
//        } catch (Exception e) {
//            System.out.println("Services.Espectaculo.getDatos()" + e.toString());
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//        }
//    }

    @POST
    @Path("/existe_id_de_paquete")
    public Response existe_id_de_paquete(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorEspectaculo().existe_id_de_paquete(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/existe_id_de_paquete:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/existe_id_de_espectaculo")
    public Response existe_id_de_espectaculo(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorEspectaculo().existe_id_de_espectaculo(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/existe_id_de_espectaculo:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_espectaculos_aceptados_no_de_paquete")
    public Response obtener_espectaculos_aceptados_no_de_paquete(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

	    ArrayList<Espectaculo> e = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_espectaculos_aceptados_no_de_paquete(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            ArrayList<EspectaculoDto> dtos = new ArrayList<>();
            for (Espectaculo item : e) {
                dtos.add(new EspectaculoDto(item));
            }
//public EspectaculoDto(String plataforma, String nombre, String descripcion, int duracion, int min_espectador, int max_espectador, String url, int costo, Date fecha_registro, int id, int id_artista) {
            ArrayList<String> r = new ArrayList<>();
            for (EspectaculoDto item : dtos) {
                r.add(GsonToUse.gson.toJson(item));
            }
	    return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_espectaculos_aceptados_no_de_paquete:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_espectaculo")
    public Response obtener_espectaculo(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Espectaculo item = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_espectaculo(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            EspectaculoDto dto = new EspectaculoDto(item);
            return Response.ok(GsonToUse.gson.toJson(dto), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_espectaculo:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/existe_id_de_funcion")
    public Response existe_id_de_funcion(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorEspectaculo().existe_id_de_funcion(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/existe_id_de_funcion:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_imagen_funcion")
    public Response obtener_imagen_funcion(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            byte[] r = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_imagen_funcion(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_imagen_funcion:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_imagen_espectaculo")
    public Response obtener_imagen_espectaculo(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            byte[] r = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_imagen_espectaculo(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_imagen_espectaculo:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_info_paquete")
    public Response obtener_info_paquete(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Paquete r = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_info_paquete(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            PaqueteDto dto = PaqueteDto.fromPaquete(r);
            return Response.ok(GsonToUse.gson.toJson(dto), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_info_paquete:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_imagen_paquete")
    public Response obtener_imagen_paquete(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            byte[] r = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_imagen_paquete(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_imagen_paquete:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/es_un_espectaculo_aceptado")
    public Response es_un_espectaculo_aceptado(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorEspectaculo().es_un_espectaculo_aceptado(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/es_un_espectaculo_aceptado:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/es_funcion_de_espectaculo")
    public Response es_funcion_de_espectaculo(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorEspectaculo().es_funcion_de_espectaculo(GsonToUse.gson.fromJson(arguments.get(0), int.class), GsonToUse.gson.fromJson(arguments.get(1), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/es_funcion_de_espectaculo:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/esta_el_espectaculo_lleno")
    public Response esta_el_espectaculo_lleno(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorEspectaculo().esta_el_espectaculo_lleno(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/esta_el_espectaculo_lleno:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/existe_paquete")
    public Response existe_paquete(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorEspectaculo().existe_paquete(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/existe_paquete:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/chequear_canje")
    public Response chequear_canje(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorEspectaculo().chequear_canje(GsonToUse.gson.fromJson(arguments.get(0), int.class), GsonToUse.gson.fromJson(arguments.get(1), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/chequear_canje:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/canjear_registro")
    public Response canjear_registro(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Fabrica.getInstance().getInstanceControladorEspectaculo().canjear_registro(GsonToUse.gson.fromJson(arguments.get(0), int.class), GsonToUse.gson.fromJson(arguments.get(1), int.class));
            return Response.ok().build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/canjear_registro:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/registrar_espectador_en_funcion_de_espectaculo")
    public Response registrar_espectador_en_funcion_de_espectaculo(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Fabrica.getInstance().getInstanceControladorEspectaculo().registrar_espectador_en_funcion_de_espectaculo(GsonToUse.gson.fromJson(arguments.get(0), int.class), GsonToUse.gson.fromJson(arguments.get(1), int.class), GsonToUse.gson.fromJson(arguments.get(2), int.class));
            return Response.ok().build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/registrar_espectador_en_funcion_de_espectaculo:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/chequear_si_nombre_de_espectaculo_esta_repetido_para_cierta_plataforma")
    public Response chequear_si_nombre_de_espectaculo_esta_repetido_para_cierta_plataforma(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorEspectaculo().chequear_si_nombre_de_espectaculo_esta_repetido_para_cierta_plataforma(GsonToUse.gson.fromJson(arguments.get(0), String.class), GsonToUse.gson.fromJson(arguments.get(1), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/chequear_si_nombre_de_espectaculo_esta_repetido_para_cierta_plataforma:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_plataformas_disponibles")
    public Response obtener_plataformas_disponibles(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            ArrayList<String> r = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_plataformas_disponibles();
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_plataformas_disponibles:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/chequear_si_nombre_de_funcion_esta_repetido")
    public Response chequear_si_nombre_de_funcion_esta_repetido(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorEspectaculo().chequear_si_nombre_de_funcion_esta_repetido(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/chequear_si_nombre_de_funcion_esta_repetido:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_espectaculos_aceptados")
    public Response obtener_espectaculos_aceptados(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            ArrayList<String> r = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_espectaculos_aceptados();
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_espectaculos_aceptados:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_funciones_de_espectaculo")
    public Response obtener_funciones_de_espectaculo(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

	    ArrayList<Funcion> e = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_funciones_de_espectaculo(GsonToUse.gson.fromJson(arguments.get(0), int.class));
	    ArrayList<FuncionDto> dtos = new ArrayList<>();
            for (Funcion item : e) {
                dtos.add(FuncionDto.fromFuncion(item));
//public FuncionDto(String nombre, Date fecha, int hora_inicio, Date fecha_registro, int id, int id_espectaculo) {
            }
            ArrayList<String> r = new ArrayList<>();
            for (FuncionDto item : dtos) {
                r.add(GsonToUse.gson.toJson(item));
            }
	    return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_funciones_de_espectaculo:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_nombres_de_paquetes_asociados_a_espectaculo")
    public Response obtener_nombres_de_paquetes_asociados_a_espectaculo(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            ArrayList<String> r = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_nombres_de_paquetes_asociados_a_espectaculo(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_nombres_de_paquetes_asociados_a_espectaculo:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_funcion_por_id")
    public Response obtener_funcion_por_id(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Funcion item = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_funcion_por_id(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            FuncionDto dto = FuncionDto.fromFuncion(item);
            return Response.ok(GsonToUse.gson.toJson(dto), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_funcion_por_id:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_espectaculo_de_funcion")
    public Response obtener_espectaculo_de_funcion(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Espectaculo item = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_espectaculo_de_funcion(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            EspectaculoDto dto = new EspectaculoDto(item);
            return Response.ok(GsonToUse.gson.toJson(dto), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_espectaculo_de_funcion:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_espectaculos_aceptados_de_paquete")
    public Response obtener_espectaculos_aceptados_de_paquete(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

	    ArrayList<Espectaculo> e = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_espectaculos_aceptados_de_paquete(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            ArrayList<EspectaculoDto> dtos = new ArrayList<>();
            for (Espectaculo item : e) {
                dtos.add(new EspectaculoDto(item));
            }
            ArrayList<String> r = new ArrayList<>();
            for (EspectaculoDto item : dtos) {
                r.add(GsonToUse.gson.toJson(item));
            }
	    return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_espectaculos_aceptados_de_paquete:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_todos_los_registros_de_espectador")
    public Response obtener_todos_los_registros_de_espectador(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

	    ArrayList<Registro_funcion> e = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_todos_los_registros_de_espectador(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            ArrayList<Registro_funcionDto> dtos = new ArrayList<>();
            for (Registro_funcion item : e) {
                dtos.add(Registro_funcionDto.fromRegistro_funcion(item));
            }
            ArrayList<String> r = new ArrayList<>();
            for (Registro_funcionDto item : dtos) {
                r.add(GsonToUse.gson.toJson(item));
            }
	    return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_todos_los_registros_de_espectador:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_paquetes_comprados_por_espectador")
    public Response obtener_paquetes_comprados_por_espectador(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

	    ArrayList<Paquete> e = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_paquetes_comprados_por_espectador(GsonToUse.gson.fromJson(arguments.get(0), String.class));
	    ArrayList<PaqueteDto> dtos = new ArrayList<>();
            for (Paquete paquete : e) {
                dtos.add(PaqueteDto.fromPaquete(paquete));
            }
            ArrayList<String> r = new ArrayList<>();
            for (PaqueteDto item : dtos) {
                r.add(GsonToUse.gson.toJson(item));
            }
	    return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_paquetes_comprados_por_espectador:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_espectaculos_de_artista")
    public Response obtener_espectaculos_de_artista(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

	    ArrayList<Espectaculo> e = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_espectaculos_de_artista(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            ArrayList<EspectaculoDto> dtos = new ArrayList<>();
            for (Espectaculo item : e) {
                dtos.add(new EspectaculoDto(item));
            }
            ArrayList<String> r = new ArrayList<>();
            for (EspectaculoDto item : dtos) {
                r.add(GsonToUse.gson.toJson(item));
            }
	    return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_espectaculos_de_artista:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/chequear_si_nombre_de_paquete_esta_repetido")
    public Response chequear_si_nombre_de_paquete_esta_repetido(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            boolean r = Fabrica.getInstance().getInstanceControladorEspectaculo().chequear_si_nombre_de_paquete_esta_repetido(GsonToUse.gson.fromJson(arguments.get(0), String.class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/chequear_si_nombre_de_paquete_esta_repetido:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/registrar_paquete")
    public Response registrar_paquete(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

            Boolean r = Fabrica.getInstance().getInstanceControladorEspectaculo().registrar_paquete(PaqueteDto.toPaquete(GsonToUse.gson.fromJson(arguments.get(0), PaqueteDto.class)), GsonToUse.gson.fromJson(arguments.get(1), byte[].class));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/registrar_paquete:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/get_espectaculos_aceptados")
    public Response get_espectaculos_aceptados(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

	    ArrayList<Espectaculo> e = Fabrica.getInstance().getInstanceControladorEspectaculo().get_espectaculos_aceptados();
            ArrayList<EspectaculoDto> dtos = new ArrayList<>();
            for (Espectaculo item : e) {
                dtos.add(new EspectaculoDto(item));
            }
            ArrayList<String> r = new ArrayList<>();
            for (EspectaculoDto item : dtos) {
                r.add(GsonToUse.gson.toJson(item));
//                System.out.println(GsonToUse.gson.toJson(item));
            }
	    return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/get_espectaculos_aceptados:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/obtener_registros_de_espectador")
    public Response obtener_registros_de_espectador(String datos){
        try {
            ArrayList<String> arguments = GsonToUse.gson.fromJson(datos, ArrayList.class);

	    ArrayList<Registro_funcion> e = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_registros_de_espectador(GsonToUse.gson.fromJson(arguments.get(0), int.class));
            ArrayList<Registro_funcionDto> dtos = new ArrayList<>();
            for (Registro_funcion item : e) {
                dtos.add(Registro_funcionDto.fromRegistro_funcion(item));
            }
            ArrayList<String> r = new ArrayList<>();
            for (Registro_funcionDto item : dtos) {
                r.add(GsonToUse.gson.toJson(item));
            }
	    return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
		
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_registros_de_espectador:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @POST
    @Path("/que")
    public Response que() {
        try {
	    ArrayList<Espectaculo> e = Fabrica.getInstance().getInstanceControladorEspectaculo().get_espectaculos_aceptados();
            ArrayList<String> r = new ArrayList<>();
//            e.get(0).setFecha_registro(new Date(e.get(0).getFecha_registro().getTime()));
            r.add(GsonToUse.gson.toJson(e.get(0)));
            return Response.ok(GsonToUse.gson.toJson(r), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            System.out.println("/espectaculos/obtener_registros_de_espectador:" + e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
