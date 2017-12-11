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
public class NoIdException extends Exception {

    /**
     * Creates a new instance of <code>NoIdException</code> without detail
     * message.
     */
    public NoIdException() {
    }

    /**
     * Constructs an instance of <code>NoIdException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public NoIdException(String msg) {
        super(msg);
    }
}
