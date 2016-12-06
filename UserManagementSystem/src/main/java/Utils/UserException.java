/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author nigelantwi-boasiako
 */
public class UserException extends Exception {
    
    public UserException(String message){
        super(message);
    }
    
     public UserException(Throwable cause){
        super(cause);
    }
     
     public UserException(String message, Throwable cause){
        super(message,cause);
    }
    
    
    
}
