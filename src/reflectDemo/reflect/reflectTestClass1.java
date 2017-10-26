package reflectDemo.reflect;

public class reflectTestClass1 {

	private String name;
	public String sex;

	public reflectTestClass1() {
		this.name = "jack";
		this.sex = "man";
	}

	private void printName() {
		System.out.println("name is:" + this.name);
	}

	private void eat(String food) {
		System.out.println(this.name + "eat" + food);
	}

	public void setName(String name) {
		this.name = name;
		printName();
	}

	public void printAll() {
		System.out.println("name is:" + this.name + "sex is:" + this.sex);
	}
}
