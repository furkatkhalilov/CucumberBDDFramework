import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) throws IOException {
        List<String> CustomerList = new ArrayList<>();

        File file = new File("src/main/resources/task3.xlsx");
        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheet("Sheet2");
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i); // get reference to
            Cell cell = row.getCell(1);
            CustomerList.add(cell.getStringCellValue());
        }
        System.out.println(CustomerList);
    }
}
