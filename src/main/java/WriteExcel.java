import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    public static void main(String[] args) throws IOException {
        // create an new Workbook reference
        Workbook workbook = WorkbookFactory.create(true);

        // filling in the data
        Sheet sheet = workbook.createSheet("output");
        Row row = sheet.createRow(2);
        Cell cell = row.createCell(3);
        cell.setCellValue("Hello excel!");

        // writing workbook to a file
        FileOutputStream outputStream = new FileOutputStream("src/main/resources/output.xlsx");
        workbook.write(outputStream);
        outputStream.close();
    }
}
