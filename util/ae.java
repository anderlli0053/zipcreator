package util;

import gui.av;

class ae extends av {
  private final Runnable a;
  
  private final Runnable b;
  
  ae(Runnable paramRunnable1, Runnable paramRunnable2) {
    this.a = paramRunnable1;
    this.b = paramRunnable2;
  }
  
  public final void run() {
    this.a.run();
    this.b.run();
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\ae.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */