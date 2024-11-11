package gui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class i extends AbstractAction {
  private final o a;
  
  i(o paramo, String paramString) {
    super(paramString);
    this.a = paramo;
  }
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    if (o.b(this.a))
      return; 
    int j = this.a.N.getLeadSelectionIndex();
    int k = this.a.N.getModel().getSize();
    if (j == -1 && k > 0) {
      j = 0;
    } else {
      j--;
    } 
    if (j >= 0 && j < k) {
      this.a.N.setSelectionInterval(j, j);
      this.a.N.ensureIndexIsVisible(j);
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\i.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */