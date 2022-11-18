import com.yzk18.GUI.GUI;
import com.yzk18.commons.IOHelpers;


public class Case4 {
    public static void main(String[] args) {
        String sourDir = GUI.dirOpenBox("选择要统计的文件夹");
        String[] files = IOHelpers.getFilesRecursively(sourDir, "txt");
        int count = 1;
        for (String file : files) {
            String words = IOHelpers.readAllText(file);
            String[] word_num = words.split(" ");
            count += word_num.length;
        }
        System.out.println(count);
    }
}
