package gui;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class ap implements ListSelectionListener {
  private final o a;
  
  ap(o paramo) {
    this.a = paramo;
  }
  
  public final void valueChanged(ListSelectionEvent paramListSelectionEvent) {
    if (!paramListSelectionEvent.getValueIsAdjusting() && !o.b(this.a))
      this.a.p(); 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\ap.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */