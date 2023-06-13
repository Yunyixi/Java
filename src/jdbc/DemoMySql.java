package jdbc;

import java.sql.*;

public class DemoMySql {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            //注册数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //1.获取连接对象
            String url = "jdbc:mysql://127.0.0.1:3306/world?serverTimezone=UTC&userUnicode=true&charsetEncoding=utf-8";
            String user = "root";
            String password = "000000";
            connection = DriverManager.getConnection(url, user, password); //得到数据库连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet = null;
        }
        if (statement == null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = null;
        }
        if (connection == null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }
}
