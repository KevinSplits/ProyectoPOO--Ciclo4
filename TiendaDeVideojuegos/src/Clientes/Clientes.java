
package Clientes;
   import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class Clientes {
    Connection cn;
    private int codigo;
    private String nombre;
    private String direccion;
    private String numero;
      
    public Clientes(){
        Conexion con=new Conexion();
        cn= con.conectar();
    }  

    public void LLenarDatos1(DefaultTableModel modelo){
        try {
            String sql="select * from Cliente";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
           
            while(rs.next()){
                // aqui esta el arreglo de objetos guey
                Object[] datos=new Object[4];
              
                for(int i=0;i<4;i++){
                    datos[i]=rs.getString(i+1);                  
                }
                modelo.addRow(datos);
            }
            cmd.close();
            cn.close();
           
        } catch (Exception e) { System.out.println(e.getMessage());
        }
    }  

    public void Agregar2 (String nombre,String direccion,String numero ){
        try {
            String sql="execute RegistrarCliente ?,?,?";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.setString(1, nombre);
            cmd.setString(2,direccion );
            cmd.setString(3, numero);
            cmd.execute();
            cmd.close();
            cn.close();          
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }      
    }       
} 

