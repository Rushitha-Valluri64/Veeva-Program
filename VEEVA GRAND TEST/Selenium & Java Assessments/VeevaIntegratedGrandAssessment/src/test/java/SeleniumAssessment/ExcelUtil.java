package SeleniumAssessment;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;

public class ExcelUtil {

    public static Object[][] getLoginData() throws Exception {

        FileInputStream fis = new FileInputStream("testdata.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();   
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++)
        { 
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
            }
        }

        wb.close();
        return data;
    }
}