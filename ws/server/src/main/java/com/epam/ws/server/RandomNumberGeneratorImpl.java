package com.epam.ws.server;

import javax.jws.WebService;
import java.util.Random;

@WebService( endpointInterface = "com.epam.ws.server.RandomNumberGenerator" )
public class RandomNumberGeneratorImpl
  implements RandomNumberGenerator
{
  @Override
  public int randomNumber( int lowerBound, int upperBound )
  {
    Random random = new Random();
    return random.nextInt( ( upperBound - lowerBound ) + 1 ) + lowerBound;
  }
}
