package serveur.connexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientDessin extends Thread{

	Socket socket;
	BufferedReader fluxEntrant;
	
	
	public ClientDessin(Socket s) throws IOException {
		this.socket = s;
		this.fluxEntrant = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
	}
	
	
	public void run() {
		try {
			
			String args[] = fluxEntrant.readLine().split(",");
			UIDessin clientD = new UIDessin(args[0],Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]),Integer.parseInt(args[4]));
			while(true) {
				args = fluxEntrant.readLine().split(","); // redondance
				
				//Traitement du flux avec chaine formes2
				
			}
			
		} catch (IOException e) {

			System.out.println("Erreur : "+e);
		}
		
		
	}
}
