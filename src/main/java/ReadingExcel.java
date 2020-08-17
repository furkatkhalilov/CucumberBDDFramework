import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class ReadingExcel {
    public static void main(String[] args) throws IOException {

        File file = new File("src/main/resources/data.xlsx"); // excel file to be read
        Workbook workbook = WorkbookFactory.create(file); // Workbook reference to excel file

        for (int n = 0; n < workbook.getNumberOfSheets(); n++) { // iterate over all existing sheets
            Sheet sheet = workbook.getSheetAt(n); // get reference to each sheet
            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) { // iterate over all existing rows in a sheet
                Row row = sheet.getRow(i); // get reference to each row
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) { // iterate over all existing cell in a row
                    Cell cell = row.getCell(j); // get reference to each cell
                    System.out.print(cell.getStringCellValue() + " "); // get the string value of each cell
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }
    }
}
