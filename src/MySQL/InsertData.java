package MySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) {
        Connection conn = Connector.connect();
        try {
            assert conn != null;
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM `java-2022`.`index`";
            ResultSet res = stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
