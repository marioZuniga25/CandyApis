
package com.softday.candyday.controller;

import com.google.gson.Gson;
import java.sql.CallableStatement;
import com.softday.candyday.bd.ConexionMySQL;
import com.softday.candyday.model.Productos;
import com.softday.candyday.model.Usuario;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mazu1
 */


public class ControllerUsuario {
    
    /*public void registro(Usuario u) throws Exception
    {
        boolean r = false;
        
        //La consulta SQL a ejecutar:
        String sql = "{INSERT INTO usuario (nombreUsuario, contrasenia, correo) VALUES (?, ?, ?);}";
        
        //Con este objeto nos vamos a conectar a la Base de Datos:
        ConexionMySQL connMySQL = new ConexionMySQL();
        
        //Abrimos la conexión con la Base de Datos:
        Connection conn = connMySQL.open();
        
        //Con este objeto ejecutaremos la consulta:
        CallableStatement cstmt = conn.prepareCall(sql);
        
        //Aquí guardaremos los resultados de la consulta:
        cstmt.executeUpdate();
        
        
        
        cstmt.setString(1, u.getNombreUsuario());
        cstmt.setString(2, u.getContrasenia());
        cstmt.setString(3, u.getCorreo());
        
        
        cstmt.close();
        connMySQL.close();
        
        //return r;
    }*/
    
    
    
    public void insert(Usuario u) throws Exception
    {
        //Definimos la consulta SQL que invoca al Stored Procedure:
        //String sql =    "{call insertarUsuario(?, ?, ?, ?)}";  // Valores de Retorno
        
        String sql = "INSERT INTO usuario (nombreUsuario, contrasenia, correo) VALUES (?, ?, ?);";
        
        //Aquí guardaremos los ID's que se generarán:
        //int idUsuarioGenerado = -1;
        
        //Con este objeto nos vamos a conectar a la Base de Datos:
        ConexionMySQL connMySQL = new ConexionMySQL();
        
        //Abrimos la conexión con la Base de Datos:
        Connection conn = connMySQL.open();
        
        //Con este objeto invocaremos al StoredProcedure:
        CallableStatement cstmt = conn.prepareCall(sql);
        
        //Establecemos los valores de lso parametros  de los datos personales 
        //en el orden
        //en que los pide el procedimiento almacenado, comenzando en 1:
        cstmt.setString(1, u.getNombreUsuario());
        cstmt.setString(2, u.getContrasenia());
        cstmt.setString(3, u.getCorreo());
       // cstmt.registerOutParameter(4, Types.INTEGER);
        
        //Ejecutamos el Stored Procedure:
        cstmt.executeUpdate();
        
        //Recuperamos los ID's generados:
        
        //idUsuarioGenerado = cstmt.getInt(4);
        
        //u.setIdUsuario();
        
        
        cstmt.close();
        connMySQL.close();
        
        //Devolvemos el ID de Cliente generado:
        //return idUsuarioGenerado;
    }
    
    
    

}

