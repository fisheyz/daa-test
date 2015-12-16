import java.util.*;

class PII {
    PII(int x, int y, int pos) {
	this.x = x;
	this.y = y;
	this.top = pos;
    }
    int x, y, top;
}

public class Prob18 {
    static String m[];
    static int vis[][][]; //0 nao vis, 1 a visitar, 2 visitado
    static LinkedList<PII> s;

    static int count;
    static int maxi;
    static int found;

    static int c, l;
    
    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);

	c = in.nextInt();
	l = in.nextInt();

	m = new String[l];
	for (int i = 0; i < l; i++)
	    m[i] = in.next();

	vis = new int[l][c][2];
	s = new LinkedList<PII>();

	count = 0;
	maxi = 0;

	for (int i = 0; i < l; i++)
	    for (int j = 0; j < c; j++) {
		found = 0;
		if (vis[i][j][0] == 0)
		    dfs(i, j, 0, 0, -1, -1);
		if (found == 1)
		    count++;
		found = 0;
		if (vis[i][j][1] == 0)
		    dfs(i, j, 1, 0, -1, -1);
		if (found == 1)
		    count++;
	    }

	if (count != 0)
	    System.out.println(count + " " + maxi);
	else
	    System.out.println("nao tem ciclos");
	
    }

    static void dfs(int x, int y, int top, int sz, int px, int py) {
	if (vis[x][y][top] == 1) {
	    if (sz >= 4)
		found = 1;
	    if (sz > maxi && sz >= 4)
		maxi = sz;
	    return;
	}

	vis[x][y][top] = 1;
	if (m[x].charAt(y) == '\\') {
	    if (top == 1) {
		if (x > 0)
		    if (x-1 != px && y != py)
			dfs(x-1, y, 0, sz+1, x, y);
		if (y < c-1 && m[x].charAt(y+1) == '\\')
		    if (x != px && y+1 != py)
			dfs(x, y+1, 0, sz+1, x, y);
		if (y < c-1 && m[x].charAt(y+1) == '/')
		    if (x != px && y+1 != py)
			dfs(x, y+1, 1, sz+1, x, y);
	    }
	    else if (top == 0) {
		if (x < l-1)
		    if (x+1 != px && y != py)
			dfs(x+1, y, 1, sz+1, x, y);
		if (y > 0 && m[x].charAt(y-1) == '\\')
		    if (x != px && y-1 != py)
			dfs(x, y-1, 1, sz+1, x, y);
		if (y > 0 && m[x].charAt(y-1) == '/')
		    if (x != px && y-1 != py)
			dfs(x, y-1, 0, sz+1, x, y);
	    }
	}
	else {
 	    if (top == 1) {
		if (x > 0)
		    if (x-1 != px && y != py)
			dfs(x-1, y, 0, sz+1, x, y);
		if (y > 0 && m[x].charAt(y-1) == '\\')
		    if (x != px && y-1 != py)
			dfs(x, y-1, 1, sz+1, x, y);
		if (y > 0 && m[x].charAt(y-1) == '/')
		    if (x != px && y-1 != py)
			dfs(x, y-1, 0, sz+1, x, y);
	    }
	    else if (top == 0) {
		if (x < l-1)
		    if (x+1 != px && y != py)
			dfs(x+1, y, 1, sz+1, x, y);
		if (y < c-1 && m[x].charAt(y+1) == '\\')
		    if (x != px && y+1 != py)
			dfs(x, y+1, 0, sz+1,x ,y);
		if (y < c-1 && m[x].charAt(y+1) == '/')
		    if (x != px && y+1 != py)
			dfs(x, y+1, 1, sz+1,x,y);
	    }
	}
    }
}

