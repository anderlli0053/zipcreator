package gui;

import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

class bl implements PopupMenuListener {
  private final o a;
  
  bl(o paramo) {
    this.a = paramo;
  }
  
  public void popupMenuWillBecomeVisible(PopupMenuEvent paramPopupMenuEvent) {
    o.a(this.a, false);
  }
  
  public void popupMenuWillBecomeInvisible(PopupMenuEvent paramPopupMenuEvent) {
    o.a(this.a, true);
  }
  
  public void popupMenuCanceled(PopupMenuEvent paramPopupMenuEvent) {}
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\bl.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */