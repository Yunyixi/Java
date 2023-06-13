package jdbc;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DemoMySql.getConnection();
            statement = connection.createStatement();
            String sql = "select * from student"; //使用Statement执行SQL语句
            resultSet = statement.executeQuery(sql); //查询 SQL语句，得到结果
            System.out.println("*--*-----* MySql *-----*--*");
            System.out.println("****************************");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("- Mysql数据：" + id + " -- " + name + " -- " + age);
            }
            System.out.println("****************************");
        } catch (Exception e) { //引用最上层的父类异常,可以捕获所有的异常子类
            e.printStackTrace(); //打印异常
        } finally { //回收数据库资源
            DemoMySql.close(resultSet, statement, connection); //调用Demo02的close方法，关闭资源
        }
    }
}
