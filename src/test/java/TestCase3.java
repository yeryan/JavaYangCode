import com.yzk18.commons.IOHelpers;

import java.util.Arrays;

public class TestCase3 {
    public static void main(String[] args) {

        String [] FileDir = IOHelpers.getFilesRecursively("D:\\data\\Summary","txt");
        System.out.println(Arrays.toString(FileDir));
        for(String file : FileDir){
            String [] result = IOHelpers.readAllLines(file);
            System.out.println(Arrays.toString(result));
            IOHelpers.appendAllLines("D:\\data\\Summary\\1.CSV",  result);
        }
    }
}
