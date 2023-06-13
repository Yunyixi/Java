package jdbc;

import java.sql.*;
import java.util.List;

public class Demo02 {
    public static void main(String[] args) throws SQLException {
        DemoService demoService = new DemoService();
        List<Student> arrayList = demoService.getAllStudent();
        System.out.println("*-- MySql查询表所有数据 --*");
        for (Student student : arrayList) {
            System.out.println("*-集合内容：" + student);
        }
        System.out.println("*-查询按id开头的数据：");
        Student student01 = demoService.getStudentId01(1003);
        System.out.println("--* " + student01);
        System.out.println("*-用BaseDao类查询按id开头的数据：");
        Student student02 = demoService.getStudentId02(1003);
        System.out.println("--* " + student02);
    }

    public static class Student {
        private int id;
        private String name;
        private int age;

        public Student() {
        }

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "学生：" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age + ";";
        }
    }
}
