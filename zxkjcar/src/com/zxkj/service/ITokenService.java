package com.zxkj.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ITokenService {
	//生成token并保存
    boolean save() default false;

    //删除token
    boolean remove() default false;
}