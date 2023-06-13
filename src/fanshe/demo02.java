package fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class demo02 {
    public static void main(String[] args) throws Exception {
        Class<?> c1 = null;
        System.out.println("*----- 无参构造 -----*");
        c1 = Class.forName("fanshe.DemoStudent");
        //用反射创建一个对象，并且强转 对象
        DemoStudent demoStudent = (DemoStudent) c1.newInstance();
        demoStudent.setName("小发");
        demoStudent.setId(1001);
        demoStudent.setAge(20);
        System.out.println(demoStudent);
        System.out.println("*----- 有参构造 -----*");
        Constructor<?> constructor[] = null;
        constructor = c1.getConstructors();
        for (Constructor constructor1 : constructor) {
            System.out.println("得到的构造方法：" + constructor1);
        }
        //调用有参构造方法，并且传入参数，生成对象并初始化
        DemoStudent demoStudent1 = (DemoStudent) constructor[1].newInstance(1002, "小发2", 18);
        System.out.println(demoStudent1);
        System.out.println("*----- 获取该类的全部方法 -----*");
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("获取方法名：" + method.getName());
        }
        System.out.println("*----- 用反射的方式调用类里面的方法 -----*");
        Method method = c1.getMethod("show");
        method.invoke(demoStudent1);
        System.out.println("*----- 用反射的方式获取全部的属性 -----*");
        Field[] fields = c1.getDeclaredFields(); //获得所有的属性
        for (Field field : fields) {
            Class<?> r = field.getDeclaringClass();
            int mo = field.getModifiers();
            String priv = Modifier.toString(mo);
            System.out.println("获得属性：" + r.getName() + "," + field.getName());
        }
    }
}
