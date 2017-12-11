/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.exceptions;

/**
 *
 * @author isma
 */
public class NoMaquinasException extends Exception {

    /**
     * Creates a new instance of <code>NoMaquinasException</code> without detail
     * message.
     */
    public NoMaquinasException() {
    }

    /**
     * Constructs an instance of <code>NoMaquinasException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoMaquinasException(String msg) {
        super(msg);
    }
}
