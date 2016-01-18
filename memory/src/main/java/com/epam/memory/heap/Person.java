package com.epam.memory.heap;

public class Person
{
  private final String firstName;
  private final String lastName;
  private final Integer age;
  private final Double weight;
  private final Double height;
  private Person friend;

  public Person(){
    firstName = null;
    lastName = null;
    age = null;
    weight = null;
    height = null;
  }

  public Person( String firstName, String lastName, Integer age, Double weight, Double height )
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.weight = weight;
    this.height = height;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Integer getAge() {
    return age;
  }

  public Double getWeight() {
    return weight;
  }

  public Double getHeight() {
    return height;
  }

  public Person getFriend() {
    return friend;
  }

  public void setFriend( Person friend ) {
    this.friend = friend;
  }
}
