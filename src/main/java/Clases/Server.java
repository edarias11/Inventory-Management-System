package Clases;

import java.io.IOException;
import java.net.ServerSocket;


public class Server {
    
      public static void main(String[] args) {
        try {
            System.out.println("El servidor esta corriendo");
            ServerSocket server = new ServerSocket(9090);
            
            while (true) {                
                ServidorAyuda sh = new ServidorAyuda(server.accept());
                sh.start();
            }
            
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
  
}
