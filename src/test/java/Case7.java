import com.yzk18.commons.IOHelpers;
import com.yzk18.docs.PDFHelpers;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.util.LinkedHashMap;
import java.util.Set;

public class Case7 {
    public static void main(String[] args) {
        String[] filePath = IOHelpers.getFilesRecursively("D:\\data\\test\\Case7","pdf");
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String path : filePath) {
            PDDocument pdf = PDFHelpers.openFile(path);
            String text = PDFHelpers.parseText(pdf).toLowerCase();
            String[] words = text.split("\s|\\,|\\.|\\?|\\!|\\&|\\—|\\:");
            for(String word : words) {
                Integer num = map.get(word);
                if(num == null) {
                    map.put(word, 1);
                } else {
                    map.put(word, num + 1);
                }
            }
            PDFHelpers.close(pdf);
        }
        String lines = "";
        for(String word : map.keySet()) {
            int freq = map.get(word);
            System.out.println(word + "\t" + freq);
            lines = lines + word + " "+ freq +"\r";
        }
        IOHelpers.writeAllText("D:\\data\\test\\Case7\\1.txt", lines);
    }
}
