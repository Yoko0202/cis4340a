package main;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class R07_ERR06_J {
    private static Throwable throwable;

    public R07_ERR06_J() throws Throwable {
        throw throwable;
    }

    public static synchronized void undeclaredThrow(Throwable throwable) {
        if (throwable instanceof IllegalAccessException ||
            throwable instanceof InstantiationException) {
            throw new IllegalArgumentException();
        }

        R07_ERR06_J.throwable = throwable;
        try {
            Constructor<R07_ERR06_J> constructor = R07_ERR06_J.class.getDeclaredConstructor();
            constructor.setAccessible(true); 
            constructor.newInstance();
        } catch (InstantiationException e) { 
        } catch (IllegalAccessException e) { 
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause != null) {
                throw new RuntimeException("Undeclared checked exception occurred", cause);
            } else {
                throw new RuntimeException("Undeclared checked exception occurred", e);
            }
        } catch (NoSuchMethodException e) { 
        } finally { 
            R07_ERR06_J.throwable = null;
        }
    }

    public static void main1(String[] args) {
        try {
            R07_ERR06_J.undeclaredThrow(
                new Exception("Any checked exception"));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        R07_ERR06_J.undeclaredThrow(
            new Exception("Any checked exception"));
    }
}

