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
public class Arista {
    private int idArista;
    private int peso;

    public Arista() {
    }

    public Arista(int idArista, int peso) {
        this.idArista = idArista;
        this.peso = peso;
    }

    public int getIdArista() {
        return idArista;
    }

    public void setIdArista(int idArista) {
        this.idArista = idArista;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }   
}
