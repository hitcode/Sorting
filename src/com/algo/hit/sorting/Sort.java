package com.algo.hit.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort<T> {
	
	
	
	public static <T extends Comparable> void merge(Comparable[] array,int lo ,int mid,int hi,Comparable[] tempArray)
	{
		
		for(int i=0;i<array.length;i++)
		{
			tempArray[i]=array[i];
		}
		
		int start=lo;
		int l=lo;
		int m=mid+1;
		int h=hi;
		
		while(l<=mid && m<=hi)
		{
			if(tempArray[l].compareTo(tempArray[m])==-1 || tempArray[l].compareTo(tempArray[m])==0)
			{
				array[start]=tempArray[l];
				l++;
				start++;
			}
			else
			{
				array[start]=tempArray[m];
				start++;
				m++;
			}
			
		}
		while(l<=mid)
		{
			array[start]=tempArray[l];
			l++;
			start++;
		}
		
		while(m<=hi)
		{
			array[start]=tempArray[m];
			start++;
			m++;
		}
		
		
		
		
	}
	
	public static <T extends Comparable> void mergeSort(Comparable[] array,int lo ,int hi ,Comparable [] tempArray)
	{
		
		int partition=lo+(hi-lo)/2;
		
		if(partition>lo)
			mergeSort(array,lo,partition,tempArray);
		if(hi>partition+1)
			mergeSort(array,partition+1,hi,tempArray);
		
		merge(array,lo,partition,hi,tempArray);
		
		
	}
	
	
	public static <T extends Comparable> void mergeSort(Comparable[] array)
	{
		
		Comparable[] temp = new Comparable[array.length];
		mergeSort(array,0,array.length-1,temp);
		
	}
	
	public static<T extends Comparable>  void swap(T [] array,int i,int j)
	{
		
		 T temp=array[i];
		 array[i]=array[j];
		 array[j]=temp;
	}
	
	
	public static<T extends Comparable> void quickSort(T[] array,int lo,int hi)
	{
		
		 int pivot_index=lo;
		 int l=lo+1;
		 int h=hi;
		 
		 while(l<=h)
		 {
			 
			 while(l<array.length && array[pivot_index].compareTo(array[l])==-1)
			 {
				 l++; 
				 
			 }
			 
			 while(h>0 && ( array[pivot_index].compareTo(array[h])==1 
					 || array[pivot_index].compareTo(array[h])==0))
			 {
				 h--; 
				 
			 }
			 
			 if(l<h)
				 swap(array,l,h);
			 
			 
		 }
		 
		 swap(array,pivot_index,h);
		 if(h-1>lo)
		 quickSort(array,lo,h-1);
		 if(hi>h+1)
		 quickSort(array,h+1,hi);
		 
		 
		 
		 
		
		
	}
	
	public static <T extends Comparable> void quickSort(T[] array)
	{
		
		quickSort(array,0,array.length-1);
	}
	
	
	
	public static <T extends Comparable> void insertionSort(T[] array)
	{
		
		int length=array.length;
		
		
		for(int i=1;i<length;i++)
		{
			int j=i;
			
			while(j>0 && array[j].compareTo(array[j-1])==1)
			{
				
				T temp=array[j];
				array[j]=array[j-1];
				array[j-1]=temp;
				j--;
			}
		}
		
	}
	public static<T extends Comparable> void selectionSort(T[] array)
	{
		int length=array.length;
		
		for(int i=0;i<length-1;i++)
		{
			int min_index=i;
			for(int j=i+1;j<length;j++)
			{
				int a=array[min_index].compareTo(array[j]);
				if(a==-1)
					min_index=j;
				
			}
			
			T temp=array[i];
			array[i]=array[min_index];
			array[min_index]=temp;
			
		}
	}
	
	
	public static void main (String [] args)
	{
		
		Integer [] arr={12,2,1123,123,45,214,123,445,21421,2,12};
		mergeSort(arr);
		
		for(int i:arr)
			System.out.print(i+  " ");
	}

}
