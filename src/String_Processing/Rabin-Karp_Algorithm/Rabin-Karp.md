# Rabin-Karp Algorithm

This is one of the applications of *String hashing*.

Given two strings - a pattern *s* and a text *t*, determine if the pattern appears in the text and if it does, enumerate all its occurrences in O(|s|+|t|) time.

***Algorithm*** : First the hash for the pattern *s* is calculated and then hash of all the substrings of text *t* of the same length as |s| is calculated. Now comparison between pattern and substring can be done in constant time.

## Implementation
```cpp
    vector<int> rabin_karp(string  const& s, string  const& t) 
    {
        const  int p = 31; 
        const  int m = 1e9 + 9;
        int S = s.size(), T = t.size();
        vector<long long> p_pow(max(S, T));
        p_pow[0] = 1; 
        for (int i = 1; i < (int)p_pow.size(); i++)
            p_pow[i] = (p_pow[i-1] * p) % m;
        vector<long long> h(T + 1, 0); 
        for (int i = 0; i < T; i++) 
            h[i+1] = (h[i] + (t[i] - 'a' + 1) * p_pow[i]) % m; 
        long  long h_s = 0; 
        for (int i = 0;i < S; i++) 
            h_s = (h_s + (s[i] - 'a' + 1) * p_pow[i]) % m;
        vector<int> occurences; 
        for (int i = 0; i + S - 1 < T; i++) 
        { 
            long  long cur_h = (h[i+S] + m - h[i]) % m;
            if (cur_h == h_s * p_pow[i] % m) 
            occurences.push_back(i); 
        } 
        return occurences; 
    }
```
## Problems for Practice

- [Good_Substrings](https://codeforces.com/problemset/problem/271/D)
- [Pattern_Find](https://www.spoj.com/problems/NAJPF/)

## References

- [CP-Algorithms](https://cp-algorithms.com/)
