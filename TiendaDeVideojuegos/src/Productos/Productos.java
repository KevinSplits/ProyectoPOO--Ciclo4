
package Productos;
   import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class Productos {
    Connection cn;
    private int codigo;
    private String nombre;
    private int cantidad;
    private float precio;
    private String marca;
    private String modelo;
      
    public Productos(){
        Conexion1 con=new Conexion1();
        cn= con.conectar();
    }  

    public void LLenarDatos(DefaultTableModel modelo){
        try {
            String sql="select * from Producto";
            CallableStatement cmd=cn.prepareCall(sql);
            ResultSet rs= cmd.executeQuery();
           
            while(rs.next()){
                // aqui esta el arreglo de objetos guey
                Object[] datos=new Object[6];
              
                for(int i=0;i<6;i++){
                    datos[i]=rs.getString(i+1);                  
                }
                modelo.addRow(datos);
            }
            cmd.close();
            cn.close();
           
        } catch (Exception e) { System.out.println(e.getMessage());
        }
    }  

    public void Agregar1 (String nombre, int cantidad, float precio,String marca,String modelo){
        try {
            String sql="execute AgregarProducto ?,?,?,?,?";
            PreparedStatement cmd=cn.prepareCall(sql);
            cmd.setString(1, nombre);
            cmd.setInt(2, cantidad);
            cmd.setFloat(3, precio);
            cmd.setString(4, marca);
            cmd.setString(5, modelo);
            cmd.execute();
            cmd.close();
            cn.close();          
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }      
    }       
} 

