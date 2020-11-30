# Bubble Sort

## Example Problem

Given an array `arr = [a1,a2,a3,a4,a5...,an] ` , we need to sort the array the array with the help of Bubble Sort algorithm.

<hr>

## Discussion

Bubble Sort is one of the simplest sorting algorithms that repeatedly swaps the adjacent elements if they are in wrong order.

## Illustration

<img src="https://raw.githubusercontent.com/Ahel2000/StarBuzz/master/bubble-sort.png"/>

## Code for Bubble Sort

```java

void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]) //if ordering is wrong
                {   int temp = arr[j]; //then swap a[j] and a[j+1]
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

```
