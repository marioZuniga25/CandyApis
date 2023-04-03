
package com.softday.candyday.bd;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author pasit
 */
public class ConexionMySQL {
    Connection conn;
    
    public Connection open(){
       
        String user = "root";
        String password = "gatitofeliz25";
        String url = "jdbc:mysql://localhost:3306/candyday?useSSL=false&"
                +"allowPublicKeyRetrieval=true&"+ 
                "useUnicode=true&characterEncoding=utf-8";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            /*conn = DriverManager.getConnection("jdbc:mysql://us-east.connect.psdb.cloud/aplication1?sslMode=VERIFY_IDENTITY"
                    ,"4hnev730rwvptma0530g"
                    ,"pscale_pw_8cAqQuZ7qlNxQmiQqAlftxy2T0n4VdWpKGWAIzIjZLx");
            */
            
            conn = DriverManager.getConnection(url,user,password);
            
            
            return conn;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public void close(){
        if (conn != null) {
            try{
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Exception Controlada");
            }
        }
    }
}
