package com.epam.classloader.menu;

import com.epam.classloader.exception.ApplicationException;
import org.apache.log4j.Logger;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

public class Menu
{
  public void callMenu()
  {
    while ( true )
    {
      System.out.println( "Choose jar. Enter number: " );
      System.out.println( "1 for printer-1.0.1-SNAPSHOT.jar, " );
      System.out.println( "2 for printer-1.0.2-SNAPSHOT.jar, " );
      System.out.println( "3 for printer-1.0.3-SNAPSHOT.jar. " );
      System.out.println( "Press enter to exit. " );

      Scanner in = new Scanner( System.in );
      String nextLine = in.nextLine();
      if ( nextLine.trim().equals( "" ) )
      {
        return;
      }
      String jarPath = "printers/printer-1.0." + nextLine + "-SNAPSHOT.jar";

      callPrintMessageMethod( getURLClassLoader( jarPath ) );
    }
  }

  private void callPrintMessageMethod( URLClassLoader urlClassLoader )
  {
    try
    {
      Class classToLoad = Class.forName( "com.epam.classloader.printer.MessagePrinter", true, urlClassLoader );
      Method method = classToLoad.getDeclaredMethod( "printMessage" );
      Object instance = classToLoad.newInstance();
      method.invoke( instance );
    }
    catch ( Throwable e )
    {
      throw new ApplicationException( "Error during method call" );
    }
  }

  private URLClassLoader getURLClassLoader( final String jarPath )
  {
    URLClassLoader urlClassLoader = null;
    try
    {
      ClassLoader parentClassLoader = this.getClass().getClassLoader();
      File jar = new File( parentClassLoader.getResource( jarPath ).getFile() );
      URL url = jar.toURL();
      URL[] urls = new URL[]{ url };
      urlClassLoader = new URLClassLoader ( urls, parentClassLoader);
    }
    catch ( MalformedURLException e )
    {
      throw new ApplicationException( "Error during getting URL ClassLoader" );
    }
    return urlClassLoader;
  }
}
