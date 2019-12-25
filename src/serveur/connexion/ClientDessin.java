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
		String flux;
		try {
			flux = this.fluxEntrant.readLine();
			String args[] = flux.split("-");
			
			
			
			
		} catch (IOException e) {

			System.out.println("Erreur : "+e);
		}
		
		
	}
}
