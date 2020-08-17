import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/task2.xlsx");
        Workbook workbook = WorkbookFactory.create(file);
//        Sheet sheet = workbook.getSheetAt(1);
        Sheet sheet = workbook.getSheet("Sheet3");
        Row row = sheet.getRow(2);
        for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
            Cell cell = row.getCell(j);
            System.out.print(cell.getStringCellValue() + " ");
        }
    }
}
