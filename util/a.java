package util;

import gui.be;
import gui.bf;
import gui.bk;
import java.awt.AWTPermission;
import java.io.File;
import java.io.FilePermission;
import java.net.URL;
import java.util.ArrayList;
import java.util.PropertyPermission;
import javax.swing.JOptionPane;

public abstract class a {
  public static final boolean c;
  
  private static int b = 1;
  
  private static boolean e = false;
  
  private static boolean a = false;
  
  private static File f = null;
  
  static Class d;
  
  public static final void a(String[] paramArrayOfString) {
    f.e();
    d();
    a();
    f();
    paramArrayOfString = b(paramArrayOfString);
    int i = a(paramArrayOfString, 0);
    be.g();
    be.a("Starting");
    be.b();
    f.f();
    e();
    b(paramArrayOfString, i);
    bh.a();
    ai.b();
    am.a();
    f.a();
    be.a(false);
  }
  
  private static final void e() {
    if (c)
      ai.f = false; 
    if (c) {
      am.e = false;
      am.d = false;
      am.a = false;
    } 
  }
  
  public static final void b() {
    switch (b) {
      case 1:
        g();
        break;
      case 2:
        e = true;
        break;
    } 
  }
  
  public static final void h() {
    a(false);
  }
  
  public static final void a(boolean paramBoolean) {
    if (b == 1)
      b = 2; 
    a = paramBoolean;
  }
  
  public static final boolean c() {
    return (b == 2 && e);
  }
  
  public static final void i() {
    if (b == 2 && e) {
      g();
    } else if (b == 2) {
      b = 1;
    } 
  }
  
  private static final void g() {
    b = 0;
    boolean bool = bd.a(a);
    if (!bool)
      b = 1; 
  }
  
  private static final String[] b(String[] paramArrayOfString) {
    if (paramArrayOfString == null || paramArrayOfString.length == 0)
      return null; 
    ArrayList arrayList = new ArrayList();
    for (byte b = 0; b < paramArrayOfString.length; b++) {
      String str = paramArrayOfString[b].trim();
      if (str.startsWith("\""))
        str = str.substring(1); 
      if (str.endsWith("\""))
        str = str.substring(0, str.length() - 1); 
      if (str.length() > 0)
        arrayList.add(str); 
    } 
    return arrayList.<String>toArray(new String[arrayList.size()]);
  }
  
  private static final int a(String[] paramArrayOfString, int paramInt) {
    if (paramArrayOfString == null || paramInt == -1 || paramInt >= paramArrayOfString.length || paramArrayOfString.length == 0)
      return -1; 
    int i = paramInt;
    try {
      if (paramArrayOfString[i].equalsIgnoreCase("-font"))
        if (paramArrayOfString.length > ++i) {
          if (paramArrayOfString[i].equalsIgnoreCase("small")) {
            bf.a(bk.D[0]);
          } else if (!paramArrayOfString[i].equalsIgnoreCase("medium")) {
            if (paramArrayOfString[i].equalsIgnoreCase("large")) {
              bf.a(bk.D[2]);
            } else {
              throw new IllegalStateException("Invalid font size option '" + paramArrayOfString[i] + "'. Specify either small, medium or large.");
            } 
          } 
          i++;
        } else {
          throw new IllegalStateException("The font size option is missing. Specify either small, medium or large.");
        }  
      if (i == paramArrayOfString.length)
        return i; 
      if (paramArrayOfString[i].equalsIgnoreCase("-compression"))
        if (paramArrayOfString.length > ++i) {
          if (paramArrayOfString[i].equalsIgnoreCase("faster")) {
            r.a = 5;
          } else if (!paramArrayOfString[i].equalsIgnoreCase("normal")) {
            if (paramArrayOfString[i].equalsIgnoreCase("stronger")) {
              r.a = 9;
            } else {
              throw new IllegalStateException("Invalid compression setting '" + paramArrayOfString[i] + "'. Specify either faster, normal or stronger.");
            } 
          } 
          i++;
        } else {
          throw new IllegalStateException("The compression mode is missing. Specify either faster, normal or stronger.");
        }  
      if (i == paramArrayOfString.length)
        return i; 
      if (paramArrayOfString[i].equalsIgnoreCase("-norestrict")) {
        ai.f = true;
        ai.c = true;
        ai.g = true;
        am.e = true;
        am.d = true;
        am.a = true;
        i++;
      } 
    } catch (Exception exception) {
      aw.a("Invalid arguments", "Check the arguments you have specified are correct.", exception);
      return -1;
    } 
    return i;
  }
  
  private static final void b(String[] paramArrayOfString, int paramInt) {
    if (paramArrayOfString == null || paramInt == -1 || paramInt >= paramArrayOfString.length || paramArrayOfString.length == 0)
      return; 
    int i = paramInt;
    try {
      if (!paramArrayOfString[i].startsWith("-")) {
        File file = (new File(paramArrayOfString[i])).getAbsoluteFile();
        if (r.b(file)) {
          r.a(file);
          aw.a(file);
        } else {
          return;
        } 
        i++;
      } 
      if (i == paramArrayOfString.length)
        return; 
      if (paramArrayOfString[i].equalsIgnoreCase("-add")) {
        i++;
        ArrayList arrayList = new ArrayList();
        while (i < paramArrayOfString.length && !paramArrayOfString[i].startsWith("-")) {
          File file = (new File(paramArrayOfString[i])).getAbsoluteFile();
          String str1 = file.getName();
          String str2 = ar.h(str1);
          boolean bool1 = false;
          boolean bool2 = false;
          if (str2.length() > 0) {
            String str = str1.substring(0, str1.lastIndexOf('.'));
            if (str.equals("*") || str.equals("**"))
              bool1 = true; 
            if (str.equals("**"))
              bool2 = true; 
          } 
          if (bool1) {
            File file1 = file.getParentFile().getAbsoluteFile();
            if (!file1.isDirectory())
              throw new IllegalStateException("The directory '" + file1.getPath() + "' does not exist."); 
            be.a = ar.e(file1);
            if (!be.a.endsWith("/"))
              be.a += "/"; 
            ar.a(file1, str2, bool2, arrayList);
          } else {
            if (!file.exists())
              throw new IllegalStateException("The file or directory to add '" + paramArrayOfString[i] + "' does not exist."); 
            if (arrayList.contains(file))
              throw new IllegalStateException("Duplicate file or directory specified, '" + paramArrayOfString[i] + "'."); 
            arrayList.add(file);
          } 
          i++;
        } 
        if (arrayList.size() == 0)
          throw new IllegalStateException("Expected some files for adding, but none were specified."); 
        File[] arrayOfFile = arrayList.<File>toArray(new File[arrayList.size()]);
        be.a(arrayOfFile);
        if (i < paramArrayOfString.length) {
          if (paramArrayOfString[i].equalsIgnoreCase("-save")) {
            if (!r.c())
              throw new IllegalStateException("Cannot save because a zip file has not been opened."); 
            r.a();
            i++;
          } else if (paramArrayOfString[i].equalsIgnoreCase("-saveas")) {
            if (paramArrayOfString.length == ++i)
              throw new IllegalStateException("Cannot perform -saveas because a file path has not been specified."); 
            if (paramArrayOfString[i].startsWith("-"))
              throw new IllegalStateException("Expected a file path, not '" + paramArrayOfString[i] + "'."); 
            File file = (new File(paramArrayOfString[i])).getAbsoluteFile();
            r.c(file);
            i++;
          } else {
            throw new IllegalStateException("Expected either the -save or -saveas switch, not '" + paramArrayOfString[i] + "'.");
          } 
          if (paramArrayOfString.length > i && paramArrayOfString[i].equalsIgnoreCase("-exit")) {
            if (paramArrayOfString.length > i + 1)
              aw.b("Ignoring arguments", "One or more arguments were specified after the -exit switch."); 
            b();
          } else if (paramArrayOfString.length > i) {
            throw new IllegalStateException("Expected -exit, not '" + paramArrayOfString[i] + "'.");
          } 
        } 
      } else {
        throw new IllegalStateException("Expected -add, not '" + paramArrayOfString[i] + "'.");
      } 
    } catch (Exception exception) {
      aw.a("Invalid arguments", "Check the arguments you have specified are correct.", exception);
    } 
  }
  
  private static final void d() {
    try {
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append('M');
      stringBuffer.append('E');
      stringBuffer.append('T');
      stringBuffer.append('A');
      stringBuffer.append('-');
      stringBuffer.append('I');
      stringBuffer.append('N');
      stringBuffer.append('F');
      stringBuffer.append('/');
      stringBuffer.append('Z');
      stringBuffer.append('I');
      stringBuffer.append('P');
      stringBuffer.append('C');
      stringBuffer.append('R');
      stringBuffer.append('E');
      stringBuffer.append('A');
      stringBuffer.append('T');
      stringBuffer.append('.');
      stringBuffer.append('D');
      stringBuffer.append('S');
      stringBuffer.append('A');
      URL uRL = ((d == null) ? (d = a("util.a")) : d).getClassLoader().getResource(stringBuffer.toString());
      if (uRL == null)
        throw new IllegalStateException(); 
      stringBuffer = new StringBuffer();
      stringBuffer.append('M');
      stringBuffer.append('E');
      stringBuffer.append('T');
      stringBuffer.append('A');
      stringBuffer.append('-');
      stringBuffer.append('I');
      stringBuffer.append('N');
      stringBuffer.append('F');
      stringBuffer.append('/');
      stringBuffer.append('Z');
      stringBuffer.append('I');
      stringBuffer.append('P');
      stringBuffer.append('C');
      stringBuffer.append('R');
      stringBuffer.append('E');
      stringBuffer.append('A');
      stringBuffer.append('T');
      stringBuffer.append('.');
      stringBuffer.append('S');
      stringBuffer.append('F');
      uRL = ((d == null) ? (d = a("util.a")) : d).getClassLoader().getResource(stringBuffer.toString());
      if (uRL == null)
        throw new IllegalStateException(); 
    } catch (Exception exception) {
      JOptionPane.showMessageDialog(null, "This jar file may have been modified without authorisation.\nThe program will now exit.", "Warning", 2, null);
      System.exit(-1);
    } 
  }
  
  private static final void a() {
    try {
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append('z');
      stringBuffer.append('i');
      stringBuffer.append('p');
      stringBuffer.append('c');
      stringBuffer.append('r');
      stringBuffer.append('e');
      stringBuffer.append('a');
      stringBuffer.append('t');
      stringBuffer.append('o');
      stringBuffer.append('r');
      stringBuffer.append(' ');
      stringBuffer.append('l');
      stringBuffer.append('i');
      stringBuffer.append('c');
      stringBuffer.append('e');
      stringBuffer.append('n');
      stringBuffer.append('s');
      stringBuffer.append('e');
      stringBuffer.append(' ');
      stringBuffer.append('a');
      stringBuffer.append('g');
      stringBuffer.append('r');
      stringBuffer.append('e');
      stringBuffer.append('e');
      stringBuffer.append('m');
      stringBuffer.append('e');
      stringBuffer.append('n');
      stringBuffer.append('t');
      stringBuffer.append('.');
      stringBuffer.append('t');
      stringBuffer.append('x');
      stringBuffer.append('t');
      String str = stringBuffer.toString();
      URL uRL = ((d == null) ? (d = a("util.a")) : d).getClassLoader().getResource(stringBuffer.toString());
      if (uRL == null)
        throw new IllegalStateException(); 
    } catch (Exception exception) {
      System.exit(-1);
    } 
  }
  
  private static final void f() {
    SecurityManager securityManager = System.getSecurityManager();
    if (securityManager == null)
      return; 
    byte b1 = 0;
    byte b2 = 0;
    StringBuffer stringBuffer1 = new StringBuffer();
    boolean bool1 = false;
    boolean bool2 = false;
    try {
      securityManager.checkPermission(new PropertyPermission("os.name", "read"));
    } catch (SecurityException securityException) {
      b1++;
      stringBuffer1.append("    permission java.util.PropertyPermission \"os.name\", \"read\";\n");
    } 
    try {
      securityManager.checkPermission(new PropertyPermission("user.dir", "read"));
    } catch (SecurityException securityException) {
      b1++;
      stringBuffer1.append("    permission java.util.PropertyPermission \"user.dir\", \"read\";\n");
    } 
    try {
      securityManager.checkPermission(new PropertyPermission("user.home", "read"));
      bool1 = true;
    } catch (SecurityException securityException) {
      b1++;
      stringBuffer1.append("    permission java.util.PropertyPermission \"user.home\", \"read\";\n");
    } 
    try {
      securityManager.checkPermission(new PropertyPermission("java.io.tmpdir", "read"));
      bool2 = true;
    } catch (SecurityException securityException) {
      b1++;
      stringBuffer1.append("    permission java.util.PropertyPermission \"java.io.tmpdir\", \"read\";\n");
    } 
    if (bool1) {
      String str = System.getProperty("user.home") + File.separatorChar + "-";
      try {
        securityManager.checkPermission(new FilePermission(str, "read, write"));
      } catch (SecurityException securityException) {
        b1++;
        stringBuffer1.append("    permission java.io.FilePermission \"${user.home}${/}-\", \"read, write\";\n");
      } 
    } 
    if (bool2) {
      String str = System.getProperty("java.io.tmpdir") + File.separatorChar + "-";
      try {
        securityManager.checkPermission(new FilePermission(str, "read, write, delete"));
      } catch (SecurityException securityException) {
        b1++;
        stringBuffer1.append("    permission java.io.FilePermission \"${java.io.tmpdir}${/}-\", \"read, write, delete\";\n");
      } 
    } 
    try {
      securityManager.checkPermission(new AWTPermission("createRobot"));
    } catch (SecurityException securityException) {
      b2++;
      stringBuffer1.append("    permission java.awt.AWTPermission \"createRobot\"; // Optional\n");
    } 
    try {
      securityManager.checkPermission(new AWTPermission("readDisplayPixels"));
    } catch (SecurityException securityException) {
      b2++;
      stringBuffer1.append("    permission java.awt.AWTPermission \"readDisplayPixels\"; // Optional\n");
    } 
    try {
      securityManager.checkPermission(new AWTPermission("accessClipboard"));
    } catch (SecurityException securityException) {
      b2++;
      stringBuffer1.append("    permission java.awt.AWTPermission \"accessClipboard\"; // Optional\n");
      am.e = false;
      am.d = false;
      am.a = false;
    } 
    try {
      securityManager.checkPermission(new AWTPermission("showWindowWithoutWarningBanner"));
    } catch (SecurityException securityException) {
      b2++;
      stringBuffer1.append("    permission java.awt.AWTPermission \"showWindowWithoutWarningBanner\";\n");
    } 
    try {
      securityManager.checkPermission(new AWTPermission("replaceKeyboardFocusManager"));
    } catch (SecurityException securityException) {
      b2++;
      stringBuffer1.append("    permission java.awt.AWTPermission \"replaceKeyboardFocusManager\";\n");
    } 
    if (b1 == 0)
      return; 
    StringBuffer stringBuffer2 = new StringBuffer();
    if (b1 == 1 && b2 == 0) {
      stringBuffer2.append("The following permission has not been granted by the security policy:\n");
      stringBuffer2.append(stringBuffer1.toString());
    } else {
      stringBuffer2.append("The following permissions have not been granted by the security policy:\n");
      stringBuffer2.append(stringBuffer1.toString());
    } 
    stringBuffer2.append("zipcreator cannot function properly until the security policy is changed accordingly.\n");
    stringBuffer2.append("Consult the Java security documentation for more information on how to do this.\n");
    stringBuffer2.append("Note that additional permissions may be needed for file system access, for example:\n");
    stringBuffer2.append("    permission java.io.FilePermission \"path${/}\", \"read, write\";\n");
    stringBuffer2.append("    permission java.io.FilePermission \"path${/}-\", \"read, write, delete\";\n");
    stringBuffer2.append("Alternatively, you can grant access to the whole file system with:\n");
    stringBuffer2.append("    permission java.io.FilePermission \"<<ALL FILES>>\", \"read, write, delete\";\n");
    stringBuffer2.append("The program will now exit.");
    aw.b("Insufficient security permissions", stringBuffer2.toString());
    b();
  }
  
  static Class a(String paramString) {
    try {
      return Class.forName(paramString);
    } catch (ClassNotFoundException classNotFoundException) {
      throw new NoClassDefFoundError(classNotFoundException.getMessage());
    } 
  }
  
  static {
    boolean bool;
    try {
      bool = System.getProperty("os.name").equals("Mac OS X");
    } catch (Exception exception) {
      bool = false;
    } 
    c = bool;
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\a.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */