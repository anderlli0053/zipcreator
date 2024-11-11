package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import model.e;
import model.h;
import model.k;
import model.l;
import model.m;
import model.s;

public abstract class r {
  public static int a = 7;
  
  private static File d = null;
  
  private static String f = null;
  
  private static String c = null;
  
  private static String e = null;
  
  private static File b = null;
  
  public static final boolean c() {
    return (d != null);
  }
  
  public static final String f() {
    return f;
  }
  
  public static final String e() {
    return c;
  }
  
  private static final void d(File paramFile) {
    d = paramFile;
    if (paramFile == null) {
      f = "";
      c = "";
      e = "";
    } else {
      f = a(ar.d(paramFile));
      c = ar.c(paramFile);
      e = ar.d(paramFile.getParentFile());
    } 
  }
  
  private static final String a(String paramString) {
    String str = paramString.substring(paramString.lastIndexOf(File.separator) + 1);
    int i = Math.max(16, 50 - str.length());
    StringTokenizer stringTokenizer = new StringTokenizer(paramString, File.separator, true);
    boolean bool = false;
    StringBuffer stringBuffer = new StringBuffer();
    while (stringTokenizer.hasMoreTokens()) {
      String str1 = stringTokenizer.nextToken();
      if (!stringTokenizer.hasMoreTokens()) {
        stringBuffer.append(str1);
        continue;
      } 
      if (str1.equals(File.separator)) {
        stringBuffer.append(str1);
        continue;
      } 
      if (bool) {
        stringBuffer.append("...");
        continue;
      } 
      int j = stringBuffer.length() + str1.length();
      if (j >= i) {
        bool = true;
        stringBuffer.append("...");
        continue;
      } 
      stringBuffer.append(str1);
    } 
    return stringBuffer.toString();
  }
  
  public static final void d() {
    d(null);
    be.a = null;
    be.b = false;
    at.e();
    be.d.f();
    f.b();
  }
  
  public static final boolean b(File paramFile) {
    if (!paramFile.exists() || paramFile.isDirectory()) {
      aw.b("Cannot open file", "The following file is not valid:\n    " + ar.d(paramFile));
      return false;
    } 
    return true;
  }
  
  public static final void a(File paramFile) {
    d(paramFile);
    be.b = false;
    be.a = null;
    at.e();
    be.d.f();
    f.a(true);
    f.a("Opening");
    a.h();
    n.p();
    boolean bool = true;
    byte b = 0;
    StringBuffer stringBuffer = new StringBuffer();
    try {
      aq.a("Opening");
      aq.a = paramFile.length();
      at.f.setValueIsAdjusting(true);
      ZipFile zipFile = new ZipFile(paramFile);
      boolean bool1 = (zipFile.size() <= 28) ? true : false;
      ArrayList arrayList = new ArrayList();
      m m = new m();
      Enumeration enumeration = zipFile.entries();
      while (enumeration.hasMoreElements()) {
        e e;
        ZipEntry zipEntry1 = enumeration.nextElement();
        ZipEntry zipEntry2 = zipFile.getEntry(zipEntry1.getName());
        if (zipEntry2 == null) {
          b++;
          stringBuffer.append("    " + zipEntry1.getName() + "\n");
          aq.e += (zipEntry1.getMethod() == 0) ? zipEntry1.getSize() : zipEntry1.getCompressedSize();
          aq.a();
          continue;
        } 
        boolean bool2 = zipEntry1.isDirectory();
        if (bool2) {
          l l = new l();
        } else {
          e = new e();
        } 
        ((s)e).h = zipEntry1.getName();
        String str = ((s)e).h.trim();
        if (str.startsWith("/"))
          str = str.substring(1).trim(); 
        if (bool2 && !str.endsWith("/")) {
          str = str + "/";
        } else if (!bool2 && str.endsWith("/")) {
          str = str + str.substring(0, str.length() - 1).trim();
        } 
        ((s)e).h = str;
        if (((s)e).h.length() == 0 || ((s)e).h.equals("/"))
          continue; 
        ((s)e).a = zipEntry1.getTime();
        if (e instanceof e) {
          e e1 = e;
          e1.g = (zipEntry1.getMethod() == 0);
          k k = new k();
          k.b = paramFile;
          k.d = zipEntry1.getName();
          k.e = (zipEntry1.getMethod() == 0);
          k.a = zipEntry1.getSize();
          k.c = zipEntry1.getCompressedSize();
          e1.j = (h)k;
          aq.e += k.e ? k.a : k.c;
          aq.a();
        } 
        if (bool1) {
          be.d.b((s)e);
        } else {
          arrayList.add(e);
          m.b((s)e);
        } 
        if (a.c() || n.r()) {
          bool = false;
          break;
        } 
      } 
      zipFile.close();
      if (!bool1) {
        be.d.a(arrayList);
        be.d.a = m;
      } else {
        arrayList.clear();
        m.a();
      } 
      at.f.setValueIsAdjusting(false);
      if (bool) {
        f.a("Opening");
        if (b > 0) {
          String str;
          StringBuffer stringBuffer1 = new StringBuffer();
          if (b == 1) {
            str = "Invalid entry name";
            stringBuffer1.append("The following entry name is not valid:\n");
            stringBuffer1.append(stringBuffer.toString());
            stringBuffer1.append("This entry has been omitted from the list.");
          } else if (b <= 10) {
            str = "Invalid entry names";
            stringBuffer1.append("The following " + b + " entry names are not valid:\n");
            stringBuffer1.append(stringBuffer.toString());
            stringBuffer1.append("These entries have been omitted from the list.");
          } else {
            str = "Invalid entry names";
            stringBuffer1.append("There are " + b + " invalid entry names.\n");
            stringBuffer1.append("These entries have been omitted from the list.");
          } 
          aw.b(str, stringBuffer1.toString());
        } else if (be.d.getSize() == 0) {
          aw.b("Empty zip file", "No entries were found in the file:\n    " + ar.d(paramFile));
          bool = false;
        } 
        if (be.d.getSize() > 0)
          be.a(); 
      } 
    } catch (Exception exception) {
      aw.a("Cannot open file", "An error occurred while opening the file:\n    " + ar.d(paramFile), exception);
      bool = false;
    } 
    if (!bool) {
      d(null);
      be.b = false;
      if (be.d.getSize() > 0)
        be.d.f(); 
      if (at.f.getValueIsAdjusting())
        at.f.setValueIsAdjusting(false); 
    } 
    a.i();
    f.b();
    f.a(false);
  }
  
  public static final void a() {
    if (d != null)
      c(d); 
  }
  
  public static final void c(File paramFile) {
    if (paramFile.isDirectory()) {
      aw.d("Cannot save file", "The following file is not valid:\n    " + ar.d(paramFile) + "\nThe destination must be a file, not a directory.");
      return;
    } 
    if (paramFile.exists() && !paramFile.canWrite()) {
      aw.d("Cannot save file", "The following file may be marked as read only:\n    " + ar.d(paramFile));
      return;
    } 
    f.a(true);
    boolean bool1 = ar.h(paramFile.getName()).equalsIgnoreCase("jar");
    boolean bool2 = be.a(bool1);
    if (!bool2) {
      f.a(false);
      return;
    } 
    int i = be.d.getSize();
    char c = '\uFFFE';
    if (i > c) {
      int j = i - c;
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append("Due to the large number of entries the save operation may not be successful.\n");
      stringBuffer.append("Try removing at least " + ((j == 1) ? "one entry" : (j + " entries")) + " from the list.\n");
      stringBuffer.append("Do you want to proceed anyway?\n");
      bool2 = aw.c("Too many entries", stringBuffer.toString());
      if (!bool2) {
        f.a(false);
        return;
      } 
    } 
    f.a("Saving");
    a.a(true);
    n.p();
    File file1 = d;
    d(paramFile);
    File file2 = null;
    boolean bool3 = be.b;
    String str = be.a;
    be.b = false;
    be.a = null;
    boolean bool4 = true;
    boolean bool5 = false;
    byte b = 1;
    try {
      file2 = File.createTempFile("zip", null, b());
      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
      ZipOutputStream zipOutputStream = new ZipOutputStream(bufferedOutputStream);
      zipOutputStream.setMethod(8);
      zipOutputStream.setLevel(a);
      List list = be.d.a();
      if (be.d.e() != 1)
        ar.a(list); 
      aq.a("Saving");
      aq.a(list);
      a(list, zipOutputStream);
      list.clear();
      zipOutputStream.close();
      bufferedOutputStream.flush();
      bufferedOutputStream.close();
      if (a.c() || n.r()) {
        d(file1);
        be.b = bool3;
        be.a = str;
        a.i();
        f.b();
        f.a(false);
        return;
      } 
      b = 2;
      aq.a("Copying to destination");
      aq.a = file2.length();
      if (paramFile.exists())
        paramFile.delete(); 
      f.a("Copying to destination");
      paramFile.createNewFile();
      bool5 = true;
      bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramFile));
      BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
      int j = 65536;
      byte[] arrayOfByte = new byte[j];
      while (true) {
        int k = bufferedInputStream.available();
        if (k <= 0)
          break; 
        int m = (k < j) ? k : j;
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
      bool5 = false;
      bufferedOutputStream.close();
      bufferedInputStream.close();
      if (a.c() || n.r()) {
        d(file1);
        be.b = bool3;
        be.a = str;
        a.i();
        f.b();
        f.a(false);
        return;
      } 
      b = 3;
      f.a("Reloading entries");
      aq.a("Reloading entries");
      aq.a = paramFile.length();
      a(file2, paramFile);
    } catch (IOException iOException) {
      StringBuffer stringBuffer1;
      StringBuffer stringBuffer2;
      long l;
      switch (b) {
        case 1:
          aw.a("Cannot save file", "An error occurred while saving the file.", iOException);
          break;
        case 2:
          stringBuffer1 = new StringBuffer();
          stringBuffer1.append("An error occurred while copying the file to the destination:\n");
          stringBuffer1.append("    " + ar.d(paramFile));
          stringBuffer2 = new StringBuffer();
          stringBuffer2.append("You may want to copy the saved file from the location below.\n");
          stringBuffer2.append("This file will be deleted when you exit zipcreator.\n");
          stringBuffer2.append("    " + ar.d(file2));
          bool4 = false;
          if (bool5) {
            System.gc();
            ar.a(paramFile);
          } 
          aw.a("Error copying to destination", stringBuffer1.toString(), iOException, stringBuffer2.toString());
          break;
        case 3:
          bool3 = false;
          stringBuffer1 = new StringBuffer();
          l = 2147483648L;
          if (paramFile.exists() && paramFile.length() >= l) {
            stringBuffer1.append("The file was written, but the entries could not be reloaded properly.\n");
            stringBuffer1.append("This is because the file exceeds the 2 GB limit for zip files.\n");
            stringBuffer1.append("Try removing some entries before saving the file again.\n");
            stringBuffer1.append("    " + ar.d(paramFile));
          } else {
            stringBuffer1.append("The file has been saved, but the entries have not been updated properly.\n");
            stringBuffer1.append("Try opening the file again:\n");
            stringBuffer1.append("    " + ar.d(paramFile));
          } 
          aw.a("Error reloading entries", stringBuffer1.toString(), iOException);
          break;
      } 
      d(file1);
      be.b = bool3;
      be.a = str;
    } 
    if (bool4 && file2 != null && file2.exists())
      file2.delete(); 
    a.i();
    f.b();
    f.a(false);
  }
  
  private static final File b() {
    if (b == null) {
      b = new File(ba.d(), "saving");
      b.mkdirs();
    } 
    return b;
  }
  
  private static final void a(File paramFile1, File paramFile2) throws IOException {
    ArrayList arrayList = new ArrayList();
    ZipFile zipFile = new ZipFile(paramFile1);
    Enumeration enumeration = zipFile.entries();
    while (enumeration.hasMoreElements()) {
      e e;
      ZipEntry zipEntry = enumeration.nextElement();
      if (zipEntry.isDirectory()) {
        l l = new l();
      } else {
        e = new e();
      } 
      ((s)e).h = zipEntry.getName();
      ((s)e).a = zipEntry.getTime();
      if (e instanceof e) {
        e e1 = e;
        e1.g = (zipEntry.getMethod() == 0);
        k k = new k();
        k.b = paramFile2;
        k.d = zipEntry.getName();
        k.e = (zipEntry.getMethod() == 0);
        k.a = zipEntry.getSize();
        k.c = zipEntry.getCompressedSize();
        e1.j = (h)k;
        aq.e += k.e ? k.a : k.c;
        aq.a();
      } 
      arrayList.add(e);
    } 
    zipFile.close();
    be.d.a(arrayList);
    arrayList.clear();
  }
  
  private static final void a(List paramList, ZipOutputStream paramZipOutputStream) throws IOException {
    HashMap hashMap = new HashMap();
    CRC32 cRC32 = new CRC32();
    for (s s : paramList) {
      ZipEntry zipEntry = new ZipEntry(s.h);
      zipEntry.setTime(s.a);
      if (s instanceof l) {
        paramZipOutputStream.putNextEntry(zipEntry);
      } else {
        e e = (e)s;
        if (!e.j.b.exists())
          throw new IOException("The source file for '" + s.j() + "' does not exist:\n" + "    " + ar.d(e.j.b)); 
        zipEntry.setMethod(e.g ? 0 : 8);
        if (e.j instanceof model.r) {
          if (e.g) {
            BufferedInputStream bufferedInputStream1 = new BufferedInputStream(new FileInputStream(e.j.b));
            a(zipEntry, bufferedInputStream1, cRC32);
          } 
          paramZipOutputStream.putNextEntry(zipEntry);
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
              paramZipOutputStream.write(arrayOfByte, 0, m);
              aq.e += m;
              aq.a();
            } 
          } 
          bufferedInputStream.close();
        } else {
          ZipFile zipFile;
          k k = (k)e.j;
          if (hashMap.containsKey(k.b)) {
            zipFile = (ZipFile)hashMap.get(k.b);
          } else {
            zipFile = new ZipFile(k.b);
            hashMap.put(k.b, zipFile);
          } 
          ZipEntry zipEntry1 = zipFile.getEntry(k.d);
          if (zipEntry1 == null)
            throw new IOException("Cannot find entry '" + k.d + "' in the zip file:\n" + "    " + ar.d(k.b)); 
          if (e.g) {
            BufferedInputStream bufferedInputStream1 = new BufferedInputStream(zipFile.getInputStream(zipEntry1));
            a(zipEntry, bufferedInputStream1, cRC32);
          } 
          paramZipOutputStream.putNextEntry(zipEntry);
          BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry1));
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
              paramZipOutputStream.write(arrayOfByte, 0, n);
              aq.e += n;
              aq.a();
            } 
          } 
          bufferedInputStream.close();
        } 
      } 
      paramZipOutputStream.closeEntry();
      if (a.c() || n.r())
        break; 
    } 
    a(hashMap.values());
    hashMap.clear();
  }
  
  public static final void a(Collection paramCollection) {
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      try {
        ((ZipFile)iterator.next()).close();
      } catch (Exception exception) {}
    } 
  }
  
  private static final void a(ZipEntry paramZipEntry, BufferedInputStream paramBufferedInputStream, Checksum paramChecksum) throws IOException {
    long l = 0L;
    int i = 65536;
    byte[] arrayOfByte = new byte[i];
    while (true) {
      int j = paramBufferedInputStream.available();
      if (j <= 0)
        break; 
      int k = (j < i) ? j : i;
      int m = paramBufferedInputStream.read(arrayOfByte, 0, k);
      if (m == -1)
        break; 
      if (m > 0) {
        paramChecksum.update(arrayOfByte, 0, m);
        l += m;
      } 
    } 
    paramZipEntry.setSize(l);
    paramZipEntry.setCompressedSize(l);
    paramZipEntry.setCrc(paramChecksum.getValue());
    paramBufferedInputStream.close();
    paramChecksum.reset();
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\r.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */