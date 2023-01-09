package util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TxtReader {
    public static ArrayList<String> read(String path) {
        ArrayList<String> res = new ArrayList<>();
        try {
            File myFile = new File(path);  //通过字符串创建File类型对象，指向该字符串路径下的文件
            if (myFile.isFile() && myFile.exists()) {  //判断文件是否存在
                InputStreamReader Reader = new InputStreamReader(new FileInputStream(myFile), StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(Reader);
                String lineTxt;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    res.add(lineTxt);
                }
                Reader.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return res;
    }
}
