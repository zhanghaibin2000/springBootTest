package com.zhb.server.test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.tomcat.util.digester.SetPropertiesRule;
import org.springframework.beans.CachedIntrospectionResults;

public class mainTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Class<Sub> class1 = Sub.class;
		System.out.println("============================Field===========================");  
        //public + 继承  
        System.out.println(Arrays.toString(class1.getFields()));  
        //all + 自身  
        System.out.println(Arrays.toString(class1.getDeclaredFields()));  
          
        System.out.println("============================Method===========================");  
        //public + 继承  
        System.out.println(Arrays.toString(class1.getMethods()));  
        //all + 自身  
        System.out.println(Arrays.toString(class1.getDeclaredMethods()));  
          
        System.out.println("============================Constructor===========================");  
        //public + 自身  
        System.out.println(Arrays.toString(class1.getConstructors()));  
        //all + 自身  
        System.out.println(Arrays.toString(class1.getDeclaredConstructors()));  
          
          
        System.out.println("============================AnnotatedElement===========================");  
        //注解DBTable2是否存在于元素上  
        System.out.println(class1.isAnnotationPresent(DBTable2.class));  
        //如果存在该元素的指定类型的注释DBTable2，则返回这些注释，否则返回 null。  
        System.out.println(class1.getAnnotation(DBTable2.class));  
        //继承  
        System.out.println(Arrays.toString(class1.getAnnotations()));  
        //自身  
        System.out.println(Arrays.toString(class1.getDeclaredAnnotations()));  
        
        System.out.println("============================PropertyDescriptor===========================");  
        
        Sub sub = new Sub(1);
        setPropertiesRule(sub, "a", "hello1");
        System.out.println(getProperties(sub, "a"));
        System.out.println(getProperties1(sub, "a"));
        
//        PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(class1).getPropertyDescriptors();
//        System.out.println(propertyDescriptors);
         
	}
	
	public static Object invokeMethod(Object ownerObject, String methodName, Object[] methodObjects)  
            throws Exception {  
		Class ownerClass =  ownerObject.getClass();//首先还是必须得到这个对象的Class
		Class[] methodClasss = new Class[methodObjects.length];
		for(int i = 0; i < methodObjects.length; i++) {
			methodClasss[i] = methodObjects[i].getClass();
		}
		Method method = ownerClass.getMethod(methodName, methodClasss);//通过methodName和参数的argsClass（方法中的参数类型集合）数组得到要执行的Method。
		return method.invoke(ownerObject, methodObjects);//执行该Method.invoke方法的参数是执行这个方法的对象owner，和参数数组args，可以这么理解：owner对象中带有参数args的method方法。返回值是Object，也既是该方法的返回值。	
	}
	
	public static void setPropertiesRule(Object ownerObject,  String propertiesName, Object value) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertiesName, ownerObject.getClass());
		Method method = propertyDescriptor.getWriteMethod();
		method.invoke(ownerObject, value);
	}
	
	public static Object getProperties(Object ownerObject, String propertiesName) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertiesName, ownerObject.getClass());
		Method method = propertyDescriptor.getReadMethod();
		return method.invoke(ownerObject);
	}
	
	public static Object getProperties1(Object ownerObject, String propertiesName) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		BeanInfo beanInfo = Introspector.getBeanInfo(ownerObject.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		Object returnValue = null;
		for(PropertyDescriptor propertyDescriptor :propertyDescriptors ) {
			if (propertyDescriptor.getName().equals(propertiesName)) {
				returnValue = propertyDescriptor.getReadMethod().invoke(ownerObject);
			}
		}
		return returnValue;
	}

}


