package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//数据表的服务类，关于数据库表的增删查改都可以在这里
public class DemoService {
    /**
     * 查询数据表的数据，最终返回一个集合
     */
    //查询所有的数据
    BaseDao baseDao = new BaseDao();

    public List<Demo02.Student> getAllStudent() {
        //得到集合，这集合里面存对象
        ArrayList<Demo02.Student> arrayList = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DemoMySql.getConnection();
            statement = connection.createStatement();
            String sql = "select * from student"; //使用Statement执行SQL语句
            resultSet = statement.executeQuery(sql); //查询 SQL语句，得到结果
            while (resultSet.next()) {
                //获取数据库的表数据---添加到集合
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Demo02.Student student = new Demo02.Student(id, name, age);
                //数据库数据，添加集合
                arrayList.add(student);
            }
        } catch (Exception e) { //引用最上层的父类异常,可以捕获所有的异常子类
            e.printStackTrace(); //打印异常
        } finally { //回收数据库资源
            DemoMySql.close(resultSet, statement, connection); //调用Demo02的close方法，关闭资源
        }
        return arrayList;
    }

    //查询id开头的数据
    public Demo02.Student getStudentId01(int id) {
        //得到集合，这集合里面存对象
        ArrayList<Demo02.Student> arrayList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DemoMySql.getConnection();
            String sql = "select * from student where id=?";//使用Statement执行SQL语句
            preparedStatement = connection.prepareStatement(sql); //查询 SQL语句，得到结果
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Demo02.Student student = new Demo02.Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"));
                //数据库数据，添加集合
                arrayList.add(student);
            }
        } catch (Exception e) { //引用最上层的父类异常,可以捕获所有的异常子类
            e.printStackTrace(); //打印异常
        } finally { //回收数据库资源
            //DemoMySql.close(resultSet, statement, connection); //调用Demo02的close方法，关闭资源
        }
        if (arrayList != null && arrayList.size() > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    public Demo02.Student getStudentId02(int id) {
        Demo02.Student student = null;
        String sql = "select * from student where id=?";
        Object[] objects = {id};
        List<Demo02.Student> studentList = baseDao.executeQuery(sql, objects, Demo02.Student.class);
        if (studentList.size() > 0) {
            student = studentList.get(0);
        }
        return student;
    }
}
