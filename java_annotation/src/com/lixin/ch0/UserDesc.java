package com.lixin.ch0;
//https://www.cnblogs.com/Qian123/p/5256084.html
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//ע������þ����������˵��xml�����ã������������ķ���java��ݿ�����Ҫ��
//@Target Ԫע��  ������UserDesc���ע�����ʹ�õķ�Χ:1.��  2.����  3.����
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserDesc {
	
	String  name();
	
	int  age()  default  0;

}
