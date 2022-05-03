package p05;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author: ymm
 * @date: 2022/5/3
 * @version: 1.0.0
 * @description:
 */
public class PersonFieldTest {

    public static void main(String[] args) {
        Class<?> cls = null;
        try {
            cls = Class.forName("p05.Person");
            System.out.println("cls = " + cls);

            Constructor<?> constructor = cls.getConstructor(String.class, int.class);
            Object obj = constructor.newInstance("zhangfei", 11);
//            Field name = cls.getField("name");
            Field declaredField = cls.getDeclaredField("name");
            System.out.println("declaredField.getName() = " + declaredField.getName());
//            System.out.println("name = " + name.getName());
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
