# Linear Diophantine Equations

## Introduction
A linear diophantine equation is one of the form \\(ax + by = c\\), where \\(a\\), \\(b\\) and \\(c\\) are integers known to us. A solution to the equation will exist only when \\(\gcd(a,b)\\) divides \\(c\\), where gcd denotes the greatest common divisor.

To find one of the solutions, we can apply the extended Euclidean algorithm to find the gcd of \\(a\\) and \\(b\\), and two numbers \\(x_{g}\\) and \\(y_{g}\\) such that \\(ax_{g} + by_{g} = g\\).

The implementation is as follows:

**C++**
```cpp
pair<int, int> solve(int a, int b, int c)
{
    int m1=1, m2=0, n1=0, n2=1;
    while (a % b)
    {
        int quotient = a / b;
        int remainder = a % b;
        int aux1 = m1-(m2*quotient);
        int aux2 = n1-(n2*quotient);
        a = b;
        b = remainder;
        m1 = m2;
        n1 = n2;
        m2 = aux1;
        n2 = aux2;
    }
    return make_pair(m2*c,n2*c);
}
```

**Python**

```py
def solve(a,b,c):
    m1, m2, n1, n2 = 1, 0, 0, 1
    while a % b:
        quotient = a // b
        a, b = b, a % b
        m1, n1, m2, n2 = m2, n2, m1-(m2*quotient), n1-(n2*quotient)
    return m2*c,n2*c
```

From one solution, say \\((x_0, y_0)\\), we can obtain all other solutions by adding \\(\frac{b}{g}\\) to \\(x_0\\) and subtracting \\(\frac{a}{g}\\) from \\(y_0\\). This gives us a general solution of the form:
\
\\(x = x_0 + k \cdot \frac{b}{g}\\), 
\
\\(y = y_0 - k \cdot \frac{a}{g}\\)

## Practice Problems
- [Crucial Equations](https://www.spoj.com/problems/CEQU/)

## References
- [CP-Algorithms](https://cp-algorithms.com/)