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
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gerald
 */
public class Metodos {

    Grafo grafo = new Grafo();

    public void crearVertice(String dato, int x, int y) {
        if (dato != null) {
            Vertice nuevo = new Vertice(dato, x, y);
            if (grafo.agregarVertice(nuevo)) {
                //JOptionPane.showMessageDialog(null, "Se agrego correctamente el vertice " + dato);
            }
        }
    }

    public ArrayList mostrarListaVertices() {
        ArrayList<String> listaNombre= new ArrayList<String>();
        int cantVertice = grafo.getListaVertice().size();
        for (int i = 0; i < cantVertice; i++) {
            listaNombre.add(grafo.getListaVertice().get(i).getNombre());
        }
        return listaNombre;
    }
    
    public ArrayList vertices() {
        ArrayList<Vertice> listVertices= new ArrayList<Vertice>();
        int cantVertice = grafo.getListaVertice().size();
        for (int i = 0; i < cantVertice; i++) {
            listVertices.add(grafo.getListaVertice().get(i));
        }
        return listVertices;
    }

    public void crearArista(String nombreIni, String nombreFin, int peso) {
        Vertice ini = grafo.buscarVertice(nombreIni);
        Vertice fin = grafo.buscarVertice(nombreFin);
        Arista nueva = new Arista();
        nueva.setPeso(peso);
        nueva.setEstado(true);
        nueva.setColor(Color.BLUE);
        crearRuta(ini, fin, nueva);
    }

    public void crearRuta(Vertice ini, Vertice fin, Arista arista) {
        crearRutaRecur(ini, fin, arista);
        //crearRutaRecur(fin, ini, arista);
    }

    public void crearRutaRecur(Vertice ini, Vertice fin, Arista arista) {
        if (ini != null && fin != null) {
            ini.addVerticeAdyacente(arista, fin);
        }
    }

    public ArrayList rutasHabilitadas(String nombreBuscar) {
        Vertice buscar = grafo.buscarVertice(nombreBuscar);
        ArrayList<Ruta> listAux = null;
        if (buscar !=null) {
            if (buscar.getListaDestinos().size() !=0) {
                listAux = new ArrayList<Ruta>();
                for (Ruta ruta : buscar.getListaDestinos()) {
                    listAux.add(ruta);
                }
            }else{
            }
        }
        return listAux;

    }

    public void eliminarVertice(String nombreEliminar) {
        Vertice eliminar = grafo.buscarVertice(nombreEliminar);
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el vertice '" + nombreEliminar + "'?", "Atención", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            if (!eliminar.getListaDestinos().isEmpty()) {
                respuesta = JOptionPane.showConfirmDialog(null, "¿El vertice '" + nombreEliminar + "' cuenta con rutas a otros vertices. Siempre desea eliminarlo?", "Atención", JOptionPane.YES_NO_OPTION);
                if (respuesta == 0) {
                    for (int i = 0; i <= eliminar.getListaDestinos().size(); i++) {
                        if(i==eliminar.getListaDestinos().size()){
                            Vertice aux = eliminar.getListaDestinos().get((i-1)).getVertice();
                            eliminarArista(aux, eliminar);
                        }else{
                            Vertice aux = eliminar.getListaDestinos().get((i)).getVertice();
                            eliminarArista(aux, eliminar);
                        }                        
                    }
                    grafo.getListaVertice().remove(eliminar);
                }
                JOptionPane.showMessageDialog(null, "El vertice " + nombreEliminar + " fue eliminado correctamente");
            } else {
                grafo.getListaVertice().remove(eliminar);
            }
        }
    }

    public void eliminarArista(Vertice ini, Vertice fin) {
        boolean encontrado = true;
        if (!ini.listDestinos().isEmpty()) {
            for (int i = 0; i < ini.listDestinos().size(); i++) {
                if (ini.listDestinos().get(i).getVertice() == fin) {
                    ini.listDestinos().remove(i);
                    encontrado = true;
                    break;
                } else {
                    encontrado = false;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "El vertice " + ini.getNombre() + " no cuenta con una arista al vertice " + fin.getNombre());
            }else {                
                JOptionPane.showMessageDialog(null, "La arista entre los vertices " + ini.getNombre() + " y " + fin.getNombre()+ " fue eliminada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El vertice " + ini.getNombre() + " no cuenta con aristas");
        }
    }
    
    public void actualizarVertice(String actual, String nuevo){
        Vertice cambiar = grafo.buscarVertice(actual);
        cambiar.setNombre(nuevo);
    }
    
    public void actualizarAristaBuscar(String ini, String fin, int peso){
        Vertice iniVert = grafo.buscarVertice(ini);
        Vertice finVert = grafo.buscarVertice(fin);        
        if(actualizarArista(iniVert, finVert, peso)){
            JOptionPane.showMessageDialog(null, "La arista del vertice '"+ini+"' al vertice '"+fin+"' se actualizo correctamente.");
        }     
    }
    
    public boolean actualizarArista(Vertice ini, Vertice fin, int peso){
        boolean realizado = false;
        if(!ini.getListaDestinos().isEmpty()){
            for (int i = 0; i < ini.getListaDestinos().size(); i++) {
                if(ini.getListaDestinos().get(i).getVertice()==fin){
                    ini.getListaDestinos().get(i).getArista().setPeso(peso);
                    realizado = true;
                    break;
                }
            }
        }
        if(!fin.getListaDestinos().isEmpty()){
            for (int i = 0; i < fin.getListaDestinos().size(); i++) {
                if(fin.getListaDestinos().get(i).getVertice()==ini){
                    fin.getListaDestinos().get(i).getArista().setPeso(peso);
                    realizado = true;
                    break;
                }
            }
        }
        
        return realizado;
    }
    
    public Vertice buscarVertice(String nombre){
        Vertice aux;
        aux = grafo.buscarVertice(nombre);        
        return aux;
    }
    
    public Vertice buscarVertice(int x, int y){
        Vertice verticeAuxiliar = null;
        for(int i = 0; i < grafo.getListaVertice().size(); i++){
            int xVertice = grafo.getListaVertice().get(i).getX();
            int yVertice = grafo.getListaVertice().get(i).getY();
            if(x > xVertice && x < (xVertice + 35)){
                if(y > yVertice && y < (yVertice + 35)){
                    verticeAuxiliar = grafo.getListaVertice().get(i);
                    break;
                }
            }
        }
        return verticeAuxiliar;
    }
    
    public void iniciarAlgoritmo(String inicio, String fin){
        Vertice verticeInicio = buscarVertice(inicio);
        Vertice verticeFin = buscarVertice(fin);
        algoritmoDisjktra algoritmo = new algoritmoDisjktra(grafo);
        algoritmo.ejecutar(verticeInicio);
        algoritmo.marcarRuta(verticeFin);
    }
    
    public void reiniciar(){
        grafo.reiniciarAlgoritmo();
    }
}
