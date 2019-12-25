import java.awt.*;
import java.lang.reflect.Field;

public class ExpertSegment extends ExpertCOR {

    public ExpertSegment(ExpertCOR suivant) { super(suivant);}

    protected boolean dessinerForme(String requete, Graphics2D graphics2D) {
        if(requete.startsWith("Segment")) {
        	String elems[] = requete.substring(nom.length()).split(",");
	        if (elems.length == 6) {
	            int x1 = (int) Double.parseDouble(elems[1].trim());
	            int y1 = (int) Double.parseDouble(elems[2].trim());
	            int x2 = (int) Double.parseDouble(elems[3].trim());
	            int y2 = (int) Double.parseDouble(elems[4].trim());
	            String couleur = elems[5].trim();
	            try {
	                Field champ = Color.class.getField(couleur);
	                Color color = (Color) champ.get(null);
                    graphics2D.setColor(color);
					graphics2D.draw(new Line2D.Double(x1, y1, x2, y2));
	            } catch (IllegalAccessException | NoSuchFieldException e) {
	                e.printStackTrace();
	            }
	            return true;
	        }
        }
	     return false;
    }
}
