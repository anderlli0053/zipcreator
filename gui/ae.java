package gui;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultFocusManager;
import javax.swing.JComponent;
import util.bh;
import util.f;

public class ae extends DefaultFocusManager {
  public final void processKeyEvent(Component paramComponent, KeyEvent paramKeyEvent) {
    if (f.c.n()) {
      if (paramKeyEvent.getKeyCode() == 9) {
        if (paramKeyEvent.getID() != 401) {
          paramKeyEvent.consume();
          return;
        } 
        if ((paramKeyEvent.getModifiers() & 0x1) == 1) {
          b(paramComponent);
        } else {
          a(paramComponent);
        } 
        paramKeyEvent.consume();
      } 
    } else {
      super.processKeyEvent(paramComponent, paramKeyEvent);
    } 
  }
  
  public final void a(Component paramComponent) {
    a(paramComponent, a(), 1);
  }
  
  public final void b(Component paramComponent) {
    a(paramComponent, a(), -1);
  }
  
  private final List a() {
    return bh.a;
  }
  
  private final void a(Component paramComponent, List paramList, int paramInt) {
    int i = paramList.indexOf(paramComponent);
    if (i > -1) {
      int[] arrayOfInt = a(i, paramList.size(), paramInt);
      for (byte b = 0; b < arrayOfInt.length; b++) {
        Component component = paramList.get(arrayOfInt[b]);
        if (component.isEnabled()) {
          if (component instanceof JComponent) {
            ((JComponent)component).grabFocus();
          } else {
            component.requestFocus();
          } 
          return;
        } 
      } 
    } 
  }
  
  private final int[] a(int paramInt1, int paramInt2, int paramInt3) {
    int[] arrayOfInt = new int[paramInt2 - 1];
    int i = paramInt1;
    if (paramInt3 > 0) {
      for (byte b = 0; b < arrayOfInt.length; b++) {
        if (++i >= paramInt2)
          i = 0; 
        arrayOfInt[b] = i;
      } 
    } else {
      for (byte b = 0; b < arrayOfInt.length; b++) {
        if (--i < 0)
          i = paramInt2 - 1; 
        arrayOfInt[b] = i;
      } 
    } 
    return arrayOfInt;
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\ae.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */