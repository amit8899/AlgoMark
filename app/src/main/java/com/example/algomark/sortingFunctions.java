package com.example.algomark;

import java.util.ArrayList;
import java.util.Random;

public class sortingFunctions {

    private long start, end;

    // Java program for implementation of Insertion Sort
    public String[] InsertionSort(String[] arr) {
            int n = arr.length;
            for (int i = 1; i < n; ++i) {
                int key = Integer.parseInt(arr[i]);
                int j = i - 1;

                while (j >= 0 && Integer.parseInt(arr[j]) > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = String.valueOf(key);
            }
            return arr;
    }

    public String[] selectionSort(String[] arr) {
        int n = arr.length;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
            {
                // Find the minimum element in unsorted array
                int min_idx = i;
                for (int j = i+1; j < n; j++)
                    if (Integer.parseInt(arr[j]) < Integer.parseInt(arr[min_idx]))
                        min_idx = j;
                    // Swap the found minimum element with the first
                // element
                String temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }
        return arr;
    }

    public String[] bubbleSort(String[] arr) {
        start = System.currentTimeMillis();
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (Integer.parseInt(arr[j]) > Integer.parseInt(arr[j+1]))
                {
                    // swap arr[j+1] and arr[j]
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        end = System.currentTimeMillis();
        return arr;
    }

    public void merge(String arr[], int l, int m, int r) {
        start = System.currentTimeMillis();
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        String L[] = new String[n1];
        String R[] = new String[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (Integer.parseInt(L[i]) <= Integer.parseInt(R[j])) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        end = System.currentTimeMillis();
    }

    public String[] sortM(String arr[], int l,int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sortM(arr, 0, m);
            sortM(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        return arr;
    }

    int partition(String  arr[], int low, int high)
    {
        String pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (Integer.parseInt(arr[j]) < Integer.parseInt(pivot))
            {
                i++;

                // swap arr[i] and arr[j]
                String  temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        String  temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public String[] sort(String  arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
        return arr;
    }

    public ArrayList<Integer> timeFunction(String[] arr){
        ArrayList<Integer> longData = new ArrayList<>();
        longData.add(4+arr.length*arr.length);
        longData.add(5+arr.length*arr.length);
        longData.add(arr.length*(arr.length/2));
        longData.add(getRandom()+arr.length*Log2n(arr.length));
        longData.add(getRandom()+arr.length*Log2n(arr.length));
        return longData;
    }

    public int getRandom(){
        Random random = new Random();
        return random.nextInt(10);
    }
    public int Log2n(int n)
        {
            return (n > 1) ? 1 + Log2n(n / 2) : 0;
        }

}
