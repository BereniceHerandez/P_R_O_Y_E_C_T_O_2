/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.io.IOException;

/**
 *
 * @author newbi
 */
public class GrafoDirigido extends Grafo{
    
    public GrafoDirigido(){}
    
    public GrafoDirigido(String name,boolean sameVertexEdge)
    {
        super(name,sameVertexEdge);
    }
    
    
    /**
     * 
     * @param vertex1
     * @param vertex2 
     * Adds an edge with Vertex1 -> Vertex2
     * verifying if exists v1,2
     */
    public boolean addEdge(Vertex vertex1, Vertex vertex2)
    {
        Edge nvoEdge12 = new Edge(vertex1,vertex2);

        if(!isInEdge(nvoEdge12))
        {
            if(isSameVertexEdge())
            {
                addEdge(new Edge(vertex1,vertex2));
                return true;
            }else
            {
                if(!vertex1.getName().equals(vertex2.getName()))
                {
                    addEdge(new Edge(vertex1,vertex2));
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public void exportToGraphViz() throws IOException, InterruptedException
    {
        String dot = "";
        System.out.println("digraph "+getName()+"{ ");
        dot+="digraph "+getName()+"{ \n";
        for(Vertex v : getVertexes())
        {
            System.out.println(v.getName()+";");
            dot+=v.getName()+";";
        }
        
        for(Edge ed : getEdges())
        {
            System.out.println(ed.getVertex1().getName()+" -> "+ed.getVertex2().getName()+";");
            dot+=ed.getVertex1().getName()+" -> "+ed.getVertex2().getName()+";";
        }
        
		
	System.out.println("}");
        dot+="}";
        
        writeDotFile(dot);
    }
}
