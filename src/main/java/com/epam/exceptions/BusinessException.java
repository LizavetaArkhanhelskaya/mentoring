package com.epam.exceptions;

public class BusinessException
 extends RuntimeException
{
  public BusinessException()
  {
    System.out.println( "Business exception" );
  }
}
