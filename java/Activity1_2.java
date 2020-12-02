package JavaActivity;

import java.util.*;

public class Activity1_2 {
    public static void main(String[] args) {
        int[] arr1 = {10, 77, 10, 54, -11, 10};
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Result: " + result(arr1));
    }
    public static boolean result(int[] arr1) {
    	int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
    		if (arr1[i] == 10) {
    			sum += arr1[i];
    			}
        }
        System.out.println("sum of all the 10's in the array: " + sum);
    	return sum == 30;		
    		}
    }
