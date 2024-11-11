package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class s extends WindowAdapter {
  private final o a;
  
  s(o paramo) {
    this.a = paramo;
  }
  
  public void windowClosing(WindowEvent paramWindowEvent) {
    o.a(this.a, paramWindowEvent);
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\s.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */