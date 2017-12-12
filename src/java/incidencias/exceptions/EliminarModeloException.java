/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencias.exceptions;

/**
 *
 * @author ubuntu
 */
public class EliminarModeloException extends Exception {

    /**
     * Creates a new instance of <code>EliminarModeloException</code> without
     * detail message.
     */
    public EliminarModeloException() {
    }

    /**
     * Constructs an instance of <code>EliminarModeloException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EliminarModeloException(String msg) {
        super(msg);
    }
}
