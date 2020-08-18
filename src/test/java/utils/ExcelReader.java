package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
            Row row = sheet.getRow(i);
            list.add(getStringFromCell(row, 0));
        }
        return list;
    }

    public Map<String, String> getMap(String sheetName) {
        Map<String,String> map = new HashMap<>();

        Sheet sheet = workbook.getSheet(sheetName);
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            map.put(getStringFromCell(row, 0),getStringFromCell(row, 1));
        }
        return map;
    }

    public List<List<String>> getListOfLists(String sheetName) {
        List<List<String>> listOfLists = new ArrayList<>();

        Sheet sheet = workbook.getSheet(sheetName);
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            List<String> rowList = new ArrayList<>(); // create empty list for each row
            Row row = sheet.getRow(i); // get reference to
            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                rowList.add(getStringFromCell(row, j)); // add cell to rowList
            }
            // finished reading the row into a rowList
            listOfLists.add(rowList); // add rowList to list of lists
        }
        return listOfLists;
    }

    public List<Map<String, String>> getListOfMaps(String sheetName) {
        List<Map<String,String>>  listOfMaps = new ArrayList<>();

        Sheet listMap = workbook.getSheet(sheetName);
        Row fieldRow = listMap.getRow(0);
        List<String> fieldNames = new ArrayList<>();
        for (int i = 0; i < fieldRow.getPhysicalNumberOfCells(); i++) {
            fieldNames.add(getStringFromCell(fieldRow, i));
        }

        for (int i = 1; i < listMap.getPhysicalNumberOfRows(); i++) {
            Row dataRow = listMap.getRow(i);
            Map<String, String> rowMap =  new HashMap<>();
            for (int j = 0; j < dataRow.getPhysicalNumberOfCells(); j++) {
                String key = fieldNames.get(j);
                String value = getStringFromCell(dataRow, j);
                rowMap.put(key, value);
            }

            listOfMaps.add(rowMap);
        }
        return listOfMaps;
    }

    private String getStringFromCell(Row row, int index) {
        Cell cell = row.getCell(index);
        String value = cell.toString() == null ? "" : cell.toString().trim();
        return value;
    }
}
