import java.util.*;




public class Prob17{
  static int n, k=0;
  static String s[];
  static Boolean adj[][];
  static Boolean visited[];
  public static void main(String args[]){

    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    s = new String[n];
    adj = new Boolean[26][26];
    for (int i=0; i<n; i++)
      s[i] = in.next();

    for (int i = 0; i < n ; i++){
      while (s[i].charAt(k) == s[i + 1].charAt(k))
        k++;
      adj[(int)(s[i].charAt(k)-'A')][((int)(s[i+1].charAt(k)-'A'))] = true;
    }
  }
  static void dfs(int v){
    visited[v] = true;
    for(int i=1; 1<=n;i++)
      if (!visited[i] && adj[v][i])
        dfs(i);
        }
}
