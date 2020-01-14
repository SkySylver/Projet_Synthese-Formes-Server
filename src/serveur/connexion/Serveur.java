package serveur.connexion;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import serveur.forme.ExpertCOR;
import serveur.forme.ExpertCercle;
import serveur.forme.ExpertPolygone;
import serveur.forme.ExpertSegment;
import serveur.forme.ExpertTriangle;

/**
 * Effectue la creation du serveur
 * Initialisation des Expert (Formes), evitant une allocation a travers chaque session
 * Cree un Client pour chaque nouvelle connexion
 */
public class Serveur {
	public static void main(String[] args) throws IOException {
	    Socket socket;
	    ClientDessin client;
        int nbClient = 0, portServeur = 6666;

        try {
            //Initialisation du serveur
        	ServerSocket serveur = new ServerSocket(portServeur);
            InetAddress IP = InetAddress.getLocalHost();
            int port = serveur.getLocalPort();
            System.out.println("Adresse IP du serveur: "+IP.getHostAddress()+":"+port);
            
            //Initialisation de l'expert formes + Evite creations multiples de formes pour chaque client
            ExpertCOR experts = new ExpertCercle(null);
            experts = new ExpertSegment(experts);
            experts= new ExpertTriangle(experts);
            experts = new ExpertPolygone(experts);
            
            
            while(true){
                System.out.println("Serveur en attente d'une connexion...\n");
                socket = serveur.accept();
                nbClient++;

                client = new ClientDessin(socket, experts);
                client.start();
            }
        }
        catch (IOException e) {
            System.err.println("Erreur de connexion :"+e);
        }
        
    }
}
