package serveur.forme;

import java.awt.*;

public interface Expert {
	
	/**
	 * 
	 * @param requete
	 * @param graphics2D
	 * @return
	 */
    public boolean dessiner(String requete, Graphics2D graphics2D);
    
}
