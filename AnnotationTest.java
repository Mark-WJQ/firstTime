package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface AnnotationTest {
	
	String value() default "hello";
	String value1() default "world";
	
}


enum EnumTest{
<<<<<<< HEAD
	Hello,World,Welcome,I;
}
=======
	Hello,World,Welcome,M;
}
>>>>>>> 1bb87d6f6ffa8269be0290f9936dcbaec697704d
