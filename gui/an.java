package gui;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import util.ar;

public class an extends FileFilter {
  public String getDescription() {
    return "ZIP and JAR Files";
  }
  
  public boolean accept(File paramFile) {
    if (paramFile.isDirectory())
      return true; 
    String str = ar.h(paramFile.getName());
    return (str.equalsIgnoreCase("zip") || str.equalsIgnoreCase("jar"));
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\an.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */