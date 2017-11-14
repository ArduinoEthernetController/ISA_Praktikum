/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CommandControl.Controller;

import CommandControl.CommandInterface;
import View.MainView;
import hexeditor.HexEditorModel;
import java.util.Stack;
import javax.swing.text.BadLocationException;

/**
 * Class DeleteLineController implements the interface CommandInterface
 * handles the actions of all elements which realize the deleteLine function of the application
 * 
 * @author Christoph
 * 
 */
public class DeleteLineController implements CommandInterface
{
  private MainView view;
  private HexEditorModel hexEditorModel;
  private Stack<DeletedItem> deletedItemStack;
  
  /**
   * 
   * @param view - the Main View of the Application
   * @param hexEditorModel  - the Datamodel of the Applicaton
   */
  public DeleteLineController(MainView view, HexEditorModel hexEditorModel)
  {
    this.view = view;
    this.hexEditorModel = hexEditorModel;
    this.deletedItemStack = new Stack<>();
  }
  /**
   * overrides of interface method execute
   * Method execute deletes the marked line of the JTextArea
   */

  @Override
  public void execute()
  {
    try
    {
      int caretOffset = view.getTaEditor().getTaEditor().getCaretPosition();
      int lineNumber = view.getTaEditor().getTaEditor().getLineOfOffset(caretOffset);
      int startOffset = view.getTaEditor().getTaEditor().getLineStartOffset(lineNumber);
      int endOffset = view.getTaEditor().getTaEditor().getLineEndOffset(lineNumber);
      
      if(endOffset - startOffset > 0){
        String taText = view.getTaEditor().getTaEditor().getText(startOffset, endOffset - startOffset);
        view.getTaEditor().getTaEditor().replaceRange("",startOffset, endOffset);
        deletedItemStack.push(new DeletedItem(startOffset, taText));
      }
    }
    catch (BadLocationException ex)
    {
    }
  }
  
  /**
   * overrides of interface method undo
   * Method undo get the deleted text and its position from the deletedItem-Stack and returns it to the TextArea
   */
  @Override
  public void undo()
  { 
    if(!deletedItemStack.isEmpty())
    {
      DeletedItem buff = deletedItemStack.pop();
      view.getTaEditor().getTaEditor().insert(buff.getText(), buff.getPosition());
    }
  }
  /**
   * Method returns the current MainView
   * @return the current MainView reference
   */

  @Override
  public MainView getView()
  {
    return this.view;
  }
}
