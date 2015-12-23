package com.epam.client;

import com.epam.model.Person;
import com.epam.writeReader.WriteReaderFactory;
import com.epam.writeReader.personWriteReader.PersonWriteReader;

import java.util.List;

public class Client
{
  private PersonWriteReader personWriteReader;

  public Client(final String type, final String fileName)
  {
    personWriteReader = WriteReaderFactory.createPersonWriteReaderFactory(type, fileName).createWriteReader();
  }

  public void writePerson(final Person person)
  {
    personWriteReader.writePerson(person);
  }

  public List<Person> readPerson()
  {
    return personWriteReader.readPersons();
  }

  public Person readPerson(final String name)
  {
    return personWriteReader.readPerson(name);
  }
}
