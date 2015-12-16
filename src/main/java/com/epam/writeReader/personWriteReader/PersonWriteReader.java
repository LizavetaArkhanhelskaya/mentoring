package com.epam.writeReader.personWriteReader;

import com.epam.model.Person;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface PersonWriteReader
{
  public void writePerson( Person person ) throws IOException, SQLException, ClassNotFoundException;

  public List<Person> readPersons() throws IOException, SQLException, ClassNotFoundException;

  public Person readPerson( String name ) throws IOException, SQLException, ClassNotFoundException;
}
