/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CommandControl.Controller;

/**
 *
 * @author Christoph
 */
public class DeletedItem
{
  private int cursorPosition;
  private String deletedText;
  
  public DeletedItem(int cursorPosition, String deletedText)
  {
    this.cursorPosition = cursorPosition;
    this.deletedText = deletedText;
  }
  public DeletedItem getDeletedItem()
  {
    return this;
  }
   
  public int getPosition()
  {
    return this.cursorPosition;
  }
      
  public String getText()
  {
    return this.deletedText;
  }
}
