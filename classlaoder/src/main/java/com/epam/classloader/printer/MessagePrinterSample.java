package com.epam.classloader.printer;

import org.apache.log4j.Logger;

public class MessagePrinterSample
{
  final static Logger logger = Logger.getLogger( MessagePrinterSample.class );

  public void printMessage()
  {
    logger.info( "Sample" );
  }
}
