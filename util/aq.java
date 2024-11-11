package util;

import java.util.List;
import model.e;
import model.s;

public abstract class aq {
  public static long a = 0L;
  
  public static long e = 0L;
  
  private static int c = 0;
  
  private static int b = 0;
  
  private static String d = "Progress";
  
  public static final void a(String paramString) {
    d = paramString;
    a = 0L;
    e = 0L;
    c = 0;
    b = 0;
  }
  
  public static final void a(List paramList) {
    if (paramList == null || paramList.isEmpty())
      return; 
    for (e e : paramList) {
      if (e instanceof e) {
        e e1 = e;
        if (e1.j != null) {
          long l = e1.j.a();
          if (l > 0L)
            a += l; 
        } 
      } 
    } 
  }
  
  public static final void a() {
    if (e > a || a < 1L) {
      c = 100;
    } else {
      c = (int)(100.0D * e / a);
    } 
    if (c != b) {
      f.a(d + " " + c + "%");
      b = c;
    } 
  }
  
  public static final void a(s params) {
    if (params != null && params instanceof e) {
      e e = (e)params;
      if (e.j != null)
        a -= e.j.a(); 
      if (a < 0L)
        a = 0L; 
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\aq.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */