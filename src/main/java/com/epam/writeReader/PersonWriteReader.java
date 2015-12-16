package com.epam.writeReader;

import com.epam.writeReader.reader.PersonReader;
import com.epam.writeReader.writer.PersonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;


public interface PersonWriteReader
{
  public PersonReader createReader() throws FileNotFoundException, SQLException, ClassNotFoundException;

  public PersonWriter createWriter() throws IOException, SQLException, ClassNotFoundException;
}
