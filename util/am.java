package util;

import gui.aw;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.s;

public abstract class am {
  public static boolean e = true;
  
  public static boolean d = true;
  
  public static boolean a = true;
  
  private static boolean b = false;
  
  private static ClipboardOwner c = null;
  
  public static final void a() {
    c = new y();
  }
  
  public static final void a(boolean paramBoolean) {
    b = paramBoolean;
  }
  
  public static final void d() {
    if (e && !b && !at.f.isSelectionEmpty())
      b(true); 
  }
  
  public static final void b() {
    if (d && !b && !at.f.isSelectionEmpty())
      b(false); 
  }
  
  private static final void b(boolean paramBoolean) {
    f.a(true);
    bg.c();
    List list = at.a();
    boolean bool = (list.size() > 1) ? true : false;
    boolean bool1 = bg.a(ba.d(), list, false, bool);
    if (!bool1) {
      f.a(false);
      return;
    } 
    ArrayList arrayList = new ArrayList();
    boolean bool2 = bg.a(list, arrayList, paramBoolean, bool);
    if (bool2)
      try {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents((Transferable)new aw(list, arrayList), c);
      } catch (Exception exception) {
        aw.a("Clipboard operation failed", "The clipboard contents could not be set.", exception);
        bool2 = false;
      }  
    if (bool2 && paramBoolean) {
      at.f.setValueIsAdjusting(true);
      be.d.b(list);
      at.f.setValueIsAdjusting(false);
      be.b = true;
    } 
    f.b();
    f.a(false);
  }
  
  public static final void e() {
    if (a && !b)
      c(); 
  }
  
  private static final void c() {
    Transferable transferable = null;
    try {
      transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(f.c);
    } catch (Exception exception) {
      aw.a("Clipboard operation failed", "The clipboard contents could not be accessed.", exception);
      return;
    } 
    if (transferable == null)
      return; 
    if (transferable.isDataFlavorSupported(aw.d)) {
      try {
        List list = (List)transferable.getTransferData(aw.d);
        if (list != null && !list.isEmpty())
          a(list); 
      } catch (Exception exception) {
        aw.a("Clipboard operation failed", "The entries on the clipboard could not be accessed.", exception);
      } 
    } else if (transferable.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
      try {
        List list = aw.a(transferable);
        if (list.size() > 0) {
          File[] arrayOfFile = (File[])list.toArray((Object[])new File[list.size()]);
          a(arrayOfFile);
        } 
      } catch (Exception exception) {
        aw.a("Clipboard operation failed", "The files on the clipboard could not be accessed.", exception);
      } 
    } 
  }
  
  public static final void a(List paramList) {
    f.a(true);
    f.a("Adding");
    ArrayList arrayList = new ArrayList(paramList);
    at.f.setValueIsAdjusting(true);
    byte b = 0;
    Iterator iterator = arrayList.iterator();
    while (iterator.hasNext()) {
      s s = iterator.next();
      if (be.d.a(s) > -1) {
        iterator.remove();
        continue;
      } 
      be.d.b(s);
      f.a("Adding " + ++b + " " + ((b == 1) ? "entry" : "entries"));
    } 
    at.f.setValueIsAdjusting(false);
    if (arrayList.size() > 0) {
      be.b = true;
      at.a(arrayList);
    } else {
      int i = paramList.size();
      StringBuffer stringBuffer = new StringBuffer();
      if (i == 1) {
        stringBuffer.append("The paste operation had no effect because the entry on the clipboard\n");
        stringBuffer.append("has the same path as an entry already in the list.");
      } else if (i > 1) {
        stringBuffer.append("The paste operation had no effect because the " + i + " entries on the clipboard\n");
        stringBuffer.append("have the same paths as entries already in the list.");
      } 
      aw.b("Paste notification", stringBuffer.toString());
    } 
    f.b();
    f.a(false);
  }
  
  public static final void a(File[] paramArrayOfFile) {
    aa aa = new aa(paramArrayOfFile);
    aa.c();
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\am.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */