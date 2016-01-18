package com.epam.memory.stack;

public class Parent
{
  private Child child;

  public Parent()
  {
    this.child = new Child();
  }

  public Child getChild() {
    return child;
  }

  public void setChild( Child child ) {
    this.child = child;
  }
}
