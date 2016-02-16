package com.epam.sql.exception;

public class BusinessException
 extends Exception
{
  private String message;

  public BusinessException()
  {

  }

  public BusinessException( String message )
  {
    this.message = message;
  }
}
