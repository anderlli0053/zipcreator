package model;

import java.text.Collator;
import java.util.Comparator;

public class a implements Comparator, u {
  public static final a d = new a();
  
  public int b = 1;
  
  private static final Collator a = Collator.getInstance();
  
  public int compare(Object paramObject1, Object paramObject2) {
    boolean bool1;
    boolean bool2;
    if (!(paramObject1 instanceof s) || !(paramObject2 instanceof s))
      throw new ClassCastException("Incompatible types passed for comparison."); 
    s s1 = (s)paramObject1;
    s s2 = (s)paramObject2;
    switch (this.b) {
      case 1:
        return a(s1, s2);
      case 0:
        null = a(s1.j(), s2.j());
        if (null == 0)
          null = a(s1, s2); 
        return null;
      case 3:
        bool1 = s1 instanceof l;
        bool2 = s2 instanceof l;
        if (bool1 && bool2) {
          null = a(s1.h, s2.h);
        } else {
          if (bool1)
            return -1; 
          if (bool2)
            return 1; 
          null = a(s1.a(), s2.a());
          if (null == 0)
            null = a(s1, s2); 
        } 
        return null;
      case 2:
        return d(s1, s2);
      case 4:
        return c(s1, s2);
      case 5:
        return b(s1, s2);
    } 
    throw new ClassCastException("Invalid sort option");
  }
  
  public static final int a(String paramString1, String paramString2) {
    return a.compare(paramString1, paramString2);
  }
  
  private static final int a(s params1, s params2) {
    int i;
    String str1 = params1.h;
    String str2 = params2.h;
    String str3 = params1.j();
    String str4 = params2.j();
    String str5 = params1.d();
    String str6 = params2.d();
    boolean bool1 = params1 instanceof e;
    boolean bool2 = params2 instanceof e;
    boolean bool3 = !bool1 ? true : false;
    boolean bool4 = !bool2 ? true : false;
    if (bool3 && bool4) {
      i = a(str1, str2);
    } else if (str5.equals(str6)) {
      if (bool1 && bool2) {
        i = a(str3, str4);
      } else if (bool1) {
        i = -1;
      } else {
        i = 1;
      } 
    } else if (bool1 && bool2 && str6.startsWith(str5)) {
      i = -1;
    } else if (bool1 && bool2 && str5.startsWith(str6)) {
      i = 1;
    } else if (bool3 && bool2 && str1.equals(str6)) {
      i = -1;
    } else if (bool1 && bool4 && str2.equals(str5)) {
      i = 1;
    } else if (bool3 && bool2 && str6.startsWith(str1)) {
      i = -1;
    } else if (bool1 && bool4 && str5.startsWith(str2)) {
      i = 1;
    } else if (bool1 && bool4) {
      i = a(str5, str2);
    } else if (bool3 && bool2) {
      i = a(str1, str6);
    } else {
      i = a(str1, str2);
    } 
    return i;
  }
  
  private static final int d(s params1, s params2) {
    int i;
    long l1 = (params1.a == -1L) ? -1L : (params1.a / 60000L);
    long l2 = (params2.a == -1L) ? -1L : (params2.a / 60000L);
    if (l1 < l2) {
      i = 1;
    } else if (l1 > l2) {
      i = -1;
    } else {
      i = a(params1, params2);
    } 
    return i;
  }
  
  private static final int c(s params1, s params2) {
    int i;
    long l1 = (params1 instanceof e) ? a(((e)params1).j.a()) : -1L;
    long l2 = (params2 instanceof e) ? a(((e)params2).j.a()) : -1L;
    if (l1 < l2) {
      i = 1;
    } else if (l1 > l2) {
      i = -1;
    } else {
      i = a(params1, params2);
    } 
    return i;
  }
  
  private static final long a(long paramLong) {
    return 1L + paramLong / 1024L;
  }
  
  private static final int b(s params1, s params2) {
    int i = 0;
    boolean bool1 = params1 instanceof l;
    boolean bool2 = params2 instanceof l;
    boolean bool = false;
    if (bool1 && bool2) {
      bool = true;
    } else {
      if (bool1)
        return 1; 
      if (bool2)
        return -1; 
    } 
    if (!bool) {
      double d1 = params1.c();
      double d2 = params2.c();
      if (d1 < d2)
        return 1; 
      if (d1 > d2)
        return -1; 
      bool = true;
    } 
    if (bool)
      if (bool1 && bool2) {
        i = a(params1.h, params2.h);
      } else {
        if (bool1)
          return 1; 
        if (bool2)
          return -1; 
        i = a(params1.a(), params2.a());
        if (i == 0)
          i = a(params1, params2); 
      }  
    return i;
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\model\a.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */