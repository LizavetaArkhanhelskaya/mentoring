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
   ilya.setName("Roma");
   ilya.setAge(23);

   Person vlad = new Person();
   vlad.setName("Vlad");
   vlad.setAge(9);

   System.out.println( "Start" );

   Client client1 = new Client();
   client1.chooseWriteReader("file","persons.txt");
   client1.writePerson(ilya);
   client1.writePerson(liza);

   //System.out.println("File: " + client1.readPerson());
   //System.out.println("File: "+client1.readPerson("Vlad"));
/*
   Client client2 = new Client();
   client2.chooseWriteReader("DB","persons.txt");
   client2.writePerson(ilya);
   System.out.println("DB: "+client2.readPerson());
   System.out.println("DB: "+client2.readPerson("Vlad"));
*/
   System.out.println( "End" );
 }
}
