package com.epam.writeReader.personWriteReader.impl;

import com.epam.model.Person;
import com.epam.writeReader.personWriteReader.PersonWriteReader;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBPersonWriteReader
  implements PersonWriteReader
{
  private static final String SQL_INSERT_PERSON = "insert into Person values(?, ?)";
  private static final String SQL_SELECT_PERSONS = "select * from Person";
  private static final String SQL_SELECT_PERSON_BY_NAME = "select * from Person where Name = ?";

  private Connection connection;

  @Override
  public void writePerson(final Person person)
    throws SQLException, ClassNotFoundException, IOException
  {
    openConection();
    PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PERSON);
    statement.setString(1,person.getName());
    statement.setInt(2, person.getAge());
    statement.executeUpdate();
    statement.close();
    closeConnection();
  }

  @Override
  public List<Person> readPersons()
    throws SQLException, ClassNotFoundException, IOException
  {
    openConection();
    Statement statement = connection.createStatement();
    ResultSet result = statement.executeQuery(SQL_SELECT_PERSONS);

    List<Person> persons = new ArrayList<Person>();
    while ( result.next())
    {
      persons.add(new Person(result.getString("Name"),result.getInt("Age")));
    }

    result.close();
    statement.close();
    closeConnection();
    return persons;
  }

  @Override
  public Person readPerson(final String name)
    throws SQLException, ClassNotFoundException, IOException
  {
    openConection();
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
    closeConnection();
    return person;
  }

  private void openConection()
    throws ClassNotFoundException, SQLException
  {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
  }
  private void closeConnection()
    throws IOException, SQLException
  {
    connection.close();
  }
}
