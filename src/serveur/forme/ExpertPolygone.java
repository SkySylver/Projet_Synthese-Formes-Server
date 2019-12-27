package serveur.forme;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class ExpertPolygone extends ExpertCOR {

	public ExpertPolygone(ExpertCOR suivant) {
		super(suivant);
	}

	protected boolean dessinerForme(String requete, Graphics2D graphics2D) {
		if (requete.startsWith("Polygone")) {
			convertArgs(requete);
			
			ArrayList<Integer> _X = new ArrayList<Integer>();
			ArrayList<Integer> _Y = new ArrayList<Integer>();
			int i = 0;
			while (i < argi.length) {
				if (i % 2 == 0)
					_X.add(argi[i]);
				else
					_Y.add(argi[i]);
				i++;
			}

			try {
				Field champ = Color.class.getField(args[1].trim());
				Color color = (Color) champ.get(null);
				graphics2D.setColor(color);
				int x[] = Arrays.stream(_X.toArray(new Integer[_X.size()])).mapToInt(Integer::intValue).toArray();
				int y[] = Arrays.stream(_Y.toArray(new Integer[_Y.size()])).mapToInt(Integer::intValue).toArray();
				graphics2D.fillPolygon(x, y, x.length);

			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
}
