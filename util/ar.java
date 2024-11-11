package util;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import model.a;
import model.s;

public abstract class ar {
  public static final String h(String paramString) {
    int i = paramString.lastIndexOf('.');
    return (i >= 0 && i < paramString.length() - 1) ? paramString.substring(i + 1) : "";
  }
  
  public static final void a(File paramFile, String paramString, boolean paramBoolean, List paramList) {
    if (!paramFile.isDirectory())
      return; 
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
      return; 
    for (byte b = 0; b < arrayOfFile.length; b++) {
      if (paramBoolean && arrayOfFile[b].isDirectory()) {
        a(arrayOfFile[b], paramString, paramBoolean, paramList);
      } else if (arrayOfFile[b].isFile() && paramString.equalsIgnoreCase(h(arrayOfFile[b].getName()))) {
        paramList.add(arrayOfFile[b]);
      } 
    } 
  }
  
  public static final boolean a() {
    return (File.separatorChar == '\\');
  }
  
  public static final boolean g(String paramString) {
    for (byte b = 0; b < paramString.length(); b++) {
      char c = paramString.charAt(b);
      if (c == '\\' || c == ':' || c == '*' || c == '?' || c == '"' || c == '<' || c == '>' || c == '|')
        return false; 
    } 
    return true;
  }
  
  public static final boolean b(String paramString) {
    for (byte b = 0; b < paramString.length(); b++) {
      char c = paramString.charAt(b);
      char c1 = c;
      if (c1 >= '\u0100')
        return true; 
    } 
    return false;
  }
  
  public static final String d(File paramFile) {
    try {
      if (!paramFile.isAbsolute())
        paramFile = paramFile.getAbsoluteFile(); 
    } catch (Exception exception) {}
    try {
      return paramFile.getCanonicalPath();
    } catch (Exception exception) {
      try {
        return paramFile.getAbsolutePath();
      } catch (Exception exception1) {
        return paramFile.getPath();
      } 
    } 
  }
  
  public static final String c(File paramFile) {
    try {
      if (!paramFile.isAbsolute())
        paramFile = paramFile.getAbsoluteFile(); 
    } catch (Exception exception) {}
    try {
      return paramFile.getCanonicalFile().getName();
    } catch (Exception exception) {
      try {
        return paramFile.getAbsoluteFile().getName();
      } catch (Exception exception1) {
        return paramFile.getName();
      } 
    } 
  }
  
  public static final String e(File paramFile) {
    return (paramFile == null) ? null : ((File.separatorChar == '\\') ? f(paramFile.getPath()) : paramFile.getPath());
  }
  
  public static final String k(String paramString) {
    return (paramString == null) ? null : ((File.separatorChar == '\\') ? f(paramString) : paramString);
  }
  
  public static final boolean i(String paramString) {
    return (paramString.indexOf("\\") >= 0);
  }
  
  public static final String f(String paramString) {
    String str = paramString.replace('\\', '/');
    StringBuffer stringBuffer = new StringBuffer();
    boolean bool = true;
    for (byte b = 0; b < str.length(); b++) {
      char c = str.charAt(b);
      if (c == '/') {
        if (!bool) {
          stringBuffer.append(c);
          bool = true;
        } 
      } else {
        stringBuffer.append(c);
        bool = false;
      } 
    } 
    return stringBuffer.toString();
  }
  
  public static final boolean e(String paramString) {
    if (paramString.length() < 1)
      return false; 
    if (paramString.charAt(0) == ' ')
      return false; 
    char c = paramString.charAt(paramString.length() - 1);
    if (c == ' ' || c == '.')
      return false; 
    for (byte b = 0; b < paramString.length(); b++) {
      c = paramString.charAt(b);
      char c1 = c;
      if (c == '/')
        return false; 
    } 
    return true;
  }
  
  public static final boolean a(String paramString) {
    return paramString.endsWith("/") ? e(paramString.substring(0, paramString.length() - 1)) : e(paramString);
  }
  
  public static final String j(String paramString) {
    StringBuffer stringBuffer = new StringBuffer();
    for (byte b = 0; b < paramString.length(); b++) {
      char c = paramString.charAt(b);
      if (Character.isWhitespace(c)) {
        stringBuffer.append(" ");
      } else {
        stringBuffer.append(c);
      } 
    } 
    return stringBuffer.toString();
  }
  
  public static final boolean d(String paramString) {
    if (paramString.startsWith("/"))
      return false; 
    if (paramString.indexOf("//") > -1)
      return false; 
    StringTokenizer stringTokenizer = new StringTokenizer(paramString, "/");
    while (stringTokenizer.hasMoreTokens()) {
      String str = stringTokenizer.nextToken();
      if (!e(str))
        return false; 
    } 
    return true;
  }
  
  public static final String b() {
    try {
      List list = at.a();
      Iterator iterator = list.iterator();
      s s = iterator.next();
      String str = (s instanceof model.l) ? s.h : s.d();
      while (iterator.hasNext()) {
        s = iterator.next();
        str = a(str, (s instanceof model.l) ? s.h : s.d());
        if (str.length() == 0)
          break; 
      } 
      return str;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static final String a(String paramString1, String paramString2) {
    if (paramString1.equals(paramString2))
      return paramString1; 
    StringTokenizer stringTokenizer1 = new StringTokenizer(paramString1, "/");
    StringTokenizer stringTokenizer2 = new StringTokenizer(paramString2, "/");
    String str = "";
    while (stringTokenizer1.hasMoreTokens() && stringTokenizer2.hasMoreTokens()) {
      String str1 = stringTokenizer1.nextToken();
      if (str1.equals(stringTokenizer2.nextToken()))
        str = str + str1 + "/"; 
    } 
    return str;
  }
  
  public static final String c(String paramString) {
    if (paramString == null)
      return ""; 
    if (!paramString.endsWith("/"))
      return paramString.substring(0, paramString.lastIndexOf("/") + 1); 
    String str = paramString.substring(0, paramString.length() - 1);
    return str.substring(0, str.lastIndexOf("/") + 1);
  }
  
  public static final void a(List paramList) {
    Collections.sort(paramList, (Comparator)a.d);
  }
  
  public static final void b(List paramList) {
    Collections.sort(paramList, be.d.b());
  }
  
  public static final File f(File paramFile) {
    File[] arrayOfFile = paramFile.listFiles();
    byte b;
    for (b = 0; b < arrayOfFile.length; b++) {
      if (!arrayOfFile[b].isDirectory())
        return arrayOfFile[b]; 
    } 
    for (b = 0; b < arrayOfFile.length; b++) {
      if (arrayOfFile[b].isDirectory()) {
        File file = f(arrayOfFile[b]);
        if (file != null)
          return file; 
      } 
    } 
    return null;
  }
  
  public static final boolean a(File paramFile) {
    try {
      return b(paramFile);
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static final boolean b(File paramFile) throws IOException {
    if (!paramFile.exists())
      return false; 
    if (paramFile.isDirectory()) {
      File[] arrayOfFile = paramFile.listFiles();
      boolean bool = true;
      for (byte b = 0; bool && b < arrayOfFile.length; b++)
        bool = b(arrayOfFile[b]); 
      if (bool)
        paramFile.delete(); 
      return bool;
    } 
    return paramFile.delete();
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\ar.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */