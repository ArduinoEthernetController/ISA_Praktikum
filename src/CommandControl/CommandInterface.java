/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandControl;

import View.MainView;

/**
 *
 * @author Christoph
 */
public interface CommandInterface
{
  public void execute();
  public MainView getView();
  public void undo();
}
