/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Christoph
 */
public class Edit extends javax.swing.JPanel
{

  /**
   * Creates new form Edit
   */
  public Edit()
  {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    jScrollPane1 = new javax.swing.JScrollPane();
    taEditor = new javax.swing.JTextArea();

    setLayout(new java.awt.BorderLayout());

    taEditor.setColumns(20);
    taEditor.setRows(5);
    jScrollPane1.setViewportView(taEditor);

    add(jScrollPane1, java.awt.BorderLayout.CENTER);
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JScrollPane jScrollPane1;
  public javax.swing.JTextArea taEditor;
  // End of variables declaration//GEN-END:variables

  /**
   * @return the taEditor
   */
  public javax.swing.JTextArea getTaEditor()
  {
    return taEditor;
  }
}