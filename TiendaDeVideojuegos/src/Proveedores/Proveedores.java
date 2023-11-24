package Proveedores;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Proveedores {

    Connection cn;
    private int codigo;
    private String nombre;
    private String direccion;
    private String telefono;

    public Proveedores() {
        Conexion con = new Conexion();
        cn = con.conectar();
    }

    public void LLenarDatos3(DefaultTableModel modelo) {
        try {
            String sql = "select * from PROVEEDOR";
            CallableStatement cmd = cn.prepareCall(sql);
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                // aqui esta el arreglo de objetos guey
                Object[] datos = new Object[4];

                for (int i = 0; i < 4; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                modelo.addRow(datos);
            }
            cmd.close();
            cn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Agregar4(String nombre,String direccion,String telefono) {
        try {
            String sql = "execute RegistrarProveedor ?,?,?";
            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.setString(1, nombre);
            cmd.setString(2, telefono);
            cmd.setString(3, direccion);
            cmd.execute();
            cmd.close();
            cn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
