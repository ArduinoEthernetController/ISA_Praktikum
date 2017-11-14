/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CommandControl.Controller;

/**
 * Class implements a Stack for the deleted Text and its position
 * @author Christoph
 */
public class DeletedItem
{
  private int cursorPosition;
  private String deletedText;
  
  /**
   * Constructor DeletedItem
   * @param cursorPosition - stores the start cursor position of the deleted text 
   * @param deletedText - stores the deleted text
   */
  public DeletedItem(int cursorPosition, String deletedText)
  {
    this.cursorPosition = cursorPosition;
    this.deletedText = deletedText;
  }
  /**
   * getDeletedItem
   * @return the current reference of the DeletedItem object
   */
  public DeletedItem getDeletedItem()
  {
    return this;
  }
  /**
   * getPosition
   * @return the current cursor position
   */ 
  public int getPosition()
  {
    return this.cursorPosition;
  }
  /**
   * getText
   * @return the deleted text 
   */
  public String getText()
  {
    return this.deletedText;
  }
}
