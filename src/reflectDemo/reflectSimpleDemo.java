package reflectDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import reflectDemo.reflect.reflectTestClass;
import reflectDemo.reflect.reflectTestClass1;

public class reflectSimpleDemo<T> {

	private T Instance = null;

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
	@SuppressWarnings("unchecked")
	public void invokeFunction(Class<?> clazz, String callFunName,
			Boolean isPrivate, Object... args) {
		Method method = getMed(clazz, callFunName, getClassParams(args));
		method.setAccessible(isPrivate);
		try {
			if (this.Instance == null) {
				this.Instance = (T) clazz.newInstance();
				method.invoke(this.Instance, args);
			} else {
				method.invoke(Instance, args);
			}
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | InstantiationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置构造函数，用指定的构造函初始化需要调用函数的类
	 * 
	 * @param clazz
	 * @param callFunName
	 * @param constructorParams
	 */
	@SuppressWarnings({ "unchecked" })
	public void useConstructorInstance(Class<?> clazz,
			Object... constructorParams) {
		try {
			Constructor<?> cons = clazz
					.getConstructor(getClassParams(constructorParams));
			this.Instance = (T) cons.newInstance(constructorParams);
		} catch (NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
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
		} catch (NoSuchMethodException | SecurityException
				| IllegalArgumentException e) {
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

	public T getInstance() {
		return this.Instance;
	}

	public static void main(String[] args) {
		reflectSimpleDemo<reflectTestClass> call = new reflectSimpleDemo<reflectTestClass>();
		call.invokeFunction(reflectTestClass.class, "showPublic", false);
		call.getInstance().print(123);

		// Class<?> clazz = constructorReflectTestClass.class;
		// String callFunName = "printChange";
		// callFunction<constructorReflectTestClass> c = new
		// callFunction<constructorReflectTestClass>();
		// c.invokeFunction(constructorReflectTestClass.class, "print", false);
		// c.useConstructorInstance(constructorReflectTestClass.class, "fuck");
		// c.invokeFunction(clazz, callFunName, false, "jack");
	}
}