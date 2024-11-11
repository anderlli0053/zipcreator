package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class o implements ActionListener {
  public final void actionPerformed(ActionEvent paramActionEvent) {
    if (!aw.a().isShowing())
      return; 
    if (!paramActionEvent.getActionCommand().equals("ApproveSelection"))
      if (aw.b().isMultiSelectionEnabled()) {
        aw.b().setSelectedFiles(null);
      } else {
        aw.b().setSelectedFile(null);
      }  
    aw.a().hide();
    bg.e = aw.d().isSelected();
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\o.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */