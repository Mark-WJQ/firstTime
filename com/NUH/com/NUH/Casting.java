package com.NUH;



import java.util.Random;

class Letter{
	char c;
}

class Tank{
	int level;
}

class TestFloat{
	float level;
}

class Value{
	int i;
}

public class Casting {

	static void f(Letter y){
		y.c = 'z';
	}
	
	
	static  void CastingNumber(){
		double above = 0.7,below = 0.4;
		float fabove = 0.7f,fbelow = 0.4f;
		System.out.println("(int)above"+(int)above);
		System.out.println("(int)below"+(int)below);
		System.out.println("(int)fabove"+(int)fabove);
		System.out.println("(int)fbelow"+(int)fbelow);
	}
	
	static void roundingNumbers(){
		double above = 0.7,below = 0.4;
		float fabove = 0.7f,fbelow = 0.4f;
		System.out.println("Math.round(above):"+ Math.round(above));
		System.out.println("Math.round(below):"+ Math.round(below));
		System.out.println("Math.round(fabove):"+ Math.round(fabove));
		System.out.println("Math.round(fbelow):"+ Math.round(fbelow));
	}
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int i = 200;
		long lng = (long)i;
		lng = i;
		long lng2 = (long)200;
		i = (int)lng2;*/
		//CastingNumber();
		//roundingNumbers();
		/*Letter x = new Letter();
		x.c = 'a';
		System.out.println("1:x.c:"+ x.c);
		f(x);
		System.out.println("2:x.c:"+ x.c);*/
		//别名现象
		/*Tank t1 = new Tank();
		Tank t2 = new Tank();
		t1.level = 9;
		t2.level = 47;
		System.out.println("1: t1.level: "+t1.level + " t2.level : "+t2.level);
		t1 = t2;    //t1,t2指向同一个引用，赋值操作的是一个对象的引用，有别于t1.level = t2.level;
		System.out.println("1: t1.level: "+t1.level + " t2.level : "+t2.level);
		t1.level = 27;
		System.out.println("1: t1.level: "+t1.level + " t2.level : "+t2.level);
		TestFloat tf1 = new TestFloat();
		TestFloat tf2 = new TestFloat();
		tf1.level = 5f;
		tf2.level = 12f;
		System.out.println("1: tf1.level: "+tf1.level + " tf2.level : "+tf2.level);
		tf1 = tf2;
		System.out.println("1: tf1.level: "+tf1.level + " tf2.level : "+tf2.level);
		tf1.level = 22.0f;
		System.out.println("1: tf1.level: "+tf1.level + " tf2.level : "+tf2.level);*/
		/*运算符
		Random rand = new Random(47);
		int i,j,k;
		j = rand.nextInt(100)+1;
		System.out.println("j : "+ j);
		k = rand.nextInt(100)+1;
		System.out.println("k : "+ k);
		i = j + k;
		System.out.println("j + k :" + i);
		i = j - k;
		System.out.println("j - k : " + i);
		i = k / j;
		System.out.println("k / j :" + i);
		i = k * j;
		System.out.println("k * j :" + i);
		i = k % j ;
		System.out.println("k % j : " + i);
		float u,v,w;
		v = rand.nextFloat();
		System.out.println("v : "+ v);
		u = rand.nextFloat();
		System.out.println("u : "+ u);
		w = u + v;
		System.out.println("u + v: " + w);
		w = u - v;
		System.out.println("u - v: " + w);
		w = u * v;
		System.out.println("u * v: " + w);
		w = u / v;
		System.out.println("u / v: " + w);
		w = u % v;
		System.out.println("u % v: " + w);
		w += v;
		System.out.println("w += v " + w);
		w -= v;
		System.out.println("w -= v " + w);
		w *= v;
		System.out.println("w *= v " + w);
		w /= v;
		System.out.println("w /= v " + w);
		w %= v;
		System.out.println("w %= v " + w);*/
		
		/*int i = 1;
		System.out.println("i : " + i);
		System.out.println("++i : " + ++i);
		System.out.println("i++ : " + i++);
		System.out.println("i : " + i);
		System.out.println("--i : " + --i);
		System.out.println("i-- : " + i--);
		System.out.println("i : " + i);*/
		
		//测试对象的等价性
		/*Integer n1 = new Integer(15);
		Integer n2 = new Integer(15);
		System.out.println(n1 == n2);    //false     
		System.out.println(n1.equals(n2));    //true    n1,n2是对象不是基本数据类型
		System.out.println(n1 != n2);   //true
*/	
		Value v1 = new Value();
		Value v2 = new Value();
		v1.i = v2.i = 100;
		System.out.println(v1.equals(v2));
	}
	
}
