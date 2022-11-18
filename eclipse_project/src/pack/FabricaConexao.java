package pack;

import java.sql.*;

public final class FabricaConexao {

    Connection connection;
    String url = "jdbc:mysql://localhost:3306/?user=root&password=";

    // constructor
    public FabricaConexao(boolean... log) {
        // default log is false
        boolean logEnabled = false;
        if (log.length > 0)
            logEnabled = log[0];

        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url);
            if (connection != null) {
                if (logEnabled)
                    System.out.println("Connected!");
            } else {
                if (logEnabled)
                    System.out.println("Not connected?");
            }
        } catch (Exception e) {
            //
        }

    }

    public Connection getConexao() throws Exception {
        // open connection if closed
        if (connection.isClosed())
            connection = DriverManager.getConnection(url);

        return connection;
    }
}
