package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class conexion {

    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url = "jdbc:sqlserver://DESKTOP-EMGKJOF:1433;databaseName=esfe2;user=usuarioSQL;password=321;encrypt=false;trustServerCertificate=false";

    public String getDriver() { //getDriver()devuelve el valor de la variable driver.
        return driver;
    }

    //setDriver(String driver)establece el valor driver con el valor pasado como argumento.
    public void setDriver(String driver) {  
        this.driver = driver;
    }
    
    //getUrl()devuelve el url.
    public String getUrl() {
        return url;
    }

//setUrl (String url)establece el valor de la variable url con el valor pasado como argumento
    public void setUrl(String url) {
        this.url = url;
    }

    public boolean conectar() {
        Connection conexion = null;
        try {
            Class.forName(driver);
            
            // Establecer propiedades de la conexión
            Properties connectionProps = new Properties();
            connectionProps.put("encrypt", "false");
            connectionProps.put("trustServerCertificate", "true");
            
            // Establecer conexión
            conexion = DriverManager.getConnection(url, connectionProps);
            
            System.out.println("Conexión exitosa a la base de datos.");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador: " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return false;
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
}
