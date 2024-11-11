package gui;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;

class aa extends AbstractAction {
  private final o a;
  
  aa(o paramo, String paramString) {
    super(paramString);
    this.a = paramo;
  }
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    if (o.a(this.a).isVisible()) {
      o.a(this.a).setVisible(false);
    } else {
      int i = this.a.getWidth() / 2;
      int j = this.a.getHeight() / 2;
      MouseEvent mouseEvent = new MouseEvent(this.a, paramActionEvent.getID(), System.currentTimeMillis(), paramActionEvent.getModifiers(), i, j, 1, true);
      o.b(this.a, mouseEvent);
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\aa.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */