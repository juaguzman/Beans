/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author JUANCARLOS
 */
public class FuenteDeDatos
{
private Connection conexion=null;
private String url;
private String baseDeDatos;
private String usuario;
private String clave;

public FuenteDeDatos()
{
   baseDeDatos="fabrica";
   clave="mysql";
   usuario="root";
   url="jdbc:mysql://localhost/"+baseDeDatos;
}
 
public Connection crearConexion() throws SQLException
{
    try 
    {
        Class.forName("com.mysql.jdbc.Driver");
        conexion=DriverManager.getConnection(url,usuario,clave);
        System.out.println("conexion realizada correctamente");
    }
    catch (ClassNotFoundException ex)
    {
     System.out.println(ex.getMessage());
    } 
    catch(SQLException ex2)
            {
                System.out.println(ex2.getMessage());
            }
    return conexion;
}
}
