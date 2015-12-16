package com.epam.writeReader.personWriteReaderFactory.impl;

import com.epam.writeReader.personWriteReader.impl.FilePersonWriteReader;
import com.epam.writeReader.personWriteReaderFactory.PersonWriteReaderFactory;
import com.epam.writeReader.personWriteReader.PersonWriteReader;
import java.io.IOException;
import java.sql.SQLException;

public class FilePersonWriteReaderFactory
  implements PersonWriteReaderFactory
{
  private String fileName;

  public FilePersonWriteReaderFactory(final String fileName)
  {
    this.fileName = fileName;
  }

  @Override
  public PersonWriteReader createWriteReader()
    throws IOException, SQLException, ClassNotFoundException
  {
    return new FilePersonWriteReader(fileName);
  }
}
