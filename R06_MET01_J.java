package main;

public class R06_MET01_J {

    public static void main(String[] args) {
        try {
            int result = getAbsAdd(Integer.MIN_VALUE, 1);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static int getAbsAdd(int x, int y) {
        if ((x < 0 && y < 0 && Integer.MAX_VALUE - x < y) || (x > 0 && y > 0 && Integer.MAX_VALUE - x < y) || (x < 0 && y > 0 && Integer.MIN_VALUE + y > x) || (x > 0 && y < 0 && Integer.MIN_VALUE + x > y)) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        return absX + absY;
    }
}

