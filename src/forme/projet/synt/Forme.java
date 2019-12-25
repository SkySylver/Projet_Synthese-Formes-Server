package forme.projet.synt;

public abstract class Forme {

	private String couleur;
	
	abstract void draw();

	
	
	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
}
