package util;

import java.io.File;

public abstract class bd {
  public static final void b() {
    if (a()) {
      int i = aw.a("Save changes", c(), 2);
      if (i == 1) {
        if (r.c()) {
          n.a((Runnable)n.m(), (Runnable)n.h()).c();
          return;
        } 
        File file = aw.b("Save zip file", "Save", 0, 0);
        if (file == null)
          return; 
        n.a((Runnable)n.c(file), (Runnable)n.h()).c();
        return;
      } 
      if (i != 2)
        return; 
    } 
    n.h().run();
  }
  
  public static final void d() {
    if (a()) {
      int i = aw.a("Save changes", c(), 2);
      if (i == 1) {
        if (r.c()) {
          n.a((Runnable)n.m(), (Runnable)n.z()).c();
          return;
        } 
        File file1 = aw.b("Save zip file", "Save", 0, 0);
        if (file1 == null)
          return; 
        n.a((Runnable)n.c(file1), (Runnable)n.z()).c();
        return;
      } 
      if (i != 2)
        return; 
    } 
    File file = aw.b("Open zip file", "Open", 0, 0);
    if (file == null)
      return; 
    n.a(file, false).c();
  }
  
  public static final void a(File paramFile) {
    if (!r.b(paramFile))
      return; 
    String str1 = ar.c(paramFile);
    String str2 = ar.h(str1);
    if (!str2.equalsIgnoreCase("zip") && !str2.equalsIgnoreCase("jar")) {
      boolean bool = aw.c("Confirm open", "The file '" + str1 + "' may not be a zip file.\nAre you sure you want to open it?");
      if (!bool)
        return; 
    } 
    if (a()) {
      int i = aw.a("Save changes", c(), 2);
      if (i == 1) {
        if (r.c()) {
          n.m().run();
          n.a(paramFile, true).run();
          return;
        } 
        File file = aw.b("Save zip file", "Save", 0, 0);
        if (file == null)
          return; 
        n.c(file).run();
        n.a(paramFile, true).run();
        return;
      } 
      if (i != 2)
        return; 
    } 
    n.a(paramFile, true).run();
  }
  
  public static final boolean a(boolean paramBoolean) {
    if (!paramBoolean && a()) {
      int i = aw.a("Save changes", c(), 2);
      if (i == 1) {
        if (r.c()) {
          n.a((Runnable)n.m(), (Runnable)n.o()).c();
          return true;
        } 
        File file = aw.b("Save zip file", "Save", 0, 0);
        if (file != null) {
          n.a((Runnable)n.c(file), (Runnable)n.o()).c();
          return true;
        } 
      } else if (i != 2) {
        return false;
      } 
    } 
    n.o().run();
    return true;
  }
  
  private static final boolean a() {
    return (be.b && be.d.getSize() > 0);
  }
  
  private static final String c() {
    String str;
    if (r.c()) {
      str = "The entries for '" + r.e() + "' have changed.\nDo you want to save these changes?";
    } else if (be.d.getSize() == 1) {
      str = "Do you want to save this entry as a zip file?";
    } else {
      str = "Do you want to save these entries as a zip file?";
    } 
    return str;
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\bd.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */