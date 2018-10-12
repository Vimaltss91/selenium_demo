import com.ibm.stax.Reporting.Extent_Reporting;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementAction
{
  public static Logger Log = null;
  Extent_Reporting r = null;
  
  public ElementAction()
  {
    Log = Logger.getLogger(getClass().getSimpleName());
    this.r = new Extent_Reporting();
  }
  
  public boolean isElementPresentByXpath(String xpath, WebDriver driver, String Element_Name)
    throws InterruptedException
  {
    try
    {
      driver.findElement(By.xpath(xpath));
      Extent_Reporting.Log_Pass(Element_Name + " Exist", Element_Name + " Exist");
      Log.info(Element_Name + " Exist");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", driver);
      t.printStackTrace();
      Log.error(t.getMessage());
      return false;
    }
    return true;
  }
  
  public boolean isElementPresentByLinkText(String linkText, WebDriver driver)
    throws InterruptedException
  {
    try
    {
      driver.findElement(By.linkText(linkText));
      Extent_Reporting.Log_Pass(linkText + " Exist", linkText + " Exist");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(linkText + " does not Exist", linkText + " does not Exist", driver);
      t.printStackTrace();Log.error(t.getMessage());
      return false;
    }
    return true;
  }
  
  public boolean isElementPresentByID(String ID, WebDriver driver, String Element_Name)
    throws InterruptedException
  {
    try
    {
      driver.findElement(By.id(ID));
      Extent_Reporting.Log_Pass(Element_Name + " Exist", Element_Name + " Exist");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", driver);
      t.printStackTrace();Log.error(t.getMessage());
      return false;
    }
    return true;
  }
  
  public boolean isElementPresentByName(String Name, WebDriver driver, String Element_Name)
    throws InterruptedException
  {
    try
    {
      driver.findElement(By.name(Name));
      Extent_Reporting.Log_Pass(Element_Name + " Exist", Element_Name + " Exist");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", driver);
      t.printStackTrace();Log.error(t.getMessage());
      return false;
    }
    return true;
  }
  
  public boolean isElementPresentByClassName(String className, WebDriver driver, String Element_Name)
    throws InterruptedException
  {
    try
    {
      driver.findElement(By.className(className));
      Extent_Reporting.Log_Pass(Element_Name + " Exist", Element_Name + " Exist");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", driver);
      t.printStackTrace();Log.error(t.getMessage());
      return false;
    }
    return true;
  }
  
  public void clickButtonID(WebDriver screenName, String ID, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement webButton = screenName.findElement(By.id(ID));
      webButton.click();
      Extent_Reporting.Log_Pass(Element_Name + " Clicked", Element_Name + " Clicked");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void clickButton(WebDriver screenName, String ObjectxPath, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement webButton = screenName.findElement(By.xpath(ObjectxPath));
      webButton.click();
      Extent_Reporting.Log_Pass(Element_Name + " Clicked", Element_Name + " Clicked");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void clickWebElement(WebDriver screenName, WebElement element, String Element_Name)
    throws Exception
  {
    try
    {
      element.click();
      Extent_Reporting.Log_Pass(Element_Name + " Clicked", Element_Name + " Clicked");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void clickLink(WebDriver screenName, String ObjectxPath, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement webButton = screenName.findElement(By.xpath(ObjectxPath));
      webButton.click();
      Extent_Reporting.Log_Pass(Element_Name + " Clicked", Element_Name + " Clicked");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void clickLinkByLinkText(WebDriver screenName, String linkText, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement webButton = screenName.findElement(By.linkText(linkText));
      webButton.click();
      Extent_Reporting.Log_Pass(Element_Name + " Clicked", Element_Name + " Clicked");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public boolean clickFirst(WebDriver screenName, String ObjectxPath, String Element_Name)
    throws Exception
  {
    boolean flag = true;
    try
    {
      WebElement webButton = screenName.findElement(By.xpath(ObjectxPath));
      webButton.click();
      Extent_Reporting.Log_Pass(Element_Name + " Clicked", Element_Name + " Clicked");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
    return flag;
  }
  
  public void inputText(WebDriver screenName, String ObjectxPath, String sValue, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
      inputText.clear();
      inputText.sendKeys(new CharSequence[] { sValue });
      Extent_Reporting.Log_Pass_Screenshot(Element_Name + " Entered", sValue + " entered in " + Element_Name, screenName);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void removeAttribute(WebDriver driver)
  {
    List<WebElement> inputs = driver.findElements(By.tagName("input"));
    for (WebElement input : inputs) {
      ((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", new Object[] { input });
    }
  }
  
  public void typeNonEditable(WebDriver driver, String ObjectxPath, String sValue, String Element_Name)
    throws Exception
  {
    removeAttribute(driver);
    inputText(driver, ObjectxPath, sValue, Element_Name);
  }
  
  public void enterText(WebDriver screenName, String ObjectxPath, String sValue, String Element_Name)
    throws Exception
  {
    Actions actions = new Actions(screenName);
    try
    {
      WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
      actions.moveToElement(inputText);
      actions.click();
      actions.sendKeys(new CharSequence[] { sValue });
      actions.build().perform();
      Extent_Reporting.Log_Pass(Element_Name + " Entered", sValue + " entered in " + Element_Name);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void inputTextByID(WebDriver screenName, String ID, String sValue, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement inputText = screenName.findElement(By.id(ID));
      inputText.sendKeys(new CharSequence[] { sValue });
      Extent_Reporting.Log_Pass(Element_Name + " Entered", sValue + " entered in " + Element_Name);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void selectCheckBox(WebDriver screenName, String ObjectxPath, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement checkBox = screenName.findElement(By.xpath(ObjectxPath));
      checkBox.click();
      Extent_Reporting.Log_Pass(Element_Name + " checkbox clicked", Element_Name + " checkbox clicked");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void selectRadio(WebDriver screenName, String ObjectxPath, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement radioButton = screenName.findElement(By.xpath(ObjectxPath));
      radioButton.click();
      Extent_Reporting.Log_Pass(Element_Name + " radiobutton clicked", Element_Name + " radiobutton clicked");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public String getInputTextValue(WebDriver screenName, String ObjectxPath, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
      Extent_Reporting.Log_Pass(Element_Name + " exist", Element_Name + " has " + inputText.getText());
      return inputText.getText();
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public String getInputValue(WebDriver screenName, String ObjectxPath, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
      Extent_Reporting.Log_Pass(Element_Name + " exist", Element_Name + " has " + inputText.getText());
      return inputText.getAttribute("value");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public String getAttributeValue(WebDriver screenName, String ObjectxPath, String attributeName, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
      Extent_Reporting.Log_Pass(Element_Name + " exist", Element_Name + " has " + inputText.getText());
      return inputText.getAttribute(attributeName);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void clearInputTextValue(WebDriver screenName, String ObjectxPath, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
      inputText.clear();
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void clearInputTextValueByName(WebDriver screenName, String name, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement inputText = screenName.findElement(By.name(name));
      inputText.clear();
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void clearAndInputTextValue(WebDriver screenName, String ObjectxPath, String value, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
      Thread.sleep(1000L);
      inputText.clear();
      Thread.sleep(1000L);
      inputText.sendKeys(new CharSequence[] { value });
      Extent_Reporting.Log_Pass(Element_Name + " cleared & Entered with " + value, Element_Name + " cleared & Entered with " + value);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void selectDropBoxValue(WebDriver screenName, String ObjectxPath, String value, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
      Select select = new Select(selectDropBox);
      select.selectByValue(value);
      Extent_Reporting.Log_Pass(Element_Name + " selected with " + value, Element_Name + " selected with " + value);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void selectDropBoxByVisibleText(WebDriver screenName, String ObjectxPath, String value, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
      Select select = new Select(selectDropBox);
      select.selectByVisibleText(value);
      Extent_Reporting.Log_Pass(Element_Name + " selected with " + value, Element_Name + " selected with " + value);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void selectDropBoxValueByID(WebDriver screenName, String ID, String value, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement selectDropBox = screenName.findElement(By.id(ID));
      Select select = new Select(selectDropBox);
      select.selectByValue(value);
      Extent_Reporting.Log_Pass(Element_Name + " selected with " + value, Element_Name + " selected with " + value);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void selectDropBoxValueByName(WebDriver screenName, String Name, String value, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement selectDropBox = screenName.findElement(By.name(Name));
      Select select = new Select(selectDropBox);
      select.selectByValue(value);
      Extent_Reporting.Log_Pass(Element_Name + " selected with " + value, Element_Name + " selected with " + value);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void selectDropBoxValue(WebDriver screenName, String ObjectxPath, int index, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
      Select select = new Select(selectDropBox);
      select.selectByIndex(index);
      Extent_Reporting.Log_Pass(Element_Name + " selected with " + index, Element_Name + " selected with " + index);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void selectDropBoxDefaultValue(WebDriver screenName, String ObjectxPath, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
      Select select = new Select(selectDropBox);
      select.selectByIndex(0);
      Extent_Reporting.Log_Pass(Element_Name + " selected with default value ", Element_Name + " selected with default value ");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public String getDropBoxDefaultValue(WebDriver screenName, String ObjectxPath, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
      Select select = new Select(selectDropBox);
      Extent_Reporting.Log_Pass(Element_Name + " selected value is " + select.getFirstSelectedOption().getText(), Element_Name + " selected value is " + select.getFirstSelectedOption().getText());
      return select.getFirstSelectedOption().getText();
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public String getDropBoxSelectedValue(WebDriver screenName, String ObjectxPath, int index, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
      Select select = new Select(selectDropBox);
      Extent_Reporting.Log_Pass(Element_Name + " selected value is " + select.getFirstSelectedOption().getText(), Element_Name + " selected value is " + select.getFirstSelectedOption().getText());
      return ((WebElement)select.getOptions().get(index)).getText();
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public int getDropBoxSize(WebDriver screenName, String ObjectxPath, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
      Select select = new Select(selectDropBox);
      Extent_Reporting.Log_Pass(Element_Name + " dropbox size is " + select.getOptions().size(), Element_Name + " dropbox size is " + select.getOptions().size());
      return select.getOptions().size();
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public String[] getDropBoxValue(WebDriver screenName, String ObjectxPath, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
      Select select = new Select(selectDropBox);
      List<WebElement> optionValue = select.getOptions();
      String[] value = new String[optionValue.size()];
      for (int i = 0; i < optionValue.size(); i++) {
        value[i] = ((WebElement)optionValue.get(i)).getText();
      }
      return value;
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public int getTotalTableCell(WebDriver driver, String ObjectxPath, String Element_Name)
    throws Exception
  {
    try
    {
      Extent_Reporting.Log_Pass(Element_Name + " table size is " + driver.findElements(By.xpath(ObjectxPath)).size(), Element_Name + " table size is " + driver.findElements(By.xpath(ObjectxPath)).size());
      return driver.findElements(By.xpath(ObjectxPath)).size();
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", driver);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public int getElementsSize(WebDriver driver, String ObjectxPath, String Element_Name)
    throws Exception
  {
    try
    {
      Extent_Reporting.Log_Pass(Element_Name + " element size is " + driver.findElements(By.xpath(ObjectxPath)).size(), Element_Name + " element size is " + driver.findElements(By.xpath(ObjectxPath)).size());
      return driver.findElements(By.xpath(ObjectxPath)).size();
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", driver);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public int getElementCount(WebDriver driver, String className, String Element_Name)
    throws Exception
  {
    int count = 0;
    try
    {
      count = driver.findElements(By.className(className)).size();
      Extent_Reporting.Log_Pass(Element_Name + " element count " + count, Element_Name + " element size is " + count);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", driver);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
    return count;
  }
  
  public boolean isElementEnabled(WebDriver driver, String xpath, String Element_Name)
  {
    boolean flag = false;
    try
    {
      if (driver.findElement(By.xpath(xpath)).isEnabled())
      {
        Extent_Reporting.Log_Pass(Element_Name + " is Enabled ", Element_Name + " is Enabled ");
        flag = true;
      }
    }
    catch (Throwable e)
    {
      Extent_Reporting.Log_Pass(Element_Name + " is disabled ", Element_Name + " is disabled ");
      flag = false;
    }
    return flag;
  }
  
  public boolean isElementDisplayed(WebDriver driver, String xpath, String Element_Name)
    throws InterruptedException
  {
    boolean flag = false;
    try
    {
      if (driver.findElement(By.xpath(xpath)).isDisplayed())
      {
        Extent_Reporting.Log_Pass_Screenshot(Element_Name + " is displayed ", Element_Name + " is displayed ", driver);
        flag = true;
      }
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " is not displayed ", Element_Name + " is not displayed ", driver);
      flag = false;
      Log.error(t.getMessage());
    }
    return flag;
  }
  
  public boolean isElementDisplay(WebDriver driver, String xpath)
  {
    boolean flag = false;
    try
    {
      if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
        flag = true;
      }
    }
    catch (Throwable e)
    {
      e.printStackTrace();
      flag = false;
      Log.error(e.getMessage());
    }
    return flag;
  }
  
  public void mouseHoverAction_3(WebDriver driver, String mainElementXP, String subElementXP, String subSubElementXP, String Element_Name)
    throws Exception
  {
    try
    {
      Actions action = new Actions(driver);
      WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
      action.moveToElement(mainElement).perform();
      WebElement subElement = driver.findElement(By.xpath(subElementXP));
      action.moveToElement(subElement).perform();
      WebElement subSubElement = driver.findElement(By.xpath(subSubElementXP));
      action.moveToElement(subSubElement);
      action.click();
      action.perform();
      
      Extent_Reporting.Log_Pass("Click action is performed on the selected Product Type" + Element_Name, "Click action is performed on the selected Product Type" + Element_Name);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", driver);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void mouseHoverAction_2(WebDriver driver, String mainElementXP, String subElementXP, String Element_Name)
    throws Exception
  {
    try
    {
      Actions action = new Actions(driver);
      WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
      action.moveToElement(mainElement).perform();
      WebElement subElement = driver.findElement(By.xpath(subElementXP));
      action.moveToElement(subElement);
      action.click();
      action.perform();
      
      Extent_Reporting.Log_Pass("Click action is performed on the selected Product Type" + Element_Name, "Click action is performed on the selected Product Type" + Element_Name);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", driver);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void mouseHoverAction(WebDriver driver, String mainElementXP, String Element_Name)
    throws Exception
  {
    try
    {
      Actions action = new Actions(driver);
      WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
      action.moveToElement(mainElement).clickAndHold().build().perform();
      action.release().perform();
      
      Extent_Reporting.Log_Pass("Click action is performed on the selected Product Type" + Element_Name, "Click action is performed on the selected Product Type" + Element_Name);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", driver);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void mouseHoverAction(WebDriver driver, String mainElementXP, String subElementXP, String subSubElementXP, String subBesideElementXP, String Element_Name)
    throws Exception
  {
    try
    {
      Actions action = new Actions(driver);
      WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
      action.moveToElement(mainElement).perform();
      WebElement subElement = driver.findElement(By.xpath(subElementXP));
      action.moveToElement(subElement).perform();
      WebElement subSubElement = driver.findElement(By.xpath(subSubElementXP));
      action.moveToElement(subSubElement).perform();
      WebElement subBesideElement = driver.findElement(By.xpath(subBesideElementXP));
      action.moveToElement(subBesideElement).perform();
      action.click();
      action.perform();
      
      Extent_Reporting.Log_Pass("Click action is performed on the selected Product Type" + Element_Name, "Click action is performed on the selected Product Type" + Element_Name);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", driver);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void selectclass(WebDriver driver, WebElement parent, String elementToSelect, String Element_Name)
    throws Exception
  {
    try
    {
      Select dropdown = new Select(parent);
      dropdown.selectByVisibleText(elementToSelect);
      Extent_Reporting.Log_Pass("selected " + elementToSelect, "selected " + elementToSelect + "in " + parent);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", driver);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void getWindowHandle(WebDriver driver, String title)
  {
    Set<String> handles = driver.getWindowHandles();
    
    String[] browser = (String[])handles.toArray(new String[0]);
    System.out.println("Number of browsers opened are" + 
      browser.length);
    for (int i = 0; i < handles.size(); i++)
    {
      driver.switchTo().window(browser[i]);
      if (driver.getTitle().equals(title)) {
        driver.getWindowHandle();
      }
    }
  }
  
  public void selectWindowIfElementPresent(WebDriver driver, String element)
    throws InterruptedException
  {
    Thread.sleep(2000L);
    Set<String> windows = driver.getWindowHandles();
    Object[] win = windows.toArray();System.out.println(win.length);
    driver.switchTo().window(win[0].toString());
    if (isElementDisplay(driver, element))
    {
      Extent_Reporting.Log_Pass("Selected Pop Up : " + driver.switchTo().window(win[0].toString()).getTitle(), "Selected Pop Up : " + driver.switchTo().window(win[0].toString()).getTitle());
    }
    else
    {
      driver.switchTo().window(win[1].toString());
      System.out.println("Selected Pop Up : " + driver.switchTo().window(win[1].toString()).getTitle());
    }
  }
  
  public void waitForElementNotPresent(WebDriver driver, String element)
  {
    try
    {
      WebDriverWait wait = new WebDriverWait(driver, 30L);
      wait.until(ExpectedConditions.elementToBeSelected(By.xpath(element)));
    }
    catch (TimeoutException t)
    {
      Log.error(t.getMessage());
    }
  }
  
  public void waitForElementVisible(WebDriver driver, String element)
  {
    try
    {
      WebDriverWait wait = new WebDriverWait(driver, 30L);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }
    catch (NoSuchWindowException e)
    {
      Log.error(e.getMessage());
    }
    catch (InvalidElementStateException e)
    {
      Log.error(e.getMessage());
    }
    catch (TimeoutException te)
    {
      Log.error(te.getMessage());
    }
    catch (NoSuchElementException e)
    {
      Log.error(e.getMessage());
    }
    catch (WebDriverException we)
    {
      Log.error(we.getMessage());
    }
  }
  
  public void waitForElementClickable(WebDriver driver, String element, String text)
  {
    try
    {
      WebDriverWait localWebDriverWait = new WebDriverWait(driver, 30L);
    }
    catch (NoSuchWindowException e)
    {
      Log.error(e.getMessage());
    }
    catch (InvalidElementStateException e)
    {
      Log.error(e.getMessage());
    }
    catch (TimeoutException te)
    {
      Log.error(te.getMessage());
    }
    catch (NoSuchElementException e)
    {
      Log.error(e.getMessage());
    }
    catch (WebDriverException we)
    {
      Log.error(we.getMessage());
    }
  }
  
  public void waitForTextPresent(WebDriver driver, String text)
    throws InterruptedException
  {
    try
    {
      Thread.sleep(2000L);
      long timer = 0L;
      do
      {
        Thread.sleep(500L);
        timer += 5000L;
        if (isTextPresent(driver, text)) {
          break;
        }
      } while (timer < Long.valueOf("30000").longValue());
    }
    catch (NoSuchWindowException e)
    {
      Log.error(e.getMessage());
    }
  }
  
  public void waitForPageToLoad(WebDriver driver)
  {
    driver.manage().timeouts().implicitlyWait(Integer.parseInt(Create_TestNGXML.getConfigData("TimeOut")), TimeUnit.SECONDS);
  }
  
  public boolean isTextPresent(WebDriver driver, String text)
  {
    boolean flag = false;
    try
    {
      flag = driver.findElement(By.xpath("//*[contains(.,'" + text + "')]")).isDisplayed();
    }
    catch (NoSuchElementException e)
    {
      Log.error(e.getMessage());
      return flag;
    }
    catch (NoSuchWindowException e)
    {
      Log.error(e.getMessage());
      return flag;
    }
    return flag;
  }
  
  public void getTableData(WebDriver driver, String xpath)
  {
    WebElement table = driver.findElement(By.xpath(xpath));
    
    List<WebElement> allRows = table.findElements(By.tagName("tr"));
    Iterator localIterator2;
    for (Iterator localIterator1 = allRows.iterator(); localIterator1.hasNext(); localIterator2.hasNext())
    {
      WebElement row = (WebElement)localIterator1.next();
      List<WebElement> cells = row.findElements(By.tagName("td"));
      
      localIterator2 = cells.iterator(); continue;WebElement cell = (WebElement)localIterator2.next();
      System.out.println(cell.getText());
    }
  }
  
  public String getObjectValue(WebDriver driver, WebElement webElement)
  {
    JavascriptExecutor e = (JavascriptExecutor)driver;
    return (String)e.executeScript(String.format("return $('#%s').val();", new Object[] { webElement.getAttribute("id") }), new Object[0]);
  }
  
  public String getObjectValueClass(WebDriver driver, WebElement webElement)
  {
    JavascriptExecutor e = (JavascriptExecutor)driver;
    return (String)e.executeScript(String.format("return $('#%s').val();", new Object[] { webElement.getAttribute("class") }), new Object[0]);
  }
  
  public int getElementCountXPath(WebDriver driver, String ObjectPath, String Element_Name)
    throws InterruptedException
  {
    int count = 0;
    if (isElementPresentByXpath(ObjectPath, driver, Element_Name)) {
      count = driver.findElements(By.xpath(ObjectPath)).size();
    }
    return count;
  }
  
  public void acceptAlert(WebDriver driver)
    throws InterruptedException
  {
    try
    {
      Alert alert = waitforAlertPresent(driver);
      if (!alert.equals(null)) {
        alert.accept();
      }
    }
    catch (NoAlertPresentException ex)
    {
      Log.error(ex.getMessage());
    }
  }
  
  public Alert waitforAlertPresent(WebDriver driver)
    throws InterruptedException
  {
    int i = 0;
    Alert alert = null;
    while (i++ < 30) {
      try
      {
        return driver.switchTo().alert();
      }
      catch (NoAlertPresentException e)
      {
        Thread.sleep(1000L);
      }
    }
    return alert;
  }
  
  public void waitForPopUp(WebDriver driver, String b)
    throws InterruptedException
  {
    Thread.sleep(3000L);
    try
    {
      selectPopUp(driver, b);
      driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
    }
    catch (NoSuchWindowException e)
    {
      Log.error(e.getMessage());
    }
    catch (Exception e)
    {
      Log.error(e.getMessage());
    }
  }
  
  public void selectPopUp(WebDriver driver, String arg)
  {
    boolean flag = false;
    try
    {
      int i = 0;
      do
      {
        Set<String> pops = driver.getWindowHandles();
        Iterator<String> it = pops.iterator();
        if (pops.size() > 1)
        {
          System.out.println("No of Windows " + pops.size());
          for (int j = 0; (j < pops.size()) && (!flag); j++)
          {
            String popupHandle = ((String)it.next()).toString();
            if (driver.switchTo().window(popupHandle).getTitle().contains(arg))
            {
              driver.switchTo().window(popupHandle);
              flag = true;
            }
          }
          flag = true;
          pops.clear();
        }
        i++;
        if (i >= 2) {
          break;
        }
      } while (!flag);
    }
    catch (NoSuchWindowException e)
    {
      Log.error(e.getMessage());
      System.out.println("Not able to Navigate to Window " + arg);
    }
    catch (Exception e)
    {
      Log.error(e.getMessage());
    }
  }
  
  public void checkUsingJavaScript(WebDriver driver, String obj, String ObjectName)
    throws InterruptedException
  {
    try
    {
      WebElement element = null;
      if (obj.startsWith("id")) {
        element = driver.findElement(By.id(obj.split("id:")[1]));
      } else if (obj.startsWith("name")) {
        element = driver.findElement(By.name(obj.split("name:")[1]));
      } else {
        element = driver.findElement(By.xpath(obj));
      }
      JavascriptExecutor executor = (JavascriptExecutor)driver;
      executor.executeScript("arguments[0].click();", new Object[] { element });
      Extent_Reporting.Log_Pass(ObjectName + " clicked", ObjectName + " Ciicked");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(ObjectName + " Not Present", ObjectName + " Not Present", driver);
      t.printStackTrace();
      Log.error(t.getMessage());
      new Exception(ObjectName + " not present");
    }
  }
  
  public void waitForFrameAndSwitch(WebDriver driver, String frameName)
  {
    WebDriverWait wait = new WebDriverWait(driver, 60L);
    driver.switchTo().defaultContent();
  }
  
  public void waitForFrameAndSwitch(String frameXpath, WebDriver driver)
  {
    WebDriverWait wait = new WebDriverWait(driver, 60L);
    driver.switchTo().defaultContent();
  }
  
  public void waitForElementVisible(WebDriver driver, String element, String Element_Name)
    throws Throwable
  {
    try
    {
      WebDriverWait localWebDriverWait = new WebDriverWait(driver, 30L);
    }
    catch (Throwable we)
    {
      we.printStackTrace();
      Log.error(we.getMessage());
      Extent_Reporting.Log_Fail(Element_Name + "Not visible", Element_Name + "Not visible", driver);
    }
  }
  
  public void Javascriptexecutor_InputText(WebDriver driver, String XpathObject, String sValue, String Element_Name)
    throws Throwable
  {
    waitForPageToLoad(driver);
    try
    {
      WebElement inputText = driver.findElement(By.xpath(XpathObject));
      
      JavascriptExecutor myExecutor = (JavascriptExecutor)driver;
      
      myExecutor.executeScript("arguments[0].value='" + sValue + "';", new Object[] { inputText });
      
      Extent_Reporting.Log_Pass(Element_Name + " Entered", sValue + " entered in " + Element_Name);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(XpathObject + " Not Present", XpathObject + " Not Present", driver);
      t.printStackTrace();
      new Exception(XpathObject + " not present");
    }
  }
  
  public void Javascriptexecutor_forClick(WebDriver driver, String frameName, String XpathObject, String ObjectName)
    throws Throwable
  {
    waitForPageToLoad(driver);
    waitForFrameAndSwitch(driver, frameName);
    waitForPageToLoad(driver);
    waitForElementVisible(driver, XpathObject, ObjectName);
    try
    {
      WebElement e = driver.findElement(By.xpath(XpathObject));
      JavascriptExecutor js = (JavascriptExecutor)driver;
      js.executeScript("arguments[0].click();", new Object[] { e });
      Extent_Reporting.Log_Pass(ObjectName + " clicked", ObjectName + " Ciicked");
      js = null;
      e = null;
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(ObjectName + " Not Present", ObjectName + " Not Present", driver);
      t.printStackTrace();
      Log.error(t.getMessage());
      new Exception(ObjectName + " not present");
    }
  }
  
  public String[] findElementsInArray(WebDriver driver, String ObjectxPath, String ObjectName)
    throws InterruptedException, Exception
  {
    String[] array = null;
    int i = 0;
    if (isElementPresentByXpath(ObjectxPath, driver, ObjectName))
    {
      List<WebElement> list = driver.findElements(By.xpath(ObjectxPath));
      array = new String[list.size()];
      Iterator<WebElement> it = list.iterator();
      while (it.hasNext()) {
        array[(i++)] = ((WebElement)it.next()).getText();
      }
    }
    else
    {
      Extent_Reporting.Log_Fail("findElementsInArray", ObjectxPath + " is not present", driver);
      throw new Exception("findElementsInArray() --- >Element Not Present");
    }
    return array;
  }
  
  public void removeAttribute(WebDriver driver, String ObjectXpath)
  {
    WebElement input = driver.findElement(By.xpath(ObjectXpath));
    
    ((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('disabled','disabled')", new Object[] { input });
  }
  
  public void clickUsingActions(WebDriver screenName, String ObjXpath, String Element_Name)
    throws Exception
  {
    try
    {
      Actions actions = new Actions(screenName);
      WebElement webButton = screenName.findElement(By.xpath(ObjXpath));
      actions.click(webButton);
      Extent_Reporting.Log_Pass(Element_Name + " Clicked", Element_Name + " Clicked");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public List<WebElement> findElementsInList(WebDriver driver, String ObjectxPath, String ObjectName)
    throws InterruptedException, Exception
  {
    List<WebElement> list = null;
    if (isElementPresentByXpath(ObjectxPath, driver, ObjectName))
    {
      list = driver.findElements(By.xpath(ObjectxPath));
    }
    else
    {
      Extent_Reporting.Log_Fail("findElementsInArray", ObjectxPath + " is not present", driver);
      throw new Exception("findElementsInArray() --- >Element Not Present");
    }
    return list;
  }
  
  public boolean selectWindow(String windowname, WebDriver driver)
  {
    try
    {
      Thread.sleep(1000L);
    }
    catch (InterruptedException e1)
    {
      Log.error(e1.getMessage());
      e1.printStackTrace();
    }
    boolean selWindow = false;
    try
    {
      if (windowname != null)
      {
        if (windowname.contains("null"))
        {
          switchToWindow(1, driver);
          selWindow = true;
        }
        else
        {
          selectPopUp(windowname, driver);
          selWindow = true;
        }
      }
      else
      {
        switchToWindow(1, driver);
        selWindow = true;
      }
    }
    catch (Exception e)
    {
      e.getMessage();
      e.printStackTrace();
      switchToWindow(1, driver);
      selWindow = false;
      Log.error(e.getMessage());
    }
    return selWindow;
  }
  
  public void switchToWindow(int WindowNumber, WebDriver driver)
  {
    WindowNumber--;
    
    Set<String> windows = driver.getWindowHandles();
    
    Object[] win = windows.toArray();
    
    driver.switchTo().window(win[WindowNumber].toString());
  }
  
  public void selectPopUp(String arg, WebDriver driver)
  {
    boolean flag = false;
    try
    {
      int i = 0;
      do
      {
        Set<String> pops = driver.getWindowHandles();
        
        Iterator<String> it = pops.iterator();
        if (pops.size() > 1)
        {
          System.out.println("No of Windows " + pops.size());
          for (int j = 0; (j < pops.size()) && (!flag); j++)
          {
            String popupHandle = ((String)it.next()).toString();
            if (driver.switchTo().window(popupHandle).getTitle().contains(arg))
            {
              driver.switchTo().window(popupHandle);
              
              flag = true;
            }
          }
          pops.clear();
        }
        i++;
        if (i >= 2) {
          break;
        }
      } while (!flag);
    }
    catch (NoSuchWindowException e)
    {
      Log.error(e.getMessage());
      System.out.println("Not able to Navigate to Window " + arg);
    }
    catch (Exception e)
    {
      Log.error(e.getMessage());
    }
  }
  
  public void waitUntilExist(WebDriver driver, String ObjectxPath)
    throws Exception
  {
    driver.manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
    int i = 1;
    do
    {
      i++;
      Thread.sleep(10000L);
      try
      {
        WebElement webButton = driver.findElement(By.xpath(ObjectxPath));
        System.out.println("X" + i);
        webButton.getText();
      }
      catch (Throwable t)
      {
        break;
      }
    } while (
    
      i < 100);
    waitForPageToLoad(driver);
  }
  
  public boolean CheckifExist(WebDriver driver, String element, int number)
  {
    try
    {
      driver.manage().timeouts().implicitlyWait(number, TimeUnit.MILLISECONDS);
      WebDriverWait wait = new WebDriverWait(driver, number);
      
      waitForPageToLoad(driver);
      return true;
    }
    catch (Exception e)
    {
      System.out.println("not exist");
      waitForPageToLoad(driver);
      Log.error(e.getMessage());
    }
    return false;
  }
  
  public void Clickbtn(WebDriver screenName, String ObjectxPath, String Element_Name)
    throws Exception
  {
    Thread.sleep(500L);
    try
    {
      WebElement webButton = screenName.findElement(By.xpath(ObjectxPath));
      webButton.click();
      Extent_Reporting.Log_Pass(Element_Name + " Clicked", Element_Name + " Clicked");
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public void WaitFunction(WebDriver driver, String Message)
    throws Exception
  {
    waitUntilExist(driver, "//*[contains(text(),'Loading...')]");
    waitUntilExist(driver, "//*[contains(text(),'Loading...')]");
    if (CheckifExist(driver, "//*[contains(text(),'Attention')]", 3))
    {
      Extent_Reporting.Log_Fail("Attention Error Occured", "Attention Error Occured" + Message, driver);
      new Exception("Attention Error Occured");
    }
  }
  
  public void waituntilDisplayed(WebDriver driver, String xpath)
    throws InterruptedException
  {
    int i = 1;
    
    boolean x = false;
    do
    {
      i++;
      Thread.sleep(2000L);
      try
      {
        x = driver.findElement(By.xpath(xpath)).isDisplayed();
      }
      catch (Throwable localThrowable) {}
    } while ((i != 60) && 
    
      (!x));
  }
  
  public boolean CheckifTextExistAndReport(WebDriver driver, String element, String Element_Name)
    throws InterruptedException
  {
    try
    {
      String Strelement = "//*[contains(text(),'" + element + "')]";
      driver.findElement(By.xpath(Strelement));
      Extent_Reporting.Log_Pass(Element_Name + " Exist", Element_Name + " is Exist");
      System.out.println("Element Exist");
      waitForPageToLoad(driver);
      return true;
    }
    catch (Throwable t)
    {
      waitForPageToLoad(driver);
      System.out.println("not exist");
      t.printStackTrace();
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + "does not Exist", driver);
      Log.error(t.getMessage());
    }
    return false;
  }
  
  public boolean CheckifExistwithWait(WebDriver driver, String element)
  {
    try
    {
      driver.findElement(By.xpath(element));
      
      return true;
    }
    catch (Throwable e)
    {
      Log.error(e.getMessage());
    }
    return false;
  }
  
  public void MouseClick(WebDriver driver, String Xpath)
    throws AWTException
  {
    Robot bot = new Robot();
    WebElement e = driver.findElement(By.xpath(Xpath));
    int x = e.getLocation().getX();
    int y = e.getLocation().getY();
    System.out.println(x + " " + y);
    bot.mouseMove(x, y);
    bot.mousePress(16);
    bot.mouseRelease(16);
  }
  
  public int getTableRowCount(WebDriver driver, String xapth)
  {
    try
    {
      WebElement htmltable = driver.findElement(By.xpath(xapth));
      
      List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
      
      System.out.println(rows.size());
      return rows.size();
    }
    catch (Throwable t)
    {
      t.printStackTrace();
      Log.error(t.getMessage());
    }
    return 0;
  }
  
  public boolean CheckifTextExistwithoutReport(WebDriver driver, String element, String Element_Name)
    throws InterruptedException
  {
    try
    {
      String Strelement = "//*[contains(text(),'" + element + "')]";
      driver.findElement(By.xpath(Strelement));
      
      System.out.println("Element Exist");
      
      waitForPageToLoad(driver);
      return true;
    }
    catch (Throwable t)
    {
      waitForPageToLoad(driver);
      System.out.println("not exist");
      
      Log.error(t.getMessage());
    }
    return false;
  }
  
  public void Javascriptexecutor_forClick(WebDriver driver, String XpathObject, String ObjectName)
    throws Throwable
  {
    waitForPageToLoad(driver);
    waitForPageToLoad(driver);
    try
    {
      WebElement e = driver.findElement(By.xpath(XpathObject));
      JavascriptExecutor js = (JavascriptExecutor)driver;
      js.executeScript("arguments[0].click();", new Object[] { e });
      Extent_Reporting.Log_Pass(ObjectName + " clicked", ObjectName + " Ciicked");
      js = null;
      e = null;
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(ObjectName + " Not Present", ObjectName + " Not Present", driver);
      t.printStackTrace();
      Log.error(t.getMessage());
      new Exception(ObjectName + " not present");
    }
  }
  
  public void javascriptExecutor_Setvalue(WebDriver driver, String Xpath, String data, String ElementName)
  {
    WebElement VVIN = driver.findElement(By.xpath(Xpath));
    JavascriptExecutor myExecutor = (JavascriptExecutor)driver;
    
    myExecutor.executeScript("arguments[0].value='" + data + "';", new Object[] { VVIN });
    Extent_Reporting.Log_Pass(ElementName + " is set with " + data, ElementName + " is set with " + data);
  }
  
  public void inputTextwithClick(WebDriver screenName, String ObjectxPath, String sValue, String Element_Name)
    throws Exception
  {
    try
    {
      WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
      
      inputText.click();
      inputText.clear();
      System.out.println(sValue);
      inputText.sendKeys(new CharSequence[] { sValue });
      inputText.sendKeys(new CharSequence[] { Keys.ENTER });
      Extent_Reporting.Log_Pass(Element_Name + " Entered", sValue + " entered in " + Element_Name);
    }
    catch (Throwable t)
    {
      Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + " does not Exist", screenName);
      t.printStackTrace();
      Log.error(t.getMessage());
      throw new Exception("Element Not Present");
    }
  }
  
  public boolean verifyAssendingSort(int[] array)
  {
    for (int i = 1; i > array.length; i++) {
      if (array[i] < array[(i + 1)]) {
        int i = 1;
      } else {
        return false;
      }
    }
    return true;
  }
  
  public boolean verifyAssendingSort(String[] array)
  {
    String previous = "";
    String[] arrayOfString;
    int j = (arrayOfString = array).length;
    for (int i = 0; i < j; i++)
    {
      String current = arrayOfString[i];
      if (current.compareTo(previous) < 0) {
        return false;
      }
      previous = current;
    }
    return true;
  }
}
