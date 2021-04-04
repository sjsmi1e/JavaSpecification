import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {


    public static List<Map<String, String>> readExcel(File file) {
        List<Map<String, String>> Row = new ArrayList<Map<String, String>>();
        InputStream is = null;
        try {
            Workbook workBook = null;
            is = new FileInputStream(file.getPath());
            String fn = file.getName();

            String prex = fn.substring(fn.lastIndexOf("."));
            if (prex.toLowerCase().equals(".xlsx")) {
                workBook = new XSSFWorkbook(is);
            } else if (prex.toLowerCase().equals(".xls")) {
                workBook = new HSSFWorkbook(is);
            }

            for (int numSheet = 0; numSheet < workBook.getNumberOfSheets(); numSheet++) {
                Sheet sheet = workBook.getSheetAt(numSheet);
                if (sheet == null) {
                    continue;
                }
                // 循环行Row
                Map<String, String> maptitleCell = new HashMap<String, String>();
                for (int rowNum = 4; rowNum <= sheet.getLastRowNum(); rowNum++) {
                    Row row = sheet.getRow(rowNum);
                    if (row == null) {
                        continue;
                    }

                    // 循环列Cell
                    Map<String, String> mapCell = new HashMap<String, String>();
                    for (int cellNum = 0; cellNum <= row.getLastCellNum(); cellNum++) {
                        Cell cell = row.getCell(cellNum);
                        //如果是日期形式
                        if (cellNum == 8 && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                            Date theDate = cell.getDateCellValue();
                            SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String format = datetimeFormat.format(theDate);

                            mapCell.put(cellNum + "", format);
                            continue;
                        }
                        if (cell == null) {
                            continue;
                        }
                        mapCell.put(cellNum + "", getValue(cell));
                    }
                    Row.add(mapCell);
                }
            }
        } catch (IOException e) {
            System.out.println("e:" + e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Row;
    }

    @SuppressWarnings("static-access")
    private static String getValue(Cell cell) {
        if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return String.valueOf(cell.getStringCellValue());
        }
    }


}
