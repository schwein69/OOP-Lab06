package it.unibo.oop.lab06.generics1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractGraph<N> implements Graph<N> {//caso grafo orientato
	
	private List<N> s = new LinkedList<N>();
	private Map<N,Set<N>> adj = new HashMap<>();

	
	protected List<N> getS() {
		return s;
	}

	protected Map<N, Set<N>> getAdj() {
		return adj;
	}

	@Override
	public void addNode(N node) {
		// TODO Auto-generated method stub
		if(node != null && !this.adj.containsKey(node)) {
			adj.put(node, new HashSet<>());
		}
	}

	
	public abstract void addEdge(N source, N target);
		
		
	
	
	@Override
	public Set<N> linkedNodes(N node) {
		// TODO Auto-generated method stub
		return (this.adj.containsKey(node) && node != null) ? this.adj.get(node) : null;
	}


	@Override
	public Set<N> nodeSet() {
		// TODO Auto-generated method stub
		return this.adj.keySet();
	}
	
	private List<N> operation(List<N> t,N source, N target){
		if(source==target) {
			t.add(source);
			this.getS().addAll(t);
			return this.getS();
		}
		for(N i: this.linkedNodes(source)) {
			if(!t.contains(i)){
				t.add(source);
			
			if(operation(t, i, target) != null) {
				/*if(!t.contains(source)) {
					t.add(0, source);
				}*/
				return this.getS();
				}
			}
		}
		return null;	
	}
	@Override
	public List<N> getPath(N source, N target) {
		List<N> tmp = new LinkedList<>();
		this.s.clear();
		return this.operation(tmp,source,target);
		// TODO Auto-generated method stub
	}

}
