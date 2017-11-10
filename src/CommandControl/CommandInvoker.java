/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CommandControl;

import java.awt.Component;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author Christoph
 */
public class CommandInvoker
{
  private HashMap<Component, CommandInterface> commands;
  public Stack<CommandInterface> undoStack;
  
  public CommandInvoker()
  {
    commands = new HashMap<>();
    undoStack = new Stack<>();
  }
  
  public void addCommand(Component key, CommandInterface value)
  {
    commands.put(key, value);
  }
  
  public void executeCommand(Component key)
  {
    commands.get(key).execute();
    
    // Command nur auf den Stack legen, wenn das Command auch ein Undo machen soll 
    if(key.equals(commands.get(key).getView().getBtnDeleteLine()) || key.equals(commands.get(key).getView().getMniDeleteLine()) || key.equals(commands.get(key).getView().getPumDeleteLine()))
    {  
      undoStack.push(commands.get(key));
    }
  }
  
  public void undoCommand()
  {
    if(!undoStack.isEmpty())
    {
       undoStack.pop().undo();
    }
  }
}
