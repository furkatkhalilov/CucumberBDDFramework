package steps;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

import java.util.List;
import java.util.Map;

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

    @Given("^I printout to console using datable list of maps$")
    public void iPrintoutToConsoleUsingDatableMap(DataTable table) {
        List<Map<String, String>> mapList = table.asMaps(String.class, String.class);
        for ( Map<String, String> row: mapList) {
            for (String key: row.keySet()) {
                System.out.print(key + " : " + row.get(key) + " | ");
            }
            System.out.println();
        }

    }

    @Given("^I printout to console using datable map only$")
    public void iPrintoutToConsoleUsingDatableMapOnly(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);
        for (String key: map.keySet()) {
            System.out.println(key + " : " + map.get(key) );
        }
    }
}
