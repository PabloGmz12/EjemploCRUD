
package Modelos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpleadosModel {
Connection MyConexion;
ResultSet result;


public DefaultTableModel ListarDatos()
{
    
    DefaultTableModel TablaModelo = new DefaultTableModel();
    TablaModelo.setRowCount(0);
    TablaModelo.setColumnCount(0);
    
        TablaModelo.addColumn("ID");
        TablaModelo.addColumn("APELLIDOS");
        TablaModelo.addColumn("NOMBRE");
        TablaModelo.addColumn("TELEFONO");
    try
    {
        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        result = sentencia.executeQuery("select * from empleados");  
        //return result;
        
        while(result.next()){
            TablaModelo.addRow(new Object[]{result.getInt("idEmpleado"),
            result.getString("Apellidos"),
            result.getString("Nombre"),
            result.getString("Telefono")});
        }
        return TablaModelo;
    }
    
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, "No se Pudo Listar Empleados...."+e.getMessage());
        return null;
    }
}


public void Actualizar(int codigo, String Apellidos, String Nombre, String telefono)
{
        try
        {
        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        sentencia.executeQuery("Update empleados set apellidos ="+"'"+Apellidos+"',nombre="+"'"+Nombre+"',telefono="+"'"+telefono+"' where idempleado="+"'"+codigo+"'");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo Actualizar..."+ex.getMessage());
        }
          
}

public void Guardar(int codigo, String Apellidos, String Nombre, String Telefono){
        try
        {
        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        sentencia.executeQuery("Insert into empleados values ("+" '"+codigo+"',"+"'"+Apellidos+"',"+"'"+Nombre+"',"+"'"+Telefono+"')");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo guardar..."+ex.getMessage());
        }   
}
public void Eliminar(int codigo, String Apellidos, String Nombre, String Telefono)
{
        try
        {
        Conexion nuevaConexion = new Conexion();
        MyConexion = nuevaConexion.Conectar();
        Statement sentencia = MyConexion.createStatement();
        sentencia.executeQuery("delete from Empleados where idEmpleado="+"'"+codigo+"'");
        }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "No se pudo eliminar..."+ex.getMessage());
        }
          
}
}
