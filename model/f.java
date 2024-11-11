package model;

import gui.av;

class f extends av {
  private final int[] b;
  
  private final int a;
  
  private final t c;
  
  f(t paramt, int[] paramArrayOfint, int paramInt) {
    this.c = paramt;
    this.b = paramArrayOfint;
    this.a = paramInt;
  }
  
  public final void run() {
    int i = this.b[0];
    int j = this.b[0];
    for (byte b = 1; b < this.a; b++) {
      if (this.b[b] - j != 1) {
        t.d(this.c, this.c, i, j);
        i = this.b[b];
      } 
      j = this.b[b];
    } 
    t.c(this.c, this.c, i, j);
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\model\f.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */