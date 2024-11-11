package gui;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;
import util.ah;
import util.ar;

public class l extends FileView {
  public final String getName(File paramFile) {
    if (paramFile == null)
      return null; 
    String str1 = paramFile.getName();
    String str2 = ar.h(str1);
    return (ah.c(str2) && !paramFile.isDirectory()) ? str1 : null;
  }
  
  public final String getDescription(File paramFile) {
    return null;
  }
  
  public final String getTypeDescription(File paramFile) {
    if (paramFile == null)
      return null; 
    String str1 = paramFile.getName();
    String str2 = ar.h(str1);
    return (ah.c(str2) && !paramFile.isDirectory()) ? ah.b(str2) : null;
  }
  
  public final Icon getIcon(File paramFile) {
    if (paramFile == null)
      return null; 
    String str1 = paramFile.getName();
    String str2 = ar.h(str1);
    return !paramFile.isDirectory() ? ah.b(ah.a(str2)) : null;
  }
  
  public final Boolean isTraversable(File paramFile) {
    return null;
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\l.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */