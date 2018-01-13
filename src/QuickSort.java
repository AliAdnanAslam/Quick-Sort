// Quick Sort -- Program

// Importing the necessary packages 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Quick sort algorithm for sorting the given array.
 */

public class QuickSort {
     
    private int array[];
    private int length;
    
    /**
     * sort function provides the sorting of minimum length of array
     * @param inputArr this is the minimum size of array 
     */
    public void sort(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
    
    /**
     * quickSort function provides the sorting of elements by comparing by iteration number
     * and calling the sort function.
     * @param lowerIndex
     * @param higherIndex 
     */
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    /**
     * exchangeNumbers function provides the swapping of two elements
     * @param i element to swap
     * @param j element to swap
     */
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     
    
    // Main function
    public static void main(String a[]) throws FileNotFoundException{
         
        QuickSort sorter = new QuickSort();             //creating an object of quicksort function
        
        //reading array list from file 
        Scanner scanner = new Scanner(new File("C:\\Users\\Anonymous\\Documents\\"
                + "NetBeansProjects\\file handling\\src\\file\\handling\\unsorted.txt"));
        int [] input = new int [100];
        int x = 0;
        while(scanner.hasNextInt())
        {
            input[x++] = scanner.nextInt();
        }
        
        //calling the sort function to sort the given array list
        sorter.sort(input);
        for(int i:input){
            if (i != 0) {
                System.out.print(i);
                System.out.print(" ");            
            }
        }
    }
}