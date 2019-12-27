package serveur.connexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import serveur.forme.ExpertPolygone;
import serveur.forme.ExpertTriangle;

/**
 * Client/Thread cree lors d'une nouvelle connexion
 *
 */
public class ClientDessin extends Thread {

	
	Socket socket;
	BufferedReader fluxEntrant;
	ExpertPolygone formes;
	

	public ClientDessin(Socket s, ExpertPolygone expert) throws IOException {
		this.formes = expert;
		this.socket = s;
		this.fluxEntrant = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
	}

	public void run() {
		try {
			// Creation d'une nouvelle fenetre
			UIDessin client = new UIDessin(fluxEntrant.readLine().split(","));

			while (true) {

				formes.dessiner(fluxEntrant.readLine(), client.graphics);
				// Traitement du flux avec chaine formes2
			}

		} catch (IOException e) {

			System.out.println("Erreur : " + e);
		}

	}

}
