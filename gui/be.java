package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import javax.swing.JWindow;
import util.f;

public class be extends JWindow {
  private static JWindow g = null;
  
  private static long a = -1L;
  
  private static av l = null;
  
  private static boolean c = true;
  
  private static Rectangle f = null;
  
  private static BufferedImage e = null;
  
  private static BufferedImage k = null;
  
  private static Graphics o = null;
  
  private static boolean j = false;
  
  private static Image n = null;
  
  private static Font m = new Font("Dialog", 0, 9);
  
  private static Color b = new Color(255, 255, 255, 128);
  
  private static Color d = bf.m;
  
  private static Color h = bf.k;
  
  private static String i = null;
  
  public be() {
    super(f.c);
    h();
    f();
    c();
    e();
  }
  
  private final void e() {
    addMouseListener(new af(this));
  }
  
  private final void c() {
    k = new BufferedImage(350, 130, 2);
    o = k.getGraphics();
    a(o);
    j = true;
  }
  
  private final void f() {
    try {
      e = (new Robot()).createScreenCapture(f);
    } catch (Exception exception) {
      c = false;
    } 
    if (n == null) {
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
      stringBuffer.append('.');
      stringBuffer.append('p');
      stringBuffer.append('n');
      stringBuffer.append('g');
      n = f.c(stringBuffer.toString()).getImage();
    } 
  }
  
  private final void h() {
    setSize(350, 130);
    f.a(this);
    f = getBounds();
  }
  
  public final void update(Graphics paramGraphics) {
    a(o);
    j = true;
    paint(paramGraphics);
  }
  
  public final void paint(Graphics paramGraphics) {
    if (j) {
      j = false;
      paramGraphics.drawImage(k, 0, 0, this);
    } else {
      update(paramGraphics);
    } 
  }
  
  public final void a(Graphics paramGraphics) {
    if (c && n != null) {
      paramGraphics.drawImage(e, 0, 0, g);
    } else {
      paramGraphics.setColor(bf.g);
      paramGraphics.fillRect(1, 1, 348, 128);
      paramGraphics.setColor(bf.m);
      paramGraphics.drawRect(0, 0, 349, 129);
    } 
    if (n != null)
      paramGraphics.drawImage(n, 0, 0, g); 
    byte b1 = 10;
    byte b2 = 11;
    int i = 130 - b2 - 2;
    byte b3 = 124;
    paramGraphics.setFont(m);
    String str = "Use of the software is subject to the terms defined by the zipcreator";
    a(paramGraphics, d, str, b1, i - b2 * 4);
    str = "license agreement. For operating instructions please refer to the user";
    a(paramGraphics, d, str, b1, i - b2 * 3);
    str = "guide which can be downloaded from the zipcreator web site.";
    a(paramGraphics, d, str, b1, i - b2 * 2);
    str = "Web: www.zipcreator.com Email: feedback@zipcreator.com";
    a(paramGraphics, d, str, b1, i - b2);
    if (i != null)
      a(paramGraphics, h, i, b1, b3); 
  }
  
  private static final void a(Graphics paramGraphics, Color paramColor, String paramString, int paramInt1, int paramInt2) {
    paramGraphics.setColor(b);
    paramGraphics.drawString(paramString, paramInt1 + 1, paramInt2);
    paramGraphics.drawString(paramString, paramInt1, paramInt2 + 1);
    paramGraphics.setColor(paramColor);
    paramGraphics.drawString(paramString, paramInt1, paramInt2);
  }
  
  public static final void g() {
    g = new be();
    g.show();
    a = System.currentTimeMillis();
    if (c && !f.equals(g.getBounds())) {
      c = false;
      g.repaint();
    } 
  }
  
  public static final boolean i() {
    return (g == null) ? false : g.isShowing();
  }
  
  public static final void a(boolean paramBoolean) {
    if (paramBoolean || a < 0L) {
      d();
    } else {
      l = new q();
      l.c();
    } 
  }
  
  private static final void d() {
    a = -1L;
    if (i()) {
      g.hide();
      g.dispose();
    } 
  }
  
  public static final void a(String paramString) {
    if (i == null && paramString == null)
      return; 
    if (i != null && i.equals(paramString))
      return; 
    i = paramString;
    b();
  }
  
  private static final void b() {
    try {
      g.repaint(8, 114, 341, 14);
    } catch (Exception exception) {}
  }
  
  static long a() {
    return a;
  }
  
  static void j() {
    d();
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\be.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */