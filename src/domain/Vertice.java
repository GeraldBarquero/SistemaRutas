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
public class Vertice {
    private String Nombre;  //propiedad que hace referencia al nombre de cada vertice

    public Vertice() {
    }

    public Vertice(String Nombre) {
        this.Nombre = Nombre;
    }   

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
