package com.epam.classloader.exception;

public class ApplicationException
  extends RuntimeException
{
  private String message;

  public ApplicationException(){}

  public ApplicationException( String message )
  {
    this.message = message;
  }
}
