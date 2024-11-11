package gui;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class j extends FileFilter {
  public String getDescription() {
    return "Directories only";
  }
  
  public boolean accept(File paramFile) {
    return paramFile.isDirectory();
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\j.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */