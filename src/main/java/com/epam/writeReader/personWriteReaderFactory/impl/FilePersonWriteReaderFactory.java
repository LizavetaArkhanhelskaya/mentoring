package com.epam.writeReader.personWriteReaderFactory.impl;

import com.epam.writeReader.personWriteReader.impl.FilePersonWriteReader;
import com.epam.writeReader.personWriteReaderFactory.PersonWriteReaderFactory;
import com.epam.writeReader.personWriteReader.PersonWriteReader;

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
  {
    return new FilePersonWriteReader(fileName);
  }
}
