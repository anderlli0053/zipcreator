package gui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import util.n;

class as extends AbstractAction {
  private final o a;
  
  as(o paramo, String paramString) {
    super(paramString);
    this.a = paramo;
  }
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    if (o.a(this.a).isVisible()) {
      o.a(this.a).setVisible(false);
    } else {
      n.f();
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\as.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */