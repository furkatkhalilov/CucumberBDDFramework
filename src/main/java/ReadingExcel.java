import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class ReadingExcel {
    public static void main(String[] args) throws IOException {
        Workbook workbook = WorkbookFactory.create(new File("src/main/resources/data.xlsx"));

        for (int n = 0; n < workbook.getNumberOfSheets(); n++) {
            Sheet sheet = workbook.getSheetAt(n);
            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                    Cell cell = row.getCell(j);
                    System.out.print(cell.getStringCellValue() + " ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }
    }
}
