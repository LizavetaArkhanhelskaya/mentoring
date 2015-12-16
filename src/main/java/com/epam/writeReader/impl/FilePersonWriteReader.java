package com.epam.writeReader.impl;

import com.epam.writeReader.reader.PersonReader;
import com.epam.writeReader.reader.impl.FilePersonReader;
import com.epam.writeReader.PersonWriteReader;
import com.epam.writeReader.writer.PersonWriter;
import com.epam.writeReader.writer.impl.FilePersonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FilePersonWriteReader
  implements PersonWriteReader
{
  private String fileName;

  public FilePersonWriteReader(final String fileName)
  {
    this.fileName = fileName;
  }

  @Override
  public PersonReader createReader()
    throws FileNotFoundException
  {
    //System.out.println( "Create file reader." );
    return new FilePersonReader(fileName);
  }

  @Override
  public PersonWriter createWriter()
    throws IOException
  {
    //System.out.println( "Create file writer." );
    return new FilePersonWriter(fileName);
  }
}
