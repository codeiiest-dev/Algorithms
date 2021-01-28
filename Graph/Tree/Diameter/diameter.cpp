#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

vector<vector<int>> tree ;
vector<int> visited, toLeaf, path_length;

void dfs(int node){
    visited[node] = true;
    vector<int> length = {-1};
    for(int child : tree[node]){
        if(visited[child])
            continue;
        dfs(child);
        toLeaf[node] = max(toLeaf[node], 1 + toLeaf[child]); 
        length.push_back(toLeaf[child]);
    }
    int n = length.size(), m = min((int)length.size(),2);
    for(int i = 0; i < m; i++){
        for(int j = i+1; j < n; j++){
            if(length[i] < length[j])
                swap(length[i], length[j]);
        }
        path_length[node] += length[i] + 1;
    }   
}

int main(){
    int n;
    cin >> n;
    int m = n - 1;
    tree.resize(n+1), toLeaf.resize(n+1,0), path_length.resize(n+1,0), visited.resize(n+1,false);
    while(m--){
        int x, y;
        cin >> x >> y;
        tree[x].push_back(y);
        tree[y].push_back(x);
    }
    int root = 1;
    dfs(root);
    int diameter = *max_element(path_length.begin(), path_length.end());
    cout << diameter << "\n";
    return 0;    
}