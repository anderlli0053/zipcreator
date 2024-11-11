package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import model.e;
import model.s;
import util.ah;
import util.ar;
import util.f;

public class x extends JPanel implements ListCellRenderer {
  private static final ImageIcon k = f.c("blank.png");
  
  private static final ImageIcon j = f.c("dir.png");
  
  private static final ImageIcon g = f.c("uncompressed.png");
  
  private static final ImageIcon p = f.c("compressed.png");
  
  private static final ImageIcon c = f.c("dir_d.png");
  
  private static final ImageIcon a = f.c("uncompressed_d.png");
  
  private static final ImageIcon d = f.c("compressed_d.png");
  
  private static boolean n = false;
  
  private static boolean o = false;
  
  private JLabel e;
  
  private JLabel f;
  
  private JLabel m;
  
  private JLabel h;
  
  private JLabel i;
  
  private JLabel b;
  
  private JLabel l;
  
  public x() {
    a();
  }
  
  public Component getListCellRendererComponent(JList paramJList, Object paramObject, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    n = (paramBoolean2 || (paramJList != null && paramInt == paramJList.getLeadSelectionIndex()));
    o = (paramJList != null) ? paramJList.isEnabled() : false;
    this.f.setForeground(bf.m);
    this.m.setForeground(bf.m);
    if (o) {
      setBackground(paramBoolean1 ? bf.i : bf.g);
      this.h.setForeground(bf.k);
      this.i.setForeground(bf.k);
      this.l.setForeground(bf.k);
    } else {
      setBackground(paramBoolean1 ? bf.j : bf.g);
      this.h.setForeground(bf.e);
      this.i.setForeground(bf.e);
      this.l.setForeground(bf.e);
    } 
    if (paramObject == null || !(paramObject instanceof s)) {
      this.e.setIcon(k);
      this.f.setText("");
      this.m.setText("");
      this.h.setText("");
      this.i.setText("");
      this.b.setIcon(k);
      this.l.setText("");
    } else {
      s s = (s)paramObject;
      boolean bool = s instanceof model.l;
      e e = bool ? null : (e)s;
      String str1 = s.j();
      if (bool) {
        this.e.setIcon(o ? j : c);
      } else {
        String str = ar.h(str1);
        int i = ah.a(str);
        this.e.setIcon(o ? ah.b(i) : ah.a(i));
      } 
      this.f.setText(str1);
      this.f.setFont(bool ? bf.f : bf.c);
      if (str1.length() >= 6 && str1.substring(0, 6).equalsIgnoreCase("<html>"))
        this.f.putClientProperty("html", (Object)null); 
      String str2 = s.d();
      this.m.setText(str2);
      if (str2.length() >= 6 && str2.substring(0, 6).equalsIgnoreCase("<html>"))
        this.m.putClientProperty("html", (Object)null); 
      this.h.setText(s.g());
      String str3 = s.a();
      this.i.setText(str3);
      if (str3.length() >= 6 && str3.substring(0, 6).equalsIgnoreCase("<html>"))
        this.i.putClientProperty("html", (Object)null); 
      if (bool) {
        this.b.setIcon(k);
      } else if (e.g) {
        this.b.setIcon(o ? g : a);
      } else {
        this.b.setIcon(o ? p : d);
      } 
      this.l.setText(s.i());
    } 
    return this;
  }
  
  public final void paintBorder(Graphics paramGraphics) {
    if (n) {
      paramGraphics.setColor(o ? bf.b : bf.h);
      paramGraphics.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    } 
  }
  
  public final void revalidate() {}
  
  public void firePropertyChange(String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void firePropertyChange(String paramString, Object paramObject1, Object paramObject2) {
    if (paramString.equals("text") || paramString.equals("icon"))
      super.firePropertyChange(paramString, paramObject1, paramObject2); 
  }
  
  private void a() {
    this.e = new JLabel();
    this.f = new JLabel();
    this.m = new JLabel();
    this.h = new JLabel();
    this.i = new JLabel();
    this.b = new JLabel();
    this.l = new JLabel();
    setLayout(new GridBagLayout());
    this.e.setIcon(k);
    this.e.setMaximumSize(new Dimension(16, 16));
    this.e.setMinimumSize(new Dimension(16, 16));
    this.e.setPreferredSize(new Dimension(16, 16));
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.insets = new Insets(0, 3, 0, 3);
    add(this.e, gridBagConstraints);
    this.f.setText("Spec.name()");
    this.f.setPreferredSize(new Dimension(140, 16));
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.fill = 2;
    gridBagConstraints.insets = new Insets(1, 0, 1, 3);
    gridBagConstraints.anchor = 17;
    gridBagConstraints.weightx = 0.3D;
    add(this.f, gridBagConstraints);
    this.m.setText("Spec.dir()");
    this.m.setPreferredSize(new Dimension(70, 16));
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.fill = 2;
    gridBagConstraints.insets = new Insets(1, 3, 1, 3);
    gridBagConstraints.anchor = 17;
    gridBagConstraints.weightx = 0.45D;
    add(this.m, gridBagConstraints);
    this.h.setForeground(bf.k);
    this.h.setText("Spec.dateTime()");
    this.h.setPreferredSize(new Dimension(90, 16));
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.fill = 2;
    gridBagConstraints.insets = new Insets(1, 3, 1, 3);
    gridBagConstraints.anchor = 17;
    gridBagConstraints.weightx = 0.05D;
    add(this.h, gridBagConstraints);
    this.i.setForeground(bf.k);
    this.i.setText("Spec.type()");
    this.i.setPreferredSize(new Dimension(50, 16));
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.fill = 2;
    gridBagConstraints.insets = new Insets(1, 3, 1, 3);
    gridBagConstraints.anchor = 17;
    gridBagConstraints.weightx = 0.1D;
    add(this.i, gridBagConstraints);
    this.b.setIcon(g);
    this.b.setMaximumSize(new Dimension(16, 16));
    this.b.setMinimumSize(new Dimension(16, 16));
    this.b.setPreferredSize(new Dimension(16, 16));
    gridBagConstraints = new GridBagConstraints();
    add(this.b, gridBagConstraints);
    this.l.setForeground(bf.k);
    this.l.setText("Spec.size()");
    this.l.setPreferredSize(new Dimension(110, 16));
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.fill = 2;
    gridBagConstraints.insets = new Insets(1, 6, 1, 3);
    gridBagConstraints.anchor = 17;
    gridBagConstraints.weightx = 0.1D;
    add(this.l, gridBagConstraints);
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\x.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */