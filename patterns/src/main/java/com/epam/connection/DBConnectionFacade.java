package com.epam.connection;

import com.epam.exceptions.DatabaseConnectionException;

import java.sql.Connection;

public interface DBConnectionFacade
{
  public void loadDriver() throws DatabaseConnectionException;

  public Connection createConnection() throws DatabaseConnectionException;

  public void closeConnection(Connection connection) throws DatabaseConnectionException;
}
