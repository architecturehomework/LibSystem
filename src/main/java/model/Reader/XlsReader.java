package model.Reader;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class XlsReader extends Reader {
    @Override
    public String getText(String filePath) throws IOException {
        FileInputStream in = new FileInputStream(filePath);
        StringBuilder content = new StringBuilder();
        HSSFWorkbook workbook = new HSSFWorkbook(in);
        for(int sheetIndex=0;sheetIndex<workbook.getNumberOfSheets();sheetIndex++){
            HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
            for(int rowIndex=0;rowIndex<=sheet.getLastRowNum();rowIndex++){
                HSSFRow row = sheet.getRow(rowIndex);
                if(row==null){
                    continue;
                }
                for(int cellnum=0;cellnum<row.getLastCellNum();cellnum++){
                    HSSFCell cell = row.getCell(cellnum);
                    if(cell!=null){
                        content.append(cell.getRichStringCellValue().getString()+" ");
                    }

                }
            }

        }
        workbook.close();
        return content.toString();
    }
}
