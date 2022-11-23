import com.yzk18.commons.IOHelpers;
import com.yzk18.docs.ExcelHelpers;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class Case12 {
    public static void main(String[] args) {
        String[] path = IOHelpers.getFilesRecursively("D:\\data\\test\\Case12\\合并","xlsx");
        Workbook save = ExcelHelpers.createXLSX();
        Sheet newSheet = save.createSheet();
        ExcelHelpers.setCellValue(newSheet,0,0,"FileName");
        ExcelHelpers.setCellValue(newSheet,0,1,"Name");
        ExcelHelpers.setCellValue(newSheet,0,2,"length");
        int row_num = 1;    //写入的行数
        for(String file : path){
            String fileName = IOHelpers.getFileNameWithoutExtension(file);
            Workbook workbook = ExcelHelpers.openFile(file);
            Sheet sheet = workbook.getSheetAt(0);
            int rowIndex = sheet.getLastRowNum();
            for(int i = 1;i <= rowIndex;i++){      //遍历每个sheet，i为其中一个sheet第i行，该sheet总共有rowIndex行
                String name = ExcelHelpers.getCellStringValue(sheet,i,0);
                Double length = ExcelHelpers.getCellDoubleValue(sheet,i,1);
                ExcelHelpers.setCellValue(newSheet,row_num,0,fileName);
                ExcelHelpers.setCellValue(newSheet,row_num,1,name);
                ExcelHelpers.setCellValue(newSheet,row_num,2,length);
                row_num++;
            }
            ExcelHelpers.close(workbook);
        }
        ExcelHelpers.saveToFile(save,"D:\\data\\test\\Case12\\合并\\save.xlsx");
        ExcelHelpers.close(save);
    }
}
