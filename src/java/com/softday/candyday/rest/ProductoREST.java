
package com.softday.candyday.rest;

import com.softday.candyday.controller.ControllerProducto;
import com.google.gson.Gson;
import com.softday.candyday.model.Productos;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.awt.PageAttributes;
import java.util.List;

/**
 *
 * @author mazu1
 */
@Path("producto")
public class ProductoREST {
    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll (@QueryParam("filtro") @DefaultValue("")String filtro){
        String out = null;
        ControllerProducto ce = null;
        List<Productos> producto = null;
        try{
            ce = new ControllerProducto();
            producto = ce.getAll(filtro);
            out = new Gson().toJson(producto);
        }
        catch(Exception e){
            e.printStackTrace();
            out= "{\"exception\":\"Error interno del servidor.\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    
    @GET
    @Path("buscarP")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarP (@QueryParam("codigoBarras") @DefaultValue("")String codigoBarras){
        String out = null;
        ControllerProducto ce = null;
        Productos producto = null;
        try{
            ce = new ControllerProducto();
            producto = ce.buscarP(codigoBarras);
            out = new Gson().toJson(producto);
        }
        catch(Exception e){
            e.printStackTrace();
            out= "{\"exception\":\"Error interno del servidor.\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }


    
}
