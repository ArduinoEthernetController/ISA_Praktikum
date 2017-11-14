/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CommandControl;

import View.MainView;
import hexeditor.HexEditorModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class UndoController is the ActionListener for the undo botton
 * 
 * @author Christoph
 */
public class UndoController implements ActionListener
{
  private MainView view;
  private HexEditorModel model;
  private CommandInvoker invoker;
  
  /**
   * Constructor
   * @param view - the Main View of the Application
   * @param hexEditorModel - the Datamodel of the Applicaton
   * @param invoker is to invoke the undoCommand
   */
  public UndoController(MainView view, HexEditorModel hexEditorModel, CommandInvoker invoker)
  {
    this.view = view;
    this.model = hexEditorModel;
    this.invoker = invoker;
  }
  
  /**
   *  Method registers all events to be listened for undo command
   */
  public void registerEvents()
  {
    // Undo
    view.getMniUndo().addActionListener(this);
    view.getBtnUndo().addActionListener(this);
    view.getPumUndo().addActionListener(this);
  }

  /**
   * Method registers all commands
  */
  public void registerCommands()
  {
   //invoker.addCommand(view, value);
  }
  /**
   * Method overrides the actionPerformed method and calls the undoCommand 
   * @param e current ActionEvent
   */
  @Override
  public void actionPerformed(ActionEvent e)
  {
    invoker.undoCommand();
  }

}
