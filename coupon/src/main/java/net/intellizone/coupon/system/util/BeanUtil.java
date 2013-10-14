package net.intellizone.coupon.system.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @名称:java反射帮助类
 * @作用:提供对象,属性,方法之间转换的常用方法
 * 		在对象或者类中,有的属性不可访问,可以通过 xxx.setAccessible(true);
 * @dateTime: May 29, 2009
 */
public class BeanUtil {
	/**
	 * @作用:通过一个对象 以及 一个属性名称,取出该属性的值
	 * @dateTime: May 29, 2009
	 * @param owner
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	public static Object getPropertyValue(Object owner, String fieldName) throws Exception {
		Class ownerClass = owner.getClass();
		Field field = null;
		try {
			field = ownerClass.getDeclaredField(fieldName);
		}catch(Exception ex) {
			field = ownerClass.getSuperclass().getDeclaredField(fieldName);
		}
		field.setAccessible(true);
		Object fieldVlaue = field.get(owner);
		return fieldVlaue;
	}

	/**
	 * @作用:获取一个类的静态属性的值
	 * @dateTime: May 29, 2009
	 * @param className
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	public static Object getStaticPropertyValue(String className, String fieldName) throws Exception {
		Class ownerClass = Class.forName(className);
		Field field = ownerClass.getDeclaredField(fieldName);
		field.setAccessible(true);
		Object fieldVlaue = field.get(ownerClass);
		return fieldVlaue;
	}
	/**
	 * 对象属性复制
	 * @param dist
	 * @param source
	 */
	public static void copyProperties(Object dist, Object source) {
		try {
			PropertyUtils.copyProperties(dist, source);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @作用:通过对象,方法名称以及参数 来 调用方法
	 * @dateTime: May 29, 2009
	 * @param owner
	 * @param methodName
	 * @param args
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
		Class ownerClass = owner.getClass();
		Class[] argsClass = new Class[args.length];
		int i = 0;
		for (int j = args.length; i < j; ++i) {
			argsClass[i] = args[i].getClass();
		}

		Method method = ownerClass.getDeclaredMethod(methodName, argsClass);
		method.setAccessible(true);
		return method.invoke(owner, args);
	}

	/**
	 * @作用:调用静态方法
	 * @dateTime: May 29, 2009
	 * @param className
	 * @param methodName
	 * @param args
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Object invokeStaticMethod(String className, String methodName, Object[] args) throws Exception {
		Class ownerClass = Class.forName(className);
		Class[] argsClass = new Class[args.length];
		int i = 0;
		for (int j = args.length; i < j; ++i)
			argsClass[i] = args[i].getClass();

		Method method = ownerClass.getMethod(methodName, argsClass);
		method.setAccessible(true);
		return method.invoke(null, args);
	}
	
	/**
	 * @作用:获取所有申明的字段
	 * @dateTime: May 29, 2009
	 * @param className
	 * @return
	 */
	public static Field[] getDeclaredFields(String className) {
		Class targetClass = null;
		try {
			targetClass = Class.forName(className);
			if (!(targetClass.isPrimitive()) && !(targetClass == String.class))
				return targetClass.getDeclaredFields();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取Class clazz的实体类型
	 * @param clazz
	 * @param index=0
	 * @return
	 */
	public static Class getGenericClass(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();
		if (genType instanceof ParameterizedType) {
			Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
			if ((params != null) && (params.length >= index - 1))
				return ((Class) params[index]);
		}
		return null;
	}
}