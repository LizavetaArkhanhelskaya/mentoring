package com.epam.sql.connection;

import com.epam.sql.exception.BusinessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection
{
  public static Connection createConnection() throws BusinessException {
    Connection connection = null;
    try
    {
      Class.forName( "oracle.jdbc.driver.OracleDriver" );
      connection = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe", "system", "system" );
    }
    catch ( ClassNotFoundException e )
    {
      throw new BusinessException( "Can't find oracle driver." );
    }
    catch ( SQLException e )
    {
      throw new BusinessException( "Exception during database connecting." );
    }
    return connection;
  }
}
