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
public class IncorrectInputException extends Exception {

    /**
     * Creates a new instance of <code>IncorrectInputException</code> without
     * detail message.
     */
    public IncorrectInputException() {
    }

    /**
     * Constructs an instance of <code>IncorrectInputException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public IncorrectInputException(String msg) {
        super(msg);
    }
}
