package com.epam.writeReader.personWriteReaderFactory;

import com.epam.writeReader.personWriteReader.PersonWriteReader;
import java.io.IOException;
import java.sql.SQLException;


public interface PersonWriteReaderFactory
{
  public PersonWriteReader createWriteReader() throws IOException, SQLException, ClassNotFoundException;
}
