package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    Workbook workbook;
    public ExcelReader(String filePath) throws IOException {
        File file = new File(filePath);
        workbook = WorkbookFactory.create(file);
    }

    public List<String> getList(String sheetName) {
        List<String> list = new ArrayList<>();
        Sheet sheet = workbook.getSheet(sheetName);
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i); // get reference to
            list.add(getStringFromCell(row, 0));
        }
        return list;
    }



    public Map<String, String> getMap(String sheetName) {
        return null;
    }

    public List<List<String>> getListOfLists(String sheetName) {
        return null;
    }

    public List<Map<String, String>> getListOfMaps(String sheetName) {
        return null;
    }

    private String getStringFromCell(Row row, int index) {
        Cell cell = row.getCell(index);
        String value = cell.toString() == null ? "" : cell.toString().trim();
        return value;
    }
}
