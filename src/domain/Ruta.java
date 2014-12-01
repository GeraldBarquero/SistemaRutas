/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author Gerald
 */
public class Ruta {
    private Arista arista;
    private Vertice vertice;

    public Ruta() {
        this.arista= new Arista();
        this.vertice = new Vertice();
    }

    public Ruta(Arista arista, Vertice vertice) {
        this.arista = arista;
        this.vertice = vertice;
    }

    public Arista getArista() {
        return arista;
    }

    public void setArista(Arista arista) {
        this.arista = arista;
    }

    public Vertice getVertice() {
        return vertice;
    }

    public void setVertice(Vertice vertice) {
        this.vertice = vertice;
    }
}
