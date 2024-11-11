package gui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class bh extends AbstractAction {
  private final String a;
  
  private final o b;
  
  bh(o paramo, String paramString1, String paramString2) {
    super(paramString1);
    this.b = paramo;
    this.a = paramString2;
  }
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    o.a(this.b, false, this.a);
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\bh.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */