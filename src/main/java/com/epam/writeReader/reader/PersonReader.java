package com.epam.writeReader.reader;

import com.epam.model.Person;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface PersonReader
{
  public List<Person> readPersons() throws IOException, SQLException;

  public Person readPerson( String name ) throws IOException, SQLException;
}
