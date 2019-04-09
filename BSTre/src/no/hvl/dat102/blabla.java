package no.hvl.dat102;

import java.util.Scanner;

public class blabla {
		// Returns index of x if it is present in arr[l.. 
	    // r], else return -1 
	    int binarySearch(int arr[], int l, int r, int x) { 
	        if (r >= l) { 
	            int mid = l + (r - l) / 2; 
	  
	            // If the element is present at the 
	            // middle itself 
	            if (arr[mid] == x) 
	                return mid; 
	  
	            // If element is smaller than mid, then 
	            // it can only be present in left subarray 
	            if (arr[mid] > x) 
	                return binarySearch(arr, l, mid - 1, x); 
	  
	            // Else the element can only be present 
	            // in right subarray 
	            return binarySearch(arr, mid + 1, r, x); 
	        } 
	  
	        // We reach here when element is not present 
	        // in array 
	        return -1; 
	    } 
	  
	    // Driver method to test above 
	    public static void main(String args[]) 
	    { 
	        blabla ob = new blabla(); 
	        int arr[] = { 2, 4, 5, 7, 8, 10, 12, 15, 18, 21, 23, 27, 29, 30, 31}; 
	        int n = arr.length; 
	        System.out.println("Skriv et random tall:");
	        Scanner scan = new Scanner(System.in); 
	        int x = scan.nextInt(); 
	        int result = ob.binarySearch(arr, 0, n - 1, x); 
	        if (result == -1) 
	            System.out.println("Element not present"); 
	        else
	            System.out.println("Element found at index " + result); 
	    }

}
