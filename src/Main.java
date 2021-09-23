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
		for(int i = 0; i < 99; i++) {
			largestPrimeFactor(99999);
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