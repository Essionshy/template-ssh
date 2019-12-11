package com.tingyu.template.ssh.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 泛型工具类
 * @author Essionshy
 *
 */
public class GenericUtils {

	/**
	 * 1、如果要获取的泛型的具体类型，形参中没有，而类上带有，则需要通过下面的方法来获取泛型类型
	 * @param index
	 * @return
	 */
	public Class<?> getGenericClass(int index) {
		// 1、获取当前类的父类的泛型类型
		Type genericSuperclass = this.getClass().getGenericSuperclass();

		// 2、获取当前类父类的泛型的参数类型

		ParameterizedType pt = (ParameterizedType) genericSuperclass;

		Type[] arguments = pt.getActualTypeArguments();

		Class<?> clazz = (Class<?>) arguments[index];
		return clazz;
	}
}
