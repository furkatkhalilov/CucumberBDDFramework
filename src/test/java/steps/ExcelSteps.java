package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.apache.poi.ss.usermodel.*;
import utils.ExcelReader;
import utils.ExcelWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        String pathToFile = "src/test/resources/output.xlsx";
        ExcelWriter writer = new ExcelWriter(pathToFile);

        List<List<String>> rows = table.asLists(String.class); // extract data from datatable as list of lists

        writer.writeListOfLists(rows, sheetName);

    }
}
