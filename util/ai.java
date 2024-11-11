package util;

import gui.aw;
import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ai {
  public static boolean f = true;
  
  public static boolean c = true;
  
  public static boolean g = true;
  
  private static List e;
  
  private static File b = null;
  
  private static boolean a = true;
  
  private static boolean d = false;
  
  public static final void b() {
    e = Collections.synchronizedList(new ArrayList());
    if (f)
      k(); 
    if (c)
      j(); 
    if (g)
      d(); 
  }
  
  private static final void k() {
    try {
      DragSource dragSource = DragSource.getDefaultDragSource();
      x x = new x();
      DragGestureRecognizer dragGestureRecognizer = dragSource.createDefaultDragGestureRecognizer(f.c.N, 1073741827, new ab(x));
    } catch (Exception exception) {}
  }
  
  private static final void j() {
    try {
      b b = new b();
      DropTarget dropTarget1 = new DropTarget();
      dropTarget1.setComponent((Component)f.c);
      dropTarget1.setFlavorMap(SystemFlavorMap.getDefaultFlavorMap());
      dropTarget1.setDefaultActions(1073741825);
      dropTarget1.addDropTargetListener(b);
      DropTarget dropTarget2 = new DropTarget();
      dropTarget2.setComponent(f.c.c());
      dropTarget2.setFlavorMap(SystemFlavorMap.getDefaultFlavorMap());
      dropTarget2.setDefaultActions(1073741825);
      dropTarget2.addDropTargetListener(b);
      Component[] arrayOfComponent = f.c.c().getComponents();
      for (byte b1 = 0; b1 < arrayOfComponent.length; b1++) {
        DropTarget dropTarget = new DropTarget();
        dropTarget.setComponent(arrayOfComponent[b1]);
        dropTarget.setFlavorMap(SystemFlavorMap.getDefaultFlavorMap());
        dropTarget.setDefaultActions(1073741825);
        dropTarget.addDropTargetListener(b);
      } 
    } catch (Exception exception) {}
  }
  
  private static final void d() {
    try {
      au au = new au();
      DropTarget dropTarget1 = new DropTarget();
      dropTarget1.setComponent(f.c.N);
      dropTarget1.setFlavorMap(SystemFlavorMap.getDefaultFlavorMap());
      dropTarget1.setDefaultActions(1073741827);
      dropTarget1.addDropTargetListener(au);
      DropTarget dropTarget2 = new DropTarget();
      dropTarget2.setComponent(f.c.r());
      dropTarget2.setFlavorMap(SystemFlavorMap.getDefaultFlavorMap());
      dropTarget2.setDefaultActions(1073741827);
      dropTarget2.addDropTargetListener(au);
    } catch (Exception exception) {}
  }
  
  public static final void a(boolean paramBoolean) {
    d = paramBoolean;
  }
  
  private static final boolean a() {
    int i = e.size();
    return (i == 0 || (i == 1 && e.contains(b)));
  }
  
  private static final boolean h() {
    if (b == null || !b.exists())
      try {
        File file = new File(ba.d(), "Warning.txt");
        file.createNewFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("zipcreator drag and drop warning.");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.write("The drag and drop operation was not completed successfully.");
        bufferedWriter.newLine();
        bufferedWriter.write("You should allow more time for the selected entries to be extracted.");
        bufferedWriter.newLine();
        bufferedWriter.write("Only use the drop gesture once the title bar reads 'Ready to drop'.");
        bufferedWriter.close();
      } catch (Exception exception) {
        return false;
      }  
    return true;
  }
  
  private static final void b(DragGestureEvent paramDragGestureEvent, DragSourceListener paramDragSourceListener) {
    bg.a();
    boolean bool = c();
    if (bool)
      paramDragGestureEvent.startDrag(DragSource.DefaultMoveDrop, (Transferable)new aw(e), paramDragSourceListener); 
  }
  
  private static final boolean c() {
    e.clear();
    if (!h())
      return false; 
    e.add(b);
    if (at.f.isSelectionEmpty())
      return false; 
    List list = at.a();
    boolean bool = (list.size() > 1) ? true : false;
    boolean bool1 = bg.a(ba.d(), list, true, bool);
    if (!bool1)
      return false; 
    p p = new p(list, bool);
    p.c();
    return true;
  }
  
  private static final void a(DropTargetDropEvent paramDropTargetDropEvent) {
    Transferable transferable = paramDropTargetDropEvent.getTransferable();
    if (paramDropTargetDropEvent.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
      paramDropTargetDropEvent.acceptDrop(1073741824);
    } else if (paramDropTargetDropEvent.isDataFlavorSupported(DataFlavor.stringFlavor)) {
      paramDropTargetDropEvent.acceptDrop(1);
    } else {
      paramDropTargetDropEvent.rejectDrop();
      return;
    } 
    try {
      List list = aw.a(transferable);
      File file1 = list.get(0);
      if (paramDropTargetDropEvent.isLocalTransfer()) {
        if (file1.isDirectory())
          file1 = ar.f(file1); 
        if (file1 == null) {
          aw.b("Cannot open", "To open a zip file from the list, select it and then drag it to the title bar.");
          return;
        } 
      } 
      File file2 = file1;
      k k = new k(file2);
      k.c();
      paramDropTargetDropEvent.dropComplete(true);
      f.c.toFront();
    } catch (Exception exception) {
      paramDropTargetDropEvent.dropComplete(false);
    } 
  }
  
  private static final void d(DropTargetDropEvent paramDropTargetDropEvent) {
    Transferable transferable = paramDropTargetDropEvent.getTransferable();
    if (paramDropTargetDropEvent.isLocalTransfer()) {
      paramDropTargetDropEvent.rejectDrop();
      return;
    } 
    if (paramDropTargetDropEvent.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
      paramDropTargetDropEvent.acceptDrop(1073741824);
    } else if (paramDropTargetDropEvent.isDataFlavorSupported(DataFlavor.stringFlavor)) {
      paramDropTargetDropEvent.acceptDrop(1);
    } else {
      paramDropTargetDropEvent.rejectDrop();
      return;
    } 
    try {
      List list = aw.a(transferable);
      if (list.size() < 1) {
        paramDropTargetDropEvent.dropComplete(false);
        return;
      } 
      File[] arrayOfFile = (File[])list.toArray((Object[])new File[list.size()]);
      a(arrayOfFile);
      paramDropTargetDropEvent.dropComplete(true);
      f.c.toFront();
    } catch (Exception exception) {
      paramDropTargetDropEvent.dropComplete(false);
    } 
  }
  
  private static final void a(File[] paramArrayOfFile) {
    g g = new g(paramArrayOfFile);
    g.c();
  }
  
  static boolean e() {
    return a();
  }
  
  static boolean f() {
    return a;
  }
  
  static boolean i() {
    return d;
  }
  
  static void a(DragGestureEvent paramDragGestureEvent, DragSourceListener paramDragSourceListener) {
    b(paramDragGestureEvent, paramDragSourceListener);
  }
  
  static boolean b(boolean paramBoolean) {
    return a = paramBoolean;
  }
  
  static void c(DropTargetDropEvent paramDropTargetDropEvent) {
    a(paramDropTargetDropEvent);
  }
  
  static void b(DropTargetDropEvent paramDropTargetDropEvent) {
    d(paramDropTargetDropEvent);
  }
  
  static List g() {
    return e;
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\ai.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */