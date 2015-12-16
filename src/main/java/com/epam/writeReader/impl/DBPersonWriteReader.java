package com.epam.writeReader.impl;

import com.epam.writeReader.reader.PersonReader;
import com.epam.writeReader.reader.impl.DBPersonReader;
import com.epam.writeReader.PersonWriteReader;
import com.epam.writeReader.writer.PersonWriter;
import com.epam.writeReader.writer.impl.DBPersonWriter;

import java.sql.SQLException;

public class DBPersonWriteReader
  implements PersonWriteReader
{
  @Override
  public PersonReader createReader()
    throws SQLException, ClassNotFoundException
  {
    //System.out.println( "Create DB reader." );
    return new DBPersonReader();
  }

  @Override
  public PersonWriter createWriter()
    throws SQLException, ClassNotFoundException
  {
    //System.out.println( "Create DB writer." );
    return new DBPersonWriter();
  }
}
