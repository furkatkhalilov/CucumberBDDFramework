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
}
