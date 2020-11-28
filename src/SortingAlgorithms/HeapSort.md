# Heap Sort

## Example Problem

Given an array ``arr = [a1,a2,a3,a4,a5...,an] `` , we need to sort the array with the help of Heap Sort algorithm.

<hr>

## Discussion

**Heap sort** is a comparison based sorting technique based on Binary Heap data structure. It is similar to selection sort where we first find the maximum element and place the maximum element at the end. We repeat the same process for the remaining elements.

A **Binary Heap** is a Complete Binary Tree where items are stored in a special order such that value in a parent node is greater(or smaller) than the values in its two children nodes. The former is called as max heap and the latter is called min-heap. The heap can be represented by a binary tree or array.

Here , we use array representation of complete binary tree. So for the index `i` the left child will be `2*i` and the right child will be `2*i+1`.

<hr>

## Working of the Algorithm

**Heap Sort Algorithm for sorting in increasing order:**

1. Build a max heap from the input data. 
2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of the tree. 
3. Repeat step 2 while size of heap is greater than 1.

**Algorithm for building max heap:**
1. A single element is already in a heap.
2. When we add next elemnt , add it at the last of the array, so that it is a complete binary tree.
3. Now , the newly inserted element is a leaf element. So we compare the element with it's parent element `(i/2)` and if the inserted element is greater than it's parent we place the parent node at the leaf position . And we repeat this process , until we find the proper position for the newly inserted element.

**Algorithm for deletion:**
1. We can only delete a root element from the max heap.
2. So we swap the last element of the complete binary tree with the root element and bring the root element to it's proper position. In this process the size of max heap decreases by 1.

## Illustration

```
Input data : 6 25 10 5 40

Now , as discussed above 6 that is the single element is already a heap.

Inserting 25 ->

          6        Applying Heap       25
         /        -------------->     /
        25                           6

Inserting 10 ->

         25        Applying Heap       25
        /  \      --------------->    /  \
       6    10                       6    10

Repeating the same process , the final heap is ->

                    40
                   /  \
                 25    10
                /  \ 
               5    6   

So the new array becomes : 40 25 10 5 6

We have build our max heap , now we keep on deleting the root element and keep on adding the element at the end of the array and put the last element of the heap to the node.

      6                                      25
     / \        Making it Heap again        /  \
   25   10       --------------->          6    10
   /                                      /
  5                                      5

So now the array becomes : 25 6 10 5 || 40 , where the elements before || is a heap.

Repeating the same process until the size of the heap becomes 1 , our array becomes : 5 6 10 25 40

Hence the array is sorted.
```

<hr>

## Code

### Code For Insertion
```cpp
void InsertHeap(int arr[],int n)
{
    // taking the newly inserted element as temp
    int temp = arr[n] , i = n;

    // finding correct position for temp
    while(i>1 && temp>arr[i/2])
    {
        arr[i] = arr[i/2];
        i/=2;
    }

    //placing the temp at the correct position
    arr[i] = temp;
}
```

### Code for Deletion.
```cpp
void DeleteHeap(int a[],int n)
{
    int i = 1;
    int j = i*2;

    // swapping the root and the last element
    swap(a[1],a[n]);

    // coverting the rest array into heap again
    while(j<n-1)
    {
        // comparing the left and right child for finding the greater one
        if(a[j+1]>a[j])
            j = j+1;

        // cehcking for the correct position
        if(a[i]<a[j])
        {
            swap(a[i],a[j]);
            i = j;
            j = j*2;
        }
        else
            break;
    }
}
```

### Code for Heap Sort.
```cpp
void HeapSort(int a[],int n)
{
    // making the max heap
    for(int i=2;i<n;i++)
        InsertHeap(a,i);
    
    // deleting the root and placing at last of the array
    for(int i=n;i>1;i--)
        DeleteHeap(a,i);
}
```
<hr>

## Time Complexity

Each Insertion algorithm takes O(logn) time and we insert n number of elements in the heap , so the total time complexity for insertion is O(nlogn).

Similarly , each Insertion algorithm takes O(logn) time and we delete n number of elements in the heap , so the total time complexity for deletion is O(nlogn).

So the total time complexity for heap sort is (nlogn).
<hr>

## Note

One thing to be noted is that , the time complexity of insertion algorithm can be reduced by using heapify. In heapify we check elemnts from last and see if the elemnt is greater than it's child element . If it is not then we apply heapify on the sub tree to make it a proper heap.

## Code for Heapify
```cpp
void heapify(int arr[], int n, int i)
{
    int largest = i; // Initialize largest as root
    int l = 2 * i + 1;
    int r = 2 * i + 2;
 
    // If left child is larger than root
    if (l < n && arr[l] > arr[largest])
        largest = l;
 
    // If right child is larger than largest so far
    if (r < n && arr[r] > arr[largest])
        largest = r;
 
    // If largest is not root
    if (largest != i) {
        swap(arr[i], arr[largest]);
 
        // Recursively heapify the affected sub-tree
        heapify(arr, n, largest);
    }
}
```
## Code for Heap Sort
```cpp
void heapSort(int arr[], int n)
{
    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);
 
    // One by one extract an element from heap
    for (int i = n - 1; i > 0; i--) {
        // Move current root to end
        swap(arr[0], arr[i]);
 
        // call max heapify on the reduced heap
        heapify(arr, i, 0);
    }
}
```
Above Code is from [GFG Blog](https://www.geeksforgeeks.org/heap-sort/). 

<hr>

Application Problems

- [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)
- [Kth Smallest Element in an Array](https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1)