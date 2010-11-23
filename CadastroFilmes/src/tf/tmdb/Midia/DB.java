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

public class DB extends Midia {
    private DBRegiao regiao;

    public DB(DBRegiao regiao) {
        this.regiao = regiao;
    }

    public DBRegiao getRegiao() {
        return regiao;
    }
    
    public String toString() {
        return "Blu-ray regiao: " + regiao;
    }
}
