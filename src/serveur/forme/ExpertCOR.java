package serveur.forme;

import java.awt.*;

public abstract class ExpertCOR implements Expert {

	
	String args[]; //Liste des arguments string(Forme, couleur, voir plus)
	int argi[]; //Reste des arguments (Coordonnees, etc...)
	
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
    
	public void convertArgs(String str) {

		String tempargs[] = str.split(",");

		if(tempargs.length==0) throw new IllegalArgumentException("La liste des arguments est vide");

		args = tempargs[0].split(";");
			
		for (int i = 1; i <= tempargs.length; i++) {
			argi[i-1] = Integer.parseInt(tempargs[i]);
		}
	}
}