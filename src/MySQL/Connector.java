package MySQL;
import java.sql.*;

public class Connector {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    static final String USERNAME = "root";
    static final String PASSWORD = "root";

    static Connection conn = null;

    public static Connection connect() {
        if (conn != null) {
            System.out.println("Connection already exist");
            return null;
        }
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            return conn;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(){
        if (conn == null){
            System.out.println("Connection does NOT exist");
            return;
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
