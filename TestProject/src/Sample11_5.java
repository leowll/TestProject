public class Sample11_5 {

	public static void main(String[] args) {

		try {
			ThreadA a = new ThreadA();
			a.start();
			System.out.println("main : sleep start.");
			Thread.sleep(1000);
			System.out.println("main : sleep end.");
			a.interrupt();
		} catch (InterruptedException e) {
			
		}
	}
	
}

class ThreadA extends Thread{
	@Override
	public void run() {
		try {
			System.out.println("Thread A : sleep start");
			Thread.sleep(5000);
			System.out.println("Thread A : sleep end");
		} catch (InterruptedException e) {
			System.out.println("Catch Thread A interrupted");
		}
		System.out.println("Thread A finished.");
	}
}