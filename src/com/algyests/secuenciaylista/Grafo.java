//Hecho por José Miguel Comprés
//ID: 10153259

package com.algyests.secuenciaylista;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private List<List<Character>> listaConexiones;
    private List<Integer> bucles;   //Para contar los bucles que contienen cada vértice (esto para dar la respuesta correcta en la secuencia de grados, a la vez que en la lista de adyacencia no se redunde)

    public Grafo(int numeroVertices)
    {
        listaConexiones = new ArrayList<>(numeroVertices);
        bucles = new ArrayList<>(numeroVertices);
        for (int i = 0; i<numeroVertices; i++)
        {
            listaConexiones.add(new ArrayList<Character>());
            bucles.add(0);
        }
    }

    //Crea, en un grafo no dirigido, una arista que conecta al nodo1 y nodo2
    public void agregarArista(char idNodo1, char idNodo2)
    {
        int intId1 = idNodo1-'A', intId2 = idNodo2-'A';
        listaConexiones.get(intId1).add(idNodo2);
        if (idNodo1 != idNodo2) listaConexiones.get(intId2).add(idNodo1);
        else bucles.set(intId1, bucles.get(intId1)+1);
    }

    //Imprime la lista de vértices con los que cada vértice del grafo es adyacente
    public void printListaAdyacencia()
    {
        System.out.println("LISTA DE ADYACENCIA");
        int n = listaConexiones.size();
        for (int i = 0; i<n; i++)
        {
            System.out.print("Vértice "+((char)('A'+i))+": ");
            for (Character ch : listaConexiones.get(i))
                System.out.print(ch + " ");
            System.out.println("");
        }
    }

    //Imprime el grado de cada vértice en el grafo, cada uno en orden y separados por espacios
    public void printSecuenciaGrados()
    {
        System.out.println("SECUENCIA DE GRADOS");
        System.out.print("(");
        int n = listaConexiones.size();
        for (int i = 0; i<n; i++)
            System.out.print(" "+(listaConexiones.get(i).size()+bucles.get(i)));
        System.out.println(" )");
    }

    public static void main(String[] args) {
        
        Grafo grafo = new Grafo(9);
    
        //{(A, B), (A, C), (B, D), (B, E), (C, F), (C, G), (D, E), (D, H), (E, I), (F, G), (G, H), (H, I), (I, F)} 
        grafo.agregarArista('A', 'B');
        grafo.agregarArista('A', 'C');
        grafo.agregarArista('B', 'D');
        grafo.agregarArista('B', 'E');
        grafo.agregarArista('C', 'F');
        grafo.agregarArista('C', 'G');
        grafo.agregarArista('D', 'E');
        grafo.agregarArista('D', 'H');
        grafo.agregarArista('E', 'I');
        grafo.agregarArista('F', 'G');
        grafo.agregarArista('G', 'H');
        grafo.agregarArista('H', 'I');
        grafo.agregarArista('I', 'F');

        grafo.printListaAdyacencia();
        System.out.println("");
        grafo.printSecuenciaGrados();
    }

}
