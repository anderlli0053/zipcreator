package util;

import gui.av;
import gui.bj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import model.s;

public abstract class at {
  public static final bj f = new bj();
  
  private static av b = null;
  
  private static av h = null;
  
  private static av l = null;
  
  private static av c = null;
  
  private static av k = null;
  
  private static av e = null;
  
  private static av a = null;
  
  private static av d = null;
  
  private static int i = -1;
  
  private static List g = new ArrayList();
  
  private static int j = -1;
  
  public static final int m() {
    return f.h();
  }
  
  public static final boolean c() {
    return f.g();
  }
  
  public static final s h() {
    return f.i();
  }
  
  public static final List a() {
    return f.f();
  }
  
  public static final void e() {
    if (b == null)
      b = new af(); 
    b.a();
  }
  
  public static final void b() {
    if (h == null)
      h = new as(); 
    h.a();
  }
  
  public static final void l() {
    if (l == null)
      l = new u(); 
    l.a();
  }
  
  public static final void d() {
    if (c == null)
      c = new j(); 
    c.a();
  }
  
  public static final void j() {
    if (k == null)
      k = new t(); 
    k.a();
  }
  
  public static final void b(int paramInt) {
    if (e == null)
      e = new s(); 
    i = paramInt;
    e.a();
  }
  
  public static final void a(s params) {
    b(be.d.a(params));
  }
  
  public static final void a(Collection paramCollection) {
    if (a == null)
      a = new v(); 
    g.clear();
    g.addAll(paramCollection);
    a.a();
  }
  
  public static final void k() {
    if (!f.isSelectionEmpty())
      a(f.getMinSelectionIndex()); 
  }
  
  public static final void a(int paramInt) {
    if (d == null)
      d = new ac(); 
    j = paramInt;
    d.a();
  }
  
  static int f() {
    return i;
  }
  
  static List g() {
    return g;
  }
  
  static int i() {
    return j;
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\at.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */