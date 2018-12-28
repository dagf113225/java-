package com.lixin.ch0;
//https://www.cnblogs.com/Qian123/p/5256084.html
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解的作用就是替代或者说简化xml的配置，更加轻量级的符合java快捷开发的要求。
//@Target 元注解  描述了UserDesc这个注解可以使用的范围:1.类  2.变量  3.方法
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserDesc {
	
	String  name();
	
	int  age()  default  0;

}
