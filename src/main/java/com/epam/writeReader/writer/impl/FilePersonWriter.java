package com.epam.writeReader.writer.impl;

import com.epam.model.Person;
import com.epam.writeReader.writer.PersonWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FilePersonWriter
  implements PersonWriter
{
  private FileWriter fileWriter;

  public FilePersonWriter(final String fileName)
    throws IOException
  {
    this.fileWriter = new FileWriter(new File(fileName), true);
  }

  @Override
  public void writePerson(final Person person)
    throws IOException
  {
    //System.out.println( "Write person into file." );
    fileWriter.write(person.toString());
    fileWriter.close();
  }
}
