package gui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class c extends AbstractAction {
  private final o a;
  
  c(o paramo, String paramString) {
    super(paramString);
    this.a = paramo;
  }
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    if (o.b(this.a))
      return; 
    int i = this.a.N.getLeadSelectionIndex();
    boolean bool = (i >= 0 && this.a.N.isSelectedIndex(i)) ? true : false;
    int j = this.a.N.getModel().getSize();
    if (i == -1 && j > 0) {
      i = 0;
      bool = true;
    } else {
      i = 0;
    } 
    if (bool && i < j) {
      int k = this.a.N.getAnchorSelectionIndex();
      if (k == -1)
        k = i; 
      this.a.N.addSelectionInterval(k, i);
      this.a.N.ensureIndexIsVisible(i);
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\c.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */