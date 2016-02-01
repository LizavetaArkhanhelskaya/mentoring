package com.epam;

import org.apache.log4j.Logger;

import java.util.UUID;

public class Producer implements Runnable
{
  final static Logger logger = Logger.getLogger( Producer.class );

  private int id;
  private MessageBus messageBus;

  public Producer( MessageBus messageBus, int id )
  {
    this.messageBus = messageBus;
    this.id = id;
  }

  private String generateMessage()
  {
    return UUID.randomUUID().toString();
  }

  private void postMessage( String message )
  {
    logger.info( "Producer " + id +" posts a message: " + message );
    messageBus.addMessage( message );
  }

  @Override
  public void run()
  {
    for ( int i = 0; i < 10; i++)
    {
      try
      {
        String message = generateMessage();
        postMessage( message );
        Thread.sleep( 10 );
      }
      catch ( InterruptedException e )
      {
        logger.info( "InterruptedException" );
      }
    }
  }
}
