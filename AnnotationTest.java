package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//标志子类继承父类的注解
@Inherited  
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface AnnotationTest {
	
	String value() default "hello";
	String value1() default "world";
	
}


enum EnumTest{
	Hello,World,Welcome,M;
}
