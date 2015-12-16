package com.epam.writeReader.personWriteReader.impl;

import com.epam.model.Person;
import com.epam.writeReader.personWriteReader.PersonWriteReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilePersonWriteReader
  implements PersonWriteReader
{
  private static final String SPACE = " ";

  private String fileName;
  private BufferedReader reader;
  private FileWriter writer;

  public FilePersonWriteReader(final String fileName)
  {
    this.fileName = fileName;
  }

  @Override
  public void writePerson(final Person person)
    throws IOException
  {
    openWriter();
    writer.write(person.toString());
    closeWriter();
  }

  @Override
  public List<Person> readPersons()
    throws IOException
  {
    openReader();
    List<Person> persons = new ArrayList<Person>();

    String line = null;
    while ((line = reader.readLine()) != null)
    {
      String[] parts = line.split(SPACE);
      persons.add( new Person(parts[0], Integer.parseInt( parts[1] ) ) );
    }
    closeReader();
    return persons;
  }

  @Override
  public Person readPerson(final String name)
    throws IOException
  {
    openReader();
    String line = null;
    while ((line = reader.readLine()) != null)
    {
      String[] parts = line.split(SPACE);
      if(parts[0].equals(name))
      {
        return new Person( parts[0], Integer.parseInt( parts[1] ) );
      }
    }
    closeReader();
    return null;
  }

  private void openReader()
    throws FileNotFoundException
  {
    this.reader = new BufferedReader(new FileReader(new File(fileName)));
  }

  private void closeReader()
    throws IOException
  {
    reader.close();
  }

  private void openWriter()
    throws IOException
  {
    this.writer = new FileWriter(new File(fileName), true);
  }

  private void closeWriter()
    throws IOException
  {
    writer.close();
  }
}
