package gui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;

class aj extends AbstractAction {
  private final AbstractButton b;
  
  private final o a;
  
  aj(o paramo, String paramString, AbstractButton paramAbstractButton) {
    super(paramString);
    this.a = paramo;
    this.b = paramAbstractButton;
  }
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    this.b.doClick(128);
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\aj.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */