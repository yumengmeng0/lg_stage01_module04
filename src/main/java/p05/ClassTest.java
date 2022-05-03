package p05;

/**
 * @author: ymm
 * @date: 2022/5/3
 * @version: 1.0.0
 * @description:
 */
public class ClassTest {

    public static void main(String[] args) {

        // 1.用数据类型.class的方式获取对应类的Class对象
        Class cls = String.class;

        System.out.println("cls = " + cls); // cls = class java.lang.String

        System.out.println("***********************************");
        // 2.使用对象.class的方式获取对应的Class对象
        String hello = new String("hello");
        cls = hello.getClass();
        System.out.println("cls = " + cls);

        // 基本数据类型的变量不能调用方法
        int num = 2;
//        num.getClass() 错误
        System.out.println("***********************************");
        // 3.使用包装类.TYPE的方式获取对应基本数据类型的Class对象
        cls = Integer.TYPE;
        System.out.println("cls = " + cls); // cls = int

        cls = Integer.class;
        System.out.println("cls = " + cls); // cls = class java.lang.Integer

        System.out.println("***********************************");
        // 4.调用Class类中的forName方法来获取对应的Class对象
        try {
            cls = Class.forName("java.lang.String"); // cls = class java.lang.String
            System.out.println("cls = " + cls);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("***********************************");

        // 5.使用类加载器ClassLoader获取Class对象信息
        ClassLoader classLoader = ClassTest.class.getClassLoader();
        System.out.println("classLoader = " + classLoader);
        try {
            cls = classLoader.loadClass("java.lang.String");
            System.out.println("cls = " + cls); // cls = class java.lang.String
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
