package reflectDemo;

import java.lang.reflect.Modifier;

import reflectDemo.reflect.reflectTestClass;

public class reflectApiDemo {

	public static void main(String[] args) {
		// 参考http://blog.csdn.net/coslay/article/details/38084343
		/** 获取类的方式 */
		/* 获取类方式1 */
		Class<?> clazz = reflectTestClass.class;
		/* 获取类方式2 */
		try {
			Class<?> clazz1 = Class.forName("reflectTest.reflect.reflectTest");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/* 获取类方式3 */
		Class<?> clazz2 = new reflectTestClass().getClass();

		/** 获取类名的方式 */
		/* 获取类名方式1 */
		String clazzName = clazz.getName();
		/* 获取类名方式2 */
		String clazzName1 = clazz.getCanonicalName();
		/* 获取不包涵包名的类名 */
		String simpleClassName = clazz.getSimpleName();

		/** 获取类的修饰符 */
		int modifiers = clazz.getModifiers();
		/* 使用Modifier类的toString查看类的修饰符 */
		String retval = Modifier.toString(modifiers);
		/* 判断类修饰符方法返回boolean结果方法: */
		// Modifier.isAbstract(modifiers);
		// Modifier.isFinal(modifiers);
		// Modifier.isInterface(modifiers);
		// Modifier.isNative(modifiers);
		// Modifier.isPrivate(modifiers);
		// Modifier.isProtected(modifiers);
		// Modifier.isPublic(modifiers);
		// Modifier.isStatic(modifiers);
		// Modifier.isStrict(modifiers);
		// Modifier.isSynchronized(modifiers);
		// Modifier.isTransient(modifiers);
		// Modifier.isVolatile(modifiers);

		/** 获取包信息 */
		/* 获取Package对象 */
		Package pack = clazz.getPackage();
		/* 获取包名 */
		String packName = pack.getName();

		/** 获取父类 */
		Class superclazz = clazz.getSuperclass();

		/** 获取实现的接口 */
		Class[] interfaces = clazz.getInterfaces();
		System.out.println(interfaces);
	}
}