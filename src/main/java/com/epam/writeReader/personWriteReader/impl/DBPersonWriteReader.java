package com.epam.writeReader.personWriteReader.impl;

import com.epam.exceptions.BusinessException;
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

  private static final String NAME_COLUMN = "Name";
  private static final String AGE_COLUMN = "Age";

  private Connection connection;

  @Override
  public void writePerson(final Person person)
  {
    try
    {
      openConection();
      PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PERSON);
      statement.setString(1, person.getName());
      statement.setInt(2, person.getAge());
      statement.executeUpdate();
      statement.close();
      closeConnection();
    }
    catch (ClassNotFoundException e)
    {
      throw new BusinessException();
    }
    catch (SQLException e)
    {
      throw new BusinessException();
    }
    catch (IOException e)
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
      openConection();
      Statement statement = connection.createStatement();
      ResultSet result = statement.executeQuery(SQL_SELECT_PERSONS);

      while ( result.next())
      {
        persons.add(new Person(result.getString(NAME_COLUMN), result.getInt("Age")));
      }

      result.close();
      statement.close();
      closeConnection();
    }
    catch (ClassNotFoundException e)
    {
      throw new BusinessException();
    }
    catch (SQLException e)
    {
      throw new BusinessException();
    }
    catch (IOException e)
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
      openConection();
      PreparedStatement statement = connection.prepareStatement(SQL_SELECT_PERSON_BY_NAME);
      statement.setString(1,name);
      ResultSet result = statement.executeQuery();

      if ( result.next() )
      {
        person = new Person(result.getString(NAME_COLUMN), result.getInt(AGE_COLUMN));
      }

      result.close();
      statement.close();
      closeConnection();
    }
    catch (ClassNotFoundException e)
    {
      throw new BusinessException();
    }
    catch (SQLException e)
    {
      throw new BusinessException();
    }
    catch (IOException e)
    {
      throw new BusinessException();
    }
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
