package it.unibo.oop.lab06.generics1;

public class UndirectedGraph<N> extends AbstractGraph<N>{

    @Override
    public void addEdge(N source, N target) {
	// TODO Auto-generated method stub
	if (source != null && target != null && this.getAdj().containsKey(source)
		&& this.getAdj().containsKey(target)) {

	    this.getAdj().get(source).add(target);
	    this.getAdj().get(target).add(source);
	}
    }

}
