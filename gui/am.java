package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class am implements ActionListener {
  private final o a;
  
  am(o paramo) {
    this.a = paramo;
  }
  
  public void actionPerformed(ActionEvent paramActionEvent) {
    o.p(this.a, paramActionEvent);
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\am.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */