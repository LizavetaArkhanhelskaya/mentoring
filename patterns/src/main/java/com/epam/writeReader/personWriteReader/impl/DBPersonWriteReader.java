package com.epam.writeReader.personWriteReader.impl;

import com.epam.connection.DBConnectionFacade;
import com.epam.connection.impl.PersonDBConnection;
import com.epam.exceptions.BusinessException;
import com.epam.exceptions.DatabaseConnectionException;
import com.epam.model.Person;
import com.epam.writeReader.personWriteReader.PersonWriteReader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBPersonWriteReader
  implements PersonWriteReader
{
  private static final String SQL_INSERT_PERSON = "insert into Person values(?, ?)";
  private static final String SQL_SELECT_PERSONS = "select * from Person";
  private static final String SQL_SELECT_PERSON_BY_NAME = "select * from Person where Name = ?";

  private static final String NAME_COLUMN = "Name";
  private static final String AGE_COLUMN = "Age";

  private DBConnectionFacade dbConnection;

  public DBPersonWriteReader()
  {
    dbConnection = new PersonDBConnection();
    dbConnection.loadDriver();
  }

  @Override
  public void writePerson(final Person person)
  {
    try
    {
      Connection connection = dbConnection.createConnection();
      PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PERSON);
      statement.setString(1, person.getName());
      statement.setInt(2, person.getAge());
      statement.executeUpdate();
      statement.close();
      dbConnection.closeConnection(connection);
    }
    catch (DatabaseConnectionException e)
    {
      throw new BusinessException();
    }
    catch (SQLException e)
    {
      throw new BusinessException();
    }
  }

  @Override
  public List<Person> readPersons()
  {
    List<Person> persons = new ArrayList<Person>();
    try
    {
      Connection connection = dbConnection.createConnection();
      Statement statement = connection.createStatement();
      ResultSet result = statement.executeQuery(SQL_SELECT_PERSONS);

      while ( result.next())
      {
        persons.add(new Person(result.getString(NAME_COLUMN), result.getInt("Age")));
      }

      result.close();
      statement.close();
      dbConnection.closeConnection(connection);
    }
    catch (DatabaseConnectionException e)
    {
      throw new BusinessException();
    }
    catch (SQLException e)
    {
      throw new BusinessException();
    }
    return persons;
  }

  @Override
  public Person readPerson(final String name)
  {
    Person person = null;
    try
    {
      Connection connection = dbConnection.createConnection();
      PreparedStatement statement = connection.prepareStatement(SQL_SELECT_PERSON_BY_NAME);
      statement.setString(1,name);
      ResultSet result = statement.executeQuery();

      if ( result.next() )
      {
        person = new Person(result.getString(NAME_COLUMN), result.getInt(AGE_COLUMN));
      }

      result.close();
      statement.close();
      dbConnection.closeConnection(connection);
    }
    catch (DatabaseConnectionException e)
    {
      throw new BusinessException();
    }
    catch (SQLException e)
    {
      throw new BusinessException();
    }
    return person;
  }
}
