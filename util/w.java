package util;

import gui.av;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.RepaintManager;

class w extends av {
  public final void run() {
    if (f.c())
      RepaintManager.currentManager((Component)f.c).paintDirtyRegions(); 
    f.c.setIconImage(f.c() ? f.a : f.i);
    f.c.a(f.c());
    if (f.c()) {
      f.c.setCursor(Cursor.getPredefinedCursor(3));
    } else {
      f.c.setCursor(Cursor.getPredefinedCursor(0));
    } 
    ai.a(f.c());
    am.a(f.c());
    if (!f.c())
      RepaintManager.currentManager((Component)f.c).paintDirtyRegions(); 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\w.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */