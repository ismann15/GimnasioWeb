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
public class CrearMaquinaException extends Exception {

    /**
     * Creates a new instance of <code>CrearMaquinaException</code> without
     * detail message.
     */
    public CrearMaquinaException() {
    }

    /**
     * Constructs an instance of <code>CrearMaquinaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CrearMaquinaException(String msg) {
        super(msg);
    }
}
