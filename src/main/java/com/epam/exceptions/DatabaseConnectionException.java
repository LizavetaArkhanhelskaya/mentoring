package com.epam.exceptions;

public class DatabaseConnectionException
  extends RuntimeException
{
  public DatabaseConnectionException()
  {
    System.out.println( "Database connection exception" );
  }
}
