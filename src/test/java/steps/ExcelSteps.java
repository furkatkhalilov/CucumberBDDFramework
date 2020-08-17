package steps;

import cucumber.api.java.en.*;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelSteps {

    @Given("^I printout to console from excel using list only$")
    public void listOnly() throws IOException {
        List<String> list = new ArrayList<>();

        File file = new File("src/main/resources/data.xlsx");
        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheet("list");
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i); // get reference to
            Cell cell = row.getCell(0);
            list.add(cell.toString());
        }
        System.out.println(list);
    }


    @Given("^I printout to console from excel using map only$")
    public void iPrintoutToConsoleFromExcelUsingMapOnly() throws IOException {
        Map<String,String> map = new HashMap<>();

        File file = new File("src/main/resources/data.xlsx");
        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheet("map");
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i); // get reference to
            Cell cell0 = row.getCell(0);
            Cell cell1 = row.getCell(1);
            map.put(cell0.toString(),cell1.toString()); // key, value
        }
        System.out.println(map);
    }

    @Given("^I printout to console from excel using list of lists$")
    public void iPrintoutToConsoleFromExcelUsingListOfLists() throws IOException {
        List<List<String>> listOfLists = new ArrayList<>();

        File file = new File("src/main/resources/data.xlsx");
        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheet("listList");
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            List<String> rowList = new ArrayList<>(); // create empty list for each row
            Row row = sheet.getRow(i); // get reference to
            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                rowList.add(row.getCell(j).toString()); // add cell to rowList
            }
            // finished reading the row into a rowList
            listOfLists.add(rowList); // add rowList to list of lists
        }
        System.out.println(listOfLists);
    }

    @Given("^I printout to console from excel using list of maps$")
    public void iPrintoutToConsoleFromExcelUsingListOfMaps() throws IOException {
        List<Map<String,String>>  listOfMaps = new ArrayList<>();

        File file = new File("src/main/resources/data.xlsx");
        Workbook workbook = WorkbookFactory.create(file);

        Sheet listMap = workbook.getSheet("listMap");
        Row fieldRow = listMap.getRow(0);
        List<String> fieldNames = new ArrayList<>();
        for (int i = 0; i < fieldRow.getPhysicalNumberOfCells(); i++) {
            fieldNames.add(fieldRow.getCell(i).toString());
        }

        for (int i = 1; i < listMap.getPhysicalNumberOfRows(); i++) {
            Row dataRow = listMap.getRow(i);
            Map<String, String> rowMap =  new HashMap<>();
            for (int j = 0; j < dataRow.getPhysicalNumberOfCells(); j++) {
                String key = fieldNames.get(j);
                String value = dataRow.getCell(j).toString();
                rowMap.put(key, value);
            }

            listOfMaps.add(rowMap);
        }

        System.out.println(listOfMaps);
    }
}
