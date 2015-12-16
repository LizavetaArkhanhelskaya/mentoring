package com.epam.writeReader.reader.impl;

import com.epam.model.Person;
import com.epam.writeReader.reader.PersonReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilePersonReader
  implements PersonReader
{
  private static final String SPACE = " ";

  private BufferedReader reader;

  public FilePersonReader(final String fileName)
   throws FileNotFoundException
  {
    this.reader = new BufferedReader(new FileReader(new File(fileName)));
  }

  @Override
  public List<Person> readPersons()
    throws IOException
  {
    //System.out.println("Read persons from file.");
    List<Person> persons = new ArrayList<Person>();

    String line = null;
    while ((line = reader.readLine()) != null)
    {
      String[] parts = line.split(SPACE);
      persons.add( new Person(parts[0], Integer.parseInt( parts[1] ) ) );
    }

    return persons;
  }

  @Override
  public Person readPerson(final String name) throws IOException {
    //System.out.println("Read person by name from file.");
    String line = null;
    while ((line = reader.readLine()) != null)
    {
      String[] parts = line.split(SPACE);
      if(parts[0].equals(name))
      {
        return new Person( parts[0], Integer.parseInt( parts[1] ) );
      }
    }
    return null;
  }
}
