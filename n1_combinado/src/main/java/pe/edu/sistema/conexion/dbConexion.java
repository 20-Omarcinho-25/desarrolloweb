package pe.edu.sistema.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConexion {

    static String url="jdbc:mysql://localhost:3306/sideral";
    static String user="root";
   static String pass="";
    
    public static Connection conectar()
    {
       Connection con=null;
       try
       {
            Class.forName("com.mysql.cj.jdbc.Driver");
       con=DriverManager.getConnection(url,user,pass);
           System.out.println("Conexión exitosa");
       }catch(SQLException e)
       {
        e.printStackTrace();
       } catch (ClassNotFoundException ex) {
            System.getLogger(dbConexion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
       
       return con;
               
    }
}
