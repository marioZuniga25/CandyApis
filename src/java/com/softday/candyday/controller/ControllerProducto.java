
package com.softday.candyday.controller;

import com.softday.candyday.bd.ConexionMySQL;
import com.softday.candyday.model.Productos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mazu1
 */
public class ControllerProducto {
     public List<Productos> getAll(String filtro) throws Exception
    {
        //La consulta SQL a ejecutar:
        String sql = "SELECT * FROM productos;";
        
        //Con este objeto nos vamos a conectar a la Base de Datos:
        ConexionMySQL connMySQL = new ConexionMySQL();
        
        //Abrimos la conexión con la Base de Datos:
        Connection conn = connMySQL.open();
        
        //Con este objeto ejecutaremos la consulta:
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        //Aquí guardaremos los resultados de la consulta:
        ResultSet rs = pstmt.executeQuery();
        
        List<Productos> productos = new ArrayList<>();
        
        while (rs.next()){
            productos.add(fill(rs));
        }
        
        rs.close();
        pstmt.close();
        connMySQL.close();
        
        return productos;
    }
    
   
    
     public Productos buscarP(String codigoBarras) throws Exception
    {
        //La consulta SQL a ejecutar:
        String sql = "SELECT * FROM productos WHERE codigoBarras = "+codigoBarras+";";
        
        //Con este objeto nos vamos a conectar a la Base de Datos:
        ConexionMySQL connMySQL = new ConexionMySQL();
        
        //Abrimos la conexión con la Base de Datos:
        Connection conn = connMySQL.open();
        
        //Con este objeto ejecutaremos la consulta:
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        //Aquí guardaremos los resultados de la consulta:
        ResultSet rs = pstmt.executeQuery();
        
        Productos p = new Productos();
        
        if (rs.next()) {
        
            p = fill(rs);    
        
        }
        
        
        
        rs.close();
        pstmt.close();
        connMySQL.close();
        
        return p;
    }
    
     private Productos fill(ResultSet rs) throws Exception
    {
        Productos p = new Productos();
        
        p.setIdProducto(rs.getInt("idProducto"));
        p.setNombreProducto(rs.getString("nombreProducto"));
        p.setPrecioVenta(rs.getDouble("precioVenta"));
        p.setFotografia(rs.getString("fotografia"));
        p.setExistencias(rs.getInt("existencias"));
        p.setTipo(rs.getString("tipo"));
        p.setEstatus(rs.getInt("estatus"));
        
        
        return p;
    }
    

}
