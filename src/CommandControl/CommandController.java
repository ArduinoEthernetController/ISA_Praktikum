/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CommandControl;

import CommandControl.Controller.DeleteLineController;
import CommandControl.Controller.OpenController;
import CommandControl.Controller.SaveAsController;
import CommandControl.Controller.SaveController;
import View.MainView;
import hexeditor.HexEditorModel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class CommandController implements all the functions to be listend by the Actionlistener
 * @author Christoph
 */
public class CommandController implements ActionListener
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
  public CommandController(MainView view, HexEditorModel hexEditorModel, CommandInvoker invoker)
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
    // Open
    view.getMniOpen().addActionListener(this);
    view.getBtnOpen().addActionListener(this);
    view.getPumOpen().addActionListener(this);
    
    // Save
    view.getMniSave().addActionListener(this);
    view.getBtnSave().addActionListener(this);
    view.getPumSave().addActionListener(this);
    
    // Save As
    view.getMniSaveAs().addActionListener(this);
    view.getBtnSaveAs().addActionListener(this);
    view.getPumSaveAs().addActionListener(this);
    
    // Delete Line
    view.getMniDeleteLine().addActionListener(this);
    view.getBtnDeleteLine().addActionListener(this);
    view.getPumDeleteLine().addActionListener(this);
    
  }

  /**
   *  Method registers all commends to be registered by the CommandInvoker
   */
  public void registerCommands()
  {
    // Open
    invoker.addCommand(view.getMniOpen(), new OpenController (view, model));
    invoker.addCommand(view.getBtnOpen(), new OpenController (view, model));
    invoker.addCommand(view.getPumOpen(), new OpenController (view, model));
    
    // Save
    invoker.addCommand(view.getMniSave(), new SaveController (view, model));
    invoker.addCommand(view.getBtnSave(), new SaveController (view, model));
    invoker.addCommand(view.getPumSave(), new SaveController (view, model));
    
    // Save As
    invoker.addCommand(view.getMniSaveAs(), new SaveAsController (view, model));
    invoker.addCommand(view.getBtnSaveAs(), new SaveAsController (view, model));
    invoker.addCommand(view.getPumSaveAs(), new SaveAsController (view, model));

    // Delete Line
    invoker.addCommand(view.getMniDeleteLine(), new DeleteLineController (view, model));
    invoker.addCommand(view.getBtnDeleteLine(), new DeleteLineController (view, model));
    invoker.addCommand(view.getPumDeleteLine(), new DeleteLineController (view, model));    
  }
  /**
   * override Method overrides the actionPerformed method and calls the undoCommand 
   * @param e current ActionEvent
   */
  @Override
  public void actionPerformed(ActionEvent e)
  {
    Component key = (Component)e.getSource();
    invoker.executeCommand(key);
  }
}
