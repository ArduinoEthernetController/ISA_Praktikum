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
 * 
 * @author Christoph
 * 
 */
public class DeleteLineController implements CommandInterface
{
  private MainView view;
  private HexEditorModel hexEditorModel;
  private Stack<DeletedItem> deletedItemStack;
  
  public DeleteLineController(MainView view, HexEditorModel hexEditorModel)
  {
    this.view = view;
    this.hexEditorModel = hexEditorModel;
    this.deletedItemStack = new Stack<>();
  }

  @Override
  public void execute()
  {
    try
    {
      int caretOffset = view.getTaEditor().getTaEditor().getCaretPosition();
      int lineNumber = view.getTaEditor().getTaEditor().getLineOfOffset(caretOffset);
      int startOffset = view.getTaEditor().getTaEditor().getLineStartOffset(lineNumber);
      int endOffset = view.getTaEditor().getTaEditor().getLineEndOffset(lineNumber);
      String taText = view.getTaEditor().getTaEditor().getText(startOffset, endOffset - startOffset);
      view.getTaEditor().getTaEditor().replaceRange("",startOffset, endOffset);
      
      deletedItemStack.push(new DeletedItem(startOffset, taText));
    }
    catch (BadLocationException ex)
    {
    }
  }
  
  @Override
  public void undo()
  { 
    if(!deletedItemStack.isEmpty())
    {
      DeletedItem buff = deletedItemStack.pop();
      view.getTaEditor().getTaEditor().insert(buff.getText(), buff.getPosition());
    }
  }

  @Override
  public MainView getView()
  {
    return this.view;
  }
}
