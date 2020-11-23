# Sieve of Eratosthenes

## Introduction

Sieve of Eratosthenes is an algorithm that helps us find all the prime numbers in a range \\([1, n]\\). Initially, we take a boolean array of size \\(n+1\\) where the \\(i\\)'th index will be `true` if \\(i\\) is prime, and `false` otherwise. All the numbers except 0 and 1 are marked as prime at the beginning of the process.

Then we loop through the numbers from 2 till \\(n\\) and if the number is currently marked as prime, then we add that number to our list of primes and mark all it's multiples as non-prime. At the end of the process, we will have all the prime numbers in the range in our list.

Let us try to simulate the process for \\(n=16\\). The numbers will be placed between brackets in the diagrams if they are marked as non-prime. Initially, all numbers are marked prime except 1.

```
(1) 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
```

Now, the loop variable, say \\(i\\), is at 2, which is a prime, so we mark all it's multiples as non-prime.

```
(1) 2 3 (4) 5 (6) 7 (8) 9 (10) 11 (12) 13 (14) 15 (16)
```

We do the same for `i=3`.

```
(1) 2 3 (4) 5 (6) 7 (8) (9) (10) 11 (12) 13 (14) (15) (16)
```

One important observation here is that all non-prime numbers are marked within \\(\sqrt{n}\\) iterations. So, we can go through the remaining numbers and add them if they are prime. So the primes in the range would be: `[2, 3, 5, 7, 11, 13]`.

## Implementation

**C++**
```cpp
vector<int> get_primes(int n)
{

    vector<int> primes;
    vector<bool> is_prime(n+1, true);
    is_prime[0] = is_prime[1] = false;

    for(int i=2; i<=n; i++)
    {
        if (!is_prime[i])
            continue;
        primes.push_back(i);
        for(int j=i*i; j<=n; j+=i)
            is_prime[j] = false;
    }
    return primes;
}
```

**Python**
```py
def SieveOfEratosthenes(n):
    isPrime = [True]*(n+1)
    isPrime[0] = isPrime[1] = False
    primes = []
    for i in range(2, n+1):
        if not isPrime[i]:continue
        primes += [i]
        for j in range(i*i, n+1, i):
            isPrime[j] = False
    return primes
```

Other than finding primes, the algorithm can also be used to factorise any number less than or equal to \\(n\\) in **O(divisors)** time if we simply store the smallest prime factor of each number in the array.

## Practice Problems
- [Almost Prime](https://codeforces.com/contest/26/problem/A)
- [Two Divisors](https://codeforces.com/contest/1366/problem/D)