package steps;

import cucumber.api.java.en.*;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            list.add(cell.getStringCellValue());
        }
        System.out.println(list);
    }
}
