package util;

import gui.av;
import java.util.List;

class p extends av {
  private final List a;
  
  private final boolean b;
  
  p(List paramList, boolean paramBoolean) {
    this.a = paramList;
    this.b = paramBoolean;
  }
  
  public final void run() {
    bg.a(this.a, ai.g(), this.b);
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\p.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */