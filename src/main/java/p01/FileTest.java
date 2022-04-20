package p01;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @author: ymm
 * @date: 2022/4/19
 * @version: 1.0.0
 * @description:
 */
public class FileTest {

    public static void main(String[] args) {
        File file = new File("e:/test/a.txt");
        if (file.exists()) {
            System.out.println("file.getName() = " + file.getName());
        }

        if (file.isDirectory()) {
            System.out.println("file.isDirectory() = " + file.isDirectory());
        }


        // 创建和删除目录
        File file1 = new File("e:/test1/");
        if (file1.exists()) {
            System.out.println("file1.getName() = " + file1.getName());
            System.out.println(file1.delete() ? "目录删除成功" : "目录删除失败");
        } else {
            System.out.println(file1.mkdir() ? "目录创建成功" : "目录创建失败");
        }

        File file2 = new File("e:/test1/tt");
        file2.mkdirs(); // 创建多级目录


        System.out.println(" ============");
        // 遍历指定目录所有文件
        File users = new File("E:\\Users\\ben\\Documents\\Unreal Projects\\城市示例");

        listFiles("E:\\Users\\ben\\Documents\\Unreal Projects\\城市示例");

        System.out.println(" ============");

/*        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        };*/

        FileFilter fileFilter = (File pathname) -> {
            return pathname.getName().endsWith(".txt");
        };


        File[] files = users.listFiles(fileFilter);
        for (File file3 : files) {
            System.out.println("file3 = " + file3);
        }


        System.out.println(" ============");

    }

    public static void listFiles(String pathname, FileFilter fileFilter) {


    }


    /**
     * 列出当前目录下所有文件或目录
     *
     * @param pathname
     */
    public static void listFiles(String pathname) {

        File file = new File(pathname);

        File[] files = file.listFiles();

        for (File f : files) {
            if (f.exists()) {
                String name = f.getAbsolutePath();
                if (f.isFile()) {
                    System.out.println(name);
                }
                if (f.isDirectory()) {
                    System.out.println("[" + name + "]");
                }
            }
        }
    }

}
