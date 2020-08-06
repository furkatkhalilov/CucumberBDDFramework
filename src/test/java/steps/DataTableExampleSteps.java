package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

import java.util.List;

public class DataTableExampleSteps {
    @Given("^I printout to console using datable$")
    public void i_printout_to_console(DataTable table) {
        List<List<String>> rows = table.asLists(String.class); // extract data from datatable as list of lists
        for(List<String> column: rows) {
            for (String cell: column) {
                System.out.print(cell + " | ");
            }
            System.out.println();
        }
    }

}
