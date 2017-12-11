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
public class DateFormatException extends Exception {
    /**
     * Constructs an instance of <code>DateFormatException</code> without
     * detail message.
     */
    public DateFormatException(){
    }
    /**
     * Constructs an instance of <code>DateFormatException</code> with the specified
     * detail message.
     * 
     * @param message 
     */
    public DateFormatException (String message){
        super(message);
    }
}
