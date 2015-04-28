/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


/**
 *
 * @author JUANCARLOS
 */
public class EntidadDAO 
{
    private String tabla;
    private PreparedStatement comando;
    private Connection conexion;

    public EntidadDAO(String nTabla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet darRegistros(String criterio, String valor) throws SQLException
    {
        String sql = "call darRegistros(?,?,?)";
        comando = conexion.prepareStatement(sql);
        comando.setString(1,tabla);
        comando.setString(2,criterio);
        comando.setString(3,valor);
        ResultSet r = comando.executeQuery();
        return r;
    }
    
    public Object[] darEtiquetas(String criterio, String valor) throws SQLException
    {
        ResultSet rs = darRegistros(criterio, valor);
        ResultSetMetaData metaDatos = rs.getMetaData();
        int columnas = metaDatos.getColumnCount();
        Object[] etiquetas = new Object[columnas];
        for(int i=0;i<columnas;i++)
        {
            etiquetas[i] = metaDatos.getCatalogName(i+1);
        }
        return etiquetas;
    }
public static void main(String[] args) throws SQLException
{
    FuenteDeDatos f = new FuenteDeDatos();
    f.crearConexion();
}
}
