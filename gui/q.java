package gui;

class q extends av {
  public final void run() {
    long l1 = be.a() + 3800L;
    for (long l2 = System.currentTimeMillis(); l2 < l1; l2 = System.currentTimeMillis()) {
      try {
        Thread.currentThread();
        Thread.sleep(l1 - l2);
      } catch (InterruptedException interruptedException) {}
      l1 = be.a() + 3800L;
    } 
    be.j();
  }
}


/* Location:              C:\Users\ander\Downloads\zipcreator.jar!\gui\q.class
 * Java compiler version: 3 (47.0)
 * JD-Core Version:       1.1.3
 */