package com.epam.memory.metaspace;

import javassist.CannotCompileException;

public class ClassGenerator
{
  static javassist.ClassPool classPool = javassist.ClassPool.getDefault();

  public static void generate( String className ) throws CannotCompileException
  {
    for (int i = 0; ; i++) {
      Class clazz = classPool.makeClass( className + i ).toClass();
      System.out.println( clazz );
    }
  }
}
