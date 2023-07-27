/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;
import java.util.*;
/**
 *
 * @author MINEDUCYT
 */
public class UsuarioDAO {
    PreparedStatement ps;           //preparar las sentencias a ejecutar
    ResultSet rs;                   //leer resultados del select
    conexion cn = new conexion();   //parametros de conexion
    Usuario u;                     //crear usuario
    
    //Declaración de un método llamado "con" que devuelve un objeto Connection 
    //y puede lanzar las excepciones SQLException y ClassNotFoundException.
    Connection con() throws SQLException, ClassNotFoundException   
          
     //Se utiliza el método estático "forName" de la clase Class para cargar 
     //dinámicamente el controlador de la base de datos especificado por la variable "cn.getDriver()".  
    {      
        Class.forName(cn.getDriver());
        return DriverManager.getConnection(cn.getUrl());//Se utiliza el método estático "getConnection" de la clase 
                                                           //DriverManager para obtener una instancia de conexión con la base de datos.
                                                           // El método recibe la URL de conexión proporcionada por la variable "cn.getUrl()".
                                                   // Esta línea devuelve el objeto Connection que representa la conexión con la base de datos.
    }
    
    public ArrayList<Usuario> mostrar()
    {
        ArrayList<Usuario> al = new ArrayList<Usuario>(); //Se crea un nuevo ArrayList llamado "al" que almacenará objetos de tipo Usuario.
        try
        {
 //  Se prepara una sentencia SQL para seleccionar todos los registros de la tabla "usuario" 
 //utilizando el objeto Connection retornado por el método "con()".
            ps = con().prepareStatement("select * from usuario");
            rs = ps.executeQuery();
            while(rs.next())
            {
                u = new Usuario (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
                al.add(u);
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally
        {
            try
            {
                rs.close();
                ps.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
 // Se devuelve el ArrayList "al" que contiene los objetos Usuario recuperados de la base de datos.       
        return al;
    }
    
    public int insertar(Usuario u)
    {
        int n=0;
        try
        {
            ps = con().prepareStatement("insert into Usuario(nombre, apellido, edad, genero, correo, telefono) values(?, ?, ?, ?, ?, ?)");
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setInt(3, u.getEdad());
            ps.setString(4,u.getGenero());
            ps.setString(5, u.getCorreo());
            ps.setString(6, u.getTelefono());
            
            
            n = ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                ps.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        return n;
    }   
    
    public int modificar(Usuario u)
    {
        int n=0;
        try
        {
            ps = con().prepareStatement("update usuario set nombre = ?, apellido = ?, edad = ?, genero = ?, correo = ?, telefono = ? where id = ?");
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setInt(3, u.getEdad());
            ps.setString(4, u.getGenero());
            ps.setString(5, u.getCorreo());
            ps.setString(6, u.getTelefono());
                ps.setInt(7, u.getId()); // Establece el ID del usuario en el parámetro 7

            
            n = ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                ps.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        return n;
    }
    public int eliminar(Usuario u)
    {
        int n=0;
        try
        {
            ps = con().prepareStatement("delete from usuario where id = ?");
            ps.setInt(1, u.getId());
            
            n = ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                ps.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        return n;
    }
    

    
}
