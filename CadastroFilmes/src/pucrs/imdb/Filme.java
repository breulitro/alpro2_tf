/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pucrs.imdb;

import java.io.Serializable;

/**
 *
 * @author flash
 */
public class Filme implements Serializable, Comparable<Filme>{

    private int ano;
    private String titulo;
    private String diretor;
    private float nota;
    private int votos;
	private String url;

	public float getNota() {
		return nota;
	}

	public int getVotos() {
		return votos;
	}

	public Filme(int ano, String titulo, String diretor, String url, float nota, int votos) {
        this.ano = ano;
        this.titulo = titulo;
        this.diretor = diretor;
        this.url = url;
		this.nota = nota;
		this.votos = votos;
    }

    public int getAno() {
        return ano;
    }

    public String getUrl() {
        return url;
    }

    public String getDiretor() {
        return diretor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String toString()
    {
        String aux =  titulo + "("+ano+")" + " - " + diretor + " - " + url;
        return aux;
    }

	public int compareTo(Filme o) {
		return titulo.compareTo(o.titulo);
	}
}

