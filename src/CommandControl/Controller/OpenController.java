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
public class OpenController implements CommandInterface
{
  private MainView view;
  private HexEditorModel hexEditorModel;
  
  public OpenController(MainView view, HexEditorModel hexEditorModel)
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
        hexEditorModel.readFile(f);
        String bufferString = hexEditorModel.getDataAsString();
        view.getTaEditor().getTaEditor().setText(bufferString);
      }
      catch(IOException ex)
      {
        JOptionPane.showConfirmDialog(view, ex.getMessage());
      } 
    }
  }
  
  @Override
  public void undo()
  {
    view.getTaEditor().getTaEditor().append("Open Undo\n");
  }
  
  @Override
  public MainView getView()
  {
    return this.view;
  }
}
