package model;

import java.util.Iterator;

class b implements Iterator {
  private s a;
  
  private final Iterator c;
  
  private final t b;
  
  b(t paramt, Iterator paramIterator) {
    this.b = paramt;
    this.c = paramIterator;
    this.a = null;
  }
  
  public boolean hasNext() {
    return this.c.hasNext();
  }
  
  public Object next() {
    s s1 = (s)this.c.next();
    if (s1 != null && s1 instanceof s) {
      this.a = s1;
    } else {
      this.a = null;
    } 
    return this.a;
  }
  
  public void remove() {
    int i;
    if (this.a != null) {
      i = t.a(this.b).indexOf(this.a);
    } else {
      throw new IllegalStateException();
    } 
    synchronized (t.a(this.b)) {
      this.c.remove();
      this.b.a.c(this.a);
    } 
    this.b.b = this.b.b.substring(0, i) + this.b.b.substring(i + 1);
    this.a = null;
    g g = new g(this, i);
    g.a();
  }
  
  static t a(b paramb) {
    return paramb.b;
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\model\b.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */