/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tf.tmdb;
import pucrs.imdb.Filme;
import tf.tmdb.Midia.*;

/**
 *
 * @author foo
 */
public class FilmeTMDB extends Filme {
    private String nomePortugues;
    private String poster;
    private int tmdbId;
    private Midia midia;
	private String comentario;

    public FilmeTMDB(int ano, String titulo, String diretor, String url, String nomePortugues, String poster, int tmdbId, Midia midia, String comentario, float nota, int votos) {
        super(ano, titulo, diretor, url, nota, votos);
        this.nomePortugues = nomePortugues;
        this.poster = poster;
        this.tmdbId = tmdbId;
        this.midia = midia;
		this.comentario = comentario;
	}

	public String getComentario() {
		return comentario;
	}

	public int getTmdbId() {
		return tmdbId;
	}

	public int getImdbId() {
        return tmdbId;
    }

    public Midia getMidia() {
        return midia;
    }

    public String getNomePortugues() {
        return nomePortugues;
    }

    public String getPoster() {
        return poster;
    }

    public String toString() {
        return super.toString() + "\nMidia: " + midia;
    }
}
