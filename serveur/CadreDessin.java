import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Dimension;

/**
 * destine a recevoir des dessins realises en Active-Rendering
 * 
 * paint() est desactivee
 * 
 * pourrait etre amelioree par l'utilisation d'un Canvas : Panel specialise pour le dessin
 * pourrait etre amelioree par l'utilisation de coordonnees relatives plutot que des coordonnees en pixels
 * */
public class CadreDessin extends Frame{
  public Graphics graphics;      // pour dessiner sur this

  /**
   * @param titre : titre de la fenetre
   * @param ox : abscisse souhaite pour le bord gauche de la fenetre
   * @param oy : ordonnee souhaitee pour le bord superieur de la fenetre
   * @param largeur : largeur souhaitee pour la fenetre
   * @param hauteur : hauteur souhaitee pour la fenetre
   * 
   * l'unite pour ces 4 parametres est le pixel 
   * 
   * */
  public CadreDessin(String titre, int ox, int oy, int largeur, int hauteur) throws InterruptedException{
    super(titre);
    // ------------------ parametrage de la position et des dimensions de la fenetre --------------------------

    Toolkit tk = Toolkit.getDefaultToolkit();

    int le, he; // largeur ecran, hauteur ecran

    Dimension dim = tk.getScreenSize(); // dimensions de l'ecran

    le = (int) dim.getWidth();
    he = (int) dim.getHeight();

    int bordGauche, bordSuperieur, l, h ;

    bordGauche = Math.max(0, ox);
    bordSuperieur = Math.max(0, oy);
    l = Math.min(largeur, le - bordGauche);
    h = Math.min(hauteur, he - bordSuperieur);
    this.setBounds(bordGauche, bordSuperieur, l, h);

    //this.setBounds(ox, oy, largeur, hauteur);

    this.setVisible(true);

    //------------------------- initialisation de l'active rendering -----------------------

    this.setIgnoreRepaint(true);

    int nombreBuffers = 1;
    this.createBufferStrategy(nombreBuffers);
    Thread.sleep(50);   // il faut attendre un minimum de 50 ms pour que le buffer soit operationnel
    this.graphics = this.getBufferStrategy().getDrawGraphics();
  }
}
