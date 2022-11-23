import com.yzk18.docs.ChartFromCellRangeBuilder;
import com.yzk18.docs.ExcelHelpers;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFSheet;
//运行报错
public class Case13 {
    public static void main(String[] args) {
        Workbook workbook = ExcelHelpers.openFile("D:\\data\\test\\Case13\\1.xlsx");
        Sheet sheet = workbook.getSheetAt(0);
        int count =sheet.getLastRowNum();
        XSSFChart chart = ExcelHelpers.createChart(sheet, 5, 0, 20, 10);
        ChartFromCellRangeBuilder  chartBulider = new ChartFromCellRangeBuilder  (ChartTypes.LINE,(XSSFSheet) sheet);
        chartBulider.setCategoriesCellRange(new CellRangeAddress(1,count,0,0));
        chartBulider.putCellRanges("确诊",new CellRangeAddress(1,count,1,1));
        chartBulider.putCellRanges("死亡",new CellRangeAddress(1,count,2,2));
        chartBulider.setCategoryAxisTitle("地区");
        chartBulider.build(chart);
        ExcelHelpers.saveToFile(workbook,"D:\\data\\test\\Case13\\2.xlsx");
        ExcelHelpers.close(workbook);
    }
}
