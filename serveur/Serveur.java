import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) throws IOException {
        int portServeurDessin = 8091;   // arbitraire. N'importe quel port libre convient
        try {
            ServerSocket serveur = new ServerSocket(portServeurDessin);
            System.out.println("serveur de dessin pret, \n details : "+serveurDessin);
            InetAddress IP = InetAddress.getLocalHost();
            int localPort = serveur.getLocalPort();
            System.out.println("Adresse IP du serveur: ["+IP.getHostAddress()+"] / Port : ["+localPort+"]");
            
            int nombreClients;
            nombreClients = 0;
            while(true){
                System.out.println("serveur de dessin en attente du prochain client");
                Socket socket = serveurDessin.accept();
                ++nombreClients;
                System.out.println("nouveau client connecten, num client = " + nombreClients);
                SessionDessin session = new SessionDessin(socket);
                session.start();
            }  
        } 
        catch (IOException e) {
            System.err.println("Le serveur n'a pu etre connecte sur le port d'ecoute ou la connexion sur ce port a ete rompue. \n Details : "+e);
        }
        
    }
}
