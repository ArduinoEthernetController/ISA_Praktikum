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
 * Class CommnandInvoker stores a HashMap(Component, CommandInterface) and a Stack(CommandInterface)
 * @author Christoph
 */
public class CommandInvoker
{
  private HashMap<Component, CommandInterface> commands;
  public Stack<CommandInterface> undoStack;

/**
 * Constructor
 */  
  public CommandInvoker()
  {
    commands = new HashMap<>();
    undoStack = new Stack<>();
  }
  /**
   * method adds the given Component and CommandInterface
   * @param key - current Component 
   * @param value - current CommandInterface
   */
  public void addCommand(Component key, CommandInterface value)
  {
    commands.put(key, value);
  }
  /**
   * mehthod pushes the relevant executed methods on the stack
   * @param key - current Component
   */
  public void executeCommand(Component key)
  {
    commands.get(key).execute();
    
    // Command nur auf den Stack legen, wenn das Command auch ein Undo machen soll 
    if(key.equals(commands.get(key).getView().getBtnDeleteLine()) || key.equals(commands.get(key).getView().getMniDeleteLine()) || key.equals(commands.get(key).getView().getPumDeleteLine()))
    {  
      undoStack.push(commands.get(key));
    }
  }
  /**
   * Method takes the last object (if available) of the undoStack and calls the undo method 
   */
  public void undoCommand()
  {
    if(!undoStack.isEmpty())
    {
       undoStack.pop().undo();
    }
  }
}
