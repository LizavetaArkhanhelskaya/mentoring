package com.epam.sql;

import com.epam.sql.commands.DBCommandsProcessor;
import com.epam.sql.connection.DBConection;
import com.epam.sql.exception.BusinessException;

import java.sql.Connection;
import java.sql.SQLException;

public class Test
{
  public static void main( String[] args ) throws BusinessException
  {
    try
    {
      Connection connection = DBConection.createConnection();
      DBCommandsProcessor processor = new DBCommandsProcessor( connection );
      processor.create();
      processor.insert();
      processor.select();
      connection.close();
    }
    catch ( SQLException e )
    {
      throw new BusinessException( "Can't close connection." );
    }
  }
}
