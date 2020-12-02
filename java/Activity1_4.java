package JavaActivity;

import java.util.Arrays;

class Activity1_4 {  
    public static void main(String args[]) {
        int[] array = {77, 54, 10, 15, 12};
        System.out.println("Array before sorting: " + Arrays.toString(array));
        ascendingSort(array);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(array));
    }
    static void ascendingSort(int array[]) {     
    	for (int i = 1; i < array.length; i++) {
            int key = array[i]; 
            int j = i - 1;
            
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }
}

