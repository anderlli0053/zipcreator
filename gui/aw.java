package gui;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import util.ar;

public class aw implements Transferable {
  public aw(List paramList) {
    this(null, paramList);
  }
  
  public aw(List paramList1, List paramList2) {
    this.c = paramList1;
    this.b = paramList2;
  }
  
  public final DataFlavor[] getTransferDataFlavors() {
    return (this.c == null) ? new DataFlavor[] { DataFlavor.javaFileListFlavor, DataFlavor.stringFlavor } : new DataFlavor[] { DataFlavor.javaFileListFlavor, DataFlavor.stringFlavor, d };
  }
  
  public boolean isDataFlavorSupported(DataFlavor paramDataFlavor) {
    return DataFlavor.javaFileListFlavor.equals(paramDataFlavor) ? true : (DataFlavor.stringFlavor.equals(paramDataFlavor) ? true : ((this.c != null && d != null && d.equals(paramDataFlavor))));
  }
  
  public Object getTransferData(DataFlavor paramDataFlavor) throws UnsupportedFlavorException, IOException {
    if (DataFlavor.javaFileListFlavor.equals(paramDataFlavor))
      return this.b; 
    if (DataFlavor.stringFlavor.equals(paramDataFlavor))
      return a(); 
    if (this.c != null && d != null && d.equals(paramDataFlavor))
      return this.c; 
    throw new UnsupportedFlavorException(paramDataFlavor);
  }
  
  private final String a() {
    StringBuffer stringBuffer = new StringBuffer();
    Iterator iterator = this.b.iterator();
    while (iterator.hasNext()) {
      File file = iterator.next();
      if (file != null) {
        stringBuffer.append(ar.d(file));
        if (iterator.hasNext())
          stringBuffer.append("\n"); 
      } 
    } 
    return stringBuffer.toString();
  }
  
  public static final List a(Transferable paramTransferable) throws UnsupportedFlavorException, IOException {
    if (paramTransferable.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
      List list = (List)paramTransferable.getTransferData(DataFlavor.javaFileListFlavor);
      return a(list);
    } 
    if (paramTransferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
      String str = (String)paramTransferable.getTransferData(DataFlavor.stringFlavor);
      return a(str);
    } 
    throw new UnsupportedFlavorException(paramTransferable.getTransferDataFlavors()[0]);
  }
  
  private static final List a(List paramList) {
    ArrayList arrayList = new ArrayList();
    for (File file : paramList) {
      if (file != null && file.getName().length() > 0)
        arrayList.add(file); 
    } 
    return arrayList;
  }
  
  private static final List a(String paramString) {
    ArrayList arrayList = new ArrayList();
    StringTokenizer stringTokenizer = new StringTokenizer(paramString, "\t\n\r\f");
    while (stringTokenizer.hasMoreTokens()) {
      String str = stringTokenizer.nextToken();
      str = str.trim();
      if (str.length() > 0)
        arrayList.add(new File(str)); 
    } 
    return arrayList;
  }
  
  static {
    try {
      dataFlavor = new DataFlavor(a);
    } catch (ClassNotFoundException classNotFoundException) {
      dataFlavor = null;
    } 
    d = dataFlavor;
  }
  
  static {
    DataFlavor dataFlavor;
  }
  
  public static final String a = "application/x-java-jvm-local-objectref;class=java.util.List";
  
  public static final DataFlavor d;
  
  private List b = null;
  
  private List c = null;
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\aw.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */