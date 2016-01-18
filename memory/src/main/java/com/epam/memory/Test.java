package com.epam.memory;

import com.epam.memory.heap.FriendChainBuilder;
import com.epam.memory.heap.Person;
import com.epam.memory.metaspace.ClassGenerator;
import com.epam.memory.stack.Child;
import javassist.CannotCompileException;

import java.util.Scanner;

public class Test
{
  private enum COMMAND { HEAP, METASPACE, STACK };

  //-Xmx3m -Xss1m -XX:MaxPermSize=3m
  public static void main( String[] args ) throws CannotCompileException
  {
    while ( true )
    {
      System.out.println( "Enter command: heap, metaspace, stack. Press enter to exit." );
      Scanner in = new Scanner( System.in );
      String command = in.nextLine();
      if ( command.trim().equals( "" ) )
      {
        return;
      }

      COMMAND commandType = COMMAND.valueOf( command.toUpperCase() );
      switch( commandType )
      {
        case HEAP:
          Person liza = new Person( "Lizaveta", "Arkhanhelskaya", 22, 68.0, 175.0 );
          FriendChainBuilder.build( liza );
        case METASPACE:
          ClassGenerator.generate( "com.epam.memory.metaspace.Generated" );
        case STACK:
          new Child();
      }
    }
  }
}
