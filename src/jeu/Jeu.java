package jeu;
import javax.swing.JPanel;

import joueur.Joueur;

/**
 * Interface d'engine des jeux"
 *
 */
public abstract class Jeu extends JPanel{ // classe abstraite ??
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Joueur p1 = null ; //initialistion
	public Joueur p2 = null ;
	
	public Jeu(Joueur p1, Joueur p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	// stocker les pieces de depart
	/**
	 * Lancer le jeu
	 */
	public abstract void commencerJeu() ;
	
	/**
	 * Terminer le jeu
	 * @throws InterruptedException 
	 */
	public abstract void finirJeu() throws InterruptedException;
	
	/**
	 * Annocer le gagnant
	 */
	public abstract void revelerGagnant() ;

}
