package com.etixapp.java.base.basics.nested;

public class OuterClassStaticExample {

  // static member
  static int outer_x = 10;

  // instance(non-static) member
  int outer_y = 20; // this is not visible in the static nested class

  // private member
  private static int outer_private = 30;

  // static nested class
  // !!! it should be defined as public, otherwise it will not work
  public static class StaticNestedClass {
    // !!! it should be defined as public, otherwise it will not work
    public void display()
    {
      // can access static member of outer class
      System.out.println("outer_x = " + outer_x);

      // can access private static member of
      // outer class
      System.out.println("outer_private = "
          + outer_private);

      // The following statement will give compilation
      // error as static nested class cannot directly
      // access non-static members
      // System.out.println("outer_y = " + outer_y);

      // Therefore create object of the outer class
      // to access the non-static member
      OuterClassStaticExample out = new OuterClassStaticExample();
      System.out.println("outer_y = " + out.outer_y);


    }
  }

}
