package com.epam.ws.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding( style = Style.RPC )
public interface RandomNumberGenerator
{
  @WebMethod
  int randomNumber( @WebParam( name = "lowerBound" ) int lowerBound, @WebParam( name = "upperBound" ) int upperBound );
}
