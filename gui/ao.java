package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ToolTipManager;

class ao extends MouseAdapter {
  private final ToolTipManager a;
  
  private final o b;
  
  ao(o paramo, ToolTipManager paramToolTipManager) {
    this.b = paramo;
    this.a = paramToolTipManager;
  }
  
  public final void mouseEntered(MouseEvent paramMouseEvent) {
    a();
  }
  
  public final void mouseExited(MouseEvent paramMouseEvent) {
    a();
  }
  
  private final void a() {
    try {
      this.a.mousePressed(null);
    } catch (Exception exception) {}
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\ao.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */