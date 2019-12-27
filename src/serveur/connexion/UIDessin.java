package serveur.connexion;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

public class UIDessin extends Frame{
	public Graphics2D graphics;
	
	/**
	 * 
	 * @param args[0] : Nom du client
	 * @param args[1] : Coordonnee en abscisse de l'ecran ou va demarrer la fenetre
	 * @param args[2] : Coordonnee en ordonnee de l'ecran ou va demarrer la fenetre
	 * @param args[3] : Longeur de la fenetre
	 * @param args[4] : Hauteur de la fenetre
	 * @throws InterruptedException 
	 */
	public UIDessin(String args[]) {

		super(args[0]);

		//Adaptation à l'écran
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int le = (int) dim.getWidth();
		int he = (int) dim.getHeight();
		
		int bordGauche,bordSuperieur, h, l;
		bordGauche = Math.max(0, Integer.parseInt(args[1]));
		bordSuperieur = Math.max(0, Integer.parseInt(args[2]));
		l = Math.min(Integer.parseInt(args[3]), le - bordGauche);
		h = Math.min(Integer.parseInt(args[4]), he - bordSuperieur);
		
		this.setBounds(bordGauche, bordSuperieur, l, h);

		this.setVisible(true);
	
		//=============Active rendering=============//
		this.setIgnoreRepaint(true);
		
		int numBuffers = 1;
		this.createBufferStrategy(numBuffers);
		
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			System.out.println("Erreur Sleep :"+e);
		}
		
		//graphics correspond à l'objet sur lequel les formes seront dessinnées
		this.graphics = (Graphics2D) this.getBufferStrategy().getDrawGraphics();
	
	}	
	
}
