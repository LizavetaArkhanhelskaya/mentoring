package com.epam.sql.util;

import com.epam.sql.exception.BusinessException;

import java.io.*;

public class ScriptReader
{
  public static String read( String filePath ) throws BusinessException {
    StringBuffer sb = new StringBuffer();
    try
    {
      InputStream is = ScriptReader.class.getResourceAsStream( filePath );
      BufferedReader br = new BufferedReader( new InputStreamReader( is ) );
      String script = null;
      while( ( script = br.readLine() ) != null )
      {
        sb.append(script);
      }
      br.close();
    }
    catch ( FileNotFoundException e )
    {
      throw new BusinessException( "Can't find sql script." );
    }
    catch ( IOException e )
    {
      throw new BusinessException( "Exception during script reading." );
    }
    return sb.toString();
  }
}
