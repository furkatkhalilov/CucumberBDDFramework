import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task4 {
    public static void main(String[] args) throws IOException {

        File file = new File("src/main/resources/task4.xlsx");
        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheetAt(0);
        Map<String,String> table=new HashMap<>();
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i); // get reference to
            Cell cell0 = row.getCell(0);
            Cell cell1 = row.getCell(1);
            table.put(cell0.toString(),cell1.toString()); // key, value
        }
        System.out.println(table);
    }
}
