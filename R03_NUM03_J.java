package main;

import java.io.DataInputStream;
import java.io.IOException;
public class R03_NUM03_J {
	    public static void main(String[] args) {
	        try {
	            DataInputStream is = new DataInputStream(System.in);
	            long unsignedInteger = getUnsignedInteger(is);
	            System.out.println("Unsigned Integer: " + unsignedInteger);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static long getUnsignedInteger(DataInputStream is) throws IOException {
	        return is.readInt() & 0xFFFFFFFFL;
	    }
	}

