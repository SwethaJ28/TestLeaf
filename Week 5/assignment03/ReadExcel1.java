package week05.day0102.assignment03;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel1 {

	public static String[][] data(String excelFilePath) throws IOException {
		// Opening the work book
		XSSFWorkbook book = new XSSFWorkbook(excelFilePath);
		// traversing the to the sheet.
		XSSFSheet sheet = book.getSheetAt(0);

		// for getting row count.
		int rowcount = sheet.getLastRowNum();

		// for getting column count
		short columncount = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rowcount][columncount];

		// for getting data from sheet
		for (int i = 1; i <= rowcount; i++) {
			XSSFRow eachrow = sheet.getRow(i);
			for (int j = 0; j < columncount; j++) {
				XSSFCell cell = eachrow.getCell(j);
				cell.setCellType(CellType.STRING);
				String value = cell.getStringCellValue();
				data[i - 1][j] = value;
				System.out.println(value);

			}
		}

		book.close();
		return data;
	}
}
