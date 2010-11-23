/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pucrs.imdb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author flash
 */
public class ListaFilmes implements Iterable<Filme> {

    private List<Filme> lista;

    public ListaFilmes() {
        this.lista = new ArrayList<Filme>();
    }

    public void addFilme(Filme f) {
        lista.add(f);
    }

    public List<String> getListaTitulos() {
    	ArrayList<String> list = new ArrayList<String>();
    	for (Filme f : lista ) {
    		if (!list.contains(f.getTitulo()))
    	       list.add(f.getTitulo());	
       }
    	return list;
    }
    
    // Acesso à lista de filmes

    public int getTotalFilmes() {
        return lista.size();
    }

    public Filme getFilmePosicao(int pos) {
        return lista.get(pos);
    }

    // Métodos de ordenação

    public void ordenaFilme() {
        Collections.sort(lista, getComparadorFilme());
    }

    // Comparators usados pelos métodos acima (privados)

    private Comparator<Filme> getComparadorFilme() {
        return new Comparator<Filme>() {

            public int compare(Filme o1, Filme o2) {
                return o1.getTitulo().compareTo(o2.getTitulo());
            }
        };
    }

    public Iterator<Filme> iterator() {
        return new Iterator<Filme>() {

            private int pos = 0;
            
            public boolean hasNext() {
                return (pos < lista.size());
            }

            public Filme next() {
                if(pos >= lista.size())
                    return null;
                return lista.get(pos++);
            }

            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }
}

