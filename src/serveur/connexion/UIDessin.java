package serveur.connexion;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;

public class UIDessin extends Frame{
	public Graphics graphics;
	
	/**
	 * 
	 * @param client
	 * @param x : 
	 * @param y
	 * @param l
	 * @param h
	 * @throws InterruptedException 
	 */
	public UIDessin(String client, int x, int y, int largeur, int hauteur) {
		super(client);

		//Adaptation à l'écran
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int le = (int) dim.getWidth();
		int he = (int) dim.getHeight();
		
		int bordGauche, bordSuperieur, l, h;
		bordGauche = Math.max(0, x);
		bordSuperieur = Math.max(0, y);
		l = Math.min(largeur, le - bordGauche);
		h = Math.min(hauteur, he - bordSuperieur);
		
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
		this.graphics = this.getBufferStrategy().getDrawGraphics();
	
	}
	
	
}
