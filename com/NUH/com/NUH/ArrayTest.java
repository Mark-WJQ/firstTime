package com.NUH;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*int[][] a = new int [2][];
		a[0] = new int[]{};
		int[][] b = new int [][]{{1,2,3},{2,3,4,5}};
		System.out.println(b[1][3]);
		System.out.println(a[0] instanceof int[]);*/
		///a[0] = {1,2,3};
		
		/*int[] a = new int[4];
		a[1] = 1;
		int[] b = {1,2,3};
		int[] c = {1,2,3};
		System.out.println(b.equals(c));
		System.out.println(a.length);*/
		
		
		
		int[] a = new int[20];
		for(int i = 0;i < 20; i++){
			a[i] = new Random().nextInt(100);
			System.out.print(a[i] + "   ");
		}
		System.out.println("");
		a[10] = 20;
		arraySort2(a);
		for(int i = 0;i < 20; i++){
			System.out.print(a[i] + "   ");
		}
		System.out.println();
		System.out.println(binarySearch(a,20));
		System.out.println(search(new int[]{10},10));
		
		
	}

	
	
	
	
	public static void arraySort(int[] a){
		int length = a.length;
		if(length > 1){
			int temp;
			for(int i = 1;i < length; i++){
				for(int j = 0; j < i; j++){
					if(a[i] < a[j]){
						temp = a[j];
						a[j] = a[i];
						a[i] = temp;
					}
				}	
			}
			
		}	
	}
	
	public static void arraySort1(int[] a){
		int length = a.length;
		if(length > 1){
			int temp;
			for(int i = 1;i < length; i++){
				for(int j = 0; j < length - 1; j++){
					if(a[i] < a[j]){
						temp = a[j];
						a[j] = a[i];
						a[i] = temp;
					}
				}	
			}
			
		}	
	}
	
	
	//冒泡排序
	public static void arraySort2(int[] a){
		int length = a.length;
		if(length > 1){
			int temp;
			for(int i = 0;i < length - 1; i++){
				for(int j = 0; j < length - i - 1; j++){
					if(a[j] > a[j+1]){
						temp = a[j];
						a[j] = a[j+1];
						a[j+1] = temp;
					}
				}	
			}
			
		}	
	}
	
	
	public static void quickSort(int[] a){
		int left = 0;
		int right = a.length - 1;
		int a1 = a[left];
		while(left < right){
			if(a1 < a[right]){
				right --;
			}
			if(left < right)
				a[left] = a[right];
			if(a1 > a[left])
				left ++;
			if(left < right)
				a[right] = a[left];
		}
		a[left] = a1;
		
		
		
		
		
	}
	
	public static int search(int[] a,int b){
		
		if(a.length == 0){
			return -1;
		}
		
		if(a.length == 1){
			if(b == a[0]){
				return 0;
			}
		}
		
		int i = a.length/2;
		while(i != 0){
			if(a[i] == b){
				return i;
			}else if(a[i] > b){
				i = i - i/2;
			}else if(a[i] < b){
				i = i + i/2;
			}
		}
		return -1;
	}
	
	//二分查找
	public static int binarySearch(int[] a,int b){
		int low = 0;
		int high = a.length - 1;
		while(low <= high){
			int mid = (low + high)/2;
			int midValue = a[mid];
			System.out.println(mid + "    " +midValue);
			if(b == midValue){
				return mid;
			}else if(b > midValue){
				low = mid + 1;
			}else if(b < midValue){
				high = mid - 1;
			}
		}
		return -1;
	}
	
	
}
