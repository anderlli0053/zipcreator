package gui;

import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicListUI;
import util.a;

public final class gui/ai extends BasicListUI.MouseInputHandler {
  private final k a;
  
  public gui/ai(k paramk) {
    super(paramk);
    this.a = paramk;
  }
  
  public final void mouseDragged(MouseEvent paramMouseEvent) {}
  
  public final void mousePressed(MouseEvent paramMouseEvent) {
    if (!k.b(this.a).isEnabled())
      return; 
    if (paramMouseEvent.isPopupTrigger())
      return; 
    if (SwingUtilities.isLeftMouseButton(paramMouseEvent)) {
      if (!k.o(this.a).hasFocus())
        k.m(this.a).requestFocus(); 
      int i = this.a.convertYToRow(paramMouseEvent.getY());
      if (i > -1) {
        boolean bool1;
        if (a.c) {
          bool1 = paramMouseEvent.isMetaDown();
        } else {
          bool1 = paramMouseEvent.isControlDown();
        } 
        boolean bool2 = paramMouseEvent.isShiftDown();
        boolean bool3 = k.g(this.a).isSelectedIndex(i);
        boolean bool4 = paramMouseEvent.isAltDown();
        int j = paramMouseEvent.getClickCount();
        int m = k.a(this.a).getAnchorSelectionIndex();
        boolean bool = (m > -1) ? true : false;
        if (bool1 && bool3) {
          k.h(this.a).removeSelectionInterval(i, i);
        } else if (bool1) {
          k.f(this.a).addSelectionInterval(i, i);
        } else if (bool2 && bool) {
          k.n(this.a).addSelectionInterval(m, i);
        } else if (!bool3 || bool4 || j > 1) {
          k.l(this.a).setSelectionInterval(i, i);
        } 
      } 
    } 
  }
  
  public final void mouseReleased(MouseEvent paramMouseEvent) {}
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\ai.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */