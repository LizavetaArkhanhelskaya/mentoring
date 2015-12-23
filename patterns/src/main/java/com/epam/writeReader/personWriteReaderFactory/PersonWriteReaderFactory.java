package com.epam.writeReader.personWriteReaderFactory;

import com.epam.writeReader.personWriteReader.PersonWriteReader;

public interface PersonWriteReaderFactory
{
  public PersonWriteReader createWriteReader();
}
