package com.epam.client;

import com.epam.exceptions.BusinessException;
import com.epam.model.Person;
import com.epam.writeReader.PersonWriteReader;
import com.epam.writeReader.impl.DBPersonWriteReader;
import com.epam.writeReader.impl.FilePersonWriteReader;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Client
{
  private PersonWriteReader personWriteReader;

  public void chooseWriteReader(final String type, final String fileName)
  {
    if ( type != null )
    {
      if ( type.equals( "file" ) )
      {
        System.out.println( "Client chooses file." );
        personWriteReader = new FilePersonWriteReader(fileName);
        return;
      }
      if ( type.equals( "DB" ) )
      {
        System.out.println("Client chooses DB.");
        personWriteReader = new DBPersonWriteReader();
        return;
      }
    }
    throw new BusinessException();
  }

  public void writePerson( final Person person )
    throws IOException, SQLException, ClassNotFoundException
  {
    //System.out.println("Client writes person.");
    personWriteReader.createWriter().writePerson( person );
  }

  public List<Person> readPerson()
    throws IOException, SQLException, ClassNotFoundException
  {
    //System.out.println("Client reads persons." );
    return personWriteReader.createReader().readPersons();
  }

  public Person readPerson( final String name )
    throws IOException, SQLException, ClassNotFoundException
  {
    //System.out.println("Client reads person by name." );
    return personWriteReader.createReader().readPerson( name );
  }
}
