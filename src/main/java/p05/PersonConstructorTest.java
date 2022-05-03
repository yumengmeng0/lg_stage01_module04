package p05;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author: ymm
 * @date: 2022/5/3
 * @version: 1.0.0
 * @description:
 */
public class PersonConstructorTest {
    public static void main(String[] args) {

        // 1.原始方式以无参形式构造对象
        Person person = new Person();
        System.out.println("person = " + person);

        // 2.利用反射构造无参形式的对象
        Class<?> cls = null;
        try {
            cls = Class.forName("p05.Person");
            System.out.println("cls = " + cls);  // cls = class p05.Person
//            Object o = cls.newInstance();  // 过时
            Constructor<?> constructor = cls.getConstructor();
            Object o = constructor.newInstance();
            System.out.println("o = " + o);
            System.out.println("o = " + o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("***********************************");

        // 3.有参方式构造对象
        Constructor<?> constructor = null;
        try {
            constructor = cls.getConstructor(String.class, int.class);

            Object o = constructor.newInstance("zhangfei", 11);
            System.out.println("o = " + o); // o = Person{name='zhangfei', age=11}
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("***********************************");
        // 获取所有的构造方法
        Constructor<?>[] constructors = cls.getConstructors();
        for (Constructor<?> constructor1 : constructors) {
            System.out.println("constructor1.getName() = " + constructor1.getName());
            System.out.println("constructor1.getModifiers() = " + constructor1.getModifiers());
            Class<?>[] parameterTypes = constructor1.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("parameterType = " + parameterType);
            }
        }


    }
}
