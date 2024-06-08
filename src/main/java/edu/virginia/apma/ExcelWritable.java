package edu.virginia.apma;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public interface ExcelWritable {
    void writeToRow(XSSFSheet sheet, int rowNumber);
}
