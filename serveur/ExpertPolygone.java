import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class ExpertPolygone extends ExpertCOR {

    public ExpertPolygone(ExpertCOR suivant) {super(suivant);}

    protected boolean dessinerForme(String requete, Graphics2D graphics2D){
    	if (requete.startsWith("Polygone")) {
        	String arguments[] = requete.substring(nom.length()).split(",");
            ArrayList<Integer> _X = new ArrayList<Integer>();
            ArrayList<Integer> _Y = new ArrayList<Integer>();
            int i = 1;
            while(i < arguments.length - 1){
                if (i % 2 == 1) 
                    _X.add((int) Double.parseDouble(arguments[i].trim()));
                else 
                    _Y.add((int) Double.parseDouble(arguments[i].trim()));
            	i++;
            }
            String couleur = arguments[arguments.length - 1].trim();

            try {
                Field champ = Color.class.getField(couleur);
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
