package com.epam.writeReader.personWriteReader;

import com.epam.model.Person;

import java.util.List;

public interface PersonWriteReader
{
  public void writePerson(Person person);

  public List<Person> readPersons();

  public Person readPerson(String name);
}
