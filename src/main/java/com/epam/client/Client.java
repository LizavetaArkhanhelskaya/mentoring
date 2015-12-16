package com.epam.client;

import com.epam.exceptions.BusinessException;
import com.epam.model.Person;
import com.epam.writeReader.personWriteReader.PersonWriteReader;
import com.epam.writeReader.personWriteReaderFactory.PersonWriteReaderFactory;
import com.epam.writeReader.personWriteReaderFactory.impl.DBPersonWriteReaderFactory;
import com.epam.writeReader.personWriteReaderFactory.impl.FilePersonWriteReaderFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Client
{
  private PersonWriteReader personWriteReader;

  public Client(final String type, final String fileName)
    throws SQLException, IOException, ClassNotFoundException
  {
    PersonWriteReaderFactory personWriteReaderFactory = null;
    if ( type != null )
    {
      if ( type.equals( "file" ) )
      {
        personWriteReaderFactory = new FilePersonWriteReaderFactory(fileName);
      }
      if ( type.equals( "DB" ) )
      {
        personWriteReaderFactory = new DBPersonWriteReaderFactory();
      }
    }

    if (personWriteReaderFactory == null)
    {
      throw new BusinessException();
    }
    else
    {
      personWriteReader = personWriteReaderFactory.createWriteReader();
    }
  }

  public void writePerson( final Person person )
    throws IOException, SQLException, ClassNotFoundException
  {
    personWriteReader.writePerson(person);
  }

  public List<Person> readPerson()
    throws IOException, SQLException, ClassNotFoundException
  {
    return personWriteReader.readPersons();
  }

  public Person readPerson( final String name )
    throws IOException, SQLException, ClassNotFoundException
  {
    return personWriteReader.readPerson(name);
  }
}
