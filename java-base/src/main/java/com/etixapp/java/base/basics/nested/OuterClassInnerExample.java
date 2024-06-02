package com.etixapp.java.base.basics.nested;

public class OuterClassInnerExample {
  // static member
  static int outer_x = 10;

  // instance(non-static) member
  int outer_y = 20;

  // private member
  private int outer_private = 30;

  // inner class
  public class InnerClass {
    public void display()
    {
      // can access static member of outer class
      System.out.println("outer_x = " + outer_x);

      // can also access non-static member of outer
      // class
      System.out.println("outer_y = " + outer_y);

      // can also access a private member of the outer
      // class
      System.out.println("outer_private = "
          + outer_private);
    }
  }
}
