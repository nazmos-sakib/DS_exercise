/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10_11_REST.SolutionProf.REST_Server.film;

/**
 *
 * @author neuhardt
 */
public class UnknownKeyException extends RuntimeException {

    public UnknownKeyException() {
    }
 
    public UnknownKeyException(String message) {
    	super(message);
    }
    
}
