package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class al implements ActionListener {
  private final o a;
  
  al(o paramo) {
    this.a = paramo;
  }
  
  public void actionPerformed(ActionEvent paramActionEvent) {
    o.i(this.a, paramActionEvent);
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\al.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */