package com.epam;

import org.apache.log4j.Logger;

public class Consumer implements Runnable
{
  final static Logger logger = Logger.getLogger( Consumer.class );

  private int id;
  private MessageBus messageBus;

  public Consumer( MessageBus messageBus, int id )
  {
    this.messageBus = messageBus;
    this.id = id;
  }

  private String consumeMessage()
  {
    return messageBus.removeMessage();
  }

  private void logMessage( String message )
  {
    logger.info( "Consumer " + id + " retrieves a message: " + message );
  }

  @Override
  public void run()
  {
    for ( int i = 0; i < 10; i++)
    {
      try
      {
        String message = consumeMessage();
        logMessage( message );
        Thread.sleep( 20 );
      }
      catch ( InterruptedException e )
      {
        logger.info( "InterruptedException" );
      }
    }
  }
}
