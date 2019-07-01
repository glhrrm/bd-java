package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

     public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String urlBD = "jdbc:oracle:thin:@200.132.53.144:1521:orcl11";
            return DriverManager.getConnection(urlBD, "usr75", "usr75");
        } catch (SQLException e) {
            System.out.println("Exceção SQL");
        } catch (ClassNotFoundException e) {
            System.out.println("Exceção Classe não encontrada");
        }
        return null;
    }
    
}
