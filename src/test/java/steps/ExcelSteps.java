package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.apache.poi.ss.usermodel.*;
import utils.ExcelReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelSteps {

    @Given("^I printout to console from excel using list only$")
    public void listOnly() throws IOException {
        ExcelReader reader = new ExcelReader("src/main/resources/data.xlsx");
        List<String> list = reader.getList("list");;
        System.out.println(list);
    }


    @Given("^I printout to console from excel using map only$")
    public void iPrintoutToConsoleFromExcelUsingMapOnly() throws IOException {
        ExcelReader reader = new ExcelReader("src/main/resources/data.xlsx");
        Map<String,String> map = reader.getMap("map");
        System.out.println(map);
    }

    @Given("^I printout to console from excel using list of lists$")
    public void iPrintoutToConsoleFromExcelUsingListOfLists() throws IOException {
        ExcelReader reader = new ExcelReader("src/main/resources/data.xlsx");
        List<List<String>> listOfLists = reader.getListOfLists("listList");
        System.out.println(listOfLists);
    }

    @Given("^I printout to console from excel using list of maps$")
    public void iPrintoutToConsoleFromExcelUsingListOfMaps() throws IOException {
        ExcelReader reader = new ExcelReader("src/main/resources/data.xlsx");
        List<Map<String,String>>  listOfMaps = reader.getListOfMaps("listMap");
        System.out.println(listOfMaps);
    }

    @Given("^I write to excel following data to sheet \"([^\"]*)\"$")
    public void iWriteToExcelFollowingData(String sheetName, DataTable table) throws IOException {
        // create an new Workbook reference
        Workbook workbook = WorkbookFactory.create(true);

        // filling in the data
        Sheet sheet = workbook.createSheet(sheetName);

        List<List<String>> rows = table.asLists(String.class); // extract data from datatable as list of lists
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
        FileOutputStream outputStream = new FileOutputStream("src/test/resources/output.xlsx");
        workbook.write(outputStream);
        outputStream.close();
    }
}
