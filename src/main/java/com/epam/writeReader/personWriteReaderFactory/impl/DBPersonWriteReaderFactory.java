package com.epam.writeReader.personWriteReaderFactory.impl;

import com.epam.writeReader.personWriteReader.impl.DBPersonWriteReader;
import com.epam.writeReader.personWriteReaderFactory.PersonWriteReaderFactory;
import com.epam.writeReader.personWriteReader.PersonWriteReader;

public class DBPersonWriteReaderFactory
  implements PersonWriteReaderFactory
{
  @Override
  public PersonWriteReader createWriteReader()
  {
    return new DBPersonWriteReader();
  }
}
