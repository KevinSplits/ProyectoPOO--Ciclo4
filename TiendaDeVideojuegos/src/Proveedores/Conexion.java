
package Proveedores;

//import com.sun.jdi.connect.spi.Connection;


import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url="jdbc:sqlserver://localhost:1433;databaseName=TiendaVideojuegos";
    private String user="sa";
    private String pass="123";
    
    Conexion(){ }
    
    public Connection conectar(){
        try{
            Class.forName(driver);
            return(DriverManager.getConnection(url,user,pass));
        }catch(Exception e){System.out.println(e);}
        return null;
    }
    
    public void CerrarConexion(Connection con){
        try{
            con.close();
            
        }catch(Exception e){System.out.println(e);}
    }
    
            
}
