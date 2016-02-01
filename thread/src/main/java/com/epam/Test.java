package com.epam;

import java.util.ArrayList;
import java.util.List;

public class Test
{
  public static void main( String[] args )
  {
    MessageBus messageBus = new MessageBus();

    for ( int i = 0; i < 5; i++ )
    {
      Thread producer = new Thread( new Producer( messageBus, i ) );
      Thread consumer = new Thread( new Consumer( messageBus, i ) );

      producer.start();
      consumer.start();
    }

  }
}
