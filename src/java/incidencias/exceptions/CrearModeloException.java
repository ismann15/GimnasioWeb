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
public class CrearModeloException extends Exception {

    /**
     * Creates a new instance of <code>CrearModeloException</code> without
     * detail message.
     */
    public CrearModeloException() {
    }

    /**
     * Constructs an instance of <code>CrearModeloException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CrearModeloException(String msg) {
        super(msg);
    }
}
