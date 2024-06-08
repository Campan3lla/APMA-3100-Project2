package edu.virginia.apma;

import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class ExcelWriter {
    public void write(List<ExcelWritable> data, String fileName) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(fileName);
        writeDataToSheet(data, sheet);
        writeWorkbookToFile(workbook, fileName);
    }

    private void writeDataToSheet(List<ExcelWritable> data, XSSFSheet sheet) {
        for (int i = 0; i < data.size(); i++) {
            data.get(i).writeToRow(sheet, i);
        }
    }

    private void writeWorkbookToFile(XSSFWorkbook workbook, String fileNameToWriteTo) {
        try {
            File newFile = new File(fileNameToWriteTo + ".xlsx");
            FileOutputStream out = new FileOutputStream(newFile);
            workbook.write(out);

            // Closing file output connections
            out.close();

            // Console message for successful execution of the program
            System.out.println(fileNameToWriteTo + ".xlsx written successfully to disk.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
