package serveur.forme;

import java.awt.*;
import java.lang.reflect.Field;

public class ExpertCercle extends ExpertCOR {

	/**
	 * args[0] : Forme args[1] : Couleur
	 * 
	 * argi[0] : x1 argi[1] : x2 argi[2] : y1 argi[3] : y2
	 */

	/**
	 * 
	 * @param suivant : Expert suivant
	 */
	public ExpertCercle(ExpertCOR suivant) {
		super(suivant);
	}

	protected boolean dessinerForme(String requete, Graphics2D graphics2D) {
		if (requete.startsWith("Cercle")) {
			convertArgs(requete);

			if (argi.length >= 4) {
				String couleur = args[1].trim();

				try {
					
					Field champ = Color.class.getField(couleur);
					Color color = (Color) champ.get(null);
					graphics2D.setColor(color);
					graphics2D.fillOval(argi[0], argi[1], argi[2], argi[3]);
					return true;
				} catch (NoSuchFieldException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}

		}
		return false;

	}
}