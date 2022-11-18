import com.yzk18.commons.IOHelpers;

import java.util.Arrays;

public class Case1 {
    public static void main(String[] args) {
        String[] resultA = IOHelpers.readAllLines("D:/data/Summary/2.txt");
        for (int i = 0; i < resultA.length; i++) {
            String[] a = resultA[i].split(",");
            String out = a[0] + "你好，你的语文成绩为" + Double.parseDouble(a[1]) + "，你的数学成绩为" + Double.parseDouble(a[2]) +
                    "，你的外语成绩为" + Double.parseDouble(a[3]) + "，平均分为" + (Double.parseDouble(a[1]) + Double.parseDouble(a[2]) + Double.parseDouble(a[3])) / 3;
            System.out.println(out);
            IOHelpers.writeAllText("D:/data/Summary/" + a[0] + ".txt", out);
        }


        String[] result = IOHelpers.readAllLines("D:/data/Summary/2.txt");
        for (int i = 0; i < result.length; i++) {
            String[] a = result[i].split(",");
            String name = a[0].replaceAll(" ", "");
            double sum = 0;
            double average = 0;
            int j = 1;
            while (j < a.length) {
                double re = Double.parseDouble(a[j]);
                sum += re;
                average = sum / j;
                j++;
            }
            String out = name + "，平均分为" + average + "\n";
            System.out.println(out);
            IOHelpers.appendAllText("D:/data/Summary/平均成绩.txt", out);
        }
    }
}
