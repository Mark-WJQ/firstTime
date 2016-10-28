package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@AnnotationTest(value1 = "beijing", value = "honglian")
public class Test1 {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Test1 t1 = new Test1();
		Class<?> classType = t1.getClass();
		Method method = classType.getMethod("output");
		if(method.isAnnotationPresent(AnnotationTest.class)){
			AnnotationTest annotationTest = method.getAnnotation(AnnotationTest.class);
			method.invoke(t1);
		}
		
		
		Annotation[] annotations = classType.getAnnotations();
		
		for(Annotation annotation : annotations){
			annotation.annotationType().getName();
			AnnotationTest annotationTest = (AnnotationTest)annotation; 
			String value = annotationTest.value();
			String value1 = annotationTest.value1();
			
			System.out.println(value + " " +value1);
		}
		
		
	}
	
	@Deprecated
	@AnnotationTest(value1 = "beijing", value = "honglian")
	public void output(){
		System.out.println("output something");
	}
}
