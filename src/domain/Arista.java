/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.awt.Color;

/**
 *
 * @author Gerald
 */
public class Arista {
    private int peso;
    private boolean estado;
    private Color color;

    public Arista() {
    }

    public Arista(int peso) {
        this.peso = peso;
        estado = true;
        color = Color.BLACK;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }   
}
