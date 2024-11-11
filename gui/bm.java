package gui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;

class bm extends AbstractAction {
  private final JComponent c;
  
  private final Action a;
  
  private final o b;
  
  bm(o paramo, String paramString, JComponent paramJComponent, Action paramAction) {
    super(paramString);
    this.b = paramo;
    this.c = paramJComponent;
    this.a = paramAction;
  }
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    if (this.c.isEnabled()) {
      ActionEvent actionEvent = new ActionEvent(this.c, paramActionEvent.getID(), paramActionEvent.getActionCommand(), paramActionEvent.getModifiers());
      this.a.actionPerformed(actionEvent);
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\bm.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */