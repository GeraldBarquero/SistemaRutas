/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import bl.Grafo;
import domain.Arista;
import domain.Vertice;
import domain.Ruta;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gerald
 */
public class Metodos {

    Grafo grafo = new Grafo();

    public void crearVertice(String dato) {
        if (dato != null) {
            Vertice nuevo = new Vertice(dato);
            if (grafo.agregarVertice(nuevo)) {
                JOptionPane.showMessageDialog(null, "Se agrego correctamente el vertice " + dato);
            }
        }
    }

    public void mostrarListaVertices() {
        int cantVertice = grafo.getListaVertice().size();
        for (int i = 0; i < cantVertice; i++) {
            System.out.println("Vertice: " + grafo.getListaVertice().get(i).getNombre());
        }
    }

    public void crearArista(String nombreIni, String nombreFin, int peso) {
        Vertice ini = grafo.buscarVertice(nombreIni);
        Vertice fin = grafo.buscarVertice(nombreFin);
        Arista nueva = new Arista();
        nueva.setPeso(peso);
        crearRuta(ini, fin, nueva);
    }

    public void crearRuta(Vertice ini, Vertice fin, Arista arista) {
        crearRutaRecur(ini, fin, arista);
        crearRutaRecur(fin, ini, arista);
    }

    public void crearRutaRecur(Vertice ini, Vertice fin, Arista arista) {
        if (ini != null && fin != null) {
            ini.addVerticeAdyacente(arista, fin);
        }
    }

    public void rutasHabilitadas(String nombreBuscar) {
        Vertice buscar = grafo.buscarVertice(nombreBuscar);
        ArrayList<Ruta> listAux = null;
        if (buscar !=null) {
            if (!buscar.getListaDestinos().isEmpty()) {
                listAux = new ArrayList<Ruta>();
                for (Ruta ruta : buscar.getListaDestinos()) {
                    listAux.add(ruta);
                }
            }
            System.out.println("Destinos disponibles desde el vertice: " + nombreBuscar);
            for (Ruta listAux1 : listAux) {
                System.out.println("Vertice Destino: " + listAux1.getVertice().getNombre() + " Peso de la Arista: " + listAux1.getArista().getPeso());
            }
        }else{
            JOptionPane.showMessageDialog(null, "No existe el vertice "+nombreBuscar+" en el grafo");
        }

    }

    public void eliminarVertice(String nombreEliminar) {
        Vertice eliminar = grafo.buscarVertice(nombreEliminar);
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el vertice '" + nombreEliminar + "'?", "Atención", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            if (!eliminar.getListaDestinos().isEmpty()) {
                respuesta = JOptionPane.showConfirmDialog(null, "¿El vertice '" + nombreEliminar + "' cuenta con rutas a otros vertices. Siempre desea eliminarlo?", "Atención", JOptionPane.YES_NO_OPTION);
                if (respuesta == 0) {
                    for (int i = 1; i <= eliminar.getListaDestinos().size(); i++) {
                        Vertice aux = eliminar.getListaDestinos().get(i).getVertice();
                        eliminarArista(aux, eliminar);
                    }
                    grafo.getListaVertice().remove(eliminar);
                }
            } else {
                grafo.getListaVertice().remove(eliminar);
            }
        }
    }

    public void eliminarArista(Vertice ini, Vertice fin) {
        boolean encontrado = true;
        if (!ini.getListaDestinos().isEmpty()) {
            for (int i = 0; i < ini.getListaDestinos().size(); i++) {
                if (ini.getListaDestinos().get(i).getVertice() == fin) {
                    ini.getListaDestinos().remove(i);
                    encontrado = true;
                    break;
                } else {
                    encontrado = false;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "El vertice " + ini.getNombre() + " no cuenta con una arista al vertice " + fin.getNombre());
            }
        } else {
            JOptionPane.showMessageDialog(null, "El vertice " + ini.getNombre() + " no cuenta con aristas");
        }

        if (!fin.getListaDestinos().isEmpty()) {
            for (int i = 0; i < fin.getListaDestinos().size(); i++) {
                if (fin.getListaDestinos().get(i).getVertice() == ini) {
                    fin.getListaDestinos().remove(i);
                    encontrado = true;
                    break;
                } else {
                    encontrado = false;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "El vertice " + fin.getNombre() + " no cuenta con una arista al vertice " + ini.getNombre());
            }
        } else {
            JOptionPane.showMessageDialog(null, "El vertice " + fin.getNombre() + " no cuenta con aristas");
        }
    }
    
    public void actualizarVertice(){
        
    }
    
    public void actualizarArista(){
        
    }

}
