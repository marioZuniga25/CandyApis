
package com.softday.candyday.controller;

import com.softday.candyday.bd.ConexionMySQL;
import com.softday.candyday.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author mazu1
 */
public class ControllerLogin {
    
    public Usuario login(String usuario, String contrasenia) throws Exception{
    String sql = "SELECT * FROM usuario WHERE nombreUsuario = ? AND contrasenia = ?;";
    
    ConexionMySQL connMySQL = new ConexionMySQL();
    Connection conn = connMySQL.open();
    
    PreparedStatement pstmt = conn.prepareStatement(sql);
    
    ResultSet rs = null;
    
    pstmt.setString(1, usuario);
    pstmt.setString(2, contrasenia);
    
    rs = pstmt.executeQuery();
    
    Usuario u = null;
    
    if (rs.next()){
        u = fill(rs);
    }
    
    rs.close();
    pstmt.close();
    connMySQL.close();
    
    return u;
    }
    
    private Usuario fill (ResultSet rs) throws Exception{
        
        Usuario u = new Usuario();
        
        
        u.setIdUsuario(rs.getInt("idUsuario"));
        u.setNombreUsuario(rs.getString("nombreUsuario"));
        u.setContrasenia(rs.getString("contrasenia"));
        u.setCorreo(rs.getString("correo"));
        
        
        return u;
    }
}
