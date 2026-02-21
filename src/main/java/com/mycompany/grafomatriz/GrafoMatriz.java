package com.mycompany.grafomatriz;
import java.util.ArrayList;

class GrafoMatriz {

    private ArrayList<String> vertices;
    private int[][] matriz;
    private int capacidad;

    public GrafoMatriz(int tamaño) {
        capacidad = tamaño;
        vertices = new ArrayList<>();
        matriz = new int[tamaño][tamaño];
    }

    public void agregarVertice(String vertice) {
        if (vertices.contains(vertice)) {
            System.out.println("El vértice ya existe.");
            return;
        }

        if (vertices.size() >= capacidad) {
            System.out.println("Capacidad máxima alcanzada.");
            return;
        }

        vertices.add(vertice);
    }

    public void agregarArista(String v1, String v2) {
        if (!vertices.contains(v1) || !vertices.contains(v2)) {
            System.out.println("Uno o ambos vértices no existen.");
            return;
        }

        int i = vertices.indexOf(v1);
        int j = vertices.indexOf(v2);

        matriz[i][j] = 1;
        matriz[j][i] = 1; // Grafo no dirigido
    }

    public void mostrarMatriz() {
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        GrafoMatriz grafo = new GrafoMatriz(4);

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");

        grafo.agregarArista("A", "B");
        grafo.agregarArista("B", "C");
        grafo.agregarArista("C", "D");
        grafo.agregarArista("D", "A");

        grafo.mostrarMatriz();
    }
}