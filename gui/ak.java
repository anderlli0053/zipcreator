package gui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class ak extends AbstractAction {
  private final o a;
  
  ak(o paramo, String paramString) {
    super(paramString);
    this.a = paramo;
  }
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    if (!be.i()) {
      be.g();
      be.a(false);
    } else {
      be.a(true);
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\ak.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */