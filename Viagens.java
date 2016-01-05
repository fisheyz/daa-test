import java.util.*;
import java.io.*;

class Viagens{

	static String ponto[];
	static int n, e;
	
	public static int id(String local){
		for(int i = 0; i<n; i++){
			if("".equals(ponto[i])){
				ponto[i] = local;
				return i;
			}
			if(local.equals(ponto[i]))
				return i;
		}
		return 0;

	}
		
	public static void main(String args[]){
		
		 
		 
		 double d;
			
		Scanner in= new Scanner(System.in);
		n = in.nextInt();
		e = in.nextInt();
		ponto = new String [n+1];
		for(int i=0; i<n; i++)
			ponto[i] = "";
		ponto[0] = in.next();
		ponto[1] = in.next();
		
		Graph v = new Graph(n);	
		
		for ( int i = 0; i<e ;i++){
			String n = in.next();
			String m = in.next();
			v.addLink(id(n), id(m), in.nextDouble());
			
		}
		v.Dijkstra(0);
		System.out.printf("%.1f\n", v.nodes[1].distance);
		
	}

	 
	

}


class Node {
    public LinkedList<Edge> adj; // Lista de adjacencias
    public boolean visited;         // Valor booleano que indica se foi visitao numa pesquisa
    public double distance;            // Distancia do no origem da pesquisa

    Node() {
	adj = new LinkedList<Edge>();
	visited = false;
	distance = -1;
    }
}

class Edge{
	public int destino;
	public double dist;
	
	Edge(int destino, double dist){
		this.destino = destino;
		this.dist = dist;
	}

}
// Classe que representa um grafo
class Graph {
    int n;           // Numero de nos do grafo
    Node nodes[];    // Array para conter os nos
	
    Graph(int n) {
	this.n = n;
	nodes  = new Node[n+1]; // +1 se os comecam em 1 ao inves de 0
	for (int i=0; i<n; i++)
	    nodes[i] = new Node();
	
    }

    public void addLink(int a, int b, double d) {
	nodes[a].adj.add(new Edge(b, d));
	nodes[b].adj.add(new Edge(a, d));
	
    }

	public void Dijkstra(int v){
		for(int i = 0; i<n; i++){
			nodes[i].distance = Double.MAX_VALUE;
			nodes[i].visited = false;
		}

		nodes[v].distance = 0;
		for(int j=0; j<n; j++){
			double menor=Double.MAX_VALUE;
			int pos = 0;
			for(int i = 0; i<n; i++){	
				if(nodes[i].visited == false && nodes[i].distance < menor){
					menor = nodes[i].distance;
					pos = i;
				}
			}
				
				nodes[pos].visited = true;
				for ( Edge w : nodes[pos].adj){
					if(nodes[w.destino].visited == false && nodes[pos].distance + w.dist < nodes[w.destino].distance)
						nodes[w.destino].distance = nodes[pos].distance + w.dist; 
				}
			}
		}
	
   
}
