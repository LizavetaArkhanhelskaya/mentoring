package com.epam.writeReader;

import com.epam.exceptions.BusinessException;
import com.epam.writeReader.personWriteReaderFactory.PersonWriteReaderFactory;
import com.epam.writeReader.personWriteReaderFactory.impl.DBPersonWriteReaderFactory;
import com.epam.writeReader.personWriteReaderFactory.impl.FilePersonWriteReaderFactory;

public class WriteReaderFactory
{
  private enum TYPE {FILE, DB};
  public static PersonWriteReaderFactory createPersonWriteReaderFactory(final String type, final String fileName)
  {
    TYPE enumType = TYPE.valueOf(type.toUpperCase());
    switch(enumType)
    {
      case FILE: return new FilePersonWriteReaderFactory(fileName);
      case DB: return new DBPersonWriteReaderFactory();
      default: throw new BusinessException();
    }
  }
}
