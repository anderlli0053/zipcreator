package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import javax.swing.JToolBar;

public class ah extends JToolBar.Separator {
  public static JComponent a = null;
  
  private JToolBar b;
  
  private PropertyChangeListener c = null;
  
  public ah(JToolBar paramJToolBar) {
    this.b = paramJToolBar;
    b();
  }
  
  public final void b() {
    if (this.c == null)
      this.c = new bi(this); 
    this.b.addPropertyChangeListener(this.c);
  }
  
  public final void a() {
    if (this.c != null)
      this.b.removePropertyChangeListener(this.c); 
  }
  
  public final void c() {
    if (this.b.getOrientation() == 1) {
      setOrientation(0);
    } else {
      setOrientation(1);
    } 
    int i = 6;
    int j = 6;
    if (a != null)
      if (getOrientation() == 1) {
        j = (a.getPreferredSize()).height;
      } else {
        i = (a.getPreferredSize()).width;
      }  
    setSeparatorSize(new Dimension(i, j));
    revalidate();
  }
  
  public final void paintBorder(Graphics paramGraphics) {
    if (getOrientation() == 1) {
      int i = getHeight();
      paramGraphics.setColor(bf.h);
      paramGraphics.drawLine(3, 0, 3, i - 1);
      paramGraphics.setColor(bf.g);
      paramGraphics.drawLine(4, 1, 4, i - 1);
    } else {
      int i = getWidth();
      paramGraphics.setColor(bf.h);
      paramGraphics.drawLine(0, 3, i - 1, 3);
      paramGraphics.setColor(bf.g);
      paramGraphics.drawLine(1, 4, i - 1, 4);
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\ah.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */