package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ag implements ActionListener {
  private final o a;
  
  ag(o paramo) {
    this.a = paramo;
  }
  
  public void actionPerformed(ActionEvent paramActionEvent) {
    o.b(this.a, paramActionEvent);
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\ag.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */