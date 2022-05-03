package p04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author: ymm
 * @date: 2022/5/3
 * @version: 1.0.0
 * @description:
 */
public class URLTest {

    public static void main(String[] args) {
        // 1.使用参数指定的字符串来构造对象
        try {
            URL url = new URL("http://www.baidu.com");
            // 2.获取相关信息并打印
            /**
             * url.getProtocol() = http
             * url.getHost() = www.baidu.com
             * url.getPort() = -1
             */
            System.out.println("url.getProtocol() = " + url.getProtocol());
            System.out.println("url.getHost() = " + url.getHost());
            System.out.println("url.getPort() = " + url.getPort());

            // 3.建立连接读取信息打印
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println("str = " + str);
            }

            // 断开连接
            urlConnection.disconnect();

        } catch (MalformedURLException e) {  // malformed 畸形的
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
