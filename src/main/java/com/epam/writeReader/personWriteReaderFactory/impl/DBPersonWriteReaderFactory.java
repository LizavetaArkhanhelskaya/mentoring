package com.epam.writeReader.personWriteReaderFactory.impl;

import com.epam.writeReader.personWriteReader.impl.DBPersonWriteReader;
import com.epam.writeReader.personWriteReaderFactory.PersonWriteReaderFactory;
import com.epam.writeReader.personWriteReader.PersonWriteReader;

import java.io.IOException;
import java.sql.SQLException;

public class DBPersonWriteReaderFactory
  implements PersonWriteReaderFactory
{
  @Override
  public PersonWriteReader createWriteReader()
    throws IOException, SQLException, ClassNotFoundException
  {
    return new DBPersonWriteReader();
  }
}
