/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tf.tmdb.Midia;

import java.io.Serializable;

/**
 *
 * @author foo
 */



public class Arquivo extends Midia {
    private int tamanho;
    private String nome;
    private String extensao;
    private CODEC codec;

    public Arquivo(int tamanho, String nome, String extensao, CODEC codec) {
        this.tamanho = tamanho;
        this.nome = nome;
        this.extensao = extensao;
        this.codec = codec;
    }

    public CODEC getCodec() {
        return codec;
    }

    public String getExtensao() {
        return extensao;
    }

    public String getNome() {
        return nome;
    }

    public int getTamanho() {
        return tamanho;
    }
    
    public String toString() {
        return nome + "." + extensao + " (" + tamanho + " MB)\nCodec: " + codec;
    }
}
