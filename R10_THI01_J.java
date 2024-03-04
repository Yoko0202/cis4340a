package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class R10_THI01_J {
  
  final class HandleRequest implements Runnable {
    public void run() {
      // example processing
      System.out.println(Thread.currentThread().getName() + " is processing a request.");
      try {
        Thread.sleep(1000); //example  time
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt(); 
      }
      System.out.println(Thread.currentThread().getName() + " has finished processing.");
    }
  }

  public final class NetworkHandler {
    private final ExecutorService executor;
   
    NetworkHandler(int poolSize) {
      this.executor = Executors.newFixedThreadPool(poolSize);
    }
   
    public void startThreads() {
      for (int i = 0; i < 3; i++) {
        executor.execute(new HandleRequest());
      }
    }
   
    public void shutdownPool() {
      executor.shutdown();
    }
  }

  public static void main(String[] args) {
    R10_THI01_J r10 = new R10_THI01_J();
    NetworkHandler nh = r10.new NetworkHandler(3);
    nh.startThreads();
    nh.shutdownPool();
  }
}

