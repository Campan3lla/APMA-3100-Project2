package edu.virginia.apma;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.concurrent.atomic.AtomicInteger;

public class Realization implements ExcelWritable {
    private final double realization;
    private final double value;

    private String realizationIdentifier = "Realization: ";
    private String valueIdentifier = "Value: ";

    public Realization(double realization, double value) {
        this.realization = realization;
        this.value = value;
    }

    public double getRealization() {
        return realization;
    }

    public double getValue() {
        return value;
    }

    public String getRealizationIdentifier() {
        return realizationIdentifier;
    }

    public String getValueIdentifier() {
        return valueIdentifier;
    }

    public void setRealizationIdentifier(String realizationIdentifier) {
        this.realizationIdentifier = realizationIdentifier;
    }

    public void setValueIdentifier(String valueIdentifier) {
        this.valueIdentifier = valueIdentifier;
    }

    public String toString() {
        return realizationIdentifier + realization + "\n" + valueIdentifier + value + "\n";
    }

    @Override
    public void writeToRow(XSSFSheet sheet, int rowNumber) {
        Row excelRow = sheet.createRow(rowNumber);
        AtomicInteger columnIndex = new AtomicInteger(0);
        excelRow.createCell(columnIndex.getAndIncrement()).setCellValue(realizationIdentifier);
        excelRow.createCell(columnIndex.getAndIncrement()).setCellValue(realization);
        excelRow.createCell(columnIndex.getAndIncrement()).setCellValue(valueIdentifier);
        excelRow.createCell(columnIndex.getAndIncrement()).setCellValue(value);
    }
}
