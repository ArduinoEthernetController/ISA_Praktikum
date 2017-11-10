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
 *
 * @author Christoph
 */
public class UndoController implements ActionListener
{
  private MainView view;
  private HexEditorModel model;
  private CommandInvoker invoker;
  
  public UndoController(MainView view, HexEditorModel model, CommandInvoker invoker)
  {
    this.view = view;
    this.model = model;
    this.invoker = invoker;
  }
  
  public void registerEvents()
  {
    // Undo
    view.getMniUndo().addActionListener(this);
    view.getBtnUndo().addActionListener(this);
    view.getPumUndo().addActionListener(this);
  }

  public void registerCommands()
  {
   //invoker.addCommand(view, value);
  }
  @Override
  public void actionPerformed(ActionEvent e)
  {
    invoker.undoCommand();
  }

}
