# Linear Search

Linear search is the simplest searching algorithm that searches for an element in a list(any linear data-structure) in sequential order. We start at one end and check every element until the desired element is not found.
Works on both sorted and un-sorted array.

## Problem Statement

Given an array `arr[]` of n elements, write a function to search a given element `x` in `arr[]`.(Array indexing 0-based, i.e,  `[0,1,...,n-1]` where n is the size of the array). If `x` is not present in the array return `-1`.

## Solution

We linearly traverse the array `arr[]` from frist to last postion, i.e, index `0` to index `n-1` where `n` is the size of the given array, and if we find the required element `x` return the index of that element. If the required element makes multiple occurances, the index value of the first occurance will be returned.

```cpp
int main(){
    int n;
    cin>>n; // input the size of required array
    int arr[n]; // make an array of size n
    for(int i=0; i<n; i++)cin>>arr[i]; // input the array
    int x; 
    cin>>x; // the value to be searched
    int pos=-1; // initialize to -1 so that non-occurance of x can be checked
    for(int i=0; i<n; i++){
        if(arr[i]==x){
            cout<<x<<"Occurs at index "<<i;
            pos=i;
            return 0;
        }
    }
    if(pos==-1)cout<<"Not present in array";
}
```

## Time Complexity

>`O(n)` in the worst case scenario as we have to traverse the whole array from start to end.

## Practice Problems

[Find number of occurances](https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1/?category[]=Searching&page=1&query=category[]Searchingpage1)

[Doubling the value](https://practice.geeksforgeeks.org/problems/doubling-the-value4859/1/?category[]=Searching&page=1&query=category[]Searchingpage1)

[Search in a matrix](https://practice.geeksforgeeks.org/problems/search-in-a-matrix17201720/1/?category[]=Searching&page=2&query=category[]Searchingpage2)