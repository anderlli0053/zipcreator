package util;

import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

class b implements DropTargetListener {
  public final void dragEnter(DropTargetDragEvent paramDropTargetDragEvent) {
    a(paramDropTargetDragEvent);
  }
  
  public final void dragOver(DropTargetDragEvent paramDropTargetDragEvent) {
    a(paramDropTargetDragEvent);
  }
  
  public final void dropActionChanged(DropTargetDragEvent paramDropTargetDragEvent) {
    a(paramDropTargetDragEvent);
  }
  
  public final void dragExit(DropTargetEvent paramDropTargetEvent) {}
  
  public final void drop(DropTargetDropEvent paramDropTargetDropEvent) {
    if (ai.i()) {
      paramDropTargetDropEvent.rejectDrop();
    } else {
      ai.b(false);
      ai.c(paramDropTargetDropEvent);
    } 
  }
  
  private final void a(DropTargetDragEvent paramDropTargetDragEvent) {
    if (ai.i()) {
      paramDropTargetDragEvent.rejectDrag();
    } else if (paramDropTargetDragEvent.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
      paramDropTargetDragEvent.acceptDrag(1073741824);
    } else if (paramDropTargetDragEvent.isDataFlavorSupported(DataFlavor.stringFlavor)) {
      paramDropTargetDragEvent.acceptDrag(1);
    } else {
      paramDropTargetDragEvent.rejectDrag();
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\b.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */