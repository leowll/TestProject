public class ThreadTest1 {

	public static void main(String[] args) {
		ThreadDemo t1 = new ThreadDemo("t1");
		ThreadDemo t2 = new ThreadDemo("t2");

		t1.start();
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	}

}

class ThreadDemo extends Thread {
	String name = "";

	ThreadDemo(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				sleep(1000);
				System.out.println("Slept for" + this.name);
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
			}

		}
	}

}
