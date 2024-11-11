package util;

import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

class x implements DragSourceListener {
  public void dragEnter(DragSourceDragEvent paramDragSourceDragEvent) {}
  
  public void dragOver(DragSourceDragEvent paramDragSourceDragEvent) {}
  
  public void dropActionChanged(DragSourceDragEvent paramDragSourceDragEvent) {}
  
  public void dragExit(DragSourceEvent paramDragSourceEvent) {}
  
  public void dragDropEnd(DragSourceDropEvent paramDragSourceDropEvent) {
    bg.a();
    boolean bool = ai.e();
    if (ai.f() && bool && !bg.b())
      aw.b("Incomplete drag and drop", "The drag and drop operation did not complete successfully.\nYou may need to allow more time for the selected entries to be extracted."); 
    f.b();
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\x.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */