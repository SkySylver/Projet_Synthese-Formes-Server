import java.io.IOException;
import java.net.*;

public class Serveur {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		try {
		ServerSocket srv = new ServerSocket(6666);
		//InetAddress ip = InetAddress.getLocalHost();
		//int localPort = srv.getLocalPort();
		
		System.out.println("Serveur lancé\nAdresse - "+InetAddress.getLocalHost().getHostAddress()+":"+srv.getLocalPort());
		
		while(true) {
			Socket user = srv.accept();
			//New UI
			//run
			
			
		}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}