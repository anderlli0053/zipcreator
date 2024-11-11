package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class bd extends MouseAdapter {
  private final o a;
  
  bd(o paramo) {
    this.a = paramo;
  }
  
  public void mousePressed(MouseEvent paramMouseEvent) {
    o.c(this.a, paramMouseEvent);
  }
  
  public void mouseReleased(MouseEvent paramMouseEvent) {
    o.a(this.a, paramMouseEvent);
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\bd.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */