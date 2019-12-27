package serveur.forme;

import java.awt.*;
import java.lang.reflect.Field;

public class ExpertTriangle extends ExpertCOR {

	public ExpertTriangle(ExpertCOR suivant) {
		super(suivant);
	}

	/**
	 * @param requete : "Forme;Couleur,x1,y1,x2,y2,x3,y3"
	 * @param graphics2D : Graphique sur lequel il faut dessiner
	 */
	public boolean dessinerForme(String requete, Graphics2D graphics2D) {
		if (requete.startsWith("Triangle")) {
			convertArgs(requete);
			if (args.length == 2 && argi.length == 6) {
				try {
					// Graphics2D ne permet pas de dessiner des triangles, on dessine un polygone à
					// la place
					int x[] = { argi[0], argi[2], argi[4]}, y[] = {argi[1], argi[3], argi[5]};
					Field field = Color.class.getField(args[1].trim());
					Color c = (Color) field.get(null);
					graphics2D.setColor(c);
					graphics2D.fillPolygon(x, y, 3);
				} catch (IllegalAccessException | NoSuchFieldException e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}
}
