package util;

import gui.av;
import java.util.List;
import javax.swing.UIManager;

class al extends av {
  public final void run() {
    f.a(true);
    List list = at.a();
    try {
      UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    } catch (Exception exception) {}
    aw.c();
    f.c.d();
    at.a(list);
    f.a(false);
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\al.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */