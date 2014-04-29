package outil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptageMdP {
	
	// String -> SHA1 -> tableau de byte
	  public static byte[]  encoderMotDePasse(String str){
	      MessageDigest msgd = null;
	      try {
	           msgd = MessageDigest.getInstance("SHA1");
	      } catch (NoSuchAlgorithmException e) {
	          e.printStackTrace();
	      }
	      msgd.update(str.getBytes());
	      return msgd.digest();	
	  }
      
   // tableau de byte -> string HEXA
 	 public static String passToString(byte[] pwd){
 	          return javax.xml.bind.DatatypeConverter.printHexBinary(pwd);
 	      }


}
