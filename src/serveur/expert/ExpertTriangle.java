package serveur.expert;

import java.awt.*;
import java.lang.reflect.Field;

public class ExpertTriangle extends ExpertCOR {

    public ExpertTriangle(ExpertCOR suivant) {super(suivant);}

    protected boolean dessinerForme(String requete, Graphics2D graphics2D) {
    	if(requete.startsWith("Triangle")){
        	String arguments[] = requete.substring(nom.length()).split(",");
	        if (arguments.length == 8) {
	            int x1 = (int) Double.parseDouble(arguments[1].trim());
	            int y1 = (int) Double.parseDouble(arguments[2].trim());
	            int x2 = (int) Double.parseDouble(arguments[3].trim());
	            int y2 = (int) Double.parseDouble(arguments[4].trim());
	            int x3 = (int) Double.parseDouble(arguments[5].trim());
	            int y3 = (int) Double.parseDouble(arguments[6].trim());
	            String couleur = arguments[7].trim();
	
	            try {
					//Graphics2D ne permet pas de dessiner des triangles, on dessine un polygone à la place
	            	int x[] = {x1, x2, x3}, y[] = {y1, y2, y3};
	                Field field = Color.class.getField(couleur);
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
