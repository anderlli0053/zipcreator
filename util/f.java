package util;

import gui.at;
import gui.av;
import gui.be;
import gui.bf;
import gui.o;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.net.URL;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;

public abstract class f {
  public static final Image i;
  
  public static final Image a;
  
  public static o c = null;
  
  private static final String d;
  
  private static av h;
  
  private static av f;
  
  private static av b;
  
  private static boolean g;
  
  static Class e;
  
  public static final void e() {
    MetalLookAndFeel.setCurrentTheme((MetalTheme)new bf());
    try {
      UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
      return;
    } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
      aw.a("Metal Look & Feel not supported on this platform.");
    } catch (IllegalAccessException illegalAccessException) {
      aw.a("Metal Look & Feel could not be accessed.");
    } catch (ClassNotFoundException classNotFoundException) {
      aw.a("Metal Look & Feel could not found.");
    } catch (InstantiationException instantiationException) {
      aw.a("Metal Look & Feel could not be instantiated.");
    } catch (Exception exception) {
      aw.b("Unexpected error.", exception);
    } 
    a.b();
  }
  
  public static final void f() {
    c = new o();
  }
  
  public static final void a() {
    a((Window)c);
    c.setVisible(true);
    c.toFront();
    c.s();
  }
  
  public static final void d() {
    if (c != null)
      c.setVisible(false); 
  }
  
  public static final void a(int paramInt) {
    if (paramInt < 8 || paramInt > 14)
      return; 
    bf.a(paramInt);
    if (h == null)
      h = new al(); 
    h.a();
  }
  
  public static final void a(boolean paramBoolean) {
    if (f == null)
      f = new w(); 
    g = paramBoolean;
    f.a();
  }
  
  public static final void a(AbstractButton paramAbstractButton) {
    paramAbstractButton.setBorder((Border)at.a());
    paramAbstractButton.setFocusPainted(false);
    paramAbstractButton.setRolloverEnabled(true);
  }
  
  public static final void a(AbstractButton paramAbstractButton, String paramString) {
    String str = ".png";
    ImageIcon imageIcon = c(paramString + str);
    if (imageIcon != null)
      paramAbstractButton.setIcon(imageIcon); 
    imageIcon = c(paramString + "_p" + str);
    if (imageIcon != null)
      paramAbstractButton.setPressedIcon(imageIcon); 
    imageIcon = c(paramString + "_d" + str);
    if (imageIcon != null)
      paramAbstractButton.setDisabledIcon(imageIcon); 
    imageIcon = c(paramString + "_s" + str);
    if (imageIcon != null)
      paramAbstractButton.setSelectedIcon(imageIcon); 
    imageIcon = c(paramString + "_ds" + str);
    if (imageIcon != null)
      paramAbstractButton.setDisabledSelectedIcon(imageIcon); 
    imageIcon = c(paramString + "_r" + str);
    if (imageIcon != null)
      paramAbstractButton.setRolloverIcon(imageIcon); 
    imageIcon = c(paramString + "_rs" + str);
    if (imageIcon != null)
      paramAbstractButton.setRolloverSelectedIcon(imageIcon); 
  }
  
  public static final ImageIcon c(String paramString) {
    try {
      URL uRL = ((e == null) ? (e = b("util.f")) : e).getClassLoader().getResource("images/" + paramString);
      return new ImageIcon(uRL);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static final void b() {
    String str2;
    String str3;
    String str1 = be.b ? "*" : "";
    if (!r.c()) {
      str2 = d;
      str3 = null;
    } else {
      str2 = d + " [" + r.f() + str1 + "]";
      str3 = r.f() + str1;
    } 
    String str4 = g();
    if (str4 != null)
      str2 = str2 + " " + str4; 
    if (c != null)
      c.setTitle(str2); 
    be.a(str3);
  }
  
  public static final void a(String paramString) {
    String str2;
    String str3;
    String str1 = be.b ? "*" : "";
    if (!r.c()) {
      str2 = d + " " + paramString;
      str3 = paramString;
    } else {
      str2 = d + " [" + r.f() + str1 + "] " + paramString;
      str3 = r.f() + str1 + " " + paramString.toLowerCase();
    } 
    c.setTitle(str2);
    be.a(str3);
  }
  
  private static final String g() {
    String str;
    int i = be.d.getSize();
    int j = at.m();
    if (i == 0) {
      str = null;
    } else if (i == 1) {
      str = "One entry";
    } else {
      str = i + " entries";
    } 
    if (i > 0)
      if (j == 0) {
        str = str + " (none selected)";
      } else if (i == j && j == 1) {
        str = str + " (selected)";
      } else if (i == j) {
        str = str + " (all selected)";
      } else if (j == 1) {
        str = str + " (one selected)";
      } else {
        str = str + " (" + j + " selected)";
      }  
    return str;
  }
  
  public static final void a(Window paramWindow) {
    int i;
    int j;
    GraphicsConfiguration graphicsConfiguration = paramWindow.getGraphicsConfiguration();
    if (graphicsConfiguration != null) {
      Rectangle rectangle = graphicsConfiguration.getBounds();
      i = rectangle.x + (rectangle.width - paramWindow.getWidth()) / 2;
      j = rectangle.y + (rectangle.height - paramWindow.getHeight()) / 2;
    } else {
      Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
      i = (dimension.width - paramWindow.getWidth()) / 2;
      j = (dimension.height - paramWindow.getHeight()) / 2;
    } 
    if (i < 0)
      i = 0; 
    if (j < 0)
      j = 0; 
    paramWindow.setLocation(i, j);
  }
  
  public static final void a(Component paramComponent) {
    Dimension dimension1 = paramComponent.getSize();
    Dimension dimension2 = c.getSize();
    Point point = c.getLocationOnScreen();
    int i = point.x + (dimension2.width - dimension1.width) / 2;
    int j = point.y + (dimension2.height - dimension1.height) / 2;
    if (i < 0)
      i = 0; 
    if (j < 0)
      j = 0; 
    paramComponent.setLocation(i, j);
  }
  
  static boolean c() {
    return g;
  }
  
  static Class b(String paramString) {
    try {
      return Class.forName(paramString);
    } catch (ClassNotFoundException classNotFoundException) {
      throw new NoClassDefFoundError(classNotFoundException.getMessage());
    } 
  }
  
  static {
    i = c("zip_file.png").getImage();
    a = c("zip_file_d.png").getImage();
    char[] arrayOfChar = { 'z', 'i', 'p', 'c', 'r', 'e', 'a', 't', 'o', 'r' };
    d = new String(arrayOfChar);
    h = null;
    f = null;
    b = null;
    g = false;
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\f.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */