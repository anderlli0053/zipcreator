package gui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class h extends AbstractAction {
  private final o a;
  
  h(o paramo, String paramString) {
    super(paramString);
    this.a = paramo;
  }
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    if (o.b(this.a))
      return; 
    int i = this.a.N.getModel().getSize();
    if (i > 0) {
      this.a.N.setSelectionInterval(0, 0);
      this.a.N.ensureIndexIsVisible(0);
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\h.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */