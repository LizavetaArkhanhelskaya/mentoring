package com.epam.memory.heap;

import java.util.Random;

public class FriendChainBuilder
{
  private static final Random random = new Random();

  public static void build( Person person )
  {
    while ( true )
    {
      System.out.println( person.getFirstName() );
      Person friend = new Person( "FirstName " + random.nextInt(),
        "LastName " + random.nextInt(), random.nextInt(),
        random.nextDouble(), random.nextDouble() );
      person.setFriend( friend );
      person = friend;
    }
  }
}
