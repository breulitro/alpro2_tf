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
public class DVD extends Midia {
    private int qtd;
    private int regiao;

    public DVD(int qtd, int regiao) {
        this.qtd = qtd;
        this.regiao = regiao;
    }

    public int getQtd() {
        return qtd;
    }

    public int getRegiao() {
        return regiao;
    }

    public String toString() {
        return qtd + " DVD(s) regiao: " + regiao;
    }
}
