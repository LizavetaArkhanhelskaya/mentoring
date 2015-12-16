package com.epam.writeReader.writer.impl;

import com.epam.model.Person;
import com.epam.writeReader.writer.PersonWriter;

import java.sql.*;

public class DBPersonWriter
  implements PersonWriter
{
  private static final String SQL_INSERT_PERSON = "insert into Person values(?, ?)";

  private Connection connection;

  public DBPersonWriter()
    throws ClassNotFoundException, SQLException
  {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
  }

  @Override
  public void writePerson(final Person person)
    throws SQLException
  {
    //System.out.println( "Write person into DB." );
    //Statement statement = connection.createStatement();
    //statement.executeUpdate("insert into Person values(\'Lizaveta\',22)");
    PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PERSON);
    statement.setString(1,person.getName());
    statement.setInt(2,person.getAge());
    statement.executeUpdate();
    statement.close();
  }
}
