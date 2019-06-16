import java.sql.*;

public class OracleTest {

    public static void main(String[] args) {
        try {
            //create jdb connection obj and load class
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String urlBD = "jdbc:oracle:thin:@200.132.53.144:1521:orcl11";
            Connection connection = DriverManager.getConnection(urlBD, "usr76", "jurley");

            System.out.println("Conexão estabelecida com " + connection);

            //create statement obj
            Statement statement = connection.createStatement();

            //Exec query
            ResultSet resultSet = statement.executeQuery("select * from cargo");

            //print database table records
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " +
                        resultSet.getString(2) + " " +
                        resultSet.getString(3));
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Exceção de SQL");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
