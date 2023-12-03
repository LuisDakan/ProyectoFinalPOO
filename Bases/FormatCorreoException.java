/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Bases;

/**
 *
 * @author DAPG1
 */
public class FormatCorreoException extends RuntimeException{

    public FormatCorreoException() {
    }

    public FormatCorreoException(String message) {
        super(message);
    }

    public FormatCorreoException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatCorreoException(Throwable cause) {
        super(cause);
    }

    
}
