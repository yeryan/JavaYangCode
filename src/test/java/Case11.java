import com.yzk18.docs.ExcelHelpers;
import com.yzk18.docs.WordTemplateRenderer;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.time.LocalDate;
import java.util.HashMap;
//按给定word模板生成工资条
public class Case11 {
    public static void main(String[] args) {
        Workbook salary = ExcelHelpers.openFile("D:\\data\\test\\Case11\\1.xlsx");
        HashMap<String,Object> data = new HashMap<>();
        String mode = "D:\\data\\test\\Case11\\模板.docx";
        int sheet_num = salary.getNumberOfSheets();
        for(int sheetIndex = 0; sheetIndex < sheet_num; sheetIndex++ ){
            Sheet sheet = salary.getSheetAt(sheetIndex);
            String department = sheet.getSheetName();
            int row_num = sheet.getLastRowNum();
            for(int rowIndex = 1; rowIndex <= row_num; rowIndex++){
                Row row = sheet.getRow(rowIndex);
                String name = ExcelHelpers.getCellStringValue(sheet,rowIndex,0);
                String num = ExcelHelpers.getCellStringValue(sheet,rowIndex,1);
                Double base = ExcelHelpers.getCellDoubleValue(sheet,rowIndex,2);
                Double add = ExcelHelpers.getCellDoubleValue(sheet,rowIndex,3);
                Double min = ExcelHelpers.getCellDoubleValue(sheet,rowIndex,4);
                data.put("[标题]","工资条");
                data.put("[姓名]",name);
                data.put("[工号]",num);
                data.put("[基本工资]",base);
                data.put("[奖金]",add);
                data.put("[罚款]",min);
                data.put("[合计]",base + add -min);
                data.put("[部门]",department);
                data.put("[日期]", LocalDate.now());
                String output = "D:\\data\\test\\Case11\\工资条\\" + name +"-"+department+ "-"+num+".docx";
                WordTemplateRenderer.render(mode, data, output);
            }
            }
        }
    }

