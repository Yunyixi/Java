package fanshe;

import gather.Student;

public class Demo01 { //Java反射机制
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c1 = null;
        Class<?> c2 = null;
        Class<?> c3 = null;
        c1 = Class.forName("fanshe.DemoStudent");
        c2 = new Student().getClass();
        c3 = Student.class;
        System.out.println("类名称" + c1.getName());
        System.out.println("类名称" + c1.getName());
        System.out.println("类名称" + c1.getName());
    }

}
