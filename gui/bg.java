package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bg implements ActionListener {
  private final o a;
  
  bg(o paramo) {
    this.a = paramo;
  }
  
  public void actionPerformed(ActionEvent paramActionEvent) {
    o.m(this.a, paramActionEvent);
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\bg.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */