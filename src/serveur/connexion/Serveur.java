package serveur.connexion;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import serveur.forme.ExpertCercle;
import serveur.forme.ExpertPolygone;
import serveur.forme.ExpertSegment;
import serveur.forme.ExpertTriangle;

public class Serveur {
    public static void main(String[] args) throws IOException {
        int nbClient = 0, portServeur = 6666;   // arbitraire. N'importe quel port libre convient
        
        try {
            //Initialisation du serveur
        	ServerSocket serveur = new ServerSocket(portServeur);
            InetAddress IP = InetAddress.getLocalHost();
            int port = serveur.getLocalPort();
            System.out.println("Adresse IP du serveur: "+IP.getHostAddress()+":"+port);
            
            //Initialisation de l'expert formes + Evite creations multiples de formes pour chaque client
            ExpertCercle cercle = new ExpertCercle(null);
            ExpertSegment segment = new ExpertSegment(cercle);
            ExpertTriangle triangle = new ExpertTriangle(segment);
            ExpertPolygone expert = new ExpertPolygone(triangle);
            
            
            while(true){
                System.out.println("Serveur en attente d'une connexion...\n");
                Socket socket = serveur.accept();
                nbClient++;

                ClientDessin client = new ClientDessin(socket, expert);
                client.start();
            }
        }
        catch (IOException e) {
            System.err.println("Erreur de connexion :"+e);
        }
        
    }
}
