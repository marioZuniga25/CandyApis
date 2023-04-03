
package com.softday.candyday.rest;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.softday.candyday.controller.ControllerProducto;
import com.softday.candyday.controller.ControllerUsuario;
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

@Path("usuario")
public class UsuarioREST {
    

    @POST
    @Path("registro")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registro (@QueryParam("datosUsuario") @DefaultValue("")String datosUsuario){
        String out = null;
        Gson gson = new Gson();
        Usuario u = null; 
        ControllerUsuario ca = new ControllerUsuario(); //Controler es donde se hace todas las funciones

        
        try{
          
                u = gson.fromJson(datosUsuario, Usuario.class); //Ocupamos gson para convertirlo Gson tiene una funcion que permite convertir una variable a una clase
                
                ca.insert(u);
                
                /*if (mat.getIdAlumno()== 0) { // Realizamos un if para saber si existe el Material, de la clase Material tomamos el id y lo comparamos con 0
                    cm.insert(mat); //si es igual a 0 insertamos el Material
                } else {
                    cm.update(mat); //Y si la id no es 0 se actualiza el Material
                }*/
                out = gson.toJson(u); //Debolvemos una respuesta y se compierte a un String
            
        }
        catch(JsonParseException jpe){
            jpe.printStackTrace();
            
            out = """
                  {"exception": "Formato de Datos Incorrecto."}
                  """;
        }
        catch(Exception e){
            e.printStackTrace();
            out = """
                  {"exception" : "%s"}
                  """;
            out = String.format(out, e.toString());
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}

