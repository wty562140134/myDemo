package reflectDemo.reflect;

public class reflectTestClass {

	private String selfName;
	public String publicName;

	public reflectTestClass() {
		print("无参构造函数");
	}

	public reflectTestClass(String selfName, String publicName) {
		print("有参构造函数");
		this.selfName = selfName;
		this.publicName = publicName;
	}

	public <T> void print(T args) {
		System.out.println(args);
	}

	private void showSelf() {
		print("reflectTest类私有方法" + selfName);
	}

	public void showPublic() {
		print("reflectTest类共有方法" + publicName);
	}

}