package com.epam.writeReader.writer;

import com.epam.model.Person;

import java.io.IOException;
import java.sql.SQLException;

public interface PersonWriter
{
  public void writePerson( Person person ) throws IOException, SQLException;
}
