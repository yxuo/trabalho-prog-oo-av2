package Package;

import java.sql.*;

public class ConsultarFunc {

    // consultarFunc
    public static Func run(FabricaConexao fabricaConexao, String dbName, int codigo) throws Exception {
        String tableName = "func";
        Connection connection = fabricaConexao.getConexao();
        Statement statement = connection.createStatement();
        try {
            String sql;

            // Enter database db
            sql = "USE " + dbName;
            statement.executeUpdate(sql);

            // Select from table
            sql = "SELECT * FROM " + tableName + " WHERE codigo = " + codigo;
            ResultSet rs = statement.executeQuery(sql);

            // Response
            if (rs.next()) {
                Func func = new Func(rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("cargo"),
                        rs.getString("end"));
                statement.close();
                return func;
            } else {
                statement.close();
                return null;
            }
        } catch (Exception e) {
            statement.close();
            System.out.println("Error on select!");
            return null;
        }
    }
    
}
