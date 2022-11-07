package Package;

// import com.mysql.cj.jdbc.*;
import java.sql.*;

public class CriarBanco {

    public static int run(FabricaConexao fabricaConexao, String dbName) throws Exception {
        Connection connection = fabricaConexao.getConexao();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=");
            Statement statement = connection.createStatement();
            String sql = "CREATE DATABASE" + dbName;
            statement.executeUpdate(sql);
            return 0;
        } catch (Exception e) {
            // System.out.println("Database already exists!");
            return 1;
        }
    }
}
