package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractListModel;
import util.at;

public class t extends AbstractListModel {
  public m a;
  
  public String b;
  
  private List c = new ArrayList();
  
  private a d;
  
  public t() {
    this.c = Collections.synchronizedList(this.c);
    this.d = new a();
    this.a = new m();
    this.b = "";
  }
  
  public final void a(int paramInt) {
    synchronized (this.c) {
      this.d.b = paramInt;
      Collections.sort(this.c, this.d);
    } 
    d();
    g();
  }
  
  public final int e() {
    return this.d.b;
  }
  
  public final Comparator b() {
    return this.d;
  }
  
  public final int getSize() {
    return this.c.size();
  }
  
  public final Object getElementAt(int paramInt) {
    return (paramInt < 0 || paramInt >= this.c.size()) ? null : this.c.get(paramInt);
  }
  
  public final void f() {
    int i;
    synchronized (this.c) {
      i = this.c.size() - 1;
      this.c.clear();
      this.a.a();
    } 
    this.b = "";
    j j = new j(this, i);
    j.b();
  }
  
  public final void a(Collection paramCollection) {
    int i;
    synchronized (this.c) {
      i = this.c.size() - 1;
      this.c.clear();
      this.c.addAll(paramCollection);
      Collections.sort(this.c, this.d);
    } 
    d();
    o o = new o(this, i);
    o.a();
  }
  
  public final void g() {
    int i = this.c.size() - 1;
    p p = new p(this, i);
    p.a();
  }
  
  public final void c(int paramInt) {
    if (paramInt == -1)
      return; 
    q q = new q(this, paramInt);
    q.a();
  }
  
  public final void c(Collection paramCollection) {
    int[] arrayOfInt = new int[paramCollection.size()];
    Iterator iterator = paramCollection.iterator();
    byte b1;
    for (b1 = 0; iterator.hasNext(); b1++) {
      int i = a(iterator.next());
      if (i == -1)
        continue; 
      arrayOfInt[b1] = i;
    } 
    byte b2 = b1;
    a(arrayOfInt, b2);
  }
  
  public final void a(int[] paramArrayOfint, int paramInt) {
    if (paramArrayOfint == null || paramArrayOfint.length == 0 || paramInt > paramArrayOfint.length)
      return; 
    f f = new f(this, paramArrayOfint, paramInt);
    f.a();
  }
  
  public final void b(s params) {
    int i;
    byte b;
    if (params == null)
      return; 
    synchronized (this.c) {
      i = c(params);
      if (i == -1)
        return; 
      this.c.add(i, params);
      this.a.b(params);
    } 
    char c = Character.toUpperCase(params.j().charAt(0));
    this.b = this.b.substring(0, i) + c + this.b.substring(i);
    int j = at.f.getLeadSelectionIndex();
    if (j >= i) {
      b = j + 1;
    } else {
      b = -1;
    } 
    i i1 = new i(this, i, b);
    i1.a();
  }
  
  public final void d(s params) {
    int i;
    if (params == null)
      return; 
    synchronized (this.c) {
      i = a(params);
      if (i == -1)
        return; 
      this.c.remove(i);
      this.a.c(params);
    } 
    this.b = this.b.substring(0, i) + this.b.substring(i + 1);
    d d = new d(this, i);
    d.a();
  }
  
  public final void b(Collection paramCollection) {
    int[] arrayOfInt1 = new int[paramCollection.size()];
    Iterator iterator = paramCollection.iterator();
    byte b1;
    for (b1 = 0; iterator.hasNext(); b1++) {
      s s = iterator.next();
      int i = a(s);
      if (i == -1)
        continue; 
      arrayOfInt1[b1] = i;
    } 
    byte b2 = b1;
    int[] arrayOfInt2 = new int[b2];
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, b2);
    a(arrayOfInt1);
  }
  
  public final void a(int[] paramArrayOfint) {
    Arrays.sort(paramArrayOfint);
    int i = paramArrayOfint[0];
    int j = paramArrayOfint[0];
    int k = at.f.getLeadSelectionIndex();
    int n = 0;
    for (byte b = 1; b < paramArrayOfint.length; b++) {
      if (paramArrayOfint[b] - n - j != 1) {
        a(i, j, k, n);
        n += j - i + 1;
        i = paramArrayOfint[b] - n;
      } 
      j = paramArrayOfint[b] - n;
    } 
    a(i, j, k, n);
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    synchronized (this.c) {
      for (int k = paramInt2; k >= paramInt1; k--) {
        s s = this.c.get(k);
        this.c.remove(k);
        this.a.c(s);
      } 
    } 
    this.b = this.b.substring(0, paramInt1) + this.b.substring(paramInt2 + 1);
    int i = paramInt3 - paramInt4;
    if (i >= paramInt1 && i <= paramInt2) {
      int k = this.c.size();
      i = (paramInt1 < k) ? paramInt1 : (k - 1);
    } else {
      i = -1;
    } 
    int j = i;
    c c = new c(this, paramInt1, paramInt2, j);
    c.a();
  }
  
  private final int c(s params) {
    if (params == null)
      return -1; 
    int i = this.c.size();
    if (i == 0)
      return 0; 
    int j = 0;
    int k = 0;
    int n = i - 1;
    int i1 = k;
    int i2 = n;
    int i3 = -1;
    boolean bool = false;
    while (n > k) {
      j = a(k, n);
      int i5 = this.d.compare(params, this.c.get(j));
      i3 = j;
      if (i5 < 0) {
        n = Math.max(j - 1, i1);
        bool = true;
        continue;
      } 
      if (i5 > 0) {
        k = Math.min(j + 1, i2);
        bool = false;
        continue;
      } 
      return -1;
    } 
    if (k == i3)
      return bool ? i3 : (i3 + 1); 
    j = k;
    int i4 = this.d.compare(params, this.c.get(j));
    return (i4 < 0) ? j : ((i4 > 0) ? (j + 1) : -1);
  }
  
  private final int a(int paramInt1, int paramInt2) {
    if (paramInt1 > paramInt2)
      return paramInt1; 
    int i = 1 + paramInt2 - paramInt1;
    return paramInt1 + (int)Math.floor(0.5D * i);
  }
  
  public final int a(s params) {
    return (params == null) ? -1 : this.c.indexOf(params);
  }
  
  public final List a() {
    return new ArrayList(this.c);
  }
  
  private final void d() {
    StringBuffer stringBuffer = new StringBuffer();
    for (s s : this.c) {
      char c = Character.toUpperCase(s.j().charAt(0));
      stringBuffer.append(c);
    } 
    this.b = stringBuffer.toString();
  }
  
  public final Iterator c() {
    Iterator iterator = this.c.iterator();
    return new b(this, iterator);
  }
  
  public final int b(int paramInt) {
    int i;
    s s = this.c.get(paramInt);
    synchronized (this.c) {
      this.c.remove(paramInt);
      i = c(s);
      this.c.add(i, s);
    } 
    this.b = this.b.substring(0, paramInt) + this.b.substring(paramInt + 1);
    char c = Character.toUpperCase(s.j().charAt(0));
    this.b = this.b.substring(0, i) + c + this.b.substring(i);
    if (paramInt == i) {
      c(paramInt);
      return paramInt;
    } 
    n n = new n(this, paramInt, i);
    n.a();
    return i;
  }
  
  static void g(t paramt, Object paramObject, int paramInt1, int paramInt2) {
    paramt.fireIntervalRemoved(paramObject, paramInt1, paramInt2);
  }
  
  static void j(t paramt, Object paramObject, int paramInt1, int paramInt2) {
    paramt.fireContentsChanged(paramObject, paramInt1, paramInt2);
  }
  
  static void e(t paramt, Object paramObject, int paramInt1, int paramInt2) {
    paramt.fireContentsChanged(paramObject, paramInt1, paramInt2);
  }
  
  static void a(t paramt, Object paramObject, int paramInt1, int paramInt2) {
    paramt.fireContentsChanged(paramObject, paramInt1, paramInt2);
  }
  
  static void d(t paramt, Object paramObject, int paramInt1, int paramInt2) {
    paramt.fireContentsChanged(paramObject, paramInt1, paramInt2);
  }
  
  static void c(t paramt, Object paramObject, int paramInt1, int paramInt2) {
    paramt.fireContentsChanged(paramObject, paramInt1, paramInt2);
  }
  
  static void i(t paramt, Object paramObject, int paramInt1, int paramInt2) {
    paramt.fireIntervalAdded(paramObject, paramInt1, paramInt2);
  }
  
  static void f(t paramt, Object paramObject, int paramInt1, int paramInt2) {
    paramt.fireIntervalRemoved(paramObject, paramInt1, paramInt2);
  }
  
  static void l(t paramt, Object paramObject, int paramInt1, int paramInt2) {
    paramt.fireIntervalRemoved(paramObject, paramInt1, paramInt2);
  }
  
  static List a(t paramt) {
    return paramt.c;
  }
  
  static void b(t paramt, Object paramObject, int paramInt1, int paramInt2) {
    paramt.fireIntervalRemoved(paramObject, paramInt1, paramInt2);
  }
  
  static void k(t paramt, Object paramObject, int paramInt1, int paramInt2) {
    paramt.fireIntervalRemoved(paramObject, paramInt1, paramInt2);
  }
  
  static void h(t paramt, Object paramObject, int paramInt1, int paramInt2) {
    paramt.fireIntervalAdded(paramObject, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\model\t.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */