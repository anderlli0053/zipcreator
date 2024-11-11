package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.ToolTipManager;
import model.u;
import util.a;
import util.am;
import util.at;
import util.aw;
import util.bd;
import util.be;
import util.bh;
import util.f;
import util.n;
import util.r;

public class o extends JFrame implements bk, ActionListener, u {
  private static final ImageIcon i = f.c("option_yes.png");
  
  private static final ImageIcon f = f.c("option_no.png");
  
  private JMenuItem[] n;
  
  private JMenuItem[] L;
  
  private JComponent E = null;
  
  private boolean J = false;
  
  private gui/e S = null;
  
  private JPopupMenu w;
  
  private JMenu x;
  
  private JMenuItem y;
  
  private JMenuItem r;
  
  private JSeparator A;
  
  private JMenuItem Q;
  
  private JSeparator U;
  
  private JMenuItem u;
  
  private JSeparator k;
  
  private JMenuItem I;
  
  private JMenuItem d;
  
  private JMenuItem e;
  
  private JMenu a;
  
  private JMenuItem M;
  
  private JMenuItem p;
  
  private JSeparator v;
  
  private JMenuItem g;
  
  private JSeparator G;
  
  private JMenu K;
  
  private JMenu m;
  
  private ButtonGroup b;
  
  private ButtonGroup B;
  
  private JToolBar F;
  
  private JButton H;
  
  private JButton j;
  
  private JButton q;
  
  private JButton z;
  
  private JSeparator O;
  
  private JButton s;
  
  private JButton l;
  
  private JSeparator h;
  
  private JButton R;
  
  private JButton o;
  
  private JPanel t;
  
  private JScrollPane C;
  
  public JList N;
  
  static Class P;
  
  public o() {
    super("zipcreator");
    b();
    this.N.setUI(new k());
    m();
    q();
    k();
    e();
    g();
    j();
    i();
    a();
    f();
    o();
    ah.a = this.s;
    h();
    p();
  }
  
  public final void d() {
    ((ah)this.O).a();
    ((ah)this.h).a();
    this.N.setModel(new DefaultListModel());
    try {
      SwingUtilities.updateComponentTreeUI(this);
      SwingUtilities.updateComponentTreeUI(this.w);
      SwingUtilities.updateComponentTreeUI((JComponent)this.N.getCellRenderer());
    } catch (Exception exception) {}
    this.N.setUI(new k());
    this.N.setModel((ListModel)be.d);
    ((ah)this.O).b();
    ((ah)this.h).b();
    o();
    h();
    j();
    a();
    f();
  }
  
  private final void m() {
    bh.a.add(this.H);
    bh.a.add(this.j);
    bh.a.add(this.q);
    bh.a.add(this.z);
    bh.a.add(this.s);
    bh.a.add(this.l);
    bh.a.add(this.R);
    bh.a.add(this.o);
    bh.a.add(this.N);
  }
  
  public final void s() {
    this.j.requestFocus();
  }
  
  public final boolean n() {
    boolean bool = false;
    if (l())
      bool = a(this.F); 
    if (!bool)
      bool = a(this); 
    return bool;
  }
  
  private final boolean a(Container paramContainer) {
    Component[] arrayOfComponent = paramContainer.getComponents();
    for (byte b = 0; b < arrayOfComponent.length; b++) {
      if (arrayOfComponent[b].hasFocus())
        return true; 
      if (arrayOfComponent[b] instanceof Container && a((Container)arrayOfComponent[b]))
        return true; 
    } 
    return false;
  }
  
  private final void j() {
    SwingUtilities.replaceUIInputMap(this.F, 1, null);
    SwingUtilities.replaceUIInputMap(this.C, 1, null);
    SwingUtilities.replaceUIInputMap(this.N, 0, null);
  }
  
  private final void a() {
    this.F.setInputMap(2, getRootPane().getInputMap(2));
    this.F.setActionMap(getRootPane().getActionMap());
  }
  
  private final void b(boolean paramBoolean) {
    if (paramBoolean) {
      InputMap inputMap = getRootPane().getInputMap(2);
      inputMap.put(KeyStroke.getKeyStroke(38, 0), "selectPrevEntry");
      inputMap.put(KeyStroke.getKeyStroke(40, 0), "selectNextEntry");
      inputMap = this.F.getInputMap(2);
      inputMap.put(KeyStroke.getKeyStroke(38, 0), "selectPrevEntry");
      inputMap.put(KeyStroke.getKeyStroke(40, 0), "selectNextEntry");
    } else {
      InputMap inputMap = getRootPane().getInputMap(2);
      inputMap.remove(KeyStroke.getKeyStroke(38, 0));
      inputMap.remove(KeyStroke.getKeyStroke(40, 0));
      inputMap = this.F.getInputMap(2);
      inputMap.remove(KeyStroke.getKeyStroke(38, 0));
      inputMap.remove(KeyStroke.getKeyStroke(40, 0));
    } 
  }
  
  private final void f() {
    KeyListener[] arrayOfKeyListener = (KeyListener[])this.N.getListeners((P == null) ? (P = a("java.awt.event.KeyListener")) : P);
    for (byte b = 0; b < arrayOfKeyListener.length; b++)
      this.N.removeKeyListener(arrayOfKeyListener[b]); 
  }
  
  private final void i() {
    byte b1;
    ak ak = new ak(this, "helpAction");
    Action action1 = a("scrollUp", this.C);
    Action action2 = a("scrollDown", this.C);
    as as = new as(this, "escapeAction");
    aq aq = new aq(this, "cutAction");
    n n = new n(this, "copyAction");
    p p = new p(this, "pasteAction");
    i i = new i(this, "selectPrevEntry");
    a a = new a(this, "selectNextEntry");
    ay ay = new ay(this, "selectPrevAdd");
    az az = new az(this, "selectNextAdd");
    y y = new y(this, "selectPrevRemove");
    t t = new t(this, "selectNextRemove");
    h h = new h(this, "selectFirst");
    b b = new b(this, "selectLast");
    c c = new c(this, "selectFirstAdd");
    f f = new f(this, "selectLastAdd");
    aa aa = new aa(this, "popAction");
    AbstractAction abstractAction1 = b("newAction", this.H);
    AbstractAction abstractAction2 = b("openAction", this.j);
    AbstractAction abstractAction3 = b("saveAction", this.q);
    AbstractAction abstractAction4 = b("saveAsAction", this.z);
    AbstractAction abstractAction5 = b("extractAllAction", this.s);
    AbstractAction abstractAction6 = b("extractAction", this.l);
    AbstractAction abstractAction7 = b("addAction", this.R);
    AbstractAction abstractAction8 = b("removeAction", this.o);
    AbstractAction abstractAction9 = b("selectAll", this.y);
    AbstractAction abstractAction10 = b("deselect", this.r);
    AbstractAction abstractAction11 = b("selectInvert", this.Q);
    AbstractAction abstractAction12 = b("selectBranch", this.u);
    AbstractAction abstractAction13 = a("renameAction", this.I);
    AbstractAction abstractAction14 = a("changeDirAction", this.d);
    AbstractAction abstractAction15 = a("modifiedAction", this.e);
    AbstractAction abstractAction16 = a("deflatedAction", this.M);
    AbstractAction abstractAction17 = a("storedAction", this.p);
    AbstractAction abstractAction18 = a("insertDirAction", this.g);
    InputMap inputMap = getRootPane().getInputMap(2);
    ActionMap actionMap = getRootPane().getActionMap();
    if (a.c) {
      b1 = 4;
    } else {
      b1 = 2;
    } 
    a(inputMap, actionMap, 27, "escapeAction", as);
    if (am.e)
      a(inputMap, actionMap, 88, b1, "cutAction", aq); 
    if (am.d)
      a(inputMap, actionMap, 67, b1, "copyAction", n); 
    if (am.a)
      a(inputMap, actionMap, 86, b1, "pasteAction", p); 
    a(inputMap, actionMap, 38, "selectPrevEntry", i);
    a(inputMap, actionMap, 40, "selectNextEntry", a);
    a(inputMap, actionMap, 38, 8, "selectPrevEntry", i);
    a(inputMap, actionMap, 40, 8, "selectNextEntry", a);
    a(inputMap, actionMap, 38, 1, "selectPrevAdd", ay);
    a(inputMap, actionMap, 40, 1, "selectNextAdd", az);
    a(inputMap, actionMap, 38, b1, "selectPrevRemove", y);
    a(inputMap, actionMap, 40, b1, "selectNextRemove", t);
    a(inputMap, actionMap, 38, b1 + 1, "selectPrevRemove", y);
    a(inputMap, actionMap, 40, b1 + 1, "selectNextRemove", t);
    a(inputMap, actionMap, 65, b1, "selectAll", abstractAction9);
    a(inputMap, actionMap, 47, b1, "selectAll", abstractAction9);
    a(inputMap, actionMap, 92, b1, "deselect", abstractAction10);
    a(inputMap, actionMap, 68, b1, "deselect", abstractAction10);
    a(inputMap, actionMap, 73, b1, "selectInvert", abstractAction11);
    a(inputMap, actionMap, 71, b1, "selectBranch", abstractAction12);
    a(inputMap, actionMap, 33, "scrollUp", action1);
    a(inputMap, actionMap, 34, "scrollDown", action2);
    a(inputMap, actionMap, 33, 1, "scrollUp", action1);
    a(inputMap, actionMap, 34, 1, "scrollDown", action2);
    a(inputMap, actionMap, 36, "selectFirst", h);
    a(inputMap, actionMap, 35, "selectLast", b);
    a(inputMap, actionMap, 36, 1, "selectFirstAdd", c);
    a(inputMap, actionMap, 35, 1, "selectLastAdd", f);
    a(inputMap, actionMap, 112, "helpAction", ak);
    a(inputMap, actionMap, 113, "renameAction", abstractAction13);
    a(inputMap, actionMap, 114, "changeDirAction", abstractAction14);
    a(inputMap, actionMap, 115, "modifiedAction", abstractAction15);
    a(inputMap, actionMap, 116, "deflatedAction", abstractAction16);
    a(inputMap, actionMap, 117, "storedAction", abstractAction17);
    a(inputMap, actionMap, 118, "insertDirAction", abstractAction18);
    a(inputMap, actionMap, 121, "popAction", aa);
    a(inputMap, actionMap, 121, 1, "popAction", aa);
    a(inputMap, actionMap, 0, "popAction", aa);
    a(inputMap, actionMap, 78, b1, "newAction", abstractAction1);
    a(inputMap, actionMap, 78, 8, "newAction", abstractAction1);
    a(inputMap, actionMap, 79, b1, "openAction", abstractAction2);
    a(inputMap, actionMap, 79, 8, "openAction", abstractAction2);
    a(inputMap, actionMap, 83, b1, "saveAction", abstractAction3);
    a(inputMap, actionMap, 83, 8, "saveAction", abstractAction3);
    a(inputMap, actionMap, 65, 8, "saveAsAction", abstractAction4);
    a(inputMap, actionMap, 69, 8, "extractAllAction", abstractAction5);
    a(inputMap, actionMap, 88, 8, "extractAction", abstractAction6);
    a(inputMap, actionMap, 68, 8, "addAction", abstractAction7);
    a(inputMap, actionMap, 155, "addAction", abstractAction7);
    a(inputMap, actionMap, 82, 8, "removeAction", abstractAction8);
    a(inputMap, actionMap, 127, "removeAction", abstractAction8);
    byte b2;
    for (b2 = 65; b2 <= 90; b2++)
      a(inputMap, actionMap, b2); 
    for (b2 = 48; b2 <= 57; b2++)
      a(inputMap, actionMap, b2); 
  }
  
  private final AbstractAction b(String paramString, AbstractButton paramAbstractButton) {
    return new aj(this, paramString, paramAbstractButton);
  }
  
  private final AbstractAction a(String paramString, AbstractButton paramAbstractButton) {
    return new ar(this, paramString, paramAbstractButton);
  }
  
  private final void a(InputMap paramInputMap, ActionMap paramActionMap, int paramInt) {
    String str1 = KeyEvent.getKeyText(paramInt);
    if (str1.length() != 1)
      return; 
    String str2 = "" + str1.charAt(0);
    String str3 = "selectNextLetter-" + str1;
    ad ad = new ad(this, str3, str2);
    a(paramInputMap, paramActionMap, paramInt, str3, ad);
    str3 = "selectPrevLetter-" + str1;
    bh bh = new bh(this, str3, str2);
    a(paramInputMap, paramActionMap, paramInt, 1, str3, bh);
  }
  
  private final void a(InputMap paramInputMap, ActionMap paramActionMap, int paramInt, String paramString, Action paramAction) {
    a(paramInputMap, paramActionMap, paramInt, 0, paramString, paramAction);
  }
  
  private final void a(InputMap paramInputMap, ActionMap paramActionMap, int paramInt1, int paramInt2, String paramString, Action paramAction) {
    if (paramAction != null) {
      KeyStroke keyStroke = KeyStroke.getKeyStroke(paramInt1, paramInt2);
      paramInputMap.put(keyStroke, paramString);
      paramActionMap.put(paramString, paramAction);
    } 
  }
  
  private final Action a(String paramString, JComponent paramJComponent) {
    Action action = paramJComponent.getActionMap().get(paramString);
    return new bm(this, paramString, paramJComponent, action);
  }
  
  private final void g() {
    f.a(this.H, "new");
    f.a(this.j, "open");
    f.a(this.q, "save");
    f.a(this.z, "saveas");
    f.a(this.s, "extractall");
    f.a(this.l, "extract");
    f.a(this.R, "add");
    f.a(this.o, "remove");
    f.a(this.x, "selection");
    f.a(this.y, "select");
    f.a(this.r, "deselect");
    f.a(this.Q, "select_invert");
    f.a(this.u, "select_branch");
    f.a(this.I, "rename_entry");
    f.a(this.d, "change_directory");
    f.a(this.e, "set_modified");
    f.a(this.a, "set_method");
    f.a(this.g, "dir_insert");
    f.a(this.K, "font_size");
    f.a(this.m, "sort_by");
  }
  
  private final void o() {
    f.a(this.H);
    f.a(this.j);
    f.a(this.q);
    f.a(this.z);
    f.a(this.s);
    f.a(this.l);
    f.a(this.R);
    f.a(this.o);
  }
  
  private final void h() {
    ((ah)this.O).c();
    ((ah)this.h).c();
  }
  
  private final void q() {
    at.f.addListSelectionListener(new ap(this));
    this.w.addPopupMenuListener(new bl(this));
    ToolTipManager toolTipManager = ToolTipManager.sharedInstance();
    this.N.addMouseListener(new ao(this, toolTipManager));
  }
  
  private final void k() {
    this.n = new JMenuItem[T.length];
    for (byte b = 0; b < T.length; b++) {
      JMenuItem jMenuItem = new JMenuItem(T[b]);
      jMenuItem.setActionCommand("size." + T[b]);
      jMenuItem.addActionListener(this);
      jMenuItem.setIcon((D[b] == bf.l) ? i : f);
      this.n[b] = jMenuItem;
      this.B.add(jMenuItem);
      this.K.add(jMenuItem);
    } 
  }
  
  private final void e() {
    this.L = new JMenuItem[c.length];
    for (byte b = 0; b < c.length; b++) {
      JMenuItem jMenuItem = new JMenuItem(c[b]);
      jMenuItem.setActionCommand("sort." + c[b]);
      jMenuItem.addActionListener(this);
      jMenuItem.setIcon((b == 1) ? i : f);
      this.L[b] = jMenuItem;
      this.b.add(jMenuItem);
      this.m.add(jMenuItem);
    } 
  }
  
  private void b() {
    this.w = new JPopupMenu();
    this.x = new JMenu();
    this.y = new JMenuItem();
    this.r = new JMenuItem();
    this.A = new JSeparator();
    this.Q = new JMenuItem();
    this.U = new JSeparator();
    this.u = new JMenuItem();
    this.k = new JSeparator();
    this.I = new JMenuItem();
    this.d = new JMenuItem();
    this.e = new JMenuItem();
    this.a = new JMenu();
    this.M = new JMenuItem();
    this.p = new JMenuItem();
    this.v = new JSeparator();
    this.g = new JMenuItem();
    this.G = new JSeparator();
    this.K = new JMenu();
    this.m = new JMenu();
    this.b = new ButtonGroup();
    this.B = new ButtonGroup();
    this.F = new JToolBar();
    this.H = new JButton();
    this.j = new JButton();
    this.q = new JButton();
    this.z = new JButton();
    this.O = new ah(this.F);
    this.s = new JButton();
    this.l = new JButton();
    this.h = new ah(this.F);
    this.R = new JButton();
    this.o = new JButton();
    this.t = new JPanel();
    this.C = new JScrollPane();
    this.N = new JList();
    this.x.setText("Selection");
    this.y.setText("Select all");
    this.y.addActionListener(new ac(this));
    this.x.add(this.y);
    this.r.setText("Deselect");
    this.r.addActionListener(new v(this));
    this.x.add(this.r);
    this.x.add(this.A);
    this.Q.setText("Invert");
    this.Q.addActionListener(new ba(this));
    this.x.add(this.Q);
    this.x.add(this.U);
    this.u.setText("Similar path");
    this.u.addActionListener(new g(this));
    this.x.add(this.u);
    this.w.add(this.x);
    this.w.add(this.k);
    this.I.setText("Rename entry...");
    this.I.addActionListener(new d(this));
    this.w.add(this.I);
    this.d.setText("Change directory...");
    this.d.addActionListener(new bc(this));
    this.w.add(this.d);
    this.e.setText("Change modified date...");
    this.e.addActionListener(new au(this));
    this.w.add(this.e);
    this.a.setText("Storage method");
    this.M.setText("Compressed");
    this.M.setIcon(f.c("compressed.png"));
    this.M.addActionListener(new al(this));
    this.a.add(this.M);
    this.p.setText("Uncompressed");
    this.p.setIcon(f.c("uncompressed.png"));
    this.p.addActionListener(new ax(this));
    this.a.add(this.p);
    this.w.add(this.a);
    this.w.add(this.v);
    this.g.setText("New directory...");
    this.g.addActionListener(new am(this));
    this.w.add(this.g);
    this.w.add(this.G);
    this.K.setText("Text size");
    this.w.add(this.K);
    this.m.setText("Sort by");
    this.w.add(this.m);
    setDefaultCloseOperation(0);
    setIconImage(f.i);
    addWindowListener(new s(this));
    this.F.setName("zipcreator");
    this.H.setMnemonic('n');
    this.H.setText("New");
    this.H.setToolTipText("New zip");
    this.H.addActionListener(new u(this));
    this.F.add(this.H);
    this.j.setMnemonic('o');
    this.j.setText("Open");
    this.j.setToolTipText("Open an existing zip file");
    this.j.addActionListener(new ag(this));
    this.F.add(this.j);
    this.q.setMnemonic('s');
    this.q.setText("Save");
    this.q.setToolTipText("Save zip");
    this.q.addActionListener(new r(this));
    this.F.add(this.q);
    this.z.setMnemonic('a');
    this.z.setText("Save As");
    this.z.setToolTipText("Save as");
    this.z.addActionListener(new w(this));
    this.F.add(this.z);
    this.O.setAlignmentX(0.0F);
    this.F.add(this.O);
    this.s.setMnemonic('e');
    this.s.setText("Extract All");
    this.s.setToolTipText("Extract all entries");
    this.s.addActionListener(new ab(this));
    this.F.add(this.s);
    this.l.setMnemonic('x');
    this.l.setText("Extract");
    this.l.setToolTipText("Extract the selected entries");
    this.l.addActionListener(new z(this));
    this.F.add(this.l);
    this.h.setAlignmentX(0.0F);
    this.F.add(this.h);
    this.R.setMnemonic('d');
    this.R.setText("Add");
    this.R.setToolTipText("Add one or more entries");
    this.R.addActionListener(new bg(this));
    this.F.add(this.R);
    this.o.setMnemonic('r');
    this.o.setText("Remove");
    this.o.setToolTipText("Remove selected entries");
    this.o.addActionListener(new bb(this));
    this.F.add(this.o);
    getContentPane().add(this.F, "North");
    this.t.setLayout(new BorderLayout());
    this.C.setVerticalScrollBarPolicy(22);
    this.N.setModel((ListModel)be.d);
    this.N.setCellRenderer(new x());
    this.N.setDoubleBuffered(true);
    this.N.setSelectionModel(at.f);
    this.N.setVisibleRowCount(15);
    this.N.setAutoscrolls(false);
    this.N.addMouseListener(new bd(this));
    this.C.setViewportView(this.N);
    this.t.add(this.C, "Center");
    getContentPane().add(this.t, "Center");
    setSize(new Dimension(720, 420));
  }
  
  private void g(ActionEvent paramActionEvent) {
    at.j();
  }
  
  private void c(ActionEvent paramActionEvent) {
    at.d();
  }
  
  private void k(ActionEvent paramActionEvent) {
    at.l();
  }
  
  private void r(ActionEvent paramActionEvent) {
    at.b();
  }
  
  private void a(WindowEvent paramWindowEvent) {
    a.b();
  }
  
  private void l(ActionEvent paramActionEvent) {
    n.n().c();
  }
  
  private void h(ActionEvent paramActionEvent) {
    n.d().c();
  }
  
  private void n(ActionEvent paramActionEvent) {
    n.y().c();
  }
  
  private void a(ActionEvent paramActionEvent) {
    n.q().c();
  }
  
  private void j(ActionEvent paramActionEvent) {
    n.a(false).c();
  }
  
  private void m(ActionEvent paramActionEvent) {
    n.a(true).c();
  }
  
  private void b(MouseEvent paramMouseEvent) {
    c(paramMouseEvent);
  }
  
  private void a(MouseEvent paramMouseEvent) {
    c(paramMouseEvent);
  }
  
  private void i(ActionEvent paramActionEvent) {
    n.u().c();
  }
  
  private void o(ActionEvent paramActionEvent) {
    File[] arrayOfFile = aw.a("Add file or directory", "Add", 2, 1);
    if (arrayOfFile != null)
      n.a(arrayOfFile).c(); 
  }
  
  private void e(ActionEvent paramActionEvent) {
    File file = aw.b("Extract to directory", "Extract", 1, 2);
    if (file != null)
      n.a(file).c(); 
  }
  
  private void p(ActionEvent paramActionEvent) {
    File file = aw.b("Extract all to directory", "Extract", 1, 2);
    if (file != null)
      n.b(file).c(); 
  }
  
  private void q(ActionEvent paramActionEvent) {
    File file = aw.b("Save zip file", "Save", 0, 0);
    if (file != null)
      n.c(file).c(); 
  }
  
  private void f(ActionEvent paramActionEvent) {
    n.m().c();
  }
  
  private void b(ActionEvent paramActionEvent) {
    bd.d();
  }
  
  private void d(ActionEvent paramActionEvent) {
    bd.b();
  }
  
  public final JScrollBar r() {
    return this.C.getVerticalScrollBar();
  }
  
  public final JToolBar c() {
    return this.F;
  }
  
  private final void c(MouseEvent paramMouseEvent) {
    if (paramMouseEvent.isPopupTrigger())
      this.w.show(paramMouseEvent.getComponent(), paramMouseEvent.getX(), paramMouseEvent.getY()); 
  }
  
  public final void actionPerformed(ActionEvent paramActionEvent) {
    String str = paramActionEvent.getActionCommand();
    if (str.startsWith("size.")) {
      String str1 = str.substring(5);
      int i = D[1];
      for (byte b = 0; b < T.length; b++) {
        if (str1.equals(T[b])) {
          i = D[b];
          this.n[b].setIcon(i);
        } else {
          this.n[b].setIcon(f);
        } 
      } 
      if (i == bf.a())
        return; 
      n.b(i).c();
    } else if (str.startsWith("sort.")) {
      String str1 = str.substring(5);
      byte b1 = 1;
      for (byte b2 = 0; b2 < c.length; b2++) {
        if (str1.equals(c[b2])) {
          b1 = b2;
          this.L[b2].setIcon(i);
        } else {
          this.L[b2].setIcon(f);
        } 
      } 
      if (b1 == be.d.e())
        return; 
      n.a(b1).c();
    } 
  }
  
  public final void a(boolean paramBoolean) {
    this.J = paramBoolean;
    if (paramBoolean) {
      try {
        this.E = (JComponent)getFocusOwner();
      } catch (Exception exception) {
        this.E = null;
      } 
      this.H.setEnabled(false);
      this.j.setEnabled(false);
      this.q.setEnabled(false);
      this.z.setEnabled(false);
      this.s.setEnabled(false);
      this.l.setEnabled(false);
      this.R.setEnabled(false);
      this.o.setEnabled(false);
      this.N.setEnabled(false);
      this.y.setEnabled(false);
      this.r.setEnabled(false);
      this.Q.setEnabled(false);
      this.u.setEnabled(false);
      this.I.setEnabled(false);
      this.d.setEnabled(false);
      this.e.setEnabled(false);
      this.a.setEnabled(false);
      this.M.setEnabled(false);
      this.p.setEnabled(false);
      this.g.setEnabled(false);
      this.m.setEnabled(false);
      this.K.setEnabled(false);
      r().requestFocus();
    } else {
      this.H.setEnabled(true);
      this.j.setEnabled(true);
      this.R.setEnabled(true);
      this.N.setEnabled(true);
      p();
      this.g.setEnabled(true);
      this.m.setEnabled(true);
      this.K.setEnabled(true);
      if (this.E != null && this.E.isEnabled()) {
        this.E.requestFocus();
      } else {
        this.N.requestFocus();
      } 
    } 
  }
  
  public final void p() {
    int i = be.d.getSize();
    boolean bool = (i > 0) ? true : false;
    int j = 0;
    if (bool)
      j = at.m(); 
    boolean bool1 = (be.b && bool && r.c());
    if (this.q.isEnabled() != bool1)
      this.q.setEnabled(bool1); 
    bool1 = bool;
    if (this.z.isEnabled() != bool1)
      this.z.setEnabled(bool1); 
    bool1 = (j < i);
    if (this.y.isEnabled() != bool1)
      this.y.setEnabled(bool1); 
    bool1 = (j > 0);
    if (this.r.isEnabled() != bool1)
      this.r.setEnabled(bool1); 
    bool1 = (j > 0 && j < i);
    if (this.Q.isEnabled() != bool1)
      this.Q.setEnabled(bool1); 
    bool1 = (j > 0 && j < i);
    if (this.u.isEnabled() != bool1)
      this.u.setEnabled(bool1); 
    bool1 = (bool && j == 1);
    if (this.I.isEnabled() != bool1)
      this.I.setEnabled(bool1); 
    bool1 = bool;
    if (this.s.isEnabled() != bool1)
      this.s.setEnabled(bool1); 
    bool1 = (bool && j > 0);
    if (this.o.isEnabled() != bool1)
      this.o.setEnabled(bool1); 
    if (this.d.isEnabled() != bool1)
      this.d.setEnabled(bool1); 
    if (this.e.isEnabled() != bool1)
      this.e.setEnabled(bool1); 
    bool1 = (bool1 && at.c());
    if (this.l.isEnabled() != bool1)
      this.l.setEnabled(bool1); 
    if (this.a.isEnabled() != bool1)
      this.a.setEnabled(bool1); 
    if (this.M.isEnabled() != bool1)
      this.M.setEnabled(bool1); 
    if (this.p.isEnabled() != bool1)
      this.p.setEnabled(bool1); 
    f.b();
  }
  
  public final boolean l() {
    return (getRootPane() != this.F.getRootPane());
  }
  
  private final void a(boolean paramBoolean, String paramString) {
    if (this.S == null)
      this.S = new gui/e(this); 
    this.S.d = paramBoolean;
    this.S.a = paramString;
    this.S.c = System.currentTimeMillis();
  }
  
  static Class a(String paramString) {
    try {
      return Class.forName(paramString);
    } catch (ClassNotFoundException classNotFoundException) {
      throw new NoClassDefFoundError(classNotFoundException.getMessage());
    } 
  }
  
  static JPopupMenu a(o paramo) {
    return paramo.w;
  }
  
  static boolean b(o paramo) {
    return paramo.J;
  }
  
  static void b(o paramo, MouseEvent paramMouseEvent) {
    paramo.c(paramMouseEvent);
  }
  
  static void a(o paramo, boolean paramBoolean, String paramString) {
    paramo.a(paramBoolean, paramString);
  }
  
  static void a(o paramo, boolean paramBoolean) {
    paramo.b(paramBoolean);
  }
  
  static void l(o paramo, ActionEvent paramActionEvent) {
    paramo.k(paramActionEvent);
  }
  
  static void f(o paramo, ActionEvent paramActionEvent) {
    paramo.r(paramActionEvent);
  }
  
  static void c(o paramo, ActionEvent paramActionEvent) {
    paramo.c(paramActionEvent);
  }
  
  static void r(o paramo, ActionEvent paramActionEvent) {
    paramo.g(paramActionEvent);
  }
  
  static void n(o paramo, ActionEvent paramActionEvent) {
    paramo.h(paramActionEvent);
  }
  
  static void h(o paramo, ActionEvent paramActionEvent) {
    paramo.l(paramActionEvent);
  }
  
  static void a(o paramo, ActionEvent paramActionEvent) {
    paramo.a(paramActionEvent);
  }
  
  static void i(o paramo, ActionEvent paramActionEvent) {
    paramo.j(paramActionEvent);
  }
  
  static void g(o paramo, ActionEvent paramActionEvent) {
    paramo.m(paramActionEvent);
  }
  
  static void p(o paramo, ActionEvent paramActionEvent) {
    paramo.n(paramActionEvent);
  }
  
  static void a(o paramo, WindowEvent paramWindowEvent) {
    paramo.a(paramWindowEvent);
  }
  
  static void j(o paramo, ActionEvent paramActionEvent) {
    paramo.d(paramActionEvent);
  }
  
  static void b(o paramo, ActionEvent paramActionEvent) {
    paramo.b(paramActionEvent);
  }
  
  static void e(o paramo, ActionEvent paramActionEvent) {
    paramo.f(paramActionEvent);
  }
  
  static void k(o paramo, ActionEvent paramActionEvent) {
    paramo.q(paramActionEvent);
  }
  
  static void d(o paramo, ActionEvent paramActionEvent) {
    paramo.p(paramActionEvent);
  }
  
  static void q(o paramo, ActionEvent paramActionEvent) {
    paramo.e(paramActionEvent);
  }
  
  static void m(o paramo, ActionEvent paramActionEvent) {
    paramo.o(paramActionEvent);
  }
  
  static void o(o paramo, ActionEvent paramActionEvent) {
    paramo.i(paramActionEvent);
  }
  
  static void c(o paramo, MouseEvent paramMouseEvent) {
    paramo.a(paramMouseEvent);
  }
  
  static void a(o paramo, MouseEvent paramMouseEvent) {
    paramo.b(paramMouseEvent);
  }
  
  private final class gui/e extends Timer implements ActionListener {
    public boolean d;
    
    public String a;
    
    public long c;
    
    private long b;
    
    private final o e;
    
    public gui/e(o this$0) {
      super(50, null);
      this.e = this$0;
      this.d = true;
      this.a = null;
      this.c = 0L;
      this.b = -1L;
      setCoalesce(true);
      addActionListener(this);
      start();
    }
    
    public void actionPerformed(ActionEvent param1ActionEvent) {
      boolean bool = false;
      long l = this.c;
      if (this.c > this.b) {
        stop();
        bool = true;
        int i = be.d.b.length();
        if (i > 0) {
          int j = this.e.N.getLeadSelectionIndex();
          int k = -1;
          if (this.d && j < i - 1) {
            k = be.d.b.indexOf(this.a, j + 1);
          } else if (!this.d && j > 0) {
            k = be.d.b.lastIndexOf(this.a, j - 1);
          } 
          if (k > -1) {
            this.e.N.setSelectionInterval(k, k);
            this.e.N.ensureIndexIsVisible(k);
          } 
        } 
      } 
      this.b = l;
      if (bool)
        restart(); 
    }
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\o.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */