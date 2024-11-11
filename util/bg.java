package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import model.e;
import model.k;
import model.s;

public abstract class bg {
  public static boolean e = true;
  
  private static int c;
  
  private static File a = null;
  
  private static File b = null;
  
  private static boolean d = false;
  
  public static final void c() {
    b = null;
  }
  
  public static final boolean a(List paramList1, List paramList2, boolean paramBoolean1, boolean paramBoolean2) {
    File file = ba.a(ba.d(), "clip");
    b = file;
    String str = paramBoolean1 ? "cut" : "copy";
    f.a("Preparing " + str);
    if (be.d.e() != 1)
      ar.a(paramList1); 
    a.h();
    n.p();
    aq.a("Preparing " + str);
    aq.a(paramList1);
    boolean bool = true;
    TreeSet treeSet = new TreeSet();
    HashMap hashMap1 = new HashMap();
    HashMap hashMap2 = new HashMap();
    c = 0;
    for (s s : paramList1) {
      try {
        bool = a(file, s, treeSet, hashMap1, hashMap2, false, paramBoolean2);
        if (a.c() || n.r())
          bool = false; 
      } catch (IllegalStateException illegalStateException) {
        break;
      } 
      if (b != file)
        bool = false; 
      if (!bool)
        break; 
    } 
    r.a(hashMap2.values());
    hashMap2.clear();
    a(hashMap1);
    hashMap1.clear();
    if (bool) {
      File[] arrayOfFile = file.listFiles();
      for (byte b = 0; b < arrayOfFile.length; b++)
        paramList2.add(arrayOfFile[b]); 
    } 
    a.i();
    return bool;
  }
  
  public static final void a() {
    a = null;
  }
  
  public static final void a(List paramList1, List paramList2, boolean paramBoolean) {
    File file = ba.a(ba.d(), "drag");
    a = file;
    f.a("Preparing drag");
    if (be.d.e() != 1)
      ar.a(paramList1); 
    aq.a("Preparing drag");
    aq.a(paramList1);
    boolean bool = true;
    TreeSet treeSet = new TreeSet();
    HashMap hashMap1 = new HashMap();
    HashMap hashMap2 = new HashMap();
    c = 0;
    for (s s : paramList1) {
      try {
        bool = a(file, s, treeSet, hashMap1, hashMap2, false, paramBoolean);
      } catch (IllegalStateException illegalStateException) {
        break;
      } 
      if (a != file)
        bool = false; 
      if (!bool)
        break; 
    } 
    r.a(hashMap2.values());
    hashMap2.clear();
    a(hashMap1);
    hashMap1.clear();
    if (bool) {
      File[] arrayOfFile = file.listFiles();
      synchronized (paramList2) {
        paramList2.clear();
        for (byte b = 0; b < arrayOfFile.length; b++)
          paramList2.add(arrayOfFile[b]); 
      } 
      f.a("Ready to drop");
    } else {
      f.b();
    } 
  }
  
  public static final void a(File paramFile, boolean paramBoolean) {
    if (!paramFile.isDirectory()) {
      aw.b("Cannot extract", "The destination directory does not exist:\n    " + ar.d(paramFile));
      return;
    } 
    f.a(true);
    f.a("Extracting");
    List list = paramBoolean ? be.d.a() : at.a();
    if (be.d.e() != 1)
      ar.a(list); 
    boolean bool1 = a(paramFile, list, false, e);
    if (!bool1) {
      list.clear();
      f.b();
      f.a(false);
      return;
    } 
    a.h();
    n.p();
    aq.a("Extracting");
    aq.a(list);
    boolean bool2 = true;
    TreeSet treeSet = new TreeSet();
    HashMap hashMap1 = new HashMap();
    HashMap hashMap2 = new HashMap();
    c = 2;
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      s s = iterator.next();
      try {
        boolean bool = !iterator.hasNext() ? true : false;
        bool2 = a(paramFile, s, treeSet, hashMap1, hashMap2, bool, e);
        if (a.c() || n.r())
          bool2 = false; 
      } catch (IllegalStateException illegalStateException) {
        break;
      } 
      if (!bool2)
        break; 
    } 
    r.a(hashMap2.values());
    hashMap2.clear();
    a(hashMap1);
    hashMap1.clear();
    list.clear();
    a.i();
    f.b();
    f.a(false);
  }
  
  private static final boolean a(File paramFile, s params, Set paramSet, Map paramMap1, Map paramMap2, boolean paramBoolean1, boolean paramBoolean2) {
    File file = null;
    boolean bool = false;
    try {
      if (params instanceof e) {
        e e = (e)params;
        if (!e.j.b.exists())
          throw new IOException("The source file does not exist:\n    " + ar.d(e.j.b)); 
        if (paramBoolean2) {
          for (String str = ar.c(params.h); str.length() > 0; str = ar.c(str)) {
            if (!paramSet.contains(str)) {
              File file1 = a(paramFile, str);
              if (file1.isFile()) {
                boolean bool1;
                if (c == 0) {
                  bool1 = true;
                } else {
                  String str1 = "Confirm file replacement";
                  StringBuffer stringBuffer = new StringBuffer();
                  stringBuffer.append("Do you want to replace the existing file:\n");
                  stringBuffer.append("    " + ar.d(file1) + "\n");
                  stringBuffer.append("With the file entry:\n");
                  stringBuffer.append("    " + params.h);
                  if (paramBoolean1) {
                    bool1 = aw.c(str1, stringBuffer.toString());
                  } else {
                    c = aw.b(str1, stringBuffer.toString(), c);
                    if (c == 4)
                      throw new IllegalStateException("Extract operation cancelled."); 
                    bool1 = (c == 0 || c == 1) ? true : false;
                  } 
                } 
                if (bool1) {
                  ar.b(file1);
                } else {
                  return false;
                } 
              } 
              paramSet.add(str);
            } 
          } 
          file = a(paramFile, params.h);
          if (!file.getParentFile().isDirectory())
            file.getParentFile().mkdirs(); 
        } else {
          file = a(paramFile, e.j());
        } 
        if (file.exists()) {
          boolean bool1;
          if (c == 0) {
            bool1 = true;
          } else if (c == 3) {
            bool1 = false;
          } else {
            boolean bool2 = file.isDirectory();
            String str1 = bool2 ? "directory" : "file";
            String str2 = "Confirm " + str1 + " replacement";
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Do you want to replace the existing " + str1 + ":\n");
            stringBuffer.append("    " + ar.d(file) + "\n");
            stringBuffer.append("With the file entry:\n");
            stringBuffer.append("    " + params.h + "\n");
            if (bool2)
              stringBuffer.append("By replacing the directory, all of its contents will be permanently deleted."); 
            if (paramBoolean1) {
              bool1 = aw.c(str2, stringBuffer.toString().trim());
            } else {
              c = aw.c(str2, stringBuffer.toString().trim(), c);
              if (c == 4)
                throw new IllegalStateException("Extract operation cancelled."); 
              bool1 = (c == 0 || c == 1) ? true : false;
            } 
          } 
          if (bool1) {
            ar.b(file);
          } else {
            aq.a((s)e);
            return true;
          } 
        } 
        if (e.j instanceof k) {
          ZipFile zipFile;
          k k = (k)e.j;
          if (paramMap2.containsKey(k.b)) {
            zipFile = (ZipFile)paramMap2.get(k.b);
          } else {
            zipFile = new ZipFile(k.b);
            paramMap2.put(k.b, zipFile);
          } 
          ZipEntry zipEntry = zipFile.getEntry(k.d);
          if (zipEntry == null)
            throw new IOException("Cannot find entry '" + k.d + "' in the zip file '" + ar.d(k.b) + "'."); 
          file.createNewFile();
          bool = true;
          BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
          BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
          int i = 65536;
          byte[] arrayOfByte = new byte[i];
          while (true) {
            int j = bufferedInputStream.available();
            if (j <= 0)
              break; 
            int m = (j < i) ? j : i;
            int n = bufferedInputStream.read(arrayOfByte, 0, m);
            if (n == -1)
              break; 
            if (n > 0) {
              bufferedOutputStream.write(arrayOfByte, 0, n);
              aq.e += n;
              aq.a();
            } 
          } 
          bufferedOutputStream.flush();
          bool = false;
          bufferedOutputStream.close();
          bufferedInputStream.close();
        } else {
          if (e.j.b == null)
            throw new IOException("The source file for entry '" + e.h + "' cannot be identified."); 
          if (!e.j.b.exists())
            throw new IOException("The source file '" + ar.d(e.j.b) + "' for entry '" + e.h + "' does not exist."); 
          if (!e.j.b.canRead())
            throw new IOException("The source file '" + ar.d(e.j.b) + "' for entry '" + e.h + "' cannot be read."); 
          file.createNewFile();
          bool = true;
          BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
          BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(e.j.b));
          int i = 65536;
          byte[] arrayOfByte = new byte[i];
          while (true) {
            int j = bufferedInputStream.available();
            if (j <= 0)
              break; 
            int k = (j < i) ? j : i;
            int m = bufferedInputStream.read(arrayOfByte, 0, k);
            if (m == -1)
              break; 
            if (m > 0) {
              bufferedOutputStream.write(arrayOfByte, 0, m);
              aq.e += m;
              aq.a();
            } 
          } 
          bufferedOutputStream.flush();
          bool = false;
          bufferedOutputStream.close();
          bufferedInputStream.close();
        } 
        if (params.a > -1L)
          try {
            file.setLastModified(params.a);
          } catch (Exception exception) {} 
      } else if (paramBoolean2) {
        for (String str = ar.c(params.h); str.length() > 0; str = ar.c(str)) {
          if (!paramSet.contains(str)) {
            File file1 = a(paramFile, str);
            if (file1.isFile()) {
              boolean bool2;
              if (c == 0) {
                bool2 = true;
              } else {
                String str1 = "Confirm file replacement";
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Do you want to replace the existing file:\n");
                stringBuffer.append("    " + ar.d(file1) + "\n");
                stringBuffer.append("With the directory entry:\n");
                stringBuffer.append("    " + params.h);
                if (paramBoolean1) {
                  bool2 = aw.c(str1, stringBuffer.toString());
                } else {
                  c = aw.b(str1, stringBuffer.toString(), c);
                  if (c == 4)
                    throw new IllegalStateException("Extract operation cancelled."); 
                  bool2 = (c == 0 || c == 1) ? true : false;
                } 
              } 
              if (bool2) {
                ar.b(file1);
              } else {
                return false;
              } 
            } 
            paramSet.add(str);
          } 
        } 
        file = a(paramFile, params.h);
        if (file.isFile()) {
          boolean bool2;
          if (c == 0) {
            bool2 = true;
          } else {
            String str1 = "Confirm file replacement";
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Do you want to replace the existing file:\n");
            stringBuffer.append("    " + ar.d(file) + "\n");
            stringBuffer.append("With the directory entry:\n");
            stringBuffer.append("    " + params.h);
            if (paramBoolean1) {
              bool2 = aw.c(str1, stringBuffer.toString());
            } else {
              c = aw.b(str1, stringBuffer.toString(), c);
              if (c == 4)
                throw new IllegalStateException("Extract operation cancelled."); 
              bool2 = (c == 0 || c == 1) ? true : false;
            } 
          } 
          if (bool2) {
            ar.b(file);
          } else {
            return false;
          } 
        } 
        boolean bool1 = file.mkdirs();
        if (params.a > -1L && (bool1 || file.lastModified() < params.a))
          paramMap1.put(params, file); 
      } 
      return true;
    } catch (Exception exception) {
      d = true;
      if (bool) {
        System.gc();
        ar.a(file);
      } 
      aw.a("Cannot extract entry", "An error occurred while extracting the following entry:\n    " + params.h, exception);
      d = false;
      return false;
    } 
  }
  
  public static final boolean b() {
    return d;
  }
  
  private static final void a(Map paramMap) {
    try {
      for (s s : paramMap.keySet()) {
        File file = (File)paramMap.get(s);
        file.setLastModified(s.a);
      } 
    } catch (Exception exception) {}
  }
  
  private static final File a(File paramFile, String paramString) {
    String str = paramString;
    if (paramString.endsWith("/"))
      str = paramString.substring(0, paramString.length() - 1); 
    return ar.a() ? new File(paramFile, str.replace('/', File.separatorChar)) : new File(paramFile, str);
  }
  
  public static final boolean a(File paramFile, List paramList, boolean paramBoolean1, boolean paramBoolean2) {
    boolean bool;
    ArrayList arrayList = new ArrayList();
    arrayList.addAll(paramList);
    StringBuffer stringBuffer1 = new StringBuffer();
    byte b1 = 0;
    byte b2 = 0;
    byte b3 = 0;
    StringBuffer stringBuffer2 = new StringBuffer();
    StringBuffer stringBuffer3 = new StringBuffer();
    StringBuffer stringBuffer4 = new StringBuffer();
    if (ar.a()) {
      for (s s : paramList) {
        String str = paramBoolean2 ? s.h : s.j();
        if (!ar.g(str)) {
          arrayList.remove(s);
          b1++;
          stringBuffer2.append("    " + str + "\n");
        } 
      } 
      if (b1 > 0)
        if (b1 == 1) {
          stringBuffer1.append("The following entry is not compatible with your file system.\n");
          stringBuffer1.append("To extract it you should remove any \\ : * ? \" < > | characters.\n");
          stringBuffer1.append(stringBuffer2.toString());
        } else if (b1 <= 4) {
          stringBuffer1.append("The following entries are not compatible with your file system.\n");
          stringBuffer1.append("To extract them you should remove all \\ : * ? \" < > | characters.\n");
          stringBuffer1.append(stringBuffer2.toString());
        } else {
          stringBuffer1.append("There are " + b1 + " entries which are incompatible with your file system.\n");
          stringBuffer1.append("To extract these entries you should remove all \\ : * ? \" < > | characters.\n");
        }  
    } 
    try {
      l.f(paramFile);
    } catch (IOException iOException) {
      aw.a("Extraction tests failed", "The capabilities of the file system could not be evaluated.", iOException);
      return false;
    } 
    if (!l.i(paramFile)) {
      if (b1 == 0) {
        stringBuffer1.append("zipcreator does not have permission to read the contents of the destination directory.\n");
      } else {
        stringBuffer1.append("Additionally, zipcreator does not have permission to read the destination directory.\n");
      } 
      aw.b("Extract operation cancelled", stringBuffer1.toString());
      return false;
    } 
    boolean bool1 = l.c(paramFile);
    boolean bool2 = l.d(paramFile);
    if (!bool1 || !bool2) {
      String str;
      if (!bool1 && !bool2) {
        str = "write and delete";
      } else if (!bool1) {
        str = "write";
      } else {
        str = "delete";
      } 
      if (stringBuffer1.length() == 0) {
        stringBuffer1.append("zipcreator may not have permission to " + str + " files in the destination directory.\n");
      } else {
        stringBuffer1.append("Check whether zipcreator has permission to " + str + " files in the destination directory.\n");
      } 
    } 
    if (!l.e(paramFile)) {
      for (s s : paramList) {
        String str = paramBoolean2 ? s.h : s.j();
        if (ar.b(str)) {
          arrayList.remove(s);
          b2++;
          stringBuffer3.append("    " + str + "\n");
        } 
      } 
      if (b2 > 0) {
        if (stringBuffer1.length() == 0) {
          stringBuffer1.append("Your file system does not support unicode characters in file names.\n");
        } else {
          stringBuffer1.append("Your file system does not appear to support unicode characters in file names.\n");
        } 
        if (b2 == 1) {
          stringBuffer1.append("The following entry may not extract successfully to your file system.\n");
          stringBuffer1.append(stringBuffer3.toString());
        } else if (b2 <= 4) {
          stringBuffer1.append("The following entries may not extract successfully to your file system.\n");
          stringBuffer1.append(stringBuffer3.toString());
        } else {
          stringBuffer1.append("There are " + b2 + " entries containing unicode characters. These may not extract\n");
          stringBuffer1.append("successfully to your file system.\n");
        } 
      } 
    } 
    if (!l.a(paramFile)) {
      TreeSet treeSet = new TreeSet();
      for (s s : paramList) {
        String str1 = paramBoolean2 ? s.h : s.j();
        String str2 = str1.toLowerCase();
        if (str2.endsWith("/"))
          str2 = str2.substring(0, str2.length() - 1); 
        treeSet.add(str2);
      } 
      if (treeSet.size() < paramList.size()) {
        String[] arrayOfString = (String[])treeSet.toArray((Object[])new String[treeSet.size()]);
        int[] arrayOfInt = new int[arrayOfString.length];
        byte b;
        for (b = 0; b < arrayOfInt.length; b++)
          arrayOfInt[b] = 0; 
        for (s s : paramList) {
          String str1 = paramBoolean2 ? s.h : s.j();
          String str2 = str1;
          if (str2.endsWith("/"))
            str2 = str2.substring(0, str2.length() - 1); 
          for (byte b4 = 0; b4 < arrayOfString.length; b4++) {
            if (str2.equalsIgnoreCase(arrayOfString[b4]) && !str2.equals(arrayOfString[b4]))
              arrayOfInt[b4] = arrayOfInt[b4] + 1; 
          } 
        } 
        treeSet.clear();
        for (b = 0; b < arrayOfInt.length; b++) {
          if (arrayOfInt[b] > 1)
            for (s s : paramList) {
              String str1 = paramBoolean2 ? s.h : s.j();
              String str2 = str1;
              if (str2.endsWith("/"))
                str2 = str2.substring(0, str2.length() - 1); 
              if (arrayOfString[b].equalsIgnoreCase(str2)) {
                arrayList.remove(s);
                treeSet.add(str1);
              } 
            }  
        } 
        if (!treeSet.isEmpty()) {
          for (String str : treeSet) {
            b3++;
            stringBuffer4.append("    " + str + "\n");
          } 
          stringBuffer1.append("Your file system does not support case sensitive file names.\n");
          if (b3 > 0)
            if (b3 <= 6) {
              stringBuffer1.append("It is unlikely that the following entries will extract correctly.\n");
              stringBuffer1.append(stringBuffer4.toString());
            } else {
              stringBuffer1.append("There are " + b3 + " similar entries when compared case insentively.\n");
              stringBuffer1.append("It is unlikely that these entries will all extract correctly.\n");
            }  
        } 
      } 
    } 
    if (stringBuffer1.length() == 0) {
      bool = true;
    } else if (paramBoolean1) {
      String str = "Drag operation cancelled";
      if ((b1 == 0 && b2 == 0 && b3 == 0) || arrayList.size() == 0) {
        aw.b(str, stringBuffer1.toString().trim());
      } else {
        boolean bool3 = (b1 + b2 + b3 == 1) ? true : false;
        if (bool3) {
          stringBuffer1.append("Would you like this entry to be deselected?");
        } else {
          stringBuffer1.append("Would you like these entries to be deselected?");
        } 
        boolean bool4 = aw.c("Drag operation cancelled", stringBuffer1.toString());
        if (bool4) {
          paramList.clear();
          paramList.addAll(arrayList);
          at.a(arrayList);
        } 
      } 
      bool = false;
    } else {
      String str = "Confirm extract to '" + ar.c(paramFile) + "'";
      if ((b1 == 0 && b2 == 0 && b3 == 0) || arrayList.size() == 0) {
        stringBuffer1.append("Do you want to continue?");
        bool = aw.c(str, stringBuffer1.toString());
      } else {
        stringBuffer1.append("If you want to continue, you can choose to extract only the entries known\n");
        stringBuffer1.append("to be compatible with your file system.\n");
        int i = aw.a(str, stringBuffer1.toString());
        if (i == 1) {
          paramList.clear();
          paramList.addAll(arrayList);
          at.a(arrayList);
          bool = true;
        } else if (i == 2) {
          bool = true;
        } else {
          bool = false;
        } 
      } 
    } 
    return bool;
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\bg.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */