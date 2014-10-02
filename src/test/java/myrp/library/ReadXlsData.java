package myrp.library;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReadXlsData {

	private Object[][] data = null;
	private String file = "src/test/java/com/library/testdata.xls";

	public ReadXlsData() throws IOException {
		ReadXlsDataImplementation();
	}
	public ReadXlsData(String filePath) throws IOException {
		file = filePath;
		ReadXlsDataImplementation();
	}
	
	public Object[][] getData () {
		return data;
	}
	
	private void ReadXlsDataImplementation() throws IOException {
		
		List<String[]> list = new ArrayList<String[]>();

		InputStream input = new BufferedInputStream(new FileInputStream(file));
		POIFSFileSystem fs = new POIFSFileSystem(input);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		
		Iterator rows = sheet.rowIterator();
		while (rows.hasNext()) {
			
			StringBuffer sb = new StringBuffer();
			HSSFRow row = (HSSFRow) rows.next();
			
			if(row.getRowNum()<1)
				continue;
			
			if (checkIfRowEmpty(row)) continue;
			
			int minColIndex = row.getFirstCellNum();
			int maxColIndex = row.getLastCellNum() - 1;
			
			List <String> rd = new ArrayList<String>();
			
			for(int colIndex = minColIndex; colIndex <= maxColIndex; colIndex++) {
				HSSFCell cell = row.getCell(colIndex);  
	       
				// POI can't recognize empty cells of Excel, so we should create new cells with a blank value  
				if (cell == null) {  
					cell = row.createCell(colIndex);  
					cell.setCellValue(" ");  
				}      
				String value = "";
				switch(cell.getCellType()) {  
				
					case HSSFCell.CELL_TYPE_NUMERIC:
						Double cellValue = cell.getNumericCellValue();
						value = String.valueOf(cellValue).replaceFirst("\\.0+$", "");
						break;  
					case HSSFCell.CELL_TYPE_BOOLEAN:  
						value = Boolean.toString(cell.getBooleanCellValue());  
						break;  
					case HSSFCell.CELL_TYPE_BLANK:  
					    value = "";  
					    break;  
					case HSSFCell.CELL_TYPE_ERROR:  
					    value = "";  
					    break;  
					case HSSFCell.CELL_TYPE_FORMULA:
					    value = "";  
					    break;  
					default:  
					    value = cell.getStringCellValue();  
					    break;  
				}	
				rd.add(value);
			}
			String[] array = rd.toArray(new String[rd.size()]);
			list.add(array);
		}
			
		if (list.size() > 0) {
			int i = 0;
			data = new Object[list.size()][2];
			for (String[] dataRow : list) {
				data [i][0] = String.class;
				data [i][1] = dataRow;
			    i++;
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public boolean checkIfRowEmpty(HSSFRow row) {
		boolean isRowEmpty = true;  
		try {
			int minColumIndex = row.getFirstCellNum();  
			int maxColumnIndex = row.getLastCellNum() - 1;  
			for(int columIndex = minColumIndex; columIndex <= maxColumnIndex; columIndex++) {
				HSSFCell cell = row.getCell((short) columIndex);
				if(cell == null || cell.toString().trim().isEmpty() || cell.toString().length() == 0) {
				  
				} else { 
					isRowEmpty = false;  
					return isRowEmpty;  
				}  
			}
		} catch (Exception ex) {
		}
		return isRowEmpty;  
	}
}
