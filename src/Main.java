public class Main {
	public static volatile int i = 0;
	
	public static void main(String[] args) {
		MinhaThread mT1 = new MinhaThread(1);
		MinhaThread mT2 = new MinhaThread(2);
		MinhaThread mT3 = new MinhaThread(3);
		
		mT1.setPriority(Thread.MIN_PRIORITY);
		mT2.setPriority(Thread.MAX_PRIORITY);
		mT1.start();
		mT2.start();
		mT3.start();
		for(i = 0; i < 99; i++) {
			System.out.println("Valor de i na thread principal: " + i);
		}
		System.err.println("Terminou thread principal. P:" + Thread.currentThread().getPriority());
	}
}
class MinhaThread extends Thread {
	int numThread = 0;
	MinhaThread(int num) {
		this.numThread = num;
	}

	public void run() {
		for(int i = Main.i; Main.i < 99; Main.i++) {
			System.out.println("Valor de i na thread " + numThread + " é: " + Main.i);
			//largestPrimeFactor(99999);
		}
		System.err.println("Terminou thread " + numThread + ". P:" + Thread.currentThread().getPriority());
	}
	
	int largestPrimeFactor(int n) {
	  if (n <= 1) {
		  return 0;  
	  } else {
		  int div = 2;  
		  while (div < n) {
			  if (n % div != 0) {
				  div++;  
			  } else {
				  n = n / div;
				  div = 2;  
			  	}
		  }
		  return n;
	  }
	}
}
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//
//    public static volatile  int a = 0;
//    public static void main(String args[]) throws InterruptedException{
//
//        List<Thread> list = new  ArrayList<Thread>();
//        for(int i = 0 ; i<11 ;i++){
//            list.add(new Pojo());
//        }
//
//        for (Thread thread : list) {
//            thread.start();
//        }
//
//        Thread.sleep(20000);
//        System.out.println(a);
//    }
//}
//class Pojo extends Thread{
//    int a = 10001;
//    public void run() {
//        while(a-->0){
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            Main.a++;
//            System.out.println("a = "+Main.a);
//        }
//    }
//}