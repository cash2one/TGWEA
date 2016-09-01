package com.etaoguan.wea.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface WeaFunction {
	public enum Operation {CREATE,READ,UPDATE,DELETE};
	
	String fname();
	
	Operation oname();
}