package util;

import javax.swing.Icon;

public abstract class ah {
  private static final Icon c = f.c("file.png");
  
  private static final Icon h = f.c("zip_file.png");
  
  private static final Icon d = f.c("jar_file.png");
  
  private static final Icon b = f.c("web_file.png");
  
  private static final Icon o = f.c("pdf_file.png");
  
  private static final Icon l = f.c("text_file.png");
  
  private static final Icon m = f.c("office_file.png");
  
  private static final Icon n = f.c("sound_file.png");
  
  private static final Icon a = f.c("image_file.png");
  
  private static final Icon e = f.c("movie_file.png");
  
  private static final Icon s = f.c("file_d.png");
  
  private static final Icon g = f.c("zip_file_d.png");
  
  private static final Icon i = f.c("jar_file_d.png");
  
  private static final Icon t = f.c("web_file_d.png");
  
  private static final Icon p = f.c("pdf_file_d.png");
  
  private static final Icon q = f.c("text_file_d.png");
  
  private static final Icon f = f.c("office_file_d.png");
  
  private static final Icon r = f.c("sound_file_d.png");
  
  private static final Icon k = f.c("image_file_d.png");
  
  private static final Icon j = f.c("movie_file_d.png");
  
  public static final int a(String paramString) {
    String str = (new String(paramString)).toLowerCase();
    return str.equals("zip") ? 1 : ((str.equals("jar") || str.equals("war")) ? 2 : ((str.equals("htm") || str.equals("html") || str.equals("xhtml") || str.equals("php") || str.equals("asp") || str.equals("jsp") || str.equals("cfm")) ? 10 : (str.equals("pdf") ? 20 : ((str.equals("txt") || str.equals("ini")) ? 30 : ((str.equals("doc") || str.equals("xls") || str.equals("ppt") || str.equals("mdb") || str.equals("wri") || str.equals("rtf") || str.equals("sxw") || str.equals("sxc") || str.equals("sxi") || str.equals("sxd") || str.equals("sxg") || str.equals("cwk")) ? 40 : ((str.equals("wav") || str.equals("aif") || str.equals("aiff") || str.equals("au") || str.equals("mp3") || str.equals("wma")) ? 50 : ((str.equals("png") || str.equals("gif") || str.equals("jpg") || str.equals("jpeg") || str.equals("tif") || str.equals("tiff") || str.equals("bmp") || str.equals("raw") || str.equals("tga") || str.equals("psd") || str.equals("ai") || str.equals("rif") || str.equals("pic") || str.equals("pct")) ? 60 : ((str.equals("mov") || str.equals("avi") || str.equals("wmv") || str.equals("qt") || str.equals("mpg") || str.equals("mpeg")) ? 70 : 0))))))));
  }
  
  public static final boolean c(String paramString) {
    return (a(paramString) != 0);
  }
  
  public static final Icon b(int paramInt) {
    switch (paramInt) {
      case 1:
        return h;
      case 2:
        return d;
      case 10:
        return b;
      case 20:
        return o;
      case 30:
        return l;
      case 40:
        return m;
      case 50:
        return n;
      case 60:
        return a;
      case 70:
        return e;
    } 
    return c;
  }
  
  public static final Icon a(int paramInt) {
    switch (paramInt) {
      case 1:
        return g;
      case 2:
        return i;
      case 10:
        return t;
      case 20:
        return p;
      case 30:
        return q;
      case 40:
        return f;
      case 50:
        return r;
      case 60:
        return k;
      case 70:
        return j;
    } 
    return s;
  }
  
  public static final String b(String paramString) {
    return (paramString == null || paramString.length() < 1) ? null : (paramString.toUpperCase() + " File");
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\ah.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */