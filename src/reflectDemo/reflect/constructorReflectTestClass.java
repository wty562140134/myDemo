package reflectDemo.reflect;

public class constructorReflectTestClass {

	private String a;
	private Integer b;

	public constructorReflectTestClass() {
		System.out.println("使用了无参构造函数");
	}

	public constructorReflectTestClass(String a) {
		this.a = a;
		System.out.println("使用了初始化a的构造函数");
	}

	public constructorReflectTestClass(Integer b) {
		this.b = b;
		System.out.println("使用了初始化b的构造函数");
	}

	public constructorReflectTestClass(String a, Integer b) {
		this.a = a;
		this.b = b;
		System.out.println("使用了初始化a,b的构造函数");
	}

	public void print() {
		System.out.println(this.a + this.b);
	}

	public void printChange(String name) {
		System.out.println(name + " change " + this.a + " and " + this.b);
	}

}