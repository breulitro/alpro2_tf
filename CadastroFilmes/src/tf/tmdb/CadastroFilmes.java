/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tf.tmdb;

import java.util.Iterator;
import java.util.Vector;
import pucrs.bst.BinarySearchTree;
import pucrs.imdb.Filme;

/**
 *
 * @author foo
 */
public class CadastroFilmes {

	BinarySearchTree<Filme> cad;
	String file;

	public CadastroFilmes() {
		file = "CadastroFilmes.o";
		cad = new BinarySearchTree<Filme>();
		deserialize();
	}

	public CadastroFilmes(String file) {
		this.file = file;
		cad = new BinarySearchTree<Filme>();
		deserialize();
	}

	protected void finalize() throws Throwable {
		System.out.println("Isso Funcona?");
		serialize();
		super.finalize();
	}

	public void deserialize() {
		cad.deserialize(file);
	}

	public void serialize() {		
		cad.serialize(file);
	}	

	public void setFile(String file) {
		this.file = file;
	}

	public void add(FilmeTMDB f) {
		cad.add(f);
	}

	public String toString() {
		return cad.toString();
	}

	public Vector<String> toArray() {
		//List<String> ret = new ArrayList();
		Vector<String> ret = new Vector<String>();
		Iterator i = cad.getIteratorCentral();
		while (i.hasNext()) {
			ret.add(((FilmeTMDB)i.next()).getTitulo());
		}
		/*for (String s:ret) {
			System.out.println("TOARRAY - " + s);
		}
		//return (String[]) ret.toString();
		System.out.println("Vai Cavalo");
		for (Object s : ret.toArray()) {
			System.out.println(s);
		}*/
		return ret;
	}

	public FilmeTMDB findByTitulo(String selectedValue) {
		FilmeTMDB f = new FilmeTMDB(0, selectedValue, null, null, null, null, 0, null, null, 0, 0);
		return (FilmeTMDB) cad.find(f);
	}

	public void remove(FilmeTMDB findByTitulo) {
		cad.remove(findByTitulo);
	}
}
