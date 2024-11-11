package gui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class b extends AbstractAction {
  private final o a;
  
  b(o paramo, String paramString) {
    super(paramString);
    this.a = paramo;
  }
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    if (o.b(this.a))
      return; 
    int i = this.a.N.getModel().getSize();
    if (i > 0) {
      this.a.N.setSelectionInterval(i - 1, i - 1);
      this.a.N.ensureIndexIsVisible(i - 1);
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\b.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */