#  String Hashing
We need this to compare the strings. Idea is to convert each string to integer and compare those instead of the actual strings which is O(1) operation. The conversion is done by a ***Hash-Function*** and the integer obtained corresponding to the string is called *hash* of the string.
A widely used function is   *polynomial rolling hash function* :
 ![](https://hapq.me/content/images/2019/11/Screen-Shot-2019-11-06-at-4.59.06-PM.png)
where *p* and *m* are some chosen, positive numbers. *p* is a prime approximately equal to the number of characters in the input alphabet and *m* is a large number.
Here, it is m=10^9 + 9.

## Implementation 

    long long compute_hash(string  const& s)
     { 
	      const  int p = 31; 
	      const  int m = 1e9 + 9;
	      long  long hash_value = 0; 
	      long  long p_pow = 1;
	      for (char c : s) 
	      {
	        hash_value = (hash_value + (c - 'a' + 1) * p_pow)%m; 
	        p_pow = (p_pow * p) % m;
	      } 
	      return hash_value; 
     }
