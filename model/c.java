package model;

import gui.av;
import util.at;

class c extends av {
  private final int a;
  
  private final int d;
  
  private final int c;
  
  private final t b;
  
  c(t paramt, int paramInt1, int paramInt2, int paramInt3) {
    this.b = paramt;
    this.a = paramInt1;
    this.d = paramInt2;
    this.c = paramInt3;
  }
  
  public final void run() {
    t.l(this.b, this.b, this.a, this.d);
    if (this.c > -1)
      at.f.setLeadSelectionIndex(this.c); 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\model\c.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */