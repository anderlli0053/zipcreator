package util;

import java.io.File;

public abstract class ba {
  private static File a = null;
  
  private static File b = null;
  
  public static final File d() {
    if (b == null)
      b = a(c(), "zipcreator"); 
    return b;
  }
  
  private static final File c() {
    if (a == null)
      a = new File(System.getProperty("java.io.tmpdir")); 
    return a;
  }
  
  public static final File a(File paramFile, String paramString) {
    byte b = 1;
    File file = null;
    while (file == null) {
      String str = (b == 1) ? paramString : (paramString + b);
      file = new File(paramFile, str);
      if (file.exists()) {
        file = null;
        b++;
      } 
    } 
    file.mkdirs();
    return file;
  }
  
  public static final void a() {
    if (b != null)
      ar.a(b); 
    b();
  }
  
  private static final void b() {
    long l1 = 604800000L;
    long l2 = System.currentTimeMillis() - l1;
    File[] arrayOfFile = c().listFiles();
    for (byte b = 0; b < arrayOfFile.length; b++) {
      if (arrayOfFile[b].isDirectory() && arrayOfFile[b].getName().startsWith("zipcreator")) {
        File file = arrayOfFile[b];
        long l = file.lastModified();
        if (l > 0L && l < l2)
          ar.a(file); 
      } 
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\ba.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */