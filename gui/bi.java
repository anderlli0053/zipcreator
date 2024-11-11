package gui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class bi implements PropertyChangeListener {
  private final ah a;
  
  bi(ah paramah) {
    this.a = paramah;
  }
  
  public final void propertyChange(PropertyChangeEvent paramPropertyChangeEvent) {
    if (paramPropertyChangeEvent.getPropertyName().equals("orientation"))
      this.a.c(); 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\bi.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */