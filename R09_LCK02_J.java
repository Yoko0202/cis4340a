package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
public class R09_LCK02_J {


	static final class Base {
	    static DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);

	    public Date parse(String str) throws ParseException {
	        synchronized (Base.class) {
	            return format.parse(str);
	        }
	    }

	    public Date doSomething(String str) throws ParseException {
	        return new Helper().doSomethingAndParse(str);
	    }

	    private static class Helper {
	        public Date doSomethingAndParse(String str) throws ParseException {
	            synchronized (Base.class) {
	                return format.parse(str);
	            }
	        }
	    }
	}

	// Client code:
	static class ExampleClientCode {

	    private final Base base = new Base();

	    public ExampleClientCode() {
	        Thread t1 = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                try {
	                    base.parse("date1");
	                } catch (ParseException e) {
	                    e.printStackTrace();
	                 }
	            }
	        });
	        t1.start();

	        Thread t2 = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                try {
	                    base.doSomething("date2");
	                } catch (ParseException e) {
	                    e.printStackTrace();
	                 }
	             }
	         });
	        t2.start();
	     }
	}
 }
