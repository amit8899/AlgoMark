package com.example.algomark;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<Data> dataEntry = new ArrayList<>();


    public static void initData(){
            Data data1 = new Data(1, "Selection Sort", "The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.\n" +
                    "\n" +
                    "1) The subarray which is already sorted.\n" +
                    "2) Remaining subarray which is unsorted.\n" +
                    "\n" +
                    "In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray", "O(n^2)", "O(1)", "The default Implementation is not stable. But can be made stable");
            dataEntry.add(data1);

            Data data2 = new Data(2, "Insertion Sort", "Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands. The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and placed at the correct position in the sorted part.\n" +
                    "Algorithm\n" +
                    "To sort an array of size n in ascending order:\n" +
                    "1: Iterate from arr[1] to arr[n] over the array.\n" +
                    "2: Compare the current element (key) to its predecessor.\n" +
                    "3: If the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements one position up to make space for the swapped element."
                    , "O(n^2)", "O(1)", "Yes");

            dataEntry.add(data2);

            Data data3 = new Data(3, "Bubble Sort", "Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.",
                    "Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.\n" +
                            "\n" +
                            "Best Case Time Complexity: O(n). Best case occurs when array is already sorted.", "O(1)", "Yes");
            dataEntry.add(data3);

            Data data4 = new Data(4, "Merge Sort", "Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It divides the input array into two halves, calls itself for the two halves, and then merges the two sorted halves. The merge() function is used for merging two halves. The merge(arr, l, m, r) is a key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one.",
                    "T(n) = 2T(n/2) + θ(n)", "O(n)", "Yes");
            dataEntry.add(data4);

            Data data5 = new Data(5, "Quick Sort", "Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot. There are many different versions of quickSort that pick pivot in different ways.\n" +
                    "\n" +
                    "Always pick first element as pivot.\n" +
                    "Always pick last element as pivot (implemented below)\n" +
                    "Pick a random element as pivot.\n" +
                    "Pick median as pivot.\n" +
                    "The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as pivot, put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x. All this should be done in linear time",
                    "T(n) = T(n-1) + \\theta(n)", "null", "The default implementation is not stable. However any sorting algorithm can be made stable by" +
                    " considering indexes as comparison parameter.");
            dataEntry.add(data5);
        }

    public static ArrayList<Data> getDataEntry() {
        return dataEntry;
    }
}
