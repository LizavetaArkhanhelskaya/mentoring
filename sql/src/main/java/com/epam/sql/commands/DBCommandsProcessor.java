package com.epam.sql.commands;

import com.epam.sql.exception.BusinessException;
import com.epam.sql.util.ScriptReader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCommandsProcessor
{
  private Connection connection;

  public DBCommandsProcessor( Connection connection )
  {
    this.connection = connection;
  }

  public void create() throws BusinessException
  {
    Statement statement = null;
    try {
      statement = connection.createStatement();
      String createTableSQL = ScriptReader.read( "/scripts/create.sql" );
      String[] commands = createTableSQL.split( ";" );
      System.out.println( "Start table creation." );
      for ( String command: commands )
      {
        statement.execute( command );
      }
      System.out.println( "End table creation." );
    }
    catch ( SQLException e )
    {
      throw new BusinessException( "Exception during table creation." );
    }
    finally
    {
      closeStatement( statement );
    }
  }

  public void insert() throws BusinessException
  {
    Statement statement = null;
    try {
      statement = connection.createStatement();
      String insertDataSQL = ScriptReader.read( "/scripts/insert.sql" );
      String[] commands = insertDataSQL.split( ";" );
      System.out.println( "Start to insert data." );
      for ( String command: commands )
      {
        statement.executeUpdate( command );
      }
      System.out.println( "End to insert data." );
    }
    catch ( SQLException e )
    {
      throw new BusinessException( "Exception during data inserting." );
    }
    finally
    {
      closeStatement( statement );
    }
  }

  public void select() throws BusinessException
  {
    Statement statement = null;
    try {
      statement = connection.createStatement();
      String selectDataSQL = ScriptReader.read( "/scripts/select.sql" );
      System.out.println( "Start to select data." );
      ResultSet result = statement.executeQuery( selectDataSQL );
      while( result.next() )
      {
        System.out.println( result.getInt( "id" ) + " " +
          result.getString( "name" ) + " " +
          result.getString( "surname" ) );
      }
      result.close();
      System.out.println( "End to select data." );
    }
    catch ( SQLException e )
    {
      throw new BusinessException( "Exception during data inserting." );
    }
    finally
    {
      closeStatement( statement );
    }

  }

  private void closeStatement( Statement statement ) throws BusinessException
  {
    if ( statement != null )
    {
      try
      {
        statement.close();
      }
      catch ( SQLException e )
      {
        throw new BusinessException( "Can't close statement." );
      }
    }
  }
}
