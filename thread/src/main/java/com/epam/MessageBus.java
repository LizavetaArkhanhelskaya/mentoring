package com.epam;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class MessageBus
{
  final static Logger logger = Logger.getLogger( MessageBus.class );

  private Queue<String> queue = new LinkedList<String>();
  private Semaphore lock = new Semaphore( 1 );

  public void addMessage( String message )
  {
    try {
      lock.acquire();
      queue.add( message );
    }
    catch ( InterruptedException e )
    {
      logger.info( "InterruptedException" );
    }
    finally
    {
      lock.release();
    }
  }

  public String removeMessage()
  {
    String message = null;
    try {
      lock.acquire();
      message = queue.poll();
    }
    catch ( InterruptedException e )
    {
      logger.info( "InterruptedException" );
    }
    finally
    {
      lock.release();
    }
    return message;
  }
}
