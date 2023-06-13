package gather;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Student> list = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        init();
        int n = 0;
        while (n != 5) {
            System.out.println("--------欢迎使用学生管理系统--------");
            System.out.println("系统的功能如下，请选择：");
            System.out.println("1：查询功能" + " " + "2：添加功能" + " " + "3：删除功能" + " " + "4：修改功能" + " " + "5：退出功能");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    inquirestudent();
                    break;
                case 2:
                    addstudent();
                    break;
                case 3:
                    deletestudent();
                    break;
                case 4:
                    modifystudent();
                    break;
                case 5:
                    System.out.println("== 退出功能 ==");
                    return;
                default:
                    System.out.println("输入有误，请重新输入！");
            }

        }
    }

    //初始化数据
    public static void init() {
        list.add(new Student(10001, "小苏", 20, "柳州官塘大道"));
        list.add(new Student(10002, "小永", 20, "柳州官塘大道"));
        list.add(new Student(10003, "小发", 20, "柳州官塘大道"));
    }

    //查询所有学生
    private static void inquirestudent() {
        if (list.isEmpty()) {
            System.out.println("没有学生信息");
        } else {
            for (int i = 0; i < list.size(); i++) {
                Student student = list.get(i); //alt+回车补全代码
                System.out.println(student);
            }
        }
    }

    //添加学生
    private static void addstudent() {
        System.out.println("== 添加学生信息 ==");
        System.out.println("输入9退出添加，请输入学号：");
        int id = sc.nextInt();

        for (Student student : list) {
            if (id == 9) {
                return;
            }
            if (student.getStudentID() == id) {
                System.out.println("学号已存在，添加失败");
                return;//方法结束
            }
        }
        System.out.println("请输入姓名：");
        String name = sc.next();
        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        System.out.println("请输入地址：");
        String address = sc.next();
        //创建学生对象
        Student sc = new Student(id, name, age, address);
        //接入集合
        list.add(sc);
        System.out.println("添加成功");

    }

    //删除学生数据
    private static void deletestudent() {
        System.out.println("== 删除学生信息 ==");
        System.out.println("请输入需要删除的学生学号：");
        int id = sc.nextInt();
        for (Student student : list) {
            if (student.getStudentID() == id) {
                list.remove(student);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("学号不存在，删除失败");
    }

    //修改学生数据
    private static void modifystudent() {
        System.out.println("== 修改学生信息 ==");
        System.out.println("请输入需要修改的学生学号：");
        int id = sc.nextInt();
        for (Student student : list) {
            if (student.getStudentID() == id) {
                System.out.println("请输入新的姓名：");
                String name = sc.next();
                System.out.println("请输入新的年龄：");
                int age = sc.nextInt();
                System.out.println("请输入新的地址：");
                String address = sc.next();
                student.setName(name);
                student.setAge(age);
                student.setAddress(address);
                System.out.println("修改成功");
                return;
            }
        }
        System.out.println("学号不存在，修改失败");
    }

}

