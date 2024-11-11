package gui;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public final class gui/m implements ListSelectionListener {
  private final k a;
  
  public gui/m(k paramk) {
    this.a = paramk;
  }
  
  public void valueChanged(ListSelectionEvent paramListSelectionEvent) {
    int i = paramListSelectionEvent.getFirstIndex();
    int j = paramListSelectionEvent.getLastIndex();
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


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\m.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */