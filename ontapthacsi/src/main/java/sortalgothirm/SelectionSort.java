package sortalgothirm;

import java.util.Arrays;

public class SelectionSort {
//    public static void main(String[] args) {
//        int[] arr = Base.genArrRandom(6);
//        System.out.println(Arrays.toString(arr));
//
//        // selection sort: chọn giá trị nhỏ nhất trong đoạn chưa sắp xếp và đưa vào đoạn đã sắp xếp
//        // đoạn đã sắp xếp ở đây ngầm hiểu là những vị trí nhỏ nhất xếp dần vào
//        int sortedPartSize = 0;
//        int minimumIndex;
//        int swap;
//        for (int index = arr.length-1; index >=0; index-- ) {
//            minimumIndex= index;
//            for (int unsortedPartIndex = index-1;unsortedPartIndex >=0;unsortedPartIndex--){
//                if(arr[minimumIndex]>arr[unsortedPartIndex]){
//                    minimumIndex =unsortedPartIndex;
//                }
//            }
//            swap =arr[index];
//            System.out.printf("swap index: %d\n", index);
//            arr[index] = arr[minimumIndex];
//            arr[minimumIndex] =swap;
//        }
//        System.out.println(Arrays.toString(arr));
//    }

    void sort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            System.out.println("i "+i);
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }

    // Prints the array
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver code to test above
    public static void main(String args[])
    {
        SelectionSort ob = new SelectionSort();
        int arr[] = {11,12,25,64,22};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
