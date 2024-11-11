package gui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;

class ar extends AbstractAction {
  private final AbstractButton b;
  
  private final o a;
  
  ar(o paramo, String paramString, AbstractButton paramAbstractButton) {
    super(paramString);
    this.a = paramo;
    this.b = paramAbstractButton;
  }
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    if (o.a(this.a).isVisible())
      o.a(this.a).setVisible(false); 
    this.b.doClick(128);
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\ar.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */