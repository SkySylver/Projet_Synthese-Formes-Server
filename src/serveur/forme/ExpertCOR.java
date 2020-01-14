package serveur.forme;

import java.awt.*;

public abstract class ExpertCOR implements Expert {

	
	String args[]; //Liste des arguments string(Forme, couleur, voir plus)
	int argi[]; //Reste des arguments (Coordonnees, etc...)
	
	private ExpertCOR suivant;
	
	/**
	 * Dessiner la forme correspondant a la requete, si existente
	 * @param requete : Format different selon la forme
	 * @param graphics2D : graphic sur lequel il faut dessiner
	 * @return Vrai si la forme est dessinee
	 */
    protected abstract boolean dessinerForme(String requete, Graphics2D graphics2D);

    /**
     * Constructeur sans successeur
     */
    public ExpertCOR() {
		suivant = null;
	}
    
    /**
     * Constructeur avec expert suivant
     * @param suivant : Expert suivant
     */
    public ExpertCOR(ExpertCOR suivant) {
        this.suivant = suivant;
    }


    

    /**
     * @param requete
     */
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
		argi = new int[tempargs.length - 1];
		for (int i = 1; i < tempargs.length ; i++) {
			argi[i-1] = Integer.parseInt(tempargs[i]);
		}
	}
}