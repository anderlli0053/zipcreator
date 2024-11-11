package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import util.ar;

public class m {
  private TreeMap a = new TreeMap();
  
  public m() {
    this(null);
  }
  
  public m(Collection paramCollection) {
    if (paramCollection != null)
      a(paramCollection); 
  }
  
  public final void a() {
    this.a.clear();
  }
  
  public final void a(Collection paramCollection) {
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext())
      b(iterator.next()); 
  }
  
  public final m b() {
    m m1 = new m();
    for (String str : this.a.keySet()) {
      SortedSet sortedSet = b(str);
      m1.a.put(str, a(sortedSet));
    } 
    return m1;
  }
  
  private final SortedSet a(SortedSet paramSortedSet) {
    TreeSet treeSet = new TreeSet(a.d);
    for (s s : paramSortedSet)
      treeSet.add(s.e()); 
    return treeSet;
  }
  
  public final void b(s params) {
    String str = a(params);
    SortedSet sortedSet = b(str);
    if (sortedSet == null) {
      sortedSet = new TreeSet(a.d);
      sortedSet.add(params);
      this.a.put(str, sortedSet);
    } 
    sortedSet.add(params);
  }
  
  public final void a(m paramm) {
    for (String str : paramm.a.keySet()) {
      SortedSet sortedSet = paramm.b(str);
      Iterator iterator = sortedSet.iterator();
      while (iterator.hasNext())
        b(iterator.next()); 
    } 
  }
  
  public final void c(s params) {
    String str = a(params);
    SortedSet sortedSet = b(str);
    if (sortedSet == null) {
      this.a.remove(str);
      return;
    } 
    sortedSet.remove(params);
    if (sortedSet.size() == 0)
      this.a.remove(str); 
  }
  
  public final void g(String paramString) {
    String str = paramString;
    if (!paramString.endsWith("/"))
      str = str + "/"; 
    Iterator iterator = this.a.keySet().iterator();
    while (iterator.hasNext()) {
      String str1 = iterator.next();
      if (str1.equals("/"))
        continue; 
      String str2 = str1 + "/";
      if (str2.startsWith(str))
        iterator.remove(); 
    } 
  }
  
  private final SortedSet b(String paramString) {
    Object object = this.a.get(paramString);
    return (object == null) ? null : (SortedSet)object;
  }
  
  public final List h(String paramString) {
    boolean bool = paramString.equals("");
    ArrayList arrayList = new ArrayList();
    String str = paramString;
    if (!paramString.endsWith("/"))
      str = str + "/"; 
    for (String str1 : this.a.keySet()) {
      if (bool) {
        arrayList.addAll(b(str1));
        continue;
      } 
      if (str1.equals("/"))
        continue; 
      String str2 = str1 + "/";
      if (str2.startsWith(str))
        arrayList.addAll(b(str1)); 
    } 
    return arrayList;
  }
  
  public final s a(int paramInt, String paramString) {
    e e;
    l l;
    switch (paramInt) {
      case 1:
        return c(paramString);
      case 3:
        return e(paramString);
      case 2:
        e = c(paramString);
        if (e == null)
          l = e(paramString); 
        return l;
      case 4:
        return d(paramString);
      case 5:
        return f(paramString);
    } 
    return null;
  }
  
  private final e c(String paramString) {
    String str1 = paramString;
    if (paramString.endsWith("/"))
      str1 = paramString.substring(0, paramString.length() - 1); 
    String str2 = a(ar.c(str1));
    SortedSet sortedSet = b(str2);
    if (sortedSet == null)
      return null; 
    for (s s : sortedSet) {
      if (s instanceof e && s.h.equals(str1))
        return (e)s; 
    } 
    return null;
  }
  
  private final l e(String paramString) {
    String str1 = paramString;
    if (paramString.endsWith("/"))
      str1 = paramString.substring(0, paramString.length() - 1); 
    String str2 = a(str1);
    SortedSet sortedSet = b(str2);
    if (sortedSet == null)
      return null; 
    String str3 = str1 + "/";
    for (s s : sortedSet) {
      if (s instanceof l && s.h.equals(str3))
        return (l)s; 
    } 
    return null;
  }
  
  private final s d(String paramString) {
    String str = paramString;
    if (!paramString.endsWith("/"))
      str = str + "/"; 
    for (String str1 : this.a.keySet()) {
      if (str1.equals("/"))
        continue; 
      String str2 = str1 + "/";
      if (str2.startsWith(str))
        return b(str1).first(); 
    } 
    return null;
  }
  
  private final s f(String paramString) {
    String str1 = paramString;
    if (paramString.endsWith("/"))
      str1 = paramString.substring(0, paramString.length() - 1); 
    String str2 = ar.c(paramString);
    if (str2.length() == 0)
      return null; 
    str2 = ar.c(str2);
    for (String str3 = a(str2);; str3 = a(str2)) {
      SortedSet sortedSet = b(str3);
      if (sortedSet != null)
        for (s s : sortedSet) {
          if (s instanceof e) {
            String str = s.h + "/";
            if (str1.startsWith(str))
              return s; 
          } 
        }  
      if (str3.equals("/"))
        return null; 
      str2 = ar.c(str2);
    } 
  }
  
  private final String a(String paramString) {
    String str = paramString;
    if (str.endsWith("/"))
      str = str.substring(0, str.length() - 1); 
    if (str.length() == 0)
      str = "/"; 
    return str;
  }
  
  private final String a(s params) {
    String str;
    if (params instanceof l) {
      str = params.h;
    } else {
      str = params.d();
    } 
    if (str.endsWith("/"))
      str = str.substring(0, str.length() - 1); 
    if (str.length() == 0)
      str = "/"; 
    return str;
  }
  
  protected final void finalize() {
    this.a.clear();
    this.a = null;
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\model\m.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */