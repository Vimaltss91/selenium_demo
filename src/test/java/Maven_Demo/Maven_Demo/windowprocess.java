package com.ibm.stax.InitialSetup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WindowsProcess
{
  private String processName;
  
  public void kill(String processName)
    throws Exception
  {
    this.processName = processName;
    if (isRunning()) {
      getRuntime().exec("taskkill /F /IM " + processName);
    }
  }
  
  private boolean isRunning()
    throws Exception
  {
    Process listTasksProcess = getRuntime().exec("tasklist");
    
    BufferedReader tasksListReader = new BufferedReader(
    
      new InputStreamReader(listTasksProcess.getInputStream()));
    String tasksLine;
    while ((tasksLine = tasksListReader.readLine()) != null)
    {
      String tasksLine;
      if (tasksLine.contains(this.processName)) {
        return true;
      }
    }
    return false;
  }
  
  private Runtime getRuntime()
  {
    return Runtime.getRuntime();
  }
  
  public static void main(String[] args)
    throws Exception
  {
    WindowsProcess w = new WindowsProcess();
    
    w.kill("chrome.exe");
  }
}
