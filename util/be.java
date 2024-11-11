package util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import model.e;
import model.h;
import model.l;
import model.m;
import model.r;
import model.s;
import model.t;

public abstract class be {
  private static final SimpleDateFormat e = new SimpleDateFormat("d'-'MMM'-'yy H':'mm");
  
  public static t d;
  
  public static boolean b = false;
  
  public static String a = null;
  
  private static int c;
  
  private static int f;
  
  public static final void b() {
    d = new t();
  }
  
  public static final void a(File[] paramArrayOfFile) {
    if (paramArrayOfFile == null)
      return; 
    f.a(true);
    n.p();
    f.a("Adding");
    List list = d.a();
    ArrayList arrayList = new ArrayList();
    m m1 = d.a.b();
    m m2 = new m();
    c = 1;
    for (byte b = 0; b < paramArrayOfFile.length; b++) {
      String str;
      File file = paramArrayOfFile[b];
      if (!file.exists()) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The following path is not valid:\n");
        stringBuffer.append("    " + ar.d(file));
        aw.b("Cannot add file or directory", stringBuffer.toString());
        break;
      } 
      if (a == null) {
        a = a(file);
        str = a;
      } else if (a(file, a)) {
        str = a;
      } else {
        str = a(file);
      } 
      try {
        if (file.isDirectory()) {
          a(file, str, list, m1, arrayList, m2);
        } else {
          boolean bool = (b == paramArrayOfFile.length - 1) ? true : false;
          a(file, str, list, m1, arrayList, m2, bool);
        } 
      } catch (IllegalStateException illegalStateException) {
        break;
      } catch (SecurityException securityException) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("File permission problem encountered while adding:\n");
        stringBuffer.append("    " + ar.d(file));
        aw.a("Cannot add file or directory", stringBuffer.toString(), securityException);
      } 
    } 
    if (arrayList.size() > 0) {
      list.addAll(arrayList);
      m1.a(m2);
      d.a(list);
      d.a = m1;
      m2.a();
      b = true;
      at.a(arrayList);
    } 
    f.b();
    f.a(false);
  }
  
  private static final void a(File paramFile, String paramString, Collection paramCollection1, m paramm1, Collection paramCollection2, m paramm2) throws IllegalStateException {
    if (n.r())
      throw new IllegalStateException("Add operation cancelled."); 
    l l = new l();
    l.h = b(paramFile, paramString);
    l.a = paramFile.lastModified();
    if (l.a == 0L)
      l.a = -1L; 
    boolean bool = false;
    Collection collection = paramCollection2;
    m m1 = paramm2;
    s s = m1.a(3, l.h);
    if (s == null) {
      collection = paramCollection1;
      m1 = paramm1;
      s = m1.a(3, l.h);
    } 
    if (s != null) {
      boolean bool1;
      if (c == 0) {
        bool1 = true;
      } else if (c == 3) {
        bool1 = false;
      } else {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Do you want to replace the existing directory entry?\n");
        stringBuffer.append("    " + s.h);
        c = aw.c("Confirm entry replacement", stringBuffer.toString(), c);
        if (c == 4)
          throw new IllegalStateException("Add operation cancelled."); 
        bool1 = (c == 0 || c == 1) ? true : false;
      } 
      if (bool1) {
        collection.remove(s);
        m1.c(s);
      } else {
        bool = true;
      } 
    } 
    collection = paramCollection2;
    m1 = paramm2;
    s = m1.a(1, l.h);
    if (s == null) {
      collection = paramCollection1;
      m1 = paramm1;
      s = m1.a(1, l.h);
    } 
    if (s != null) {
      boolean bool1;
      if (c == 0) {
        bool1 = true;
      } else if (c == 3) {
        bool1 = false;
      } else {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Do you want to replace the existing file entry?\n");
        stringBuffer.append("    " + s.h);
        c = aw.c("Confirm entry replacement", stringBuffer.toString(), c);
        if (c == 4)
          throw new IllegalStateException("Add operation cancelled."); 
        bool1 = (c == 0 || c == 1) ? true : false;
      } 
      if (bool1) {
        collection.remove(s);
        m1.c(s);
      } else {
        return;
      } 
    } 
    collection = paramCollection2;
    m1 = paramm2;
    s = m1.a(5, l.h);
    if (s == null) {
      collection = paramCollection1;
      m1 = paramm1;
      s = m1.a(5, l.h);
    } 
    if (s != null) {
      boolean bool1;
      if (c == 0) {
        bool1 = true;
      } else if (c == 3) {
        bool1 = false;
      } else {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Do you want to replace the existing file entry?\n");
        stringBuffer.append("    " + s.h + "\n");
        stringBuffer.append("Otherwise the following directory entry will not be added:\n");
        stringBuffer.append("    " + l.h);
        c = aw.c("Confirm entry replacement", stringBuffer.toString(), c);
        if (c == 4)
          throw new IllegalStateException("Add operation cancelled."); 
        bool1 = (c == 0 || c == 1) ? true : false;
      } 
      if (bool1) {
        collection.remove(s);
        m1.c(s);
      } else {
        return;
      } 
    } 
    if (!bool) {
      paramCollection2.add(l);
      paramm2.b((s)l);
      int i = paramCollection2.size();
      f.a("Adding " + i + " " + ((i == 1) ? "entry" : "entries"));
    } 
    File[] arrayOfFile = paramFile.listFiles();
    for (byte b = 0; b < arrayOfFile.length; b++) {
      if (arrayOfFile[b].isDirectory()) {
        a(arrayOfFile[b], paramString, paramCollection1, paramm1, paramCollection2, paramm2);
      } else {
        a(arrayOfFile[b], paramString, paramCollection1, paramm1, paramCollection2, paramm2, false);
      } 
    } 
  }
  
  private static final void a(File paramFile, String paramString, Collection paramCollection1, m paramm1, Collection paramCollection2, m paramm2, boolean paramBoolean) throws IllegalStateException {
    if (n.r())
      throw new IllegalStateException("Add operation cancelled."); 
    e e = new e();
    e.h = b(paramFile, paramString);
    e.a = paramFile.lastModified();
    e.g = false;
    r r = new r();
    r.b = paramFile;
    r.a = paramFile.length();
    e.j = (h)r;
    String str = e.h + "/";
    Collection collection = paramCollection2;
    m m1 = paramm2;
    s s = m1.a(4, str);
    if (s == null) {
      collection = paramCollection1;
      m1 = paramm1;
      s = m1.a(4, str);
    } 
    if (s != null) {
      boolean bool;
      if (c == 0) {
        bool = true;
      } else if (c == 3) {
        bool = false;
      } else {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("There are one or more existing entries using the following path:\n");
        stringBuffer.append("    " + str + "\n");
        stringBuffer.append("Do you want to replace these entries with this file entry?\n");
        stringBuffer.append("    " + e.h);
        if (paramBoolean) {
          bool = aw.c("Confirm entry replacement", stringBuffer.toString());
        } else {
          c = aw.c("Confirm entry replacement", stringBuffer.toString(), c);
          if (c == 4)
            throw new IllegalStateException("Add operation cancelled."); 
          bool = (c == 0 || c == 1) ? true : false;
        } 
      } 
      if (bool) {
        a(str, paramCollection2);
        paramm2.g(str);
        a(str, paramCollection1);
        paramm1.g(str);
      } else {
        return;
      } 
    } 
    collection = paramCollection2;
    m1 = paramm2;
    s = m1.a(1, e.h);
    if (s == null) {
      collection = paramCollection1;
      m1 = paramm1;
      s = m1.a(1, e.h);
    } 
    if (s != null) {
      boolean bool;
      if (c == 0) {
        bool = true;
      } else if (c == 3) {
        bool = false;
      } else {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Do you want to replace the existing file entry?\n");
        stringBuffer.append("    " + s.h);
        if (paramBoolean) {
          bool = aw.c("Confirm entry replacement", stringBuffer.toString());
        } else {
          c = aw.c("Confirm entry replacement", stringBuffer.toString(), c);
          if (c == 4)
            throw new IllegalStateException("Add operation cancelled."); 
          bool = (c == 0 || c == 1) ? true : false;
        } 
      } 
      if (bool) {
        collection.remove(s);
        m1.c(s);
      } else {
        return;
      } 
    } 
    collection = paramCollection2;
    m1 = paramm2;
    s = m1.a(5, e.h);
    if (s == null) {
      collection = paramCollection1;
      m1 = paramm1;
      s = m1.a(5, e.h);
    } 
    if (s != null) {
      boolean bool;
      if (c == 0) {
        bool = true;
      } else if (c == 3) {
        bool = false;
      } else {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Do you want to replace the existing file entry?\n");
        stringBuffer.append("    " + s.h + "\n");
        stringBuffer.append("Otherwise the following file entry will not be added:\n");
        stringBuffer.append("    " + e.h);
        if (paramBoolean) {
          bool = aw.c("Confirm entry replacement", stringBuffer.toString());
        } else {
          c = aw.c("Confirm entry replacement", stringBuffer.toString(), c);
          if (c == 4)
            throw new IllegalStateException("Add operation cancelled."); 
          bool = (c == 0 || c == 1) ? true : false;
        } 
      } 
      if (bool) {
        collection.remove(s);
        m1.c(s);
      } else {
        return;
      } 
    } 
    paramCollection2.add(e);
    paramm2.b((s)e);
    int i = paramCollection2.size();
    f.a("Adding " + i + " " + ((i == 1) ? "entry" : "entries"));
  }
  
  public static final void f() {
    int[] arrayOfInt = at.f.k();
    int i = arrayOfInt.length;
    if (i > 0) {
      f.a("Removing " + i + " " + ((i == 1) ? "entry" : "entries"));
      f.a(true);
      at.f.setValueIsAdjusting(true);
      d.a(arrayOfInt);
      at.f.setValueIsAdjusting(false);
      b = true;
      f.b();
      f.a(false);
    } 
  }
  
  public static final void g() {
    String str1 = ar.b();
    String str2 = "Enter the directory path.";
    if (ar.a())
      str2 = str2 + "\nUse forward slashes to separate directories."; 
    String str3 = aw.a("New directory", str2, str1, aw.j);
    if (str3 == null)
      return; 
    str3 = str3.trim();
    str3 = ar.j(str3);
    if (ar.a() && ar.i(str3) && aw.c("Convert backslashes", "The entered directory path contains backslash characters.\nDo you want use these to separate directories?"))
      str3 = ar.f(str3); 
    String str4 = str3;
    String str5 = str3;
    if (str3.endsWith("/")) {
      str5 = str3.substring(0, str3.length() - 1);
    } else {
      str4 = str4 + "/";
    } 
    if (str5.length() == 0)
      return; 
    if (!ar.d(str4)) {
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append("The entered path contains one or more invalid characters:\n");
      stringBuffer.append("    " + str4);
      aw.b("Invalid directory path", stringBuffer.toString());
      return;
    } 
    s s = d.a.a(3, str4);
    if (s != null) {
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append("There is already a directory entry with the following path:\n");
      stringBuffer.append("    " + str4 + "\n");
      stringBuffer.append("Do you want to replace this entry?");
      boolean bool = aw.c("Confirm entry replacement", stringBuffer.toString());
      if (bool) {
        d.d(s);
      } else {
        return;
      } 
    } 
    s = d.a.a(1, str5);
    if (s != null) {
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append("There is already a file entry with the following path:\n");
      stringBuffer.append("    " + str5 + "\n");
      stringBuffer.append("Do you want to replace this entry?");
      boolean bool = aw.c("Confirm entry replacement", stringBuffer.toString());
      if (bool) {
        d.d(s);
      } else {
        return;
      } 
    } 
    s = d.a.a(5, str4);
    if (s != null) {
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append("Do you want to replace the existing file entry?\n");
      stringBuffer.append("    " + s.h + "\n");
      stringBuffer.append("Otherwise the following directory entry will not be created:\n");
      stringBuffer.append("    " + str4);
      boolean bool = aw.c("Confirm entry replacement", stringBuffer.toString());
      if (bool) {
        d.d(s);
      } else {
        return;
      } 
    } 
    f.a(true);
    l l = new l();
    l.h = str4;
    l.a = System.currentTimeMillis();
    d.b((s)l);
    b = true;
    at.a((s)l);
    f.b();
    f.a(false);
  }
  
  public static final void d() {
    String str7;
    s s2;
    s s1 = at.h();
    if (s1 == null)
      return; 
    at.k();
    boolean bool = s1 instanceof l;
    String str1 = s1.j();
    String str3 = bool ? "directory" : "file";
    String str2 = aw.a("Rename entry", "Rename the " + str3 + " entry '" + str1 + "'.", str1, aw.d);
    if (str2 == null)
      return; 
    str2 = str2.trim();
    str2 = ar.j(str2);
    String str4 = str2;
    String str5 = str2;
    String str6 = str2;
    if (str2.endsWith("/")) {
      str6 = str2.substring(0, str2.length() - 1);
    } else {
      str5 = str5 + "/";
    } 
    if (str6.length() == 0) {
      aw.b("Entry not renamed", "If you want to delete the entry, select it and then click the Remove button.");
      return;
    } 
    if (bool) {
      if (str5.equals(str1))
        return; 
      if (!ar.a(str5)) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The entered directory name contains one or more invalid characters:\n");
        stringBuffer.append("    " + str5);
        aw.b("Invalid directory name", stringBuffer.toString());
        return;
      } 
    } else {
      if (str4.equals(str1))
        return; 
      if (!ar.e(str4)) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The entered file name contains one or more invalid characters:\n");
        stringBuffer.append("    " + str4);
        aw.b("Invalid file name", stringBuffer.toString());
        return;
      } 
    } 
    if (bool) {
      str7 = s1.d() + str5;
    } else {
      str7 = s1.d() + str6;
    } 
    f.a(true);
    if (bool) {
      s2 = d.a.a(2, str7);
    } else {
      s2 = d.a.a(1, str7);
    } 
    if (s2 != null) {
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append("Do you want to replace the existing " + str3 + " entry of the same name?\n");
      stringBuffer.append("    " + s2.h);
      boolean bool1 = aw.c("Confirm entry replacement", stringBuffer.toString());
      if (bool1) {
        d.d(s2);
      } else {
        f.a(false);
        return;
      } 
    } 
    if (!bool) {
      s2 = d.a.a(4, str7);
      if (s2 != null) {
        String str = str7 + "/";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("There are one or more existing entries using the following path:\n");
        stringBuffer.append("    " + str + "\n");
        stringBuffer.append("Do you want to replace these entries with the renamed file entry?\n");
        stringBuffer.append("    " + str6);
        boolean bool1 = aw.c("Confirm entry replacement", stringBuffer.toString());
        if (bool1) {
          a(str, d.c());
          d.a.g(str);
        } else {
          f.a(false);
          return;
        } 
      } 
    } 
    d.a.c(s1);
    s1.h = str7;
    s1.h();
    int i = d.a(s1);
    i = d.b(i);
    d.a.b(s1);
    b = true;
    at.b(i);
    f.b();
    f.a(false);
  }
  
  public static final void c() {
    int i = at.m();
    if (i == 0)
      return; 
    at.k();
    String str1 = ar.b();
    boolean bool = str1.equals("");
    if (i == 1) {
      str2 = aw.a("Change directory", "Change the directory of the selected entry.", str1, aw.m);
    } else if (bool) {
      str2 = aw.a("Change directory", "Change the directory of selected entries relative to the root level.", "", aw.m);
    } else {
      str2 = aw.a("Change directory", "Change the directory of selected entries relative to the following path:\n    " + str1, str1, aw.m);
    } 
    if (str2 == null)
      return; 
    String str2 = str2.trim();
    str2 = ar.j(str2);
    if (ar.a() && ar.i(str2) && aw.c("Convert backslashes", "The entered directory path contains backslash characters.\nDo you want to use these to separate directories?"))
      str2 = ar.f(str2); 
    String str3 = str2;
    String str4 = str2;
    if (str2.endsWith("/")) {
      str4 = str2.substring(0, str2.length() - 1);
    } else {
      str3 = str3 + "/";
    } 
    boolean bool1 = false;
    if (str4.length() == 0)
      bool1 = true; 
    if (bool && bool1)
      return; 
    if (str3.equals(str1))
      return; 
    if (!bool1 && !ar.d(str3)) {
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append("The entered path contains one or more invalid characters:\n");
      stringBuffer.append("    " + str3);
      aw.b("Invalid directory path", stringBuffer.toString());
      return;
    } 
    f.a(true);
    List list = at.a();
    List list1 = d.a();
    Iterator iterator1 = list.iterator();
    s s = iterator1.next();
    Iterator iterator2 = list1.iterator();
    while (iterator2.hasNext()) {
      s s1 = iterator2.next();
      if (s1.equals(s)) {
        iterator2.remove();
        if (iterator1.hasNext()) {
          s = iterator1.next();
          continue;
        } 
        break;
      } 
    } 
    m m = new m(list1);
    ArrayList arrayList = new ArrayList(list.size());
    for (s s1 : list)
      arrayList.add(s1.e()); 
    list.clear();
    list = null;
    TreeMap treeMap = new TreeMap();
    Iterator iterator3 = arrayList.iterator();
    String str5 = bool1 ? "" : str3;
    while (iterator3.hasNext()) {
      s s1 = iterator3.next();
      if (bool1 && s1 instanceof l && s1.h.equals(str1)) {
        iterator3.remove();
        continue;
      } 
      String str = str5 + s1.h.substring(str1.length());
      treeMap.put(str, s1.h);
      s1.h = str;
    } 
    f = 2;
    boolean bool2 = false;
    iterator3 = arrayList.iterator();
    while (iterator3.hasNext()) {
      s s1 = iterator3.next();
      String str6 = (String)treeMap.get(s1.h);
      s s2 = null;
      if (s1 instanceof l) {
        s2 = m.a(3, s1.h);
        if (s2 != null) {
          boolean bool4;
          if (f == 0) {
            bool4 = true;
          } else if (f == 3) {
            bool4 = false;
          } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Do you want to replace the existing directory entry?\n");
            stringBuffer.append("    " + s2.h);
            f = aw.c("Confirm entry replacement", stringBuffer.toString(), f);
            if (f == 4) {
              bool2 = true;
              break;
            } 
            bool4 = (f == 0 || f == 1) ? true : false;
          } 
          if (bool4) {
            list1.remove(s2);
            m.c(s2);
          } else {
            iterator3.remove();
            s1.h = str6;
            list1.add(s1);
            m.b(s1);
            continue;
          } 
        } 
        s2 = m.a(1, s1.h);
        if (s2 != null) {
          boolean bool4;
          if (f == 0) {
            bool4 = true;
          } else if (f == 3) {
            bool4 = false;
          } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Do you want to replace the existing file entry?\n");
            stringBuffer.append("    " + s2.h + "\n");
            stringBuffer.append("With the directory entry:\n");
            stringBuffer.append("    " + str6);
            f = aw.c("Confirm entry replacement", stringBuffer.toString(), f);
            if (f == 4) {
              bool2 = true;
              break;
            } 
            bool4 = (f == 0 || f == 1) ? true : false;
          } 
          if (bool4) {
            list1.remove(s2);
            m.c(s2);
          } else {
            iterator3.remove();
            s1.h = str6;
            list1.add(s1);
            m.b(s1);
            continue;
          } 
        } 
        s2 = m.a(5, s1.h);
        if (s2 != null) {
          boolean bool4;
          if (f == 0) {
            bool4 = true;
          } else if (f == 3) {
            bool4 = false;
          } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Do you want to replace the existing file entry?\n");
            stringBuffer.append("    " + s2.h + "\n");
            stringBuffer.append("Otherwise the directory entry cannot be changed from:\n");
            stringBuffer.append("    " + str6);
            f = aw.c("Confirm entry replacement", stringBuffer.toString(), f);
            if (f == 4) {
              bool2 = true;
              break;
            } 
            bool4 = (f == 0 || f == 1) ? true : false;
          } 
          if (bool4) {
            list1.remove(s2);
            m.c(s2);
            continue;
          } 
          iterator3.remove();
          s1.h = str6;
          list1.add(s1);
          m.b(s1);
        } 
        continue;
      } 
      boolean bool3 = !iterator3.hasNext() ? true : false;
      String str7 = s1.h + "/";
      s2 = m.a(4, str7);
      if (s2 != null) {
        boolean bool4;
        if (f == 0) {
          bool4 = true;
        } else if (f == 3) {
          bool4 = false;
        } else {
          StringBuffer stringBuffer = new StringBuffer();
          stringBuffer.append("There are one or more existing entries using the following path:\n");
          stringBuffer.append("    " + str7 + "\n");
          stringBuffer.append("Do you want to replace these entries with the file entry?\n");
          stringBuffer.append("    " + str6);
          if (bool3) {
            bool4 = aw.c("Confirm entry replacement", stringBuffer.toString());
          } else {
            f = aw.c("Confirm entry replacement", stringBuffer.toString(), f);
            if (f == 4) {
              bool2 = true;
              break;
            } 
            bool4 = (f == 0 || f == 1) ? true : false;
          } 
        } 
        if (bool4) {
          a(str7, list1);
          m.g(str7);
        } else {
          iterator3.remove();
          s1.h = str6;
          list1.add(s1);
          m.b(s1);
          continue;
        } 
      } 
      s2 = m.a(1, s1.h);
      if (s2 != null) {
        boolean bool4;
        if (f == 0) {
          bool4 = true;
        } else if (f == 3) {
          bool4 = false;
        } else {
          StringBuffer stringBuffer = new StringBuffer();
          stringBuffer.append("Do you want to replace the existing file entry?\n");
          stringBuffer.append("    " + s2.h + "\n");
          stringBuffer.append("With the file entry:\n");
          stringBuffer.append("    " + str6);
          if (bool3) {
            bool4 = aw.c("Confirm entry replacement", stringBuffer.toString());
          } else {
            f = aw.c("Confirm entry replacement", stringBuffer.toString(), f);
            if (f == 4) {
              bool2 = true;
              break;
            } 
            bool4 = (f == 0 || f == 1) ? true : false;
          } 
        } 
        if (bool4) {
          list1.remove(s2);
          m.c(s2);
        } else {
          iterator3.remove();
          s1.h = str6;
          list1.add(s1);
          m.b(s1);
          continue;
        } 
      } 
      s2 = m.a(5, s1.h);
      if (s2 != null) {
        boolean bool4;
        if (f == 0) {
          bool4 = true;
        } else if (f == 3) {
          bool4 = false;
        } else {
          StringBuffer stringBuffer = new StringBuffer();
          stringBuffer.append("Do you want to replace the existing file entry?\n");
          stringBuffer.append("    " + s2.h + "\n");
          stringBuffer.append("Otherwise the file entry cannot be changed from:\n");
          stringBuffer.append("    " + str6);
          if (bool3) {
            bool4 = aw.c("Confirm entry replacement", stringBuffer.toString());
          } else {
            f = aw.c("Confirm entry replacement", stringBuffer.toString(), f);
            if (f == 4) {
              bool2 = true;
              break;
            } 
            bool4 = (f == 0 || f == 1) ? true : false;
          } 
        } 
        if (bool4) {
          list1.remove(s2);
          m.c(s2);
          continue;
        } 
        iterator3.remove();
        s1.h = str6;
        list1.add(s1);
        m.b(s1);
      } 
    } 
    if (bool2) {
      list1.clear();
      arrayList.clear();
      m.a();
      f.a(false);
      return;
    } 
    list1.addAll(arrayList);
    m.a(arrayList);
    d.a(list1);
    d.a = m;
    b = true;
    at.a(arrayList);
    f.b();
    f.a(false);
  }
  
  public static final void e() {
    String str1;
    long l;
    if (at.f.isSelectionEmpty())
      return; 
    List list = at.a();
    s s = at.h();
    at.k();
    StringBuffer stringBuffer = new StringBuffer();
    if (list.size() == 1) {
      str1 = (s instanceof l) ? "directory" : "file";
      stringBuffer.append("Change the modified date of the " + str1 + " entry:\n");
      stringBuffer.append("    " + s.h + "\n");
    } else {
      stringBuffer.append("Enter the modified date for the selected entries.\n");
    } 
    stringBuffer.append("The entry format is D-MMM-YY H:NN using a 24 hour clock.");
    if (list.size() == 1 && s.a > -1L) {
      str1 = e.format(new Date(s.a));
    } else {
      str1 = e.format(new Date());
    } 
    String str2 = aw.a("Change modified date", stringBuffer.toString(), str1, aw.l);
    if (str2 == null)
      return; 
    try {
      l = e.parse(str2).getTime();
      l = Math.max(0L, l);
    } catch (Exception exception) {
      aw.b("Modified date not changed", "The value you entered was not recognised as a valid date.");
      return;
    } 
    f.a(true);
    boolean bool = (list.size() < 100 && d.getSize() < 1000) ? true : false;
    ArrayList arrayList = new ArrayList();
    for (s s1 : list) {
      if (!e.format(new Date(s1.a)).equals(e.format(new Date(l)))) {
        s1.a = l;
        s1.b();
        arrayList.add(s1);
      } 
    } 
    if (arrayList.size() > 0) {
      b = true;
      if (d.e() == 2) {
        List list1 = d.a();
        d.a(list1);
        at.a(list);
      } else if (bool) {
        d.c(arrayList);
      } else {
        d.g();
      } 
    } 
    f.b();
    f.a(false);
  }
  
  public static final void b(boolean paramBoolean) {
    f.a(true);
    if (!at.c())
      return; 
    List list = at.f.d();
    boolean bool = (list.size() < 100 && d.getSize() < 1000) ? true : false;
    int[] arrayOfInt = new int[list.size()];
    byte b = 0;
    for (s s : list) {
      if (s instanceof e) {
        e e = (e)s;
        if (e.g != paramBoolean) {
          e.g = paramBoolean;
          e.f();
          if (bool)
            arrayOfInt[b] = d.a((s)e); 
          b++;
        } 
      } 
    } 
    if (b > 0) {
      if (bool) {
        d.a(arrayOfInt, b);
      } else {
        d.g();
      } 
      b = true;
      f.b();
    } 
    f.a(false);
  }
  
  public static final void a(int paramInt) {
    f.a(true);
    f.a("Sorting");
    List list = at.a();
    d.a(paramInt);
    at.a(list);
    f.b();
    f.a(false);
  }
  
  public static final void a() {
    f.a("Validating entries");
    List list = d.a();
    ArrayList arrayList = new ArrayList(list);
    byte b = 0;
    StringBuffer stringBuffer1 = new StringBuffer();
    for (s s1 : list) {
      s s2 = null;
      if (s1 instanceof l) {
        s2 = d.a.a(1, s1.h);
        if (s2 != null) {
          b++;
          stringBuffer1.append("    " + s2.h + "\n");
          arrayList.remove(s2);
          d.a.c(s2);
        } 
      } 
    } 
    f.a("Validating paths");
    list = new ArrayList(arrayList);
    TreeSet treeSet = new TreeSet();
    for (s s : list) {
      String str = ar.c(s.h);
      if (str.length() > 0 && !treeSet.contains(str)) {
        for (s s1 = d.a.a(5, s.h); s1 != null; s1 = d.a.a(5, s.h)) {
          b++;
          stringBuffer1.append("    " + s1.h + "\n");
          arrayList.remove(s1);
          d.a.c(s1);
        } 
        while (str.length() > 0) {
          treeSet.add(str);
          str = ar.c(str);
        } 
      } 
    } 
    treeSet.clear();
    StringBuffer stringBuffer2 = new StringBuffer();
    if (b == 1) {
      stringBuffer2.append("The zip file contains a file and directory with a similar path.\n");
      stringBuffer2.append("The following file will be omitted from the list.\n");
      stringBuffer2.append(stringBuffer1.toString());
      stringBuffer2.append("The zip file will not be affected until you choose Save.");
    } else if (b > 1 && b <= 10) {
      stringBuffer2.append("The zip file contains " + b + " files which conflict with other directory paths.\n");
      stringBuffer2.append("These files will be omitted from the list.\n");
      stringBuffer2.append(stringBuffer1.toString());
      stringBuffer2.append("The zip file will not be affected until you choose Save.");
    } else if (b > 10) {
      stringBuffer2.append("The zip file contains " + b + " files which conflict with other directory paths.\n");
      stringBuffer2.append("These files will be omitted from the list.\n");
      stringBuffer2.append("The zip file will not be affected until you choose Save.");
    } 
    if (b > 0) {
      f.a("Validating");
      b = true;
      aw.b("Validating zip entries", stringBuffer2.toString());
      f.a(true);
      d.a(arrayList);
      f.a(false);
    } 
    list.clear();
    arrayList.clear();
  }
  
  public static final boolean a(boolean paramBoolean) {
    List list = d.a();
    TreeSet treeSet = new TreeSet();
    boolean bool = false;
    for (s s : list) {
      String str = ar.c(s.h);
      bool = a(str, treeSet);
      if (bool)
        break; 
    } 
    treeSet.clear();
    if (!bool)
      return true; 
    boolean bool1 = !paramBoolean ? true : true;
    int i = aw.a("Create directory entries", "Not all entry paths are represented by directory entries.\nWould you like zipcreator to create these for you?", bool1);
    switch (i) {
      case 1:
        break;
      case 2:
        return true;
      default:
        return false;
    } 
    f.a("Creating directory entries");
    Iterator iterator = list.iterator();
    ArrayList arrayList = new ArrayList();
    while (iterator.hasNext()) {
      s s = iterator.next();
      String str = ar.c(s.h);
      arrayList.addAll(b(str, treeSet));
    } 
    list.addAll(arrayList);
    d.a(list);
    d.a.a(arrayList);
    at.a(arrayList);
    treeSet.clear();
    list.clear();
    b = true;
    return true;
  }
  
  private static final String b(File paramFile, String paramString) {
    null = ar.e(paramFile);
    if (paramFile.isDirectory() && !null.endsWith("/"))
      null = null + "/"; 
    return null.substring(paramString.length());
  }
  
  private static final String a(File paramFile) {
    return ar.c(ar.e(paramFile));
  }
  
  private static final boolean a(File paramFile, String paramString) {
    String str = ar.e(paramFile);
    return str.startsWith(paramString);
  }
  
  private static final void a(String paramString, Collection paramCollection) {
    a(paramString, paramCollection.iterator());
  }
  
  private static final void a(String paramString, Iterator paramIterator) {
    if (!paramString.endsWith("/"))
      paramString = paramString + "/"; 
    while (paramIterator.hasNext()) {
      s s = paramIterator.next();
      if (s.h.startsWith(paramString))
        paramIterator.remove(); 
    } 
  }
  
  private static final boolean a(String paramString, Set paramSet) {
    while (paramString.length() > 0) {
      if (!paramSet.contains(paramString)) {
        s s = d.a.a(3, paramString);
        if (s == null)
          return true; 
        paramSet.add(paramString);
      } 
      paramString = ar.c(paramString);
    } 
    return false;
  }
  
  private static final List b(String paramString, Set paramSet) {
    ArrayList arrayList = new ArrayList();
    while (paramString.length() > 0) {
      if (!paramSet.contains(paramString)) {
        s s = d.a.a(3, paramString);
        if (s == null) {
          l l = new l();
          l.h = paramString;
          l.a = System.currentTimeMillis();
          arrayList.add(l);
        } 
        paramSet.add(paramString);
      } 
      paramString = ar.c(paramString);
    } 
    return arrayList;
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\be.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */