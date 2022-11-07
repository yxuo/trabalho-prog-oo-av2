package Package;

import java.sql.*;

public class ExcluirFunc {
    
    // ExcluirFunc, using FabricaConexao
    public static Exception run(FabricaConexao fabricaConexao, String dbName, int codigo) throws Exception {
        String tableName = "func";
        Connection connection = fabricaConexao.getConexao();
        Statement statement = connection.createStatement();
        try {
            String sql;
            
            // Enter database db
            sql = "USE " + dbName;
            statement.executeUpdate(sql);
            
            // Delete from table
            sql = "DELETE FROM " + tableName + " WHERE codigo = " + codigo;
            statement.executeUpdate(sql);
            
            // Response
            statement.close();
            return null;
        } catch (Exception e) {
            statement.close();
            // System.out.println("Error on delete: " + e);
            return e;
        }
    }
    
    
}
