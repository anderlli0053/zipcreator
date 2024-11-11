package util;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public abstract class l {
  private static Map a = Collections.synchronizedMap(new TreeMap());
  
  public static final void f(File paramFile) throws IOException {
    if (!paramFile.isDirectory())
      throw new IOException("The directory '" + ar.c(paramFile) + "' does not exist or the device is not ready."); 
    if (!a.containsKey(paramFile)) {
      g(paramFile);
    } else if (!i(paramFile) || !c(paramFile) || !d(paramFile)) {
      a.remove(paramFile);
      g(paramFile);
    } 
  }
  
  public static final boolean i(File paramFile) {
    return ((h(paramFile) & 0x1) == 1);
  }
  
  public static final boolean c(File paramFile) {
    return ((h(paramFile) & 0x2) == 2);
  }
  
  public static final boolean d(File paramFile) {
    return ((h(paramFile) & 0x4) == 4);
  }
  
  public static final boolean e(File paramFile) {
    return ((h(paramFile) & 0x8) == 8);
  }
  
  public static final boolean a(File paramFile) {
    return ((h(paramFile) & 0x10) == 16);
  }
  
  private static final int h(File paramFile) {
    try {
      Integer integer = (Integer)a.get(paramFile);
      return integer.intValue();
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  private static final void g(File paramFile) {
    String str1;
    byte b = 0;
    try {
      str1 = b(paramFile);
    } catch (IllegalStateException illegalStateException) {
      return;
    } 
    String str2 = str1.toUpperCase();
    String str3 = str1 + '\u263A';
    File file1 = null;
    File file2 = null;
    File file3 = null;
    try {
      if (paramFile.canRead())
        b++; 
    } catch (Exception exception) {}
    try {
      file1 = new File(paramFile, str1);
      if (!file1.createNewFile()) {
        a(paramFile, b);
        return;
      } 
      b += 2;
    } catch (Exception exception) {
      a(paramFile, b);
      return;
    } 
    try {
      file2 = new File(paramFile, str2);
      if (file2.createNewFile()) {
        b += 16;
        if (!file2.delete())
          file2.deleteOnExit(); 
      } 
    } catch (Exception exception) {}
    try {
      file3 = new File(paramFile, str3);
      if (file3.createNewFile()) {
        b += 8;
        if (!file3.delete())
          file3.deleteOnExit(); 
      } 
    } catch (Exception exception) {}
    try {
      if (!file1.delete()) {
        file1.deleteOnExit();
      } else {
        b += 4;
      } 
    } catch (Exception exception) {}
    a(paramFile, b);
  }
  
  private static final void a(File paramFile, int paramInt) {
    a.put(paramFile, new Integer(paramInt));
  }
  
  private static final String b(File paramFile) throws IllegalStateException, SecurityException {
    int i = ".zc_".length();
    String[] arrayOfString = paramFile.list(new h(i));
    for (byte b = 1; b < '\u2710'; b++) {
      String str1 = ".zc_" + b;
      String str2 = str1 + '\u263A';
      boolean bool = true;
      for (byte b1 = 0; b1 < arrayOfString.length; b1++) {
        if (arrayOfString[b1].equalsIgnoreCase(str1) || arrayOfString[b1].equalsIgnoreCase(str2)) {
          bool = false;
          break;
        } 
      } 
      if (bool)
        return str1; 
    } 
    throw new IllegalStateException();
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\l.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */