package utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

import static constants.Constants.ExcelOutPutFile;

public class ReadExcel {


    public static Map<String, Map<String, String>> readExcelAsTestCases(String excelPath, String sheetName) {
        Map<String, Map<String, String>> testData = new LinkedHashMap<>();
        try (FileInputStream fis = new FileInputStream(excelPath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow == null) continue;

                Cell testCaseTypeCell = currentRow.getCell(0);
                if (testCaseTypeCell == null) continue;

                String testCaseType = testCaseTypeCell.getStringCellValue().trim();
                Map<String, String> fieldValues = new LinkedHashMap<>();

                for (int j = 1; j < currentRow.getLastCellNum(); j++) {
                    String fieldName = headerRow.getCell(j).getStringCellValue().trim();
                    Cell valueCell = currentRow.getCell(j);
                    String value = (valueCell != null) ? valueCell.toString().trim() : "";
                    fieldValues.put(fieldName, value);
                }

                testData.put(testCaseType, fieldValues);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return testData;
    }


    private static void writeToFile(ArrayList<HashMap<String,String>> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ExcelOutPutFile))) {
            for (Map<String, String> row : data) {
                writer.write(row.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*

     */
}
