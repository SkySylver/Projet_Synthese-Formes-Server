package serveur.forme;

import java.awt.*;
import java.awt.geom.Line2D;
import java.lang.reflect.Field;

public class ExpertSegment extends ExpertCOR {

    public ExpertSegment(ExpertCOR suivant) { super(suivant);}

    /**
     * @param requete : Schema de la chaine "Forme;Couleur,x1,y1,x2,y2"
     * @see serveur.forme.ExpertCOR#dessinerForme(java.lang.String, java.awt.Graphics2D)
     */
    public boolean dessinerForme(String requete, Graphics2D graphics2D) {
        if(requete.startsWith("Segment")) {

        	convertArgs(requete);

	        if (args.length == 2 && argi.length == 4) {

	            try {
	                Field champ = Color.class.getField(args[1]);
	                Color color = (Color) champ.get(null);
                    graphics2D.setColor(color);
					graphics2D.draw(new Line2D.Double(argi[0], argi[1], argi[2], argi[3]));
	            } catch (IllegalAccessException | NoSuchFieldException e) {
	                e.printStackTrace();
	            }
	            return true;
	        }
        }
	     return false;
    }

}
