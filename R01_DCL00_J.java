package main;

public class R01_DCL00_J {

    private final int balance;
    private static final int deposit = getDeposit();
    
    private static int getDeposit() {
        return (int) (Math.random() * 100);
    }
    
    private static final R01_DCL00_J c = new R01_DCL00_J(); 
    
    public R01_DCL00_J() { 
        balance = deposit - 10; 
    }
   
    public static void main(String[] args) {
        System.out.println("The account balance is: " + c.balance);
    }
}
