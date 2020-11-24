## Typical backtracking recursive function

### Explanation

The backtracking algorithm uses recursion and so can be represented as a tree structure where each node differs from its parent by a single extension step. The leaves of the tree are nodes where there is no more extension possible (either the problem is solved, or there are no valid candidates satisfying the contraints at the next extension).

The search tree is traversed from root down in **depth-first order**. At each node, we check if the node leads us to the path giving us a complete valid solution. If not, then the whole subtree rooted at that node is skipped, or pruned.

If the node itself is a valid solution (in which case it would be the leaf node), boolean value True is returned, indicating the solution has been found and we do not need to search any longer.

If a node lies on the path to the solution, then we return with boolean value True. This can be determined if the recursive call to its subtree returns True or not.

The distance of a node from the root determines how many values have been filled in yet.

#### Pseudocode

```

def solve_backtrack():
    if is_solved(): // base case: solution has been found
        return True

    for candidate in candidates:
        if not is_feasible(candidate): # if candidate is not a valid choice
            continue

        accept(candidate) // use candidate for the current instance
        if solve_backtrack(): // recursive call
            return True // if problem solved, return True
        reject(candidate) // problem not solved, remove candidate used and continue in loop

    return False // solution does not exist

```
