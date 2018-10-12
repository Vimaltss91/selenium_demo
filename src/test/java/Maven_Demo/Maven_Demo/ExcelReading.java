import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetReading
{
  public static XSSFWorkbook workbook;
  public static XSSFSheet sheet;
  public static XSSFSheet sheet1;
  public static XSSFCell cell;
  public static XSSFRow row;
  public static FileInputStream fis = null;
  public static FileOutputStream fileOut = null;
  public static HashMap<String, HashMap> TestAdditionalDriver;
  public static HashMap<String, HashMap> TestAdditionalVehicle;
  public static String fileFullPath;
  public static String srcSheetName;
  public static String resultPath = "";
  public static String sheetName = "";
  
  public void ExcelReader(String sheetname)
  {
    String fileName = ".\\src\\main\\resources\\com\\ibm\\stax\\TestData\\Datasheet.xlsx";
    try
    {
      fis = new FileInputStream(new File(fileName));
      workbook = new XSSFWorkbook(fis);
      sheet = workbook.getSheet(sheetname);
      
      fileFullPath = fileName;
      sheetName = sheetname;
      fis.close();
    }
    catch (FileNotFoundException fnfEx)
    {
      fnfEx.printStackTrace();
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
  
  public HashMap<String, HashMap> getExcelDataSheet()
    throws Exception
  {
    sheet = workbook.getSheet(sheetName);
    int keyIndex = 0;
    if (sheetName.equalsIgnoreCase("AdditionalDriver")) {
      keyIndex = findColumnIndex("Driver_reference_number", sheet);
    } else if (sheetName.equalsIgnoreCase("AdditionalVehicle")) {
      keyIndex = findColumnIndex("Vehicle_reference_number", sheet);
    }
    int lastRow = sheet.getLastRowNum();
    
    LinkedHashMap<String, HashMap> result = new LinkedHashMap(lastRow);
    for (int i = 1; i <= sheet.getLastRowNum(); i++)
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
    if (sheetName.equalsIgnoreCase("AdditionalDriver")) {
      TestAdditionalDriver = result;
    } else if (sheetName.equalsIgnoreCase("AdditionalVehicle")) {
      TestAdditionalVehicle = result;
    }
    return result;
  }
  
  public int findColumnIndex(String ColumnHeader, XSSFSheet sheet)
  {
    int CurrentColumn = -1;
    
    XSSFRow fr = sheet.getRow(0);
    int ColumnCount = fr.getLastCellNum() - fr.getFirstCellNum();
    for (int i = 0; i < ColumnCount - 1; i++) {
      if (fr.getCell(i).getStringCellValue().contains(ColumnHeader))
      {
        CurrentColumn = i;
        
        break;
      }
    }
    return CurrentColumn;
  }
  
  public static String Get_Data(String ReferenceNum, String ColumnHeader, String SheetName)
  {
    LinkedHashMap<String, String> TC = null;
    if (SheetName.equalsIgnoreCase("AdditionalDriver")) {
      TC = (LinkedHashMap)TestAdditionalDriver.get(ReferenceNum);
    } else if (SheetName.equalsIgnoreCase("AdditionalVehicle")) {
      TC = (LinkedHashMap)TestAdditionalVehicle.get(ReferenceNum);
    }
    try
    {
      return (String)TC.get(ColumnHeader);
    }
    catch (Throwable e) {}
    return "null";
  }
  
  public static String Get_Data1(String ReferenceNum, String ColumnHeader, String SheetName)
  {
    LinkedHashMap<String, String> TC = null;
    TC = (LinkedHashMap)TestAdditionalVehicle.get(ReferenceNum);
    try
    {
      return (String)TC.get(ColumnHeader);
    }
    catch (Throwable e) {}
    return "null";
  }
  
  public HashMap<String, HashMap> getExcelDataSheet1()
    throws Exception
  {
    sheet1 = workbook.getSheet("AdditionalVehicle");
    int keyIndex = 0;
    keyIndex = findColumnIndex("Vehicle_reference_number", sheet1);
    int lastRow = sheet1.getLastRowNum();
    
    LinkedHashMap<String, HashMap> result = new LinkedHashMap(lastRow);
    for (int i = 1; i <= sheet1.getLastRowNum(); i++)
    {
      LinkedHashMap<String, String> testdata = new LinkedHashMap();
      for (int j = 0; j < sheet1.getRow(i).getLastCellNum(); j++) {
        try
        {
          sheet1.getRow(0).getCell(j).setCellType(1);
          sheet1.getRow(i).getCell(j).setCellType(1);
          testdata.put(sheet1.getRow(0).getCell(j).getStringCellValue(), sheet1.getRow(i).getCell(j).getStringCellValue());
        }
        catch (Throwable localThrowable) {}
      }
      try
      {
        result.put(sheet1.getRow(i).getCell(keyIndex).getStringCellValue(), testdata);
      }
      catch (Throwable localThrowable1) {}
    }
    TestAdditionalVehicle = result;
    
    return result;
  }
}
