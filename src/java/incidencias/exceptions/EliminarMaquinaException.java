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
public class EliminarMaquinaException extends Exception {

    /**
     * Creates a new instance of <code>EliminarMaquinaException</code> without
     * detail message.
     */
    public EliminarMaquinaException() {
    }

    /**
     * Constructs an instance of <code>EliminarMaquinaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EliminarMaquinaException(String msg) {
        super(msg);
    }
}
