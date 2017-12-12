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
public class ModificarModeloException extends Exception {

    /**
     * Creates a new instance of <code>ModificarModeloException</code> without
     * detail message.
     */
    public ModificarModeloException() {
    }

    /**
     * Constructs an instance of <code>ModificarModeloException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ModificarModeloException(String msg) {
        super(msg);
    }
}
