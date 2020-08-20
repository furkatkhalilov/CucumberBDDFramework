package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.*;

public class ExcelWriter {
    Workbook workbook = null;
    private String pathToFile;

    public ExcelWriter(String pathToFile) throws IOException {
        this.pathToFile = pathToFile;
        try {
            FileInputStream fileInputStream = new FileInputStream(this.pathToFile);
            workbook = WorkbookFactory.create(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            workbook = WorkbookFactory.create(true);
        }
    }

    public void writeList(List<String> list, String sheetName) throws IOException {
        // | data1 | data2 | data3 |
        // filling in the data
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) { // if sheet does not exist
            sheet = workbook.createSheet(sheetName);
        }

        Row row = sheet.createRow(0);
        for (int i = 0; i < list.size(); i++) {
            Cell cell = row.createCell(i);
            String dataTableCell = list.get(i);
            cell.setCellValue(dataTableCell);
        }

        // writing workbook to a file

        closeWorkbook();

    }

    public void writeMap(Map<String, String> map, String sheetName) throws IOException {
        // | field1 | data1 |
        // | field2 | data2 |
        // | field3 | data3 |
        // filling in the data
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) { // if sheet does not exist
            sheet = workbook.createSheet(sheetName);
        }

        int i = 0;
        for (String key : map.keySet()) {
            Row row = sheet.createRow(i);
            Cell cell_1 = row.createCell(0);
            cell_1.setCellValue(key);
            Cell cell_2 = row.createCell(1);
            cell_2.setCellValue(map.get(key));
            i++;
        }

        // writing workbook to a file

        closeWorkbook();
    }

    public void writeListOfMaps(List<Map<String, String>> listOfMaps, String sheetName) throws IOException {
        // | field1 | field2 | field3 |
        // | data11 | data12 | data13 | -> { field1:data11, field2:data12, field3:data13 }
        // | data21 | data22 | data23 | -> { field1:data21, field2:data22, field3:data23 }
        // List<Map<String, String>>  -> [ { field1:data11, field2:data12, field3:data13 }, { field1:data21, field2:data22, field3:data23 }]

        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) { // if sheet does not exist
            sheet = workbook.createSheet(sheetName);
        }

        // in first row, write field keys only
        Row row = sheet.createRow(0);
        int i = 0; // first row, contains keys
        for (String key : listOfMaps.get(0).keySet()) {
            Cell cell = row.createCell(i);
            cell.setCellValue(key);
            i++;
        }

        // create a for loop that iterates over listOfMaps and writes rest of items in rows
        int j = 1; // starting second row
        for (Map<String, String> rows : listOfMaps) {
            Row rowInExel = sheet.createRow(j);
            int k = 0;
            for (String key : rows.keySet()) {
                Cell cell = rowInExel.createCell(k);
                cell.setCellValue(rows.get(key));
                k++;
            }
            j++;
        }

        // writing workbook to a file
        closeWorkbook();
        return;
    }


    public void writeListOfLists(List<List<String>> rows, String sheetName) throws IOException {

        // filling in the data
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) { // if sheet does not exist
            sheet = workbook.createSheet(sheetName);
        }


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

        closeWorkbook();

    }

    private void closeWorkbook() throws IOException {
        FileOutputStream outputStream = new FileOutputStream(pathToFile);
        workbook.write(outputStream);
        outputStream.close();
    }
}
