
package Bases;

import java.io.*;

/**
 * @author DAPG1
 */

public class MyObjectOutputStream extends ObjectOutputStream{
    
    public MyObjectOutputStream(OutputStream o) throws IOException{
        super(o);
    }
    
    @Override
    public void writeStreamHeader() throws IOException{
        
    }
}
