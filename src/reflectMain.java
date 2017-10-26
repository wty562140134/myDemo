import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import reflectDemo.callFunction;
import reflectDemo.reflect.reflectTestClass;

public class reflectMain {

	public void myinvoken(Class<?> invokenClass, String invokenFunctionName,
			Boolean isPrivate, Object... params) {
		Class<callFunction> callClass = callFunction.class;
		Method method = getInvokenMethod(callClass);
		invokenFun(callClass, method, invokenClass, invokenFunctionName,
				isPrivate, params);
	}

	public Method getInvokenMethod(Class<callFunction> clazz) {
		Method method = null;
		try {
			method = clazz.getDeclaredMethod("invokeFunction", Class.class,
					String.class, Boolean.class, Object[].class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return method;
	}

	public void invokenFun(Class<callFunction> callClass, Method method,
			Class<?> invokenClass, String invokenFunName, Boolean isPrivate,
			Object... params) {
		try {
			method.invoke(callClass.newInstance(), invokenClass,
					invokenFunName, isPrivate, params);
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

	public static void main(String[] args) {
		// 通过反射调用反射Demo
		Class<callFunction> clazz = callFunction.class;
		Method method = null;
		try {
			method = clazz.getDeclaredMethod("invokeFunction", Class.class,
					String.class, Boolean.class, Object[].class);
			method.invoke(clazz.newInstance(), reflectTestClass.class, "print",
					true, new Object[] { "通过反射调用反射函数调用正常函数Demo" });
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
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
}
