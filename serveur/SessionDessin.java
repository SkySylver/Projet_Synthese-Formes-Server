
/**
 * represente la session de dessin entreprise par un client distant.
 * 
 * Effectue principalement les operations suivantes :
 * 
 * ouvre une fenetre awt (Frame) pour dessiner dessus (les coordonnees de la fenetre sont indiquees par le client).
 * puis execute sur la fenetre ouverte tous les ordres de trace du client distant.
 * 
 * fonctionne dans un thread separe du thread principal.
 * 
 * */
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketException;


public class SessionDessin extends Thread
{
Socket socket;                  // pour dialoguer avec le client distant. Peut-on se passer de cet attribut ?
BufferedReader fluxEntrant;     // flux entrant pour recevoir les requetes du client

/**
 * cree la session de dessin avec le client distant connecte sur socket
 * @throws IOException 
 * 
 * */
public SessionDessin(Socket socket) throws IOException{
    this.socket = socket;
    this.fluxEntrant = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
}

@Override
public void run(){
    String requete;

    try{
        requete = this.fluxEntrant.readLine();  // lit le titre et les 4 coordonnees Ox, Oy, largeur et hauteur de la fenetre, les arguments sont separes par des ","
        System.out.println("requete recue : " + requete);
        String arguments[] = requete.split(",");            // redondance de code e eliminer
        
        String titre;
        int Ox, Oy, largeur, hauteur;
        
        titre = arguments[0].trim();
        Ox = Integer.parseInt(arguments[1].trim());         // redondance de code e eliminer pour 8 lignes !!!! cf. lignes suivantes
        Oy = Integer.parseInt(arguments[2].trim());
        largeur = Integer.parseInt(arguments[3].trim());
        hauteur = Integer.parseInt(arguments[4].trim());
        
        CadreDessin cadreDessin = new CadreDessin(titre,Ox,Oy,largeur,hauteur);
        
        while (true){
            requete = this.fluxEntrant.readLine();  // lit l'instruction de trace et les 4 parametres entiers du trace, les arguments sont separes par des ","
            System.out.println("requete recue : " + requete);
            if(!requete.trim().equals("")) {
                System.out.println("Re�u : " + requete);
                Expert expert = null;
                expert = new ExpertSegment(expert);
                expert = new ExpertCercle(expert);
                expert = new ExpertTriangle(expert);
                expert = new ExpertPolygone(expert);
                Polygone.dessiner(requete, cadreDessin.graphics2D);
            }
            cadreDessin.getBufferStrategy().show();
        } // while
    }

    catch (SocketException e)
        {
        System.out.println("session de dessin terminee par le client");
        }
    catch (NumberFormatException e)
        {
        e.printStackTrace();
        }
    catch (IOException e)
        {
        e.printStackTrace();
        }
    catch (InterruptedException e)
        {
        e.printStackTrace();
        }
    }
}