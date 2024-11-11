package util;

import gui.av;
import java.io.File;

class q extends av {
  public final void run() {
    File file = aw.b("Open zip file", "Open", 0, 0);
    if (file == null)
      return; 
    n.a(file, false).run();
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\q.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */