package gui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class y extends AbstractAction {
  private final o a;
  
  y(o paramo, String paramString) {
    super(paramString);
    this.a = paramo;
  }
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    if (o.b(this.a))
      return; 
    int i = this.a.N.getLeadSelectionIndex();
    int j = this.a.N.getModel().getSize();
    if (i == -1 && j > 0) {
      i = 0;
    } else {
      i--;
    } 
    if (i >= 0 && i < j) {
      this.a.N.removeSelectionInterval(i, i);
      this.a.N.ensureIndexIsVisible(i);
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\y.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */