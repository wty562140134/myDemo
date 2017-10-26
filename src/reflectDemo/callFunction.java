package reflectDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import reflectDemo.reflect.reflectTestClass;
import reflectDemo.reflect.reflectTestClass1;

public class callFunction {

	/**
	 * 调用函数的反射函数
	 * 
	 * @param clazz
	 *            被调用函数的class对象
	 * @param callFunName
	 *            被调用的函数名
	 * @param isPrivate
	 *            是私有方法么
	 * @param args
	 *            被调用函数传入参数
	 */
	public void invokeFunction(Class<?> clazz, String callFunName,
			Boolean isPrivate, Object... args) {
		Method method = getMed(clazz, callFunName, getClassParams(args));
		method.setAccessible(isPrivate);
		try {
			method.invoke(clazz.newInstance(), args);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取调用函数
	 * 
	 * @param clazz
	 *            调用函数所在类
	 * @param funName
	 *            调用函数名
	 * @param args
	 *            调用函数传入参数
	 * @return 调用函数
	 */
	private Method getMed(Class<?> clazz, String funName, Class<?>... args) {
		Method method = null;
		try {
			method = clazz.getDeclaredMethod(funName, args);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return method;
	}

	/**
	 * 获取参数所在的类
	 * 
	 * @param args
	 *            传入的参数
	 * @return 传入参数的类的数组
	 */
	private Class<?>[] getClassParams(Object... args) {
		Class<?>[] clazzs = null;
		if (args != null) {
			clazzs = new Class<?>[args.length];
			for (int i = 0; i < args.length; i++) {
				clazzs[i] = args[i].getClass();
			}
		}
		return clazzs;
	}

	public static void main(String[] args) {
		callFunction call = new callFunction();
		call.invokeFunction(reflectTestClass1.class, "eat", true, "apple");
	}
}