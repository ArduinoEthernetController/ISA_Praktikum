/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hexeditor;

import CommandControl.CommandController;
import CommandControl.CommandInvoker;
import CommandControl.UndoController;
import View.MainView;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Builder Class
 *
 * @author Christoph
 */
public class Start
{
  public Start()
  {
    MainView mainView = new MainView();
    HexEditorModel model = new HexEditorModel();
    CommandInvoker invoker = new CommandInvoker();
    
    CommandController controller = new CommandController(mainView, model, invoker);
    controller.registerEvents();
    controller.registerCommands();
    
    UndoController undoController = new UndoController(mainView, model, invoker);
    undoController.registerEvents();
    
    mainView.setVisible(true);
    
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) 
  {
    try
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception ex)
    {
      JOptionPane.showConfirmDialog(null, ex.getMessage());
    }
    new Start();
  }
}
