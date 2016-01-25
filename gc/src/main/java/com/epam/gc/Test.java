package com.epam.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Test
{
  public static void main( String[] args )
  {
    while( true )
    {
      List<String> list = new ArrayList<String>();
      for ( int i = 0; i < 10000; i++ )
      {
        list.add( UUID.randomUUID().toString() );
      }
      list = null;
    }
  }
}
