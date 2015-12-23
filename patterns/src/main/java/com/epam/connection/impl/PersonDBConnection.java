package com.epam.connection.impl;

import com.epam.connection.DBConnectionFacade;
import com.epam.exceptions.DatabaseConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersonDBConnection
  implements DBConnectionFacade
{
  @Override
  public void loadDriver()
  {
    try
    {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    }
    catch (ClassNotFoundException e)
    {
      throw new DatabaseConnectionException();
    }
  }

  @Override
  public Connection createConnection()
  {
    Connection connection = null;
    try
    {
      connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
    }
    catch (SQLException e)
    {
      throw new DatabaseConnectionException();
    }
    return connection;
  }

  @Override
  public void closeConnection(Connection connection)
  {
    try
    {
      connection.close();
    }
    catch (SQLException e)
    {
      throw new DatabaseConnectionException();
    }
  }
}
