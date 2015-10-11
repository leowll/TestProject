import java.util.concurrent.*;

class FJSample extends RecursiveTask<Integer> {
	/**
	 * 並列処理で１〜nまでの合計を計算
	 */
	private static final long serialVersionUID = 2642207809048844236L;
	final int no;

	public FJSample(int no) {
		this.no = no;
	}

	protected Integer compute() {
		if (no <= 1) {
			return no;
		}
		FJSample fj1 = new FJSample(no - 1);
		fj1.fork();
		FJSample fj2 = new FJSample(no - 2);
		return fj2.compute() + fj1.join();
		// ----並列処理しない書き方----
		// return fj1.join() + fj2.compute();
		// fj1.join()を先に呼び出すことで、１９行目で非同期実行した結果を待ってからfj2.compute()の呼び出しを行っている。
		// つまり、21行目の処理は分割したタスクを平行に実行しているのではなく、
		// それぞれ単一のスレッドで実行している状態と変わらない結果になります。

	}
}

public class Sample11_15 {
	public static void main(String[] args) {
		int i = Integer.parseInt(args[0]);
		ForkJoinPool pool = new ForkJoinPool();
		int res = pool.invoke(new FJSample(i));
		System.out.println(res);
	}
}
