package main;

public class R08_VNA04_J {

    static final class USCurrency {

        private int quarters = 0;
        private int dimes = 0;
        private int nickels = 0;
        private int pennies = 0;

        public USCurrency() {}

        
        public synchronized USCurrency setQuarters(int quantity) {
            quarters = quantity;
            return this;
        }
        public synchronized USCurrency setDimes(int quantity) {
            dimes = quantity;
            return this;
        }
        public synchronized USCurrency setNickels(int quantity) {
            nickels = quantity;
            return this;
        }
        public synchronized USCurrency setPennies(int quantity) {
            pennies = quantity;
            return this;
        }

		public int getQuarters() {
			return quarters;
		}

		public int getDimes() {
			return dimes;
		}

		public int getNickels() {
			return nickels;
		}

		public int getPennies() {
			return pennies;
		}
    }

    // Client code:
    static class ExampleClientCode {

        private final USCurrency currency = new USCurrency();
        // ...

        public ExampleClientCode() {

            Thread t1 = new Thread(new Runnable() {
                @Override public void run() {
                    synchronized (currency) {
                        currency.setQuarters(1).setDimes(1);
                    }
                }
            });
            t1.start();

            Thread t2 = new Thread(new Runnable() {
                @Override public void run() {
                    synchronized (currency) {
                        currency.setQuarters(2).setDimes(2);
                    }
                }
            });
            t2.start();

                }
    }
}