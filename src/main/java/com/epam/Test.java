package com.epam;

import com.epam.client.Client;
import com.epam.model.Person;

import java.io.*;
import java.sql.*;

public class Test
{
 public static void main( String[] args ) throws IOException, ClassNotFoundException, SQLException {

   Person liza = new Person();
   liza.setName("Liza");
   liza.setAge(22);

   Person ilya = new Person();
   ilya.setName("Ilya");
   ilya.setAge(23);

   Person vlad = new Person();
   vlad.setName("Vlad");
   vlad.setAge(9);

   System.out.println( "Start" );

   Client clientFile = new Client("file","persons.txt");
   clientFile.writePerson(ilya);
   clientFile.writePerson(liza);
   clientFile.writePerson(vlad);
   System.out.println("File: " + clientFile.readPerson());
   System.out.println("File: " + clientFile.readPerson("Vlad"));

   Client clientDB = new Client("DB",null);
   clientDB.writePerson(ilya);
   clientDB.writePerson(liza);
   clientDB.writePerson(vlad);
   System.out.println("DB: " + clientDB.readPerson());
   System.out.println("DB: " + clientDB.readPerson("Vlad"));

   System.out.println( "End" );
 }
}
