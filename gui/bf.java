package gui;

import java.awt.Color;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

public class bf extends DefaultMetalTheme implements bk {
  public static final Color m = Color.black;
  
  public static final Color g = Color.white;
  
  public static final ColorUIResource k = new ColorUIResource(120, 140, 100);
  
  public static final ColorUIResource b = new ColorUIResource(180, 200, 160);
  
  public static final ColorUIResource i = new ColorUIResource(220, 240, 200);
  
  public static final ColorUIResource e = new ColorUIResource(120, 120, 120);
  
  public static final ColorUIResource h = new ColorUIResource(160, 160, 160);
  
  public static final ColorUIResource j = new ColorUIResource(230, 230, 230);
  
  public static FontUIResource c;
  
  public static FontUIResource o;
  
  public static FontUIResource p;
  
  public static FontUIResource d;
  
  public static FontUIResource n;
  
  public static FontUIResource a;
  
  public static FontUIResource f;
  
  public static int l;
  
  public static final void a(int paramInt) {
    l = paramInt;
    c = new FontUIResource("Dialog", 0, l);
    o = new FontUIResource("Dialog", 0, l);
    p = new FontUIResource("Dialog", 0, l);
    d = new FontUIResource("Dialog", 0, l - 1);
    n = new FontUIResource("Dialog", 0, l);
    a = new FontUIResource("Dialog", 0, l);
    f = new FontUIResource("Dialog", 1, l);
  }
  
  public static final int a() {
    return l;
  }
  
  public String getName() {
    return "ZPCRTR";
  }
  
  protected ColorUIResource getPrimary1() {
    return k;
  }
  
  protected ColorUIResource getPrimary2() {
    return b;
  }
  
  protected ColorUIResource getPrimary3() {
    return i;
  }
  
  protected ColorUIResource getSecondary1() {
    return e;
  }
  
  protected ColorUIResource getSecondary2() {
    return h;
  }
  
  protected ColorUIResource getSecondary3() {
    return j;
  }
  
  public FontUIResource getSubTextFont() {
    return d;
  }
  
  public FontUIResource getSystemTextFont() {
    return n;
  }
  
  public FontUIResource getUserTextFont() {
    return a;
  }
  
  public FontUIResource getWindowTitleFont() {
    return p;
  }
  
  public FontUIResource getControlTextFont() {
    return c;
  }
  
  public FontUIResource getMenuTextFont() {
    return o;
  }
  
  static {
    a(D[1]);
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\bf.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */