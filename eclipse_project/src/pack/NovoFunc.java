package pack;

import java.sql.*;

public class NovoFunc {
    public static Exception run(FabricaConexao fabricaConexao, String dbName, Func func) throws Exception {
        String tableName = "func";
        Connection connection = fabricaConexao.getConexao();
        Statement statement = connection.createStatement();
        try {
            String sql;

            // Enter database db
            sql = "USE " + dbName;
            statement.executeUpdate(sql);
            
            // insert into table
            sql = "INSERT INTO " + tableName + " (codigo, nome, cargo, end) " +
            "VALUES ('" + func.getCodigo() + "', '" + func.getNome() + "', '" + func.getCargo() + "', '" + func.getEnd() + "')";
            statement.executeUpdate(sql);

            // Response
            statement.close();
            return null;
        } catch (Exception e) {
            statement.close();
            return e;
        }
    }
}
