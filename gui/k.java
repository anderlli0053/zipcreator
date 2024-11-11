package gui;

import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.basic.BasicListUI;
import util.a;
import util.be;

public class k extends BasicListUI {
  private static int a = -1;
  
  protected final void updateLayoutState() {
    int i = this.rendererPane.getWidth();
    if (a != i)
      a = i; 
    if (a < 580)
      a = 580; 
    this.cellHeight = 18;
    this.cellWidth = a;
  }
  
  protected final int convertRowToY(int paramInt) {
    int i = be.d.getSize();
    return (paramInt < 0 || paramInt >= i) ? -1 : (this.cellHeight * paramInt);
  }
  
  protected final int convertYToRow(int paramInt) {
    int i = be.d.getSize();
    if (i <= 0)
      return -1; 
    if (this.cellHeight == 0)
      return 0; 
    int j = paramInt / this.cellHeight;
    return (j < 0 || j >= i) ? -1 : j;
  }
  
  protected final ListSelectionListener createListSelectionListener() {
    return new gui/m(this);
  }
  
  protected final MouseInputListener createMouseInputListener() {
    return new gui/ai(this);
  }
  
  static void c(k paramk) {
    paramk.maybeUpdateLayoutState();
  }
  
  static JList d(k paramk) {
    return paramk.list;
  }
  
  static JList k(k paramk) {
    return paramk.list;
  }
  
  static JList i(k paramk) {
    return paramk.list;
  }
  
  static int a(k paramk, int paramInt) {
    return paramk.getRowHeight(paramInt);
  }
  
  static JList j(k paramk) {
    return paramk.list;
  }
  
  static JList e(k paramk) {
    return paramk.list;
  }
  
  static JList b(k paramk) {
    return paramk.list;
  }
  
  static JList o(k paramk) {
    return paramk.list;
  }
  
  static JList m(k paramk) {
    return paramk.list;
  }
  
  static JList g(k paramk) {
    return paramk.list;
  }
  
  static JList a(k paramk) {
    return paramk.list;
  }
  
  static JList h(k paramk) {
    return paramk.list;
  }
  
  static JList f(k paramk) {
    return paramk.list;
  }
  
  static JList n(k paramk) {
    return paramk.list;
  }
  
  static JList l(k paramk) {
    return paramk.list;
  }
  
  public final class gui/ai extends BasicListUI.MouseInputHandler {
    private final k a;
    
    public gui/ai(k this$0) {
      super(this$0);
      this.a = this$0;
    }
    
    public final void mouseDragged(MouseEvent param1MouseEvent) {}
    
    public final void mousePressed(MouseEvent param1MouseEvent) {
      if (!k.b(this.a).isEnabled())
        return; 
      if (param1MouseEvent.isPopupTrigger())
        return; 
      if (SwingUtilities.isLeftMouseButton(param1MouseEvent)) {
        if (!k.o(this.a).hasFocus())
          k.m(this.a).requestFocus(); 
        int i = this.a.convertYToRow(param1MouseEvent.getY());
        if (i > -1) {
          boolean bool1;
          if (a.c) {
            bool1 = param1MouseEvent.isMetaDown();
          } else {
            bool1 = param1MouseEvent.isControlDown();
          } 
          boolean bool2 = param1MouseEvent.isShiftDown();
          boolean bool3 = k.g(this.a).isSelectedIndex(i);
          boolean bool4 = param1MouseEvent.isAltDown();
          int j = param1MouseEvent.getClickCount();
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
    
    public final void mouseReleased(MouseEvent param1MouseEvent) {}
  }
  
  public final class gui/m implements ListSelectionListener {
    private final k a;
    
    public gui/m(k this$0) {
      this.a = this$0;
    }
    
    public void valueChanged(ListSelectionEvent param1ListSelectionEvent) {
      int i = param1ListSelectionEvent.getFirstIndex();
      int j = param1ListSelectionEvent.getLastIndex();
      k.c(this.a);
      int m = this.a.convertRowToY(i);
      int n = this.a.convertRowToY(j);
      if (m == -1 || n == -1) {
        k.i(this.a).repaint(0, 0, k.d(this.a).getWidth(), k.k(this.a).getHeight());
      } else {
        n += k.a(this.a, j);
        k.e(this.a).repaint(0, m, k.j(this.a).getWidth(), n - m);
      } 
    }
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\k.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */