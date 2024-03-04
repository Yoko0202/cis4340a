package main;

import java.math.BigInteger;
import java.util.Base64;

public class R04_STR03_J {
	public static void main(String[] args) {
	    BigInteger x = new BigInteger("530500452766");
	    String s = x.toString();  // Valid character data
	    byte[] byteArray = s.getBytes();
	    String ns = new String(byteArray); 
	    x = new BigInteger(ns);
	    System.out.println("Compliant Solution without Base64: " + x);
	        
	    byteArray = x.toByteArray();
	    s = Base64.getEncoder().encodeToString(byteArray);
	    byteArray = Base64.getDecoder().decode(s);
	    x = new BigInteger(byteArray);
	    System.out.println("Compliant Solution with Base64: " + x);
	    }
}