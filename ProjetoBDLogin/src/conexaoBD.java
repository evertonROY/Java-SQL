import java.sql.Connection;
import java.sql.DriverManager;

public class conexaoBD {
 
   private static final String USERNAME = "root";
 

   private static final String PASSWORD = "87578662everton";
 

   private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/entrar";


 public static Connection createConnectionToMySQL() throws Exception{
    Class.forName("com.mysql.cj.jdbc.Driver"); 

  
    Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

    return connection;
 }
}