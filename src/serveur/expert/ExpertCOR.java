package serveur.expert;

import java.awt.*;

public abstract class ExpertCOR implements Expert {
    private ExpertCOR suivant;
    protected abstract boolean dessinerForme(String requete, Graphics2D graphics2D);

    public ExpertCOR() {
		suivant = null;
	}
    
    public ExpertCOR(ExpertCOR suivant) {
        this.suivant = suivant;
    }

    public boolean dessiner(String requete, Graphics2D graphics2D) {
        if (!this.dessinerForme(requete, graphics2D)) {
        	if (this.suivant != null)
        		return this.suivant.dessiner(requete, graphics2D);
        	else return false;
        }
        return true;        
    }
}