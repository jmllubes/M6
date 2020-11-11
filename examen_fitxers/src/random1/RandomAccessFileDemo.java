package random1;

import java.io.*;

public class RandomAccessFileDemo {
   public static void main(String[] args) {

      try {
         char c = 'H';
         
         // create a new RandomAccessFile with filename test
         RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");

         // write something in the file
         raf.writeBytes("ola");
         System.out.println(raf.length());
         // set the file pointer at 0 position
         raf.seek(0);
         Byte a = raf.readByte();
         
         for(int i = 0;i<raf.length();i++) {
        	 if(a == 'a' || a == 'e' || a == 'u' || a == 'o') // Change the pipe character to whatever your sentinel character is
         {
        	   	 System.out.println(a.toString());
         }
         // read char
         }
         
         
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }
}