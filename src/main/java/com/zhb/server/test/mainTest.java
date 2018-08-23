package com.zhb.server.test;

import java.util.Arrays;

public class mainTest {

	public static void main(String[] args) {
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
         
	}

}
