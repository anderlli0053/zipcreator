package util;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class m extends WindowAdapter {
  public void windowClosing(WindowEvent paramWindowEvent) {
    aw.b().cancelSelection();
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\m.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */