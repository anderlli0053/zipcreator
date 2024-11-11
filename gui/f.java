package gui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class f extends AbstractAction {
  private final o a;
  
  f(o paramo, String paramString) {
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
      i = j - 1;
      bool = true;
    } else {
      i = j - 1;
    } 
    if (bool && i >= 0) {
      int k = this.a.N.getAnchorSelectionIndex();
      if (k == -1)
        k = i; 
      this.a.N.addSelectionInterval(k, i);
      this.a.N.ensureIndexIsVisible(i);
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\f.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */