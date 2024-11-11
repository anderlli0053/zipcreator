package util;

import java.io.File;
import java.io.FilenameFilter;

class h implements FilenameFilter {
  private final int a;
  
  h(int paramInt) {
    this.a = paramInt;
  }
  
  public boolean accept(File paramFile, String paramString) {
    return (paramString.length() > this.a && paramString.substring(0, this.a).equalsIgnoreCase(".zc_"));
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\h.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */