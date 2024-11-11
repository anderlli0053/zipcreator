package util;

import gui.an;
import gui.j;
import gui.l;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileView;

public abstract class aw {
  public static final Icon n;
  
  public static final Icon g;
  
  public static final Icon p;
  
  public static final Icon j;
  
  public static final Icon d;
  
  public static final Icon m;
  
  public static final Icon l;
  
  public static final String[] f = new String[] { "Yes to All", "Yes", "No", "No to All", "Cancel" };
  
  private static final String c;
  
  public static FileFilter h = (FileFilter)new an();
  
  public static FileFilter a = (FileFilter)new j();
  
  private static FileFilter b = null;
  
  private static JDialog e = null;
  
  private static JFileChooser i = null;
  
  private static JCheckBox o = null;
  
  private static File k = null;
  
  public static final void c() {
    try {
      if (e != null)
        SwingUtilities.updateComponentTreeUI(e); 
    } catch (Exception exception) {}
  }
  
  public static final File b(String paramString1, String paramString2, int paramInt1, int paramInt2) {
    e();
    e.setTitle(paramString1);
    i.setApproveButtonText(paramString2);
    i.setApproveButtonToolTipText(paramString1);
    i.setFileSelectionMode(paramInt1);
    i.setMultiSelectionEnabled(false);
    a(paramInt2);
    try {
      e.show();
    } catch (SecurityException securityException) {
      a("Security violation", "You may not have permission to access this part of the file system.", securityException);
      return null;
    } 
    File file = i.getSelectedFile();
    if (paramInt2 == 0) {
      b = i.getFileFilter();
      if (file != null && b == h) {
        String str1 = file.getName();
        String str2 = ar.h(str1);
        if (str2.length() == 0)
          file = new File(file.getParentFile(), str1 + ".zip"); 
      } 
    } 
    return file;
  }
  
  public static final File[] a(String paramString1, String paramString2, int paramInt1, int paramInt2) {
    e();
    e.setTitle(paramString1);
    i.setApproveButtonText(paramString2);
    i.setApproveButtonToolTipText(paramString1);
    i.setFileSelectionMode(paramInt1);
    i.setMultiSelectionEnabled(true);
    a(paramInt2);
    try {
      e.show();
    } catch (SecurityException securityException) {
      a("Security violation", "You may not have permission to access this part of the file system.", securityException);
      return null;
    } 
    File[] arrayOfFile = i.getSelectedFiles();
    return (arrayOfFile == null || arrayOfFile.length == 0) ? null : arrayOfFile;
  }
  
  private static final void a(int paramInt) {
    switch (paramInt) {
      case 0:
        i.setAcceptAllFileFilterUsed(true);
        i.resetChoosableFileFilters();
        i.addChoosableFileFilter(h);
        if (b == null) {
          i.setFileFilter(h);
        } else {
          i.setFileFilter(b);
        } 
        o.setVisible(false);
        break;
      case 1:
        i.setAcceptAllFileFilterUsed(true);
        i.resetChoosableFileFilters();
        o.setVisible(false);
        i.setSelectedFiles((File[])null);
        break;
      case 2:
        i.setAcceptAllFileFilterUsed(false);
        i.resetChoosableFileFilters();
        i.setFileFilter(a);
        o.setVisible(true);
        break;
      case 3:
        i.setAcceptAllFileFilterUsed(false);
        i.resetChoosableFileFilters();
        i.setFileFilter(a);
        o.setVisible(false);
        break;
    } 
  }
  
  public static final void a(File paramFile) {
    try {
      String str1 = ar.d(new File(System.getProperty("java.io.tmpdir")));
      String str2 = ar.d(paramFile);
      str1 = ar.k(str1);
      str2 = ar.k(str2);
      if (str1.equals(str2))
        return; 
      if (!str1.endsWith("/"))
        str1 = str1 + "/"; 
      if (str2.startsWith(str1))
        return; 
      if (i == null) {
        k = paramFile;
      } else {
        i.setCurrentDirectory(paramFile);
      } 
    } catch (Exception exception) {}
  }
  
  private static final void e() {
    if (e != null)
      return; 
    UIManager.put("FileView.directoryIcon", f.c("dir.png"));
    UIManager.put("FileView.fileIcon", f.c("file.png"));
    UIManager.put("FileView.computerIcon", f.c("computer.png"));
    UIManager.put("FileView.hardDriveIcon", f.c("hard_drive.png"));
    UIManager.put("FileView.floppyDriveIcon", f.c("floppy_drive.png"));
    i = new JFileChooser();
    i.setFileHidingEnabled(true);
    i.setDoubleBuffered(true);
    i.setFileView((FileView)new l());
    e = new JDialog((Frame)f.c, true);
    JPanel jPanel = new JPanel(true);
    GridBagLayout gridBagLayout = new GridBagLayout();
    jPanel.setLayout(gridBagLayout);
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.fill = 1;
    gridBagConstraints.weightx = 1.0D;
    gridBagConstraints.weighty = 1.0D;
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagLayout.setConstraints(i, gridBagConstraints);
    jPanel.add(i);
    o = new JCheckBox("Recreate the directory structure of entries", bg.e);
    gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.weightx = 1.0D;
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.insets = new Insets(0, 6, 6, 6);
    gridBagConstraints.anchor = 13;
    gridBagLayout.setConstraints(o, gridBagConstraints);
    jPanel.add(o);
    e.getContentPane().add(jPanel);
    e.pack();
    f.a(e);
    i.addActionListener(new o());
    e.setDefaultCloseOperation(0);
    e.addWindowListener(new m());
    if (k != null) {
      i.setCurrentDirectory(k);
    } else {
      File file = FileSystemView.getFileSystemView().getHomeDirectory();
      try {
        while (file.getParentFile() != null)
          file = file.getParentFile(); 
        i.setCurrentDirectory(file);
      } catch (Exception exception) {}
    } 
  }
  
  public static final void b(String paramString1, String paramString2) {
    JOptionPane.showMessageDialog((Component)f.c, paramString2, paramString1, 1, p);
  }
  
  public static final void a(String paramString) {
    d(c, paramString);
  }
  
  public static final void b(String paramString, Exception paramException) {
    a(c, paramString, paramException);
  }
  
  public static final void d(String paramString1, String paramString2) {
    JOptionPane.showMessageDialog((Component)f.c, paramString2, paramString1, 0, n);
  }
  
  public static final void a(String paramString1, String paramString2, Exception paramException) {
    d(paramString1, a(paramString2, paramException));
  }
  
  public static final void a(String paramString1, String paramString2, Exception paramException, String paramString3) {
    d(paramString1, a(paramString2, paramException) + "\n" + paramString3);
  }
  
  private static final String a(String paramString, Exception paramException) {
    String str = paramException.getMessage();
    if (str != null && str.length() > 4) {
      if (!str.endsWith(".") && str.indexOf("\n") == -1)
        str = str + "."; 
      char c = str.charAt(0);
      if (Character.isLowerCase(c))
        str = Character.toUpperCase(c) + str.substring(1); 
      return paramString + "\n--> " + str;
    } 
    return paramString;
  }
  
  public static final boolean c(String paramString1, String paramString2) {
    return (0 == JOptionPane.showConfirmDialog((Component)f.c, paramString2, paramString1, 0, 3, g));
  }
  
  public static final int a(String paramString1, String paramString2, int paramInt) {
    switch (paramInt) {
      case 1:
        paramInt = 0;
        break;
      case 2:
        paramInt = 1;
        break;
      default:
        paramInt = 2;
        break;
    } 
    String[] arrayOfString = { "Yes", "No", "Cancel" };
    int i = JOptionPane.showOptionDialog((Component)f.c, paramString2, paramString1, 1, 3, g, (Object[])arrayOfString, arrayOfString[paramInt]);
    switch (i) {
      case 0:
        return 1;
      case 1:
        return 2;
    } 
    return 4;
  }
  
  public static final int c(String paramString1, String paramString2, int paramInt) {
    int i = JOptionPane.showOptionDialog((Component)f.c, paramString2, paramString1, 1, 3, g, (Object[])f, f[paramInt]);
    return (i == -1) ? 4 : i;
  }
  
  public static final int b(String paramString1, String paramString2, int paramInt) {
    switch (paramInt) {
      case 0:
        paramInt = 0;
        break;
      case 1:
        paramInt = 1;
        break;
      default:
        paramInt = 2;
        break;
    } 
    String[] arrayOfString = { "Yes to All", "Yes", "Cancel" };
    int i = JOptionPane.showOptionDialog((Component)f.c, paramString2, paramString1, 1, 3, g, (Object[])arrayOfString, arrayOfString[paramInt]);
    switch (i) {
      case 0:
        return 0;
      case 1:
        return 1;
    } 
    return 4;
  }
  
  public static final int a(String paramString1, String paramString2) {
    String[] arrayOfString = { "Extract (compatible)", "Extract (override)", "Cancel" };
    int i = JOptionPane.showOptionDialog((Component)f.c, paramString2, paramString1, 1, 3, g, (Object[])arrayOfString, arrayOfString[0]);
    switch (i) {
      case 0:
        return 1;
      case 1:
        return 2;
    } 
    return 4;
  }
  
  public static final String a(String paramString1, String paramString2, String paramString3, Icon paramIcon) {
    return (String)JOptionPane.showInputDialog((Component)f.c, paramString2, paramString1, 3, paramIcon, null, paramString3);
  }
  
  static JDialog a() {
    return e;
  }
  
  static JFileChooser b() {
    return i;
  }
  
  static JCheckBox d() {
    return o;
  }
  
  static {
    n = f.c("dialog_error.png");
    g = f.c("dialog_question.png");
    p = f.c("dialog_info.png");
    j = f.c("dir_insert_large.png");
    d = f.c("rename_entry_large.png");
    m = f.c("change_directory_large.png");
    l = f.c("set_modified_large.png");
  }
  
  static {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append('z');
    stringBuffer.append('i');
    stringBuffer.append('p');
    stringBuffer.append('c');
    stringBuffer.append('r');
    stringBuffer.append('e');
    stringBuffer.append('a');
    stringBuffer.append('t');
    stringBuffer.append('o');
    stringBuffer.append('r');
    c = stringBuffer.toString();
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar\\util\aw.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */