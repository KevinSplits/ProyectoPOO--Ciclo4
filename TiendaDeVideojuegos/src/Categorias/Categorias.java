
package Categorias;
   import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class Categorias {
    Connection cn;
    private int codigo;
    private String nombre;

      
    public Categorias(){
        Conexion con=new Conexion();
        cn= con.conectar();
    }  

    public void LLenarDatos2(DefaultTableModel modelo){
        try {
            String sql="select * from Categoria";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
           
            while(rs.next()){
                // aqui esta el arreglo de objetos guey
                Object[] datos=new Object[2];
              
                for(int i=0;i<2;i++){
                    datos[i]=rs.getString(i+1);                  
                }
                modelo.addRow(datos);
            }
            cmd.close();
            cn.close();
           
        } catch (Exception e) { System.out.println(e.getMessage());
        }
    }  

    public void Agregar3 (String nombre){
        try {
            String sql="execute ModificarCategoria ?,?,?";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.setString(1, nombre);
            cmd.execute();
            cmd.close();
            cn.close();          
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }      
    }       
} 

