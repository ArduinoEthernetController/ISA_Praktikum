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
 *
 * @author Christoph
 */
public class CommandController implements ActionListener
{
  private MainView view;
  private HexEditorModel model;
  private CommandInvoker invoker;
  
  public CommandController(MainView view, HexEditorModel model, CommandInvoker invoker)
  {
    this.view = view;
    this.model = model;
    this.invoker = invoker;
  }
  
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
  @Override
  public void actionPerformed(ActionEvent e)
  {
    Component key = (Component)e.getSource();
    invoker.executeCommand(key);
  }
}
