# Diameter of a tree
The Diameter of tree is the *maximum* length between two nodes. For example : <br>
Consider the following tree of 7 nodes

<div align = "center">
<img height = "100"  src = "https://user-images.githubusercontent.com/58760297/99883654-e1a9b980-2c4e-11eb-979c-02dce3dd276d.png"/> 
</div><br>

Here, *Diameter* = 4 . 

## Algorithm

First, root the tree arbitarily.
<div align = "center">
<img height = "175"  src = "https://user-images.githubusercontent.com/58760297/99886616-fe042100-2c63-11eb-9334-81907b4c1ba6.png"/>
</div><br>

For each *node*, we calculate *toLeaf(node)* which denotes 
*maximum* length of a path from the *node* to any *leaf*.<br>

```
if node is leaf :
    toLeaf[node] = 0
else
    toLeaf[node] = 1 + max(toLeaf[child]) | for all child of node
```
    
<br>

We can use DFS to calculate *toLeaf(node)*.<br>
```cpp
vector<int> toLeaf(n+1, 0); // n is no. of nodes
void dfs(int node){
    visited[node] = true;
    for(int child : tree[node]){
        if(visited[child])
            continue;
        dfs(child);
        toLeaf[node] = max(toLeaf[node], 1 + toLeaf[child]);
    }
}
```
<br>
<div align = "center">
<img height = "175"  src = "https://user-images.githubusercontent.com/58760297/99886436-8da8d000-2c62-11eb-8c39-27906df824e5.png"/>
</div><br>

Now calculate *path_length(node)* which denotes *maximum* length of a path whose highest point is node.

```
if node is leaf :
    path_length[node] = 0
else if node has only 1 child :
    path_length[node] = toLeaf[child] + 1
else
    Take two distinct child a,b such that (toLeaf[a] + toLeaf[b]) is maximum, then
    path_length[node] = (toLeaf[a] + 1) + (toLeaf[b] + 1)
    
```
Here is the implementation .
```cpp
vector<int> toLeaf(n+1, 0), path_length(n+1, 0);
void dfs(int node){
    visited[node] = true;
    vector<int> length = {-1}; // allows us to handle the cases when node has less than 2 children
    for(int child : tree[node]){
        if(visited[child])
            continue;
        dfs(child);
        toLeaf[node] = max(toLeaf[node], 1 + toLeaf[child]); 
        length.push_back(toLeaf[child]);
    }
    int s = length.size(), m = min((int)length.size(),2);
    for(int i = 0; i < m; i++){
        for(int j = i+1; j < s; j++){
            if(length[i] < length[j])
                swap(length[i], length[j]);
        }
        path_length[node] += length[i] + 1;
    }   
}    
```

<br>
<div align = "center">
<img height = "175"  src = "https://user-images.githubusercontent.com/58760297/99886528-3a834d00-2c63-11eb-8671-4d7eb16560c4.png"/>
</div><br>

Finally, *Diameter = maximum* of all lengths in path_length. Therefore here, *Diameter* = 4.

## Problems
- [Tree Diameter](https://cses.fi/problemset/task/1131/)
## Reference
- Competitive Programmer's Handbook by Antii Laaksonen.

