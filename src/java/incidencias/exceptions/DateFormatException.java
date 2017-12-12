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
public class DateFormatException extends Exception {

    /**
     * Creates a new instance of <code>DateFormatException</code> without detail
     * message.
     */
    public DateFormatException() {
    }

    /**
     * Constructs an instance of <code>DateFormatException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DateFormatException(String msg) {
        super(msg);
    }
}
