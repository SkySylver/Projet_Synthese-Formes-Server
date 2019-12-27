package serveur.forme;

import java.awt.*;

public interface Expert {
	
	/**
	 * @param requete : Doit correspondre au regex selon chaque forme, Format de base "String;String;...,int,int,int,..."
	 * @param graphics2D : Graphic sur lequel il faut dessiner
	 * @return Vrai s'il est possible de dessiner la forme de l'expert
	 */
    public boolean dessiner(String requete, Graphics2D graphics2D);
    
}
