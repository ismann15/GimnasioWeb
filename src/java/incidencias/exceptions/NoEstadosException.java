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
public class NoEstadosException extends Exception {

    /**
     * Creates a new instance of <code>NoEstadosException</code> without detail
     * message.
     */
    public NoEstadosException() {
    }

    /**
     * Constructs an instance of <code>NoEstadosException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoEstadosException(String msg) {
        super(msg);
    }
}
