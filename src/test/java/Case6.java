import com.yzk18.commons.IOHelpers;
import com.yzk18.docs.PDFHelpers;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import java.util.List;

public class Case6 {
    public static void main(String[] args) {
        PDDocument pdf = PDFHelpers.openFile("D:\\data\\test\\1.pdf");
        String content = PDFHelpers.parseText(pdf);
        IOHelpers.writeAllText("D:\\data\\test\\h.txt", content);
        int page_num = pdf.getNumberOfPages();
        System.out.println(page_num);
        int image_num = 0;
        for(int i = 0; i < page_num; i++){
            PDPage page = pdf.getPage(i);
            List<byte []> pic = PDFHelpers.parseImages(page , "png" );
            for(byte [] bytes :pic){
                IOHelpers.writeAllBytes("D:\\data\\test\\"+ image_num +".png",bytes);
                image_num++;
            }
        }
        PDFHelpers.close(pdf);

    }
}
