class Solution {
    ArrayList<Integer>[] adj;
       Map<Integer,Integer> bobPath;
       int max =Integer.MIN_VALUE;
       int[] amount;
       boolean[] visited;
   public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
      int n=amount.length;
      bobPath=new HashMap<Integer,Integer>();
      this.amount=amount=amount;
      adj=new ArrayList[n];
      for(int i=0;i<n;i++)
      {
       adj[i]=new ArrayList<Integer>();
      }
      visited=new boolean[n];
      for(int[] edge:edges){
       int u=edge[0];
       int v=edge[1];
       adj[u].add(v);
       adj[v].add(u);
      }
      bobPath(bob,0);
      Arrays.fill(visited,false);
      alice(0,0,0);
      return max;
   }
   private boolean bobPath(int node,int time){
       visited[node]=true;
       bobPath.put(node,time);
       if(node==0){
           return true;
       }
       for(int nei:adj[node]){
           if(!visited[nei] &&bobPath(nei,time+1)){
               return true;
           }
       }
       bobPath.remove(node);
       return false;
   }
   private void alice(int node,int time,int income){
       visited[node]=true;
       if(!bobPath.containsKey(node)|| time<bobPath.get(node)){
           income+=amount[node];
       }
       else if(time==bobPath.get(node)){
           income+=amount[node]/2;
       }
       if(adj[node].size()==1 && node !=0){
           max=Math.max(max,income);
       }
       for(int nei:adj[node]){
           if(!visited[nei]){
               alice(nei,time+1,income);
           }
       }
   }
}