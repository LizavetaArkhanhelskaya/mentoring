package com.epam.memory.stack;

public class Child
{
  private Parent mother;
  private Parent father;

  public Child()
  {
    this.mother = new Parent();
    this.father = new Parent();
  }

  public Parent getMother() {
    return mother;
  }

  public void setMother( Parent mother ) {
    this.mother = mother;
  }

  public Parent getFather() {
    return father;
  }

  public void setFather( Parent father ) {
    this.father = father;
  }
}
