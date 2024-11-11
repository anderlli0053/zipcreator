package gui;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.s;
import util.ar;
import util.be;

public class bj implements ListSelectionModel {
  private EventListenerList g = new EventListenerList();
  
  private int e = -1;
  
  private int b = -1;
  
  private boolean h = false;
  
  private int a = Integer.MAX_VALUE;
  
  private int c = -1;
  
  private int j = Integer.MAX_VALUE;
  
  private int d = -1;
  
  private BitSet f = new BitSet(1024);
  
  static Class i;
  
  public final void setSelectionMode(int paramInt) {
    if (paramInt != 2)
      throw new IllegalArgumentException(); 
  }
  
  public final int getSelectionMode() {
    return 2;
  }
  
  public final int getMinSelectionIndex() {
    return isSelectionEmpty() ? -1 : this.a;
  }
  
  public final int getMaxSelectionIndex() {
    return this.c;
  }
  
  public final boolean isSelectedIndex(int paramInt) {
    return (paramInt < this.a || paramInt > this.c) ? false : this.f.get(paramInt);
  }
  
  public final boolean isSelectionEmpty() {
    return (this.a > this.c);
  }
  
  public final void setSelectionInterval(int paramInt1, int paramInt2) {
    if (paramInt1 == -1 || paramInt2 == -1)
      return; 
    c(paramInt1, paramInt2);
    int i = b(paramInt1, paramInt2);
    int j = d(paramInt1, paramInt2);
    j = b(j);
    int k;
    for (k = this.a; k < i; k++)
      this.f.clear(k); 
    for (k = i; k <= j; k++)
      this.f.set(k); 
    for (k = j + 1; k <= this.c; k++)
      this.f.clear(k); 
    this.j = a(this.j, this.a, i);
    this.d = b(this.d, this.c, j);
    this.a = i;
    this.c = j;
    j();
  }
  
  public final void addSelectionInterval(int paramInt1, int paramInt2) {
    if (paramInt1 == -1 || paramInt2 == -1)
      return; 
    c(paramInt1, paramInt2);
    int i = b(paramInt1, paramInt2);
    int j = d(paramInt1, paramInt2);
    j = b(j);
    int k = Integer.MAX_VALUE;
    int m = -1;
    for (int n = i; n <= j; n++) {
      if (!this.f.get(n)) {
        k = b(k, n);
        m = d(m, n);
      } 
      this.f.set(n);
    } 
    this.j = b(this.j, k);
    this.d = d(this.d, m);
    this.a = b(this.a, i);
    this.c = d(this.c, j);
    j();
  }
  
  public final void removeSelectionInterval(int paramInt1, int paramInt2) {
    if (paramInt1 == -1 || paramInt2 == -1)
      return; 
    c(paramInt1, paramInt2);
    int i = b(paramInt1, paramInt2);
    int j = d(paramInt1, paramInt2);
    j = b(j);
    int k = Integer.MAX_VALUE;
    int m = -1;
    int n;
    for (n = i; n <= j; n++) {
      if (this.f.get(n)) {
        k = b(k, n);
        m = d(m, n);
      } 
      this.f.clear(n);
    } 
    this.j = b(this.j, k);
    this.d = d(this.d, m);
    if (this.a >= i && this.c <= j) {
      this.a = Integer.MAX_VALUE;
      this.c = -1;
    } else {
      for (n = this.a; n <= this.c; n++) {
        if (this.f.get(n)) {
          this.a = n;
          break;
        } 
      } 
      for (n = this.c; n >= this.a; n--) {
        if (this.f.get(n)) {
          this.c = n;
          break;
        } 
      } 
    } 
    j();
  }
  
  public final void clearSelection() {
    removeSelectionInterval(this.a, this.c);
  }
  
  public final void setValueIsAdjusting(boolean paramBoolean) {
    if (paramBoolean != this.h) {
      this.h = paramBoolean;
      j();
    } 
  }
  
  public final boolean getValueIsAdjusting() {
    return this.h;
  }
  
  public final void setAnchorSelectionIndex(int paramInt) {
    c(paramInt, this.b);
    this.e = paramInt;
    j();
  }
  
  public final int getAnchorSelectionIndex() {
    return this.e;
  }
  
  public final void setLeadSelectionIndex(int paramInt) {
    c(this.e, paramInt);
    this.b = paramInt;
    j();
  }
  
  public final int getLeadSelectionIndex() {
    return this.b;
  }
  
  public final void insertIndexInterval(int paramInt1, int paramInt2, boolean paramBoolean) {
    if (isSelectionEmpty())
      return; 
    int i = paramBoolean ? paramInt1 : (paramInt1 + 1);
    int j = i + paramInt2 - 1;
    for (int k = this.c; k >= i; k--)
      a(k + paramInt2, this.f.get(k)); 
    boolean bool = this.f.get(paramInt1);
    for (int m = i; m <= j; m++)
      a(m, bool); 
  }
  
  public final void removeIndexInterval(int paramInt1, int paramInt2) {
    if (isSelectionEmpty())
      return; 
    int i = b(paramInt1, paramInt2);
    int j = d(paramInt1, paramInt2);
    int k = j - i + 1;
    for (int m = i; m <= this.c; m++)
      a(m, this.f.get(m + k)); 
  }
  
  public final void addListSelectionListener(ListSelectionListener paramListSelectionListener) {
    this.g.add((i == null) ? (i = a("javax.swing.event.ListSelectionListener")) : i, paramListSelectionListener);
  }
  
  public final void removeListSelectionListener(ListSelectionListener paramListSelectionListener) {
    this.g.remove((i == null) ? (i = a("javax.swing.event.ListSelectionListener")) : i, paramListSelectionListener);
  }
  
  private final void j() {
    if (this.d == -1)
      return; 
    int i = this.j;
    int j = this.d;
    this.j = Integer.MAX_VALUE;
    this.d = -1;
    a(i, j);
  }
  
  private final void a(int paramInt1, int paramInt2) {
    Object[] arrayOfObject = this.g.getListenerList();
    ListSelectionEvent listSelectionEvent = null;
    for (int i = arrayOfObject.length - 2; i >= 0; i -= 2) {
      if (arrayOfObject[i] == ((i == null) ? (i = a("javax.swing.event.ListSelectionListener")) : i)) {
        if (listSelectionEvent == null)
          listSelectionEvent = new ListSelectionEvent(this, paramInt1, paramInt2, this.h); 
        ListSelectionListener listSelectionListener = (ListSelectionListener)arrayOfObject[i + 1];
        listSelectionListener.valueChanged(listSelectionEvent);
      } 
    } 
  }
  
  private final void c(int paramInt1, int paramInt2) {
    if (this.e != paramInt1) {
      if (this.e != -1)
        a(this.e); 
      a(paramInt1);
    } 
    if (this.b != paramInt2) {
      if (this.b != -1)
        a(this.b); 
      a(paramInt2);
    } 
    this.e = paramInt1;
    this.b = paramInt2;
  }
  
  private final void a(int paramInt) {
    this.j = b(this.j, paramInt);
    this.d = d(this.d, paramInt);
  }
  
  private final void a(int paramInt, boolean paramBoolean) {
    if (paramBoolean) {
      c(paramInt);
    } else {
      d(paramInt);
    } 
  }
  
  private final void c(int paramInt) {
    if (this.f.get(paramInt))
      return; 
    this.f.set(paramInt);
    a(paramInt);
    this.a = b(this.a, paramInt);
    this.c = d(this.c, paramInt);
  }
  
  private final void d(int paramInt) {
    if (!this.f.get(paramInt))
      return; 
    this.f.clear(paramInt);
    a(paramInt);
    if (this.a == paramInt && this.c == paramInt) {
      this.a = Integer.MAX_VALUE;
      this.c = -1;
    } else if (paramInt == this.a) {
      this.a++;
      while (this.a <= this.c && !this.f.get(this.a))
        this.a++; 
    } else if (paramInt == this.c) {
      this.c--;
      while (this.a <= this.c && !this.f.get(this.c))
        this.c--; 
    } 
  }
  
  public final void b() {
    this.e = -1;
    this.b = -1;
    this.a = Integer.MAX_VALUE;
    this.c = -1;
    this.j = b(this.j, this.a);
    this.d = d(this.d, this.c);
    for (byte b = 0; b < this.f.length(); b++)
      this.f.clear(b); 
    this.h = false;
    j();
  }
  
  public final void c() {
    int i = be.d.getSize();
    this.a = 0;
    this.c = i - 1;
    int j = Integer.MAX_VALUE;
    int k = -1;
    for (int m = this.a; m <= this.c; m++) {
      if (!this.f.get(m)) {
        j = b(j, m);
        k = d(k, m);
        this.f.set(m);
      } 
    } 
    c(this.b, this.b);
    this.j = b(this.j, j);
    this.d = d(this.d, k);
    this.h = false;
    j();
  }
  
  public final void a() {
    int i = be.d.getSize();
    this.j = 0;
    this.d = d(this.d, i - 1);
    this.a = Integer.MAX_VALUE;
    this.c = -1;
    for (byte b = 0; b < i; b++) {
      boolean bool = !this.f.get(b) ? true : false;
      a(b, bool);
      if (bool) {
        this.a = b(this.a, b);
        this.c = d(this.c, b);
      } 
    } 
    c(this.b, this.b);
    this.h = false;
    j();
  }
  
  public final void e() {
    if (isSelectionEmpty())
      return; 
    this.j = b(this.j, this.a);
    this.d = d(this.d, this.c);
    this.a = Integer.MAX_VALUE;
    this.c = -1;
    for (byte b = 0; b < this.f.length(); b++)
      this.f.clear(b); 
    c(this.b, this.b);
    this.h = false;
    j();
  }
  
  public final int h() {
    if (isSelectionEmpty())
      return 0; 
    byte b = 0;
    for (int i = this.a; i <= this.c; i++) {
      if (this.f.get(i))
        b++; 
    } 
    return b;
  }
  
  public final boolean g() {
    for (int i = this.a; i <= this.c; i++) {
      if (this.f.get(i)) {
        Object object = be.d.getElementAt(i);
        if (object instanceof model.e)
          return true; 
      } 
    } 
    return false;
  }
  
  public final s i() {
    return isSelectionEmpty() ? null : (s)be.d.getElementAt(getMinSelectionIndex());
  }
  
  public final void e(int paramInt) {
    if (paramInt < 0) {
      clearSelection();
    } else {
      setSelectionInterval(paramInt, paramInt);
    } 
  }
  
  public final List f() {
    ArrayList arrayList = new ArrayList();
    for (int i = this.a; i <= this.c; i++) {
      if (this.f.get(i)) {
        Object object = be.d.getElementAt(i);
        if (object != null)
          arrayList.add(object); 
      } 
    } 
    return arrayList;
  }
  
  public final List d() {
    ArrayList arrayList = new ArrayList();
    for (int i = this.a; i <= this.c; i++) {
      if (this.f.get(i)) {
        Object object = be.d.getElementAt(i);
        if (object != null && object instanceof model.e)
          arrayList.add(object); 
      } 
    } 
    return arrayList;
  }
  
  public final void a(List paramList) {
    if (paramList == null || paramList.size() == 0) {
      clearSelection();
      return;
    } 
    List list = be.d.a();
    int i = list.size();
    BitSet bitSet = new BitSet(i);
    ar.b(paramList);
    int j = paramList.size();
    byte b = 0;
    int k;
    for (k = 0; k < i && b < j; k++) {
      if (list.get(k).equals(paramList.get(b))) {
        bitSet.set(k);
        b++;
      } 
    } 
    a(bitSet);
    k = getMinSelectionIndex();
    c(k, k);
    this.h = false;
    j();
  }
  
  public final void b(String paramString) {
    if (paramString == null || paramString.equals("")) {
      c();
      return;
    } 
    List list = be.d.a.h(paramString);
    List list1 = be.d.a();
    int i = list1.size();
    BitSet bitSet = new BitSet(i);
    ar.b(list);
    int j = list.size();
    byte b1 = 0;
    for (byte b2 = 0; b2 < i && b1 < j; b2++) {
      if (list1.get(b2).equals(list.get(b1))) {
        bitSet.set(b2);
        b1++;
      } 
    } 
    a(bitSet);
    c(this.b, this.b);
    this.h = false;
    j();
  }
  
  private final void a(BitSet paramBitSet) {
    this.a = Integer.MAX_VALUE;
    this.c = -1;
    int i = d(paramBitSet.length(), this.f.length());
    for (byte b = 0; b < i; b++) {
      if (paramBitSet.get(b) && this.f.get(b)) {
        this.a = b(this.a, b);
        this.c = b;
      } else {
        if (paramBitSet.get(b)) {
          this.f.set(b);
          this.a = b(this.a, b);
          this.c = b;
        } else {
          this.f.clear(b);
        } 
        this.j = b(this.j, b);
        this.d = d(this.d, b);
      } 
    } 
  }
  
  public final int[] k() {
    int[] arrayOfInt = new int[h()];
    byte b = 0;
    for (int i = this.a; i <= this.c; i++) {
      if (this.f.get(i)) {
        arrayOfInt[b] = i;
        b++;
      } 
    } 
    return arrayOfInt;
  }
  
  private static final int b(int paramInt1, int paramInt2) {
    return Math.min(paramInt1, paramInt2);
  }
  
  private static final int a(int paramInt1, int paramInt2, int paramInt3) {
    return b(b(paramInt1, paramInt2), paramInt3);
  }
  
  private static final int d(int paramInt1, int paramInt2) {
    return Math.max(paramInt1, paramInt2);
  }
  
  private static final int b(int paramInt1, int paramInt2, int paramInt3) {
    return d(d(paramInt1, paramInt2), paramInt3);
  }
  
  private static final int b(int paramInt) {
    return b(paramInt, be.d.getSize());
  }
  
  static Class a(String paramString) {
    try {
      return Class.forName(paramString);
    } catch (ClassNotFoundException classNotFoundException) {
      throw new NoClassDefFoundError(classNotFoundException.getMessage());
    } 
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\bj.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */