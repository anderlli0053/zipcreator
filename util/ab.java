package util;

import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.InvalidDnDOperationException;

class ab implements DragGestureListener {
  private final DragSourceListener a;
  
  ab(DragSourceListener paramDragSourceListener) {
    this.a = paramDragSourceListener;
  }
  
  public void dragGestureRecognized(DragGestureEvent paramDragGestureEvent) throws InvalidDnDOperationException {
    if (!ai.i()) {
      ai.a(paramDragGestureEvent, this.a);
      ai.b(true);
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\ab.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */