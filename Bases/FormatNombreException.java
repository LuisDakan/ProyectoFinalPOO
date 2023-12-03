/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Bases;

/**
 *
 * @author DAPG1
 */
public class FormatNombreException extends RuntimeException{

    public FormatNombreException() {
    }

    public FormatNombreException(String message) {
        super(message);
    }

    public FormatNombreException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatNombreException(Throwable cause) {
        super(cause);
    }

    
}
