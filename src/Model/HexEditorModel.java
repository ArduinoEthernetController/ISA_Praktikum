/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hexeditor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author le
 */
public class HexEditorModel 
{
  private String dataAsString;
  
  public HexEditorModel()
  {
    dataAsString = "";
  }
  
  public void readFile(File f) throws FileNotFoundException, IOException
  {
    BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
    
    int data;
    int col = 0;
    StringBuilder buffer = new StringBuilder();
    while ( (data = in.read()) >= 0)
    {
      buffer.append(String.format("%02X ", data));
      col++;
      if (col == 8) buffer.append(" ");
      if (col == 16) 
      {
        buffer.append("\n");
        col = 0;
      }
    }
    dataAsString = buffer.toString();
    in.close();
  }
  
  public String getDataAsString()
  {
    return dataAsString;
  }

  public void setDataAsString(String dataAsString)
  {
    this.dataAsString = dataAsString;
  }
  
  public void writeFile(File f) throws FileNotFoundException, NumberFormatException, IOException
  {
    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(f));
    
    dataAsString = dataAsString.replace(" ", "").replace("\n", "");
    
    String strValue;
    for (int i = 0; i < dataAsString.length(); i += 2)
    {
      strValue = dataAsString.substring(i, i+2);
      int value = Integer.parseInt(strValue, 16);
      out.write(value);
      
    }
    out.close();
    
  }
 
}
