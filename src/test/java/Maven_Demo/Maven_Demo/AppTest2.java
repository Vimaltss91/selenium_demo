package com.ibm.stax.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Handling
{
  private static XSSFWorkbook workbook;
  private static XSSFSheet sheet;
  private static XSSFCell cell;
  private static XSSFRow row;
  private static FileInputStream fis = null;
  public static FileOutputStream fileOut = null;
  public static HashMap<String, HashMap> TestData;
  public static HashMap<String, HashMap> deviceDetails;
  public static String fileFullPath;
  public static String srcSheetName;
  public static String resultPath = "";
  public static String resultSheetName = "";
  
  public void ExcelReader(String fileName, String sheetname, String ResultPath, String ResultName)
  {
    try
    {
      fis = new FileInputStream(new File(fileName));
      workbook = new XSSFWorkbook(fis);
      sheet = workbook.getSheet(sheetname);
      srcSheetName = sheetname;
      fileFullPath = fileName;
      resultPath = ResultPath;
      resultSheetName = ResultName;
    }
    catch (FileNotFoundException fnfEx)
    {
      System.out.println(fileName + " is not Found. please check the file name.");
      System.exit(0);
    }
    catch (IOException ioEx)
    {
      System.out.println(fis + " is not Found. please check the path.");
    }
    catch (Exception ex)
    {
      System.out.println("There is error reading/loading xls file, due to " + ex);
    }
  }
  
  public static int searchField(String sheetName, int colNum, String value)
    throws Exception
  {
    try
    {
      int rowCount = sheet.getLastRowNum();
      System.out.println("rowCount " + rowCount);
      for (int i = 0; i <= rowCount; i++) {
        if (getCellData(i, colNum).equalsIgnoreCase(value)) {
          return i;
        }
      }
      return -1;
    }
    catch (Exception e)
    {
      throw e;
    }
  }
  
  public String[] getRowData(int rowNum)
    throws Exception
  {
    String[] temp = new String[sheet.getRow(rowNum).getLastCellNum()];
    for (int i = 0; i < temp.length; i++) {
      temp[i] = getCellData(rowNum, i);
    }
    return temp;
  }
  
  public static String getCellData(int rowNum, int colNum)
    throws Exception
  {
    try
    {
      cell = sheet.getRow(rowNum).getCell(colNum);
      return cell.getStringCellValue();
    }
    catch (Exception e) {}
    return "";
  }
  
  public static String getCellIntData(int rowNum, int colNum)
    throws Exception
  {
    try
    {
      cell = sheet.getRow(rowNum).getCell(colNum);
      String CellData = String.valueOf(cell.getNumericCellValue());
      return CellData.substring(0, CellData.indexOf("."));
    }
    catch (Exception e) {}
    return "";
  }
  
  public String getCellData(String sheetName, String colName, int rowNum)
  {
    try
    {
      if (rowNum <= 0) {
        return "";
      }
      int index = workbook.getSheetIndex(sheetName);
      int col_Num = -1;
      if (index == -1) {
        return "";
      }
      sheet = workbook.getSheetAt(index);
      row = sheet.getRow(0);
      for (int i = 0; i < row.getLastCellNum(); i++) {
        if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
          col_Num = i;
        }
      }
      if (col_Num == -1) {
        return "";
      }
      sheet = workbook.getSheetAt(index);
      row = sheet.getRow(rowNum - 1);
      if (row == null) {
        return "";
      }
      cell = row.getCell(col_Num);
      if (cell == null) {
        return "";
      }
      if (cell.getCellType() == 1) {
        return cell.getStringCellValue();
      }
      if ((cell.getCellType() == 0) || (cell.getCellType() == 2)) {
        return String.valueOf(cell.getNumericCellValue());
      }
      if (cell.getCellType() == 3) {
        return "";
      }
      return String.valueOf(cell.getBooleanCellValue());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return "row " + rowNum + " or column " + colName + " does not exist in xls";
  }
  
  public String getCellData(String sheetName, int colNum, int rowNum)
  {
    try
    {
      if (rowNum <= 0) {
        return "";
      }
      int index = workbook.getSheetIndex(sheetName);
      if (index == -1) {
        return "";
      }
      sheet = workbook.getSheetAt(index);
      row = sheet.getRow(rowNum - 1);
      if (row == null) {
        return "";
      }
      cell = row.getCell(colNum);
      if (cell == null) {
        return "";
      }
      if (cell.getCellType() == 1) {
        return cell.getStringCellValue();
      }
      if ((cell.getCellType() == 0) || (cell.getCellType() == 2)) {
        return String.valueOf(cell.getNumericCellValue());
      }
      if (cell.getCellType() == 3) {
        return "";
      }
      return String.valueOf(cell.getBooleanCellValue());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
  }
  
  public List<HashMap<String, String>> getExcelData()
  {
    int lastRow = sheet.getLastRowNum();
    System.out.println(lastRow);
    List<HashMap<String, String>> result = new ArrayList(lastRow);
    for (int i = 1; i <= sheet.getLastRowNum(); i++)
    {
      HashMap<String, String> testdata = new HashMap();
      for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
        try
        {
          System.out.println("i:" + i + " " + "j:" + j);
          testdata.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());
        }
        catch (Throwable localThrowable) {}
      }
      result.add(testdata);
    }
    return result;
  }
  
  public HashMap<String, String> getExcelRowData(int rowNum)
  {
    HashMap<String, String> map = new HashMap();
    for (int j = 0; j < sheet.getRow(rowNum).getLastCellNum(); j++) {
      map.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(rowNum).getCell(j).getStringCellValue());
    }
    return map;
  }
  
  public static String cellToString(HSSFCell cell)
  {
    int type = cell.getCellType();
    Object result;
    Object result;
    Object result;
    Object result;
    switch (type)
    {
    case 0: 
      result = Double.valueOf(cell.getNumericCellValue());
      break;
    case 1: 
      result = cell.getStringCellValue();
      break;
    case 2: 
      throw new RuntimeException("We can't evaluate formulas in Java");
    case 3: 
      result = "-";
      break;
    case 4: 
      result = Boolean.valueOf(cell.getBooleanCellValue());
      break;
    case 5: 
      throw new RuntimeException("This cell has an error");
    default: 
      throw new RuntimeException("We don't support this cell type: " + type);
    }
    Object result;
    return result.toString();
  }
  
  public int getRowCount(String sheetName)
  {
    return workbook.getSheet(sheetName).getLastRowNum() + 1;
  }
  
  public static int getFirstRowNum()
  {
    return sheet.getFirstRowNum();
  }
  
  public static int getLastRowNum()
  {
    return sheet.getLastRowNum();
  }
  
  public boolean setCellData(String filepath, String sheetName, String colName, int rowNum, String data)
  {
    try
    {
      if (rowNum <= 0) {
        return false;
      }
      int index = workbook.getSheetIndex(sheetName);
      int colNum = -1;
      if (index == -1) {
        return false;
      }
      sheet = workbook.getSheetAt(index);
      row = sheet.getRow(0);
      for (int i = 0; i < row.getLastCellNum(); i++) {
        if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
          colNum = i;
        }
      }
      if (colNum == -1) {
        return false;
      }
      sheet.autoSizeColumn(colNum);
      row = sheet.getRow(rowNum - 1);
      if (row == null) {
        row = sheet.createRow(rowNum - 1);
      }
      cell = row.getCell(colNum);
      if (cell == null) {
        cell = row.createCell(colNum);
      }
      cell.setCellValue(data);
      fileOut = new FileOutputStream(filepath);
      workbook.write(fileOut);
      fileOut.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return false;
    }
    return true;
  }
  
  public boolean addSheet(String filePath, String sheetName)
  {
    try
    {
      workbook.createSheet(sheetName);
      fileOut = new FileOutputStream(filePath);
      workbook.write(fileOut);
      fileOut.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return false;
    }
    return true;
  }
  
  public boolean removeSheet(String filePath, String sheetName)
  {
    int index = workbook.getSheetIndex(sheetName);
    if (index == -1) {
      return false;
    }
    try
    {
      workbook.removeSheetAt(index);
      fileOut = new FileOutputStream(filePath);
      workbook.write(fileOut);
      fileOut.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return false;
    }
    return true;
  }
  
  public boolean addColumn(String filePath, String sheetName, String colName)
  {
    try
    {
      fis = new FileInputStream(filePath);
      XSSFWorkbook workbook = new XSSFWorkbook(fis);
      int index = workbook.getSheetIndex(sheetName);
      if (index == -1) {
        return false;
      }
      XSSFCellStyle style = workbook.createCellStyle();
      style.setFillForegroundColor((short)55);
      style.setFillPattern((short)1);
      XSSFSheet sheet = workbook.getSheetAt(index);
      XSSFRow row = sheet.getRow(0);
      XSSFCell cell = null;
      if (row == null) {
        row = sheet.createRow(0);
      }
      if (row.getLastCellNum() == -1) {
        cell = row.createCell(0);
      } else {
        cell = row.createCell(row.getLastCellNum());
      }
      cell.setCellValue(colName);
      cell.setCellStyle(style);
      fileOut = new FileOutputStream(filePath);
      workbook.write(fileOut);
      fileOut.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return false;
    }
    return true;
  }
  
  public boolean removeColumn(String filePath, String sheetName, int colNum)
  {
    try
    {
      if (!isSheetExist(sheetName)) {
        return false;
      }
      sheet = workbook.getSheet(sheetName);
      XSSFCellStyle style = workbook.createCellStyle();
      style.setFillForegroundColor((short)55);
      style.setFillPattern((short)0);
      for (int i = 0; i < getRowCount(sheetName); i++)
      {
        row = sheet.getRow(i);
        if (row != null)
        {
          cell = row.getCell(colNum);
          if (cell != null)
          {
            cell.setCellStyle(style);
            row.removeCell(cell);
          }
        }
      }
      fileOut = new FileOutputStream(filePath);
      workbook.write(fileOut);
      fileOut.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return false;
    }
    return true;
  }
  
  public boolean isSheetExist(String sheetName)
  {
    int index = workbook.getSheetIndex(sheetName);
    if (index == -1)
    {
      index = workbook.getSheetIndex(sheetName.toUpperCase());
      if (index == -1) {
        return false;
      }
      return true;
    }
    return true;
  }
  
  public int getColumnCount(String sheetName)
  {
    if (!isSheetExist(sheetName)) {
      return -1;
    }
    sheet = workbook.getSheet(sheetName);
    row = sheet.getRow(0);
    if (row == null) {
      return -1;
    }
    return row.getLastCellNum();
  }
  
  public static String HSSFCellToString(HSSFCell cell)
  {
    String cellValue = null;
    if (cell != null)
    {
      cellValue = cell.toString();
      cellValue = cellValue.trim();
    }
    else
    {
      cellValue = "";
    }
    return cellValue;
  }
  
  public HashMap<String, HashMap> getExcelDataAll()
  {
    int lastRow = sheet.getLastRowNum();
    
    HashMap<String, HashMap> result = new HashMap(lastRow);
    for (int i = 1; i <= sheet.getLastRowNum(); i++)
    {
      HashMap<String, String> testdata = new HashMap();
      for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
        try
        {
          testdata.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());
        }
        catch (Throwable localThrowable) {}
      }
      result.put(sheet.getRow(i).getCell(0).getStringCellValue(), testdata);
    }
    deviceDetails = result;
    return result;
  }
  
  public HashMap<String, HashMap> getExcelDataAll(String sheetName, String Flag, String FlagValue, String Key)
    throws Exception
  {
    sheet = workbook.getSheet(sheetName);
    
    int flagIndex = findColumnIndex(Flag);
    int keyIndex = findColumnIndex(Key);
    
    int lastRow = sheet.getLastRowNum();
    
    LinkedHashMap<String, HashMap> result = new LinkedHashMap(lastRow);
    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
      if (getCellData(i, flagIndex).equalsIgnoreCase(FlagValue))
      {
        LinkedHashMap<String, String> testdata = new LinkedHashMap();
        for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
          try
          {
            sheet.getRow(0).getCell(j).setCellType(1);
            sheet.getRow(i).getCell(j).setCellType(1);
            testdata.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());
          }
          catch (Throwable localThrowable) {}
        }
        try
        {
          result.put(sheet.getRow(i).getCell(keyIndex).getStringCellValue(), testdata);
        }
        catch (Throwable localThrowable1) {}
      }
    }
    TestData = result;
    return result;
  }
  
  public int findColumnIndex(String ColumnHeader)
  {
    int CurrentColumn = -1;
    XSSFRow fr = sheet.getRow(0);
    int ColumnCount = fr.getLastCellNum() - fr.getFirstCellNum();
    for (int i = 0; i <= ColumnCount - 1; i++) {
      if (fr.getCell(i).getStringCellValue().contains(ColumnHeader))
      {
        CurrentColumn = i;
        
        break;
      }
    }
    return CurrentColumn;
  }
  
  public static String Get_Data(String TestCase, String ColumnHeader)
  {
    LinkedHashMap<String, String> TC = (LinkedHashMap)TestData.get(TestCase);
    try
    {
      return (String)TC.get(ColumnHeader);
    }
    catch (Throwable e) {}
    return "null";
  }
  
  public static String Put_Data(String TestCase, String ColumnHeader, String Value)
  {
    try
    {
      String data = "";
      
      LinkedHashMap<String, String> TC = (LinkedHashMap)TestData.get(TestCase);
      if (TC == null) {
        return "Fail";
      }
      if (TC.containsKey(ColumnHeader))
      {
        data = (String)TC.get(ColumnHeader);
        data = data + ";" + Value;
      }
      else
      {
        data = Value;
      }
      TC.put(ColumnHeader, data);
      return "success";
    }
    catch (Throwable t)
    {
      t.printStackTrace();
    }
    return "fail";
  }
  
  public static String Put_Data_Replace(String TestCase, String ColumnHeader, String Value)
  {
    LinkedHashMap<String, String> TC = (LinkedHashMap)TestData.get(TestCase);
    
    String data = (String)TC.get(ColumnHeader);
    
    TC.put(ColumnHeader, Value);
    return "success";
  }
  
  public static boolean setCellDataWithCondtion(String colName, String rowName, String rowValue, String data)
  {
    try
    {
      int colNum = -1;
      int rowNameNum = -1;
      
      row = sheet.getRow(0);
      for (int i = 0; i < row.getLastCellNum(); i++)
      {
        String str = "";
        try
        {
          str = row.getCell(i).getStringCellValue().trim();
        }
        catch (Throwable localThrowable) {}
        if (str.equals(colName))
        {
          colNum = i;
          
          break;
        }
      }
      if (colNum == -1)
      {
        colNum = row.getLastCellNum();
        
        row.createCell(colNum);
        cell = row.getCell(colNum);
        cell.setCellValue(colName);
      }
      for (int i = 0; i < row.getLastCellNum() - 1; i++)
      {
        System.out.println(i + rowName + row.getCell(i).getStringCellValue());
        String s = "";
        try
        {
          s = row.getCell(i).getStringCellValue().trim();
        }
        catch (Throwable localThrowable1) {}
        if (s.equals(rowName.trim()))
        {
          rowNameNum = i;
          break;
        }
      }
      if (rowNameNum == -1) {
        return false;
      }
      int rowNum = searchField(srcSheetName, rowNameNum, rowValue);
      if (rowNum <= 0) {
        return false;
      }
      sheet.autoSizeColumn(colNum);
      row = sheet.getRow(rowNum);
      if (row == null) {
        row = sheet.createRow(rowNum);
      }
      cell = row.getCell(colNum);
      if (cell == null) {
        cell = row.createCell(colNum);
      }
      cell.setCellValue(data);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return false;
    }
    return true;
  }
  
  public static boolean Write_Data(String rowName, String ColumnHeader)
  {
    String s = "";
    try
    {
      Map<String, HashMap> map = TestData;
      
      HashMap<String, String> m = new HashMap();
      for (String key : map.keySet())
      {
        m = (HashMap)map.get(key);
        s = Get_Data(key, ColumnHeader);
        if (s != null) {
          setCellDataWithCondtion(ColumnHeader, rowName, key, s);
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return true;
  }
  
  public static void close()
  {
    try
    {
      System.out.println(fileFullPath + srcSheetName);
      fileOut = new FileOutputStream(fileFullPath);
      
      workbook.write(fileOut);
      fileOut.close();
    }
    catch (Throwable t)
    {
      t.printStackTrace();
    }
  }
  
  public static boolean Write_Data_All(String rowName, String ColumnHeaders)
  {
    String[] ch = ColumnHeaders.split(";");
    String[] arrayOfString1;
    int j = (arrayOfString1 = ch).length;
    for (int i = 0; i < j; i++)
    {
      String s = arrayOfString1[i];
      
      Write_Data(rowName, s);
    }
    close();
    return true;
  }
}
