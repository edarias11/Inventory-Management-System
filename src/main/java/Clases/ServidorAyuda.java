package Clases;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashSet;


public class ServidorAyuda extends Thread {
    
    
    private Socket socket;
   
    

    public ServidorAyuda(Socket socket) {
        this.socket = socket;
    }

    
}
