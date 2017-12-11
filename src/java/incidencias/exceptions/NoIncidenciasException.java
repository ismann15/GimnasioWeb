package incidencias.exceptions;
/**
 * 
 * @author isma
 */
public class NoIncidenciasException extends Exception {
    /**
     * Constructs an instance of <code>NoIncidenciasException</code> without specified message 
     */
    public NoIncidenciasException(){
    }
    /**
     * Constructs an instance of <code>NoIncidenciasException</code> with the specified
     * detail message.
     * @param message 
     */
    public NoIncidenciasException (String message){
        super(message);
    }
}
