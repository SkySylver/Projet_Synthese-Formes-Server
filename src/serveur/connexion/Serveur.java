package serveur.connexion;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) throws IOException {
        int nbClient = 0, portServeur = 6666;   // arbitraire. N'importe quel port libre convient
        
        try {
            ServerSocket serveur = new ServerSocket(portServeur);
            
            
            InetAddress IP = InetAddress.getLocalHost();
            int port = serveur.getLocalPort();
            
            System.out.println("Adresse IP du serveur: "+IP.getHostAddress()+":"+port);
            
            
            while(true){
                System.out.println("Serveur en attente d'une connexion...\n");
                Socket socket = serveur.accept();
                nbClient++;

//                System.out.println("");
                ClientDessin client = new ClientDessin(socket);
                client.start();
            }
        }
        catch (IOException e) {
            System.err.println("Erreur de connexion :"+e);
        }
        
    }
}
