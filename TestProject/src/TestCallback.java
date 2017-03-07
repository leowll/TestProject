
/**
 * 电话系统 可以回叫用户
 * 
 * @author I336694
 *
 */
interface TelephoneSystem {
	/**
	 * 回叫功能，内容未定
	 * 
	 * @return
	 */
	public void callBack();
}

/**
 * 
 * @author I336694
 *
 */
class Caller {

	private TelephoneSystem telephoneSystem;

	/**
	 * 安装一部电话机
	 * 
	 * @param telephoneSystem
	 */
	public void register(TelephoneSystem telephoneSystem) {
		this.telephoneSystem = telephoneSystem;
	}

	/**
	 * 工作
	 */
	public void doWork() {
		new Thread() {
			public void run() {
				System.out.println("I want to query something, call me back if you find it!");
				telephoneSystem.callBack();
			}
		}.start();
		
		new Thread() {
			public void run() {
				System.out.println("I have something else to do!");
			}
		}.start();

	}
}

/**
 * 办公桌上安装有一部电话，可以“实现”回叫功能
 * 
 * @author I336694
 *
 */
class MyTelephone implements TelephoneSystem {
	/**
	 * 回电话的功能
	 */
	public void callBack() {
		System.out.println("CALLED BACK");
	}

}

public class TestCallback {

	public static void main(String[] args) {
		Caller b = new Caller();
		TelephoneSystem ts = new MyTelephone();
		b.register(ts);
		b.doWork();
	}

}
