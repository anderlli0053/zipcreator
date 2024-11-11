package util;

import gui.av;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;

public abstract class n {
  private static av m = null;
  
  private static av D = null;
  
  private static av e = null;
  
  private static av i = null;
  
  private static av j = null;
  
  private static av t = null;
  
  private static av c = null;
  
  private static av f = null;
  
  private static av y = null;
  
  private static av q = null;
  
  private static av p = null;
  
  private static av s = null;
  
  private static av g = null;
  
  private static av n = null;
  
  private static av u = null;
  
  private static av B = null;
  
  private static av C = null;
  
  private static av k = null;
  
  private static av d = null;
  
  private static av a = null;
  
  private static av v = null;
  
  private static File x = null;
  
  private static boolean z = false;
  
  private static File b = null;
  
  private static File o = null;
  
  private static File l = null;
  
  private static File[] E = null;
  
  private static boolean A = false;
  
  private static int w = 0;
  
  private static int h = 0;
  
  private static boolean r = false;
  
  public static final void p() {
    r = false;
  }
  
  public static final void f() {
    r = true;
  }
  
  public static final boolean r() {
    return r;
  }
  
  public static final av h() {
    if (m == null)
      m = new bc(); 
    return m;
  }
  
  public static final av a(File paramFile, boolean paramBoolean) {
    if (D == null)
      D = new ay(); 
    x = paramFile;
    z = paramBoolean;
    return D;
  }
  
  public static final av z() {
    if (e == null)
      e = new q(); 
    return e;
  }
  
  public static final av m() {
    if (i == null)
      i = new ap(); 
    return i;
  }
  
  public static final av c(File paramFile) {
    if (j == null)
      j = new an(); 
    b = paramFile;
    return j;
  }
  
  public static final av b(File paramFile) {
    if (t == null)
      t = new ak(); 
    o = paramFile;
    return t;
  }
  
  public static final av a(File paramFile) {
    if (c == null)
      c = new z(); 
    l = paramFile;
    return c;
  }
  
  public static final av a(File[] paramArrayOfFile) {
    if (f == null)
      f = new e(); 
    E = paramArrayOfFile;
    return f;
  }
  
  public static final av u() {
    if (y == null)
      y = new c(); 
    return y;
  }
  
  public static final av d() {
    if (q == null)
      q = new ag(); 
    return q;
  }
  
  public static final av n() {
    if (p == null)
      p = new ad(); 
    return p;
  }
  
  public static final av q() {
    if (s == null)
      s = new ao(); 
    return s;
  }
  
  public static final av a(boolean paramBoolean) {
    if (g == null)
      g = new av(); 
    A = paramBoolean;
    return g;
  }
  
  public static final av y() {
    if (n == null)
      n = new bi(); 
    return n;
  }
  
  public static final av b(int paramInt) {
    if (u == null)
      u = new bf(); 
    w = paramInt;
    return u;
  }
  
  public static final av a(int paramInt) {
    if (B == null)
      B = new ax(); 
    h = paramInt;
    return B;
  }
  
  public static final av v() {
    if (C == null)
      C = new bb(); 
    return C;
  }
  
  public static final av i() {
    if (k == null)
      k = new i(); 
    return k;
  }
  
  public static final av c() {
    if (d == null)
      d = new az(); 
    return d;
  }
  
  public static final av k() {
    if (a == null)
      a = new d(); 
    return a;
  }
  
  public static final av o() {
    if (v == null)
      v = new aj(); 
    return v;
  }
  
  public static final void c(Runnable paramRunnable) {
    Thread thread = new Thread(paramRunnable);
    thread.setPriority(3);
    thread.start();
  }
  
  public static final void a(Runnable paramRunnable) {
    if (j()) {
      paramRunnable.run();
    } else {
      SwingUtilities.invokeLater(paramRunnable);
    } 
  }
  
  public static final void b(Runnable paramRunnable) {
    if (j()) {
      paramRunnable.run();
    } else {
      try {
        SwingUtilities.invokeAndWait(paramRunnable);
      } catch (InterruptedException interruptedException) {
      
      } catch (InvocationTargetException invocationTargetException) {}
    } 
  }
  
  public static final boolean j() {
    return SwingUtilities.isEventDispatchThread();
  }
  
  public static final av a(Runnable paramRunnable1, Runnable paramRunnable2) {
    return new ae(paramRunnable1, paramRunnable2);
  }
  
  static File e() {
    return x;
  }
  
  static boolean s() {
    return z;
  }
  
  static File x() {
    return b;
  }
  
  static File g() {
    return o;
  }
  
  static File a() {
    return l;
  }
  
  static File[] w() {
    return E;
  }
  
  static boolean t() {
    return A;
  }
  
  static int b() {
    return w;
  }
  
  static int l() {
    return h;
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\n.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */