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
public class ModificarMaquinaException extends Exception {

    /**
     * Creates a new instance of <code>ModificarMaquinaException</code> without
     * detail message.
     */
    public ModificarMaquinaException() {
    }

    /**
     * Constructs an instance of <code>ModificarMaquinaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ModificarMaquinaException(String msg) {
        super(msg);
    }
}
