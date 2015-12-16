package com.epam.writeReader.reader.impl;

import com.epam.model.Person;
import com.epam.writeReader.reader.PersonReader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBPersonReader
  implements PersonReader
{
  private static final String SQL_SELECT_PERSONS = "select * from Person";
  private static final String SQL_SELECT_PERSON_BY_NAME = "select * from Person where Name = ?";

  private Connection connection;

  public DBPersonReader()
    throws SQLException, ClassNotFoundException
  {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
  }
  @Override
  public List<Person> readPersons()
    throws SQLException
  {
    //System.out.println("Read persons from DB.");
    Statement statement = connection.createStatement();
    ResultSet result = statement.executeQuery(SQL_SELECT_PERSONS);

    List<Person> persons = new ArrayList<Person>();
    while ( result.next())
    {
      persons.add(new Person(result.getString("Name"),result.getInt("Age")));
    }

    result.close();
    statement.close();
    return persons;
  }

  @Override
  public Person readPerson(final String name)
    throws SQLException
  {
    //System.out.println("Read person by name from DB.");
    PreparedStatement statement = connection.prepareStatement(SQL_SELECT_PERSON_BY_NAME);
    statement.setString(1,name);
    ResultSet result = statement.executeQuery();

    Person person = null;
    if ( result.next() )
    {
      person = new Person(result.getString("Name"),result.getInt("Age"));
    }

    result.close();
    statement.close();
    return person;
  }
}
