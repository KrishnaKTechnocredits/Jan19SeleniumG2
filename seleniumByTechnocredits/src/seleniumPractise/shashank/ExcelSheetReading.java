package seleniumPractise.shashank;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetReading {
	Workbook myworkbook = null;

	ExcelSheetReading(String path) throws IOException {
		File file = new File(path);
		FileInputStream input = new FileInputStream(file);
		this.myworkbook = new XSSFWorkbook(input);
	}

	public Object[][] readExcel(String sheetName, boolean header){
		Sheet sheet=myworkbook.getSheet(sheetName);
		int firstRow=sheet.getFirstRowNum();
		int lastRow=sheet.getLastRowNum();
		int firstCol=sheet.getRow(firstRow).getFirstCellNum();
		int lastCol=sheet.getRow(firstRow).getLastCellNum();
		
		if(header)
		{
			firstRow++;
		}
		System.out.println(firstRow+" "+lastRow+" "+firstCol+" "+lastCol+" ");
		Object cell[][] = new Object[lastRow][lastCol];
		for(int i=firstRow; i<=lastRow; i++)
		{
			for(int j=firstCol; j<lastCol; j++)
			{
				try{
					cell[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.print(cell[i-1][j]+"\t");
				}catch(NullPointerException e){
					cell[i-1][j]="";
				}
			}
			System.out.println();
		}
		
		return cell;
		
	}
}

// 
