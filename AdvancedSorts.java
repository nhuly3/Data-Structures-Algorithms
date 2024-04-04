import java.lang.*;
import java.io.*;
import java.util.Arrays;
class AdvancedSorts{

  static int minimumIndex(int a[], int x, int y)
  {
    if(x == y)
       return x;
    int z = minimumIndex(a, x+1, y);
    return (a[x] < a[z])? x:z;
  }

  static void recursiveBubbleSort(int a[], int n)
  {
    if(n ==1)
      return;

    for(int i=0; i<n-1; i++)
      if(a[i] > a[i+1])
      {
        int t = a[i];
        a[i] = a[i+1];
        a[i+1] = t;
      }
    
    recursiveBubbleSort(a, n-1);
  }

  static void recursiveSelectionSort(int arr[], int n, int i)
  {
    if(i == n)
       return;

    int k = minimumIndex(arr, i, n-1);

    if(k != i)
    {
      int t = arr[k];
      arr[k] = arr[i];
      arr[i] = t;
    }
    
    recursiveSelectionSort(arr, n, i+1);
  }

  static void recursiveInsertionSort(int a[], int n)
  {
    if(n <= 1)
       return;
    recursiveInsertionSort(a, n-1);

    int last = a[n-1];
    int j=n-2;

    while(j >= 0 && a[j] > last)
    {
      a[j+1] = a[j];
      j--;
    }
    a[j+1] = last;
  }

  public static void main(String[] args) {
    int arr1[] = {15,12,85,1,95,3};
    int arr2[] = {32,2,85,10,9,3};
    int arr3[] = {5,12,8,111,9,30};

    recursiveBubbleSort(arr1, arr1.length);
    System.out.println("Bubble Sorted Array: ");
    System.out.println(Arrays.toString(arr1));

    recursiveSelectionSort(arr2, arr2.length, 0);
    System.out.println("Selection Sorted Array: ");
    System.out.println(Arrays.toString(arr2));

    recursiveInsertionSort(arr3, arr3.length);
    System.out.println("Insertion Sorted Array: ");
    System.out.println(Arrays.toString(arr3));
  }
}
