package Package;

// import com.mysql.cj.*;
import java.sql.*;

public class CriarTabelaFunc {
    public static int run(FabricaConexao fabricaConexao, String dbName) throws Exception {
        String tableName = "func";
        Connection connection = fabricaConexao.getConexao();
        Statement statement = connection.createStatement();
        try {
            // Class.forName(Connection.class.getName());
            String sql;

            // Enter database db
            sql = "USE " + dbName;
            statement.executeUpdate(sql);

            // Create table func if not exists
            sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                    "codigo INT AUTO_INCREMENT PRIMARY KEY," +
                    "nome VARCHAR(80) NOT NULL," +
                    "cargo VARCHAR(20) NOT NULL," +
                    "end VARCHAR(80) NOT NULL)";
            statement.executeUpdate(sql);
            // System.out.println("Table created!");
            statement.close();
            return 0;
        } catch (Exception e) {
            // System.out.println("Table already exists!");
            statement.close();
            return 1;
        }

    }
}
