public class Sample42 {
	public static void main(String[] args) {
		try (MyResource mr = new MyResource()) {
			System.out.println("Try");
			throw new Exception();
		} catch (Exception e) {
			System.out.println("Catch");
		} finally {
			System.out.println("Finally");
		}

	}
}

class MyResource implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("Close");
	}
}