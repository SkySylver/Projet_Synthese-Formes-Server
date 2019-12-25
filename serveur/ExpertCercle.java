import java.awt.*;
import java.lang.reflect.Field;

public class ExpertCercle extends ExpertCOR {

    public ExpertCercle(ExpertCOR suivant) { super(suivant);}
    
    protected boolean dessinerForme(String requete, Graphics2D graphics2D) {
    	if (requete.startsWith("Cercle")) {
    		String arguments[] = requete.substring(nom.length()).split(",");
        	if(arguments.length == 6) {
	            int x1 = (int) Double.parseDouble(arguments[1].trim());
	            int y1 = (int) Double.parseDouble(arguments[2].trim());
	            int x2 = (int) Double.parseDouble(arguments[3].trim());
	            int y2 = (int) Double.parseDouble(arguments[4].trim());
                String couleur = arguments[5].trim();

	            try {
	                Field champ = Color.class.getField(couleur);
	                Color color = (Color)champ.get(null);
	                graphics2D.setColor(color);
	                graphics2D.fillOval(x1, y1, x2, y2);	
	                return true;
	            } catch (NoSuchFieldException | IllegalAccessException e) {
	                e.printStackTrace();
	            }
        	}
        }

        return false;
    }
}