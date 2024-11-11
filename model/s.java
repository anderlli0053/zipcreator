package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import util.ar;

public abstract class s {
  public String h = null;
  
  public long a = -1L;
  
  private static final SimpleDateFormat d = new SimpleDateFormat("d'-'MMM'-'yy H':'mm");
  
  private String k = null;
  
  private String i = null;
  
  private String f = null;
  
  private String e = null;
  
  private String c = null;
  
  private double b = -1.0D;
  
  public final void b() {
    this.k = null;
  }
  
  public final void h() {
    this.i = null;
    this.f = null;
    this.e = null;
  }
  
  public final void f() {
    this.c = null;
  }
  
  public final String g() {
    if (this.k == null)
      if (this.a == -1L) {
        this.k = "";
      } else {
        Date date = new Date(this.a);
        this.k = d.format(date);
      }  
    return this.k;
  }
  
  public final String j() {
    if (this.i == null)
      if (this.h == null) {
        this.i = "";
      } else if (this instanceof e) {
        this.i = this.h.substring(this.h.lastIndexOf("/") + 1);
      } else {
        String str = this.h.substring(0, this.h.length() - 1);
        this.i = str.substring(str.lastIndexOf("/") + 1) + "/";
      }  
    return this.i;
  }
  
  public final String d() {
    if (this.f == null)
      if (this.h == null) {
        this.f = "";
      } else if (this instanceof e) {
        this.f = this.h.substring(0, this.h.lastIndexOf("/") + 1);
      } else {
        String str = this.h.substring(0, this.h.length() - 1);
        this.f = str.substring(0, str.lastIndexOf("/") + 1);
      }  
    return this.f;
  }
  
  public final String a() {
    if (this.e == null) {
      String str = j();
      if (str == null) {
        this.e = "";
      } else if (this instanceof e) {
        String str1 = ar.h(str);
        if (str1.length() > 0) {
          this.e = str1.toUpperCase() + " File";
        } else {
          this.e = "File";
        } 
      } else {
        this.e = "Directory";
      } 
    } 
    return this.e;
  }
  
  public final String i() {
    if (this.c == null)
      if (this instanceof e) {
        e e = (e)this;
        if (e.j instanceof k) {
          k k = (k)e.j;
          if (k.e) {
            long l = 1L + k.a / 1024L;
            if (k.a > 0L) {
              this.c = l + " KB (" + (e.g ? "Uncompressed" : "Not yet compressed") + ")";
            } else {
              this.c = "Size not specified";
            } 
          } else {
            long l = 1L + k.a / 1024L;
            if (e.g) {
              if (k.a > 0L) {
                this.c = l + " KB (Uncompressed)";
              } else {
                this.c = "Size not specified";
              } 
            } else {
              long l1 = 1L + k.c / 1024L;
              if (k.a > 0L && k.c > 0L) {
                double d = Math.ceil(k.c / k.a * 100.0D);
                this.c = l1 + " KB (" + (int)d + "% of " + l + " KB)";
              } else if (k.c > 0L) {
                this.c = l1 + " KB (Compressed)";
              } else {
                this.c = "Size not specified";
              } 
            } 
          } 
        } else {
          long l = e.j.a();
          if (l > -1L) {
            long l1 = 1L + l / 1024L;
            this.c = l1 + " KB (File size)";
          } else {
            this.c = "Size not specified";
          } 
        } 
      } else {
        this.c = "";
      }  
    return this.c;
  }
  
  public final double c() {
    if (this.b == -1.0D)
      if (this instanceof e) {
        e e = (e)this;
        if (e.j instanceof k) {
          k k = (k)e.j;
          if (k.e) {
            this.b = 100.0D;
          } else if (k.a > 0L && k.c > 0L) {
            long l1 = 1L + k.a / 1024L;
            long l2 = 1L + k.c / 1024L;
            double d = Math.ceil(k.c / k.a * 100.0D);
            this.b = d;
          } else {
            this.b = 100.0D;
          } 
        } else {
          this.b = 100.0D;
        } 
      } else {
        this.b = 100.0D;
      }  
    return this.b;
  }
  
  public abstract s e();
  
  public final String toString() {
    return this.h;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject instanceof s) {
      s s1 = (s)paramObject;
      return this.h.equals(s1.h);
    } 
    return false;
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\model\s.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */