package gui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.border.AbstractBorder;

public class at extends AbstractBorder {
  private static at a = null;
  
  private static Insets b = null;
  
  public static final at a() {
    if (a == null) {
      a = new at();
      b = new Insets(4, 5, 5, 7);
    } 
    return a;
  }
  
  public Insets getBorderInsets(Component paramComponent) {
    return b;
  }
  
  public void paintBorder(Component paramComponent, Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    AbstractButton abstractButton = (AbstractButton)paramComponent;
    ButtonModel buttonModel = abstractButton.getModel();
    if (buttonModel.isPressed() || buttonModel.isSelected()) {
      int i = paramInt1 + paramInt3 - 1;
      int j = paramInt2 + paramInt4 - 1;
      paramGraphics.setColor(bf.e);
      paramGraphics.drawLine(paramInt1, paramInt2, paramInt1, j);
      paramGraphics.drawLine(paramInt1, paramInt2, i, paramInt2);
      paramGraphics.setColor(bf.g);
      paramGraphics.drawLine(i, paramInt2, i, j);
      paramGraphics.drawLine(paramInt1, j, i, j);
    } else if (buttonModel.isRollover()) {
      int i = paramInt1 + paramInt3 - 1;
      int j = paramInt2 + paramInt4 - 1;
      paramGraphics.setColor(bf.h);
      paramGraphics.drawLine(i, paramInt2, i, j);
      paramGraphics.drawLine(paramInt1, j, i, j);
      paramGraphics.setColor(bf.g);
      paramGraphics.drawLine(paramInt1, paramInt2, paramInt1, j);
      paramGraphics.drawLine(paramInt1, paramInt2, i, paramInt2);
    } 
    if (abstractButton.hasFocus()) {
      int i = paramInt1 + 1;
      int j = paramInt2 + 1;
      int k = paramInt1 + paramInt3 - 3;
      int m = paramInt2 + paramInt4 - 3;
      paramGraphics.setColor(bf.b);
      paramGraphics.drawRect(i, j, k, m);
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\at.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */