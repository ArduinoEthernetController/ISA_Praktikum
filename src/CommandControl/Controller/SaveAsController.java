/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CommandControl.Controller;

import CommandControl.CommandInterface;
import View.MainView;
import hexeditor.HexEditorModel;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Christoph
 */
public class SaveAsController implements CommandInterface
{
  private MainView view;
  private HexEditorModel hexEditorModel;
  
  public SaveAsController(MainView view, HexEditorModel hexEditorModel)
  {
    this.view = view;
    this.hexEditorModel = hexEditorModel;
  }

  @Override
  public void execute()
  {
     if((view.getFcFileChooser().showOpenDialog(view)) == JFileChooser.APPROVE_OPTION)
    {
      File f = view.getFcFileChooser().getSelectedFile();
      view.getLblFile().setText("File: " + f.getAbsolutePath());    
      
      try
      {
        hexEditorModel.setDataAsString(view.getTaEditor().getTaEditor().getText());
        hexEditorModel.writeFile(f);
      }
      catch(IOException | NumberFormatException ex)
      {
        JOptionPane.showConfirmDialog(view, ex.getMessage());
      }
    }
  }

  @Override
  public void undo()
  {
    view.getTaEditor().getTaEditor().append("Save AS Undo\n");
  }
  
  @Override
  public MainView getView()
  {
    return this.view;
  }
}
