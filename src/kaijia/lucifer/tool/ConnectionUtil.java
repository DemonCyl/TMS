package kaijia.lucifer.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Description:
 * @Author: 尉宇晚臨江
 * @CreateTime: 2017/8/9  下午 03:39
 */
public class ConnectionUtil {

    private static final String URL = "jdbc:oracle:thin:@10.131.119.128:1521:TOPSTD"; //   TOPTEST   TOPPROD  10.131.118.50
    private static final String USERNAME = "kaijia";
    private static final String PASSWORD = "cstkaijia1234";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void releaseResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void releasePreparedStatement(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null)
                preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void releaseConnection(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
