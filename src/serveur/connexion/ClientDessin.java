package serveur.connexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import serveur.forme.ExpertCOR;
import serveur.forme.ExpertPolygone;

/**
 * Client/Thread cree lors d'une nouvelle connexion
 *
 */
public class ClientDessin extends Thread {
	
	Socket socket;
	BufferedReader fluxEntrant;
	ExpertCOR formes;
	

	/**
	 * 
	 * @param s : socket / connexion lie au client
	 * @param expert : Chaine de responsabilite de Formes 
	 * @throws IOException
	 */
	public ClientDessin(Socket s, ExpertCOR expert) throws IOException {
		this.formes = expert;
		this.socket = s;
		this.fluxEntrant = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		System.out.println("Client demarré");
	}

	/**
	 * Execute juste apres la creation du client
	 * Cree une interface/fenetre de dessin
	 * Dessine chaque requete
	 * 
	 * Le format de la 1e requete doit respecter le format : "NomClient,x1,y1,Longueur,Largeur"
	 * La fenetre s'adaptera si format invalide
	 */
	public void run() {
		try {
			// Creation d'une nouvelle fenetre
			UIDessin client = new UIDessin(fluxEntrant.readLine().split(","));

			while (true) {
				String s =fluxEntrant.readLine();
				System.out.println(s);
				formes.dessiner(s, client.graphics);
				// Traitement du flux avec chaine formes2
			}

		} catch (IOException e) {

			System.out.println("Erreur : " + e);
		}

	}

}
