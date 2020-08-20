package utils;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ExcelWriter {
    Workbook workbook = null;
    private String pathToFile;

    public ExcelWriter(String pathToFile) throws IOException {
        this.pathToFile = pathToFile;
        try {
            FileInputStream fileInputStream = new FileInputStream(this.pathToFile);
            workbook = WorkbookFactory.create(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            workbook = WorkbookFactory.create(true);
        }
    }

    public void writeListOfLists(List<List<String>> rows, String sheetName) throws IOException {

        // filling in the data
        Sheet sheet = workbook.getSheet(sheetName);
        if(sheet == null) { // if sheet does not exist
            sheet = workbook.createSheet(sheetName);
        }


        for (int i = 0; i < rows.size(); i++) {
            Row row = sheet.createRow(i);
            List<String> dataTableRow = rows.get(i);
            for (int j = 0; j < dataTableRow.size(); j++) {
                Cell cell = row.createCell(j);
                String dataTableCell = dataTableRow.get(j);
                cell.setCellValue(dataTableCell);
            }
        }

        // writing workbook to a file

        FileOutputStream outputStream = new FileOutputStream(pathToFile);
        workbook.write(outputStream);
        outputStream.close();

    }
}
