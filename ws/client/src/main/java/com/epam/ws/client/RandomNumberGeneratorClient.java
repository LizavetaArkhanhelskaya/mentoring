package com.epam.ws.client;

import com.epam.ws.server.RandomNumberGenerator;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class RandomNumberGeneratorClient
{
  public static void main(String[] args) throws Exception {

    URL url = new URL( "http://localhost:8080/ws/random" );
    QName qname = new QName( "http://server.ws.epam.com/", "RandomNumberGeneratorImplService" );
    Service service = Service.create( url, qname );

    RandomNumberGenerator random = service.getPort( RandomNumberGenerator.class );

    System.out.println( random.randomNumber( 1, 49 ) );
    System.out.println( random.randomNumber( 1, 49 ) );
    System.out.println( random.randomNumber( 1, 49 ) );
    System.out.println( random.randomNumber( 1, 49 ) );
    System.out.println( random.randomNumber( 1, 49 ) );
    System.out.println( random.randomNumber( 1, 49 ) );
  }
}
