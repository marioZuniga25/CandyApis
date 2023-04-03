
package com.softday.candyday.rest;

import com.google.gson.Gson;
import com.softday.candyday.controller.ControllerLogin;
import com.softday.candyday.model.Usuario;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author mazu1
 */
@Path("Log")
public class LoginREST {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("in")
    public Response login(@QueryParam("usuario") @DefaultValue("") String nombreUsuario,
                          @QueryParam("contrasenia")@DefaultValue("") String contrasenia){
        
        Gson gson = new Gson();       
        String out = null;
        ControllerLogin cl = new ControllerLogin();
        Usuario usu = null;
        
        try{
            usu = cl.login(nombreUsuario, contrasenia);
            if(usu != null){
               // usu.getUsuario().setLastToken();
                //System.out.println(usu.getUsuario().getLastToken());
                //cl.delete(usu.getIdUsuario(),usu.getLastToken());
                out = new Gson().toJson(usu);

            }else{
            out ="""
                 {"error" : "%s"}
                 """;
            out = String.format(out,"datos incorrectos");
            }
        }catch(Exception e){
            out = """
                  {"exception" : "?"}
                  """;
            out = String.format(out, "error interno en el servidor");
        }
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
   /* @Path("out")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response logOut(@QueryParam("empleado") @DefaultValue("") String u) throws Exception{
        String out = null;
        Usuario usuario = null;
        ControllerLogin ca = null;
        Gson gson = new Gson();
        
        try {
            usuario = gson.fromJson(u, Usuario.class);
            ca = new ControllerLogin();
            if (ca.eliminarToken(usuario)) {
                out = """
                  {"validado" : "%s"}
                  """;
            out = String.format(out, "Eliminación de Token correcta");
            }else{
                out = """
                  {"exception" : "%s"}
                  """;
            out = String.format(out, "Eliminación de Token no realizado");
            }
        } catch (JsonParseException jpe) {
            out = """
                    {"error":"Formato de datos no válido"}
                  """;
            jpe.printStackTrace();
        } catch (Exception ex){
            out = """
                    {"error":"Eliminación no concedido"}
                  """;
            ex.printStackTrace();
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
*/

    
}
