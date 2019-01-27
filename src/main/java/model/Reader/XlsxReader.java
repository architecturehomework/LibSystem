package model.Reader;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.text.NumberFormat;

public class XlsxReader extends Reader {
    @Override
    public String getText(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        XSSFWorkbook workbook = new XSSFWorkbook(filePath);
        for(int sheet=0;sheet<workbook.getNumberOfSheets();sheet++){
            if(null!=workbook.getSheetAt(sheet)){
                XSSFSheet aSheet =workbook.getSheetAt(sheet);
                for(int row=0;row<=aSheet.getLastRowNum();row++){
                    if(null!=aSheet.getRow(row)){
                        XSSFRow aRow = aSheet.getRow(row);
                        for(int cell=0;cell<aRow.getLastCellNum();cell++){
                            if(null!=aRow.getCell(cell)){
                                XSSFCell aCell = aRow.getCell(cell);
                                if(convertCell(aCell).length()>0){
                                    content.append(convertCell(aCell));
                                }
                            }
                            content.append(" ");
                        }
                    }
                }
            }
        }
        workbook.close();
        return content.toString();

    }

    private String convertCell(Cell cell){
        NumberFormat formater = NumberFormat.getInstance();
        formater.setGroupingUsed(false);
        String cellValue="";
        if(cell==null){
            return cellValue;
        }

        switch(cell.getCellType()){
            case HSSFCell.CELL_TYPE_NUMERIC:
                cellValue = formater.format(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_STRING:
                cellValue = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                cellValue = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                cellValue = Boolean.valueOf(cell.getBooleanCellValue()).toString();
                break;
            case HSSFCell.CELL_TYPE_ERROR:
                cellValue = String.valueOf(cell.getErrorCellValue());
                break;
            default:cellValue="";
        }
        return cellValue.trim();
    }

}
