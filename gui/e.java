package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import util.be;

final class gui/e extends Timer implements ActionListener {
  public boolean d;
  
  public String a;
  
  public long c;
  
  private long b;
  
  private final o e;
  
  public gui/e(o paramo) {
    super(50, null);
    this.e = paramo;
    this.d = true;
    this.a = null;
    this.c = 0L;
    this.b = -1L;
    setCoalesce(true);
    addActionListener(this);
    start();
  }
  
  public void actionPerformed(ActionEvent paramActionEvent) {
    boolean bool = false;
    long l = this.c;
    if (this.c > this.b) {
      stop();
      bool = true;
      int i = be.d.b.length();
      if (i > 0) {
        int j = this.e.N.getLeadSelectionIndex();
        int k = -1;
        if (this.d && j < i - 1) {
          k = be.d.b.indexOf(this.a, j + 1);
        } else if (!this.d && j > 0) {
          k = be.d.b.lastIndexOf(this.a, j - 1);
        } 
        if (k > -1) {
          this.e.N.setSelectionInterval(k, k);
          this.e.N.ensureIndexIsVisible(k);
        } 
      } 
    } 
    this.b = l;
    if (bool)
      restart(); 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\e.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */